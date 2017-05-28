package com.main.identification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.Expert;
import com.main.identification.model.ExpertStatistics;
import com.main.identification.service.StatisticsService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService statisticsService;
	
	@ResponseBody
	@RequestMapping("/expert")
	public List<ExpertStatistics> getExpertStatistics(@RequestBody Expert expert) {
		List<ExpertStatistics> list =  statisticsService.findExpertStatistics(expert);
		return list;
	}	
}
