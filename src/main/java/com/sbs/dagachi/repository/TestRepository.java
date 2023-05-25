package com.sbs.dagachi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.dagachi.vo.Test;

@Mapper
public interface TestRepository {
    Test getTestTno(@Param("tno") int tno);
    
    int getTestsCount(@Param("tno") int tno, 
    		@Param("searchKeywordTypeCode") String searchKeywordTypeCode, 
    		@Param("searchKeyword") String searchKeyword);
	
    List<Test> getForPrintTests(int tno, int limitStart, int limitTake, String searchKeywordTypeCode, String searchKeyword);

	List<Test> getForPrintLiveTest(int tno);

	public void setDelStatusToOne(int tno);
	
	int getCountTestsDelstatusZero();
	
}
