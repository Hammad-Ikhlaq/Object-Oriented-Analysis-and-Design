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
public class Book extends Items {
    
    public int isbn;
    public String author;
    public Book(String title,String author,String subject,LinkedList<Loan> loanlist,LinkedList<OnHold> holdlist,int isbn)
    {
        super(title,subject,loanlist,holdlist,false);
        this.isbn=isbn;
        this.author=author;
    }
}
