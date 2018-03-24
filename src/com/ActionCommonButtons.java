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

/**
 * Servlet implementation class ActionCommonButtons
 */
@WebServlet("/ActionCommonButtons")
public class ActionCommonButtons extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionCommonButtons() {
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
		String buttonName = request.getParameter("name");
		// String s;
		if (buttonName.equals("back")) {
			RequestDispatcher req = request
					.getRequestDispatcher("withdraw.jsp");
			req.forward(request, response);

		} else if (buttonName.equals("Menu")) {

			RequestDispatcher req = request
					.getRequestDispatcher("LoginProcess.jsp");
			req.forward(request, response);
		} else if (buttonName.equals("Exit")) {
			HttpSession session = request.getSession();
			session.invalidate();

			out.print("You have  Successfully Completed Transaction!");
			RequestDispatcher req = request.getRequestDispatcher("index.html");
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
