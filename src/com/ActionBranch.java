package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syntel.test.Test;

/**
 * Servlet implementation class ActionBranch
 */
@WebServlet("/ActionBranch")
public class ActionBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionBranch() {
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

			try {
				String branchId = request.getParameter("branchId");
				String branchName = request.getParameter("branchName");
				String branchAddress = request.getParameter("branchAddress");

				Test t = new Test();
				int branchId1 = Integer.parseInt(branchId);

				boolean result = t.insertBranch(branchId1, branchName,
						branchAddress);
				if (result) {
					out.println("Branch Successfully Added");
					request.getRequestDispatcher("withdrawFastDisplay.jsp")
							.include(request, response);
				} else {
					out.println("Insertion fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
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
