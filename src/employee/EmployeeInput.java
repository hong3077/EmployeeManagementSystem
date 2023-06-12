package employee;

import java.util.Scanner;

import exception.EmailFormatException;

public interface EmployeeInput {
	public int getStaffId();
	public void setStaffId(int StaffId);
	public String getStaffName();
	public void setStaffName(String StaffName);
	public String getStaffEmail();
	public void setStaffEmail(String StaffEmail) throws EmailFormatException;
	public String getStaffPhone();
	public void setStaffPhone(String StaffPhone);
	public void getUserInput(Scanner input);
	public void printInfo();
	public void setEmployeeId(Scanner input);
	public void setEmployeeName(Scanner input);
	public void setEmployeeEmail(Scanner input);
	public void setEmployeePhone(Scanner input);
}
