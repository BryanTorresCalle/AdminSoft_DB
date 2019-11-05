/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    private DatePicker dtpDatePay;
    @FXML
    private ComboBox cmbApto;
    @FXML
    private Button btnAdd;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAdd.setOnAction(e -> onClick() );
        cmbApto.setItems(FXCollections.observableArrayList(Admin_Soft_Alpha.aptos));
    }

    public void onClick(){
        
        if(validateFields()){
            // TODO Weas SQL
            new Alert(Alert.AlertType.INFORMATION, "Agregado correctamente :D", ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Faltan campos por rellennar", ButtonType.OK).show();
        } 
            
        
        
        
    }
    
    public boolean validateFields(){
        
        return !(txtValue.getText().trim().equals("") || dtpDatePay.getValue() == null || cmbApto.getValue() == null );
        
    }
    
}
