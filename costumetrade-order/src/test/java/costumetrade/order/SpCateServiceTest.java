package costumetrade.order;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.domain.SpPCate;
import costumetrade.domain.SpPCateKey;
import costumetrade.service.SpPCateService;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext_test.xml"})
public class SpCateServiceTest {

	@Autowired
	private SpPCateService spPCateService;



	@Test
	public void insertSpPCate(){
		
		SpPCate spPCate = new SpPCate();
		spPCate.setCorpid(100001);
		spPCate.setId("衬衣");
		spPCate.setFastcode("CY");
		spPCate.setCreateTime(new Date());
		spPCate.setModifyTime(new Date());
		spPCateService.saveSpPCate(spPCate);

	}
	@Test
	public void deletePCate(){
		
		SpPCateKey spPCate = new SpPCateKey();
		spPCate.setCorpid(100001);
		spPCate.setId("衬衣");
		spPCateService.deleteSpPCate(spPCate);

	}
	@Test
	public void getPCate(){
		int corpId = 100001;
		System.out.println(spPCateService.getSpPCates(corpId));

	}
	
}
