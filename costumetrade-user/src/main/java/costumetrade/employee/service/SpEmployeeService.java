package costumetrade.employee.service;

import java.util.List;

import costumetrade.user.domain.SpEmployee;


public interface SpEmployeeService {
	/*
	 * 获取所有员工信息
	 * 
	 * */
	public List<SpEmployee> getAllEmployees();
}
