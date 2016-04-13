package jane.course.java.spring.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import jane.course.java.spring.jpa.entity.Operation;

public interface OperationRepository extends PagingAndSortingRepository<Operation, Long> {
	
}
