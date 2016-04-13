package jane.course.java.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = {"/", "/index.html"})
	public String index(){
		return "index";
	}
	
	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID().toString());
	}
}
