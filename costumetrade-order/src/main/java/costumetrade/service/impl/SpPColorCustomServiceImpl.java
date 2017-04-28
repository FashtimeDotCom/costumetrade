package costumetrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.domain.SpPColorCustom;
import costumetrade.domain.SpPColorCustomKey;
import costumetrade.mapper.SpPColorCustomMapper;
import costumetrade.service.SpPColorCustomService;

@Transactional
@Service
public class SpPColorCustomServiceImpl implements SpPColorCustomService{
	@Autowired
	private SpPColorCustomMapper spPColorCustomMapper;
	
	public List<SpPColorCustom> getSpPColorCustoms(int cropId) {

		return spPColorCustomMapper.getSpPColorCustoms(cropId);
	}
	public int saveSpPColorCustom(SpPColorCustom spPColorCustom) {
		int save = 0;
		//查询对应ID是否存在，存在的话进行update 不存在save
		SpPColorCustomKey spPColorCustomKey = new SpPColorCustomKey();
		if(spPColorCustom.getId() != null && spPColorCustom.getCorpid() != null){
			spPColorCustomKey.setId(spPColorCustom.getId());
			spPColorCustomKey.setCorpid(spPColorCustom.getCorpid());

			SpPColorCustom getColor = spPColorCustomMapper.selectByPrimaryKey(spPColorCustomKey);
			if(getColor != null){
				save = spPColorCustomMapper.updateByPrimaryKeySelective(spPColorCustom);
			}else {
				save = spPColorCustomMapper.insert(spPColorCustom) ;
			}	
		}
		return save;
		
		 
	}
	public int deleteSpPColorCustom(SpPColorCustomKey spPColorCustomKey) {
	
		return spPColorCustomMapper.deleteByPrimaryKey(spPColorCustomKey);
	}

}
