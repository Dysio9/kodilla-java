package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {
    private Product product1;
    private Product product2;
    private Product product3;

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = createProductsAndInvoice();

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);
        cleanProductsAfterTest();
    }

    @Test
    void testInvoiceDaoFindAndCheckInvoiceNo() {
        //Given
        Invoice invoice = createProductsAndInvoice();
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //When
        Optional<Invoice> receivedInvoice = invoiceDao.findById(id);

        //Then
        assertEquals(invoice.getNumber(), receivedInvoice.get().getNumber());

        //CleanUp
        invoiceDao.delete(invoice);
        cleanProductsAfterTest();
    }

    @Test
    void testInvoiceDaoFindAndCheckNumberOfItems() {
        //Given
        Invoice invoice = createProductsAndInvoice();
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //When
        Optional<Invoice> receivedInvoice = invoiceDao.findById(id);

        //Then
        assertEquals(3, receivedInvoice.get().getItems().size());

        //CleanUp
        invoiceDao.delete(invoice);
        cleanProductsAfterTest();
    }

    private Invoice createProductsAndInvoice() {
        product1 = new Product("Butter");
        product2 = new Product("Computer");
        product3 = new Product("Popcorn");
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        Item item1 = new Item(product1, BigDecimal.valueOf(4.59),8);
        Item item2 = new Item(product2, new BigDecimal(4250), 2);
        Item item3 = new Item(product3, BigDecimal.valueOf(15.5), 30);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Invoice invoice = new Invoice("01/JAN/2020", items);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        return invoice;
    }

    private void cleanProductsAfterTest() {
        productDao.delete(product1);
        productDao.delete(product2);
        productDao.delete(product3);
    }
}
