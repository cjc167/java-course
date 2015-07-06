package jane.course.java.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import jane.course.java.spring.mvc.annotation.SessionAttribute;
import jane.course.java.spring.mvc.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(Model model, User user, HttpServletRequest request){
		logger.debug(String.valueOf(user));
		
		if(user == null || user.getUsername() == null || "".equals(user.getUsername().trim())){
			user = new User();
			user.setUsername("World!");
		} else {
			request.getSession().setAttribute("user", user);
		}
		
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value = "login.html")
	public String login(@SessionAttribute(value = "user") User user) {
		return "index";
	}
}