package dbproject;
//import static com.sun.corba.se.impl.util.Utility.printStackTrace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PlaceOrderPnl extends JFrame {

    private JLabel lblBillID, lblCustomerDetails, lblCName, lblPhoneNumber, lblCmCategory,
            lblQuantity, lblPrice, lblTotal, txtPrice, txtTotal;
    private JComboBox CmCategory;
    private JButton btnClear, btnSave, btnLogOut, btnBack,btn_totPrice;
    private JTextField txtBillID, txtCName, txtPhoneNumber, txtQuataty;
    private Connection conn;
    ButtonListener v = new ButtonListener();
    
    public static int price;

    public PlaceOrderPnl() {
             
    }
    

    public PlaceOrderPnl(Connection conn) {
          this();   
           this.conn = conn;
          JLabel place;
  
        ImageIcon img=new ImageIcon("place.jpeg");
      place =new JLabel("",img,JLabel.CENTER);
      place.setBounds(0,0,700,650);

        
     

        JPanel p = new JPanel();
        p.setLayout(null);

        CmCategory = new JComboBox();
        CmCategory.setBounds(193, 53, 182, 21);


        try {
            String sqlList = "Select coffeeType from coffee";
            Statement statement;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlList);

            while (rs.next()) {
                CmCategory.addItem(rs.getString("coffeeType"));


            }
        } catch (SQLException sQLException) {
        }

        CmCategory.addActionListener(v);

        lblBillID = new JLabel("Bill ID :");
        lblBillID.setForeground(Color.WHITE);
        lblBillID.setBounds(23, 17, 75, 42);
        lblBillID.setFont(new Font("Tahoma", Font.BOLD, 16));

        lblCustomerDetails = new JLabel("CustomerDetails :");
        lblCustomerDetails.setForeground(Color.WHITE);
        lblCustomerDetails.setBounds(23, 116, 128, 46);
        lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblCName = new JLabel("Customer Name :");
        lblCName.setForeground(Color.WHITE);
        lblCName.setBounds(24, 172, 127, 43);
        lblCName.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblPhoneNumber = new JLabel("PhoneNumber :");
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setBounds(24, 278, 127, 41);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblCmCategory = new JLabel("coffee type :");
        lblCmCategory.setForeground(Color.WHITE);
        lblCmCategory.setBounds(193, 11, 155, 32);
        lblCmCategory.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblQuantity = new JLabel("Quantity :");
        lblQuantity.setForeground(Color.WHITE);
        lblQuantity.setBounds(237, 137, 145, 13);
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblPrice = new JLabel("Price: ");
        lblPrice.setForeground(Color.WHITE);
        lblPrice.setBounds(460, 11, 82, 32);
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblTotal = new JLabel("Total :");
        lblTotal.setForeground(Color.WHITE);
        lblTotal.setBounds(460, 137, 55, 13);
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtBillID = new JTextField();
        txtBillID.setBounds(77, 29, 38, 19);
        txtBillID.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtCName = new JTextField();
        txtCName.setBounds(24, 225, 127, 53);
        txtCName.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(24, 329, 127, 42);
        txtPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtPrice = new JLabel();
        txtPrice.setBounds(510, 11, 145, 31);
        txtPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtPrice.setForeground(Color.WHITE);
        
        
        txtTotal = new JLabel();
        txtTotal.setBounds(520, 135, 55, 19);
        txtTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtTotal.setForeground(Color.WHITE);
        
        
        txtQuataty = new JTextField();
        txtQuataty.setBounds(237, 172, 145, 32);
        txtQuataty.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtQuataty.setForeground(Color.BLACK);
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(243, 270, 155, 39);
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnSave = new JButton("save");
        btnSave.setBounds(451, 270, 174, 37);
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnLogOut = new JButton("log out");
        btnLogOut.setBounds(451, 369, 174, 39);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnBack = new JButton("back");
        btnBack.setBounds(243, 369, 155, 39);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        
        btn_totPrice = new JButton("Get Total");
        btn_totPrice.setBounds(460, 160, 130, 39);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));

        p.add(lblBillID);
        p.add(lblCustomerDetails);
        p.add(lblCName);
        p.add(lblPhoneNumber);
        p.add(lblCmCategory);
        p.add(lblQuantity);
        p.add(lblPrice);
        p.add(lblTotal);

        p.add(btnClear);
        p.add(btnSave);
        p.add(btnBack);
        p.add(btnLogOut);
        p.add(btn_totPrice);

        p.add(txtBillID);

        p.add(txtCName);
        p.add(txtPhoneNumber);

        p.add(txtPrice);
        p.add(txtTotal);
        p.add(txtQuataty);
        p.add(CmCategory);
        p.add(place);
        btnSave.addActionListener(v);
        btnBack.addActionListener(v);
        btnLogOut.addActionListener(v);
        btnClear.addActionListener(v);
        btn_totPrice.addActionListener(v);
        p.setPreferredSize(new Dimension(700, 500));
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(p);
        setTitle("PlaceOrderPnl");
        pack();
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        

        public void actionPerformed(ActionEvent e) {

            try {

                Object selectedItem = CmCategory.getSelectedItem();
//                System.out.println(selectedItem);

                String sqlCoffee = "SELECT * FROM coffee WHERE CoffeeType = '" + selectedItem + "' ";
                Statement statement;
                statement = conn.createStatement();
                ResultSet results = statement.executeQuery(sqlCoffee);

                if (results.next()) {
                    price = results.getInt("Price");
//                    System.out.println(id);
                    txtPrice.setText("" + price + " EGP");
                    
                }

            } catch (SQLException sQLException) {
                System.out.println(sQLException);
            }

            if (e.getSource() == btnSave) {
                String billId = txtBillID.getText();
                String name = txtCName.getText();
                String phoneNumber = txtPhoneNumber.getText();
                String Quataty=txtQuataty.getText();
                 String Price=txtPrice.getText();
                String Total=lblTotal.getText();
                String CmCategory =lblCmCategory.getText();
               
                String sql = "INSERT INTO customer (orderNumber,Name,PhoneNumber) VALUES (?,?,?) ";
String sql2 = "INSERT INTO customer seller (orderNumber,quantity,Price,Total,Coffee Type) VALUES (?,?,?,?,?) ";
                try {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, billId);
                    stmt.setString(2, name);
                    stmt.setString(3, phoneNumber);
                     PreparedStatement stmt2 = conn.prepareStatement(sql2);
                      stmt2.setString(1, billId);
                      stmt2.setString(2, Quataty);
                      stmt2.setString(3, Price);
                     stmt2.setString(4, Total);
                     stmt2.setString(5, CmCategory);
                      
                      
                      
                      
                    
                    int order = stmt.executeUpdate();

                    if (order > 0) {
                        JOptionPane.showMessageDialog(null, "your order successfully added");
                    }

                } catch (SQLException exception) {
                    //  Logger.getLogger(PlaceOrderPnl.class.getName()).log(Level.SEVERE, null, ex);
                    // ex.printStackTrace();
                    exception.getMessage();
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
                //JOptionPane.showMessageDialog(null, "your order successfully added");
            }

            //   public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnLogOut) {
                int response = JOptionPane.showConfirmDialog(null, "are you sure u want to exit", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {

                    Panel1 k = new Panel1(conn);
                    dispose();
                } // System.out.println("yes select");}
                // if yes option select..
                else if (response == JOptionPane.NO_OPTION) {

                    System.out.println("No.. Option Selected..");
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("closed select");
                }
            }
            if (e.getSource() == CmCategory) {
                String combo = CmCategory.getSelectedItem().toString();
                String sql = "SELECT Price from coffee where CoffeeType = ' " + CmCategory + " ' ";// = "SELECT Price FROM coffee where CoffeeType =  ' "+combo" ' ";
                try {

                    Statement stmt = conn.createStatement();
                    ResultSet result = stmt.executeQuery(sql);
                    if (result.next()) {
                        String dbPrice = result.getString(3);
                        txtPrice.setText(dbPrice);

                    }
                    //   else
                    //{
                    //JOptionPane.showMessageDialog(null , "Error");
                    //}
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());;
                }
            }
            
            if(e.getSource() == btn_totPrice){
            
                double quantity = Integer.parseInt(txtQuataty.getText());
                
                double total = quantity*price;
                
                txtTotal.setText("" + total);
            }
        
        if (e.getSource()==btnBack){
        pnlHome o = new pnlHome(conn);
        dispose();
        }
       if (e.getSource()==btnClear){
       txtBillID.setText("");
       txtPhoneNumber.setText("");
       txtQuataty.setText("");
       txtCName.setText("");
       
       
       }
        
        }

        //@Override
     //   public boolean equals(Object o) {
       //     return super.equals(o); //To change body of generated methods, choose Tools | Templates.
        //}
  
    
    }
}     
    
    