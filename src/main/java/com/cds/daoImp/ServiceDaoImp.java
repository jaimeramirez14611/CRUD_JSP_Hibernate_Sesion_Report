/*
 * Autor: Jaime Ramírez
 * Desarrollo de los metodos CRUD Service
 * 23/05/2019

 * Documentación
 * https://www.onlinetutorialspoint.com/hibernate/hibernate-left-join-example.html
 * 
 * */
package com.cds.daoImp;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.cds.dao.ServiceDao;
import com.cds.model.Customer;
import com.cds.model.Service;
import com.cds.util.HibernateUtil;
import org.hibernate.Query;

public class ServiceDaoImp implements ServiceDao{
    
	private static ServiceDaoImp serviceDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveService(Service service) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = 0l;
		
		try {
			
		    id = (Long)session.save(service);
			transaction.commit();
			
		} catch (Exception e) {
			
			transaction.rollback();
			
		}finally {
			
			session.clear(); //Investigar sobre esto
			session.close();
		}
		
		return id;	
	}
	
	@Override
	public Long deleteService(Long id) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Service service = new Service();
		service.setService_id(id);
		
		long response = 1l;
		
		try {
			
			 session.delete(service);
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
	public Long updateService(Service service) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = 0l;
		
		try {
			
		    session.update(service);
			transaction.commit();
		    id = 1l;
		    
		} catch (Exception e) {
			
			transaction.rollback();
			
		}finally {
			
			session.clear(); //Investigar sobre esto
			session.close();
		}
		
		return id;	
	}
	@Override
	public List<Map<String, String>> findServiceById(Long id) {
		List<Map<String, String>> services = new ArrayList<>();
		Map<String, String> map = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
        	
        	String sql = "SELECT Service.SERVICE_ID, Service.SERVICE_CODE, Service.SERVICE_DESCRIPTION, Service.SERVICE_NAME, Customer.CUSTOMER_ID, Customer.FIRST_NAME, Customer.LAST_NAME, Customer.MOBILE FROM Service INNER JOIN Customer ON Customer.CUSTOMER_ID = Service.CUSTOMER_ID where Customer.CUSTOMER_ID = 1";
	        
        	Query query=  session.createSQLQuery(sql);
	     
	        List<?> list = query.list();
	        Iterator<?> iterator =list.iterator();

	        while(iterator.hasNext()){
	        	
	        	map = new HashMap<>();
	        	 
	            Object rows[] = (Object[])iterator.next();
           
	            map.put("service_id", rows[0].toString());
	            map.put("service_code", rows[1].toString());
	            map.put("service_description", rows[2].toString());
	            map.put("service_name", rows[3].toString());
	            map.put("customer_id", rows[4].toString());
	            map.put("customer_first_name", rows[5].toString());
	            map.put("customer_last_name", rows[6].toString());
	            map.put("customer_mobile", rows[7].toString());
	
	            services.add(map);
	        }
       
        } catch (Exception e) {
        	
        	 
        }finally {
        	session.clear(); //Investigar sobre esto
        	session.close();
        }
        
        return services;
	}

	@Override
	public List<Map<String, String>> findAllService() {

		List<Map<String, String>> services = new ArrayList<>();
		Map<String, String> map = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
        	
        	String sql = "SELECT services.SERVICE_ID, services.SERVICE_CODE, services.SERVICE_DESCRIPTION, services.SERVICE_NAME, customers.CUSTOMER_ID, customers.FIRST_NAME, customers.LAST_NAME, customers.MOBILE FROM services INNER JOIN customers ON customers.CUSTOMER_ID = services.CUSTOMER_ID";
	        
        	Query query=  session.createSQLQuery(sql);
	     
	        List<?> list = query.list();
	        Iterator<?> iterator =list.iterator();

	        while(iterator.hasNext()){
	        	
	        	map = new HashMap<>();
	        	 
	            Object rows[] = (Object[])iterator.next();
           
	            map.put("service_id", rows[0].toString());
	            map.put("service_code", rows[1].toString());
	            map.put("service_description", rows[2].toString());
	            map.put("service_name", rows[3].toString());
	            map.put("customer_id", rows[4].toString());
	            map.put("customer_first_name", rows[5].toString());
	            map.put("customer_last_name", rows[6].toString());
	            map.put("customer_mobile", rows[7].toString());
	
	            services.add(map);
	        }
       
        } catch (Exception e) {
        	
        	 
        }finally {
        	session.clear(); //Investigar sobre esto
        	session.close();
        }
        
        return services;
	}

	public static void main(String[] args) {
		//test  add
		/*ServiceDaoImp servicedao = new ServiceDaoImp();
		Customer customer = new Customer();
		customer.setCustomer_id((long)2);
		Service service = new Service("test","00", "niula",customer );
		long resultado = servicedao.saveService(service);
		System.out.println(resultado);	*/
		
		
		  //test to list
		/*ServiceDaoImp servicedao = new ServiceDaoImp();
		List<Map<String, String>> serice = servicedao.findAllService();
		
		 System.out.println(serice);
		  //test to list find id
		 ServiceDaoImp servicedao = new ServiceDaoImp();
		 List<Map<String, String>> serice = servicedao.findServiceById(1l);
			
		 System.out.println(serice);
		
		//test to delete
		/*ServiceDaoImp servicedao = new ServiceDaoImp();
		long response = servicedao.deleteService(7l);
		System.out.println(response);*/
		
		/*uodate test*/
		/*ServiceDaoImp servicedao = new ServiceDaoImp();
		Customer customer = new Customer();
		customer.setCustomer_id((long)2);
		Service service = new Service(11L, "Mod_test", "101","test_desc", customer);
		long resultado = servicedao.updateService(service);
		System.out.println(resultado);*/
	}



	
	
}
