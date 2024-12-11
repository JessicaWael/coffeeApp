/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class signUp  extends JFrame{
    private JLabel  lblName,lblPassword,lblEmail,lblPhoneNumber,lblID;
    private JTextField txtName,txtPassword,txtEmail,txtPhoneNumber,txtID;
    private JButton btnSignin,btnBack;
    Connection conn;
    public signUp() {
             JLabel sign;
    
        ImageIcon img=new ImageIcon("sign.jpeg");
      sign =new JLabel("",img,JLabel.CENTER);
      sign.setBounds(0,0,700,650);
         JPanel o = new JPanel();
        o.setLayout(null);
        
        
           lblName= new JLabel("Name");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(131, 56, 105, 39);
        
        lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(131, 106, 105, 34);
        
          lblEmail= new JLabel("Email");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmail.setBounds(131, 164, 105, 39);
        
        lblPhoneNumber= new JLabel("PhoneNumber");
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPhoneNumber.setBounds(131, 218, 105, 34);
        
        
        lblID= new JLabel("ID");
        lblID.setForeground(Color.WHITE);
        lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblID.setBounds(131, 263, 105, 31);
        
       
      
        txtName = new JTextField();
        txtName.setForeground(Color.BLACK);
        txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtName.setBounds(353, 53, 124, 26);
        
        txtPassword = new JTextField();
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtPassword.setBounds(353, 103, 124, 26);
        
        txtEmail = new JTextField();
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtEmail.setBounds(353, 161, 124, 26);
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setForeground(Color.BLACK);
        txtPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtPhoneNumber.setBounds(353, 215, 124, 26);
        
     
        txtID = new JTextField();
        txtID.setForeground(Color.BLACK);
        txtID.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtID.setBounds(353, 268, 124, 26);
       
        btnSignin = new JButton("Sign up");
        btnSignin.setForeground(Color.BLACK);
        btnSignin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignin.setBounds(372, 348, 150, 42);
        btnSignin.addActionListener(new ButtonListener());
     
        
        btnBack =new JButton("back");
        btnBack.setForeground(Color.BLACK);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBounds(131, 348, 150, 42);
        btnBack.addActionListener(new ButtonListener());
       
        o.add(lblName);
        o.add(lblPassword);
        o.add(lblEmail);
        o.add(lblPhoneNumber);
        o.add(lblID);
        o.add(txtName);
        o.add(txtPassword);
        o.add(txtEmail);
        o.add(txtPhoneNumber);
        o.add(txtID);
        o.add(btnSignin);
        o.add(btnBack);
        o.add(sign);
        
        o.setPreferredSize(new Dimension(700,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(o);
        setTitle("new account");
        pack();
        setVisible(true); 
        this.setSize(700,650);
    
    }
    public signUp(Connection conn) {
         this();
         this.conn=conn;
}
    
    private class ButtonListener implements ActionListener
   {
   public void actionPerformed (ActionEvent event) 
   {
   if (event.getSource()== btnSignin)
   {
        
         String ID = txtID.getText();
         String name = txtName.getText();
         String phoneNumber = txtPhoneNumber.getText();  
         String Email = txtEmail.getText();
         String password = txtPassword.getText();                       
	   String sql = "INSERT INTO seller (ID,Name,PhoneNumber,Email,Password) VALUES (?,?,?,?,?)";
	   try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, ID);
		stmt.setString(2,name );
		stmt.setString(3, phoneNumber);
		stmt.setString(4, Email);
		stmt.setString(5, password);
		int rows = stmt.executeUpdate();
		if(rows>0) {
			JOptionPane.showMessageDialog(null, "You have successfully created an account");
		}
		Panel1 r = new Panel1(conn);
		   dispose();
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "email or phone num. already  exist");
            
            
		}
   }
    if (event.getSource()== btnBack){
    Panel1 p= new Panel1(conn);
    dispose();
    
    }
    
}}
}
