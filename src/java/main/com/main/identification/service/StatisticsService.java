package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.Expert;
import com.main.identification.model.ExpertStatistics;
import com.main.identification.repository.StatisticsRepository;

@Service
public class StatisticsService {
	@Autowired 
	private StatisticsRepository statisticsRepository;
	
	public int findExpertStatisticsCountCount(Expert expert){
		return statisticsRepository.findExpertStatisticsCount(expert);
	}
	
	public List<ExpertStatistics> findExpertStatistics(Expert expert) {
	    return statisticsRepository.findExpertStatistics(expert);
	}
}
