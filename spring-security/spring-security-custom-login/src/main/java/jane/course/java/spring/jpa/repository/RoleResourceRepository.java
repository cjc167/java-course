package jane.course.java.spring.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import jane.course.java.spring.jpa.entity.RoleResource;

public interface RoleResourceRepository extends PagingAndSortingRepository<RoleResource, Long> {
	
}
