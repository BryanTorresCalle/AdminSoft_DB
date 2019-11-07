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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddIncomeController implements Initializable {

    @FXML
    private TextField txtValue;
    @FXML
    private TextField txtId;
    @FXML
    private DatePicker dtpDatePay;
    @FXML
    private ComboBox<Apartment> cmbApto;
    @FXML
    private Button btnAdd;
    private ObservableList<Apartment> data;

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
            SQLProcedures sql = new SQLProcedures();
            sql.insertIncome(Integer.parseInt(txtId.getText()),
                    Double.parseDouble(txtValue.getText()), dtpDatePay.getValue().toString(),
                    Integer.parseInt(cmbApto.getValue().getId()));
            clearFields();
            new Alert(Alert.AlertType.INFORMATION, "Agregado correctamente :D", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Faltan campos por rellenar", ButtonType.OK).show();
        }

    }

    public boolean validateFields() {

        return !(txtValue.getText().trim().equals("") || dtpDatePay.getValue() == null || cmbApto.getValue() == null);

    }

    private void clearFields() {
        txtId.clear();
        txtValue.clear();
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
