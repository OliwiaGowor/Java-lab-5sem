/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.gowor.oliwia.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pl.polsl.lab.model.Buyer;
import pl.polsl.lab.model.Date;
import pl.polsl.lab.model.Order;
import pl.polsl.lab.model.OrderNotFoundException;
import pl.polsl.lab.model.OrdersList;
import pl.polsl.lab.model.Product;
import pl.polsl.lab.model.Product.VatRate;
import pl.polsl.lab.model.SameOrderNumberException;

/**
 * ModelTest class of the application responsible for testing methods of class
 * Model.
 *
 * @author Oliwia Gowor
 * @version 4.0
 */
public class ModelTest {

    /**
     * Value represents object of the Model class
     */
    private OrdersList ordersList;

    /**
     * Method is performed before each test to set up new model with test data.
     */
    @BeforeEach
    public void setUp() {
        Product product = new Product("name", 10, VatRate.TWENTYTHREE, 10, "szt");
        List<Product> products = new ArrayList();
        products.add(product);
        Buyer buyer = new Buyer("name", "surname", "address");
        Order order1 = new Order("1", new Date(1, 1, 1), buyer, products, "card");
        Order order2 = new Order("2", new Date(2, 2, 2), buyer, products, "card");
        List<Order> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        ordersList = new OrdersList(orders);
    }

    /**
     * Test chcecks if method addOrder works properly when number order's number
     * is repeated.
     *
     * @param order parameter represents order to be added to the list
     */
    @ParameterizedTest
    @MethodSource("dataOrdersRepeatedNumbers")
    public void shouldNotAddOrderWithRepeatedNumber(Order order) {
        try {
        ordersList.addOrder(order);
        } catch(SameOrderNumberException ex) {
            
        }
    }

