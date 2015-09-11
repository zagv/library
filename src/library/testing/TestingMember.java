/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.testing;

import java.util.Scanner;
import library.assignment3.Member;

/**
 *
 * @author zlatkopetrov
 */
public class TestingMember {
    Member member;
    Scanner scan = new Scanner(System.in);
    int id;
    String firstName;
    String lastName; 
    String phone;
    String email;

    public TestingMember() {
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
        menu();
    }
    
    private void menu(){
        System.out.println("Select option:");
        System.out.println("1 - Display member details");
        System.out.println("2 - Add loan");
        System.out.println("3 - Remove Loan");
        System.out.println("4 - Display Fines Amount");
        System.out.println("5 - Pay Fine");
        System.out.println("6 - Add Fine");
        System.out.println("0 - Exit");
        System.out.print("Pick from the options: ");
        int option = scan.nextInt();
        scan.nextLine();
        switch (option){
            case 0: exitProgram();
                break;
            case 1: System.out.print(member.toString());
            System.out.println();
            menu();
                break;
            case 2: addLoan();
                break;
            case 3: menu();
                break;
            case 4: 
                System.out.println();
                System.out.println("Fine amount is: "+member.getFineAmount());
                System.out.println();
                menu();
                break;
            case 5: payFine();
                break;
            case 6: addFine();
        }
    }
    
    private void exitProgram(){
        System.out.println("Thank you for using this program.");
        System.exit(0);
    }
    private void addLoan(){
        System.out.println();
        System.out.print("Enter the amount for the loan: ");
        System.out.println();
        menu();
    }
    private void payFine(){
        System.out.println();
        System.out.print("Enter amount for the fine you want to pay: ");
        float fine = scan.nextFloat();
        member.payFine(fine);
        menu();
    }
    private void addFine(){
        System.out.println();
        System.out.print("Enter amount for the fine you want to be added: ");
        float fine = scan.nextFloat();
        member.addFine(fine);
        menu();
    }
    
    
    
    
    public static void main(String[] args){
        TestingMember member = new TestingMember();
    }
}
