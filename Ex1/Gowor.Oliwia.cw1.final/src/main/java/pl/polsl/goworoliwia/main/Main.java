/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pl.polsl.goworoliwia.main;

import pl.polsl.goworoliwia.controller.Controller;
import pl.polsl.goworoliwia.model.OrdersList;
import pl.polsl.goworoliwia.view.View;

/**
 *
 * @author SuperStudent
 */
public class Main {
    /**
     * @param args program call parameters
     */
    public static void main(String[] args) {
        View view = new View();
        OrdersList model = new OrdersList();
        Controller controller = new Controller(view, model);
        controller.readParameters(args);
        controller.mainMenu();
    }
}
