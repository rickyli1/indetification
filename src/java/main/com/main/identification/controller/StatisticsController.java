package com.main.identification.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.identification.model.Expert;
import com.main.identification.service.ConstantService;
import com.main.identification.service.StatisticsService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService statisticsService;
	
	@Autowired
	public ConstantService constantService;
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
//    	ConstantModel constant = new ConstantModel();
//		constant.setConstantType(Constant.REPAIR_LEVEL);
//		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
//		model.addAttribute("repairLevelList",repairLevelList);
		
		model.addAttribute("page",  "1");
		model.addAttribute("totalPage",  "1");
		
		return "/expert/expertStatisticsSearch";
	}
	
	@RequestMapping("/getExpertStatistics")
	public String getExpertStatistics(Model model,@RequestBody Expert expert) {
		
		int totalCount = statisticsService.findExpertStatisticsCountCount(expert);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		model.addAttribute("pageSize", Constant.PAGE_SIZE);
		model.addAttribute("page", expert.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("expertStatisticsList", statisticsService.findExpertStatistics(expert));

		return "expert/expertStatisticsList";
	}	
}
