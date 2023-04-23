	package com.students.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.students.dto.Students_Data;

public class Student_DAO {

	Scanner sc1 = new Scanner(System.in);

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rohit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	
	// insert Student Record
	public void insertStudentRecord() {
	    Students_Data sd = new Students_Data();

	    System.out.print("Enter name :- ");
	    String name = sc1.nextLine().toUpperCase();
	    sd.setName(name);

	    System.out.print("Enter address :- ");
	    String address = sc1.nextLine().toUpperCase();

	    sd.setAddress(address);

	    System.out.print("Enter phone_no :- ");

	    String contact = sc1.nextLine();
	    while (!contact.matches("\\d{10}")) {
	        System.out.print("# Invalid phone number. Please enter a 10-digit phone number:-");
	        contact = sc1.nextLine();
	    }
	    sd.setPhone_no(contact);

	    entityTransaction.begin();
	    entityManager.persist(sd);
	    entityTransaction.commit();
	    System.out.println("Students_Data inserted !");
	}
	
	// get All Students Record 
	public void getAllStudentsRecords() {
		
		String jquer = "Select sd from Students_Data sd";
		Query q = entityManager.createQuery(jquer);
		List<Students_Data> sData = q.getResultList();
		if (sData!= null) {
			System.out.println(sData);
		} else {
			System.out.println("Data is not available");
		}
	}

	// get Students Record By Id
	public void getStudentsRecordById() {
		
		System.out.println("Enter id to find all info of that id");
		int id = Integer.parseInt(sc1.nextLine());
		Students_Data sData = entityManager.find(Students_Data.class, id);
		if (sData != null) {
			System.out.println(sData);
		} else {
			System.out.println("Data is not available");
		}
	}

	// get Students Record By Any Column Name
	public void getStudentsRecord_By_Any_ColumnName() {
		
		System.out.println("Enter Any one Column_Name correctly to find all info of that Row");
		System.out.println(" ");
		System.out.println("1> id");
		System.out.println("2> name");
		System.out.println("3> address");
		System.out.println("4> phone_no");
		System.out.println(" ");
		System.out.println("Enter correct column name from above :-");
		String id = "id";
		String name = "name";
		String address = "address";
		String phoneNo = "phone_no";

		String x = sc1.nextLine();

		if (id.equals(x)) {
			System.out.println(" ");
			System.out.println("Enter the id to search the record:-");
			int i = sc1.nextInt();

			String jpql = "Select sd from Students_Data sd where sd.id=?1";
			Query r = entityManager.createQuery(jpql);

			r.setParameter(1, i);
			List<Students_Data> s = r.getResultList();

			System.out.println(s);
		} else if (name.equals(x)) {
			System.out.println(" ");
			System.out.println("Enter the name to search the record:-");
			String v = sc1.nextLine();
			v = v.toUpperCase();
			String jpql = "Select sd from Students_Data sd where sd.name=?1";
			Query r = entityManager.createQuery(jpql);
			r.setParameter(1, v);
			List<Students_Data> s = r.getResultList();
			System.out.println(s);
			
		} else if (address.equals(x)) {
			System.out.println(" ");
			System.out.println("Enter the address to search the record:-");
			String a = sc1.nextLine();
			a = a.toUpperCase();
			String jpql = "Select sd from Students_Data sd where sd.address=?1";
			Query r = entityManager.createQuery(jpql);
			r.setParameter(1, a);
			List<Students_Data> s = r.getResultList();
			System.out.println(s);
			
		} else if (phoneNo.equals(x)) {
			System.out.println(" ");
			System.out.println("Enter the phoneNo to search the data:-");
			String u = sc1.nextLine();
			String jpql = "Select sd from Students_Data sd where sd.phone_no=?1";
			Query r = entityManager.createQuery(jpql);
			r.setParameter(1, u);
			List<Students_Data> s = r.getResultList();
			System.out.println(s);
			
		} else {
			System.out.println("Enter Column Name correctly");
		}

	}

	// update Record Of Entire 1 Row
	public void updateRecord_Of_Entire_one_Row() {
		

		System.out.println("Enter data to update record of one Row");
		System.out.println(" ");
		System.out.println("Enter id below :- ");
		int id = Integer.parseInt(sc1.nextLine());
		Students_Data sData = entityManager.find(Students_Data.class, id);

		System.out.println("Enter name to update :- ");
		String name = sc1.nextLine().toUpperCase();
		sData.setName(name);

		System.out.println("Enter address to update :- ");
		String address = sc1.nextLine().toUpperCase();
		sData.setAddress(address);

		System.out.println("Enter phone_no to update :- ");
		String phone_no = sc1.nextLine();
		sData.setPhone_no(phone_no);

		entityTransaction.begin();
		entityManager.merge(sData);
		entityTransaction.commit();
	}

	// update Record Of 1 Cell
	public void updateRecord_Of_one_Cell() {
		System.out.print("Enter id below:- ");
		int id = Integer.parseInt(sc1.nextLine());
		Students_Data sData = entityManager.find(Students_Data.class, id);

		System.out.println("Enter any one column to update the record");
		System.out.println("1> name");
		System.out.println("2> address");
		System.out.println("3> phone_no");
		System.out.println(" ");
		System.out.println("Enter correct column name from above :-");

		String update_name = "name";
		String update_address = "address";
		String update_phoneNo = "phone_no";

		String x = sc1.nextLine();
		if (update_name.equals(x)) {

			System.out.println("Enter updated name below :- ");
			String name = sc1.nextLine().toUpperCase();
			sData.setName(name);

		} else if (update_address.equals(x)) {

			System.out.println("Enter updated address below :- ");
			String address = sc1.nextLine().toUpperCase();
			sData.setAddress(address);

		} else if (update_phoneNo.equals(x)) {

			System.out.print("Enter updated phone_no below :- ");
			String phone_no = sc1.nextLine();
			sData.setPhone_no(phone_no);

		}

		entityTransaction.begin();
		entityManager.merge(sData);
		entityTransaction.commit();

	}

	// delete All Record of Single Row
	public void deleteAllRecords_of_Single_Row() {

		System.out.println("Enter id to delete");
		int id_to_delete = Integer.parseInt(sc1.nextLine());
		Students_Data sData = entityManager.find(Students_Data.class, id_to_delete);

		if (sData != null) {
			entityTransaction.begin();
			entityManager.remove(sData);
			entityTransaction.commit();

		} else {
			System.out.println("Data is not present in table");
		}
	}
}
