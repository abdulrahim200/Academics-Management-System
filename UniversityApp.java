package com.iiitk;

import com.iiitk.admin.*;
import com.iiitk.academics.*;
import com.iiitk.faculty.*;
import com.iiitk.student.*;

public class UniversityApp implements University {
	public AdminApp admin = null;
	public AcademicsApp acad = null;
	public FacultyApp fac = null;
	public StudentApp stu = null;

	UniversityApp() {
		System.out.println("\n############################\n");
		System.out.println("\n  WELCOME TO IIIT KOTTAYAM  \n");
		System.out.println("\n############################\n");
	}

	public String display() {
		String ret = "\n############################\n";
		ret += "\n  WELCOME TO IIIT KOTTAYAM  \n";
		ret += "\n############################\n";
		return ret;
	}

	static int showUniversityMenu() {
		System.out.print("\nSelect one : \n\t\t 1. Admin User\n\t\t 2. Academics User\n\t\t 3. Faculty User\n\t\t 4. Student User\n\t\t 0. Exit\n\t:");
		return sc.nextInt();
	}

	public static void main(String ar[]) {
		UniversityApp university = new UniversityApp();

		while (true) {
			int ch = showUniversityMenu();

			switch (ch) {
				case 1:
					if (university.admin == null) {
						university.admin = new AdminApp();
					} else {
						university.admin.display();
					}
					break;
				case 2:
					if (university.acad == null) {
						university.acad = new AcademicsApp(university);
					} else {
						System.out.println("\n--------------------------------------\n");
						System.out.println("\n  Welcome to Academics Dept of IIITK  \n");
						System.out.println("\n--------------------------------------\n");
						university.acad.display();
					}
					break;
				case 3:
					if (university.fac == null) {
						university.fac = new FacultyApp(university);
					} else {
						university.fac.display();
					}
					break;
				case 4 :
					if(university.stu == null)
					{
						university.stu = new StudentApp(university);
					}
					else
					{
						university.stu.display();
					}
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("\n\t====  Invalid Choice  ====\n");
			}
			try {
				Runtime.getRuntime().exec("cls");
			} catch (Exception e) {
				System.out.println("Enter Valid Format");
			}
		
		}
	}
}