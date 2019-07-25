package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.bean.Employee;
import com.lti.service.EmployeeService;
import com.lti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			
			String s_doj=request.getParameter("doj");
			DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate doj=LocalDate.parse(s_doj, df);
			
			int dept=Integer.parseInt(request.getParameter("dept"));
			
			Employee emp=new Employee(id, fname, lname, doj, dept);
			EmployeeService service=new EmployeeServiceImpl();
			service.createNewEmployee(emp);
			out.println("Account Inserted");
			
			ServletContext application=getServletContext();
			List<Employee> mylist=(List<Employee>) application.getAttribute("emplist");
			mylist.add(emp);
			application.setAttribute("emplist", mylist);
			
			request.setAttribute("emp", emp);
			RequestDispatcher red=request.getRequestDispatcher("InsertedSuccessfully.jsp");
			red.forward(request, response);
			
		}
		catch(Exception e) {
			String error=e.getMessage();
			request.setAttribute("err", error);
			RequestDispatcher red=request.getRequestDispatcher("AddEmployee.jsp");
			red.forward(request, response);
		}
	}

}
