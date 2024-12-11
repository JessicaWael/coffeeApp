
package dbproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.text.html.HTML.Tag.OPTION;

/**
 *
 * @author Ideapad_Gaming3
 */
public class Panel1 extends JFrame{
    private JLabel lblUsername , lblPassword , lblPhoto,lblalready ,  lblsign;
    private JButton btnLogin , btnCancel ,btnCreat ;
    private JTextField txtUsername , txtPassword ;
    Connection conn;
    public Panel1()
    {
         JLabel log;
    
        ImageIcon img=new ImageIcon("log.jpeg");
      log =new JLabel("",img,JLabel.CENTER);
      log.setBounds(0,0,700,650);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(107, 81, 167, 55);
        
        lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(107, 168, 167, 55);
         
        lblalready = new JLabel("already have an account");
          lblalready.setForeground(Color.WHITE);
        lblalready.setBounds(405, 324, 152, 14);
        
        lblsign= new JLabel("creat a new account");
         lblsign.setForeground(Color.WHITE);
          lblsign.setBounds(261, 421, 167, 14);
       
          btnLogin = new JButton("Log In");
        btnLogin.setBounds(405, 275, 152, 42);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.addActionListener(new ButtonListener());
        
        btnCancel = new JButton("EXIT");
        btnCancel.setBounds(133, 275, 152, 42);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.addActionListener(new ButtonListener());
        
        btnCreat = new JButton("sign up");
        btnCreat.setBounds(261, 368, 167, 42);
        btnCreat.setFont(new Font("Tahoma", Font.BOLD, 14));
         btnCreat.addActionListener(new  ButtonListener());

        
        txtUsername = new JTextField();
        txtUsername.setBounds(314, 95, 197, 35);
        txtUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        txtPassword = new JTextField();
        txtPassword.setBounds(314, 168, 197, 35);
        txtPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
       
        p.add(lblUsername);
        p.add(lblPassword);
        p.add(txtUsername);
        p.add(txtPassword);
        p.add(btnLogin);
        p.add(btnCancel);
        p.add(btnCreat);
        p.add(lblalready);
        p.add(lblsign);
        p.add(log);
        
        p.setPreferredSize(new Dimension(700,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(p);
        setTitle("login");
        pack();
        setVisible(true); 
        this.setSize(700,650);
        
        
        
    }
    public Panel1(Connection conn)
    {
        this();
        this.conn =conn;
    }
    private class ButtonListener implements ActionListener
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==btnLogin) 
            
        {
        String Name = txtUsername.getText();
   	String password = txtPassword.getText();
   	String sql = "SELECT *from seller Where Name = '" + Name + "'";
   	Statement statement;
   	try {
   	statement   = conn.createStatement();
   	ResultSet results = statement.executeQuery(sql);
   	if(results.next()) {
            String databasePassword = results.getString("Password");
            if(databasePassword.equals(password)) {
           // JOptionPane.showMessageDialog(null, "Goooooooo");
   	pnlHome h =new pnlHome (conn);
            dispose();
   	}
            else {
            JOptionPane.showMessageDialog(null, "Incorrect Password");
   	}
   	}
   	else {
   	JOptionPane.showMessageDialog(null, "User does not exist");
   	}
   	} catch (SQLException e1) {
   	// TODO Auto-generated catch block
   	e1.printStackTrace();
   	}
        
        }
     if (e.getSource()==btnCreat){
    
          signUp s=new signUp(conn);
     dispose();}
    
     if (e.getSource()==btnCancel){
    int response =JOptionPane.showConfirmDialog(null, "are you sure u want to exit","confirm",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
     if (response==JOptionPane.YES_OPTION) {
       dispose();
         System.out.println("yes select");}
// if yes option select..

else if  (response==JOptionPane.NO_OPTION){

System.out.println("No.. Option Selected..");} 
else if (response == JOptionPane. CLOSED_OPTION){
         System.out.println("closed select");
}
    
    }
    }
    
 
  
 
  //  btnCreat.addActionListener(new ActionListener() {
     //public void actionPerformed(ActionEvent e) {
         //if(e.getSource()==btnCreat){
   
             //signUp r= new signUp(conn);
   //r.setVisible(true);
  //  JOptionPane.showMessageDialog(null, "are you sure you want to make ");
   // dispose();
         }
}
//)//;}
    
    
    
   
    
    
    



    
            

        

