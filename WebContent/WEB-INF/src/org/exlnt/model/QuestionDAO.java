package org.exlnt.model;

public interface QuestionDAO {
	public Question getQuestion();
	public boolean isAnswerCorrect(Integer answerId, Integer questionId);
}
