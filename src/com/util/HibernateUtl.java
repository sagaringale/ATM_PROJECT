package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtl {
	static SessionFactory sessionFactory;

	public static Session getSession() {
	 
		return new Configuration().configure().buildSessionFactory().openSession();
	}

}
