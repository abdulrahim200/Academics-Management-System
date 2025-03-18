package com.iiitk.academics;

import com.iiitk.*;
import com.iiitk.admin.*;

public class AcademicsApp implements University {
	static int total_courses = 0;
	public static int c_count;
	Course course[];
	public StudentCourses studentCourses[];
	public FacultyCourses facultyCourses[];

	static int stu_count, fac_count;
	
	UniversityApp university = null;

	public AcademicsApp(UniversityApp university) {

		System.out.println("\n``````````````````````````````````````\n");
		System.out.println("\n  Welcome to Academics Dept of IIITK  \n");
		System.out.println("\n``````````````````````````````````````\n");
		
		this.university = university;
		if (this.university.admin == null) {
			System.out.print("\n\nStudent and faculty details needed tobe added :");
		}
		
		else {
			System.out.print("\nEnter No of Courses : ");
			total_courses = sc.nextInt();
			this.course = new Course[total_courses];c_count = 0;
			stu_count = this.university.admin.student.length;
			fac_count = this.university.admin.faculty.length;
			studentCourses = new StudentCourses[this.university.admin.student.length];
			facultyCourses = new FacultyCourses[this.university.admin.faculty.length];
			display();
		} 
	}

	public void displayCourses() {
		
		if (c_count == 0) {
			System.out.println("Course list is empty!!!");
			return;
		}
		for (int i = 0; i < c_count; i++)
			System.out.println(course[i].display());
	}

	public void addStudentCourses() {
		System.out.println("Choose a Student");
		for (int i = 0; i < stu_count; i++) {
			System.out.print("\n\t\t" + (i + 1) + ". " + university.admin.student[i].getName());
		}

		System.out.print("\n\tWhat's your Choice : ");int id = sc.nextInt();
		studentCourses[id - 1] = new StudentCourses(university.admin.student[id - 1]);

		System.out.println("\n\nChoose the courses which you want to register : ");
		for (int i = 0; i < c_count; i++) {
			System.out.println("\n\t\t" + (i + 1) + ". " + course[i].name);
		}
		System.out.println("\nChoose " + university.admin.student[id - 1].getNoCourses() + " courses to register :");
		int choice = 0;
		for (int i = 0; i < university.admin.student[id - 1].getNoCourses(); i++) {
			System.out.print("\n\tYour " + (i + 1) + "th Choice : ");
			choice = sc.nextInt();
			choice = choice - 1;
			studentCourses[id - 1].add(course[choice]);
		}

	}

	public void addFacultyCourses() {
		System.out.println("Choose one Faculty");
		for (int i = 0; i < fac_count; i++) {
			System.out.print("\n\t\t" + (i + 1) + ". " + university.admin.faculty[i].getName());
		}

		System.out.print("\n\tYour Choice : ");
		int id = sc.nextInt();
		facultyCourses[id - 1] = new FacultyCourses(university.admin.faculty[id - 1]);

		System.out.println("\n\nChoose the courses which you want to teach : ");
		for (int i = 0; i < c_count; i++) {
			System.out.println("\n\t\t" + (i + 1) + ". " + course[i].name);
		}
		System.out.println("\nChoose " + university.admin.faculty[id - 1].getNoCourses() + " courses to teach :");
		int choice = 0;
		for (int i = 0; i < university.admin.faculty[id - 1].getNoCourses(); i++) {
			System.out.print("\n\tYour " + (i + 1) + "th Choice : ");
			choice = sc.nextInt();choice = choice - 1;
			facultyCourses[id - 1].add(course[choice]);
		}
	}

	void updateStudentCourse() {
		if (studentCourses.length == 0) {
			System.out.println("\nNo courses added, please try after adding it :");
			return;
		}
		System.out.println("\nChoose a student : ");
		for (int i = 0; i < stu_count; i++) {
			System.out.println("\n\t\t " + (i + 1) + ". " + university.admin.student[i].getName());

		}
		System.out.println("\nEnter your choice : ");
		int choice = sc.nextInt();
		choice = choice - 1;
		System.out.println("\nChoose the course to be updated : ");
		for (int i = 0; i < university.admin.student[choice].getNoCourses(); i++) {
			System.out.println("\n\t\t" + (i + 1) + ". " + studentCourses[choice].course[i].name);
		}
		System.out.println("Enter your choice: ");
		int updChoice = sc.nextInt();updChoice = updChoice - 1;
		System.out.println("\n\nChoose the new course :");
		for (int i = 0; i < c_count; i++) {
			System.out.println("\n\t\t " + (i + 1) + ". " + course[i].name);
		}
		System.out.println("\nEnter your choice : ");
		int choicenew = sc.nextInt();choicenew = choicenew - 1;
		studentCourses[choice].course[updChoice] = course[choicenew];
	}

	void updatefacultyCourse() {
		if (facultyCourses[0] == null) {
			System.out.println("\nNo courses added, please try after adding it :");
			return;
		}
		System.out.println("\nChoose a faculty : ");
		for (int i = 0; i < stu_count; i++) {
			System.out.println("\n\t\t " + (i + 1) + ". " + university.admin.faculty[i].getName());

		}
		System.out.println("\nEnter your choice : ");
		int choice = sc.nextInt();
		choice = choice - 1;
		System.out.println("\nChoose the course to be updated : ");
		for (int i = 0; i < university.admin.faculty[choice].getNoCourses(); i++) {
			System.out.println("\n\t\t" + (i + 1) + ". " + facultyCourses[choice].course[i].name);
		}
		System.out.println("Enter your choice: ");
		int updChoice = sc.nextInt();updChoice = updChoice - 1;
		System.out.println("\n\nChoose the new course :");
		for (int i = 0; i < c_count; i++) {
			System.out.println("\n\t\t " + (i + 1) + ". " + course[i].name);
		}
		System.out.println("\nEnter your choice : ");
		int choicenew = sc.nextInt();choicenew = choicenew - 1;
		facultyCourses[choice].course[updChoice] = course[choicenew];
	}

