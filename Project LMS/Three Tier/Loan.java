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
    
    public int Borrowerid;
    public int ItemId;
    public String duedate;
    public String issuedate;
    public Loan(int LoanBorrower,int LoanBook,String ddate,String idate)
    {
        this.Borrowerid=LoanBorrower;
        this.ItemId=LoanBook;
        this.duedate=ddate;
        this.issuedate=idate;
    }
    
}
