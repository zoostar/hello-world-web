package net.zoostar.hw.web.controller;

import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@Value("${env.value}")
	protected String envValue;
	
	@Value("${index.message}")
	protected String message;
	
	@RequestMapping(value="/", produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView loadHomePage(Map<String, Object> model) throws ServletException {
		log.info("Loading home page index.jsp message {} for env: {}...", message, envValue);
		model.put("env_value", envValue);
		model.put("index_message", message);
		return new ModelAndView("index", model);
	}
}
