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
public class Apartment {
    private final StringProperty id;
    private final StringProperty number;
    
    public Apartment(String id,String number){
        this.id = new SimpleStringProperty(id);
        this.number = new SimpleStringProperty(number);
    }
    
    public String getId(){
        return id.get();
    }
    
    public void setId(String id){
        this.id.set(id);
    }
    
    public StringProperty idProperty(){
        return id;
    }
    
    public String getNumber(){
        return number.get();
    }
    
    public void setNumber(String number){
        this.number.set(number);
    }
    
    public StringProperty numberProperty(){
        return number;
    }
    
    @Override
    public String toString(){
        return  number.get();
    }
}
