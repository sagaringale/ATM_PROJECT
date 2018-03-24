package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.util.HibernateUtl;

/**
 * Servlet implementation class MiniStatement
 */
@WebServlet("/MiniStatement")
public class MiniStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MiniStatement() {
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
		HttpSession session3 = request.getSession(false);
		if (session3 != null) {

			String operationType = request.getParameter("operationType");
			if (operationType.equals("miniStatement")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					int accountNumber = (int) session
							.getAttribute("accountNumber");

					Session session2 = HibernateUtl.getSession();
					Transaction tx = null;
					try {
						tx = session2.beginTransaction();
						Criteria cr = session2
								.createCriteria(co.Transaction.class);
						cr.add(Restrictions.eq("accountNumber", accountNumber));

						List trasanctions = cr.list();

						HttpSession session1 = request.getSession();
						session1.setAttribute("transList", trasanctions);
						Iterator itr1 = trasanctions.iterator();
						session1.setAttribute("trans", trasanctions);
						co.Transaction at;
						while (itr1.hasNext()) {
							at = (co.Transaction) itr1.next();

						}

						RequestDispatcher view = request
								.getRequestDispatcher("MiniStatement.jsp");
						view.include(request, response);

						tx.commit();
					}

					catch (HibernateException e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					} finally {
						session2.close();
					}
				}
			} else {
				out.print("Please login first");
				request.getRequestDispatcher("Login.jsp").include(request,
						response);
			}
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
