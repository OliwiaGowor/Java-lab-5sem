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
import pl.polsl.goworoliwia.model.Order;
import pl.polsl.goworoliwia.model.OrderNotFoundException;
import pl.polsl.goworoliwia.model.OrdersList;
import pl.polsl.goworoliwia.model.Product;
import pl.polsl.goworoliwia.model.Product.VatRate;
import pl.polsl.goworoliwia.view.View;

/**
 * Controller class of the application responsible for interacting with user and
 * modifying model.
 *
 * @author Oliwia Gowor
 * @version 2.0
 */
public class Controller {

    /**
     * Value represents object of the View class.
     */
    private View view;
    /**
     * Value represents object of the OrdersList class.
     */
    private OrdersList model;

    /**
     * Controller class constructor.
     *
     * @param view represents the View class
     * @param model represents the OrdersList class
     */
    public Controller(View view, OrdersList model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Method responsilbe for running the program – it checks the parameters and
     * runs appropriate menu based on them.
     *
     * @param args program call parameters
     */
    public void runProgram(String[] args) {
        if (!this.getParameters(args)) {
            String[] parameters = getParametersFormUser();
            while (!validateParameters(parameters)) {
                parameters = getParametersFormUser();
                view.printErrorParameters();
            }
            if (parameters[1].equals("admin")) {
                this.mainMenu();
            } else if (parameters[1].equals("viewer")) {
                this.viewerMenu();
            } else {
                view.printErrorRunProgram();
            }
        } else {
            if (args[1] == "admin") {
                this.mainMenu();
            } else if (args[1] == "viewer") {
                this.viewerMenu();
            } else {
                view.printErrorRunProgram();
            }
        }
    }

    /**
     * Method for checking and writing out the program parameters.
     *
     * @param args program call parameters
     * @return true if parameters are correct, false if they are incorrect.
     */
    private Boolean getParameters(String[] args) {
        if (validateParameters(args)) {
            view.printParameters(args);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for getting the program parameters from user.
     *
     * @return parameters given by user
     */
    private String[] getParametersFormUser() {
        Scanner scanner = new Scanner(System.in);
        view.askForParameters();
        String parametersStr = scanner.nextLine();
        String[] parameters = parametersStr.split(" ");
        return parameters;
    }

    /**
     * Method responisible for checking if program call parameters are correct.
     *
     * @param args program call parameters
     * @return true if parameters are correct, false if they are incorrect
     */
    private Boolean validateParameters(String[] args) {
        if (args.length == 2) {
            if ("OrdersManagement".equals(args[0])) {
                if ("admin".equals(args[1]) || "viewer".equals(args[1])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Method for getting integer parameter from user.
     *
     * @return integer parameter given by user
     */
    public int getIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        view.askForNumber();
        try {
            choice = scanner.nextInt();
        } catch (NumberFormatException ex) {
            view.printError(ex.getMessage());
            return 9;
        }
        return choice;
    }

    /**
     * Method lets user choose which action form the main menu the application
     * should do by showing them menu and asking for the number of option.
     */
    private void mainMenu() {
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
                    deleteOrder();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    view.printErrorNumber();
                    break;
            }
        }
    }

    /**
     * Method lets user choose which action form the searchv menu the
     * application should do by showing them menu and asking for the number of
     * option.
     */
    private void searchMenu() {
        int choice = 1;

        while (choice != 0) {
            view.printSearchMenu();
            choice = getIntFromUser();
            switch (choice) {
                case 1:
                    searchOrdersByNumber();
                    break;
                case 2:
                    searchOrdersByDate();
                    break;
                case 9:
                    choice = 0;
                    break;
                default:
                    view.printErrorNumber();
                    break;
            }
        }
    }

    /**
     * Method lets user choose which action form the menu for viewer only the
     * application should do by showing them menu and asking for the number of
     * option.
     */
    private void viewerMenu() {
        int choice = 1;

        while (choice != 0) {
            view.printViewerMenu();
            choice = getIntFromUser();
            switch (choice) {
                case 1:
                    view.printOrdersList(model.getOrdersList());
                    break;
                case 2:
                    searchMenu();
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    view.printErrorNumber();
                    break;
            }
        }
    }

    /**
     * Method for getting order parameters from user and adding new order to the
     * list.
     */
    private void createOrder() {
        Scanner scanner = new Scanner(System.in);
        Boolean ifCont = true;

        view.printAddOrder();
        String number = scanner.next();
        Buyer buyer = createBuyer();
        Date date = createDate();
        List<Product> products = new ArrayList(addProducts());
        view.askForOrderPaymentMeth();
        String paymentMethod = scanner.nextLine();
        Order newOrder = new Order(number, date, buyer, products, paymentMethod);
        model.addOrder(newOrder);
    }

    /**
     * Method for creating new products list for the order.
     *
     * @return list of products
     */
    private List<Product> addProducts() {
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

    /**
     * Metod for getting product parameters from user and creating new product.
     *
     * @return created product
     */
    private Product createNewProduct() {
        Scanner scanner = new Scanner(System.in);
        view.askForProductName();
        String name = scanner.next();
        view.askForPriceNetto();
        double priceNetto = scanner.nextDouble();
        VatRate vatRate = selectVatRate();
        view.askForQuantinity();
        int quantinity = scanner.nextInt();
        view.askForProductUnit();
        String unit = scanner.next();
        
        
        Product newProduct = new Product(name, priceNetto, vatRate, quantinity, unit);
        return newProduct;
    }
    
    private VatRate selectVatRate() {
        int choice;
 
         while (true) {
             view.askForProductVatRate();
            choice = getIntFromUser();
            switch (choice) {
                case 1 -> {
                    return VatRate.ZERO;
                }
                case 2 -> {
                    return VatRate.FIVE;
                }
                case 3 -> {
                    return VatRate.EIGHT;
                }
                case 4 -> {
                    return VatRate.TWENTYTHREE;
                }
                default -> view.printErrorNumber();
            }
        }
    }

    /**
     * Metod for getting buyer parameters from user and creating new buyer.
     *
     * @return created buyer
     */
    private Buyer createBuyer() {
        Scanner scanner = new Scanner(System.in);
        view.askForBuyerName();
        String buyerName = scanner.next();
        view.askForBuyerSurname();
        String buyerSurname = scanner.next();
        view.askForBuyerAddress();
        String buyerAddress = scanner.nextLine();
        Buyer newBuyer = new Buyer(buyerName, buyerSurname, buyerAddress);
        return newBuyer;
    }

    /**
     * Metod for getting date parameters from user and creating new date.
     *
     * @return created date
     */
    private Date createDate() {
        Scanner scanner = new Scanner(System.in);
        view.askForDate();
        int day = scanner.nextInt();
        view.askForMonth();
        int month = scanner.nextInt();
        view.askForYear();
        int year = scanner.nextInt();
        Date newDate = new Date(day, month, year);
        return newDate;
    }

    /**
     * Method responsible for deleting order based on order number choosen by
     * user.
     */
    private void deleteOrder() {
        Scanner scanner = new Scanner(System.in);
        view.printDeleteOrder();
        String number = scanner.nextLine();
        try {
        model.deleteOrder(number);
        } catch (OrderNotFoundException ex) {
            view.printError(ex.getMessage());
        }
    }

    /**
     * Method lets user search order by number.
     */
    private void searchOrdersByNumber() {
        Scanner scanner = new Scanner(System.in);
        List<Order> foundOrders = new ArrayList();
        view.printSearchOrderNumber();
        String number = scanner.nextLine();
        try {
            foundOrders = model.searchOrderByNumber(number);
        } catch (OrderNotFoundException ex) {
            view.printError(ex.getMessage());
        }
        for (int i = 0; i < foundOrders.size(); i++) {
            view.printOrdersList(foundOrders);
        }
    }

    /**
     * Method lets user search order by date.
     */
    private void searchOrdersByDate() {
        Scanner scanner = new Scanner(System.in);
        List<Order> foundOrders = new ArrayList();
        Date date = new Date();

        view.askForDate();
        date.setDay(scanner.nextInt());
        view.askForMonth();
        date.setMonth(scanner.nextInt());
        view.askForYear();
        date.setYear(scanner.nextInt());
        try {
            foundOrders = model.searchOrderByDate(date);
        } catch (OrderNotFoundException ex) {
            view.printError(ex.getMessage());
        }
        for (int i = 0; i < foundOrders.size(); i++) {
            view.printOrdersList(foundOrders);
        }
    }
}
