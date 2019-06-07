/*
 * Autor: Jaime Ramírez
 * Desarrollo de los metodos CRUD CUSTOMER
 * 23/05/2019
 *
 * */
package com.cds.daoImp;
/*https://www.youtube.com/watch?v=GZ5in9Xpons*/
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.cds.dao.CustomerDao;
import com.cds.model.Customer;
import com.cds.model.Service;
import com.cds.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	private static CustomerDaoImpl customerDaoImpl = null;
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public Long saveCustomer(Customer customer) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(customer);
		transaction.commit();
		session.close();
		return id;		
	}
	
	@Override
	public Customer findCustomerById(Long id) {
		 Session session = this.sessionFactory.openSession();
		 Customer customer = null;
		 try {
			 customer = new Customer();
			 customer = session.load(Customer.class, id);
		} catch (Exception e) {
			 System.out.println("------------null---------");
			 
		}
		
		 return customer;
	}
	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long deleteCustomer(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCustomer_id(id);
		
		long response = 1l;
		
		try {
			
			 session.delete(customer);
			 transaction.commit();
			 
		} catch (Exception e) {
			response = 0l;
			transaction.rollback();
		}finally {
			
			session.clear(); //Investigar sobre esto
			session.close();
		}

		return response;
	}
	@Override
	public Long updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		/*test costumers add*/
		/*CustomerDaoImpl customerdao = new CustomerDaoImpl();
		Customer customer = new Customer("firstName", "lastName", "email@hgj.com", "3456789");
		long resultado = customerdao.saveCustomer(customer);
		System.out.println(resultado);*/
		
		CustomerDaoImpl customerdao = new CustomerDaoImpl();
		customerdao.deleteCustomer(3l);
			
	}
	
	
}
