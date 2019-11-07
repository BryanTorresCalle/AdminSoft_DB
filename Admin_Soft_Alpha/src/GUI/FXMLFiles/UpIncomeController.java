/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.Apartment;
import Classes.Concept;
import Classes.SQLProcedures;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class UpIncomeController implements Initializable {

    @FXML
    private Label lblId;
    @FXML
    private TextField txtValue;
    @FXML
    private DatePicker dtpDatePay;
    @FXML
    private ComboBox<Apartment> cmbApto;
    @FXML
    private Button btnUp;
    
    private ObservableList<Apartment> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          load();
        fillCmb();
        btnUp.setOnAction( e -> update(txtValue.getText(), dtpDatePay.getValue().toString(), 
                  cmbApto.getValue().getId(), IncomeController.selected.getId()));
    }    
    private void load(){
        
        txtValue.setText("" + IncomeController.selected.getValue());
        lblId.setText( "ID: " + IncomeController.selected.getId());
       
        
    }
    
    
        private void update(String value, String date, String apto, int id){
         SQLProcedures con = new SQLProcedures();
        try {
            
            Connection connect = con.getConnection();
            connect.createStatement().executeUpdate("Update ingresos set valor ="
                     + value + ", fechaPago= \'" + date + "\', idApto= \'" + apto + "\' where id = " + id);
            
            new Alert(Alert.AlertType.INFORMATION, "Se ha modificado con exito :D", ButtonType.OK).show();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
        
    }
        
        
        
        private void fillCmb() {
        try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from aptos");
            while (rs.next()) {
                data.add(new Apartment(rs.getString(1),rs.getString(2)));
            }
            cmbApto.setItems(data);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
}
