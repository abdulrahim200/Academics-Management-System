package com.iiitk.student;
import com.iiitk.*;
import com.iiitk.faculty.Attendance;
import com.iiitk.faculty.Marks;
import com.iiitk.admin.AdminApp;



public class StudentApp implements University{
    UniversityApp university;
    public StudentApp(UniversityApp university){
        this.university = university;
        display();
    }


    void displayAttentance()
    {
        if(university.admin.student==null)
        {
            System.out.println("\nNo student available , Add throught admin user : ");
            return;
        }
        System.out.println("\nChoose Your name : ");
        for(int i = 0 ; i<university.admin.student.length;i++){
            System.out.println("\n\t\t "+(i+1)+". "+university.admin.student[i].getName());
        }
        int choice = sc.nextInt(); choice = choice-1;
        System.out.println("\n\nChoose a course : ");
        
        for(int i = 0;i<university.acad.studentCourses[choice].getNoCourses();i++){
            System.out.println("\n\t\t "+(i+1)+". "+university.acad.studentCourses[choice].course[i].name);
        }
        int id = sc.nextInt();id = id-1;
        Attendance a = university.fac.attendance.get(university.acad.studentCourses[choice].course[id].name);
        if(a==null){
            System.out.println("\n\n Attendance not found.  ");
            return;
        }
        int index = 0;
        for (int i = 0; i < university.admin.student.length; i++) {
            for (int j = 0; j < university.acad.studentCourses[i].course.length; j++) {
                if (university.acad.studentCourses[i].course[j].name == university.acad.studentCourses[choice].course[id].name) {
                    index++;
                    break;
                }
            }
            if(university.admin.student[choice].getName()==university.admin.student[i].getName()){
                break;
            }
        }
        System.out.println("\n\n\t\t Attendance Status : ");System.out.println("\n\t\t Date : \t\t Status : ");
        for(int i = 0;i<a.date.length;i++){
            System.out.print("\n\t\t "+a.date[index-1].toString());
            if(a.list[i][index-1]==1){
                System.out.print("\t : Present");
            }
            else{
                System.out.print("\t : Absent");
            }
            
        }
    }

    void displayMarks()
    {
        if(university.admin.student==null)
        {
            System.out.println("\nNo student available: ");
            return;
        }
        System.out.println("\nChoose Your name : ");
        for(int i = 0 ; i<university.admin.student.length;i++){
            System.out.println("\n\t\t "+(i+1)+". "+university.admin.student[i].getName());
        }
        int choice = sc.nextInt();choice = choice-1;
        System.out.println("\n\nChoose a course : ");
        for(int i = 0;i<university.acad.studentCourses[choice].course.length;i++){
            System.out.println("\n\t\t "+(i+1)+". "+university.acad.studentCourses[choice].course[i].name);
        }
        int id = sc.nextInt();id = id-1;
        Marks m = university.fac.marks.get(university.acad.studentCourses[choice].course[id].name);

        if(m==null)
        {
            System.out.println("\n\n Marks not found: ");
            return;
        }
        int index = 0;
        for (int i = 0; i < university.admin.student.length; i++) {
            for (int j = 0; j < university.acad.studentCourses[i].course.length; j++) {
                if (university.acad.studentCourses[i].course[j].name == university.acad.studentCourses[choice].course[id].name) {
                    index++;
                    break;
                }
            }
            if(university.admin.student[choice].getName()==university.admin.student[i].getName()){
                break;
            }
        }

        System.out.println("\n\n\t\t Marks Recieved -> "+m.marks[index-1]);
        
    }

    public String display() {
        while (true) {
            System.out.print("\nChoose Your name form the list :");
            for (int i = 0; i < university.admin.student.length; i++) {
                System.out.println("\n\t\t " + (i + 1) + ". " + university.admin.student[i].getName());
            }
            int stuNo = sc.nextInt();
            stuNo = stuNo - 1;
            System.out.println(
                    "\nChoose one :\n\t\t 1. Display Attendance\n\t\t 2. Display Marks\n\t\t 3. To return to University App ");
            switch (sc.nextInt()) {
                case 1 : displayAttentance();break;
                case 2 : displayMarks();break;
                case 3 : return null;
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
