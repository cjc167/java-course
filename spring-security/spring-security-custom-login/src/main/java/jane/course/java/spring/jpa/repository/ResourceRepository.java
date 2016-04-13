package jane.course.java.spring.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import jane.course.java.spring.jpa.entity.Resource;

public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long> {
	
}
