//package com.trilogy.shippingservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.trilogy.shippingservice.model.Invoice;
//import com.trilogy.shippingservice.model.InvoiceItem;
//import com.trilogy.shippingservice.repository.InvoiceItemRepository;
//import com.trilogy.shippingservice.repository.InvoiceRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(Controller.class)
//public class ControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    InvoiceRepository invoiceRepository;
//
//    @MockBean
//    InvoiceItemRepository invoiceItemRepository;
//
//    private static final String jsonAsString(final Object object) throws Exception {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.writeValueAsString(object);
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//
//    @Test
//    public void postInvoicesReturnCreatedStatus() throws Exception{
//        Invoice invoice = new Invoice();
//        invoice.setCustomerId(10);
//        invoice.setShipToZip("45459");
//        invoice.setPurchaseDate(LocalDate.of(2019, 4, 21));
//        invoice.setTotalCost(33.33);
//        invoice.setSalesTax(6.75);
//        invoice.setSurCharge(123.0);
//
//        Set<InvoiceItem> invoiceItemSet = new HashSet<>();
//
//        InvoiceItem invoiceItem = new InvoiceItem();
//        invoiceItem.setItemName("mugs");
//        invoiceItem.setItemDescription("for coffee");
//        invoiceItem.setWeight(2);
//        invoiceItem.setShipCost(12.34);
//        invoiceItemSet.add(invoiceItem);
//
//        invoice.setInvoiceItemSet(invoiceItemSet);
//
//        // from service
//
//        Invoice invoiceFromService = new Invoice();
//        invoiceFromService.setInvoiceId(30);
//        invoiceFromService.setCustomerId(10);
//        invoiceFromService.setShipToZip("45459");
//        invoiceFromService.setPurchaseDate(LocalDate.of(2019, 4, 21));
//        invoiceFromService.setTotalCost(33.33);
//        invoiceFromService.setSalesTax(6.75);
//        invoiceFromService.setSurCharge(123.0);
//
//        Set<InvoiceItem> invoiceItemSetFromService = new HashSet<>();
//
//        InvoiceItem invoiceItemFromService = new InvoiceItem();
//        invoiceItemFromService.setInvoiceId(30);
//        invoiceItemFromService.setInvoiceItemId(50);
//        invoiceItemFromService.setItemName("mugs");
//        invoiceItemFromService.setItemDescription("for coffee");
//        invoiceItemFromService.setWeight(2);
//        invoiceItemFromService.setShipCost(12.34);
//        invoiceItemSetFromService.add(invoiceItemFromService);
//
//        invoice.setInvoiceItemSet(invoiceItemSetFromService);
//
//
//
//        when(invoiceRepository.save(invoice)).thenReturn(invoiceFromService);
//
//
//        this.mockMvc.perform(post("/invoices")
//                .content(jsonAsString(invoice))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isCreated())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(jsonAsString(invoiceItemSetFromService)));
////                .andExpect(jsonPath("$.customerId", is(10)));
//
//
//    }
//
//}