	void deleteStudentCourse() {
		if (studentCourses[0] == null) {
			System.out.println("\nNo courses added, please try after adding it :");
			return;
		}
		System.out.println("\nChoose a faculty : ");
		for (int i = 0; i < stu_count; i++) {
			System.out.println("\n\t\t " + (i + 1) + ". " + university.admin.student[i].getName());

		}
		System.out.println("\nEnter your choice : ");
		int choice = sc.nextInt();
		choice = choice - 1;
		System.out.println("\nChoose the course to be deleted : ");
		for (int i = 0; i < university.admin.student[choice].getNoCourses(); i++) {
			System.out.println("\n\t\t" + (i + 1) + ". " + studentCourses[choice].course[i].name);
		}
		System.out.println("Enter your choice: ");
		int delChoice = sc.nextInt();
		delChoice = delChoice - 1;

		Course temp = studentCourses[choice].course[delChoice];
		for (int i = delChoice; i < studentCourses[choice].getNoCourses() - 1; i++) {
			studentCourses[choice].course[i] = studentCourses[choice].course[i + 1];
			studentCourses[choice].course[i + 1] = temp;
		}

		studentCourses[choice].setNoCourses(studentCourses[choice].getNoCourses() - 1);
		
	}

	void deletefacultyCourse() {
		if (facultyCourses[0] == null) {
			System.out.println("\nNo courses added, please try after adding it :");
			return;
		}
		System.out.println("\nChoose a faculty : ");
		for (int i = 0; i < stu_count; i++) {
			System.out.println("\n\t\t " + (i + 1) + ". " + university.admin.faculty[i].getName());

		}
		System.out.println("\nEnter your choice : ");
		int choice = sc.nextInt();
		choice = choice - 1;
		System.out.println("\nChoose the course to be deleted : ");
		for (int i = 0; i < university.admin.faculty[choice].getNoCourses(); i++) {
			System.out.println("\n\t\t" + (i + 1) + ". " + facultyCourses[choice].course[i].name);
		}
		System.out.println("Enter your choice: ");
		int delChoice = sc.nextInt();
		delChoice = delChoice - 1;

		Course temp = facultyCourses[choice].course[delChoice];
		for (int i = delChoice; i < facultyCourses[choice].getNoCourses() - 1; i++) {
			facultyCourses[choice].course[i] = facultyCourses[choice].course[i + 1];
			facultyCourses[choice].course[i + 1] = temp;
		}

		facultyCourses[choice].setNoCourses(facultyCourses[choice].getNoCourses() - 1);
	}

	public void displayStudentCourses() {
		if (studentCourses.length == 0) {
			System.out.println("\nNo courses added ");
			return;
		}
		for (int i = 0; i < stu_count; i++) {
			System.out.println("\nName : " + university.admin.student[i].getName() + "\n\t\t  Courses");
			for (int j = 0; j < studentCourses[i].course.length; j++) {
				System.out.println("\n\t\t " + (j + 1) + ". " + studentCourses[i].course[j].name);
			}
		}
	}

	
	public void displayFacultyCourses() {
		if (facultyCourses.length == 0) {
			System.out.println("\nNo courses added, please try after adding it ");
			return;
		}
		for (int i = 0; i < fac_count; i++) {
			System.out.println("\nName : " + university.admin.faculty[i].getName());
			for (int j = 0; j < facultyCourses[i].getNoCourses(); j++) {
				System.out.println("\n\t\t" + facultyCourses[i].course[j].name);
			}
		}
	}

	public String display() {

		if (total_courses == 0) {
			System.out.print("\nEnter no of Courses : ");total_courses = sc.nextInt();
			this.course = new Course[total_courses];c_count = 0;
			
			stu_count = this.university.admin.student.length;
			fac_count = this.university.admin.faculty.length;
			studentCourses = new StudentCourses[this.university.admin.student.length];
			facultyCourses = new FacultyCourses[this.university.admin.faculty.length];
			
		}
		
		while (true) {
			System.out.print(
					"\nChoose any one of the below : \n\t\t 1. Add Course Details\n\t\t 2. Display Course Details\n\t\t 3. Add Student-Course Details\n\t\t 4. Add Faculty-Course Details\n\t\t 5. Update Student-Course Details\n\t\t 6. Update Faculty-Course Details\n\t\t 7. Delete Student-Course Details\n\t\t 8. Delete Faculty-Course Details\n\t\t 9. Display Student-Course Details\n\t\t 10. Display Faculty-Course Details\n\t\t 11. Return to University App:");
			switch (sc.nextInt()) {
				case 1:
					if (c_count < total_courses) {
						course[c_count] = new Course();course[c_count].readData();
						c_count++;
					} else
						System.out.println("\nNo of allowed courses over");
					break;
				case 2:
					displayCourses();
					break;
				case 3:
					addStudentCourses();
					break;
				case 4:
					addFacultyCourses();
					break;
				case 5:
					updateStudentCourse();
					break;
				case 6:
					updatefacultyCourse();
					break;
				case 7:
					deleteStudentCourse();
					break;
				case 8:
					deletefacultyCourse();
					break;
				case 9:
					displayStudentCourses();
					break;
				case 10:
					displayFacultyCourses();
					break;
				case 11:
					return null;
				default:
					System.out.println("\n\t#####  Invalid Choice  #####\n");
			}
			try {
				Runtime.getRuntime().exec("cls");
			} catch (Exception e) {
			}
		}
	}
}