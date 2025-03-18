package com.iiitk.admin;
import com.iiitk.*;
class Person implements University
{
	protected String name;
	protected DOB dob;
	protected String emailid;
	protected long mobile;
	Person()
	{
		this.name = "";
		this.dob = new DOB(0,0,0);
		this.emailid = "";
		this.mobile=0;
	}
	Person( String name, String dob, String emailid, long mobile)
	{
		this.name = name;
		this.dob = new DOB(dob);
		this.emailid = emailid;
		this.mobile=mobile;
	}
	Person (String name)
	{
		new Person(name, "1-1-2000", "", 0);
	}
	public String display()
	{
		return "Name : "+name+"\nDOB : "+dob+"\nEmail ID : "+emailid+"\nMobile : "+mobile; 
	}
	void setDOB(String d)
	{
		this.dob=new DOB(d);
	}
	class DOB
	{
		private int day;
		private int month;
		private int year;
		DOB(int day, int month, int year)
		{
			this.day=day; this.month=month;this.year=year;
		}
		DOB(String date)
		{
			if(date.length()>4)
			{
				String intDate[] = date.split("-");
				
				this.day=Integer.parseInt(intDate[0]); 
				this.month=Integer.parseInt(intDate[1]);
				this.year=Integer.parseInt(intDate[2]);
				
			}
			else
				new DOB(1,1,2000);
		}
		public String toString()
		{
			return ""+day+"-"+month+"-"+year;
		}
	}
	public String getName()
	{
		return this.name;
	}
	public String getDOB()
	{
		return this.dob.toString();
	}
	public String getEmailId()
	{
		return this.emailid;
	}
	public long getMobile()
	{
		return this.mobile;
	}
}

