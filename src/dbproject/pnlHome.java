




package dbproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class pnlHome extends JFrame {
    JPanel p1;
    Connection conn;
   private JButton btnPlaceOrder,btnNewProduct, btnLogout;
   vn v=new vn();
 public pnlHome(){
     JLabel home;
    
        ImageIcon img=new ImageIcon("home.jpeg");
      home =new JLabel("",img,JLabel.CENTER);
      home.setBounds(0,0,550,500);
     p1=new JPanel();
     this.setVisible(true);
        this.setTitle("Home");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        p1.setLayout(null);
      
     btnPlaceOrder=new JButton("place order");
      btnPlaceOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
    
         btnNewProduct=new JButton("new product");
          btnNewProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
       //  btnEdit=new JButton("view,Edit & delete product");
        // btnBills=new JButton("view Bills & order placed details");
         btnLogout=new JButton("log out");
          btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
         p1.setBackground(Color.WHITE);
    //  b1.setRequestFocusEnabled(false);
               this.setSize(550,500);
                btnPlaceOrder.setBounds(20, 70, 180, 50);
                btnNewProduct.setBounds(280, 70, 150, 50);
       //         btnEdit.setBounds(330, 300, 210, 50);
    //            btnBills.setBounds(30, 40, 240, 50);
                btnLogout.setBounds(170, 320, 143, 37);
     
                
                             this.add(p1);
                             p1.add(btnPlaceOrder);
                             p1.add(btnNewProduct);
                             p1.add(btnLogout);
                             p1.add(home);
         btnPlaceOrder.addActionListener(v);
         btnNewProduct.addActionListener(v);
         btnLogout.addActionListener(v);
 }
public pnlHome(Connection conn) {
this();
this.conn=conn;
}
    
      
 
     
     private class vn implements ActionListener{
         

        
        public void actionPerformed(ActionEvent e) {
             if(e.getSource()==btnPlaceOrder){
               PlaceOrderPnl o = new PlaceOrderPnl(conn);     
             o.setVisible(true);
               dispose();
                  
                  
             
             }
        
             btnNewProduct.addActionListener (new ActionListener() {
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewProduct){
                         PnlNewProduct z = new PnlNewProduct( conn);
                        z.setVisible(true);
                       
                       dispose();
            }
        }		});
                  
                btnLogout.addActionListener (new ActionListener() {
	public void actionPerformed(ActionEvent e) {
            if (e.getSource()==btnLogout){
    int response =JOptionPane.showConfirmDialog(null, "are you sure u want to exit","confirm",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
     if (response==JOptionPane.YES_OPTION) {
   
         Panel1 k= new Panel1(conn);
    dispose();}
     // System.out.println("yes select");}
// if yes option select..

else if  (response==JOptionPane.NO_OPTION){

System.out.println("No.. Option Selected..");} 
else if (response == JOptionPane. CLOSED_OPTION){
         System.out.println("closed select");
}
            }}		});
        }}}     
                  
            
            
 
            
			
		
                  
            
            
        
            
           
        
     

             
        
          
