package costumetrade.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import costumetrade.common.param.ApiResponse;
import costumetrade.domain.UserInfo;

/**
 *
 * 
 * @author cyj
 * @Date 2017年3月8日
 */
@RequestMapping("/user")
@Controller
public class UserController {


	@RequestMapping("/getList")
	@ResponseBody
	public ApiResponse getList() {

		ApiResponse result = new ApiResponse();
		List<UserInfo> userList = new ArrayList<UserInfo>();
		for(int i=0;i<5;i++){
			UserInfo userInfo = new UserInfo();
			userList.add(userInfo);
			userInfo.setUserName("username"+i);
			userInfo.setPassword("password"+i);
		}
		result.setData(userList);
		return result;
	}

	
}
