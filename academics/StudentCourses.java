package com.iiitk.academics;
import com.iiitk.admin.*;
import com.iiitk.*;
public class StudentCourses extends Student implements University
{
	public Course course[];
	private int count;
	private int no_courses;
	StudentCourses(Student s)
	{
		super(s);
		no_courses = s.getNoCourses();
		course = new Course[no_courses];
		count=0;
	}
	public void add(Course c)
	{
		if(no_courses==0)	System.out.println("Choose number of subjects to register in this semester\n");
		if( count<no_courses)
			course[count++] = c;
	}
	public String display()
	{	
		String ret= super.display()+"\nRegistered Courses : \n";
		for(int i=0;i<course.length;i++)
		{
			ret+=course[i].display();
		}
		return ret;
	}
}