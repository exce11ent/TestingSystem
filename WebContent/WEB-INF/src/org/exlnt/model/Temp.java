package org.exlnt.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml"); 
		Model model = ac.getBean("model", Model.class);
		System.out.println(model.isAnswerCorrect(2, 1));
		System.out.println(model.calcMark(3));
	}

}
