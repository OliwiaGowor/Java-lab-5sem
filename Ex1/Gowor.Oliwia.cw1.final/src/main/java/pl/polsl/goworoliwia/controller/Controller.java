/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pl.polsl.goworoliwia.model.Buyer;
import pl.polsl.goworoliwia.model.Date;
import pl.polsl.goworoliwia.model.IncorrectDataFormatException;
import pl.polsl.goworoliwia.model.Order;
import pl.polsl.goworoliwia.model.OrdersList;
import pl.polsl.goworoliwia.model.Product;
import pl.polsl.goworoliwia.view.View;

/**
 * Controller class of the application responsible for interacting with user and
 * modifying model
 *
 * @author Oliwia Gowor
 */
public class Controller {

    private View view;
    private OrdersList model;

    /**
     *
     * @param view
     * @param model
     */
    public Controller(View view, OrdersList model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Method for writing out the parameters.
     *
     * @param args program call parameters
     */
    public static void readParameters(String[] args) {
        int numberOfParameters = args.length;
        if (args.length > 0) {
            System.out.println("Program parameters: ");

            for (int i = 0; i < numberOfParameters; i++) {
                System.out.println("parameter " + (i + 1) + ":" + args[i]);
            }
        } else {
            getParametersFormUser();
        }
    }

    /**
     * Method for getting the parameters from user.
     */
    public static String getParametersFormUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter program parameters: ");
        String parameter = scanner.next();
        return parameter;
    }

    /**
     *
     * @return
     */
    public static int getIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int choice = scanner.nextInt();
        return choice;
    }

    /**
     *
     */
    public void mainMenu() {
        int choice = 1;

        while (choice != 0) {
            view.printMainMenu();
            choice = getIntFromUser();
            switch (choice) {
                case 1:
                    view.printOrdersList(model.getOrdersList());
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:

                    break;
                case 4:
                    searchMenu();
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    System.out.println("Number incorrect!");
                    break;
            }
        }
    }

    private void searchMenu() {
        int choice = 1;

        while (choice != 0) {
            view.printSearchMenu();
            choice = getIntFromUser();
            switch (choice) {
                case 1:

                    break;
                case 2:
                    break;
                case 9:
                    choice = 0;
                    break;
                default:
                    System.out.println("Number incorrect!");
                    break;
            }
        }
    }

    private void createOrder() {
        Scanner scanner = new Scanner(System.in);
        Boolean ifCont = true;
        Order newOrder = new Order();

        view.printAddOrder();
        newOrder.setNumber(scanner.next());
        newOrder.setBuyer(createBuyer());
        newOrder.setOrderDate(createDate());
        newOrder.setProducts(addProducts(newOrder));
        System.out.println("Payment method: ");
        newOrder.setPaymentMethod(scanner.next());
        model.addOrder(newOrder);
    }

    public List<Product> addProducts(Order order) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList();
        int choice = 1;

        while (choice != 0) {
            Product newProduct = createNewProduct();
            products.add(newProduct);
            view.ifContinueMsg();
            choice = getIntFromUser();
        }
        return products;
    }

    private Product createNewProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product name:");
        String name = scanner.next();
        System.out.println("Price netto:");
        double priceNetto = scanner.nextDouble();
        System.out.println("Quantinity:");
        int quantinity = scanner.nextInt();
        System.out.println("Unit:");
        String unit = scanner.next();
        System.out.println("VAT rate:");
        int vatRate = scanner.nextInt();
        Product newProduct = new Product(name, priceNetto, vatRate, quantinity, unit);
        return newProduct;
    }

    private Buyer createBuyer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buyers name: ");
        String buyerName = scanner.next();
        System.out.println("Buyers surname: ");
        String buyerSurname = scanner.next();
        System.out.println("Buyers address: ");
        String buyerAddress = scanner.nextLine();
        Buyer newBuyer = new Buyer(buyerName, buyerSurname, buyerAddress);
        return newBuyer;
    }

    private Date createDate() {
        Scanner scanner = new Scanner(System.in);
        Date newDate = new Date();

        view.askForDate();
        newDate.setDay(scanner.nextInt());
        view.askForMonth();
        newDate.setMonth(scanner.nextInt());
        view.askForYear();
        newDate.setYear(scanner.nextInt());
        return newDate;
    }

}
