package costumetrade.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import costumetrade.common.Entity;
import costumetrade.common.param.ApiResponse;
import costumetrade.domain.UserInfo;
import costumetrade.employee.service.SpEmployeeService;
import costumetrade.user.domain.SpEmployee;
import costumetrade.util.UserConstant;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RequestMapping("/employee")
@Controller
public class SpEmployeeController {
	@Autowired
	private SpEmployeeService spEmployeeService;

	@RequestMapping("/getAllEmployees")
	@ResponseBody
	public ApiResponse getAllEmployees(@RequestBody String subId) {

		ApiResponse result = new ApiResponse();
		List<SpEmployee> employeeLists = new ArrayList<SpEmployee>();
		employeeLists = spEmployeeService.getAllEmployees(subId);
		if(employeeLists.size()>0){
			result.setCode(UserConstant.OPERATE_SUCCESS);
			result.setData(employeeLists);
		}else{
			result.setCode(UserConstant.OPERATE_FAIL);
			result.setMsg("暂无员工信息，请先对员工信息进行维护！");
			result.setData(null);
		}
	
		return result;
	}

	@RequestMapping("/saveEmployee")
	@ResponseBody
	public ApiResponse saveEmployee(@RequestBody SpEmployee spEmployee) {

		ApiResponse result = new ApiResponse();
		if(spEmployee == null ){
			result.setMsg("员工信息为空，不能保存");
			return result;
		}
		int save = spEmployeeService.saveEmployee(spEmployee);
		if(save == UserConstant.SAVE_FAIL){
			result.setData(spEmployee);
		}else if(save == UserConstant.SAVE_SUCCESS){
			List<SpEmployee> employeeLists = new ArrayList<SpEmployee>();
			if(spEmployee.getSubbelong()  != null && "".endsWith(spEmployee.getSubbelong() )){
				employeeLists = spEmployeeService.getAllEmployees(spEmployee.getSubbelong());
				result.setData(employeeLists);
			}
			
		}
		return result;
	}

	@RequestMapping("/deleteEmployee")
	@ResponseBody
	public ApiResponse deleteEmployee(@RequestParam SpEmployee spEmployee) {

		ApiResponse result = new ApiResponse();
		if(spEmployee == null ){
			return result;
		}
		int delete = spEmployeeService.deleteEmployee(spEmployee);
		if(delete == UserConstant.SAVE_FAIL){
			
			result.setData(spEmployee);
			
		}else if(delete == UserConstant.SAVE_SUCCESS){
			List<SpEmployee> employeeLists = new ArrayList<SpEmployee>();
			if(spEmployee.getSubbelong()  != null && "".endsWith(spEmployee.getSubbelong() )){
				employeeLists = spEmployeeService.getAllEmployees(spEmployee.getSubbelong());
				result.setData(employeeLists);
			}
		}
		return result;
	}
	
}
