/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Usuario
 */
public class Expense {

    private final StringProperty id;
    private final DoubleProperty value;
    private final StringProperty paymentDate;
    private final StringProperty idConcept;
    private final StringProperty idCompany;

    public Expense(String id, double value, String paymentDate, String idConcept, String idCompany) {
        this.id = new SimpleStringProperty(id);
        this.value = new SimpleDoubleProperty(value);
        this.paymentDate = new SimpleStringProperty(paymentDate);
        this.idConcept = new SimpleStringProperty(idConcept);
        this.idCompany = new SimpleStringProperty(idCompany);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public double getValue() {
        return value.get();
    }

    public void setValue(double value) {
        this.value.set(value);
    }

    public DoubleProperty valueProperty() {
        return value;
    }

    public String getPaymentDate() {
        return paymentDate.get();
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate.set(paymentDate);
    }

    public StringProperty PaymentDateProperty() {
        return paymentDate;
    }

    public String getIdConcept() {
        return idConcept.get();
    }

    public void setIdConcept(String idConcept) {
        this.idConcept.set(idConcept);
    }

    public StringProperty idConceptProperty() {
        return idConcept;
    }

    public String getIdCompany() {
        return idCompany.get();
    }
    
    public void setIdCompany(String idCompany){
        this.idCompany.set(idCompany);
    }
    
    public StringProperty idCompanyProperty(){
        return idCompany;
    }
}
