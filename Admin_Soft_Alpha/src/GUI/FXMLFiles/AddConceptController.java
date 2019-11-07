/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.FXMLFiles;

import Classes.SQLProcedures;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddConceptController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAdd.setOnAction(e -> onClick());
    }

    public void onClick() {

        if (validateFields()) {
            SQLProcedures sql = new SQLProcedures();
            sql.insertConcept(Integer.parseInt(txtId.getText()), txtName.getText());
            clearFields();
            new Alert(Alert.AlertType.INFORMATION, "Agregado correctamente :D", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Faltan campos por rellenar", ButtonType.OK).show();
        }
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
    }

    public boolean validateFields() {
        return !(txtName.getText().trim().equals("") || txtId.getText() == null);

    }

}
