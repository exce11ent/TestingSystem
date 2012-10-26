package org.exlnt.model;

import java.util.List;

public class TestingModel {
	private List<Question> questions;
	private int correctCount = 0;
	private int maxQuestions = 5;
	
	public boolean isFinish(int currentQNumber){
		return (currentQNumber < maxQuestions) ? false : true;
	}
}