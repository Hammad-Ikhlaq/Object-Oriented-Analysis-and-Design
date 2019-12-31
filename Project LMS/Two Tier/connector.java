/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FAWAD & BRO
 */
public class connector {
    void insertBorrower(String name, String password)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertBorrower(name,password);
        con.closeConnection();
    }
    void deleteBorrower(String name)
    {
        dbConnectivity con=new dbConnectivity();
        con.deleteBorrower(name);
        con.closeConnection();
    }
    void updateBorrower(String name,String address,String phone)
    {
        dbConnectivity con=new dbConnectivity();
        con.updateBorrower(name,address,phone);
        con.closeConnection();
    }
    List<Loan> getBorrowerLoanListByName(String name)
    {
        dbConnectivity con=new dbConnectivity();
        List<Loan> Names=new ArrayList<Loan>();
        Names=con.getBorrowerLoanListByName(name);
        con.closeConnection();
        return Names;
    }
    List<String> getBorrowerName()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getBorrowerNames();
        con.closeConnection();
        return Names;
    }
    List<String> getBorrowerPassword()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getBorrowerPassword();
        con.closeConnection();
        return Names;
    }

    void insertClerk(String name, String password)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertClerk(name,password);
        con.closeConnection();
    }
    void deleteClerk(String name)
    {
        dbConnectivity con=new dbConnectivity();
        con.deleteClerk(name);
        con.closeConnection();
    }
    List<String> getClerkName()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getClerkName();
        con.closeConnection();
        return Names;
    }
    List<String> getClerkPassword()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getClerkPassword();
        con.closeConnection();
        return Names;
    }
     void insertLibrarian(String name, String password)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertLibrarian(name,password);
        con.closeConnection();
    }
    void deleteLibrarian(String name)
    {
        dbConnectivity con=new dbConnectivity();
        con.deleteLibrarian(name);
        con.closeConnection();
    }
    List<String> getLibrarianName()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getLibrarianName();
        con.closeConnection();
        return Names;
    }
    List<String> getLibrarianPassword()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getLibrarianPassword();
        con.closeConnection();
        return Names;
    }
    void insertBook(String title, String subject, int isbn, String author)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertBook(title,subject,isbn,author);
        con.closeConnection();
    }
    void deleteBook(String name)
    {
        dbConnectivity con=new dbConnectivity();
        con.deleteBook(name);
        con.closeConnection();
    }
    void updateBook(String title, String subject, int isbn, String author, boolean issued)
    {
        dbConnectivity con=new dbConnectivity();
        con.updateBook(title,subject,isbn,author,issued);
        con.closeConnection();
    }
    List<Book> getBooksByTitle(String name)
    {
        dbConnectivity con=new dbConnectivity();
        List<Book> Names=new ArrayList<Book>();
        Names=con.getBooksByTitle(name);
        con.closeConnection();
        return Names;
    }
        List<Book> getBooksBySubject(String name)
    {
        dbConnectivity con=new dbConnectivity();
        List<Book> Names=new ArrayList<Book>();
        Names=con.getBooksBySubject(name);
        con.closeConnection();
        return Names;
    }
    void IssueBook(String title)
    {
        dbConnectivity con=new dbConnectivity();
        con.IssueBook(title);
        con.closeConnection();
    }
    void UnIssueBook(String title)
    {       
        dbConnectivity con=new dbConnectivity();
        con.UnIssueBook(title);
        con.closeConnection();
    }
    void IssueDVD(String title)
    {
        dbConnectivity con=new dbConnectivity();
        con.IssueDVD(title);
        con.closeConnection();
    }
    
    void UnIssueDVD(String title)
    {
        dbConnectivity con=new dbConnectivity();
        con.UnIssueDVD(title);
        con.closeConnection();
    }
    void insertDVD(String title, String subject, boolean issued)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertDVD(title,subject,issued);
        con.closeConnection();
    }
    void updateDVD(String title, String subject, boolean issued)
    {
        dbConnectivity con=new dbConnectivity();
        con.updateDVD(title,subject,issued);
        con.closeConnection();
    }
    void deleteDVD(String name)
    {
        dbConnectivity con=new dbConnectivity();
        con.deleteDVD(name);
        con.closeConnection();
    }
    List<String> getDVDtitles()
    {
        dbConnectivity con=new dbConnectivity();
        List<String> Names=new ArrayList<String>();
        Names=con.getDVDtitles();
        con.closeConnection();
        return Names;
    }
    void insertLoan(String name, String title, String date,String is)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertLoan(name,title,date,is);
        con.closeConnection();
    }
    void ExtendDate(String name, String date)
    {
        dbConnectivity con=new dbConnectivity();
        con.ExtendDate(name,date);
        con.closeConnection();
    }
    void PayFine(String name)
    {
        dbConnectivity con=new dbConnectivity();
        con.PayFine(name);
        con.closeConnection();
    }
    void insertOnHold(String name, String title)
    {
        dbConnectivity con=new dbConnectivity();
        con.insertOnHold(name,title);
        con.closeConnection();
    }
    List<OnHold>getOnHoldByName(String name)
    {
        dbConnectivity con=new dbConnectivity();
        List<OnHold> Names=new ArrayList<OnHold>();
        Names=con.getOnHoldByName(name);
        con.closeConnection();
        return Names;
    }
}
