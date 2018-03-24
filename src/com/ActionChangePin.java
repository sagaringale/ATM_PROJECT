package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syntel.test.Test;

/**
 * Servlet implementation class ActionChangePin
 */
@WebServlet("/ActionChangePin")
public class ActionChangePin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionChangePin() {
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

		String currentPin = request.getParameter("currentPin");
		String newPin = request.getParameter("newPin");
		String newPin1 = request.getParameter("newPin1");
		int currentPin1 = Integer.parseInt(currentPin);
		int newPin2 = Integer.parseInt(newPin);
		int newPin3 = Integer.parseInt(newPin1);
		if (newPin2 == newPin3) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				int accountNumber3 = (int) session
						.getAttribute("accountNumber");

				Test t = new Test();
				boolean status = t.searchAccount(accountNumber3, currentPin1);
				if (status) {

					boolean status1 = t.changePin(accountNumber3, newPin2);
					if (status1) {
						out.println("Password Changed Successfully");
					}
				} else {
					out.println("current Pin is Invalid");
				}

			} else {
				out.print("Please login first");
				request.getRequestDispatcher("Login.jsp").include(request,
						response);
			}
		} else {
			out.println("New Pin and confirm Pin are MisMatched");
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
