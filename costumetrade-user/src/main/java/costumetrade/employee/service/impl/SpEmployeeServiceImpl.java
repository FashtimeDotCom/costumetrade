package costumetrade.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.employee.service.SpEmployeeService;
import costumetrade.user.domain.SpEmployee;
import costumetrade.user.domain.SpEmployeeKey;
import costumetrade.user.mapper.SpEmployeeMapper;
import costumetrade.util.UserConstant;

@Transactional
@Service
public class SpEmployeeServiceImpl implements SpEmployeeService{
	@Autowired
	private SpEmployeeMapper spEmployeeMapper;
	@Override
	public List<SpEmployee> getAllEmployees() {

		return spEmployeeMapper.getAllEmployees();
	}
	@Override
	public int saveEmployee(SpEmployee spEmployee) {

		SpEmployeeKey spEmployeeKey = new SpEmployeeKey();
		if(spEmployee.getId() != null && spEmployee.getCorpid() != null){
			spEmployeeKey.setId(spEmployee.getId());
			spEmployeeKey.setCorpid(spEmployee.getCorpid());
			SpEmployee getEmployee = spEmployeeMapper.selectByPrimaryKey(spEmployeeKey);
			if(getEmployee == null){
			return spEmployeeMapper.updateByPrimaryKey(spEmployee);
			}
		}
		spEmployeeKey.setCorpid(spEmployee.getCorpid());
		//查询对应ID的员工是否存在，存在的话进行update 不存在save

		return spEmployeeMapper.insert(spEmployee) ;
		 
	}
	@Override
	public int deleteEmployee(SpEmployee spEmployee) {

		SpEmployeeKey spEmployeeKey = new SpEmployeeKey();
		if(spEmployee.getId() != null && spEmployee.getCorpid() != null){
			spEmployeeKey.setId(spEmployee.getId());
			spEmployeeKey.setCorpid(spEmployee.getCorpid());
		}else{
			return UserConstant.OPERATE_FAIL;
		}
		return spEmployeeMapper.deleteByPrimaryKey(spEmployeeKey);
	}
	
	

}
