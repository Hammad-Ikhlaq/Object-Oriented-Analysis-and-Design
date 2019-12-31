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
    void insertBorrower(String name,String password,boolean FeeClear,String address,String phone)
    {
                String B=String.valueOf(FeeClear);
        try
        {
           stmt.executeUpdate("insert into Borrower(id,name,password,FeeClear,address,phone) values((Select MAX(id) from Borrower)+1,'"+name+"','"+password+"','"+B+"','"+address+"','"+phone+"');");
        }
         catch(Exception e)
        {
            System.out.print(e);
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteBorrower(int Id)
    {
         String id=String.valueOf(Id);
        try
        {
           stmt.executeUpdate("delete from Borrower where id="+id);
        JOptionPane.showMessageDialog(null,"Done","Borrower deleted succesful",JOptionPane.PLAIN_MESSAGE);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void updateBorrower(int Id,String address,String phone)
    {
        String id=String.valueOf(Id);
        try
        {
               stmt.executeUpdate("update Borrower set address ='"+address+"', phone ='"+phone+"' where id ="+id);
               
        JOptionPane.showMessageDialog(null,"Done","Borrower updated succesful",JOptionPane.PLAIN_MESSAGE);
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
          int id=0;
          ResultSet rs=stmt.executeQuery("select * from Borrower");
           while(rs.next())
           {
               id=rs.getInt(1);
               String name=rs.getString(2);
               String password=rs.getString(3);
               boolean feeClear=rs.getBoolean(4);
               String adress=rs.getString(5);
               String phone=rs.getString(6);
               
               Borrower b=new Borrower(id,name,password,adress,phone,feeClear,null,null);
               Names.add(b);
           }
            for(int i=0;i<Names.size();i++)
            {
                 Names.get(i).UserLoanList=getBorrowerLoanListByBorrowerID(Names.get(i).id);
                 Names.get(i).UserHoldList=getOnHoldByHolderID(Names.get(i).id);
                 
            }
        }
        catch(Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Loan> getBorrowerLoanListByBorrowerID(int Id)
    {
        String id=String.valueOf(Id);
        List<Loan> Names=new ArrayList<Loan>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Loan where Borrowerid="+id);
           while(rs.next())
           {
               int Bid=rs.getInt(1);
               int Iid=rs.getInt(2);
               String dd=rs.getString(3);
               String iid=rs.getString(4);
               Loan b=new Loan(Bid,Iid,dd,iid);
               Names.add(b);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Loan> getBorrowerLoanList()
    {
        List<Loan> Names=new ArrayList<Loan>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Loan");
           while(rs.next())
           {
               int Bid=rs.getInt(1);
               int Iid=rs.getInt(2);
               String dd=rs.getString(3);
               String iid=rs.getString(4);
               Loan b=new Loan(Bid,Iid,dd,iid);
               Names.add(b);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Loan> getBorrowerLoanListByItemID(int Id)
    {
        String id=String.valueOf(Id);
        List<Loan> Names=new ArrayList<Loan>();
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Loan where Itemid="+id);
           while(rs.next())
           {
               int Bid=rs.getInt(1);
               int Iid=rs.getInt(2);
               String dd=rs.getString(3);
               String iid=rs.getString(4);
               Loan b=new Loan(Bid,Iid,dd,iid);
               Names.add(b);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    void PayFine(int Id)
    {
        String id=String.valueOf(Id);
        try
        {
               stmt.executeUpdate("update Borrower set FeeClear ='true' where id ="+id);
               
        JOptionPane.showMessageDialog(null,"Done","Fine Paid succesful",JOptionPane.PLAIN_MESSAGE);
                       }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<Clerk> getAllClerks()
    {
        List<Clerk> Names=new ArrayList<Clerk>();
               int id=0;
               String name=null;
               String password=null;
               String phone=null;
               String adress=null;
               boolean status=true;
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Clerk");
           while(rs.next())
           {
               id=rs.getInt(1);
               name=rs.getString(2);
               password=rs.getString(3);
               phone=null;
               adress=null;
               status=true;
               Clerk b=new Clerk(id,name,password,adress,phone,status,null,null);
               Names.add(b);
           }
            for(int i=0;i<Names.size();i++)
            {
            ResultSet rs2=stmt.executeQuery("select FeeClear from Borrower where id ="+String.valueOf(Names.get(i).id));
            while(rs2.next())
            {
                Names.get(i).feeClear=rs2.getBoolean(1);
            }
                ResultSet rs3=stmt.executeQuery("select address from Borrower where id ="+String.valueOf(Names.get(i).id));
                while(rs3.next())
                {
                    Names.get(i).address=rs3.getString(1);
                }
                ResultSet rs4=stmt.executeQuery("select phone from Borrower where id ="+String.valueOf(Names.get(i).id));
                while(rs4.next())
                {
                    Names.get(i).phone=rs4.getString(1);
                }
            
               Names.get(i).UserLoanList=getBorrowerLoanListByBorrowerID(Names.get(i).id);
               Names.get(i).UserHoldList=getOnHoldByHolderID(Names.get(i).id);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Librarian> getAllLibrarians()
    {
        List<Librarian> Names=new ArrayList<Librarian>();
                       int id=0;
               String name=null;
               String password=null;
               String phone=null;
               String adress=null;
               boolean status=true;
        try
        {
          ResultSet rs=stmt.executeQuery("select * from Librarian");
           while(rs.next())
           {
               id=rs.getInt(1);
               name=rs.getString(2);
               password=rs.getString(3);
               phone=null;
               adress=null;
               status=true;
               Librarian b=new Librarian(id,name,password,adress,phone,status,null,null);
               Names.add(b);
           }
            for(int i=0;i<Names.size();i++)
            {
            ResultSet rs2=stmt.executeQuery("select FeeClear from Borrower where id ="+String.valueOf(Names.get(i).id));
            while(rs2.next())
            {
                Names.get(i).feeClear=rs2.getBoolean(1);
            }
                ResultSet rs3=stmt.executeQuery("select address from Borrower where id ="+String.valueOf(Names.get(i).id));
                while(rs3.next())
                {
                    Names.get(i).address=rs3.getString(1);
                }
                ResultSet rs4=stmt.executeQuery("select phone from Borrower where id ="+String.valueOf(Names.get(i).id));
                while(rs4.next())
                {
                    Names.get(i).phone=rs4.getString(1);
                }
            
               Names.get(i).UserLoanList=getBorrowerLoanListByBorrowerID(Names.get(i).id);
               Names.get(i).UserHoldList=getOnHoldByHolderID(Names.get(i).id);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }
    List<Items>getItems()
    {
        List<Items> Names=new ArrayList<Items>();
        try
        {
           ResultSet rs=stmt.executeQuery("select * from Item");
           while(rs.next())
           {
               int id=rs.getInt(1);
               String title=rs.getString(2);
               String subject=rs.getString(3);
               boolean issued=rs.getBoolean(4);
               Items b=new Items(id,title,subject,issued,null,null);
               Names.add(b);
           }
            for(int i=0;i<Names.size();i++)
            {        
               Names.get(i).Itemloanlist=getBorrowerLoanListByItemID(Names.get(i).id);
               Names.get(i).Itemholdlist=getOnHoldByItemID(Names.get(i).id);
            }
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
        return Names;
    }   
    void insertBook(String title, String subject, int isbn, String author)
    {
        String ISBN=String.valueOf(isbn);
        try
        {
           int id1=0;
           stmt.executeUpdate("insert into Item(id,title,subject,issued) values((Select MAX(id) from Item)+1,'"+title+"','"+subject+"','false');");
           ResultSet rs=stmt.executeQuery("Select MAX(id) from Item ");
           while(rs.next())
           {
               id1=rs.getInt(1);
           }
           String ID=String.valueOf(id1);
           stmt.executeUpdate("insert into Book(id,isbn,author) values("+ID+",'"+ISBN+"','"+author+"');");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteBook(int Id)
    {
         String id=String.valueOf(Id);
        try
        {
           stmt.executeUpdate("delete from Book where id="+id);
           stmt.executeUpdate("delete from Item where id="+id);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }    
    void updateBook(int Id,String title,String subject,int isbn,String author,boolean i)
    {
         String id=String.valueOf(Id);
        String B=String.valueOf(i);
        String ISBN=String.valueOf(isbn);
        try
        {
           stmt.executeUpdate("update Book set isbn ="+ISBN+",author ='"+author+"' where id ="+id);
           stmt.executeUpdate("update Item set title ='"+title+"',subject ='"+subject+"',issued ='"+B+"'where id ="+id);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void IssueItem(int id)
    {
        String ID=String.valueOf(id);
        try
        {
           stmt.executeUpdate("update Item set issued = 'true' where id ='"+ID+"'");
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void UnIssueItem(int id)
    {
        String ID=String.valueOf(id);
        try
        {
           stmt.executeUpdate("update Item set issued = 'false' where id ='"+ID+"'");
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
           int id=0;
           stmt.executeUpdate("insert into Item(id,title,subject,issued) values((Select MAX(id) from Item)+1,'"+title+"','"+subject+"','"+B+"');");
           ResultSet rs=stmt.executeQuery("Select MAX(id) from Item ");
           while(rs.next())
           {
               id=rs.getInt(1);
           }
           String ID=String.valueOf(id);
           stmt.executeUpdate("insert into DVD(id) values("+ID+");");
        }
         catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void deleteDVD(int name)
    {
        try
        {
           stmt.executeUpdate("delete from DVD where id="+name);
           stmt.executeUpdate("delete from Item where id="+name);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void updateDVD(int id,String title,String subject,boolean i)
    {

        String I=String.valueOf(i);
        try
        {
           stmt.executeUpdate("update Item set title ='"+title+"',subject ='"+subject+"',issued ='"+I+"'where id ="+id);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void insertLoan(int name, int title, String date, String is)
    {
        String Bid=String.valueOf(name);
        String Iid =String.valueOf(title);       
        try
        {
           stmt.executeUpdate("insert into Loan(Borrowerid,Itemid,duedate,issueddate) values("+Bid+","+Iid+",'"+date+"','"+is+"');");
        
        JOptionPane.showMessageDialog(null,"Done","Checkout Item succesful",JOptionPane.PLAIN_MESSAGE);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void Checkin(int name, int title)
    {
        String ID=String.valueOf(name);
        String ID2=String.valueOf(title);
        try
        {
           stmt.executeUpdate("update Loan set duedate = ' ' where Borrowerid ="+ID+"and Itemid="+ID2);
        }
         catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void insertOnHold(int name, int title)
    {
        try
        {
           stmt.executeUpdate("insert into Hold(HolderId,ItemId) values("+name+","+title+");");
        }
         catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    void ExtendDate(int id, int item, String date)
    {
        try
        {
               stmt.executeUpdate("update Loan set duedate ='"+date+"' where Borrowerid ="+id+" and Itemid="+item);
               JOptionPane.showMessageDialog(null,"Done","Renew succesful",JOptionPane.PLAIN_MESSAGE);
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Failed",JOptionPane.PLAIN_MESSAGE);
        }
    }
    List<OnHold>getOnHold()
    {
        List<OnHold> Names=new ArrayList<OnHold>();
        try
        {
           ResultSet rs=stmt.executeQuery("select * from Hold");
           while(rs.next())
           {
               int t=rs.getInt(1);
               int s=rs.getInt(2);
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
    List<OnHold>getOnHoldByHolderID(int id)
    {
        List<OnHold> Names=new ArrayList<OnHold>();
        try
        {
           ResultSet rs=stmt.executeQuery("select * from Hold where HolderId="+id);
           while(rs.next())
           {
               int t=rs.getInt(1);
               int s=rs.getInt(2);
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
    List<OnHold>getOnHoldByItemID(int id)
    {
        List<OnHold> Names=new ArrayList<OnHold>();
        try
        {
           ResultSet rs=stmt.executeQuery("select * from Hold where ItemId="+id);
           while(rs.next())
           {
               int t=rs.getInt(1);
               int s=rs.getInt(2);
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

