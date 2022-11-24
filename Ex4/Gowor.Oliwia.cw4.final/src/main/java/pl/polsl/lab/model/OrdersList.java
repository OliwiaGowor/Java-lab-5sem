/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Model class of the application responsible for list of orders data.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class OrdersList {

    /**
     * List of orders.
     */
    private List<Order> ordersList;

    /**
     * Non-parameter OrdersList class constructor.
     */
    public OrdersList() {
        this.ordersList = new ArrayList();
        initialize();
    }

    /**
     * OrdersList class constructor.
     *
     * @param ordersList parameter represents list of orders
     */
    public OrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public void initialize() {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        this.ordersList.add(order1);
        this.ordersList.add(order2);
        this.ordersList.add(order3);

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
     * @return true if new order is added, false if it's not
     */
    public Boolean addOrder(Order order) {
        if (!checkIfNumberExists(order.getNumber())) {
            ordersList.add(order);
            return true;
        } else {
            return false;
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
        if (ordersStream.size() > 0) {
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
}
