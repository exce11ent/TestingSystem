package org.exlnt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int answerId;
	private String text;
	private boolean isCorrect;
	@ManyToOne
	@JoinColumn(name="questionId")
	private Question question;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getId() {
		return answerId;
	}
	public void setId(int id) {
		this.answerId = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isRight() {
		return isCorrect;
	}
	public void setRight(boolean isRight) {
		this.isCorrect = isRight;
	}	
}
