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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class MainController implements Initializable {
    
    @FXML
    private Button btnIncomes;
    @FXML
    private Button btnExpenses;
    @FXML
    private Button btnOwners;
    @FXML
    private Button btnCompanies;
    @FXML
    private Button btnConcepts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnIncomes.setOnAction(e -> toScreen("FXMLIncome.fxml") );
        btnExpenses.setOnAction(e -> toScreen("FXMLExpenses.fxml") );
        btnOwners.setOnAction(e -> toScreen("FXMLOwners.fxml") );
        btnCompanies.setOnAction(e -> {
            toScreen("FXMLCompanies.fxml");
                });
        btnConcepts.setOnAction(e -> toScreen("FXMLConcepts.fxml") );
    }


    /**
     * Metodo para cambiar de pantalla 
     * @param screen nombre del archivo fxml
     */
    public void toScreen(String screen){     
          
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

