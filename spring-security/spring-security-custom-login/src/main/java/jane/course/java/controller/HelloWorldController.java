package jane.course.java.controller;

import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/index.html")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "/login.html")
	public String login(){
		return "login";
	}
}
