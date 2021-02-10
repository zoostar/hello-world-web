package net.zoostar.hw.web.controller;

import javax.servlet.ServletException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@RequestMapping(value="/", produces=MediaType.TEXT_HTML_VALUE)
	public String loadHomePage() throws ServletException {
		log.info("{}", "Loading home page index.jsp...");
		return "index";
	}
}
