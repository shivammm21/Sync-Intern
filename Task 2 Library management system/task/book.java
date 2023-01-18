package task;

import java.util.Scanner;

public class book {

    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;
    Scanner input = new Scanner(System.in);

    public book(){
        System.out.println("Enter Serial No of Book");
        this.sNo = input.nextInt();
        System.out.println("Enter Book Name");
        this.bookName = input.next();
        System.out.println("Enter Author Name");
        this.authorName = input.next();
        System.out.println("Enter Quantity of Book");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
    
}
