/**
 * Copyright (C) 2014-2016, Hrfax and/or its affiliates. All rights reserved.
 * Hrfax PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package costumetrade.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.common.util.HttpPostUtil;
import costumetrade.domain.SpMenuEmployee;
import costumetrade.service.SpMenuEmployeeService;
import costumetrade.service.SpMenuService;
import costumetrade.user.entity.SpMenuEmployeeEntity;

/**
 * @author caiyj
 * @Date 2017年01月13日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext_test.xml"})
public class MenuEmployServiceTest {

	@Autowired
	private SpMenuEmployeeService spMenuEmployeeService;
	@Autowired
	private SpMenuService  spMenuService ;


	@Test
	public void insertSpMenuEmployee(){
		List<SpMenuEmployee> menuEmployees = new ArrayList<SpMenuEmployee>();
		SpMenuEmployee spMenuEmployee1 = new SpMenuEmployee();
		
		spMenuEmployee1.setEmployeeId(1l);
		spMenuEmployee1.setMenuId(2l);
		spMenuEmployee1.setCreateDate(new Date());
		spMenuEmployee1.setModifyDate(new Date());
		menuEmployees.add(spMenuEmployee1);
		
		SpMenuEmployee spMenuEmployee2 = new SpMenuEmployee();
		
		spMenuEmployee2.setEmployeeId(1l);
		spMenuEmployee2.setMenuId(2l);
		spMenuEmployee2.setCreateDate(new Date());
		spMenuEmployee2.setModifyDate(new Date());
		menuEmployees.add(spMenuEmployee2);
		//spMenuEmployeeService.saveSpMenuEmployees(menuEmployees);
		HttpPostUtil httpPostUtil = new HttpPostUtil();
//		SpMenuEmployeeEntity entity = new SpMenuEmployeeEntity();
//		entity.setSpMenuEmployees(menuEmployees);
//		
//		
//		httpPostUtil.sendPostRequestJSON("http://localhost:8080/costumetrade-web/menu/addEmployeeMenus", JSONObject.fromObject(entity));
//		
		Long employeeId = 1l;
		httpPostUtil.sendPostRequestJSON("http://localhost:8080/costumetrade-web/menu/getEmployeeMenus", JSONObject.fromObject(employeeId));
	}
	@Test
	public void getMenuEmployees(){
		
		Long employeeId = 1l;
		System.out.println(spMenuEmployeeService.getAllMenuEmployees(employeeId));

	}
	
	@Test
	public void getMenus(){
		
		System.out.println(spMenuService.getAllMenus());

	}
	
}
