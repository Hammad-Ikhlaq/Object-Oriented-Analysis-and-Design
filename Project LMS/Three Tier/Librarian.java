/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author FAWAD & BRO
 */
public class Librarian extends Clerk {
    public Librarian(int id,String name,String password,String address,String phone,boolean feepaid,List<Loan>l1,List<OnHold>h)
    {
          super(id,name,password,address,phone,feepaid,l1,h);
    }
}
