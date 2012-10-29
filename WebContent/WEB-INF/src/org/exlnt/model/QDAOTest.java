package org.exlnt.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QDAOTest {

	@Test
	public void testIsAnswerCorrect() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml"); 
		QuestionsDAO qd = ac.getBean("QuestionsDAO", QuestionsDAO.class);
		assertTrue(qd.isAnswerCorrect(2, 1)); 
		assertFalse(qd.isAnswerCorrect(1, 1));
	}
}
