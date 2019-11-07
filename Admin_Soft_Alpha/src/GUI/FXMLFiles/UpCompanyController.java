/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class UpCompanyController implements Initializable {

    @FXML
    private Label lblId;
    @FXML
    private TextField txtNIT;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<Concept> cmbConcept;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtMail;
    @FXML
    private Button btnUp;
    
    private ObservableList<Concept> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        fillCmb();
        btnUp.setOnAction( e -> update(txtNIT.getText(), txtName.getText(), 
                txtMail.getText(), 
                txtPhone.getText(),CompaniesController.compSelected.getId() , 
                 cmbConcept.getValue().getId()));
        
    }    
    
    private void load(){
        
        txtNIT.setText(CompaniesController.compSelected.getNit());
        lblId.setText( "ID: " + CompaniesController.compSelected.getId());
        txtName.setText(CompaniesController.compSelected.getName());
        txtPhone.setText(CompaniesController.compSelected.getPhone());
        txtMail.setText(CompaniesController.compSelected.getEmail());
        
    }
    
    
        private void update(String nit, String name, String mail, String phone, String id, int idConcept){
         SQLProcedures con = new SQLProcedures();
        try {
            
            Connection connect = con.getConnection();
            connect.createStatement().executeUpdate("Update entidades set nit ="
                    + " \'" + nit + "\', nombre= \'" + name + "\', correo= \'" +
                    mail + "\', telefono= \'" + phone + "\' where id = " + id);
            connect.createStatement().executeUpdate("Update conceptos_entidades "
                    + "set idConcepto= \'" + idConcept + "\' where idEntidad = " + id);
            
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
            ResultSet rs = connect.createStatement().executeQuery("Select * from conceptos");
            while (rs.next()) {
                data.add(new Concept(Integer.parseInt(rs.getString(1)),rs.getString(2)));
            }
            cmbConcept.setItems(data);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
}
