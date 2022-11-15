/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.gowor.oliwia.model;

/**
 * Exception class for object of OrdersList class thrown when there is no such
 * Order object on list.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class OrderNotFoundException extends Exception {

    /**
     * Non-parameter constructor
     */
    public OrderNotFoundException() { }

    /**
     * Exception class constructor
     *
     * @param message message to display
     */
    public OrderNotFoundException(String message) {
        super(message);
    }
}
