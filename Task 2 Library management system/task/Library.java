package task;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

/**
 * Library
 */
public class Library {

    public static void main(String[] args)throws IOException {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Login Username");
        String username = input.next();
        System.out.println("Password");
        String password = input.next();

        if(username.equals("admin")&&password.equals("123")){
            System.out.println("Access Granted welcome!");
            LocalDate dt = LocalDate.now();
            dt=LocalDate.now();
            System.out.println(dt);
            try(PrintWriter out = new PrintWriter("Library Details.txt")){
                System.out.println("***Welcome to the Library***");
                System.out.println("Please select From the following options");
                System.out.println("******************************************");

                books ob = new books();
                students obStudent = new students();
                int choice;
                int searchChoice;
                do{
                    ob.dispMenu();
                    choice=input.nextInt();
                    switch(choice){
                        case 1:
                            book b = new book();
                            ob.addBook(b);
                            break;
                        case 2:
                            ob.upgradeBookQty();
                            break;
                        case 3:
                            System.out.println("Enter 1 to Search with Serial No.");
                            System.out.println("Enter 2 to Search with Author Name(Full Name");
                            searchChoice=input.nextInt();
                            switch(searchChoice){
                                case 1:
                                    ob.searchBySno();
                                    break;
                                case 2:
                                    System.out.println("Enter Author Name");
                                    String authorName=input.nextLine();
                                    ob.searchByAuthorName(authorName);
                            }
                            break;
                        case 4:
                            ob.showAllBooks();
                            out.println(ob);
                            break;
                        case 5:
                            students s =new students();
                            obStudent.addStudent(s);
                            break;
                        case 6:
                            obStudent.showAllStudents();
                            out.println(ob);
                            break;
                        case 7:
                            obStudent.checkOutBook(ob);
                            out.println(ob);
                            break;
                        case 8:
                            obStudent.checkInBook(ob);
                            out.println(obStudent);
                            break;
                        case 0:
                            System.out.println("Thank You for Visiting library");
                            break;
                        default:
                            System.out.println("Choice Should be between 0 to 8");
                    }
                }while(choice!=0);
            }
        }
        else if(username.equals("admin")){
            System.out.println("Invalid password");
        }
        else if(password.equals(123)){
            System.out.println("Invalid username");
        }
        else{
            System.out.println("Invalid username and password");
        }
    }
}