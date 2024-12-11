
package dbproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PnlNewProduct extends JFrame {

    private JLabel lblName,lblQuantity,lblPrice, lblExpirydate,lblProductID;
    private JButton btnSave ,btnBack;
 
    private JTextField txtName,txtPrice,txtQuantity,txtExprydate ,txtProductID;
    Connection conn;
    public PnlNewProduct(){
        JLabel newprod;
         ImageIcon img=new ImageIcon("newprod.jpeg");
      newprod =new JLabel("",img,JLabel.CENTER);
      newprod.setBounds(0,0,600,650);
        JPanel p = new JPanel();
       p.setLayout(null);
 
       
      lblName = new JLabel("name of new product:");
      lblName.setForeground(Color.WHITE);
      lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblName.setBounds(121, 25, 166, 42);
		
      lblQuantity = new  JLabel ("Quantity");
      lblQuantity.setForeground(Color.WHITE);
      lblQuantity.setBounds(121, 78, 147, 42);
      lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
     
     lblPrice = new JLabel("Price");
     lblPrice.setForeground(Color.WHITE);
     lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
     lblPrice.setBounds(121, 157, 147, 42);
   
     lblExpirydate =new JLabel("Expiry date");
     lblExpirydate.setForeground(Color.WHITE);
     lblExpirydate.setBounds(121, 202, 147, 42);
     lblExpirydate.setFont(new Font("Tahoma", Font.BOLD, 14));
    
     lblProductID= new JLabel("Product ID");
     lblProductID.setForeground(Color.WHITE);
     lblProductID.setBounds(121, 273, 147, 32);
     lblProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
     
     
     btnSave = new JButton("Save");
     btnSave.setBounds(355, 349, 115, 42);
     btnSave.addActionListener(new ButtonListener());
       
     btnBack = new JButton("Back");
     btnBack.setBounds(172, 349, 115, 42);
     btnBack.addActionListener(new ButtonListener());
       
     
     txtName  = new JTextField();
     txtName.setBounds(342, 25, 128, 31);
     
     
     txtPrice = new JTextField();
    txtPrice.setBounds(342, 157, 128, 31);
    
    txtExprydate =new JTextField();
    txtExprydate.setBounds(342, 202, 128, 31);
  
    txtQuantity= new JTextField();
    txtQuantity.setBounds(342, 78, 128, 30);
 
    txtProductID=new JTextField();
    txtProductID.setBounds(342, 273, 128, 30);
    
    p.add(lblQuantity);
    p.add(lblName);
    p.add(lblPrice);
    p.add(lblExpirydate);
    p.add(lblProductID);
   
    p.add(btnSave);
    p.add(btnBack);
    
    p.add(txtName);
    p.add(txtPrice);
    p.add(txtExprydate);
    p.add(txtQuantity);
    p.add(txtProductID);
    p.add(newprod);
    p.setPreferredSize(new Dimension(700,500));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(p);
    setTitle("New Product");
    pack();
    setVisible(true);
    this.setSize(600,650);
    } 
      public PnlNewProduct ( Connection conn){
     this();
     this.conn = conn;
 }
  
      private  class ButtonListener implements ActionListener{
          public void actionPerformed(ActionEvent e){
           if(e.getSource()==btnSave) {
              
              
               String ProductId= txtProductID.getText();
               String Name =txtName.getText();
               String Price =txtPrice.getText();
               String Quantity=txtQuantity.getText();
               
               String Expiry=txtExprydate.getText();
                     
             String sql2 = "SELECT * FROM coffee where CoffeeType ='"+Name+"'"; 
               try {
                   Statement stmt2 = conn.createStatement();
                   ResultSet results  = stmt2.executeQuery(sql2);
                   if(results.next())
                   {
                       JOptionPane.showMessageDialog(null, "This Coffee Type already exists .");
                   }
                   else
                   {
                    String sql ="INSERT INTO coffee( ItemNumber,CoffeeType,Price,Quantity,ExpirationData)VALUES(?,?,?,?,?)";
               try {
                   PreparedStatement stmt = conn.prepareStatement(sql);
               
                   stmt.setString(1,ProductId);               
                   stmt.setString(2, Name);
                   stmt.setString(3,Price );
	 
                   stmt.setString(4, Quantity);
                   stmt.setString(5, Expiry);
		
		
               int rows = stmt.executeUpdate();
               if(rows>0) {
			JOptionPane.showMessageDialog(null, "You have successfully add new product");
		}
               
        
   	
                   
               } catch (SQLException ex) {
                  // Logger.getLogger(PnlNewProduct.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "product id is already exists");
               }
               
                   }
                   
               } catch (SQLException ex) {
                   Logger.getLogger(PnlNewProduct.class.getName()).log(Level.SEVERE, null, ex);
               }
    
           
           
           
           
           
           }
            if (e.getSource()==btnBack) {
                pnlHome h=new pnlHome(conn);
                dispose();
                
               
           }

      
              
               }
      }}       
  
      
    

   
    

