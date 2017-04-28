package costumetrade.order;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.domain.SpPSize;
import costumetrade.domain.SpPSizeCustom;
import costumetrade.domain.SpPSizeCustomKey;
import costumetrade.domain.SpPSizeKey;
import costumetrade.service.SpPSizeCustomService;
import costumetrade.service.SpPSizeService;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext_test.xml"})
public class SpSizeServiceTest {

	@Autowired
	private SpPSizeService spPSizeService;
	@Autowired
	private SpPSizeCustomService spPSizeCustomService;



	@Test
	public void insertSpPSize(){
		
		SpPSize spPSize = new SpPSize();
		spPSize.setCorpid(100001);
		spPSize.setId("S");
		spPSize.setCreateTime(new Date());
		spPSize.setBarcode("s00001");
		spPSize.setModifyTime(new Date());
		spPSizeService.saveSpPSize(spPSize);

	}
	@Test
	public void deletePSize(){
		
		SpPSizeKey spPSize = new SpPSizeKey();
		spPSize.setCorpid(100001);
		spPSize.setId("S");
		spPSizeService.deleteSpPSize(spPSize);

	}
	@Test
	public void getPSize(){
		int corpId = 100001;
		System.out.println(spPSizeService.getSpPSizes(corpId).toString());

	}
	
	
	@Test
	public void insertSpPSizeCustom(){
		
		SpPSizeCustom spPSizeCustom = new SpPSizeCustom();
		spPSizeCustom.setCorpid(100001);
		spPSizeCustom.setId("自定义1");
		spPSizeCustom.setCreateTime(new Date());
		spPSizeCustom.setValue("S,M,L,XL");
		spPSizeCustom.setModifyTime(new Date());
		spPSizeCustomService.saveSpPSizeCustom(spPSizeCustom);

	}
	@Test
	public void deletePSizeCustom(){
		
		SpPSizeCustomKey spPSizeCustom = new SpPSizeCustomKey();
		spPSizeCustom.setCorpid(100001);
		spPSizeCustom.setId("自定义1");
		spPSizeCustomService.deleteSpPSizeCustom(spPSizeCustom);

	}
	@Test
	public void getPSizeCustom(){
		int corpId = 100001;
		System.out.println(spPSizeService.getSpPSizes(corpId).toString());

	}
}
