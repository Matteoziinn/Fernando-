package org.app.gerparque.models;

import java.time.LocalDate;

public class Ticket {
    private Integer id;
    private Integer idclientUser;
    private Integer idBoxoffice;
    private String eventName;
    private LocalDate dateVenda;
    private String PaymentMethod;

    public Ticket() {
    }

    public Ticket(Integer id, Integer idclientUser, Integer idBoxoffice,
                  String eventName, LocalDate dateVenda, String paymentMethod) {
        this.id = id;
        this.idclientUser = idclientUser;
        this.idBoxoffice = idBoxoffice;
        this.eventName = eventName;
        this.dateVenda = dateVenda;
        PaymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdclientUser() {
        return idclientUser;
    }

    public void setIdclientUser(Integer idclientUser) {
        this.idclientUser = idclientUser;
    }

    public Integer getIdBoxoffice() {
        return idBoxoffice;
    }

    public void setIdBoxoffice(Integer idBoxoffice) {
        this.idBoxoffice = idBoxoffice;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return dateVenda;
    }

    public void setEventDate(LocalDate dateVenda) {
        this.dateVenda = dateVenda;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }
}
