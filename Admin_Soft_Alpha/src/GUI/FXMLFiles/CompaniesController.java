/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.Company;
import Classes.SQLProcedures;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class CompaniesController implements Initializable {

    @FXML
    private Button btnAddCompany;
    @FXML
    private Button btnEditCompany;
    @FXML
    private Button btnDelCompany;
    @FXML
    private TableView<Company> tblCompnaies;
    @FXML
    private TableColumn<Company, String> Id;
    @FXML
    private TableColumn<Company, String> Nit;
    @FXML
    private TableColumn<Company, String> Nombre;
    @FXML
    private TableColumn<Company, String> Telefono;
    @FXML
    private TableColumn<Company, String> Correo;

    private ObservableList<Company> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAddCompany.setOnAction(e -> toScreen("FXMLAddCompany.fxml"));
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

    public void fill() {
        try {
            SQLProcedures con = new SQLProcedures();
            Connection connect = con.getConnection();
            data = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("Select * from entidades");
            while (rs.next()) {
                data.add(new Company(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        Nombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        Telefono.setCellValueFactory(new PropertyValueFactory<>("email"));
        Correo.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tblCompnaies.setItems(null);
        tblCompnaies.setItems(data);

    }
}
