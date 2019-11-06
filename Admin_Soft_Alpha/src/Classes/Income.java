/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Usuario
 */
public class Income {
    private final IntegerProperty id;
    private final DoubleProperty value;
    private final StringProperty paymentDate;
    private final IntegerProperty aptoId;

    public Income(int id, double value, String paymentDate, int aptoId){
        this.aptoId = new SimpleIntegerProperty(aptoId);
        this.paymentDate = new SimpleStringProperty (paymentDate);
        this.id = new SimpleIntegerProperty(id);
        this.value = new SimpleDoubleProperty(value);
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
   
   public double getValue(){
       return value.get();
   }
    
   public void setValue(double value){
       this.value.set(value);
   }
   
   public DoubleProperty valueProperty(){
       return value;
   }
   
   public String getPaymentDate(){
       return paymentDate.get();
   }
   
   public void setPaymentDate(String paymentDate){
       this.paymentDate.set(paymentDate);
   }
   
   public StringProperty paymentDateProperty(){
       return paymentDate;
   }
   
   public int getApartmentId(){
       return aptoId.get();
   }
   
   public void setApartmentId(int aptoId){
       this.aptoId.set(aptoId);
   }
   
   public IntegerProperty aptoIdProperty(){
       return aptoId;
   }
}
