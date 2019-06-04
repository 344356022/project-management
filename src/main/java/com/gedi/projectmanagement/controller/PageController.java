package com.gedi.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {


	@RequestMapping("{page}")
	public String page(@PathVariable("page") String page) {
		return page;
	}

}
