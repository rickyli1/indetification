package com.main.identification.utils;

public class PageUtil {
	
	public static int getStartNo(int page, int pageSize) {
		return ((page == 0 ? 1 : page ) -1 ) * pageSize ;
	}
	
	public static int getTotalPage(int totalCount, int pageSize) {
		int tempPage = totalCount / pageSize;
		
		if(totalCount % pageSize != 0) {
			tempPage ++;
		}
		
		return tempPage;
	}
}