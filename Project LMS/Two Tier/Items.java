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
public class Items{
    
    public String title;
    public String subject;
    public boolean issued ;
    public List<Loan> Itemloanlist;
    public List<OnHold> Itemholdlist;
    public Items(String title,String subject,LinkedList<Loan> loanlist,LinkedList<OnHold> holdlist,boolean i)
    {
          this.title=title;
          this.subject=subject;
          this.Itemloanlist=loanlist;
          this.Itemholdlist=holdlist;
          this.issued=i;
    }
    
}
