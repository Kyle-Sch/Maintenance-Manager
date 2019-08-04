package com.maintain.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

	@RequestMapping("/")
	public String displayHome() {
		return "home";
	}
}
