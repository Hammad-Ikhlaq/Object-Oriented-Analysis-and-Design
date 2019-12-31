/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author FAWAD & BRO
 */
public class Loan {
    
    public String LoanUser;
    public String LoanItem;
    public String duedate;
    public String issuedate;
    public Loan(String LoanBorrower,String LoanBook,String ddate,String idate)
    {
        this.LoanUser=LoanBorrower;
        this.LoanItem=LoanBook;
        this.duedate=ddate;
        this.issuedate=idate;
    }
    
}
