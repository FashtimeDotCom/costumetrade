package costumetrade.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import costumetrade.common.Entity;
import costumetrade.common.param.ApiResponse;
import costumetrade.domain.UserInfo;
import costumetrade.employee.service.SpEmployeeService;
import costumetrade.user.domain.SpEmployee;

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
	public ApiResponse getList() {

		ApiResponse result = new ApiResponse();
		List<SpEmployee> employeeLists = new ArrayList<SpEmployee>();
		employeeLists = spEmployeeService.getAllEmployees();
		if(employeeLists.size()>0){
			result.setCode(0);
			result.setData(employeeLists);
		}else{
			result.setCode(1);
			result.setMsg("暂无员工信息，请先对员工信息进行维护！");
			result.setData(null);
		}
	
		return result;
	}

	
}
