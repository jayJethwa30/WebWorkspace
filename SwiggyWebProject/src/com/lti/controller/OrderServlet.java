 package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.bean.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet.view")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			int pid=Integer.parseInt(request.getParameter("pid"));
			String pname=request.getParameter("pname");
			double price=Double.parseDouble(request.getParameter("price"));
			int quant=Integer.parseInt(request.getParameter("quant"));
			
			double bill=price*quant;
			Order ob=new Order(pid, pname, price, quant);
			ob.setBill(bill);
			
			//code to keep data in session
			HttpSession session=request.getSession();
			session.setAttribute("myorder", ob);
			response.sendRedirect("Bill.jsp");
			
		} catch(Exception e)	{
			String error=e.getMessage();
			RequestDispatcher red=request.getRequestDispatcher("index.html");
			red.include(request, response);
			out.println("<fnt color=red size=4>"+error+"</font>");
			out.close();
		}
	}

}
