/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.Company;
import Classes.Concept;
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
public class ConceptsController implements Initializable {

    @FXML
    private Button btnAddConcept;
    @FXML
    private Button btnEditConcept;
    @FXML
    private Button btnDelConcept;
    @FXML
    private TableView tblConcepts;
    @FXML
    private TableColumn<Concept, String> Id;
    @FXML
    private TableColumn<Concept, String> Nombre;
    @FXML

    private ObservableList<Concept> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAddConcept.setOnAction(e -> toScreen("FXMLAddConcept.fxml"));
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
            ResultSet rs = connect.createStatement().executeQuery("Select * from conceptos");
            while (rs.next()) {
                data.add(new Concept(Integer.parseInt(rs.getString(1)), rs.getString(2)));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nombre.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblConcepts.setItems(null);
        tblConcepts.setItems(data);

    }

}
