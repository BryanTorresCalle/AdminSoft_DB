/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Usuario
 */
public class Concept {
    private final IntegerProperty id;
    private final StringProperty description;
    
    public Concept(int id, String description){
       this.id = new  SimpleIntegerProperty(id);
       this.description = new SimpleStringProperty(description);
    }
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int id){
        this.id.set(id);
    }
    
    public IntegerProperty idProperty(){
        return id;
    }
    
    public String getDescription(){
        return description.get();
    }
    
    public void setDescription(String description){
        this.description.set(description);
    }
    
    public StringProperty descriptionProperty(){
        return description;
    }
    @Override
    public String toString(){
      return description.get();  
    }
}
