package com.trilogy.shippingedgeservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Invoice {
    private int invoiceId;
    private int customerId;
    private String shipToZip;
    @JsonDeserialize
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate date;
    private double totalCost;
    private double salesTax;
    private double surCharge;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                customerId == invoice.customerId &&
                Double.compare(invoice.totalCost, totalCost) == 0 &&
                Double.compare(invoice.salesTax, salesTax) == 0 &&
                Double.compare(invoice.surCharge, surCharge) == 0 &&
                Objects.equals(shipToZip, invoice.shipToZip) &&
                Objects.equals(date, invoice.date) &&
                Objects.equals(invoiceItemSet, invoice.invoiceItemSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, customerId, shipToZip, date, totalCost, salesTax, surCharge, invoiceItemSet);
    }
}
