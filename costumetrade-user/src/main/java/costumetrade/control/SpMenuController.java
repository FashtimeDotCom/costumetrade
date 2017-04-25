package costumetrade.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import costumetrade.common.param.ApiResponse;
import costumetrade.common.param.ResponseInfo;
import costumetrade.domain.SpMenu;
import costumetrade.domain.SpMenuEmployee;
import costumetrade.service.SpMenuEmployeeService;
import costumetrade.service.SpMenuService;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RequestMapping("/menu")
@Controller
public class SpMenuController {
	@Autowired
	private SpMenuService spMenuService;

	@Autowired
	private SpMenuEmployeeService spMenuEmployeeService;
	
	@RequestMapping("/getAllMenus")
	@ResponseBody
	public ApiResponse getAllMenus() {

		ApiResponse result = new ApiResponse();
		List<SpMenu> menuLists = new ArrayList<SpMenu>();
		menuLists = spMenuService.getAllMenus();
		result.setData(menuLists);
		return result;
	}

	@RequestMapping("/addEmployeeMenus")
	@ResponseBody
	public ApiResponse addEmployeeMenus(@RequestBody List<SpMenuEmployee> spMenuEmployees) {
		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		
		if(null==spMenuEmployees || spMenuEmployees.size()<=0){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		
	    spMenuEmployeeService.saveSpMenuEmployees(spMenuEmployees);
			
		
		return result;
	}
	
	@RequestMapping("/getEmployeeMenus")
	@ResponseBody
	public ApiResponse getEmployeeMenus(@RequestBody Long employeeId) {

		List<SpMenuEmployee> menuEmployeeLists = new ArrayList<SpMenuEmployee>();
		menuEmployeeLists = spMenuEmployeeService.getAllMenuEmployees(employeeId);

		return ApiResponse.getInstance(menuEmployeeLists);
	}
	
}
