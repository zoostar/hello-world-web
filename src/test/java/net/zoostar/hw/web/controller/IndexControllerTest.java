package net.zoostar.hw.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.ModelAndView;

@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:META-INF/applicationContext-test.xml"})
class IndexControllerTest {

	@Autowired
	protected IndexController controller;
	
	@Test
	void testLoadHomePage() throws ServletException {
		ModelAndView modelAndView = controller.loadHomePage(new HashMap<String, Object>());
		assertNotNull(modelAndView);
		assertEquals("index", modelAndView.getViewName());
		assertEquals("dev", modelAndView.getModel().get("env_value"));
		assertEquals("Hello World", modelAndView.getModel().get("index_message"));
	}

}
