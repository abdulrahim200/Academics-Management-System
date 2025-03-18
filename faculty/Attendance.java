package com.iiitk.faculty;

import java.util.Date;

public class Attendance {
    public int [][] list = new int[50][200];
    public Date [] date = new Date[50];
    public int total_class = 0;
    
    void setData(int [] list, Date date)
    {
        this.list[total_class] = list;
        this.date[total_class] = date;
        
        total_class++;
    }
}
