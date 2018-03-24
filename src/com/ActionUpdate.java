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
 * Servlet implementation class ActionUpdate
 */
@WebServlet("/ActionUpdate")
public class ActionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionUpdate() {
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
		try {
			String customerId = request.getParameter("customerId");
			int customerId1 = Integer.parseInt(customerId);
			Test t = new Test();
			boolean status = t.searchCustomer(customerId1);
			HttpSession session = request.getSession(false);
			if (session != null) {
				if (status) {

					String customerAddress = request
							.getParameter("customerAddress");
					String contactNumber = request
							.getParameter("contactNumber");

					boolean result = t.updateCustomer(customerId1,
							customerAddress, contactNumber);
					if (result) {
						out.println("Account Successfully Updated");
						request.getRequestDispatcher("withdrawFastDisplay.jsp")
								.include(request, response);

					} else {
						out.println("Updation fail");
					}
				} else {
					//out.println("Cutomer Id is Not Present");
					request.getRequestDispatcher("CustomerUpdateFail.jsp").include(request,
							response);
				}
			} else {
				out.print("Please login first");
				request.getRequestDispatcher("AdminLogin.jsp").include(request,
						response);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
