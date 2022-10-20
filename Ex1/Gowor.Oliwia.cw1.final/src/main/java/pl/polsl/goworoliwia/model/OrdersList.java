/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class of the application responsible for list of orders data.
 *
 * @author Oliwia Gowor
 * @version 1.0
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
     */
    public void addOrder(Order order) {
        ordersList.add(order);
    }

    /**
     * Method responsible for deleting order from list, based on given number.
     *
     * @param number parameter representing number of order to delete
     */
    public void deleteOrder(String number) {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getNumber().equals(number)) {
                ordersList.remove(i);
            }
        }
    }

    /**
     * Method searches orders on the list that have corresponding number to the one given.
     *
     * @param number parameter representing order number
     * @return list of found orders
     * @throws OrderNotFoundException when attempted to get order that is not
     * present in a list
     */
    public List<Order> searchOrderByNumber(String number) throws OrderNotFoundException {
        List<Order> found = new ArrayList();
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getNumber().equals(number)) {
                found.add(ordersList.get(i));
            }
        }
        if (!found.isEmpty()) {
            return found;
        } else {
            throw new OrderNotFoundException("No such order on list!");
        }
    }

    /**
     * Method searches orders on the list that have corresponding date to the one given.
     *
     * @param date parameter representing date of order
     * @return list of found orders
     * @throws OrderNotFoundException when attempted to get order that is not
     * present in a list
     */
    public List<Order> searchOrderByDate(Date date) throws OrderNotFoundException {
        List<Order> found = new ArrayList();
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getOrderDate() == date) {
                found.add(ordersList.get(i));
            }
        }
        if (!found.isEmpty()) {
            return found;
        } else {
            throw new OrderNotFoundException("No such order on list!");
        }
    }

}
