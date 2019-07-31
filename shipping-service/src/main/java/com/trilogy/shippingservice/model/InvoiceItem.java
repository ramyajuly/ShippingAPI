package com.trilogy.shippingservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InvoiceItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceItemId;
    private int invoiceId;
    private String itemName;
    private String itemDescription;
    private int weight;
    private double shipCost;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}

/*

create table if not exists invoice_item (
	  invoice_item_id int(11) not null auto_increment primary key,
    invoice_id int(11) not null,
    item_name varchar(50) not null,
    item_description varchar(255) not null,
    weight int(11) not null,
    ship_cost decimal(7,2) not null
);
 */