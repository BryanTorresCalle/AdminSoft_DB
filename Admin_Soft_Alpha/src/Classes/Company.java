/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Company {
    private final StringProperty id;
    private final StringProperty nit;
    private final StringProperty name;
    private final StringProperty eMail;
    private final StringProperty phone;

   
    public Company(String id,String nit,String nombre,String correo,String telefono){
           this.id = new SimpleStringProperty(id);
           this.nit = new SimpleStringProperty(nit);
           this.name = new SimpleStringProperty(nombre);
           this.eMail = new SimpleStringProperty(correo);
           this.phone = new SimpleStringProperty(telefono);
    }
    
    //Test
    public String getId(){
        return id.get();
    }
    
    public void setId(String id){
        this.id.set(id);
    }
    
    public StringProperty idProperty(){
        return id;
    }
    
    public String getNit(){
        return nit.get();
    }
    
    public void setNit(String nit){
        this.nit.set(nit);
    }
    
    public StringProperty nitProperty(){
        return nit;
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
    
    public StringProperty StringPhone(){
        return phone;
    }
    
    
    

}
