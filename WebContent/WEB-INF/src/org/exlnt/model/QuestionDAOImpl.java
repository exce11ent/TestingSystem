package org.exlnt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionDAOImpl implements QuestionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	public Question getQuestion(){
		Session session = getSessionFactory().openSession();
		
		Query query = session.createQuery("from Question order by RAND()");
		query.setMaxResults(1);
		
		Collection<Question> cq = new ArrayList<Question>();
		session.beginTransaction();
		
		session.getTransaction().commit();
		cq = query.list();
		
		for (Question qu : cq){
			qu.getQuestionText();
			for (Answer a : qu.getVariants()){
				System.out.println(a.getText());
			}
		}
		
		session.close();
		
		Iterator it = cq.iterator();
		
		return (Question) it.next();
	}
	
	public boolean isAnswerCorrect(Integer answerId, Integer questionId){
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Question Q where questionId = " + questionId.toString());
		query.setMaxResults(1);
		
		Collection<Question> cq = new ArrayList<Question>();
		session.beginTransaction();
		
		session.getTransaction().commit();
		cq = query.list();
		
		Iterator it = cq.iterator();
		Question q = (Question) it.next();
		
		boolean isAnswerRight = false;
		
		for (Question qu : cq){
			for (Answer a : qu.getVariants()){
				if (a.getId() == answerId.intValue())
					isAnswerRight = a.isRight();
			}
		}
		
		session.close();
		
		return isAnswerRight;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
