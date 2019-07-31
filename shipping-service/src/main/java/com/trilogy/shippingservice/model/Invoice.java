package com.trilogy.shippingservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceId;
    private int customerId;
    private String shipToZip;
    private LocalDate date;
    private double totalCost;
    private double salesTax;
    private double surCharge;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<InvoiceItem> invoiceItemSet = new HashSet<>();

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getShipToZip() {
        return shipToZip;
    }

    public void setShipToZip(String shipToZip) {
        this.shipToZip = shipToZip;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getSurCharge() {
        return surCharge;
    }

    public void setSurCharge(double surCharge) {
        this.surCharge = surCharge;
    }

    public Set<InvoiceItem> getInvoiceItemSet() {
        return invoiceItemSet;
    }

    public void setInvoiceItemSet(Set<InvoiceItem> invoiceItemSet) {
        this.invoiceItemSet = invoiceItemSet;
    }
}


/*
create table if not exists invoice (
	  invoice_id int(11) not null auto_increment primary key,
    customer_id int(11) not null,
    shipto_zip char(5) not null,
    purchase_date date not null,
    total_cost decimal(7.2) not null,
    sales_tax decimal(7.2) not null,
    surcharge decimal(7,2) not null
);


 */