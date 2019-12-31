/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author FAWAD & BRO
 */
public class Main {
    	
	public static void main(String[] args)
        {
                dbConnectivity con= new dbConnectivity();
                Library.getInstance().borrowers=con.getAllBorrowers();
                Library.getInstance().clerks=con.getAllClerks();
                Library.getInstance().librarians=con.getAllLibrarians();
                Library.getInstance().Items=con.getItems();
                Library.getInstance().LoanList=con.getBorrowerLoanList();
                Library.getInstance().OnHoldList=con.getOnHold();
		LogIn app = new LogIn();
		app.setVisible(true);
	}
}
