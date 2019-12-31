/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;
import java.util.*;
/**
 *
 * @author FAWAD & BRO
 */
public class Library {
    
   public List<Items> Items;
    public List<Loan> LoanList;
    public List<OnHold> OnHoldList;
    public List<Borrower> borrowers;
    public List<Clerk> clerks;
    public List<Librarian> librarians;
    
    private static final Library SINGLE_INSTANCE = new Library();
    private Library() 
    {}
    public static Library getInstance() 
    {
      return SINGLE_INSTANCE;
    }

}
