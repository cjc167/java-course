package jane.course.java.spring.jpa.repository;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jane.course.java.spring.jpa.entity.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UsersRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private UsersRepository usersRepository;
	
	@Before
	public void setUp() throws Exception {
		assertNotNull(usersRepository);
	}

	@Test
	public void findOne() {
		Users user = usersRepository.findOne("hippo");
		logger.info(String.valueOf(user));
	}
}
