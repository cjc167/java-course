package jane.course.java.spring.mvc.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jane.course.java.datatable.converter.DataTableToPageableConverter;
import jane.course.java.datatable.domain.DataTablesRequest;
import jane.course.java.datatable.domain.DataTablesResponse;
import jane.course.java.spring.jpa.entity.User;
import jane.course.java.spring.jpa.repository.UserRepository;

@Controller
public class HelloWorldController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private UserRepository userRepository;
	
	@RequestMapping(value = {"/", "index.html"})
	public String index(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/datatable")
	public DataTablesResponse<User> datatable(DataTablesRequest datatable){
		logger.info("接收到GET请求过来的参数{}", new Gson().toJson(datatable));
		
		Pageable pageable = new DataTableToPageableConverter(User.class).convert(datatable);
		logger.info("转换后的分页参数", new Gson().toJson(pageable));
		
		Page<User> users = userRepository.findAll(pageable);
		
		DataTablesResponse<User> response = new DataTablesResponse<User>();
		response.setRecordsTotal(new Long(users.getTotalElements()).intValue());
		response.setRecordsFiltered(users.getNumber());
		response.setData(users.getContent());
		return response;
	}
}