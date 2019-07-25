package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyColorServlet
 */
//@WebServlet("/MyColorServlet")
public class MyColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyColorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String col=request.getParameter("mycolor");
		
		//Generate cookie
		Cookie cob=new Cookie("bgc", col);
		
		//set expire
		cob.setMaxAge(30*24*60*60*1000);
		
		//add cookie in response
		response.addCookie(cob);
		
		PrintWriter out=response.getWriter();
		out.println("<h1>Color Cookie is generated</h1>");
		out.println("<a href='index.html'>Home</a>");
		String url=response.encodeRedirectURL("Demo.jsp?bgc="+col);
		out.println("<a href="+url+">Demo</a>");
		ServletContext application=getServletContext();
		String mycomp=application.getInitParameter("comp");
		String myaddr=application.getInitParameter("addr");
		out.println("<hr>Company is "+mycomp+" Address is "+myaddr);
		String initparam=getInitParameter("myname");
		out.println("<hr>Created By "+initparam);
	}

}
