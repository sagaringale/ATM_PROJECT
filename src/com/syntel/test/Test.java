package com.syntel.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.Account;
import co.Admin;
import co.BankBranch;
import co.Customer;

import com.util.HibernateUtl;

public class Test {

	public boolean insertCustomer(int customerId, String customerName,
			String customerEmail, String contactNumber, String customerAddress,
			Date customerDOB) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Customer c = new Customer();
		c.setCustomerId(customerId);
		c.setCustomerName(customerName);
		c.setCustomerEmail(customerEmail);
		c.setCustomerAddress(customerAddress);
		c.setContactNumber(contactNumber);
		c.setCustomerDOB(customerDOB);

		session.save(c);
		tx.commit();
		session.close();
		System.out.println("Customer Successfully Added");
		return true;

	}

	public boolean insertAccount(int accountNumber, int accountPin,
			String accounttype, int currentAmount) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Account a = new Account();
		a.setAccountNumber(accountNumber);
		a.setAccountPin(accountPin);
		a.setAccounttype(accounttype);
		a.setCurrentAmount(currentAmount);
		session.save(a);
		tx.commit();
		session.close();
		System.out.println("Account Successfully Added");
		return true;

	}

	public boolean insertBranch(int branchId, String branchName,
			String branchAddress) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		BankBranch b = new BankBranch();
		b.setBranchId(branchId);
		b.setBranchName(branchName);
		b.setBranchAddress(branchAddress);
		session.save(b);
		tx.commit();
		session.close();
		System.out.println("Branch Successfully Added");
		return true;

	}

	public boolean deleteCustomer(int customerId) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();

		try {
			tx = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class,
					customerId);
			session.delete(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Customer Successfully deleted");
		return true;

	}

	public boolean updateCustomer(int customerId, String customerAddress,
			String contactNumber) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try {
			Customer customer = (Customer) session.get(Customer.class,
					customerId);
			customer.setContactNumber(contactNumber);
			customer.setCustomerAddress(customerAddress);
			session.update(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Customer Successfully Updated");
		return true;
	}

	public boolean searchCustomer(int customerId) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		boolean status = false;
		try {
			tx = session.beginTransaction();
			List customers = session.createQuery(
					" FROM Customer where c_id=customerId").list();
			for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
				Customer customer = (Customer) iterator.next();
				if (customerId == customer.getCustomerId()) {
					status = true;
				}

			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return status;

	}

	public int checkBalance(int accountNumber) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		int balance = 0;
		try {
			tx = session.beginTransaction();
			List account = session.createQuery(
					"FROM Account where account_no=accountNumber").list();
			for (Iterator iterator = account.iterator(); iterator.hasNext();) {
				Account account1 = (Account) iterator.next();
				if (accountNumber == account1.getAccountNumber()) {
					balance = account1.getCurrentAmount();
					return balance;
				}

			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return balance;
	}

	public int depositBalance(int accountNumber, int amountDeposit) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		int totalbalance = 0;
		tx = session.beginTransaction();
		try {
			Account account = (Account) session.get(Account.class,
					accountNumber);
			Test t = new Test();
			int currentBalance = t.checkBalance(accountNumber);
			totalbalance = currentBalance + amountDeposit;
			account.setCurrentAmount(totalbalance);
			session.update(account);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Account Successfully Deposited");
		return totalbalance;

	}

	public int withdrawBalance(int accountNumber, int amountWithdraw) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		int totalbalance = 0;
		tx = session.beginTransaction();
		try {
			Account account = (Account) session.get(Account.class,
					accountNumber);
			Test t = new Test();
			int currentBalance = t.checkBalance(accountNumber);
			if (currentBalance > amountWithdraw && currentBalance > 0) {
				totalbalance = currentBalance - amountWithdraw;
				account.setCurrentAmount(totalbalance);
				session.update(account);
				tx.commit();
			} else {
				if (currentBalance <= 0) {
					System.out.println("Your Balance is 0");
				} else {
					System.out.println("Insufficient Balance");
					return currentBalance;
				}
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Account Successfully withdraw");
		return totalbalance;
	}

	public boolean searchAccount(int accountNumber, int accountPin) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		boolean status = false;
		try {
			tx = session.beginTransaction();
			List accounts = session.createQuery(
					" FROM Account where account_no=accountNumber").list();
			for (Iterator iterator = accounts.iterator(); iterator.hasNext();) {
				Account account = (Account) iterator.next();
				if (accountNumber == account.getAccountNumber()
						&& accountPin == account.getAccountPin()) {
					status = true;
				}

			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return status;

	}

	public boolean searchAdmin(int adminId, String userName) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		boolean status = false;
		try {
			tx = session.beginTransaction();
			List admins = session.createQuery(" FROM Admin where a_id=adminId")
					.list();
			for (Iterator iterator = admins.iterator(); iterator.hasNext();) {
				Admin admin = (Admin) iterator.next();
				if (adminId == admin.getAdminId()
						&& userName.equals(admin.getAdminName())) {
					status = true;
				}

			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return status;

	}

	public boolean insertTransaction(int tId, String tType, int tamount,
			String tdate, int accountNumber) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		co.Transaction t = new co.Transaction();
		t.settId(tId);
		t.settType(tType);
		t.setTamount(tamount);
		t.setTdate(tdate);
		t.setAccountNumber(accountNumber);
		session.save(t);
		tx.commit();
		session.close();
		System.out.println("Transaction Successfully completed");
		return true;

	}

	public boolean changePin(int accountNo, int newPin) {
		Session session = HibernateUtl.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try {
			Account account = (Account) session.get(Account.class, accountNo);
			account.setAccountPin(newPin);
			session.update(account);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Password Changed Successfully ");
		return true;
	}

}
