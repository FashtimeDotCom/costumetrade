package costumetrade.service;

import java.util.List;

import costumetrade.domain.SpPrinterInfo;
import costumetrade.domain.SpPrinterInfoKey;


public interface SpPrinterInfoService {
	/*
	 * 获取该分店下的打印机
	 * 
	 * */
	public SpPrinterInfo getSpPrinterInfos(SpPrinterInfoKey spPrinterInfoKey);
	/**
	 * 保存打印机信息
	 * 
	 * */
	public int saveSpPrinterInfo(SpPrinterInfo spPrinterInfo);
	
	/**
	 * 删除打印机信息
	 * 
	 * */
	public int deleteSpPrinterInfo(SpPrinterInfoKey spPrinterInfoKey);
}
