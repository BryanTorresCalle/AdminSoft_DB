package GUI.FXMLFiles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class Admin_Soft_Alpha extends Application {
    
    public static ArrayList<String> aptos = new ArrayList(){{
        add("9702"); add("9703"); add("9801"); add("9802"); add("9803"); 
        add("9804"); add("9901"); add("9902"); add("9903"); add("9904");
        add("101"); add("102"); add("103"); add("104"); add("201"); add("202");
        add("203"); add("204"); add("301"); add("302"); add("303"); add("304"); 
        add("401"); add("402"); add("403"); add("404"); add("501"); add("502");
        add("503"); add("504"); add("601"); add("602"); add("603"); add("604"); 
        
    }};
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    
    }
    
}
