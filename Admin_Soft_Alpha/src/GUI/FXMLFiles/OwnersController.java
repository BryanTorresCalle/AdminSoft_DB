/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.Company;
import Classes.Owner;
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
public class OwnersController implements Initializable {

    @FXML
    private Button btnAddOwner;
    @FXML
    private Button btnEditOwner;
    @FXML
    private Button btnDelOwner;
    @FXML
    private TableView<Owner> tblOwners;
    @FXML
    private TableColumn<Owner, Integer> Id;
    @FXML
    private TableColumn<Owner, Integer> Cedula;
    @FXML
    private TableColumn<Owner, String> Nombre;
    @FXML
    private TableColumn<Owner, String> Apto;
    @FXML
    private TableColumn<Owner, String> Correo;
    @FXML
    private TableColumn<Owner, String> Telefono;
    @FXML
    private TableColumn<Owner, Integer> Saldo;

    private ObservableList<Owner> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAddOwner.setOnAction(e -> toScreen("FXMLAddOwner.fxml"));
       // btnRefresh.setOnAction(e -> fill());
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

}
