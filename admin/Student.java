package com.iiitk.admin;
import com.iiitk.*;
public class  Student extends Person implements University
{
	protected int rollno;
	protected String branch;
	protected int semester;
	protected int no_courses;
	protected float cgpa;
	
	public Student()
	{
		rollno=0;
		branch="";
		semester=0;
		no_courses=0;
		cgpa=0;
	}
	public Student( String name, String dob, String emailid, long mobile, int rollno, String branch, int sem, int nc, float cgpa)
	{
		super(name, dob, emailid, mobile);
		this.rollno=rollno;
		this.branch=branch;
		this.semester=sem;
		this.no_courses = nc;
		this.cgpa=cgpa;
	}
	public Student(String name, int rollno, String branch)
	{
		this(name, "1-1-2000", "", 0, rollno, branch, 1, 0, 0.0f);
	}
	public Student(Student s)
	{
		this(s.name, s.dob.toString(), s.emailid, s.mobile, s.rollno, s.branch, s.semester, s.no_courses, s.cgpa);
	}
	public int getNoCourses()
	{
		return this.no_courses;
	}

	public void setNoCourses(int newNo)
	{
		this.no_courses = newNo;
	}
	
	public String display()
	{
		return super.display()+"\nRoll No: "+rollno+"\nBranch : "+branch+"\nSemester : "+semester+"\nCGPA : "+cgpa;
	}
	public void readData()
	{
		System.out.print("\nEnter  Name : ");String name = sc.next();
		System.out.print("\nEnter  DOB : ");String dob = sc.next();
		System.out.print("\nEnter  Email Id : ");String email = sc.next();
		System.out.print("\nEnter  Mobile : ");long mobile = Long.parseLong(sc.next());
		System.out.print("\nEnter  Roll No : ");int roll = Integer.parseInt(sc.next());
		System.out.print("\nEnter  Branch : ");String branch = sc.next();
		System.out.print("\nEnter  Semester : ");int sem = Integer.parseInt(sc.next());
		System.out.print("\nEnter  No of Courses : ");int nCou = Integer.parseInt(sc.next());
		System.out.print("\nEnter  CGPA : ");float cgpa = Float.parseFloat(sc.next());  //update_by_q
		this.name = name;
		this.setDOB(dob);
		this.emailid = email;
		this. mobile = mobile;
		this.rollno= roll;
		this.branch = branch;
		this.semester = sem;
		this.no_courses = nCou;
		this.cgpa = cgpa;
		try { Runtime.getRuntime().exec("cls"); }catch(Exception e) {}
		return;
	}
  
	void setName(){
		System.out.println("\nEnter the new name : ");
		this.name = University.sc.next();
		System.out.println(name);
	}
	void setDOB(){
		System.out.println("\nEnter the new DOB : ");
		this.setDOB(University.sc.next());
	}
	void setEmail(){
		System.out.println("\nEnter the new Email Id : ");
		String email = University.sc.next();
		
		emailid = email;
	}
	void setMobile(){
		System.out.println("\nEnter the new Mobile no : ");
		this.mobile = University.sc.nextInt();
	}
	void setBranch(){
		System.out.println("\nEnter the new branch name : ");
		this.branch = University.sc.next();
	}
	void setSemester(){
		System.out.println("\nEnter the new Semester : ");
		this.semester = University.sc.nextInt();
	}
	void setCourses(){
		System.out.println("\nEnter the new no of courses : ");
		this.no_courses = University.sc.nextInt();
	}
	void setCGPA(){
		System.out.println("\nEnter the new CGPA : ");
		this.cgpa = University.sc.nextFloat();
	}

	public void update(){
		System.out.println("\nChoose which data should be updated : \n\t\t 1.Name\n\t\t 2.DOB\n\t\t 3.Email Id\n\t\t 4.Mobile\n\t\t 5.Branch\n\t\t 6.Semester\n\t\t 7.No of Courses\n\t\t 8.CGPA\n\t\t 9.No change");
		switch(University.sc.nextInt()){
			case 1 : setName();break;
			case 2 : setDOB();break;
			case 3 : setEmail();break;
			case 4 : setMobile();break;
			case 5 : setBranch();break;
			case 6 : setSemester();break;
			case 7 : setCourses();break;
			case 8 : setCGPA();break;
			case 9 : return;
			default: System.out.println("\n\t$$$$$  Invalid Choice  $$$$$\n");
		}
		try { Runtime.getRuntime().exec("cls"); }catch(Exception e) {}
	}
	
}