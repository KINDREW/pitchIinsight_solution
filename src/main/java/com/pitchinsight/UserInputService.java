package com.pitchinsight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;





@Service
public class UserInputService {
	
	//importing userInputRepository
	@Autowired
	private UserInputRepository userInputRepository;
	
	//getting userInput from db
//	public List<UserInput> getAllInput() {
//		List<UserInput> userInput = new ArrayList<>();
//		userInputRepository.findAll().forEach(userInput::add);
//		return userInput;
//	};
	
	public Page<UserInput> getAllInputWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userInputRepository.findAll(pageable);
    }
	
	//adding userInput to db
	public void addUserInput(UserInput userInput) {
		userInputRepository.save(userInput);
		
	}

}
