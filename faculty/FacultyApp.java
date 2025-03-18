package com.iiitk.faculty;

import java.util.Date;
import java.util.HashMap;

import com.iiitk.*;
import com.iiitk.faculty.*;

public class FacultyApp implements University {

    int attendance_list[];
    double mark_list[];
    int index = 0;
    Attendance list = null;
    Marks markslist = null;
    public HashMap<String, Attendance> attendance = new HashMap<String, Attendance>();
    public HashMap<String, Marks> marks = new HashMap<String, Marks>();

    UniversityApp university = null;

    public FacultyApp(UniversityApp university) {
        System.out.println("\n=======================================\n");
        System.out.println("\n  Welcome to Faculty Session of IIITK  \n");
        System.out.println("\n=======================================\n");
        this.university = university;
        display();
    }

    void takeAttendance(int facNo) {
        attendance_list = new int[university.admin.student.length];
        System.out.println("\nSelect a course : ");
        for (int i = 0; i < university.admin.faculty[facNo].getNoCourses(); i++) {
            System.out.println("\n\t\t " + (i + 1) + ". " + university.acad.facultyCourses[facNo].course[i].name);
        }
        int choice = sc.nextInt();
        choice = choice - 1;
        System.out.println("\n\t Subject : " + university.acad.facultyCourses[facNo].course[choice].name);
       
        
        for (int i = 0; i < university.admin.student.length; i++) {
            for (int j = 0; j < university.acad.studentCourses[i].course.length; j++) {
                if (university.acad.studentCourses[i].course[j].name == university.acad.facultyCourses[facNo].course[choice].name) {
                    System.out.print("\n\t\t Name : " + university.admin.student[i].getName()
                            + " Present (Enter 1) | Absent (Enter 0) : ");
                    attendance_list[index] = sc.nextInt();
                    index++;
                    System.out.println(" ");
                    break;
                }
            }
        }
        index = 0;
        if(attendance.get(university.acad.facultyCourses[facNo].course[choice].name)==null){
            list = new Attendance();
        }
        else 
        {
            list = attendance.get(university.acad.facultyCourses[facNo].course[choice].name);
        }
        list.setData(attendance_list, new Date());
        attendance.put(university.acad.facultyCourses[facNo].course[choice].name, list);
    }

    void addMarks(int facNo) 
    {
        mark_list = new double[university.admin.student.length];
        
        System.out.println("\nChoose the course : ");
        for (int i = 0; i < university.admin.faculty[facNo].getNoCourses(); i++) {
            System.out.println("\n\t\t " + (i + 1) + ". " + university.acad.facultyCourses[facNo].course[i].name);
        }
        int choice = sc.nextInt();choice = choice - 1;
        System.out.println("\n\t Subject : " + university.acad.facultyCourses[facNo].course[choice].name);
        
        
        for (int i = 0; i < university.admin.student.length; i++) {
            for (int j = 0; j < university.acad.studentCourses[i].course.length; j++) {
                if (university.acad.studentCourses[i].course[j].name == university.acad.facultyCourses[facNo].course[choice].name) {
                    System.out.print("\n\t\t Name : " + university.admin.student[i].getName()
                            + " Enter the mark : ");
                    mark_list[index] = sc.nextDouble();
                    index++;
                    System.out.println(" ");
                    break;
                }
            }
        }
        
        markslist = new Marks(mark_list,index);
        index = 0;
        marks.put(university.acad.facultyCourses[facNo].course[choice].name,markslist);
        
    }

    void deleteAttentance(int facNo)
    {
        System.out.println("\nChoose a course : ");
        for (int i = 0; i < university.admin.faculty[facNo].getNoCourses(); i++) {
            System.out.println("\n\t\t " + (i + 1) + ". " + university.acad.facultyCourses[facNo].course[i].name);
        }
        int choice = sc.nextInt();
        choice = choice - 1;
        System.out.println("\nSubject : "+university.acad.facultyCourses[facNo].course[choice].name);
        Attendance list = attendance.get(university.acad.facultyCourses[facNo].course[choice].name);

        System.out.println("\n\n\t Choose a date : ");
        for(int i = 0; i<list.total_class;i++){
            System.out.println("\n\t\t "+(i+1)+". "+list.date[i].toString());
        }
        int id = sc.nextInt();id = id -1;
        Attendance a = attendance.get(university.acad.facultyCourses[facNo].course[choice].name);
        Date tempDate = a.date[id];
        int [] tempList = a.list[id];
        for(int i = id;i<a.total_class-1;i++){
            a.date[id] = a.date[id+1];
            a.list[id] = a.list[id+1];a.date[id+1] = tempDate;
            a.list[id+1] = tempList;
        }
        a.total_class = a.total_class-1;
    }

