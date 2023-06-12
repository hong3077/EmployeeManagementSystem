package employee;

import java.util.Scanner;

import exception.EmailFormatException;

public class AssistantManager extends Managers {
	
	public AssistantManager(EmployeeKind kind) {
		super(kind);
	}
	
	protected String departmentEmail;
	protected String departmentPhone;
	 

	public void getUserInput(Scanner input) {
		setEmployeeId(input);
		setEmployeeName(input);
		setStudentEmailwithYN(input);
		setDepartmentEmailwithYN(input); 
		setEmployeePhone(input);
	}
	public void setDepartmentEmailwithYN(Scanner input) {
		char answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer !='n' && answer !='N') {
			System.out.print("Do you have a department's email address? (Y/N)");
			answer = input.next().charAt(0);
			try {
				if (answer == 'y' || answer == 'Y') {
					setEmployeeEmail(input); 
					break;
				} else if (answer == 'n' || answer == 'N') {
					this.setStaffEmail("");
					break;
				}
			} catch(EmailFormatException e) {
				System.out.println("Incorrect Email Format. Put the Email address that contains @");
			}
		}
	}
}
