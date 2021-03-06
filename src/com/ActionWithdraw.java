package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.Customer;
import co.Transaction;

import com.syntel.test.Test;

/**
 * Servlet implementation class ActionWithdraw
 */
@WebServlet("/ActionWithdraw")
public class ActionWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionWithdraw() {
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

		String withdrawAmount = request.getParameter("withdrawAmount");
		int withdrawAmount1 = Integer.parseInt(withdrawAmount);
		Test t = new Test();
		HttpSession session = request.getSession(false);
		if (session != null) {
			int accountNumber = (int) session.getAttribute("accountNumber");

			int currentBalance1 = t.checkBalance(accountNumber);
			if (withdrawAmount1 < currentBalance1) {
				Transaction t1 = new Transaction();
				int tId = t1.gettId();
				DateFormat dateFormat = new SimpleDateFormat(
						"dd-MMM-yyyy HH:mm:ss");
				Date date = new Date();
				String date1 = dateFormat.format(date);

				String tType = "Withdraw";
				int currentBalance = t.withdrawBalance(accountNumber,
						withdrawAmount1);
				t.insertTransaction(tId, tType, withdrawAmount1, date1,
						accountNumber);
				out.println("Your Balance remaining is " + currentBalance);

				request.getRequestDispatcher("withdrawDisplay.jsp").include(
						request, response);
			} else {
				out.println("Insufficient Balance  " + "<br>");
				out.println("Your Balance is " + currentBalance1);
			}
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
