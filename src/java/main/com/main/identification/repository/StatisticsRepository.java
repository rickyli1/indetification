package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.Expert;
import com.main.identification.model.ExpertStatistics;

public interface StatisticsRepository {

	int findExpertStatisticsCount(Expert expert);
	
	List<ExpertStatistics> findExpertStatistics(Expert expert);

}
