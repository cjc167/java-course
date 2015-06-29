package jane.course.java.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(Model model, String username){
		if(username == null || "".equals(username.trim())){
			username = "World!";
		}
		
		model.addAttribute("username", username);
		return "index";
	}
}