package jane.course.java.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(Model model, String username){
		if(username == null || "".equals(username.trim())){
			username = "World!";
		}
		
		model.addAttribute("username", username);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/get", method = RequestMethod.GET)
	public String get(String username){
		logger.info("接收到GET请求过来的参数{}", username);
		return "success";
	}
}