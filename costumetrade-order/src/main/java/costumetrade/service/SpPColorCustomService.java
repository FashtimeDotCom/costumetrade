package costumetrade.service;

import java.util.List;

import costumetrade.domain.SpPColorCustom;
import costumetrade.domain.SpPColorCustomKey;


public interface SpPColorCustomService {
	/*
	 * 获取所有颜色组
	 * 
	 * */
	public List<SpPColorCustom> getSpPColorCustoms(int cropId);
	/**
	 * 保存颜色组信息
	 * 
	 * */
	public int saveSpPColorCustom(SpPColorCustom spPColorCustom);
	
	/**
	 * 删除颜色组信息
	 * 
	 * */
	public int deleteSpPColorCustom(SpPColorCustomKey spPColorCustomKey);
}
