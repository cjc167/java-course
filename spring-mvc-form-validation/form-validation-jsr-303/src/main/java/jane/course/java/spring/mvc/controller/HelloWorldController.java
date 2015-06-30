package jane.course.java.spring.mvc.controller;

import jane.course.java.spring.mvc.domain.User;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(
		Model model, 
		@Valid @ModelAttribute("user") User user, 
		BindingResult result
	){
		model.addAttribute("user", user);
		return "index";
	}
}