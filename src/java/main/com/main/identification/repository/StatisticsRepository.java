package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.Expert;
import com.main.identification.model.ExpertStatistics;

public interface StatisticsRepository {

	List<ExpertStatistics> findExpertStatistics(Expert expert);

	
	

}
