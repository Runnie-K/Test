package com.sbs.dagachi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbs.dagachi.service.TestService;
import com.sbs.dagachi.vo.Test;

@Controller
public class UsrDashBoardController {

	@Autowired
	private TestService testService;

	@RequestMapping("/usr/dashBoard/main")
	public String showList(Model model, @RequestParam(defaultValue = "1") int tno,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "title, content") String searchKeywordTypeCode,
			@RequestParam(defaultValue = "") String searchKeyword) {

		Test test = testService.getTestTno(tno);
		int testsCount = testService.getTestsCount(tno, searchKeywordTypeCode, searchKeyword);
		int itemsCountInAPage = 5;
		int pagesCount = (int) Math.ceil((double) testsCount / itemsCountInAPage);

		List<Test> tests = testService.getForPrintTest(tno, searchKeywordTypeCode, searchKeyword, itemsCountInAPage,
				page);

		model.addAttribute("test", test);
		model.addAttribute("tno", tno);
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("tests", tests);
		model.addAttribute("testsWhereDelstatusIsZeroCount", testService.getCountTestsDelstatusZero()); // New line

		return "usr/dashBoard/main";
	}

	@RequestMapping("/tests/check")
    public ResponseEntity<List<Test>> checkTest(@RequestParam(defaultValue = "1") int tno) {
        List<Test> tests = testService.getForPrintLiveTest(tno);
        
        return ResponseEntity.ok(tests); // returns tests as a JSON response
    }

	@DeleteMapping("/tests/delete")
	public ResponseEntity<Void> deleteTest(@RequestParam int tno) {
	    testService.deleteTest(tno);
	    return ResponseEntity.ok().build();
	}



}
