
/*
 * Autor: Jaime Ramírez
 *Configuración de Hibernate Util 
 * 20/05/2019
 *
 * */
package com.cds.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}

		return sessionFactory;
	}
}
