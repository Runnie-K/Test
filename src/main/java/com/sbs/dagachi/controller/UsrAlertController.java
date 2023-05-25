package com.sbs.dagachi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbs.dagachi.service.AlertService;
import com.sbs.dagachi.vo.Alert;

@Controller
public class UsrAlertController {

	private AlertService alertService;

	public UsrAlertController(AlertService alertService) {
		this.alertService = alertService;
	}

	@RequestMapping("/usr/common/head")
	public String showAlertList(Model model) {

		List<Alert> alerts = alertService.getAlerts();

		model.addAttribute("alerts", alerts);

		return "usr/common/head";
	}

}
