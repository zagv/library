/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import library.interfaces.entities.EMemberState;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

/**
 *
 * @author zlatkopetrov
 */
public class Member implements IMember {
    
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;
    private final int id;
    
    private EMemberState state;
    private List<ILoan> loanList;
    private float totalFines;
    
    public Member(int id, String firstName, String lastName, String phone, String email){
        if (!validation(id, firstName, lastName, phone, email)){
            System.out.println("All fields are mandatory!!!");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.loanList = new ArrayList<ILoan>();
        this.totalFines = 0.0f;
        this.state = EMemberState.BORROWING_ALLOWED;
    }
    private boolean validation (int id, String firstName, String lastName, String phone, String email){
        return (id >0 && firstName != null && !firstName.isEmpty() &&
                lastName !=null && !lastName.isEmpty() &&
                phone != null && !phone.isEmpty() && 
                email != null && !email.isEmpty());
    }

    @Override
    public boolean hasOverDueLoans() {
        for (ILoan loan : loanList){
            if(loan.isOverDue()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasReachedLoanLimit() {
        return loanList.size() >= IMember.LOAN_LIMIT;
    }

    @Override
    public boolean hasFinesPayable() {
        return totalFines > 0.0f;
    }

    @Override
    public boolean hasReachedFineLimit() {
        return totalFines >= IMember.FINE_LIMIT;
    }

    @Override
    public float getFineAmount() {
        return totalFines;
    }

    @Override
    public void addFine(float fine) {
        if (fine < 0){
            System.out.println("Fine can not be less than 0");
        }
        totalFines += fine;
        updateState();
    }

    @Override
    public void payFine(float payment) {
        if (payment < 0 || payment > totalFines){
            System.out.println("payment can not be less than 0 or more than total amount of fines!!!");
        }
        totalFines -= payment;
        updateState();
    }

    @Override
    public void addLoan(ILoan loan) {
        if(!borrowingAllowed()){
            System.out.println("You are not allowed to add new loan!!!");
        }
        loanList.add(loan);
    }

    @Override
    public List<ILoan> getLoans() {
        return Collections.unmodifiableList(loanList);
    }

    @Override
    public void removeLoan(ILoan loan) {
        if (loan == null || !loanList.contains(loan)){
            System.out.println("Loan can't be empty or is not found in the member loans");
        }
        loanList.remove(loan);
        updateState();
    }

    @Override
    public EMemberState getState() {
        return state;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getContactPhone() {
        return phone;
    }

    @Override
    public String getEmailAddress() {
        return email;
    }

    @Override
    public int getID() {
        return id;
    }
    
    private boolean borrowingAllowed(){
        return (!hasOverDueLoans() && !hasReachedFineLimit() && !hasReachedLoanLimit());
    }
    private void updateState(){
        if(borrowingAllowed()){
            state = EMemberState.BORROWING_ALLOWED;
        }
        else{
            state = EMemberState.BORROWING_DISALLOWED;
        }
    }
    
    public String toString(){
        return String.format("Id: %d\nName: %s %s, Contact Phone: %s, Email: %s, Outstanding Charges: %.2f", 
                id, firstName,lastName,phone,email,totalFines);
    }
    
}
