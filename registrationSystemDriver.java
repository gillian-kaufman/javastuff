package databaseProject;

import java.sql.SQLException;
import java.util.Scanner;

public class registrationSystemDriver
{
	public static void main(String args[]) throws SQLException 
	{
		boolean cont = true;
		Database db = new Database();
		Scanner scanner = new Scanner(System.in);
		
		while(cont)
		{
			System.out.println("\n********************************************************************************\n");
			System.out.println("***                                                                          ***\n");
			System.out.println("***                 Welcome to Online Registration System                    ***\n");
			System.out.println("***                                                                          ***\n");
			System.out.println("********************************************************************************");
			System.out.println("1. Add Course");
			System.out.println("2. Delete Course");
			System.out.println("3. Add Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Register Course");
			System.out.println("6. Check Student Registration");
			System.out.println("7. Upload Grades");
			System.out.println("8. Quit");
			System.out.print("Please enter a number: ");
			
			String input=scanner.next();
			
			switch (input)
			{
				case "1":
					db.addCourse(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "2":
					db.deleteCourse(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "3":
					db.addStudent(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "4":
					db.deleteStudent(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "5":
					db.registerCourse(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "6":
					db.checkRegistration(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "7":
					db.uploadGrades(scanner);
					System.out.print("Continue? (Y/N): ");
					input = scanner.next();
					if (input.contentEquals("n") || input.contentEquals("N"))
					{
						cont = false;
						System.out.println("Goodbye");
					}
					break;
				case "8":
					System.out.println("Goodbye");
					cont = false;
					break;
				default:
					System.out.print("ERROR: NOT A OPTION\n");
			}
		}
		scanner.close();
	}
}
