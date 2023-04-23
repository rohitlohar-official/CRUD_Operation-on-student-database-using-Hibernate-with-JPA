package com.students.controller;

import java.util.Scanner;

import com.students.dao.Student_DAO;

public class Students_Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Student_DAO student_DAO = new Student_DAO();

		boolean loop = true;
		while (loop) {

			System.out.println("\n enter your choice");
			System.out.println("1. Insert the record");
			System.out.println("2. Displaying All the records");
			System.out.println("3. Displaying the records by id");
			System.out.println("4. Displaying the records by Any Column Name");
			System.out.println("5. Update All the records of 1 Row");
			System.out.println("6. Update the records of 1 Cell");
			System.out.println("7. Delete All the records of 1 Row");
			System.out.println("8. Exit");
			System.out.println("===========================================================");

			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				System.out.println("Enter details of Student");
				student_DAO.insertStudentRecord();
				break;
			case 2:
				System.out.println("Records of all student");
				student_DAO.getAllStudentsRecords();
				break;
			case 3:
				student_DAO.getStudentsRecordById();
				break;
			case 4:
				student_DAO.getStudentsRecord_By_Any_ColumnName();
				break;
			case 5:
				student_DAO.updateRecord_Of_Entire_one_Row();
				break;
			case 6:
				student_DAO.updateRecord_Of_one_Cell();
				break;
			case 7:
				student_DAO.deleteAllRecords_of_Single_Row();
				break;
			case 8:
				System.out.println("Thank you. Visit again.");
				loop = false;
				break;
			default:
				System.out.println("you have enter wrong option");
				break;
			}
		}
	}

}