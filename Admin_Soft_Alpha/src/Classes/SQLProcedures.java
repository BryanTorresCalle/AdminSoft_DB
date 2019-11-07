/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SQLProcedures {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dbedificio?"
                + "useTimeZone=true&serverTimeZone=UTC";
        String user = "root";

        Connection myCon = DriverManager.getConnection(url, user, "");
        return myCon;
    }

    public void insertCompany(String id, String nit, String name, String email, String phone, int concept) {
        try {
            Connection conect = getConnection();
            String sql = "Insert into entidades(id,nit,nombre,correo,telefono) values ('" + id + "','" + nit + "','" + name + "','" + email + "','" + phone + "')";
            String sql2 = "insert into conceptos_entidades(idConcepto,idEntidad) values ('" + concept + "','" + id + "')";
            conect.createStatement().executeUpdate(sql);
            conect.createStatement().executeUpdate(sql2);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }

    public void insertConcept(int id, String name) {
        try {
            Connection conect = getConnection();
            String sql = "insert into conceptos(id,nombre) values('" + id + "','" + name + "')";
            conect.createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
    public void insertExpense(String id,double value,String paymentDate,int idConcept,String idCompany){
        try {
            Connection conect = getConnection();
            String sql = "insert into gastos(id,valor,fechaPago,idConcepto,idEntidad)"
                    + " values('" + id + "','" + value + "','"+paymentDate+"','"+idConcept+"','"+idCompany+"')";
            conect.createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
    public void insertIncome(int id,double value,String paymentDate,int aptoId){
        try {
            Connection conect = getConnection();
            String sql = "insert into ingresos(id,valor,fechaPago,idApto) values"
                    + "('"+id+"','"+value+"','"+paymentDate+"','"+aptoId+"')";
            conect.createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    public void insertOwner(int id,int cedula,String nombre,String correo,String telefono){
         try {
            Connection conect = getConnection();
            String sql = "insert into propietarios(id,cedula,nombre,correo,telefono)"
                    + "values('"+id+"','"+cedula+"','"+nombre+"','"+correo+"','"+telefono+"')";
            conect.createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
    public void del(String table, int id){
        try {
            Connection conect = getConnection();
            String sql = "delete  from " + table + "where id=" + id;
            conect.createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: "+ ex.toString());
        } 
        
        
        
    }
}
