package costumetrade.order;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.domain.SpPSize;
import costumetrade.domain.SpPSizeKey;
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
	
}
