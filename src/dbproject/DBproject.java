/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ideapad_Gaming3
 */
public class DBproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        String URl = "jdbc:ucanaccess://coffeeDB.accdb";
        Connection conn  ;
        try {
            conn = DriverManager.getConnection(URl);
            System.out.println("Connected to DB");
       Panel1 p = new Panel1(conn);
         //  PlaceOrderPnl o =new PlaceOrderPnl(conn);
         //   PnlNewProduct n = new PnlNewProduct(conn);
       //    Order o= new Order();
        //    pnlHome h= new pnlHome();
   //   signUp r=new signUp();
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }
        
    }
    
}
