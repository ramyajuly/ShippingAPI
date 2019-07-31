package com.trilogy.shippingservice.controller;

import com.trilogy.shippingservice.model.Invoice;
import com.trilogy.shippingservice.model.InvoiceItem;
import com.trilogy.shippingservice.repository.InvoiceRepository;
import com.trilogy.shippingservice.viewModel.InvoiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    InvoiceRepository invoiceRepository;

    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceView createInvoice(@RequestBody Invoice invoice){
        for(InvoiceItem invoiceItem : invoice.getInvoiceItemSet()){
            invoiceItem.setInvoice(invoice);
        }
        return new InvoiceView(invoiceRepository.save(invoice));
    }

}
