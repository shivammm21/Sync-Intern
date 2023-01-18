package task;

import java.util.*;

public class books {
    
    static Scanner input = new Scanner(System.in);

    static book theBooks[] = new book[50];
    public static int count;
    public int compareBookObject(book b1, book b2){
        if(b1.bookName.equalsIgnoreCase(b2.bookName)){
            System.out.println("Book of this Name Already Exists");
            return 0;
        }
        if(b1.sNo==b2.sNo){
            System.out.println("Book of this Serial No already Exist");
            return 0;
        }
        return 1;
    }
    public void addBook(book b){
        for(int i=0;i<count;i++){
            if(this.compareBookObject(b, this.theBooks[i])==0){
                return;
            }
            if(count<50){
                theBooks[count]=b;
                count++;
            }
            else{
                System.out.println("No space to add more books");
            }
        }
    }
    
    public void searchBySno() {
        System.out.println("\t\t\t\tSearch by Serial Number\n");
        int sNo;
        System.out.println("Enter Serial No of book");
        sNo=input.nextInt();

        int flag=0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable qty\t\tTotal qty");
        for(int i=0;i<count;i++){
            if(sNo == theBooks[i].sNo){
                System.out.println(theBooks[i].sNo+"\t\t"+theBooks[i].bookName+"\t\t"+theBooks[i].authorName+"\t\t"+theBooks[i].bookQtyCopy+"\t\t"+theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if(flag==0){
            System.out.println("No book for serial No"+sNo+"Found");
        }
    }
    
    
    public void searchByAuthorName(String authorName) {
        System.out.println("\t\t\t\tSearch by Author Name\n");
        int sNo;
        System.out.println("Enter Author Name");
        sNo = input.nextInt();
     
        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable qty\t\tTotal qty");
        for (int i = 0; i < count; i++) {
            //String authorName;
            if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {
                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" +theBooks[i].authorName+ "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
     
            }
        }
        if (flag == 0) {
            System.out.println("No book of" + authorName + "Found");
        }
    }
     
    public static void showAllBooks() {
        System.out.println("\t\t\t\tShowing All Books\n");
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable qty\t\tTotal qty");
        for(int i=0;i<count;i++){
                System.out.println(theBooks[i].sNo+"\t\t"+theBooks[i].bookName+"\t\t"+theBooks[i].authorName+"\t\t"+theBooks[i].bookQtyCopy+"\t\t"+theBooks[i].bookQty);
        }
    }
    public void upgradeBookQty(){
        System.out.println("\t\t\t\tUpgrade Quantity of a Book\n");
        System.out.println("Enter serial No of Book");
        int sNo = input.nextInt();
        for(int i=0;i<count;i++){
            if(sNo==theBooks[i].sNo){
                System.out.println("Enter No of Books to be Added");
                int addinfQty = input.nextInt();
                theBooks[i].bookQty+=addinfQty;
                theBooks[i].bookQtyCopy+=addinfQty;
                return;
            }
        }
    }
    public void dispMenu(){
        System.out.println("-------------------------------------------");
        System.out.println("Enter 0 to Exit Application");
        System.out.println("Enter 1 to Add to new Book");
        System.out.println("Enter 2 to Update Quantity of a Book");
        System.out.println("Enter 3 to Search a Book");
        System.out.println("Enter 4 to Show All Book");
        System.out.println("Enter 5 to Register Student");
        System.out.println("Enter 6 to Show All Registered Students");
        System.out.println("Enter 7 to Check out Book");
        System.out.println("Enter 8 to Check in Book");
        System.out.println("-------------------------------------------");
    }
    public static int isAvailable(int sNo){
        for(int i=0;i<count;i++){
            if(sNo==theBooks[i].sNo){
                if(theBooks[i].bookQtyCopy>0){
                    System.out.println("Book is Available");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No book of serial Number" + "Available in Library");
        return -1;
    }
    public static book checkOutBook(){
        System.out.println("Enter serial No of Book to be Checked Out");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);
        if(bookIndex!=-1){
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }
    public static void checkInBook(book b){
        for(int i=0;i<count;i++){
            if(b.equals(theBooks[i])){
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }

}
