package costumetrade.service;

import java.util.List;

import costumetrade.domain.SpPColor;
import costumetrade.domain.SpPColorKey;


public interface SpPColorService {
	/*
	 * 获取所有颜色
	 * 
	 * */
	public List<SpPColor> getSpPColors(int cropId);
	/**
	 * 保存颜色信息
	 * 
	 * */
	public int saveSpPColor(SpPColor spPColor);
	
	/**
	 * 删除颜色信息
	 * 
	 * */
	public int deleteSpPColor(SpPColorKey spPColorKey);
}
