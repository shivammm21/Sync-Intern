package task;

import java.util.*;

public class student {
    Scanner input = new Scanner(System.in);

    String studentName, address, city, uni, bi;
    String regNum, fname;
    int contact;

    book borrowedBooks[]=new book[3];
    public int booksCount=0;
    
    public student(){
        System.out.println("Enter Student Name");
        this.studentName=input.nextLine();
        System.out.println("Enter Reg Number");
        this.regNum = input.nextLine();
        System.out.println("Enter Father Name");
        this.studentName = input.nextLine();
        System.out.println("Enter Contact");
        this.contact = input.nextInt();
        System.out.println("Enter Univercity Name");
        this.uni = input.next();
        System.out.println("Enter City Name");
        this.city = input.next();
        System.out.println("Book of Interest");
        this.bi = input.next();
        

    }

    public void addStudent(students s) {
    }

}
