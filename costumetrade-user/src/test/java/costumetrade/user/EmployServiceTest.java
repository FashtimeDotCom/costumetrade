/**
 * Copyright (C) 2014-2016, Hrfax and/or its affiliates. All rights reserved.
 * Hrfax PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package costumetrade.user;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import costumetrade.employee.service.SpEmployeeService;
import costumetrade.user.domain.SpEmployee;

/**
 * @author caiyj
 * @Date 2017年01月13日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext_test.xml"})
public class EmployServiceTest {

	@Autowired
	private SpEmployeeService spEmployeeService;



	@Test
	public void insertSpEmployee(){
		
		SpEmployee spEmployee = new SpEmployee();
		
		spEmployee.setName("陈思成");
		spEmployee.setCorpid(1);
		spEmployee.setId("fancy001");
		spEmployee.setStatus(1);
		spEmployee.setCreateTime(new Date());
		spEmployee.setSubbelong("33");
		spEmployeeService.saveEmployee(spEmployee);

	}
	@Test
	public void deleteEmployee(){
		
		SpEmployee spEmployee = new SpEmployee();
		spEmployee.setCorpid(4);
		spEmployeeService.deleteEmployee(spEmployee);

	}
	@Test
	public void getEmployee(){
		
		SpEmployee spEmployee = new SpEmployee();
		spEmployee.setSubbelong(33+"");
		System.out.println(spEmployeeService.getAllEmployees(33+""));

	}
}
