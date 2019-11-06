/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class SQLProcedures {
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbedificio?"
                    + "useTimeZone=true&serverTimeZone=UTC";
            String user = "root";
            
            Connection myCon = DriverManager.getConnection(url,user,"");
            return myCon;
    }
}
