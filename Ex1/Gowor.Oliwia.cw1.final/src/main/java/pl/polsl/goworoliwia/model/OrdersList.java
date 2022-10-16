/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SuperStudent
 */
public class OrdersList {

    private List<Order> ordersList;

    public OrdersList() {
        this.ordersList = new ArrayList();
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrder(Order order) {
        ordersList.add(order);
    }

    public boolean deleteOrder(String number) {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getNumber() == number) {
                ordersList.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Order> searchOrderByNumber(String number) {
        List<Order> found = new ArrayList();
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getNumber() == number) {
                found.add(ordersList.get(i));
            }
        }
        return found;
    }

    public List<Order> searchOrderByDate(Date date) {
        List<Order> found = new ArrayList();
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getOrderDate() == date) {
                found.add(ordersList.get(i));
            }
        }
        return found;
    }

}
