/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.Company;
import Classes.Expense;
import Classes.SQLProcedures;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ExpensesController implements Initializable {

    @FXML
    private Button btnAddExpense;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnEditExpense;
    @FXML
    private Button btnDelExpense;
    @FXML
    private TableView tblExpenses;
    @FXML
    private TableColumn<Expense, Integer> Id;
    @FXML
    private TableColumn<Expense, String> Valor;
    @FXML
    private TableColumn<Expense, String> FechaPago;
    @FXML
    private TableColumn<Expense, String> Concepto;
    @FXML
    private TableColumn<Expense, String> Entidad;

    private ObservableList<Expense> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAddExpense.setOnAction(e -> toScreen("FXMLAddExpense.fxml"));
        btnRefresh.setOnAction(e -> fill());
        fill();
    }

    public void toScreen(String screen) {

        try {

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource(screen));
            Stage stage = new Stage();
            stage.setScene(new Scene(fXMLLoader.load(), 600, 400));
            stage.show();

        } catch (IOException ex) {

            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fill() {
        try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from view_gastos");
            while (rs.next()) {
                data.add(new Expense(rs.getString(1), Double.parseDouble(rs.getString(2)),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Valor.setCellValueFactory(new PropertyValueFactory<>("value"));
        FechaPago.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        Concepto.setCellValueFactory(new PropertyValueFactory<>("idConcept"));
        Entidad.setCellValueFactory(new PropertyValueFactory<>("idCompany"));
        tblExpenses.setItems(null);
        tblExpenses.setItems(data);
    }

}
