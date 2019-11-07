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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class UpExpenseController implements Initializable {

    @FXML
    private TextField txtValue;
    @FXML
    private Label lblId;
    @FXML
    private DatePicker dtpDatePay;
    @FXML
    private ComboBox<Concept> cmbConcept;
    @FXML
    private ComboBox<Company> cmbCompany;
    @FXML
    private Button btnUp;
    
    private ObservableList<Concept> data1;
    private ObservableList<Company> data2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        fillCmb();
        fillCmb2();
        btnUp.setOnAction(e -> update(txtValue.getText(), dtpDatePay.getValue().toString(),
                cmbCompany.getValue().getId(),
                ExpensesController.selected.getId(),
                cmbConcept.getValue().getId()));
    }

    private void load() {

        txtValue.setText("" + ExpensesController.selected.getValue());
        lblId.setText("ID: " + ExpensesController.selected.getId());

    }

    private void update(String value, String date, String idCompany, String id, int idConcept) {
        SQLProcedures con = new SQLProcedures();
        try {

            Connection connect = con.getConnection();
            connect.createStatement().executeUpdate("Update gastos set valor ="
                    + value + ", fechaPago= \'" + date + "\', idEntidad= "
                    + idCompany + ", idConcepto= " + idConcept + " where id = " + id);

            new Alert(Alert.AlertType.INFORMATION, "Se ha modificado con exito :D", ButtonType.OK).show();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }

    }

    private void fillCmb() {
        try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            data1 = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from conceptos");
            while (rs.next()) {
                data1.add(new Concept(Integer.parseInt(rs.getString(1)), rs.getString(2)));
            }
            cmbConcept.setItems(data1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
     private void fillCmb2() {
        try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            data2 = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from entidades");
            while (rs.next()) {
                data2.add(new Company(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            cmbCompany.setItems(data2);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
    }

}

