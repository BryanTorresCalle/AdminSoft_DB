/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.Company;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddCompanyController implements Initializable {
    @FXML
    private TextField txtID;
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
    private Button btnAdd;
    private ObservableList<Concept> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAdd.setOnAction(e -> onClick());
        fillCmb();
    }

    public void onClick() {

        if (validateFields()) {
            SQLProcedures proc = new SQLProcedures();
           proc.insertCompany(txtID.getText(), txtNIT.getText(), txtName.getText(),
                   txtMail.getText(),txtPhone.getText(),cmbConcept.getValue().getId());
            new Alert(Alert.AlertType.INFORMATION, "Agregado correctamente :D", ButtonType.OK).show();
            clearFields();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Faltan campos por rellenar", ButtonType.OK).show();
        }

    }
    
    
    public boolean validateFields() {

        return !(txtNIT.getText().trim().equals("") || txtName.getText() == null
                || cmbConcept.getValue() == null || txtPhone.getText() == null || txtMail.getText() == null);

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

    private void clearFields() {
        txtID.clear();
        txtMail.clear();
        txtNIT.clear();
        txtName.clear();
        txtPhone.clear();
    }
    
    
}
