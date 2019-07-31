package com.trilogy.shippingservice.viewModel;

import com.trilogy.shippingservice.model.Invoice;
import com.trilogy.shippingservice.model.InvoiceItem;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InvoiceView {
    private int invoiceId;
    private int customerId;
    private String shipToZip;
    private LocalDate date;
    private double totalCost;
    private double salesTax;
    private double surCharge;
    private Set<InvoiceItemView> invoiceItemSet = new HashSet<>();

    public InvoiceView(){}

    public InvoiceView(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.customerId = invoice.getCustomerId();
        this.shipToZip = invoice.getShipToZip();
        this.date = invoice.getDate();
        this.totalCost = invoice.getTotalCost();
        this.salesTax = invoice.getSalesTax();
        this.surCharge = invoice.getSurCharge();
        for(InvoiceItem invoiceItem : invoice.getInvoiceItemSet()){
            invoiceItemSet.add(new InvoiceItemView(invoiceItem));
        }
    }

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

    public Set<InvoiceItemView> getInvoiceItemSet() {
        return invoiceItemSet;
    }

    public void setInvoiceItemSet(Set<InvoiceItemView> invoiceItemSet) {
        this.invoiceItemSet = invoiceItemSet;
    }
}
