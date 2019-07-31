package com.trilogy.shippingedgeservice.service;

import com.trilogy.shippingedgeservice.feign.ShippingClient;
import com.trilogy.shippingedgeservice.model.Invoice;
import com.trilogy.shippingedgeservice.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class ShippingServiceLayer {

    @Autowired
    ShippingClient client;

    public ShippingServiceLayer(ShippingClient client) {
        this.client = client;
    }

    //Shiping cost
    private static final double SHIP_COST_ZIP_CODE_ZERO_ONE_TWO = 9.99;
    private static final double SHIP_COST_ZIP_CODE_THREE = 14.99;
    private static final double SHIP_COST_ZIP_CODE_FOUR_FIVE_SIX = 19.99;
    private static final double SHIP_COST_ZIP_CODE_SEVEN_EIGHT_NINE = 24.99;

    //surcharge
    private static final double SURCHARGE_COST_OVER_TEN_POUNDS =8.50;
    private static final double SURCHARGE_COST_OVER_SEVENTEEN_POUNDS =12.50;
    private static final double SURCHARGE_COST_OVER_TWENTYFIVE_POUNDS =19.99;
    private static final double SURCHARGE_COST_OVER_THIRTYFIVE_POUNDS =50.00;

    //SalesTax
    private static final double SALES_TAX =0.072;



    public Invoice  submitInvoice(Invoice invoice){
        double totalPounds=0;
        double totalShipCost=0;

        Set<InvoiceItem> invoiceItemViewSet = invoice.getInvoiceItemSet();
        for(InvoiceItem item:invoiceItemViewSet){
            item.setShipCost(calculateShipCost(invoice.getShipToZip()));
            totalPounds +=item.getWeight();
        }
        totalShipCost = calculateShipCost(invoice.getShipToZip()) * invoiceItemViewSet.size();
        invoice.setInvoiceItemSet(invoiceItemViewSet);
        invoice.setSurCharge(calculateSurcharge(totalPounds));
        invoice.setSalesTax(calculateSalesTax(totalShipCost,invoice.getSurCharge()));
        invoice.setTotalCost(calculateTotalCost(invoice.getSalesTax(),totalShipCost,invoice.getSurCharge()));

        //Have to get invoice id and invoice itemid from Feignclient after save operation
        //invoiceAftersave =  feignclient.save(invoiceview)
        // invoiceView.set

        return client.submitInvoice(invoice);
    }

    public List<Invoice> getInvoicesByCustomerId(int customerId){
        return client.getInvoicesByCustomerId(customerId);
    }

    public double calculateShipCost(String zipCode){


        if(zipCode.startsWith("0") || zipCode.startsWith("1") || zipCode.startsWith("2")){
            return SHIP_COST_ZIP_CODE_ZERO_ONE_TWO;
        }
        else if(zipCode.startsWith("3")){
            return  SHIP_COST_ZIP_CODE_THREE;
        }
        else if(zipCode.startsWith("4") || zipCode.startsWith("5") || zipCode.startsWith("6")){
            return  SHIP_COST_ZIP_CODE_FOUR_FIVE_SIX;
        }
        else if(zipCode.startsWith("7") || zipCode.startsWith("8") || zipCode.startsWith("9")) {
            return  SHIP_COST_ZIP_CODE_SEVEN_EIGHT_NINE;
        }
        return 0;
    }

    public double calculateSurcharge( double totalPounds){
        if(totalPounds > 10 && totalPounds <= 17)
        {
            return SURCHARGE_COST_OVER_TEN_POUNDS;
        }
        else if(totalPounds > 17 && totalPounds <= 25)
        {
            return SURCHARGE_COST_OVER_SEVENTEEN_POUNDS;
        }
        else if(totalPounds > 25 && totalPounds <= 35)
        {
            return SURCHARGE_COST_OVER_TWENTYFIVE_POUNDS;
        }
        else if(totalPounds > 35 )
        {
            return SURCHARGE_COST_OVER_THIRTYFIVE_POUNDS;
        }
        return 0;
    }

    public double calculateSalesTax(double shippingCost,double surcharge){
        return Math.round(SALES_TAX * (shippingCost + surcharge));
    }

    public double calculateTotalCost(double salesTax,double shippingCost,double surcharge){
        return Math.round(salesTax + shippingCost + surcharge);
    }


}
