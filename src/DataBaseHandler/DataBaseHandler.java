/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHandler {

    private static DataBaseHandler handler;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/datawarehouse?autoReconnect=true&useSSL=false";
    private final String user = "Adeel";
    private final String password = "995533";
    private Connection con;
    private Statement stmnt;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public DataBaseHandler() {
        createConnection();
    }

    public static DataBaseHandler getInstance() {
            if (handler == null) {
            handler = new DataBaseHandler();
        }
        return handler;
    }

    void createConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public int execute(String ddl) {
        int reocordsAffected;
        try {
            stmnt = con.createStatement();
            reocordsAffected = stmnt.executeUpdate(ddl);
            return reocordsAffected;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public ResultSet executeQuery(String dml) {
        ResultSet result;
        try {
            stmnt = con.createStatement();
            result = stmnt.executeQuery(dml);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return result;
    }
}
