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

import co.Admin;

/**
 * Servlet implementation class AdminLoginAction
 */
@WebServlet("/AdminLoginAction")
public class AdminLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginAction() {
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

		String userName1 = request.getParameter("userName");
		String password1 = request.getParameter("password");

		try {
			int password = Integer.parseInt(password1);
			Test t = new Test();
			boolean s = t.searchAdmin(password,userName1);
			HttpSession session = request.getSession();

			if (s) {
				session.setAttribute("userName", userName1);
				session.setMaxInactiveInterval(60 * 60);
				RequestDispatcher req = request
						.getRequestDispatcher("LoginAdmin.jsp");
				req.forward(request, response);

			} else if (password1 == "") {
				out.println("Sorry UserName or Password Wrong ");
				RequestDispatcher req1 = request
						.getRequestDispatcher("AdminLogin.jsp");
				req1.include(request, response);
			} else {
				out.println("Sorry UserName or Password Wrong ");
				RequestDispatcher req1 = request
						.getRequestDispatcher("AdminLogin.jsp");
				req1.include(request, response);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			out.println("Sorry UserName or Password Wrong ");
			RequestDispatcher req1 = request
					.getRequestDispatcher("AdminLogin.jsp");
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
