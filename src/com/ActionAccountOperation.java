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
 * Servlet implementation class Action1
 */
@WebServlet("/ActionAccountOperation")
public class ActionAccountOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionAccountOperation() {
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
		if (operationType.equals("withdraw")) {
			RequestDispatcher req = request
					.getRequestDispatcher("WithdrawOperation.jsp");
			req.forward(request, response);

		} else if (operationType.equals("deposit")) {

			RequestDispatcher req = request.getRequestDispatcher("Deposit.jsp");
			req.forward(request, response);
		} else if (operationType.equals("checkBalance")) {
			RequestDispatcher req = request
					.getRequestDispatcher("CheckBalance.jsp");
			req.forward(request, response);

		} else if (operationType.equals("changePin")) {
			RequestDispatcher req = request
					.getRequestDispatcher("changePin.jsp");
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
