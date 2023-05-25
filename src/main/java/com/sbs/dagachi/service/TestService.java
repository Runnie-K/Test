package com.sbs.dagachi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.dagachi.repository.TestRepository;
import com.sbs.dagachi.vo.Test;

@Service
public class TestService {
	
	@Autowired
    private TestRepository testRepository;

	public TestService(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	public Test getTestTno(int tno) {
		return testRepository.getTestTno(tno);
	}

	public int getTestsCount(int tno, String searchKeywordTypeCode, String searchKeyword) {
		// TODO Auto-generated method stub
		return testRepository.getTestsCount(tno, searchKeywordTypeCode, searchKeyword);
	}

	public List<Test> getForPrintTest(int tno, String searchKeywordTypeCode, String searchKeyword,
			int itemsCountInAPage, int page) {
		int limitStart = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;

		List<Test> tests = testRepository.getForPrintTests(tno, limitStart, limitTake, searchKeywordTypeCode,
				searchKeyword);

		return tests;
	}

	public List<Test> getForPrintLiveTest(int tno) {
		List<Test> tests = testRepository.getForPrintLiveTest(tno);

		return tests;
	}

	public void deleteTest(int tno) {
        testRepository.setDelStatusToOne(tno);
    }
	
	public int getCountTestsDelstatusZero() {
	    return testRepository.getCountTestsDelstatusZero();
	}

}