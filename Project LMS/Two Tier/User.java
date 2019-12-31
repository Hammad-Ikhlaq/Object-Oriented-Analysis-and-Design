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

public class User{
    public String name;
    public String password;
    public String address;
    public String phone;
    public String feeClear;
    public List<Loan> UserLoanList;
    public List<OnHold> UserHoldList;
    
    public User(String name,String password,String address,String phone,String feeClear,List<Loan>l1,List<OnHold> h)
    {
          this.name=name;
          this.address=address;
          this.phone=phone;
          this.UserLoanList=l1;
          this.UserHoldList=h;
          this.feeClear=feeClear;
          this.password=password;
    }
 
}
