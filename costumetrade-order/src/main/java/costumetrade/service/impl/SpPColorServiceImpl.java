package costumetrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.domain.SpPColor;
import costumetrade.domain.SpPColorKey;
import costumetrade.mapper.SpPColorMapper;
import costumetrade.service.SpPColorService;

@Transactional
@Service
public class SpPColorServiceImpl implements SpPColorService{
	@Autowired
	private SpPColorMapper spPColorMapper;
	
	public List<SpPColor> getSpPColors(int cropId) {

		return spPColorMapper.getSpPColors(cropId);
	}
	public int saveSpPColor(SpPColor spPColor) {
		int save = 0;
		//查询对应ID的员工是否存在，存在的话进行update 不存在save
		SpPColorKey spPColorKey = new SpPColorKey();
		if(spPColor.getId() != null && spPColor.getCorpid() != null){
			spPColorKey.setId(spPColor.getId());
			spPColorKey.setCorpid(spPColor.getCorpid());

			SpPColor getColor = spPColorMapper.selectByPrimaryKey(spPColorKey);
			if(getColor != null){
				save = spPColorMapper.updateByPrimaryKeySelective(spPColor);
			}else {
				save = spPColorMapper.insert(spPColor) ;
			}	
		}
			
		 
		
		return save;
		
		 
	}
	public int deleteSpPColor(SpPColorKey spPColorKey) {
	
		return spPColorMapper.deleteByPrimaryKey(spPColorKey);
	}
	
	

}
