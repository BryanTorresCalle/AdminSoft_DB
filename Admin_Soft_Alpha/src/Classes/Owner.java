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
public class Owner {

    private final IntegerProperty id;
    private final IntegerProperty dni;
    private final StringProperty name;
    private final StringProperty eMail;
    private final StringProperty phone;

    public Owner(int id, int dni, String name, String eMail, String phone) {
        this.id = new SimpleIntegerProperty(id);
        this.dni = new SimpleIntegerProperty(dni);
        this.name = new SimpleStringProperty(name);
        this.eMail = new SimpleStringProperty(eMail);
        this.phone = new SimpleStringProperty(phone);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    
    public int getDni(){
        return dni.get();
    }
    
    public void setDni(int dni){
        this.dni.set(dni);
    }
    
    public IntegerProperty dniProperty(){
        return dni;
    }
    
    public String getName(){
        return name.get();
    }
    
    public void setName(String name){
        this.name.set(name);
    }
    
    public StringProperty nameProperty(){
        return name;
    }
    
    public String getEmail(){
        return eMail.get();
    }
    
    public void setEmail(String eMail){
        this.eMail.set(eMail);
    }
    
    public StringProperty emailProperty(){
        return eMail;
    }
    
    public String getPhone(){
        return phone.get();
    }
    
    public void setPhone(String phone){
        this.phone.set(phone);
    }
    
    public StringProperty phoneProperty(){
        return phone;
    }
}
