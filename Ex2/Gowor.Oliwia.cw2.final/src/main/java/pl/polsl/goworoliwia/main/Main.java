/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pl.polsl.goworoliwia.main;

import pl.polsl.goworoliwia.controller.Controller;
import pl.polsl.goworoliwia.model.OrdersList;
import pl.polsl.goworoliwia.view.View;

/**
 * Main class of the application realizing the operations on the orders
 * database. 
 * Command line parameters order: program name (OrdersManagement),
 * role (admin - can see and modify data; or viewer - can only see data). 
 * For example: OrdersManagement admin
 *
 * @author Oliwia Gowor
 * @version 2.0
 */
public class Main {

    /**
     * Main method of the application used to start project. 
     * Command line parameters order: program name (OrdersManagement), role 
     * (admin - can see and modify data; or viewer - can only see data). 
     * For example: OrdersManagement admin
     *
     * @param args arguments entered into command line when the program is
     * started
     */
    public static void main(String[] args) {
        View view = new View();
        OrdersList model = new OrdersList();
        Controller controller = new Controller(view, model);
        controller.runProgram(args);
    }
}
