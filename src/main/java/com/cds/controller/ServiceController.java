package com.cds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;
import com.cds.daoImp.CustomerDaoImpl;
import com.cds.daoImp.ServiceDaoImp;
import com.cds.model.Service;
import com.cds.model.Customer;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class AddServiceController
 */
@WebServlet("/addService")
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceController() {
        super();  
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = ValidateNullPointer.validateToString(request.getParameter("action"));
		switch (action) {
		case "add":
			request.getRequestDispatcher("/Views/Service/addService.jsp").forward(request, response);
			break;
       case "list":
    	   request.getRequestDispatcher("/Views/Service/ListServices.jsp").forward(request, response);
			break;		

		default:
			break;
		}
		//request.getRequestDispatcher("/Views/Service/addService.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CAPTURE DATA
		String service_name = ValidateNullPointer.validateToString(request.getParameter("service"));
		String service_code = ValidateNullPointer.validateToString(request.getParameter("service"));
		String service_description = ValidateNullPointer.validateToString(request.getParameter("description"));
		long customer_id = ValidateNullPointer.validateToLong(request.getParameter("customer"));
		
		ServiceDaoImp serviceDao = new ServiceDaoImp();
		Customer customer = new Customer();
		
		if(service_name.equals("") ||service_code.equals("") || service_description.equals("")||customer_id == 0l) {
			  request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
		}else {
				   customer.setCustomer_id(customer_id);
				   Service service = new Service(service_name, service_code, service_description, customer);
                   //RETURN ID
					long id =  serviceDao.saveService(service);
					
					if(id != 0l) {//VALIDATE SAVE OR NOT SAVE REGISTER
						 request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");  	
					}else {
						request.setAttribute("error", "ERROR: USUARIO INVALIDO");
					}	
		}
		//REDIRECT TO ADDSERVICE.JSP
		request.getRequestDispatcher("./Views/Service/addService.jsp").forward(request, response);

	}

}
