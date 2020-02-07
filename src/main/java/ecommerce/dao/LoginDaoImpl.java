package ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.model.User;



@Component
public class LoginDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public User checkLogin(User user)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where username=:us and password=:pwd");
		query.setParameter("us", user.getUserName());
		query.setParameter("pwd", user.getPassword());
		Object object=query.uniqueResult();
		User user2=(User)object;
		if(user2!=null)
		{
			return user2;
		}
		else
		{
			return null;
		}
	}
}
