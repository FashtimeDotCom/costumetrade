package costumetrade.service;

import java.util.List;

import costumetrade.domain.SpPCate;
import costumetrade.domain.SpPCateKey;


public interface SpPCateService {
	/*
	 * 获取商品种类
	 * 
	 * */
	public List<SpPCate> getSpPCates(int cropId);
	/**
	 * 保存商品种类
	 * 
	 * */
	public int saveSpPCate(SpPCate spPCate);
	
	/**
	 * 删除商品种类
	 * 
	 * */
	public int deleteSpPCate(SpPCateKey spPCateKey);
}
