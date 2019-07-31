package com.trilogy.shippingservice.viewModel;

import com.trilogy.shippingservice.model.Invoice;
import com.trilogy.shippingservice.model.InvoiceItem;

import javax.persistence.*;

public class InvoiceItemView {
    private int invoiceItemId;
    private int invoiceId;
    private String itemName;
    private String itemDescription;
    private int weight;
    private double shipCost;

    public InvoiceItemView(){}

    public InvoiceItemView(InvoiceItem invoiceItem) {
        this.invoiceItemId = invoiceItem.getInvoiceItemId();
        this.invoiceId = invoiceItem.getInvoiceId();
        this.itemName = invoiceItem.getItemName();
        this.itemDescription = invoiceItem.getItemDescription();
        this.weight = invoiceItem.getWeight();
        this.shipCost = invoiceItem.getShipCost();
    }

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getShipCost() {
        return shipCost;
    }

    public void setShipCost(double shipCost) {
        this.shipCost = shipCost;
    }

}
