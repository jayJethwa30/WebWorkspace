package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.bean.Account;
import com.lti.service.AccountService;
import com.lti.service.AccountServiceImpl;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet(urlPatterns= {"/AccountServlet"}, 
	initParams= {
			@WebInitParam(name="minBalance", value="1000.00"),
			@WebInitParam(name="ifsc", value="ABC000123")
	}
)
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
			int i_aid=Integer.parseInt(request.getParameter("aid"));
			String s_aname=request.getParameter("aname");
			
			String s_dob=request.getParameter("dob");
			DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dob=LocalDate.parse(s_dob, df);
			
			double d_bal=Double.parseDouble(request.getParameter("balance"));
			double minbal=Double.parseDouble(getInitParameter("minBalance"));
			if(d_bal<minbal) {
				throw new Exception("Minimum balance should be "+minbal);
			}
			String ifsc=getInitParameter("ifsc");
			System.out.println("IFSC code is "+ifsc);
			
			Account ob=new Account(i_aid, s_aname, dob, d_bal);
			AccountService service=new AccountServiceImpl();
			service.createNewAccount(ob);
			System.out.println(" Account Inserted");
			
			ServletContext application=getServletContext();
			List<Account> mylist=(List<Account>) application.getAttribute("acclist");
			mylist.add(ob);
			application.setAttribute("acclist", mylist);
			
			request.setAttribute("myacc", ob);
			RequestDispatcher red=request.getRequestDispatcher("Success.jsp");
			red.forward(request, response);
			
		} catch(Exception e) {
			String error=e.getMessage();
			request.setAttribute("err", error);
			RequestDispatcher red=request.getRequestDispatcher("InsertAccount.jsp");
			red.forward(request, response);
		}
	}

}
