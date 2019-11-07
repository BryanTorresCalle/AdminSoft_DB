/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.SQLProcedures;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class UpConceptController implements Initializable {
    
    @FXML
    private TextField txtName;
    @FXML
    private Label lblId;
    @FXML
    private Button btnUp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        btnUp.setOnAction(e -> update(txtName.getText(), ConceptsController.selected.getId()));
    }    
    
    private void load() {

        txtName.setText("" + ConceptsController.selected.getDescription());
        lblId.setText("ID: " + ConceptsController.selected.getId());

    }
    
     private void update(String name,int id) {
        SQLProcedures con = new SQLProcedures();
        try {

            Connection connect = con.getConnection();
            connect.createStatement().executeUpdate("Update conceptos set nombre =\'"
                    + name + "\' where id = " + id);

            new Alert(Alert.AlertType.INFORMATION, "Se ha modificado con exito :D", ButtonType.OK).show();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }

    }
}
