/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import DataBaseHandler.DataBaseHandler;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adeel
 */
public class DataWarehouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DataBaseHandler db = DataBaseHandler.getInstance();
            ResultSet rs = db.executeQuery("select * from authors");
            System.out.println("Id \t name ");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t" + rs.getString("firstname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataWarehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
