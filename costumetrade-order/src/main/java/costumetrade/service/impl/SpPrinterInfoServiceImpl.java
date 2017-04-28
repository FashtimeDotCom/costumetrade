package costumetrade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.domain.SpPrinterInfo;
import costumetrade.domain.SpPrinterInfoKey;
import costumetrade.mapper.SpPrinterInfoMapper;
import costumetrade.service.SpPrinterInfoService;

@Transactional
@Service
public class SpPrinterInfoServiceImpl implements SpPrinterInfoService{
	@Autowired
	private SpPrinterInfoMapper spPrinterInfoMapper;
	
	public SpPrinterInfo getSpPrinterInfos(SpPrinterInfoKey spPrinterInfoKey) {

		return spPrinterInfoMapper.selectByPrimaryKey(spPrinterInfoKey);
	}
	public int saveSpPrinterInfo(SpPrinterInfo spPrinterInfo) {
		int save = 0;
		//查询对应ID的员工是否存在，存在的话进行update 不存在save
		SpPrinterInfoKey spPrinterInfoKey = new SpPrinterInfoKey();
		if(spPrinterInfo.getSubid() != null && spPrinterInfo.getCorpid() != null){
			spPrinterInfoKey.setSubid(spPrinterInfo.getSubid());
			spPrinterInfoKey.setCorpid(spPrinterInfo.getCorpid());

			SpPrinterInfo getColor = spPrinterInfoMapper.selectByPrimaryKey(spPrinterInfoKey);
			if(getColor != null){
				save = spPrinterInfoMapper.updateByPrimaryKeySelective(spPrinterInfo);
			}else {
				save = spPrinterInfoMapper.insert(spPrinterInfo) ;
			}	
		}
			
		 
		
		return save;
		
		 
	}
	public int deleteSpPrinterInfo(SpPrinterInfoKey spPrinterInfoKey) {
	
		return spPrinterInfoMapper.deleteByPrimaryKey(spPrinterInfoKey);
	}
	
	

}
