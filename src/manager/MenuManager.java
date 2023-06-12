import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		while (num != 6) {
			System.out.println("1. Add Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Edit Employee");
			System.out.println("4. View Employee");
			System.out.println("5. Show a menu");
			System.out.println("6. Exit");
			System.out.print("Select one number between 1~6:");
			num = input.nextInt();
			if (num==1) {
				System.out.print("Student Id: ");
				int studentId = input.nextInt();
				System.out.print("Student Name: ");
				String studentName = input.next();
			}
		}
	}


}
