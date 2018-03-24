package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.Customer;

import com.syntel.test.Test;
import com.util.HibernateUtl;

/**
 * Servlet implementation class Action5
 */
@WebServlet("/ActionNewCustomer")
public class ActionNewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionNewCustomer() {
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
		HttpSession session1 = request.getSession(false);
		if (session1 != null) {

			String customerId = request.getParameter("customerId");

			Test t = new Test();
			int customerId1 = Integer.parseInt(customerId);
			boolean status = t.searchCustomer(customerId1);

			if (status == false) {
				try {

					String customerName = request.getParameter("customerName");
					String customerEmail = request
							.getParameter("customerEmail");
					String customerAddress = request
							.getParameter("customerAddress");
					String customerContactNumber = request
							.getParameter("customerContactNumber");

					String d = request.getParameter("dd");
					String m = request.getParameter("mmm");
					String y = request.getParameter("yyyy");
					String finalDate = m + "/" + d + "/" + y;

					Date date = new Date();
					try {

						SimpleDateFormat format1 = new SimpleDateFormat(
								"MM/dd/yyyy");
						SimpleDateFormat format2 = new SimpleDateFormat(
								"dd-MMM-yyyy");
						date = format1.parse(finalDate);
						String date1 = format2.format(date);
						date = new SimpleDateFormat("DD/MM/YY").parse(date1);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int currentAmount = 1000;
					String accounttype = "Savings";
					boolean result = t.insertCustomer(customerId1,
							customerName, customerEmail, customerContactNumber,
							customerAddress, date);
					if (result) {
						t.insertAccount(customerId1, customerId1, accounttype,
								currentAmount);
						out.println("Customer and Account Successfully Added");
						request.getRequestDispatcher("withdrawFastDisplay.jsp")
								.include(request, response);

					} else {
						out.println("Insertion fail");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				//out.println("Cutomer Id Already Present");
				request.getRequestDispatcher("CustomerAlreadyPresent.jsp").include(request,
						response);
			}
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("AdminLogin.jsp").include(request,
					response);
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
