package com.pitchinsight;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserInputRepository extends CrudRepository<UserInput, Long> {
	
	
		
}
