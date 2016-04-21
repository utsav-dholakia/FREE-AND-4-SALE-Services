package servlet.mvc.rest.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final Session session= buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static Session buildSessionFactory() {
		try {
			System.out.println("Initialised");
			// Create the SessionFactory from hibernate.cfg.xml
			
			return new Configuration().configure().buildSessionFactory().openSession();
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return session;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSession().close();
	}

}