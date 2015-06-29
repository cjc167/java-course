package jane.course.java.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(){
		return "index";
	}
}