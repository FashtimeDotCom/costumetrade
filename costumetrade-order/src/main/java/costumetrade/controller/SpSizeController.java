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
import costumetrade.domain.SpPSize;
import costumetrade.domain.SpPSizeCustom;
import costumetrade.domain.SpPSizeCustomKey;
import costumetrade.domain.SpPSizeKey;
import costumetrade.service.SpPSizeCustomService;
import costumetrade.service.SpPSizeService;

/**
 *
 * 
 * @author fancy
 * @Date 2017年4月21日
 */
@RequestMapping("/size")
@Controller
public class SpSizeController {
	@Autowired
	private SpPSizeService spPSizeService;
	@Autowired
	private SpPSizeCustomService spPSizeCustomService;

	@RequestMapping("/getAllSizes")
	@ResponseBody
	public ApiResponse getAllSizes(@RequestBody int corpId) {
		
		List<SpPSize> sizeLists = new ArrayList<SpPSize>();
		sizeLists = spPSizeService.getSpPSizes(corpId);

		return  ApiResponse.getInstance(sizeLists);
	}

	@RequestMapping("/saveSize")
	@ResponseBody
	public ApiResponse saveSize(@RequestBody SpPSize spPSize) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		if(spPSize == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int save = spPSizeService.saveSpPSize(spPSize);
		if(save<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;

	}

	@RequestMapping("/deleteSize")
	@ResponseBody
	public ApiResponse deleteSize(@RequestParam SpPSizeKey spPSizeKey) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		
		if(spPSizeKey == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int delete = spPSizeService.deleteSpPSize(spPSizeKey);
		if(delete<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;
	}
	
	
	@RequestMapping("/getAllSizeCustom")
	@ResponseBody
	public ApiResponse getAllSizeCustom(@RequestBody int corpId) {
		
		List<SpPSizeCustom> sizeCustomLists = new ArrayList<SpPSizeCustom>();
		sizeCustomLists = spPSizeCustomService.getSpPSizeCustoms(corpId);

		return  ApiResponse.getInstance(sizeCustomLists);
	}

	@RequestMapping("/saveSizeCustom")
	@ResponseBody
	public ApiResponse saveSizeCustom(@RequestBody SpPSizeCustom spPSizeCustom) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		if(spPSizeCustom == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int save = spPSizeCustomService.saveSpPSizeCustom(spPSizeCustom);
		if(save<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;

	}

	@RequestMapping("/deleteSizeCustom")
	@ResponseBody
	public ApiResponse deleteSizeCustom(@RequestParam SpPSizeCustomKey spPSizeCustomKey) {

		ApiResponse result = new ApiResponse();
		result.setCode(ResponseInfo.SUCCESS.code);
		result.setMsg(ResponseInfo.SUCCESS.msg);
		
		if(spPSizeCustomKey == null ){
			result.setCode(ResponseInfo.LACK_PARAM.code);
			result.setMsg(ResponseInfo.LACK_PARAM.msg);
			return result;
		}
		int delete = spPSizeCustomService.deleteSpPSizeCustom(spPSizeCustomKey);
		if(delete<=0){
			result.setCode(ResponseInfo.EXCEPTION.code);
			result.setMsg(ResponseInfo.EXCEPTION.msg);
			return result;
		}
		return result;
	}
	
}
