package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.util.ValidateNullPointer;
import com.cds.daoImp.CustomerDaoImpl;
import com.cds.model.Customer;

/**
 * Servlet implementation class AddCustomerController
 */
@WebServlet("/addCustomer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDao = new CustomerDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = ValidateNullPointer.validateToString(request.getParameter("action"));
		switch (action) {
		case "add":
			request.getRequestDispatcher("/Views/Customer/addCustomer.jsp").forward(request, response);
			break;
       case "list":
    	    request.setAttribute("customerList", customerDao.findAllCustomers());
    	    request.getRequestDispatcher("/Views/Customer/listCustomer.jsp").forward(request, response);
			break;	
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = ValidateNullPointer.validateToString(request.getParameter("first_name"));
		String last_name = ValidateNullPointer.validateToString(request.getParameter("last_name"));
		String email = ValidateNullPointer.validateToString(request.getParameter("email"));
		String mobile = ValidateNullPointer.validateToString(request.getParameter("mobile"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		long customer_id = ValidateNullPointer.validateToLong(request.getParameter("customer_id"));
		System.out.println(option);
		switch (option) {
		case "add":
				if(first_name.equals("") ||last_name.equals("") || email.equals("")||mobile.equals("")) {
					  request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
				}else {
					Customer customer = new Customer(first_name, last_name, email, mobile);
					
				    customerDao.saveCustomer(customer);
					
					request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
				}
				request.getRequestDispatcher("./Views/Customer/addCustomer.jsp").forward(request, response);
			break;
		case "delete":
			 
			
			
			break;
		case "updateredirect":
			 List<Customer> listaCustomer = new ArrayList<Customer>();
             //Objeto                 //Set  datos
             Customer customer = new Customer(customer_id, first_name, last_name, email, mobile);
             //add to list
             listaCustomer.add(customer);
             request.setAttribute("datos", listaCustomer);
             request.getRequestDispatcher("./Views/Customer/updateCustomer.jsp").forward(request, response);
			break;
       case "update_data":
			  
			
			break;	
		default:
			System.out.println(option);
			break;
		}
		
	}
	
}
