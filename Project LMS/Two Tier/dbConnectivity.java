/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Farwa
 */
public class dbConnectivity 
{
    Connection con;
    Statement stmt;
    
    dbConnectivity() //cons
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             String s = "jdbc:sqlserver://FAWAD:1433;databaseName=l164281";
             con=DriverManager.getConnection(s,"Hammad","maulanatariqjameel");


            stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void insertBorrower(String name, String password)
    {
        try
        {
           stmt.executeUpdate("insert into Borrower(name,password) values('"+name+"','"+password+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteBorrower(String name)
    {
        try
        {
           stmt.executeUpdate("delete from Borrower where name="+"'"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void updateBorrower(String name,String address,String phone)
    {
        try
        {
               stmt.executeUpdate("update Borrower set address ='"+address+"', phone ='"+phone+"' where name ='"+name+"'");
                       }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<Borrower> getAllBorrowers()
    {
        List<Borrower> Names=new ArrayList<Borrower>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Borrower");
           while(rs.next())
           {
               String name=rs.getString(1);
               String password=rs.getString(2);
               String status=rs.getString(3);
               String adress=rs.getString(4);
               String phone=rs.getString(5);
               List<Loan> loan=getBorrowerLoanListByName(name);
               List<OnHold> hold=getOnHoldByName(name);
               
               Borrower b=new Borrower(name,password,adress,phone,status,loan,hold);
               Names.add(b);
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
        List<String> getBorrowerNames()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select name from Borrower");
           while(rs.next())
           {
               String name=rs.getString(1);
               Names.add(name);
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Loan> getBorrowerLoanListByName(String name)
    {
        List<Loan> Names=new ArrayList<Loan>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Loan where name="+"'"+name+"'");
           while(rs.next())
           {
               String n=rs.getString(1);
               String t=rs.getString(2);
               String dd=rs.getString(3);
               String id=rs.getString(4);
               Loan b=new Loan(n,t,dd,id);
               Names.add(b);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<String> getBorrowerPassword()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select password from Borrower");
           while(rs.next())
           {
               Names.add(rs.getString(1));
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    void displayBorrowerInfo()
    {
        
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Borrower");
             while(rs.next())
             {
                 
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void PayFine(String name)
    {
        try
        {
               stmt.executeUpdate("update Loan set status ='true' where name ='"+name+"'");
                       }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void insertClerk(String name, String password)
    {
        try
        {
           stmt.executeUpdate("insert into Clerk(name,password) values('"+name+"','"+password+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteClerk(String name)
    {
        try
        {
           stmt.executeUpdate("delete from clerk where name="+"'"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
        List<String> getClerkName()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select name from Clerk");
           while(rs.next())
           {
               Names.add(rs.getString(1));
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<String> getClerkPassword()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select password from Clerk");
           while(rs.next())
           {
               Names.add(rs.getString(1));
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
     void insertLibrarian(String name, String password)
    {
        try
        {
           stmt.executeUpdate("insert into Librarian(name,password) values('"+name+"','"+password+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteLibrarian(String name)
    {
        try
        {
           stmt.executeUpdate("delete from Librarian where name="+"'"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<String> getLibrarianName()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select name from Borrower");
           while(rs.next())
           {
               Names.add(rs.getString(1));
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<String> getLibrarianPassword()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select password from Borrower");
           while(rs.next())
           {
               Names.add(rs.getString(1));
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    void insertBook(String title, String subject, int isbn, String author)
    {
        String ISBN=String.valueOf(isbn);
        try
        {
           stmt.executeUpdate("insert into Book(title,subject,isbn,author,issued) values('"+title+"','"+subject+"',"+ISBN+",'"+author+"',0);");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteBook(String name)
    {
        try
        {
           stmt.executeUpdate("delete from Book where title="+"'"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }    
    void updateBook(String name,String subject,int isbn,String author,boolean i)
    {
        String B=String.valueOf(i);
        String ISBN=String.valueOf(isbn);
        try
        {
           stmt.executeUpdate("update Book set issued = "+B+",subject ='"+subject+"',isbn ='"+ISBN+"',author ='"+author+"' where title ='"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<Book> getBooksByTitle(String name)
    {
        List<Book> Names=new ArrayList<Book>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Book where title="+"'"+name+"'");
           while(rs.next())
           {
               String t=rs.getString(1);
               String s=rs.getString(2);
               int i=rs.getInt(3);
               String a=rs.getString(4);
               Book b=new Book(t,a,s,null,null,i);
               Names.add(b);
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Book> getBooksBySubject(String name)
    {
        List<Book> Names=new ArrayList<Book>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Book where subject="+"'"+name+"'");
           while(rs.next())
           {
               String t=rs.getString(1);
               String s=rs.getString(2);
               int i=rs.getInt(3);
               String a=rs.getString(4);
               Book b=new Book(t,a,s,null,null,i);
               Names.add(b);
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    void IssueBook(String title)
    {
        try
        {
           stmt.executeUpdate("update Book set issued = 1 where title ='"+title+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void UnIssueBook(String title)
    {
        try
        {
           stmt.executeUpdate("update Book set issued = 0 where title ='"+title+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void IssueDVD(String title)
    {
        try
        {
           stmt.executeUpdate("update DVD set issued = 1 where title ='"+title+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    void UnIssueDVD(String title)
    {
        try
        {
           stmt.executeUpdate("update DVD set issued = 0 where title ='"+title+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void insertDVD(String title, String subject, boolean b)
    {
        String B=String.valueOf(b);
        try
        {
           stmt.executeUpdate("insert into DVD(title,subject,issued) values("+title+",'"+subject+"','"+B+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteDVD(String name)
    {
        try
        {
           stmt.executeUpdate("delete from DVD where title="+"'"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    void updateDVD(String name,String subject,boolean i)
    {
        String B=String.valueOf(i);
        try
        {
           stmt.executeUpdate("update DVD set issued = "+B+",subject ='"+subject+"' where title ='"+name+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<String> getDVDtitles()
    {
        List<String> Names=new ArrayList<String>();
        try
        {
          ResultSet rs=stmt.executeQuery("select title from DVD");
           while(rs.next())
           {
               Names.add(rs.getString(1));
           }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    void insertLoan(String name, String title, String date, String is)
    {
        try
        {
           stmt.executeUpdate("insert into Loan(name,title,duedate) values('"+name+"','"+title+"','"+date+"','"+is+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void insertOnHold(String name, String title)
    {
        try
        {
           stmt.executeUpdate("insert into Hold(name,title) values('"+name+"','"+title+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void ExtendDate(String name, String date)
    {
        try
        {
               stmt.executeUpdate("update Loan set date ='"+date+"' where name ='"+name+"'");
                       }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<OnHold>getOnHoldByName(String name)
    {
        List<OnHold> Names=new ArrayList<OnHold>();
        try
        {
           ResultSet rs=stmt.executeQuery("select * from Hold where name="+"'"+name+"'");
           while(rs.next())
           {
               String t=rs.getString(1);
               String s=rs.getString(2);
               OnHold b=new OnHold(t,s);
               Names.add(b);
           }
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    void closeConnection()
    {
        try
        {
            con.close();
            
        }
        catch(Exception e){
            
        }
    }
}

