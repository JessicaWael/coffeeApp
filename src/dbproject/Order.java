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

public class Order  extends JFrame{
    private JLabel  lblName,lblPrice;
    private JTextField txtName,txtPrice;
    private JButton btnUpdate,BtnBack;
    
    public Order() {
         JPanel o = new JPanel();
        o.setLayout(null);
        
        
           lblName= new JLabel("Name");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(101, 169, 92, 46);
        
          lblPrice = new JLabel("price");
        lblPrice.setForeground(Color.BLACK);
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrice.setBounds(101, 320, 92, 56);
        

          txtName = new JTextField();
        txtName.setForeground(Color.BLACK);
        txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtName.setBounds(272,176,157,29);
        
        
          txtPrice = new JTextField();
        txtPrice.setForeground(Color.BLACK);
        txtPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtPrice.setBounds(272,337,162,29);
        
         btnUpdate = new JButton("Ubdate :");
        btnUpdate.setForeground(Color.BLACK);
       btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnUpdate.setBounds(332,469,147,32);
        
        
        
          BtnBack = new JButton("back :");
       BtnBack.setForeground(Color.BLACK);
        BtnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        BtnBack.setBounds(543,469,175,32);

    
        o.add(lblName);
        o.add(lblPrice);
        o.add(txtName);
        o.add(txtPrice);
        o.add(btnUpdate);
        o.add(BtnBack);
    
         o.setPreferredSize(new Dimension(450,450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(o);
        setTitle("login");
        pack();
        setVisible(true); 
    
    }
    
}