/**
 * 
 */
package com.flex.gcp.ExpenseManager.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * @author gssmunej
 *
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory;

	private HibernateUtils() {
		// Default Constructor
	}

	static {
		try {

			Configuration configuration = new Configuration()
					.configure(HibernateUtils.class.getResource("/hibernate.cfg.xml"));
			configuration.addAnnotatedClass(com.flex.gcp.ExpenseManager.entity.ExpenseManager.class);
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Exception exception) {
			System.out.println("Exception occured while loading Session Factory. The Exception is:: " + exception);
		}
	}

	public static SessionFactory getSessionFatory() {
		return sessionFactory;
	}
}
