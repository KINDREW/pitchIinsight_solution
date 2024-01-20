package com.pitchinsight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserInputController {
	
	@Autowired
	private UserInputService userInputService;
	
	@RequestMapping("/userinput")
	@GetMapping
    public Page<UserInput> getAllInputs(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "20") int size) {
        return userInputService.getAllInputWithPagination(page, size);
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/userinput")
	public void addUserInput(@RequestBody UserInput userInput) {
		userInputService.addUserInput(userInput);
		
	};

}
