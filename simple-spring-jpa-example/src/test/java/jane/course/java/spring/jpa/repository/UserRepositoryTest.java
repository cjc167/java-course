package jane.course.java.spring.jpa.repository;

import static org.junit.Assert.*;

import java.util.List;

import jane.course.java.spring.jpa.entity.User;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:/spring-context/embedded-database.xml"})
public class UserRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
		assertNotNull(userRepository);
	}

	@Test
	public void findOne() {
		User user = userRepository.findOne(1000L);
		assertNotNull(user);
		assertEquals("AARON", user.getUsername());
		assertEquals("AiVhN7qW", user.getPassword());
	}
	
	@Test
	public void findAll() {
		Sort sort = new Sort(Direction.ASC, "id", "username", "password");
		sort = new Sort(new Sort.Order(Direction.ASC, "id"), new Sort.Order(Direction.DESC, "username"));
		
		Pageable pageable = new PageRequest(0, 20, sort);
		
		
//		Page<User> usersPage = userRepository.findAll(new PageRequest(0, Integer.MAX_VALUE));
		Page<User> usersPage = userRepository.findAll(pageable);
		
		assertNotNull(usersPage);
		assertNotNull(usersPage.getContent());
		
		List<User> users = usersPage.getContent();
		assertFalse(users.isEmpty());
//		assertEquals(60, users.size());
		
		logger.info(new Gson().toJson(usersPage));
	}
}
