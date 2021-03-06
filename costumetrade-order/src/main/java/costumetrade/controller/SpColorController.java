package costumetrade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import costumetrade.common.param.ApiResponse;
import costumetrade.common.param.ResponseInfo;
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
@RequestMapping("/color")
@Controller
public class SpColorController {
	@Autowired
	private SpPColorService spPColorService;
	@Autowired
	private SpPColorCustomService spPColorCustomService;

	@RequestMapping("/getAllColors")
	@ResponseBody
	public ApiResponse getAllColors(@RequestBody int corpId) {
		
		List<SpPColor> colorLists = new ArrayList<SpPColor>();
		colorLists = spPColorService.getSpPColors(corpId);

		return  ApiResponse.getInstance(colorLists);
	}

	@RequestMapping("/saveColor")
	@ResponseBody
	public ApiResponse saveColor(@RequestBody SpPColor spPColor) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		if(spPColor == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int save = spPColorService.saveSpPColor(spPColor);
		if(save<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;

	}

	@RequestMapping("/deleteColor")
	@ResponseBody
	public ApiResponse deleteColor(@RequestParam SpPColorKey spPColorKey) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		
		if(spPColorKey == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int delete = spPColorService.deleteSpPColor(spPColorKey);
		if(delete<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;
	}
	
	@RequestMapping("/getAllColorCustoms")
	@ResponseBody
	public ApiResponse getAllColorCustoms(@RequestBody int corpId) {
		
		List<SpPColorCustom> colorCustomLists = new ArrayList<SpPColorCustom>();
		colorCustomLists = spPColorCustomService.getSpPColorCustoms(corpId);

		return  ApiResponse.getInstance(colorCustomLists);
	}

	@RequestMapping("/saveColorCustom")
	@ResponseBody
	public ApiResponse saveColorCustom(@RequestBody SpPColorCustom spPColorCustom) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		if(spPColorCustom == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int save = spPColorCustomService.saveSpPColorCustom(spPColorCustom);
		if(save<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;

	}

	@RequestMapping("/deleteColorCustom")
	@ResponseBody
	public ApiResponse deleteColorCustom(@RequestParam SpPColorCustomKey spPColorCustomKey) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		
		if(spPColorCustomKey == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int delete = spPColorCustomService.deleteSpPColorCustom(spPColorCustomKey);
		if(delete<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;
	}
}
