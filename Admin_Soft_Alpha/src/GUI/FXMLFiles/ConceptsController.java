/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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
    private TableView tblCompanies;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAddConcept.setOnAction(e -> toScreen("FXMLAddConcept.fxml") );
    }    

    private void toScreen(String screen) {
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
