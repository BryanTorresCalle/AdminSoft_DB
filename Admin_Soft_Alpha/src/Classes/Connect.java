/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class Connect {

    private String url = "jdbc:mysql://localhost:3306/taller3def?"
            + "useTimeZone=true&serverTimeZone=UTC";
    private String user = "root";

    public void conect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myCon = DriverManager.getConnection(url,user,"");
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
