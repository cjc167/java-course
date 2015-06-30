package jane.course.java.spring.mvc.controller;

import jane.course.java.spring.mvc.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(Model model, User user){
		if(user == null || user.getUsername() == null || "".equals(user.getUsername().trim())){
			user = new User();
			user.setUsername("World!");
		}
		
		model.addAttribute("user", user);
		return "index";
	}
}