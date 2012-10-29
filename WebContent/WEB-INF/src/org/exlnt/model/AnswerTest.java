package org.exlnt.model;


import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class AnswerTest {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}

	@Test
	public void hibTest(){
//		Question q = new Question();
//		Answer ans = new Answer();
//		ans.setRight(false);
//		ans.setText("Coomon text");
//		
//		Answer ans2 = new Answer();
//		ans2.setRight(true);
//		ans2.setText("Random text");
//		
//		q.getVariants().add(ans);
//		q.getVariants().add(ans2);
//		q.setQuestionText("What is the meaning of life?");
//		ans.setQuestion(q);
//		ans2.setQuestion(q);
//		
//		System.out.println(q.getVariants().toString());
		try{
			configureSessionFactory();
			Session session = sessionFactory.openSession();
//			session.beginTransaction();
//			session.save(q);
//			session.save(ans);
//			session.save(ans2);
//			session.getTransaction().commit();
			
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

		} catch (Exception e){
			System.err.append(e.getMessage());
		}
		
		
		
	}

}
