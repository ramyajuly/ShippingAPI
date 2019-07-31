package com.trilogy.shippingservice;

import com.trilogy.shippingservice.model.Invoice;
import com.trilogy.shippingservice.model.InvoiceItem;
import com.trilogy.shippingservice.repository.InvoiceItemRepository;
import com.trilogy.shippingservice.repository.InvoiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingServiceApplicationTests {

	@Autowired
	InvoiceRepository invoiceRepo;

	@Autowired
	InvoiceItemRepository invoiceIemRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest() {

		Invoice invoice = new Invoice();
		invoice.setCustomerId(15);
		invoice.setPurchaseDate(LocalDate.of(2002, 1, 31));
		invoice.setSalesTax(23.45);
		invoice.setShipToZip("12345");
		invoice.setTotalCost(50.0);
		invoice.setSurCharge(5.87);

		InvoiceItem item = new InvoiceItem();
		item.setInvoice(invoice);
		item.setItemDescription("This is a test item.");
		item.setItemName("Test Item");
		item.setShipCost(30.0);
		item.setWeight(42);

		Set<InvoiceItem> items = new HashSet<>();

		items.add(item);

		invoice.setInvoiceItemSet(items);

		invoice = invoiceRepo.save(invoice);

		Invoice fromDB = invoiceRepo.findById(invoice.getInvoiceId()).get();

		assertEquals(invoice.getInvoiceId(), fromDB.getInvoiceId());
	}
}
