/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.util.LinkedList;

/**
 *
 * @author FAWAD & BRO
 */
public class DVD extends Items {
    public DVD(String title,String subject,LinkedList<Loan> loanlist,LinkedList<OnHold> OnHold)
    {
       
        super(title,subject,loanlist,OnHold,false);
    }
    
}
