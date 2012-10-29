package org.exlnt.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Model {
	
	@Autowired
	private QuestionDAO dataAccessObject;

	@Autowired
	private int maxQuestions;
	
	public Question getQuestion() {
		return dataAccessObject.getQuestion();
	}
	
	public boolean isAnswerCorrect(Integer answerId, Integer questionId){
		return dataAccessObject.isAnswerCorrect(answerId, questionId);
	}

	public int getMaxQuestions() {
		return maxQuestions;
	}

	public void setMaxQuestions(int maxQuestions) {
		this.maxQuestions = maxQuestions;
	}
	
	public QuestionDAO getDataAccessObject() {
		return dataAccessObject;
	}

	public void setDataAccessObject(QuestionDAO data) {
		this.dataAccessObject = data;
	}
	

}