    /**
     * Test chcecks if method addOrder works properly when the data is correct.
     *
     * @param order parameter represents order to be added to the list
     */
    @ParameterizedTest
    @MethodSource("dataOrdersRightNumbers")
    public void shouldAddCorrectOrder(Order order) {
        Order newOrder = order;
        try {
        ordersList.addOrder(order);
        } catch(SameOrderNumberException ex) {
            
        }
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getNumber(), newOrder.getNumber(), "Number should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getBuyer().getName(), newOrder.getBuyer().getName(), "Buyers name should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getBuyer().getSurname(), newOrder.getBuyer().getSurname(), "Buyers surname should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getBuyer().getAddress(), newOrder.getBuyer().getAddress(), "Buyers address should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getOrderDate().getDay(), newOrder.getOrderDate().getDay(), "Day should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getOrderDate().getMonth(), newOrder.getOrderDate().getMonth(), "Month should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getOrderDate().getYear(), newOrder.getOrderDate().getYear(), "Year should be the same in both instances");
        for (int i = 0; i < ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().size(); i++) {
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getProductName(), newOrder.getProducts().get(i).getProductName(), "Product name should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getPriceNetto(), newOrder.getProducts().get(i).getPriceNetto(), "Product Netto price should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getValueNetto(), newOrder.getProducts().get(i).getValueNetto(), "Product Netto value should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getValueBrutto(), newOrder.getProducts().get(i).getValueBrutto(), "Product Brutto value should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getValueVat(), newOrder.getProducts().get(i).getValueVat(), "Product VAT value should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getVatRate(), newOrder.getProducts().get(i).getVatRate(), "Product VAT rate should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getQuantinity(), newOrder.getProducts().get(i).getQuantinity(), "Product quantinity value should be the same in both instances");
            assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getProducts().get(i).getUnit(), newOrder.getProducts().get(i).getUnit(), "Product unit should be the same in both instances");
        }
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getPaymentMethod(), newOrder.getPaymentMethod(), "Payment method should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getSumNetto(), newOrder.getSumNetto(), "Sum Netto should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getSumBrutto(), newOrder.getSumBrutto(), "Sum Brutto should be the same in both instances");
        assertEquals(ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1).getSumVat(), newOrder.getSumVat(), "Sum VAT should be the same in both instances");
    }

    /**
     * Test checks if method addOrder works properly when added data is null.
     */
    @Test
    public void shouldThrowExceptionWhenAddedOrderisNull() {
        try {
            ordersList.addOrder(null);
            fail("An exception should be thrown when the data is null");
        } catch (Exception ex) {
        }
    }

    /**
     * Test checks if method deleteOrder works properly for numbers, that are
     * not on the list or null.
     *
     * @param number parameter represents number of order to delete
     */
    @ParameterizedTest
    @CsvSource({"not-number", "doesnt-exist", "notOnTheList"})
    @NullSource()
    public void shouldThrowExceptionWhenNumberToDeleteIsNotOnListOrNull(String number) {
        try {
            ordersList.deleteOrder(number);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
        }
    }

    /**
     * Test checks if method deleteOrder works properly for correct numbers,
     * that are on the list.
     *
     * @param number parameter represents number of order to delete
     */
    @ParameterizedTest
    @CsvSource({"1", "2"})
    public void shouldDeleteWhenRightNumber(String number) {
        try {
            ordersList.deleteOrder(number);
        } catch (OrderNotFoundException ex) {
            fail("An exception shouldn't be thrown when the order is on the list");
        }
    }

    /**
     * Test checks if method searchOrderByNumber works properly when number of
     * order to find is not on the list or null.
     *
     * @param number parameter represents number of order to find
     */
    @ParameterizedTest
    @CsvSource({"not-number", "doesnt-exist", "notOnTheList"})
    @NullSource()
    public void shouldThrowExceptionWhenOrderNumberToFindIsNotOnListOrNull(String number) {
        try {
            ordersList.searchOrderByNumber(number);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
        }
    }

    /**
     * Test checks if method searchOrderByNumber works properly when number of
     * order to find is on the list.
     *
     * @param number parameter represents number of order to find
     */
    @ParameterizedTest
    @CsvSource({"1", "2"})
    public void shouldFindOrderWhenNumberIsOnList(String number) {
        try {
            ordersList.searchOrderByNumber(number);
        } catch (OrderNotFoundException ex) {
            fail("An exception should not be thrown when the order is on the list");
        }
    }

    /**
     * Test checks if method searchOrderByDate works properly when date of order
     * to find is not on the list or null.
     *
     * @param date parameter represents date of order to find
     */
    @ParameterizedTest
    @MethodSource("wrongDatesToFind")
    public void shouldThrowExceptionWhenOrderDateToFindIsNotOnListOrNull(Date date) {
        try {
            ordersList.searchOrderByDate(date);
            fail("An exception should be thrown when order date is not on the list");
        } catch (OrderNotFoundException ex) {
        }
    }

    /**
     * Test checks if method searchOrderByDate works properly when date of order
     * to find is on the list.
     *
     * @param date parameter represents date of order to find
     */
    @ParameterizedTest
    @MethodSource("rightDatesToFind")
    public void shouldFindOrderWhenDateIsOnList(Date date) {
        try {
            ordersList.searchOrderByDate(date);
        } catch (OrderNotFoundException ex) {
            fail("An exception should not be thrown when the order date is on the list");
        }
    }

    /**
     * Test checks if method addNewProduct works properly for right data.
     *
     * @param product parameter represents product to add to the list
     */
    @ParameterizedTest
    @MethodSource("productsToAdd")
    public void shouldAddNewProduct(Product product) {
        Product testProduct = product;
        Order order = ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1);
        order.addNewProduct(product);
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getProductName(), testProduct.getProductName(), "Product name should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getPriceNetto(), testProduct.getPriceNetto(), "Product Netto price should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getValueNetto(), testProduct.getValueNetto(), "Product Netto value should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getValueBrutto(), testProduct.getValueBrutto(), "Product Brutto value should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getValueVat(), testProduct.getValueVat(), "Product VAT value should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getVatRate(), testProduct.getVatRate(), "Product VAT rate should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getQuantinity(), testProduct.getQuantinity(), "Product quantinity value should be the same in both instances");
        assertEquals(order.getProducts().get(order.getProducts().size() - 1).getUnit(), testProduct.getUnit(), "Product unit should be the same in both instances");
    }

    /**
     * Test checks if method addNewProduct works properly when added data is
     * null.
     */
    @Test
    public void shouldNotAddNewProductWhenProductisNull() {
        Order order = ordersList.getOrdersList().get(ordersList.getOrdersList().size() - 1);
        assertFalse(order.addNewProduct(null), "Product shouldn't be added when null");
    }

