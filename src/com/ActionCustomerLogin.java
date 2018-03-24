package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syntel.test.Test;

/**
 * Servlet implementation class Action
 */
@WebServlet("/ActionCustomerLogin")
public class ActionCustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ActionCustomerLogin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String accountNumber = request.getParameter("accountNumber");
		int accountNumber1 = Integer.parseInt(accountNumber);

		String accountPin = request.getParameter("accountPin");

		int accountPin1 = Integer.parseInt(accountPin);
		Test t = new Test();
		boolean status = t.searchAccount(accountNumber1, accountPin1);
		HttpSession session = request.getSession();

		if (status) {
			session.setAttribute("accountNumber", accountNumber1);
			session.setMaxInactiveInterval(60 * 60);

			RequestDispatcher req = request
					.getRequestDispatcher("AccountType.jsp");
			req.forward(request, response);

		} else {
			out.println("Sorry AccountNumber or AccountPin Wrong ");
			RequestDispatcher req1 = request.getRequestDispatcher("Login.jsp");
			req1.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
