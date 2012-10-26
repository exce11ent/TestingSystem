package org.exlnt.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class QDAOTest {

	@Test
	public void testIsAnswerCorrect() {
		QuestionsDAO qdao = new QuestionsDAO();
		assertTrue(qdao.isAnswerCorrect(2, 1)); 
		assertFalse(qdao.isAnswerCorrect(1, 1));
	}
}
