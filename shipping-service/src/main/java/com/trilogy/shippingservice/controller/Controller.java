package com.trilogy.shippingservice.controller;

import com.trilogy.shippingservice.model.Invoice;
import com.trilogy.shippingservice.repository.InvoiceItemRepository;
import com.trilogy.shippingservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    InvoiceRepository repo;

    @Autowired
    InvoiceItemRepository itemRepo;

    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    public Invoice createInvoice(@RequestBody Invoice invoice) {

        // We have to manage the bidirectional relationship between the Invoice and the Invoice Items - this likely
        // wasn't managed by the client in the passed in JSON.
        invoice.getInvoiceItemSet().stream()
                .forEach(item -> item.setInvoice(invoice));
        return repo.save(invoice);
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable int id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.PUT)
    public void updateInvoice(@RequestBody Invoice invoice, @PathVariable int id) {

        // We have to manage the bidirectional relationship between the Invoice and the Invoice Items - this likely
        // wasn't managed by the client in the passed in JSON.
        invoice.getInvoiceItemSet().stream()
                .forEach(item -> item.setInvoice(invoice));
        repo.save(invoice);
    }

    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
    public void deleteInvoice(@PathVariable int id) {
        repo.deleteById(id);
    }

    @RequestMapping(value = "/invoices/customer/{id}", method = RequestMethod.GET)
    public List<Invoice> getInvoicesByCustomerId(@PathVariable int id) {
        return repo.findByCustomerId(id);
    }

}
