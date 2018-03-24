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
 * Servlet implementation class Action3
 */
@WebServlet("/ActionAdminOperation")
public class ActionAdminOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionAdminOperation() {
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
		String operationType = request.getParameter("operationType");
		// String s;
		if (operationType.equals("newCustomer")) {
			RequestDispatcher req = request
					.getRequestDispatcher("NewCustomer.jsp");
			req.forward(request, response);

		} else if (operationType.equals("addBranchDetails")) {
			RequestDispatcher req = request
					.getRequestDispatcher("AddBranchDetails.jsp");
			req.forward(request, response);

		} else if (operationType.equals("updateCustomer")) {
			RequestDispatcher req = request
					.getRequestDispatcher("UpdateCustomer.jsp");
			req.forward(request, response);

		} else if (operationType.equals("deleteCustomer")) {
			RequestDispatcher req = request
					.getRequestDispatcher("DeleteAccount.jsp");
			req.forward(request, response);

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
