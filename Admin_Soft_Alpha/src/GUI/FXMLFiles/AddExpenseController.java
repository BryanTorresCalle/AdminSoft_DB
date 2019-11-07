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
public class AddExpenseController implements Initializable {

    @FXML
    private TextField txtValue;
    @FXML
    private TextField txtId;
    @FXML
    private DatePicker dtpDatePay;
    @FXML
    private ComboBox<Concept> cmbConcept;
    @FXML
    private ComboBox<Company> cmbCompany;
    @FXML
    private Button btnAdd;
    private ObservableList<Concept> dataConcept;
    private ObservableList<Company> dataCompany;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAdd.setOnAction(e -> onClick());
        fillCmb();
        fillCmb2();
        //TODO: traer de la db la info de las empresas y los conceptos para cargar en comboxes
    }

    public void onClick() {

        if (validateFields()) {
            SQLProcedures sql = new SQLProcedures();
            sql.insertExpense(txtId.getText(),Double.parseDouble(txtValue.getText()),
                    dtpDatePay.getValue().toString() ,cmbConcept.getValue().getId(), cmbCompany.getValue().getId());
            clearFields();
            new Alert(Alert.AlertType.INFORMATION, "Agregado correctamente :D", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Faltan campos por rellennar", ButtonType.OK).show();
        }

    }

    public boolean validateFields() {

        return !(txtValue.getText().trim().equals("")
                || dtpDatePay.getValue() == null || cmbConcept.getValue() == null || cmbCompany.getValue() == null);

    }

    private void fillCmb() {
        try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            dataConcept = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from conceptos");
            while (rs.next()) {
                dataConcept.add(new Concept(Integer.parseInt(rs.getString(1)), rs.getString(2)));
            }
            cmbConcept.setItems(dataConcept);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }

    private void fillCmb2() {
         try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            dataCompany = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from entidades");
            while (rs.next()) {
                dataCompany.add(new Company(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            cmbCompany.setItems(dataCompany);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }

    private void clearFields() {
        txtId.clear();
        txtValue.clear();
    }

}
