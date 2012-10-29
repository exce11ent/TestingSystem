package org.exlnt.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml"); 
		QuestionsDAO qd = ac.getBean("QuestionsDAO", QuestionsDAO.class);
		System.out.println(qd.isAnswerCorrect(2, 1));
	}

}
