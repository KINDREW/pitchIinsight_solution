package com.pitchinsight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInput {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inputId;
	private Long input;
	
	public UserInput() {
		
	}
		
	public UserInput(Long inputId, Long input) {
		super();
		this.inputId = inputId;
		this.input = input;
	}
	
	
	public Long getInputId() {
		return inputId;
	}
	public void setInputId(Long inputId) {
		this.inputId = inputId;
	}
	public Long getInput() {
		return input;
	}
	public void setInput(Long input) {
		this.input = input;
	}
	
	
	
	
	
	
	
	
}
