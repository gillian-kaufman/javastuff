package databaseProject;

import java.sql.*;
import java.util.*;

public class Database
{
	//Declare variables for connecting to database
	Connection conn;
	Statement stmt;
	
	//Constructor
	public Database()
	{
		conn = null;
		stmt = null;
	}
	
	//Method to connect to database
	public void connectDB()
	{
		try
		{
			String url = "jdbc:mysql://localhost/registration";
			String username = "root";
			String password = "";
			
			conn = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException e)
		{
			System.out.println("Error: database cannot be accessed");
		}
	}
	
	//Add course to database
	public void addCourse(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean cont = true;
		String code, title;
		
		System.out.print("\nPlease enter course code: ");
		code = input.next();
		input.nextLine();
		
		while (code.length() > 10)
		{
			System.out.print("\nCode entered is too long.\n(Must be 10 characters or less)\nPlease enter course code: ");
			code = input.nextLine();
		}
		while (cont)
		{
			String query = "SELECT * FROM course WHERE code=\"" + code + "\"";			
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next())
			{
				System.out.print("\nCourse already exists in database.\nPlease enter course code: ");
				code = input.nextLine();
			}
			else
			{
				cont = false;
				rs.close();
			}
		}
		code.trim();
		
		System.out.print("\nPlease enter course title: ");
		title = input.nextLine();
		
		while (title.length() > 50)
		{
			System.out.print("\nTitle entered is too long.\n(Must be 50 characters or less)\nPlease enter course title: ");
			title = input.nextLine();
		}
		title.trim();
		
