package employee;

import java.util.Scanner;

public class Director extends Employee {
	
	public Director(EmployeeKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		setEmployeeId(input);
		setEmployeeName(input); 
		setEmployeeEmail(input);
		setEmployeePhone(input); 
	}
	
	public void printInfo() {
		String skind = getKindString();
		System.out.println("kind: "+skind+", Staff Name: "+staffName+", Staff Id: "+staffId+
				", Staff Email: "+staffEmail+", Staff PhoneNumber: "+staffPhone);
	}
}
