package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstLoginAction
 */
@WebServlet("/FirstLoginAction")
public class FirstLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstLoginAction() {
		super();
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
		String name = request.getParameter("name");

		if (name.equals("Customer")) {
			RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			req.forward(request, response);

		} else if (name.equals("Admin")) {
			RequestDispatcher req = request
					.getRequestDispatcher("AdminLogin.jsp");
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