		String query = "INSERT INTO course(code, title) VALUES(\"" + code + "\", \"" + title + "\")";
		stmt.executeUpdate(query);
		System.out.println("Course has been added");
		stmt.close();
	}
	
	//Delete course from database
	public void deleteCourse(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean cont = true;
		String code;
		
		input.nextLine();
		System.out.print("\nPlease enter course code to delete: ");
		code = input.nextLine();
		
		while (cont)
		{
			String query = "SELECT * FROM course WHERE code=\"" + code + "\"";			
			ResultSet rs = stmt.executeQuery(query);
			
			if (!rs.next())
			{
				System.out.print("\nCourse does not exist in database.\nReturning to menu...\n");
				return;
			}
			else
			{
				cont = false;
				rs.close();
			}
		}
		code.trim();
		
		String query = "REMOVE FROM registered(ssn, code, year, semester, grade) WHERE code=\"" + code + "\"";
		stmt.executeUpdate(query);
		query = "REMOVE FROM course(code, title) WHERE code=\"" + code + "\"";
		stmt.executeUpdate(query);
		System.out.println("Course has been deleted");
		stmt.close();
	}
	
	//Add student to database
	public void addStudent(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean cont = true, correctssn = false;
		int ssn = 0;
		String name, address, major;
		input.nextLine();
		
		while (correctssn == false)
		{
			System.out.print("\nPlease enter student's ssn: ");
			try 
			{
				ssn = Integer.parseInt(input.nextLine());
				correctssn = true;
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Error: invalid ssn (must only be numbers or is too long.)\nPlease try again.");
			}
		}
		correctssn = false;
		while (cont)
		{
			String query = "SELECT * FROM student WHERE ssn=" + ssn;			
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next())
			{
				System.out.print("\nStudent already exists in database.\nPlease enter student ssn: ");
				while (correctssn == false)
				{
					try 
					{
						ssn = Integer.parseInt(input.nextLine());
						correctssn = true;
					} 
					catch (NumberFormatException e) 
					{
						System.out.println("Error: invalid ssn (must only be numbers or is too long.)\nPlease try again.");
					}
				}
			}
			else
			{
				cont = false;
				rs.close();
			}
		}
		System.out.print("\nPlease enter student's name: ");
		name = input.nextLine();
		while (name.length() > 50)
		{
			System.out.print("\nName entered is too long.\n(Must be 50 characters or less)\nPlease enter student's name: ");
			name = input.nextLine();
		}
		name.trim();
		System.out.print("\nPlease enter student's full address: ");
		address = input.nextLine();
		while (address.length() > 100)
		{
			System.out.print("\nAddress entered is too long.\n(Must be 100 characters or less)\nPlease enter student's address: ");
			address = input.nextLine();
		}
		address.trim();
		System.out.print("\nPlease enter student's major: ");
		major = input.nextLine();
		while (major.length() > 10)
		{
			System.out.print("\nMajor entered is too long.\n(Must be 10 characters or less)\nPlease enter student's major: ");
			major = input.nextLine();
		}
		major.trim();
		
		String query = "INSERT INTO student(ssn, name, address, major) VALUES(\"" + ssn + "\", \"" + name + "\", \"" + address + "\", \"" + major + "\")";
		stmt.executeUpdate(query);
		System.out.println("Student has been added");
		stmt.close();
	}
	
	//Delete student from database
	public void deleteStudent(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean cont = true, correctssn = false;
		int ssn = 0;
		
		while (correctssn == false)
		{
			System.out.print("\nPlease enter student's ssn to remove: ");
			try 
			{
				ssn = Integer.parseInt(input.nextLine());
				correctssn = true;
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Error: invalid ssn (must only be numbers or is too long.)\nPlease try again.");
			}
		}
		while (cont)
		{
			String query = "SELECT * FROM student WHERE ssn=" + ssn;			
			ResultSet rs = stmt.executeQuery(query);
			
			if (!rs.next())
			{
				System.out.print("\nStudent does not exist in database.\nReturning to menu...\n");
				return;
			}
			else
			{
				cont = false;
				rs.close();
			}
		}
		String query = "REMOVE FROM registered(ssn, code, year, semester, grade) WHERE ssn=\"" + ssn + "\"";
		stmt.executeUpdate(query);
		query = "REMOVE FROM student(ssn, name, address, major) WHERE ssn=\"" + ssn + "\"";
		stmt.executeUpdate(query);
		System.out.println("Student has been deleted");
		stmt.close();
	}
	
	//Register a student for a course in the registered table in database
	public void registerCourse(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean correctssn = false, correctyear = false;
		int ssn = 0, year = 0;
		String code, semester;
		
		input.nextLine();
		while (correctssn == false)
		{
			System.out.print("Please enter student ssn to check registration: ");
			try 
			{
			    ssn = Integer.parseInt(input.nextLine());
			    correctssn = true;
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Error: invalid ssn (must only be numbers or is too long.)\nPlease try again.");
			}
		}
		System.out.print("\nPlease enter course code: ");
		code = input.nextLine();
		while (code.length() > 10)
		{
			System.out.print("\nCode entered is too long.\n(Must be 10 characters or less)\nPlease enter course code: ");
			code = input.nextLine();
		}
		code.trim();
		while (correctyear == false)
		{
			System.out.print("\nPlease enter registration year: ");
			try 
			{
			    year = Integer.parseInt(input.nextLine());
			    correctyear = true;
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Error: invalid year (must only be numbers or is too long.)\nPlease try again.");
			}
		}
		System.out.print("\nPlease enter registration semester: ");
		semester = input.nextLine();
		while (semester.length() > 10)
		{
			System.out.print("\nSemester entered is too long.\n(Must be 10 characters or less)\nPlease enter registration semester: ");
			semester = input.nextLine();
		}
		semester.trim();
		
		String query = "INSERT INTO registered(ssn, code, year, semester, grade) VALUES(\"" + ssn + "\", \"" + code + "\", \"" + year + "\", \"" + semester + "\")";
		stmt.executeUpdate(query);
		System.out.println("Course Registered");
		stmt.close();
	}
	
	//Select all courses a given student is registered for from database
	public void checkRegistration(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean cont = true, correctssn = false;
		int ssn = 0;
		
		input.nextLine();
		while (correctssn == false)
		{
			System.out.print("\nPlease enter student's ssn to check registration: ");
			try 
			{
			    	ssn = Integer.parseInt(input.nextLine());
				correctssn = true;
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Error: invalid ssn (must only be numbers or is too long.)\nPlease try again.");
			}
		}
		correctssn = false;
		while (cont)
		{
			String query = "SELECT * FROM student WHERE ssn=" + ssn;			
			ResultSet rs = stmt.executeQuery(query);
			
			if (!rs.next())
			{
				System.out.print("\nStudent does not exist in database.\nReturning to menu...\n");
				return;
			}
			else
			{
				cont = false;
				rs.close();
			}
		}
		//Show the courses, semesters, and years a student is registered for
		String query = "SELECT code, year, semester FROM registered WHERE ssn=" + ssn;
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("Student " + ssn + " is registered for the following courses: ");
		while (rs.next())
		{
			String code = rs.getString("code");
			String year = rs.getString("year");
			String semester = rs.getString("semester");
			System.out.println("Course: " + code + " Semester: " + semester + " Year: " + year);
		}
		stmt.close();
		rs.close();
	}
	
	//Manually enter grades for each student in a given course in database
	public void uploadGrades(Scanner input) throws SQLException
	{
		connectDB();
		stmt = conn.createStatement();
		
		boolean cont = true, correctyear = false;
		String code = "", semester = "", grade = "";
		int year = 0;
		
		input.nextLine();
		while (cont)
		{
			System.out.print("\nPlease enter course code: ");
			code = input.nextLine();
			
			if (code.length() > 10)
			{
				System.out.print("\nCode entered is too long. (Must be 10 characters or less)\n");
			}
			else
			{
				String query="SELECT code FROM registered WHERE code=\""+ code +"\"";
				ResultSet rs = stmt.executeQuery(query);
				
				if(!rs.next())
				{
					System.out.print("\nError: course does not exist in table.\nReturning to menu...\n");
					return;
				}
				else
				{
					cont = false;
				}
			}
		}
		cont = true;
		while (cont)
		{
			System.out.print("\nPlease enter course semester: ");
			semester = input.nextLine();
			
			if (semester.length() > 10)
			{
				System.out.print("\nSemester entered is too long. (Must be 10 characters or less)\n");
			}
			else
			{
				String query="SELECT semester FROM registered WHERE code=\""+ code +"\" AND semester=\"" + semester + "\"";
				ResultSet rs = stmt.executeQuery(query);
				
				if(!rs.next())
				{
					System.out.print("\nError: semester does not exist for this course.\nReturning to menu...\n");
					return;
				}
				else
				{
					cont = false;
				}
			}
		}
		cont = true;
		while (cont)
		{
			while (correctyear == false)
			{
				System.out.print("\nPlease enter course year: ");
				try 
				{
				    year = Integer.parseInt(input.nextLine());
				    correctyear = true;
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Invalid year.\nPlease try again.");
				}
			}
			String query="SELECT year FROM registered WHERE code=\""+ code +"\" AND semester=\"" + semester + "\" AND year=\"" + year + "\"";
			ResultSet rs = stmt.executeQuery(query);
			
			if(!rs.next())
			{
				System.out.print("\nError: year does not exist for this course.\n");
			}
			else
			{
				cont = false;
			}
		}
		String query = "SELECT ssn FROM registered WHERE code=\"" + code + "\" AND semester=\"" + semester + "\" AND year=\"" + year + "\"";
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<Integer> ssnList = new ArrayList<Integer>(1000);
		
		while (rs.next())
		{
			int ssn = rs.getInt("ssn");
			ssnList.add(ssn);
		}
		for (int i = 0; i < ssnList.size(); ++i)
		{
			int ssn = ssnList.get(i);
			System.out.print("Enter grade (A, B, C, D, or F) for student " + ssn + ": ");
			grade = input.nextLine();
			grade = grade.trim().toUpperCase();
			
			if(grade.contentEquals("A") || grade.contentEquals("B") || grade.contentEquals("C") || grade.contentEquals("D") || grade.contentEquals("F"))
			{
				query = "UPDATE `registered` SET `grade` =\"" + grade + "\" WHERE ssn=" + ssn + " && year=" + year + " && code=\"" + code + "\" && semester=\"" + semester + "\"";
				stmt.executeUpdate(query);
			}
			else
			{
				System.out.print("Error: grade not recognized.\n(Must be A, B, C, D, or F)\n");
			}
		}
		System.out.println("Grades Uploaded");
		query = "SELECT ssn, grade FROM registered WHERE code=\"" + code + "\" AND semester=\"" + semester + "\" AND year=\"" + year + "\"";
		rs = stmt.executeQuery(query);
		while (rs.next())
		{
			System.out.println("Student: " + rs.getInt("ssn") + " Grade: " + rs.getString("grade"));
		}
		rs.close();
		stmt.close();
	}
}
