package jane.course.java.spring.jpa.repository;

import jane.course.java.spring.jpa.entity.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
}
