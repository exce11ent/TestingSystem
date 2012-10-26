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

public class QuestionsDAO {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	public Question getQuestion(){
		configureSessionFactory();
		Session session = sessionFactory.openSession();
		
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
		configureSessionFactory();
		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("from answers A where A.answerId=" + answerId.toString());
//		
//		Collection<Answer> ca = new ArrayList<Answer>();
//		
//		session.beginTransaction();
//		session.getTransaction().commit();
//		ca = query.list();
		
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
}
