/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.util.List;

/**
 *
 * @author FAWAD & BRO
 */
public class Borrower
{
    public int id;    
    public String name;
    public String password;
    public String address;
    public String phone;
    public boolean feeClear;
    public List<Loan> UserLoanList;
    public List<OnHold> UserHoldList;
    public Borrower(int id,String name,String password,String address,String phone,boolean feepaid,List<Loan>l1,List<OnHold>h)
    {
           this.id=id;
          this.name=name;
          this.address=address;
          this.phone=phone;
          this.UserLoanList=l1;
          this.UserHoldList=h;
          this.feeClear=feepaid;
          this.password=password;
    } 

}
