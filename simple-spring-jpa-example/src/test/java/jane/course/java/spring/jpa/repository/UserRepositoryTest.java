package jane.course.java.spring.jpa.repository;

import static org.junit.Assert.*;

import java.util.List;

import jane.course.java.spring.jpa.entity.User;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:embedded-database.xml"})
public class UserRepositoryTest {
	
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
		Page<User> usersPage = userRepository.findAll(new PageRequest(0, Integer.MAX_VALUE));
		assertNotNull(usersPage);
		assertNotNull(usersPage.getContent());
		
		List<User> users = usersPage.getContent();
		assertFalse(users.isEmpty());
		assertEquals(60, users.size());
	}
}
