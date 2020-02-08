package ecommerce.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.model.Product;

@Component
public class ProductDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void InsertProduct(Product product)
	{
		
		Session session=sessionFactory.openSession();
		session.save(product);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	public List getProducts()
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		 Query query=session.createQuery("from Product");
		 List list=query.list();
		 for(Object object:list)
		 {
			 Product pro=(Product)object;

		 }
		 session.close();
		return list;
	}
	public Product getProduct(int proId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where productId=:id");
		query.setParameter("id", proId);
		Product product=(Product)query.uniqueResult();
		session.close();
		return product;
	}
	
	public Product deleteProduct(int proId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where productId=:proid");
		query.setParameter("proid", proId);
		Product product=(Product)query.uniqueResult();
		session.delete(product);
        Transaction transaction=session.beginTransaction();
        transaction.commit();
		session.close();
		return product;
	}
}
