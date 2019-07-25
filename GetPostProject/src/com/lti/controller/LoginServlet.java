package com.lti.controller;

import com.lti.bean.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.view")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String us=request.getParameter("user");
		String ps=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		if(us.equals("Aman") && ps.equals("lntinfotech")) {
			String myemail=us+"1234@lntinfotech.com";
			LoginUser myuser=new LoginUser();
			myuser.setUsername(us);
			myuser.setEmail(myemail);
			//setting data in request object by attribute name, actual object
			request.setAttribute("userdetails", myuser);
			//if login successful go to Bank.jsp
			RequestDispatcher red=request.getRequestDispatcher("Bank.jsp");
			red.forward(request, response); //pass the control to Bank.jsp page
		}
		else {
			//another way of generating RequestDispatcher is use ServletContext which represents web application environment
			ServletContext application=request.getServletContext();
			RequestDispatcher red=application.getRequestDispatcher("/index.html");
			red.include(request, response); //pass the control with request, response and include index.html
			out.println("<font color=red size=4>Unauthorized User</font>");
			out.close();
		}
	}

}
