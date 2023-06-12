package manager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import gui.WindowFrame;
import log.EventLogger;

public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt");

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		EmployeeManager employeeManager = getObject("studentManager.ser");//new EmployeeManager(input)
		if (employeeManager==null) {
			employeeManager = new EmployeeManager(input);
		}
		WindowFrame frame = new WindowFrame(employeeManager);
		selectMenu(input, employeeManager);	
		putObject(employeeManager, "studentManager.ser");
		System.out.println("System End!");
	}
	
	public static void selectMenu(Scanner input, EmployeeManager employeeManager) {
		int num = -1;
		while (num != 5) {
			try {
				showMenu();
				num = input.nextInt();
				switch(num) {
				case 1:
					employeeManager.addEmployee();
					logger.log("add an employee");
					break;
				case 2:
					employeeManager.deleteEmployee();
					logger.log("delete an employee");
					break;
				case 3:
					employeeManager.editEmployee();
					logger.log("edit an employee");
					break;
				case 4:
					employeeManager.viewEmployees();
					logger.log("edit a list of employee");
					break;
				default:
					continue;
				}
			} catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if (input.hasNext()) {
					input.next(); 
				}
				num = -1;
			}
	}
}
	public static void showMenu() {
		System.out.println("*** Employee Management System Menu ***");
		System.out.println("1. Add Employee");
		System.out.println("2. Delete Employee");
		System.out.println("3. Edit Employee");
		System.out.println("4. View Employees");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1~5:");
	}
	public static EmployeeManager getObject(String fileName) {
		EmployeeManager employeeManager = null;
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			employeeManager = (EmployeeManager) in.readObject();
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return employeeManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return employeeManager;
	}
	public static EmployeeManager putObject(EmployeeManager employeeManager, String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(employeeManager);
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeManager;
	}
}