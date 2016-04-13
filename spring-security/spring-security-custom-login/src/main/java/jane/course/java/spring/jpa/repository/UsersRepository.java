package jane.course.java.spring.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import jane.course.java.spring.jpa.entity.Users;

public interface UsersRepository extends PagingAndSortingRepository<Users, String> {
	
}
