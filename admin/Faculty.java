package com.iiitk.admin;
import com.iiitk.*;
public class Faculty extends Person implements University
{
	private int empcode;
	private String department;
	private int experience;
	private int salary;
	private int no_courses;
	Faculty()
	{
		empcode=0;
		department="";
		experience=0;
		salary=0;
		no_courses=0;
	}
	public Faculty(String name, String dob, String emailid, long  mobile, int empcode, String dept, int exp, int sal, int nc)
	{
		super(name, dob, emailid, mobile);
		this.empcode=empcode;
		this.department= dept;
		this.experience=exp;
		this.salary = sal;
		this.no_courses = nc;
	}
	public Faculty(String name, int empcode, String dept)
	{
		this(name, "1-1-1980", "", 0, empcode, dept, 0, 0, 0);
	}
	public Faculty(Faculty f)
	{
		this(f.name, f.dob.toString(),f.emailid, f.mobile, f.empcode, f.department,f.experience, f.salary,f.no_courses );
	}
	public String display()
	{
		return super.display()+"\nEmp Code: "+empcode+"\nDepartment : "+department+"\nExperience : "+experience+"\nSalary : "+salary;
	}
	public int getNoCourses()
	{
		return this.no_courses;
	}
	
	public void setNoCourses(int newNo){
		this.no_courses = newNo;
	}
	public void readData()
	{
		System.out.print("\nEnter  Name : ");String name = sc.next();
		System.out.print("\nEnter  DOB : ");String dob = sc.next();
		System.out.print("\nEnter  Email Id : ");String email = sc.next();
		System.out.print("\nEnter  Mobile : ");long mobile = Long.parseLong(sc.next());
		System.out.print("\nEnter  Emp Code : ");int emp = Integer.parseInt(sc.next());
		System.out.print("\nEnter  Department : ");String dept = sc.next();
		System.out.print("\nEnter  Experience : ");int exp = Integer.parseInt(sc.next());
		System.out.print("\nEnter  Salary : ");int sal = Integer.parseInt(sc.next());
		System.out.print("\nEnter  No of Teaching Courses : ");int nc = Integer.parseInt(sc.next());
		this.name = name;
		this.setDOB(dob);
		this.emailid = email;
		this. mobile = mobile;
		this.empcode= emp;
		this.department = dept;
		this.experience = exp;
		this.no_courses = nc;
		this.salary = sal;
		try {
			Runtime.getRuntime().exec("cls");
			}catch(Exception e) {}
		return;
	}


	void setName(){
		System.out.println("\nEnter the new name : ");
		this.name = University.sc.next();
	}
	void setDOB(){
		System.out.println("\nEnter the new DOB : ");
		this.setDOB(University.sc.next());
	}
	void setEmail(){
		System.out.println("\nEnter the new Email Id : ");
		this.emailid = University.sc.next();
	}
	void setMobile(){
		System.out.println("\nEnter the new Mobile no : ");
		this.mobile = University.sc.nextInt();
	}
	void setEmpcode(){
		System.out.println("\nEnter the new EMP code : ");
		this.empcode = University.sc.nextInt();
	}
	void setDepartement(){
		System.out.println("\nEnter the new Department : ");
		this.department = University.sc.next();
	}
	void setExperience(){
		System.out.println("\nEnter the new Experience : ");
		this.experience = University.sc.nextInt();
	}
	void setCourses(){
		System.out.println("\nEnter the new no of courses : ");
		this.no_courses = University.sc.nextInt();
	}
	void setSalary(){
		System.out.println("\nEnter the new Salary : ");
		this.salary = University.sc.nextInt();
	}

	public void update(){
		System.out.println("\nChoose which data should be updated : \n\t\t 1.Name\n\t\t 2.DOB\n\t\t 3.Email Id\n\t\t 4.Mobile\n\t\t 5.Emp Code\n\t\t 6.Department\n\t\t 7.Experience\n\t\t 8.Salary\n\t\t 9.No of Teaching Courses\n\t\t 10.No change");
		switch(University.sc.nextInt()){
			case 1 : setName();break;
			case 2 : setDOB();break;
			case 3 : setEmail();break;
			case 4 : setMobile();break;
			case 5 : setEmpcode();break;
			case 6 : setDepartement();break;
			case 7 : setExperience();break;
			case 8 : setSalary();break;
			case 9 : setCourses();break;
			case 10 : return;
			default: System.out.println("\n\t#####  Invalid Choice  #####\n");
		}
	}
	
}
