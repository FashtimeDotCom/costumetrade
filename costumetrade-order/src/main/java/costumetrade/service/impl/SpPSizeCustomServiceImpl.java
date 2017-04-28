package costumetrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.domain.SpPSizeCustom;
import costumetrade.domain.SpPSizeCustomKey;
import costumetrade.mapper.SpPSizeCustomMapper;
import costumetrade.service.SpPSizeCustomService;

@Transactional
@Service
public class SpPSizeCustomServiceImpl implements SpPSizeCustomService{
	@Autowired
	private SpPSizeCustomMapper spPSizeCustomMapper;
	
	public List<SpPSizeCustom> getSpPSizeCustoms(int cropId) {

		return spPSizeCustomMapper.getSpPSizeCustoms(cropId);
	}
	public int saveSpPSizeCustom(SpPSizeCustom spPSizeCustom) {
		int save = 0;
		//查询对应ID的是否存在，存在的话进行update 不存在save
		SpPSizeCustomKey spPSizeCustomKey = new SpPSizeCustomKey();
		if(spPSizeCustom.getId() != null && spPSizeCustom.getCorpid() != null){
			spPSizeCustomKey.setId(spPSizeCustom.getId());
			spPSizeCustomKey.setCorpid(spPSizeCustom.getCorpid());

			SpPSizeCustom getSize = spPSizeCustomMapper.selectByPrimaryKey(spPSizeCustomKey);
			if(getSize != null){
				save = spPSizeCustomMapper.updateByPrimaryKeySelective(spPSizeCustom);
			}else {
				save = spPSizeCustomMapper.insert(spPSizeCustom) ;
			}
		}
		 
		
		return save;
		
		 
	}
	public int deleteSpPSizeCustom(SpPSizeCustomKey spPSizeCustomKey) {
	
		return spPSizeCustomMapper.deleteByPrimaryKey(spPSizeCustomKey);
	}
	
	

}
