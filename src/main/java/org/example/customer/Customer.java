package org.example.customer;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String customerName;
    private String orderNummer;
    private int chek;
    private String customerAdress;

    public Customer() {
    }

    public Customer(String customerName, String orderNummer, int chek, String customerAdress) {
        this.customerName = customerName;
        this.orderNummer = orderNummer;
        this.chek = chek;
        this.customerAdress = customerAdress;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNummer() {
        return orderNummer;
    }

    public void setOrderNummer(String orderNummer) {
        this.orderNummer = orderNummer;
    }

    public int getChek() {
        return chek;
    }

    public void setChek(int chek) {
        this.chek = chek;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", customerName='" + customerName + '\'' +
                ", orderNummer='" + orderNummer + '\'' +
                ", chek=" + chek +
                ", customerAdress='" + customerAdress + '\'' +
                '}';
    }
}
