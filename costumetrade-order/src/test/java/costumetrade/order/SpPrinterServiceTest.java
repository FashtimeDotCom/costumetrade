package costumetrade.order;

import java.util.Date;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.common.util.HttpPostUtil;
import costumetrade.domain.SpPrinterInfo;
import costumetrade.domain.SpPrinterInfoKey;
import costumetrade.service.SpPrinterInfoService;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext_test.xml"})
public class SpPrinterServiceTest {

	@Autowired
	private SpPrinterInfoService spPrinterInfoService;



	@Test
	public void insertSpPrinterInfo(){
		
		SpPrinterInfo spPrinterInfo = new SpPrinterInfo();
		spPrinterInfo.setCorpid(100001);
		spPrinterInfo.setSubid("001");
		spPrinterInfo.setMbid("1657451465DB");;
		spPrinterInfo.setMbimage("c bxjhkvfyreiwhncsdfgr0546");
		spPrinterInfo.setMbuser(0001);
		spPrinterInfoService.saveSpPrinterInfo(spPrinterInfo);

	}
	@Test
	public void deletePrinterInfo(){
		
		SpPrinterInfoKey spPrinterInfo = new SpPrinterInfoKey();
		spPrinterInfo.setCorpid(100001);
		spPrinterInfo.setSubid("001");
		spPrinterInfoService.deleteSpPrinterInfo(spPrinterInfo);

	}
	@Test
	public void getPrinterInfo(){
		SpPrinterInfoKey spPrinterInfo = new SpPrinterInfoKey();
		spPrinterInfo.setCorpid(100001);
		spPrinterInfo.setSubid("001");
		//System.out.println(spPrinterInfoService.getSpPrinterInfos(spPrinterInfo));
		
		System.out.println(HttpPostUtil.sendPostRequestJSON("http://localhost:8080/costumetrade-web/printer/getPrinter", JSONObject.fromObject(spPrinterInfo)));

	}
	
}
