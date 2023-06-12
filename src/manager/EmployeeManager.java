package manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import employee.AssistantManager;
import employee.DeputyGeneralManager;
import employee.Director;
import employee.Employee;
import employee.EmployeeInput;
import employee.EmployeeKind;

public class EmployeeManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8816712537427426325L;
	
	ArrayList<EmployeeInput> employees = new ArrayList<EmployeeInput>();
	transient Scanner input;
	
	EmployeeManager(Scanner input) {
		this.input=input;
	}
	
	public void addEmployee() {
		int kind=0;
		EmployeeInput employeeInput;
		while (kind < 1 || kind > 3) {
			try {
				System.out.println("1 for Director");
				System.out.println("2 for DeputyGeneralManager");
				System.out.println("3 for AssistantManager");
				System.out.print("Select num 1, 2, or 3 for Employee Kind: ");
				kind = input.nextInt();
				if ( kind == 1 ) {
					employeeInput = new Director(EmployeeKind.Director);
					employeeInput.getUserInput(input);
					employees.add(employeeInput);
					break;
				} else if (kind == 2) {
					employeeInput = new DeputyGeneralManager(EmployeeKind.DeputyGeneralManager);
					employeeInput.getUserInput(input);
					employees.add(employeeInput);
					break;
				} else if (kind == 3) {
					employeeInput = new AssistantManager(EmployeeKind.AssistantManager);
					employeeInput.getUserInput(input);
					employees.add(employeeInput);
					break;
				} else {
					System.out.println("Select num for Employee Kind between 1~2: ");
				}
			} catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 3!");
				if (input.hasNext()) {
					input.next(); 
				}
				kind = -1;
			}
		}
	}
	public void deleteEmployee() {
		System.out.print("Staff Id: ");
		int staffId = input.nextInt();
		int index = findIndex(staffId);
		removefromEmployees(index, staffId);
	}
	
	public int findIndex (int staffId) {
		int index = -1;
		for (int i=0;i<employees.size();i++) {
			if (employees.get(i).getStaffId()==staffId) {
				index = i;
				break;
			}
		}
		return index; 
	}
	
	public int removefromEmployees(int index, int staffId) {
		if (index>=0) {
			employees.remove(index);
			System.out.println("the employee "+staffId+" is deleted");
			return 1;
		} else {
			System.out.println("the employee has not been registered");
			return -1;
		}
	}
	
	
	public void editEmployee() {
		System.out.print("Staff Id: ");
		int staffId = input.nextInt();
		for (int i=0;i<employees.size();i++) {
			EmployeeInput employee = employees.get(i);
			if (employee.getStaffId() == staffId) { 
				int num = -1;
				while (num != 5) {
					showEditMenu();
					num = input.nextInt();
					switch(num) {
					case 1:
						employee.setEmployeeId(input);
						break;
					case 2:
						employee.setEmployeeName(input);
						break;
					case 3:
						employee.setEmployeeEmail(input);
						break;
					case 4:
						employee.setEmployeePhone(input);
						break;
					default:
						continue;
					}
				}
				break;
			}
		}
	}
	public void viewEmployees() {
		System.out.println("# of registered	students: "+employees.size());
		for (int i=0;i<employees.size();i++) {
			employees.get(i).printInfo();
		}
	}

	public int size() {	
		return employees.size();
	}
	
	public EmployeeInput get(int index) {
		return (Employee) employees.get(index); 
	}
	
	public void showEditMenu() {
		System.out.println("*** Employee Info Edit Menu ***");
		System.out.println("1. Edit Staff ID");
		System.out.println("2. Edit Staff Name");
		System.out.println("3. Edit Staff Email");
		System.out.println("4. Edit Staff PhoneNumber");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1~5:");
	}
}
