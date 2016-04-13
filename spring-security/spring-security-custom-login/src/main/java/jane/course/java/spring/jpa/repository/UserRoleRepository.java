package jane.course.java.spring.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import jane.course.java.spring.jpa.entity.UserRole;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
	
}
