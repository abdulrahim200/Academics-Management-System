package com.iiitk.admin;
import com.iiitk.*;
import com.iiitk.academics.*;
public class AdminApp implements University
{
	static int total_students, stu_count;
	static int total_faculty, fac_count;
	public Student student[];
	public Faculty faculty[];
	public boolean dataadded = false;
	public AdminApp(int share){
		
	}
	public AdminApp()
	{
		System.out.println("\n||||||||||||||||||||||||||||||||||\n");
		System.out.println("\n  Welcome to Admin Dept of IIITK  \n");
		System.out.println("\n||||||||||||||||||||||||||||||||||\n");
		
		System.out.print("\nEnter the no of Students : "); total_students = sc.nextInt();
		System.out.print("\nEnter the no of Faculty : "); total_faculty = sc.nextInt();
		this.student = new Student[total_students];
		this.faculty = new Faculty[total_faculty];
		stu_count=0;
		fac_count=0;
		display();
		dataadded = true;
	}
	public void displayStudents()
	{
		for(int i=0;i<stu_count;i++)
			student[i].display();
	}
	void showStudentList()
	{
		if(stu_count==0){
			System.out.println("\nNo  students are present in the list.");  
			return;
		}
		System.out.println("Choose one Student");
		for(int i=0;i<stu_count;i++)
		{
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}

		System.out.print("\n\tYour Choice : "); int id = sc.nextInt();
		System.out.println(student[id-1].display()); 
	}
	void showFacultyList()
	{
		if(fac_count==0){
			System.out.println("\nFaculty list is  empty please try after adding faculty "); 
			return;
		}
		System.out.println("Choose one Faculty");
		for(int i=0;i<fac_count;i++)
		{
			System.out.print("\n\t\t"+(i+1)+". "+faculty[i].getName());
		}
		System.out.print("\n\tYour Choice : "); 
		int id = sc.nextInt();
		id = id-1;
		System.out.println(faculty[id].display());
	}
	
	void UpdateStudentDetails()
	{
		if(stu_count==0){
			System.out.println("\nNo students are present in the list.");  
			return;
		}
		System.out.println("Choose one Student");
		for(int i=0;i<stu_count;i++)
		{
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}
		System.out.print("\n\tYour Choice : "); 
		int id = sc.nextInt();id = id-1;
		student[id].update(); 
	}
	void UpdateFacultyDetails()
	{
		if(fac_count==0){
			System.out.println("\nFaculty list is  empty please try after adding faculty "); 
			return;
		}
		System.out.println("Choose one Faculty");
		for(int i=0;i<fac_count;i++)
		{
			System.out.print("\n\t\t"+(i+1)+". "+faculty[i].getName());
		}
		System.out.print("\n\tYour Choice : "); 
		int id = sc.nextInt();
		id = id-1;
		faculty[id].update();
	}
	void DeleteStudentDetails()
	{
		if(stu_count==0){
			System.out.println("\nNo students are present in the list.");  
			return;
		}
		System.out.println("Choose one Student");
		for(int i=0;i<stu_count;i++)
		{
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}
		System.out.print("\n\tYour Choice : "); 
		int id = sc.nextInt();
		if(id==stu_count){
			stu_count--;
			return;
		}id = id-1;
		Student temp = student[id];
		for(int i = id;i<stu_count-1;i++){
			student[id] = student[id+1];
			student[id+1] = temp;
		}
		stu_count--;
	}
	void DeleteFacultyDetails()
	{
		if(fac_count==0){
			System.out.println("\nFaculty list is  empty please try after adding faculty "); 
			return;
		}
		System.out.println("Choose one Faculty");
		for(int i=0;i<fac_count;i++)
		{
			System.out.print("\n\t\t"+(i+1)+". "+faculty[i].getName());
		}
		System.out.print("\n\tYour Choice : "); 
		int id = sc.nextInt();
		if(id==fac_count){
			fac_count--;
			return;
		}
		id = id-1;
		Faculty temp = faculty[id];
		for(int i = id;i<fac_count-1;i++){
			faculty[id] = faculty[id+1];
			faculty[id+1] = temp;
		}
		fac_count--;

	}
	public String display()
	{
		while(true)
		{
			System.out.print("\n\nChoose any one of the options : \n\t\t 1. Add Student Details\n\t\t 2. Add Faculty Details\n\t\t 3. Display Student Details\n\t\t 4. Display Faculty Details\n\t\t 5. Update Student Details\n\t\t 6. Update Faculty Details\n\t\t 7. Delete Student Details\n\t\t 8. Delete Faculty Details\n\t\t 9. Return to University App:"); //updated_by_q
			switch(University.sc.nextInt())
			{
				case 1 : if(stu_count<total_students)
						 {
							student[stu_count]=new Student(); student[stu_count].readData();
							stu_count++;
						 }
						 else System.out.println("\n\t\tMamximum Students in the App !!\n\n"); break;
				case 2 : if(fac_count<total_faculty)
						 {
							faculty[fac_count]=new Faculty(); faculty[fac_count].readData();
							fac_count++;
						 }
						 else System.out.println("\n\t\tMamximum Faculty in the App !!\n\n");break;
				case 3 : showStudentList(); break;
				case 4 : showFacultyList(); break;
				case 5 : UpdateStudentDetails();break;
				case 6 : UpdateFacultyDetails();break;
				case 7 : DeleteStudentDetails();break;
				case 8 : DeleteFacultyDetails();break;
				case 9 : return null;
				default: System.out.println("\n\t#####  Invalid Choice  #####\n");
			}
			try { Runtime.getRuntime().exec("cls"); }catch(Exception e) {}
		}
	}
}