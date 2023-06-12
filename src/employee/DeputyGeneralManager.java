package employee;

import java.util.Scanner;

public class DeputyGeneralManager extends Managers {
	
	public DeputyGeneralManager(EmployeeKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		setEmployeeId(input);
		setEmployeeName(input);
		setStudentEmailwithYN(input);
		setEmployeePhone(input); 
	}
	
}
