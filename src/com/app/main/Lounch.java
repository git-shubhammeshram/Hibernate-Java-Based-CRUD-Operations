package com.app.main;

import java.util.Scanner;

import com.app.servicesimp.EmployeeServicesImp;

public class Lounch {

	static Scanner scn = new Scanner(System.in);
	private static String result;

	public static void main(String[] args) {
		
		EmployeeServicesImp emp = new EmployeeServicesImp();

		while (true) {

			System.out.println(
					"Enter\n 1.InsertData\n 2.ReadData\n 3.ReadAllData\n 4.UpdateData\n 5.DeleteData\n 6.Exit");
			int choice = scn.nextInt();

			if (choice == 6)
				break;

			switch (choice) {
			case 1:
				 result = emp.insertEmployee();
				 System.out.println(result);
				break;

			case 2:
				 result = emp.readEmployee();
				 System.out.println(result);
				break;
			case 3:
				result = emp.readAllEmployee();
				System.out.println(result);
				break;
			case 4:
				result = emp.updateEmployee();
				System.out.println(result);
				break;
			case 5:
				result = emp.deleteEployee();
				System.out.println(result);
				break;
			

			default:
				break;
			}

		}

	}

}
