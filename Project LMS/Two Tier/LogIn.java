/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FAWAD & BRO
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        LoginLabel = new javax.swing.JLabel();
        LoginAsLabel = new javax.swing.JLabel();
        BorrowerRadioButton = new javax.swing.JRadioButton();
        ClerkRadioButton = new javax.swing.JRadioButton();
        LibrarianRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginLabel.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        LoginLabel.setForeground(new java.awt.Color(255, 0, 0));
        LoginLabel.setText("Login");

        LoginAsLabel.setText("login as");

        buttonGroup1.add(BorrowerRadioButton);
        BorrowerRadioButton.setText("Borrower");

        buttonGroup1.add(ClerkRadioButton);
        ClerkRadioButton.setText("Clerk");

        buttonGroup1.add(LibrarianRadioButton);
        LibrarianRadioButton.setText("Librarian");

        jLabel1.setText("Name");

        jLabel2.setText("Password");

        jButton1.setText("Submit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(LoginLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LoginAsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(BorrowerRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClerkRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LibrarianRadioButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(PasswordField))))))
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(LoginLabel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginAsLabel)
                    .addComponent(BorrowerRadioButton)
                    .addComponent(ClerkRadioButton)
                    .addComponent(LibrarianRadioButton))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(BorrowerRadioButton.isSelected())
        {
            connector con=new connector();
            List<String> names=new ArrayList<String>();
            names=con.getBorrowerName();
            for(int i=0;i<names.size();i++)
            {
                String s=NameTextField.getText();
                if(names.get(i).equals(s))
                {
                    List<String> passwords=new ArrayList<String>();
                    passwords=con.getBorrowerPassword();
                        String p=PasswordField.getText();
                        if(passwords.get(i).equals(p))
                        {
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                new BorrowerGUI(s).setVisible(true);
                            }
                            });
                            
                        }
                    
                }
            }
        }
        else if(ClerkRadioButton.isSelected())
        {
            connector con=new connector();
            List<String> names=new ArrayList<String>();
            names=con.getClerkName();
            for(int i=0;i<names.size();i++)
            {
                 String s=NameTextField.getText();
                if(names.get(i).equals(s))
                {
                    List<String> passwords=new ArrayList<String>();
                    passwords=con.getClerkPassword();
                        String p=PasswordField.getText();
                        if(passwords.get(i).equals(p))
                        {
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                new ClerkGUI(s).setVisible(true);
                            }
                            });
                            
                        }
                    
                }
            }
        }
        else if(LibrarianRadioButton.isSelected())
        {
            connector con=new connector();
            List<String> names=new ArrayList<String>();
            names=con.getLibrarianName();
            for(int i=0;i<names.size();i++)
            {
              String s=NameTextField.getText();
                if(names.get(i).equals(s))
                {
                    List<String> passwords=new ArrayList<String>();
                    passwords=con.getLibrarianPassword();
                        String p=PasswordField.getText();
                        if(passwords.get(i).equals(p))
                        {
                               java.awt.EventQueue.invokeLater(new Runnable() 
                               {
                                public void run() 
                                {
                                    new LibrarianGUI(s).setVisible(true);
                                }
                               });
                        }
                }
            }
        }
        else
        JOptionPane.showMessageDialog(null,"Invalid input","Error Message",JOptionPane.PLAIN_MESSAGE);
      //JOptionPane.showMessageDialog(null,"Invalid input","Error Message",JOptionPane.PLAIN_MESSAGE);  
    }//GEN-LAST:event_jButton1MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
                               java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                new LogIn().setVisible(true);
                            }
                            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BorrowerRadioButton;
    private javax.swing.JRadioButton ClerkRadioButton;
    private javax.swing.JRadioButton LibrarianRadioButton;
    private javax.swing.JLabel LoginAsLabel;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
