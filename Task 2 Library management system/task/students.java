package task;
import java.util.*;

public class students {
    Scanner input = new Scanner(System.in);

    student theStudents[]=new student[50];

    student s=new student();

    private Object regNum;

    public static int count = 0;
    public void addStudent(student s2){
        for(int i=0;i<count;i++){
            if(((String) s2.regNum).equalsIgnoreCase(theStudents[i].regNum)){
                System.out.println("Student of Reg Num"+s2.regNum+"is already Registered");
                return;
            }
        }
        if(count<=50){
            theStudents[count]=s2;
            count++;
        }
    }
    public void showAllStudents(){
        System.out.println("Student Name\t\tReg Number\t\tFather Name\t\tContact\t\tUnivercity\t\tCity\t\tBook of Interest");
        for(int i=0;i<count;i++){
            System.out.println(theStudents[i].studentName+"\t\t"+theStudents[i].regNum+"\t\t"+theStudents[i].fname+"\t\t"+theStudents[i].contact+"\t\t"+theStudents[i].uni+"\t\t"+theStudents[i].city+"\t\t"+theStudents[i].bi);
        }
    }
    public int isStudent(){
        System.out.println("Enter Reg Number");
        String regNum = input.nextLine();
        for(int i=0;i<count;i++){
            if(theStudents[i].regNum.equalsIgnoreCase(regNum)){
                return i;
            }
        }
        System.out.println("Student is not registered.");
        System.out.println("Get registered First");
        return -1;
    }
    public void checkOutBook(books ob){
        int studentIndex = this.isStudent();
        if(studentIndex!=-1){
            System.out.println("Checking out");

            books.showAllBooks();
            book b = books.checkOutBook();
            System.out.println("Checking out");
            if(b!=null){
                if(theStudents[studentIndex].booksCount<=3){
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount]=b;
                    theStudents[studentIndex].booksCount++;
                    return;
                }
                else{
                    System.out.println("Student can not Borrow more than 3 books");
                    return;
                }
            }
            System.out.println("Book is not Available");
        }
    }
    public void checkInBook(books ob){
        int studentIndex=this.isStudent();
        if(studentIndex!=-1){
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            student s = theStudents[studentIndex];
            for(int i=0;i<s.booksCount;i++){
                System.out.println(s.borrowedBooks[i].sNo+"\t\t\t"+s.borrowedBooks[i].bookName+"\t\t\t"+s.borrowedBooks[i].authorName);
            }
            System.out.println("Enter Serial Number of Book to be Checked In.");
            int sNo = input.nextInt();
            for(int i=0;i<s.booksCount;i++){
                if(sNo==s.borrowedBooks[i].sNo){
                    books.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i]=null;
                    return;
                }
            }
            System.out.println("Book of Serial No"+sNo+"Not found");
        }
    }
    public void addStudent(students s2) {
    }
    
}
