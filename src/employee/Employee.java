package employee;

import java.io.Serializable;
import java.util.Scanner;

import exception.EmailFormatException;

public abstract class Employee implements EmployeeInput, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -492123669349002017L;
	
	protected EmployeeKind kind = EmployeeKind.Director;
	protected String staffName;
	protected int staffId;
	protected String staffEmail;
	protected String staffPhone;
	
	public Employee() {
	}
	
	public Employee(EmployeeKind kind) {
		this.kind=kind;
	}
	public Employee(String staffName, int staffId) {
		this.staffName=staffName;
		this.staffId=staffId;
	}
	
	public Employee(String staffName, int staffId, String staffEmail, String staffPhone) {
		this.staffName=staffName;
		this.staffId=staffId;
		this.staffEmail=staffEmail;
		this.staffPhone=staffPhone;
	}
	
	public Employee(EmployeeKind kind, String staffName, int staffId, String staffEmail, String staffPhone) {
		this.kind=kind;
		this.staffName=staffName;
		this.staffId=staffId;
		this.staffEmail=staffEmail;
		this.staffPhone=staffPhone;
	}
	
	public EmployeeKind getKind() {
		return kind;
	}

	public void setKind(EmployeeKind kind) {
		this.kind = kind;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) throws EmailFormatException {
		if (!staffEmail.contains("@") && !staffEmail.equals("")) {
			throw new EmailFormatException();
		}
		this.staffEmail = staffEmail;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	
	public abstract void printInfo();
	
	public void setEmployeeId(Scanner input) {
		System.out.print("Staff Id: ");
		int staffID = input.nextInt();
		this.setStaffId(staffID);
	}
	public void setEmployeeName(Scanner input) {
		System.out.print("Staff Name: ");
		String staffName = input.next();
		this.setStaffName(staffName);
	}
	public void setEmployeeEmail(Scanner input) {
		String staffEmail = "";
		while (!staffEmail.contains("@")) {
			System.out.print("Staff Email: ");
			staffEmail = input.next();
			try {
				this.setStaffEmail(staffEmail);
			} catch (EmailFormatException e) {
				System.out.println("Incorrect Email Format. Put the Email address that contains @");
			}
		} 
	}
	public void setEmployeePhone(Scanner input) {
		System.out.print("Staff PhoneNumber: ");
		String staffPhone = input.next();
		this.setStaffPhone(staffPhone);
	}
	public String getKindString() {
		String skind = "none";
		switch(this.kind) {
		case Director:
			skind = "BJ.";
			break;
		case DeputyGeneralManager:
			skind = "CJ.";
			break;
		case Manager:
			skind = "GJ.";
			break;
		case AssistantManager:
			skind = "DR.";
			break;
		default:
		}
		return skind;
	}
}

