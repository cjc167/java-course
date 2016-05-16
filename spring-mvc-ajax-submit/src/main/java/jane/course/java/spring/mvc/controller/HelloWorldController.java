package jane.course.java.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jane.course.java.spring.mvc.vo.User;

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
	
	
	
	
	@RequestMapping(value = "/ajax/post", method = RequestMethod.GET)
	public String post(Model model, String username){
		logger.info("Get Method.");
		if(username == null || "".equals(username.trim())){
			username = "World!";
		}
		
		model.addAttribute("username", username);
		return "post";
	}
	
	@RequestMapping(value = "/ajax/post", method = RequestMethod.POST)
	public ResponseEntity<String> post(User user){
		logger.info(String.valueOf(user));
		
		HttpStatus httpStatus = HttpStatus.CREATED;
		
		if("jane".equals(user.getUsername())) {
			httpStatus = HttpStatus.CONFLICT;
		}
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain; charset=UTF-8");
		
		ResponseEntity<String> response = new ResponseEntity<String>(new Gson().toJson(user),  headers, httpStatus);
		return response;
	}
}