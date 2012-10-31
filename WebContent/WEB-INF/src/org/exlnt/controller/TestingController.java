package org.exlnt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.exlnt.model.Model;
import org.exlnt.model.Question;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Servlet implementation class TestingController
 */
@Controller
public class TestingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml"); 
		Model model = ac.getBean("model", Model.class);
//	
//		if (!session.isNew()) {
//			Integer questionCount = (Integer) session.getAttribute("questionCount");
//			if (questionCount.intValue() < model.getMaxQuestions()) {
//				int answerId = (int) session.getAttribute("radioButton");
//				Question question = (Question) session.getAttribute("question");
//				if (model.isAnswerCorrect(answerId, question.getQuestionID())){
//					int correctCount = (int) session.getAttribute("correctCount");
//					correctCount++;
//					session.setAttribute("correctCount", correctCount);
//				}
//				session.setAttribute("question", model.getQuestion());
//				questionCount++;
//				session.setAttribute("questionCount", questionCount);
//			} else {
//				int mark = model.calcMark((Integer)session.getAttribute("correctCount"));
//				session.setAttribute("finalMark", mark);
//			} 
//			
//		} else {
//			session.setAttribute("questionCount", 0);
//			request.setAttribute("question", model.getQuestion());
//		}
		
		RequestDispatcher view = request.getRequestDispatcher("test.jsp");
		view.forward(request, response);
	}

}
