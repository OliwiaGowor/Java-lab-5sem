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
 * View class of the application responsible for displaying information on the
 * screen.
 *
 * @author Oliwia Gowor
 * @version 1.0
 */
public class View {

    /**
     * Non-parameter constructor
     */
    public View (){}
            
    /**
     * Method prints main menu.
     */
    public void printMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("-------------------");
        System.out.println("[1] See orders");
        System.out.println("[2] Add order");
        System.out.println("[3] Delete order");
        System.out.println("[4] Search order");
        System.out.println("[0] Quit");
    }

    /**
     * Method prints search menu.
     */
    public void printSearchMenu() {
        System.out.println("SEARCH MENU");
        System.out.println("-------------------");
        System.out.println("[1] Search by number");
        System.out.println("[2] Search by date");
        System.out.println("[9] Back");
    }

    /**
     * Method prints menu for the viewer only.
     */
    public void printViewerMenu() {
        System.out.println("MAIN MENU");
        System.out.println("-------------------");
        System.out.println("[1] See orders");
        System.out.println("[2] Search order");
        System.out.println("[0] Quit");
    }

    /**
     * Method prints a command for user to enter order number parameter.
     */
    public void printAddOrder() {
        System.out.println("Add new order");
        System.out.println("---------------------------------");
        System.out.println("Order number: ");
    }

    /**
     * Method prints question if user wants to add another product.
     */
    public void ifContinueMsg() {
        System.out.println("Do you want to add another product?");
        System.out.println("[1] Yes");
        System.out.println("[0] No");
    }

    /**
     * Method prints list of orders on the screen.
     *
     * @param list parameter representing a list of orders to be displayed on
     * screen
     */
    public void printOrdersList(List<Order> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                printOrder(list.get(i));
            }
        } else {
            System.out.println("List is empty!");
        }
    }

    /**
     * Method prints order on the screen.
     *
     * @param order parameter representing a order to be displayed on screen
     */
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

    /**
     * Method prints Buyers data on the screen.
     *
     * @param buyer parameter representing a buyer to be displayed on screen
     */
    private void printBuyer(Buyer buyer) {
        System.out.println("Buyer: " + buyer.getName() + buyer.getSurname());
        System.out.println(buyer.getAddress());
    }

    /**
     * Method prints date on the screen.
     *
     * @param date parameter representing a date to be displayed on screen
     */
    private void printDate(Date date) {
        System.out.println("Products: ");
        System.out.println(date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }

    /**
     * Method prints list of products on the screen.
     *
     * @param productsList parameter representing a list of products to be
     * displayed on screen
     */
    private void printProductsList(List<Product> productsList) {
        System.out.println("name" + "|" + "quantinity" + "|" + "unit" + "|"
                + "price Netto" + "|" + "value Netto" + "|" + "VAT rate" + "|" + "value VAT" + "|" + "value Brutto");
        for (int i = 0; i < productsList.size(); i++) {
            if (!productsList.isEmpty()) {
                printProduct(productsList.get(i));
            }
        }
    }

    /**
     * Method prints product on the screen.
     *
     * @param product parameter representing a product to be displayed on screen
     */
    private void printProduct(Product product) {
        System.out.println(product.getName() + "|" + product.getQuantinity() + "|" + product.getUnit() + "|" + product.getPriceNetto() + "|"
                + product.getValueNetto() + "|" + product.getVatRate() + "|" + product.getValueVat() + "|" + product.getValueBrutto());
    }

    /**
     * Method prints error message on the screen.
     *
     * @param error represents contents of error note
     */
    public void printError(String error) {
        System.err.println(error);
    }

    /**
     * Method prints a command for user to enter day parameter.
     */
    public void askForDate() {
        System.out.println("Enter order date: ");
        System.out.println("Day: ");
    }

    /**
     * Method prints a command for user to enter month parameter.
     */
    public void askForMonth() {
        System.out.println("Month: ");
    }

    /**
     * Method prints a command for user to enter year parameter.
     */
    public void askForYear() {
        System.out.println("Year: ");
    }

    /**
     * Method prints a command for user to enter a number of order to delete.
     */
    public void printDeleteOrder() {
        System.out.println("Number of order you want to delete: ");
    }

    /**
     * Method prints a command for user to enter a number of order to find.
     */
    public void printSearchOrderNumber() {
        System.out.println("Number of order you want to find: ");
    }

    /**
     * Method prints a command for user to enter a number.
     */
    public void askForNumber() {
        System.out.println("Enter number: ");
    }

    /**
     * Method prints a command for user to enter a product name.
     */
    public void askForProductName() {
        System.out.println("Product name:");
    }

    /**
     * Method prints a command for user to enter a product Netto price.
     */
    public void askForPriceNetto() {
        System.out.println("Price netto:");
    }

    /**
     * Method prints a command for user to enter a product quantinity.
     */
    public void askForQuantinity() {
        System.out.println("Quantinity:");
    }

    /**
     * Method prints a command for user to enter a product unit.
     */
    public void askForProductUnit() {
        System.out.println("Unit:");
    }

    /**
     * Method prints a command for user to enter a product VAT rate.
     */
    public void askForProductVatRate() {
        System.out.println("VAT rate:");
    }

    /**
     * Method prints a command for user to enter a buyer name.
     */
    public void askForBuyerName() {
        System.out.println("Buyers name: ");
    }

    /**
     * Method prints a command for user to enter a buyer surname.
     */
    public void askForBuyerSurname() {
        System.out.println("Buyers surname: ");
    }

    /**
     * Method prints a command for user to enter a buyer address.
     */
    public void askForBuyerAddress() {
        System.out.println("Buyers address: ");
    }

    /**
     * Method prints a command for user to enter a orders payment method.
     */
    public void askForOrderPaymentMeth() {
        System.out.println("Payment method: ");
    }

    /**
     * Method prints a error message about program call parameter.
     */
    public void printErrorParameters() {
        System.out.println("Incorrect parameters!");
    }

    /**
     * Method prints a error message about running the program.
     */
    public void printErrorRunProgram() {
        System.out.println("Was unable to run the program. Try again.");
    }

    /**
     * Method prints a error message about incorrect number.
     */
    public void printErrorNumber() {
        System.out.println("Number incorrect!");
    }

    /**
     * Method prints program call parameters on screen.
     *
     * @param args program call parameters
     */
    public void printParameters(String[] args) {
        System.out.println("Program parameters: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }

    /**
     * Method prints a command for user to enter program call parameters.
     */
    public void askForParameters() {
        System.out.println("Enter program parameters (programName role): ");
    }

}
