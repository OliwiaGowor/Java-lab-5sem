/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

Zakres finalnej wersji aplikacji po ćwiczeniu nr 2

pełny zakres finalnej wersji aplikacji z ćwiczenia nr 1,
dodanie kolekcji bezpiecznej ze względu na typy obiektów do klasy modelu, X
wykorzystanie pętli for-each X

wykorzystanie jednego z następujących elementów:
typ wyliczeniowy, X
własny typ generyczny,
zmienna liczba parametrów metody,
własna adnotacja (inna niż w przykładach demonstracyjnych),
wyrażenie lambda (ze zdefiniowanym interfejsem).

wykorzystanie strumieniowego przetwarzania danych w kolekcjach, X
zdefiniowanie testów jednostkowych dla wszystkich publicznych metod znajdujących się w modelu (za wyjątkiem konstruktorów, akcesorów i mutatorów)
testy powinny obejmować sytuacje poprawne, niepoprawne i graniczne dla każdej testowanej jednostki,
nie testujemy wartościami granicznymi z zakresu wartości typów prostych,
parametryzacja wszystkich testów,
testy jednostkowe powinny być skomentowane.

 */
package pl.polsl.goworoliwia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pl.polsl.goworoliwia.model.Buyer;
import pl.polsl.goworoliwia.model.Date;
import pl.polsl.goworoliwia.model.Order;
import pl.polsl.goworoliwia.model.OrderNotFoundException;
import pl.polsl.goworoliwia.model.OrdersList;
import pl.polsl.goworoliwia.model.Product;
import pl.polsl.goworoliwia.model.VatRates.VatRate;

/**
 *
 * @author Oliwia
 */
public class ModelTest {

    private OrdersList ordersList;

    @BeforeEach
    public void setUp() {
        Date date = new Date(1, 2, 3);
        Product product = new Product("name", 10, VatRate.TWENTYTHREE, 10, "szt");
        List<Product> products = new ArrayList();
        products.add(product);
        Buyer buyer = new Buyer("name", "surname", "address");
        Order order1 = new Order("1", date, buyer, products, "card");
        Order order2 = new Order("2", date, buyer, products, "card");
        List<Order> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        ordersList = new OrdersList(orders);
    }

    @Test
    public void shouldThrowExceptionWhenAddedOrderisNull() {
        try {
            ordersList.addOrder(null);
            fail("An exception should be thrown when the data is null");
        } catch (Exception ex) { 
        }
    }
    
    @ParameterizedTest
    @MethodSource("dataOrdersRepeatedNumbers")
    public void shouldThrowExceptionWhenAddedOrderHasRepeatedNumber(Order order) {
        try {
            ordersList.addOrder(order);
            fail("An exception should be thrown when the order has repeated number");
        } catch (Exception ex) { 
        }
    }
    
    @ParameterizedTest
    @MethodSource("dataOrdersRepeatedNumbers")
    public void shouldAddCorrectOrder(Order order) {
        try {
            ordersList.addOrder(order);
            fail("An exception should be thrown when the order has repeated number");
        } catch (Exception ex) { 
        }
    }

    @Test
    public void testDeleteOrder() {
        String number = "a";
        try {
            ordersList.deleteOrder(number);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
        }
    }

    @Test
    public void testSearchOrderByNumber() {
        String number = "b";
        try {
            ordersList.searchOrderByNumber(number);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
        }
    }

    @Test
    public void testSearchOrderByDate() {
        Date date = new Date(0, 0, 0);
        try {
            ordersList.searchOrderByDate(date);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
        }
    }

    //Exception test
    @Test
    public void testOfException() {
        Date date = new Date(0, 0, 0);
        try {
            ordersList.searchOrderByDate(date);
            fail("An exception should be thrown when the order is not on the list");
        } catch (OrderNotFoundException ex) {
            assertTrue(ex.getMessage().contains("order"), "Unexpected message!");
        } catch (Exception e) {
            fail("An exception should be caught as a OrderNotFoundException");
        }
    }

    @Test
    public void testAddNewProduct() {
        System.out.print("Test not implemented yet.");
    }

    /*@ParameterizedTest
    @ValueSource()
    public void testCalculateSumVat() {
        System.out.print("Test not implemented yet.");
    }*/
    
     static Stream dataOrdersRepeatedNumbers() {
        Date date = new Date(1, 2, 3);
        Product product = new Product("name", 10, VatRate.TWENTYTHREE, 10, "szt");
        List<Product> products = new ArrayList();
        products.add(product);
        Buyer buyer = new Buyer("name", "surname", "address");
        Order order1 = new Order("1", date, buyer, products, "card");
        Order order2 = new Order("2", date, buyer, products, "card");
        return Stream.of(order1, order2);
    }
}
