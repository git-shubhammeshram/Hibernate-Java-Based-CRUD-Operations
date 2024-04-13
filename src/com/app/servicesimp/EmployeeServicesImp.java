package com.app.servicesimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.connection.SQLConnection;
import com.app.model.Employee;
import com.app.services.EmployeeServices;

public class EmployeeServicesImp implements EmployeeServices {
	
	private Scanner scn = new Scanner(System.in);
	private Session session;
	private String result;
	private Transaction txn;

	@SuppressWarnings("finally")
	@Override
	public String insertEmployee() {
		// TODO Auto-generated method stub
		try {
			
			 session = SQLConnection.getConnection();
			 
			 System.out.println("Enter The Employee ID:-");
			 int id = scn.nextInt();
			 System.out.println("Enter The Employee Name:-");
			 String name = scn.next();
			 System.out.println("Enter The Employee Department:-");
			 String dept = scn.next();
			 System.out.println("Enter The Employee Sallary:-");
			 int sallary = scn.nextInt();
			 
			 txn = session.beginTransaction();
			 
			 int row =(int) session.save(new Employee(id, name, dept, sallary));
			 
			 if(row == row) {
				 
				 result =  "Data Saved";
			 }
			 else {
				 result = "Something Wrong";
			 }
			 
			 txn.commit();
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			return result;
		}
		
		
		
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public String readEmployee() {
		// TODO Auto-generated method stub
		
		try {
			
			session = SQLConnection.getConnection();
			
			System.out.println("Enter The ID:-");
			int id = scn.nextInt();
			
			Employee emp = session.get(Employee.class, id);
			if(emp!=null) {
				result =  emp.getEmp_id()+" "+emp.getEmp_name()+" "+emp.getDept_name()+" "+emp.getEmp_sall();
			}
			else {
				result = "No Data Found";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			return result;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public String readAllEmployee() {
		// TODO Auto-generated method stub
		try {
			 session = SQLConnection.getConnection();
			 
			 Criteria createCriteria = session.createCriteria(Employee.class);
			 List<Employee> list = createCriteria.list();
			 
			 for(Employee li:list) result=li.getEmp_id()+" "+li.getEmp_name()+" "+li.getDept_name()+" "+li.getEmp_sall();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			return result;
		}
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public String updateEmployee() {
		// TODO Auto-generated method stub
		try {
			 session = SQLConnection.getConnection();
			 System.out.println("Enter The ID:-");
			 int id = scn.nextInt();
			 
			 Employee emp = session.get(Employee.class, id);
			 if(emp!=null) {
				 
				 System.out.println("Enter The Employee Name:-");
				 String name = scn.next();
				 System.out.println("Enter The Employee Departmenr:-");
				 String dept = scn.next();
				 System.out.println("Enter The Employee Sallary:-");
				 int sallary = scn.nextInt();
				 
				 txn = session.beginTransaction();
				 
				 emp.setEmp_name(name);
				 emp.setDept_name(dept);
				 emp.setEmp_sall(sallary);
				 
				 session.save(emp);
				 
				 txn.commit();
				 result = "Data Updated";
				 
				 }
			 else {
				 result = "No ID Found";
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			return result;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public String deleteEployee() {
		// TODO Auto-generated method stub
		try {
			 session = SQLConnection.getConnection();
			 System.out.println("Enter The ID:-");
			 int id = scn.nextInt();
			 
			 Employee emp = session.get(Employee.class, id);
			 
			 if(emp!=null) {
				 
				 txn = session.beginTransaction();
				 session.delete(emp);
				 txn.commit();
				 result = "Data Deleted";
			 }
			 else {
				 result = "No ID Found";
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			return result;
		}
		
	}

}
