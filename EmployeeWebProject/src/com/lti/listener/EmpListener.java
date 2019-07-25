package com.lti.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lti.bean.Employee;
import com.lti.service.EmployeeService;
import com.lti.service.EmployeeServiceImpl;

/**
 * Application Lifecycle Listener implementation class EmpListener
 *
 */
@WebListener
public class EmpListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EmpListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("DESTROYED");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("CONTEXT INITIALIZED");
    	EmployeeService service=new EmployeeServiceImpl();
    	List<Employee> elist=service.getAllEmployees();
		ServletContext  application= arg0.getServletContext();
        application.setAttribute("emplist", elist);
    }
	
}
