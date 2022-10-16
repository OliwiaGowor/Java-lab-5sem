/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.view;

import java.util.List;
import pl.polsl.goworoliwia.model.Buyer;
import pl.polsl.goworoliwia.model.Date;
import pl.polsl.goworoliwia.model.Order;
import pl.polsl.goworoliwia.model.Product;

/**
 *
 * @author oliwia
 */
public class View {

    public void printMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("-------------------");
        System.out.println("[1] See orders");
        System.out.println("[2] Add order");
        System.out.println("[3] Delete order");
        System.out.println("[4] Search order");
        System.out.println("[0] Quit");
    }

    public void printSearchMenu() {
        System.out.println("SEARCH MENU");
        System.out.println("-------------------");
        System.out.println("[1] Search by number");
        System.out.println("[2] Search by date");
        System.out.println("[9] Back");
    }

    public void printAddOrder() {
        System.out.println("Add new order");
        System.out.println("---------------------------------");
        System.out.println("Order number: ");
    }

    public void ifContinueMsg() {
        System.out.println("Do you want to add another product?");
        System.out.println("[1] Yes");
        System.out.println("[0] No");
    }

    public void printOrdersList(List<Order> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.isEmpty()) {
                printOrder(list.get(i));
            }
        }
    }

    private void printOrder(Order order) {
        System.out.println("ORDER");
        System.out.println("Order number: " + order.getNumber());
        printBuyer(order.getBuyer());
        printDate(order.getOrderDate());
        printProductsList(order.getProducts());
        System.out.println("Sum Netto: " + order.getSumNetto());
        System.out.println("Sum VAT: " + order.getSumVat());
        System.out.println("Sum Brutto: " + order.getSumBrutto());
    }

    private void printBuyer(Buyer buyer) {
        System.out.println("Buyer: " + buyer.getName() + buyer.getSurname());
        System.out.println(buyer.getAddress());
    }

    private void printDate(Date date) {
        System.out.println("Products: ");
        System.out.println(date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }

    private void printProductsList(List<Product> productsList) {
        System.out.println("name" + "|" + "quantinity" + "|" + "unit" + "|" + "price Netto" + "|" + "value Netto" + "|" + "VAT rate" + "|" + "value VAT" + "|" + "value Brutto");
        for (int i = 0; i < productsList.size(); i++) {
            if (!productsList.isEmpty()) {
                printProduct(productsList.get(i));
            }
        }
    }

    private void printProduct(Product product) {
        System.out.println(product.getName() + "|" + product.getQuantinity() + "|" + product.getUnit() + "|" + product.getPriceNetto() + "|"
                + product.getValueNetto() + "|" + product.getVatRate() + "|" + product.getValueVat() + "|" + product.getValueBrutto());
    }

    /**
     * Method prints error note on the screen
     *
     * @param error represents contents of error note
     */
    public void printError(String error) {
        System.err.println(error);
    }

    /**
     * Method prints a command for user to enter parameter - day
     */
    public void askForDate() {
        System.out.println("Enter order date: ");
        System.out.println("Day: ");
    }

    /**
     * Method prints a command for user to enter parameter - month
     */
    public void askForMonth() {
        System.out.println("Month: ");
    }

    /**
     * Method prints a command for user to enter parameter - year
     */
    public void askForYear() {
        System.out.println("Year: ");
    }

}
