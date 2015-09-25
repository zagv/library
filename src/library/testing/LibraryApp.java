/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.testing;

import java.util.Scanner;
import library.assignment3.Book;
import library.assignment3.Member;

/**
 *
 * @author zlatkopetrov
 */
public class LibraryApp {
    
    Member member;
    Book book;
    Scanner scan = new Scanner(System.in);
    int id;
    String firstName;
    String lastName; 
    String phone;
    String email;
    
    public LibraryApp(){
        System.out.println("Welcome. Please fill the details for the new member:");
        System.out.print("Enter member ID: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter First Name: ");
        firstName = scan.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = scan.nextLine();
        System.out.print("Enter Phone Number: ");
        phone = scan.nextLine();
        System.out.print("Enter Email: ");
        email = scan.nextLine();
        member = new Member(id, firstName, lastName, phone, email);
        System.out.println("Enter book details:");
        System.out.print("Book title: ");
        String bookTitle = scan.nextLine();
        System.out.print("Book author: ");
        String bookAuthor = scan.nextLine();
        System.out.print("Book ID: ");
        int bookId= scan.nextInt();
        scan.nextLine();
        entrance();
    }
    
    public void entrance()
    {
        System.out.print("Please swipe your membership card: ");
        String cardNumber = scan.nextLine();
        System.out.println("Welcome "+member.getFirstName());
        System.out.println("Your full name: "+member.getFirstName()+" "+member.getLastName());
        System.out.println("Your contact phone: "+member.getContactPhone());
        System.out.println("Your email address: "+member.getEmailAddress());
        bookScan();
    }
    
    public void bookScan(){
        System.out.print("Please scan book's barcode: ");
        String bookCode = scan.nextLine();
    }
}
