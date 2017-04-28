package costumetrade.order;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.domain.SpPColor;
import costumetrade.domain.SpPColorCustom;
import costumetrade.domain.SpPColorCustomKey;
import costumetrade.domain.SpPColorKey;
import costumetrade.service.SpPColorCustomService;
import costumetrade.service.SpPColorService;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext_test.xml"})
public class SpColorServiceTest {

	@Autowired
	private SpPColorService spPColorService;
	@Autowired
	private SpPColorCustomService spPColorCustomService;


	@Test
	public void insertSpPColor(){
		
		SpPColor spPColor = new SpPColor();
		spPColor.setCorpid(100001);
		spPColor.setId("红色");
		spPColor.setCreateTime(new Date());
		spPColor.setBarcode("ys00001");
		spPColor.setModifyTime(new Date());
		spPColorService.saveSpPColor(spPColor);

	}
	@Test
	public void deletePColor(){
		
		SpPColorKey spPColor = new SpPColorKey();
		spPColor.setCorpid(4);
		spPColor.setId("红色");
		spPColorService.deleteSpPColor(spPColor);

	}
	@Test
	public void getPColor(){
		int corpId = 100001;
		System.out.println(spPColorService.getSpPColors(corpId));

	}
	
	
	@Test
	public void insertSpPColorCustom(){
		
		SpPColorCustom spPColorCustom = new SpPColorCustom();
		spPColorCustom.setCorpid(100001);
		spPColorCustom.setId("自定义1");
		spPColorCustom.setCreateTime(new Date());
		spPColorCustom.setValue("红色,黄色,绿色");
		spPColorCustom.setModifyTime(new Date());
		spPColorCustomService.saveSpPColorCustom(spPColorCustom);

	}
	@Test
	public void deletePColorCustom(){
		
		SpPColorCustomKey spPColorCustom = new SpPColorCustomKey();
		spPColorCustom.setCorpid(100001);
		spPColorCustom.setId("红色");
		spPColorCustomService.deleteSpPColorCustom(spPColorCustom);

	}
	@Test
	public void getPColorCustom(){
		int corpId = 100001;
		System.out.println(spPColorCustomService.getSpPColorCustoms(corpId));

	}
	
}
