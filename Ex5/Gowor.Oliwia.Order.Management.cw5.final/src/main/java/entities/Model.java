/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.Arrays;

/**
 * Model class of the application responsible for managing application data.
 *
 * @author Oliwia Gowor
 * @version 5.0
 */
public class Model {

    /**
     * Value represents list of orders.
     */
    private List<Order> ordersList = new ArrayList();

    /**
     * Singular Entity Manager for project
     */
    private EntityManager entityManager;

    /**
     * Entity Transaction parameter
     */
    private EntityTransaction transaction;

    /**
     * Method returns entityManager parameter.
     *
     * @return entityManager parameter
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Method returns transaction parameter.
     *
     * @return transaction parameter
     */
    public EntityTransaction getTransaction() {
        return transaction;
    }

    /**
     * Non-parameter constructor
     */
    public Model() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl.lab_JPA_jar_1.0-SNAPSHOTPU");
        entityManager = emf.createEntityManager();
        transaction = entityManager.getTransaction();
        initialize();
        try {
            transaction.begin();
            ordersList = getFullListOfOrders();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Method initializes list with some data.
     */
    public void initialize() {

        List<Product> products = Arrays.asList(new Product("name", 10, Product.VatRate.TWENTYTHREE, 10, "szt"));
        Order order1 = new Order("1", new Date(1, 1, 1), "name surname address", "card");

        try {

            transaction.begin();
            addOrderToDB(order1);
            transaction.commit();

            for (Product product : products) {
                transaction.begin();
                addProductToDB(product, order1);
                transaction.commit();
            }

            transaction.begin();
            order1.addAndCalcProducts(products);
            getEntityManager().persist(order1);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    /**
     * Method returns ordersList class parameter.
     *
     * @return parameter representing list of orders
     */
    public List<Order> getOrdersList() {
        return ordersList;
    }

    /**
     * Method sets ordersList class parameter.
     *
     * @param ordersList parameter representing list of orders
     */
    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    /**
     * Method responsible for adding new order to the list.
     *
     * @param order parameter representing order to add to the list
     * @throws SameOrderNumberException when attempted to add order with the sme
     * order number that is already on the list
     */
    public void addOrder(Order order) throws SameOrderNumberException {
        if (!checkIfNumberExists(order.getNumber())) {
            ordersList.add(order);
            return;
        } else {
            throw new SameOrderNumberException("Order with this number is alerady on list!");
        }
    }

    /**
     * Method responsible for deleting order from list, based on given number.
     *
     * @param number parameter representing number of order to delete
     * @throws OrderNotFoundException when attempted to delete order that is not
     * present in a list
     */
    public void deleteOrder(String number) throws OrderNotFoundException {
        for (Order order : ordersList) {
            if (order.getNumber().equals(number)) {
                ordersList.remove(order);
                return;
            }
        }
        throw new OrderNotFoundException("No such order on list!");
    }

    public Model (List<Order> orders) {
        this.ordersList = orders;
    }
    /**
     * Method searches orders on the list that have corresponding number to the
     * one given.
     *
     * @param number parameter representing order number
     * @return list of found orders
     * @throws OrderNotFoundException when attempted to get order that is not
     * present in a list
     */
    public List<Order> searchOrderByNumber(String number) throws OrderNotFoundException {
        List<Order> ordersStream = ordersList.stream()
                .filter(flitered -> flitered.getNumber().equals(number))
                .collect(Collectors.toList());
        if (!ordersStream.isEmpty()) {
            return ordersStream;
        } else {
            throw new OrderNotFoundException("No such order on list!");
        }
    }

    /**
     * Method searches orders on the list that have corresponding date to the
     * one given.
     *
     * @param date parameter representing date of order
     * @return list of found orders
     * @throws OrderNotFoundException when attempted to get order that is not
     * present in a list
     */
    public List<Order> searchOrderByDate(Date date) throws OrderNotFoundException {
        List<Order> ordersStream = ordersList.stream()
                .filter(flitered -> flitered.getOrderDate().getDay() == date.getDay())
                .filter(flitered -> flitered.getOrderDate().getMonth() == date.getMonth())
                .filter(flitered -> flitered.getOrderDate().getYear() == date.getYear())
                .collect(Collectors.toList());
        if (!ordersStream.isEmpty()) {
            return ordersStream;
        } else {
            throw new OrderNotFoundException("No such order on list!");
        }
    }

    /**
     * Method checks if order with given number already exists.
     *
     * @param toCheck parameter represents order number to be checked
     * @return true if order with given number already exists, false if not
     */
    private Boolean checkIfNumberExists(String toCheck) {
        Stream<Order> ordersStream = ordersList.stream();
        return (ordersStream.anyMatch(checked -> checked.getNumber().equals(toCheck)));
    }

    /**
     * Method returns full list of orders from database.
     *
     * @return found list of orders
     */
    public List<Order> getFullListOfOrders() {
        List<Order> orders = new ArrayList();
        try {
            Query query = entityManager.createQuery("SELECT o FROM Order o");
            orders = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * Method returns full list of product for specific order from database.
     *
     * @return found list of products
     */
    public List<Product> getFullListOfProductsForOrder(String orderNumber) {
        List<Product> products = new ArrayList();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.order_number LIKE :orderNumber", Product.class).setParameter("orderNumber", orderNumber);
            products = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * Method adds given order to database.
     *
     * @param order represents order to add to database
     * @throws TransactionException when transaction failed
     * @throws SameOrderNumberException when order number already exists in
     * database
     */
    public void addOrderToDB(Order order) throws TransactionException, SameOrderNumberException {
        try {
            if (!checkIfNumberExists(order.getNumber())) {
                entityManager.persist(order);
                return;
            } else {
                throw new SameOrderNumberException("Order with this number is alerady on list!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new TransactionException("Something went wrong!");
        }
    }

    /**
     * Method deletes an event from list of events of specific day.
     *
     * @param number number of the order to delete
     * @throws OrderNotFoundException when attempted to get order that is not
     * present in a database
     * @throws TransactionException when transaction failed
     */
    public void deleteOrderFromDB(String number) throws OrderNotFoundException, TransactionException {
        try {
            //Order orderToDelete = entityManager.find(Order.class, number);
            List<Order> list = new ArrayList();
            list = getFullListOfOrders();
            for (Order order : list) {
                if (order.getNumber().equals(number)) {
                    entityManager.remove(entityManager.merge(order));
                    return;
                }
            }
        } catch (Exception e) {
            throw new TransactionException("Something went wrong!");
        }
        throw new OrderNotFoundException("Order not found");
    }

    /**
     * Method adds given product to database.
     *
     * @param product represents product to add to database
     * @param order represents order that method should add product to
     * @throws TransactionException when transaction failed
     */
    public void addProductToDB(Product product, Order order) throws TransactionException {
        try {
            product.setOrder(order);
            entityManager.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TransactionException("Something went wrong!");
        }
    }

}