    void deleteMarks(int facNo)
    {
        System.out.println("\nChoose a course : ");
        for (int i = 0; i < university.admin.faculty[facNo].getNoCourses(); i++) {
            System.out.println("\n\t\t " + (i + 1) + ". " + university.acad.facultyCourses[facNo].course[i].name);
        }
        int choice = sc.nextInt();
        choice = choice - 1;
        System.out.println("\nRemoving Subject Marks: "+university.acad.facultyCourses[facNo].course[choice].name);
        
        marks.remove(university.acad.facultyCourses[facNo].course[choice].name);
        
    }

    void updateAttendance(int facNo)
    {
        takeAttendance(facNo);
    }

    void displayAttentance(int facNo) {
        System.out.println("\nChoose a course : ");
        for (int i = 0; i < university.admin.faculty[facNo].getNoCourses(); i++) {
            System.out.println("\n\t\t " + (i + 1) + ". " + university.acad.facultyCourses[facNo].course[i].name);
        }
        int choice = sc.nextInt();choice = choice - 1;
        System.out.println("\nSubject : "+university.acad.facultyCourses[facNo].course[choice].name);
        Attendance list = attendance.get(university.acad.facultyCourses[facNo].course[choice].name);

        System.out.println("\n\n\t Choose a date : ");
        for(int i = 0; i<list.total_class;i++){
            System.out.println("\n\t\t "+(i+1)+". "+list.date[i].toString());
        }
        int id = sc.nextInt();
        id = id -1;
        int count = 0;
        for (int i = 0; i < university.admin.student.length; i++) {
            for (int j = 0; j < university.acad.studentCourses[i].course.length; j++) {
                if (university.acad.studentCourses[i].course[j].name == university.acad.facultyCourses[facNo].course[choice].name) {
                    System.out.println("\n\t\t "+(count + 1)+".Name :  "+university.acad.studentCourses[i].getName()+" ");
                    break;
                }
            }
            if(list.list[id][count]==1){
                System.out.print("\t\t Status :  "+"Present ");
            }
            else {
                System.out.print("\t\t Status :  "+"Absent");
            }

            count++;
            if(count>=list.list[id].length){
                break;  
            }
            
        }

    }

    void displayMarks(int facNo)
    {
        System.out.println("\nChoose a course : ");
        for (int i = 0; i < university.admin.faculty[facNo].getNoCourses(); i++) {
            System.out.println("\n\t\t " + (i + 1) + ". " + university.acad.facultyCourses[facNo].course[i].name);
        }
        int choice = sc.nextInt();
        choice = choice - 1;
        System.out.println("\nSubject : "+university.acad.facultyCourses[facNo].course[choice].name);

        Marks m = marks.get(university.acad.facultyCourses[facNo].course[choice].name);

        int count = 0;
        for (int i = 0; i < university.admin.student.length; i++) {
            for (int j = 0; j < university.acad.studentCourses[i].course.length; j++) {
                if (university.acad.studentCourses[i].course[j].name == university.acad.facultyCourses[facNo].course[choice].name) {
                    System.out.println("\n\t\t "+(count + 1)+". "+university.acad.studentCourses[i].getName()+" ");
                    break;
                }
            }
            System.out.print("\t Marks : "+m.marks[count]);
            count++;
            if(count>=m.count){
                break;
            }
        }
        
    }

    public String display() {
        while (true) {
            System.out.print("\nChoose Your name form the list :");
            for (int i = 0; i < university.admin.faculty.length; i++) {
                System.out.println("\n\t\t " + (i + 1) + ". " + university.admin.faculty[i].getName());
            }
            int facNo = sc.nextInt();
            facNo = facNo - 1;
            System.out.println(
                    "\nEnter your choice\n\t\t 1. Take attendance\n\t\t 2. Add Marks of a Course\n\t\t 3. Update Attendance\n\t\t 4. Update Marks of a Course\n\t\t 5. Display Attendance\n\t\t 6. Display Marks\n\t\t 7. To return to University App ");
            switch (sc.nextInt()) {
                case 1:
                    takeAttendance(facNo);
                    break;
                case 2:
                    addMarks(facNo);
                    break;
                case 3 : updateAttendance(facNo);break;
                case 4 : addMarks(facNo); break;
                case 5 : displayAttentance(facNo); break;
                case 6 : displayMarks(facNo);break;
                case 7:
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
