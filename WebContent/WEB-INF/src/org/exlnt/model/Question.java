package org.exlnt.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	
	@OneToMany(mappedBy="question")
	private Collection<Answer> variants = new ArrayList<Answer>();
	
	private String questionText;
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getQuestionID() {
		return questionId;
	}
	public void setQuestionID(int questionID) {
		this.questionId = questionID;
	}
	public Collection<Answer> getVariants() {
		return variants;
	}
	public void setVariants(Collection<Answer> variants) {
		this.variants = variants;
	}

}
