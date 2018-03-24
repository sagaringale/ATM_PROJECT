package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syntel.test.Test;

import co.Transaction;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/Operation")
public class Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Operation() {
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

		String depositAmount = request.getParameter("depositAmount");

		int depositAmount1 = Integer.parseInt(depositAmount);

		Test t = new Test();
		HttpSession session = request.getSession(false);
		if (session != null) {
			int accountNumber = (int) session.getAttribute("accountNumber");
			int totalBalance = t.depositBalance(accountNumber, depositAmount1);

			Transaction t1 = new Transaction();
			int tId = t1.gettId();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

			Date date = new Date();
			String date1 = dateFormat.format(date);

			String tType = "Deposit";
			t.insertTransaction(tId, tType, depositAmount1, date1,
					accountNumber);

			out.println("==========================  " + "<br>");
			out.println("<br>" + "  CASH DEPOSIT   " + "<br>");
			out.println("==========================  " + "<br>");
			out.println("                                        " + "<br>");
			out.println("Amount :" + depositAmount1
					+ " Successfully Deposited " + "<br>");
			out.println("CurrentBalance is :" + totalBalance + "<br>");
			out.println("");
			request.getRequestDispatcher("withdrawDisplay.jsp").include(
					request, response);
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("Login.jsp")
					.include(request, response);
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