// -------------------------------------------------------------
// Exception test
// -------------------------------------------------------------
    /**
     * Test chcecks if OrderNotFoundException works properly.
     *
     * @param date parameter represents date of order to find
     */
    @ParameterizedTest
    @MethodSource("wrongDatesToFind")
    public void shuldThrowOrderNotFoundException(Date date) {
        try {
            ordersList.searchOrderByDate(date);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
            assertTrue(ex.getMessage().contains("order"), "Unexpected message!");
        } catch (Exception e) {
            fail("An exception should be caught as a OrderNotFoundException");
        }
    }

    /**
     * Test chcecks if OrderNotFoundException works properly.
     *
     * @param date parameter represents date of order to find
     */
    @ParameterizedTest
    @MethodSource("rightDatesToFind")
    public void shuldNotThrowOrderNotFoundException(Date date) {
        try {
            ordersList.searchOrderByDate(date);
        } catch (OrderNotFoundException ex) {
            fail("An exception should not be thrown when the order is on the list");
        } catch (Exception e) {
            fail("An exception should be caught as a OrderNotFoundException");
        }
    }

// -------------------------------------------------------------
// Test data
// -------------------------------------------------------------
    /**
     * Method returns Order objects, used in tests.
     *
     * @return stream of Order objects
     */
    static Stream dataOrdersRepeatedNumbers() {
        List<Product> products = Arrays.asList(new Product("name", 10, VatRate.TWENTYTHREE, 10, "szt"));
        Order order1 = new Order("1", new Date(1, 1, 1), new Buyer("name", "surname", "address"), products, "card");
        Order order2 = new Order("2", new Date(2, 2, 2), new Buyer("name", "surname", "address"), products, "card");
        return Stream.of(order1, order2);
    }

    /**
     * Method returns Order objects, used in tests.
     *
     * @return stream of Order objects
     */
    static Stream dataOrdersRightNumbers() {
        List<Product> products = Arrays.asList(new Product("name", 10, VatRate.TWENTYTHREE, 10, "szt"));
        Order order1 = new Order("new-number", new Date(1, 1, 1), new Buyer("name", "surname", "address"), products, "card");
        Order order2 = new Order("not-repeated", new Date(2, 2, 2), new Buyer("name", "surname", "address"), products, "card");
        Order order3 = new Order();
        return Stream.of(order1, order2, order3);
    }

    /**
     * Method returns Date objects, used in tests.
     *
     * @return stream of Date objects
     */
    static Stream rightDatesToFind() {
        Date date1 = new Date(1, 1, 1);
        Date date2 = new Date(2, 2, 2);
        return Stream.of(date1, date2);
    }

    /**
     * Method returns Date objects, used in tests.
     *
     * @return stream of Date objects
     */
    static Stream wrongDatesToFind() {
        Date date1 = new Date(0, 0, 0);
        Date date2 = new Date(100, 100, 100);
        Date date3 = new Date();
        return Stream.of(date1, date2, date3);
    }

    /**
     * Method returns Product objects, used in tests.
     *
     * @return stream of Product objcets
     */
    static Stream productsToAdd() {
        Product product1 = new Product("1", 1.0, VatRate.ZERO, 1, "szt");
        Product product2 = new Product("2", 10.0, VatRate.FIVE, 1, "l");
        Product product3 = new Product();
        return Stream.of(product1, product2, product3);
    }
}
