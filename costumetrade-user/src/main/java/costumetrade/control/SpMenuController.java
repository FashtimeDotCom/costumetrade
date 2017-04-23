package costumetrade.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import costumetrade.authority.service.SpMenuEmployeeService;
import costumetrade.authority.service.SpMenuService;
import costumetrade.common.param.ApiResponse;
import costumetrade.user.domain.SpMenu;
import costumetrade.user.domain.SpMenuEmployee;
import costumetrade.util.UserConstant;

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
		int save = 0;
		ApiResponse result = new ApiResponse();
		List<SpMenuEmployee> menuEmployeeLists = new ArrayList<SpMenuEmployee>();
		
		if(spMenuEmployees.size()>0){
			save = spMenuEmployeeService.saveSpMenuEmployees(spMenuEmployees);
			menuEmployeeLists = spMenuEmployeeService.getAllMenuEmployees(spMenuEmployees.get(0).getEmployeeId());
		}
		result.setData(menuEmployeeLists);
		return result;
	}
	
	@RequestMapping("/getEmployeeMenus")
	@ResponseBody
	public ApiResponse getEmployeeMenus(@RequestBody Long employeeId) {
		ApiResponse result = new ApiResponse();
		List<SpMenuEmployee> menuEmployeeLists = new ArrayList<SpMenuEmployee>();
		menuEmployeeLists = spMenuEmployeeService.getAllMenuEmployees(employeeId);
		result.setData(menuEmployeeLists);
		return result;
	}
	
}
