package com.app.connection;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.app.model.Employee;

public class SQLConnection {
	
	private static Session session;
	
	@SuppressWarnings("finally")
	public static Session getConnection() {
		
		try {
			
			Configuration config = new Configuration();
			
			Properties prop = new Properties();
			
			prop.put(Environment.URL, "jdbc:mysql://localhost:3306/employee");
			prop.put(Environment.USER, "root");
			prop.put(Environment.PASS, "root");
			prop.put(Environment.SHOW_SQL, true);
			prop.put(Environment.FORMAT_SQL, true);
			prop.put(Environment.HBM2DDL_AUTO, "update");
			
			config.setProperties(prop);
			config.addAnnotatedClass(Employee.class);
			
			session = config.buildSessionFactory().openSession();
			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			
			return session;
			
		}
		
		
		
		

		
	}

}
