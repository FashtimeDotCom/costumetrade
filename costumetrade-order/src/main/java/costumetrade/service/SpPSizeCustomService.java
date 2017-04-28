package costumetrade.service;

import java.util.List;

import costumetrade.domain.SpPSizeCustom;
import costumetrade.domain.SpPSizeCustomKey;


public interface SpPSizeCustomService {
	/**
	 * 获取所有尺码组
	 * 
	 * */
	public List<SpPSizeCustom> getSpPSizeCustoms(int cropId);
	/**
	 * 保存尺码组信息
	 * 
	 * */
	public int saveSpPSizeCustom(SpPSizeCustom spPSizeCustom);
	
	/**
	 * 删除尺码组信息
	 * 
	 * */
	public int deleteSpPSizeCustom(SpPSizeCustomKey spPSizeCustomKey);
}
