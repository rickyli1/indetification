package com.main.identification.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.Expert;
import com.main.identification.service.ExpertService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;

@Controller
@RequestMapping("/expert")
public class ExpertController {
	
	@Autowired
	private ExpertService expertService;
	
	@ResponseBody
	@RequestMapping("/getExpertForApplication")
	public Map<String,Object> getExpertForApplicationRegister(@RequestBody Expert expert, Model model) {
		Map<String,Object> result = new HashMap<>();
		expert.setStartNo(PageUtil.getStartNo(expert.getPage(), Constant.PAGE_SIZE));
		expert.setPageSize(Constant.PAGE_SIZE);
		
		
		int totalCount = expertService.selectExpertCount(expert);
		result.put("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		result.put("pageSize", Constant.PAGE_SIZE);
		result.put("page", expert.getPage());
		result.put("totalCount", totalCount);
		result.put("applicationResultList", expertService.selectExpertForApplication(expert));
		
		return result;
	}
	
	
}
