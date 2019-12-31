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
public class Librarian extends User {
    public Librarian(String name,String password,String address,String phone,String feepaid,LinkedList<Loan>l1,LinkedList<OnHold>h)
    {
          super(name,password,address,phone,feepaid,l1,h);
    }
}
