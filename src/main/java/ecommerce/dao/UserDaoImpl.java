package ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.model.User;

@Component
public class UserDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void testSessionFactory()
	{
		System.out.println("sessionfactory__________"+sessionFactory);
	}
	
	public void InsertUser(User user)
	{
        Session session=sessionFactory.openSession();
        session.save(user);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
        session.close();
	}
}
