package employee;

import java.util.Scanner;

import exception.EmailFormatException;

public abstract class Managers extends Employee {
	
	public Managers(EmployeeKind kind) {
		super(kind);
	}

	public abstract void getUserInput(Scanner input);

	public void printInfo() {
		String skind = getKindString();
		System.out.println("kind: "+skind+", Staff Name: "+staffName+", Staff Id: "+staffId+
				", Staff Email: "+staffEmail+", Staff PhoneNumber: "+staffPhone);
	}

	public void setStudentEmailwithYN(Scanner input) {
		char answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer !='n' && answer !='N') {
			System.out.print("Do you have an email address? (Y/N)");
			answer = input.next().charAt(0);
			try {
				if (answer == 'y' || answer == 'Y') {
					setEmployeeEmail(input); 
					break;
				} else if (answer == 'n' || answer == 'N') {
					this.setStaffEmail("");	
					break;
				} else {	
				}
			} catch(EmailFormatException e) {
				System.out.println("Incorrect Email Format. Put the Email address that contains @");
			}
		}
	}
}
