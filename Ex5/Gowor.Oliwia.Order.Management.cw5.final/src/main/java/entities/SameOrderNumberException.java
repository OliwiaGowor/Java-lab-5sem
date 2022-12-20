/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * Exception class for object of OrdersList class thrown when there is order
 * with the same number on the list.
 *
 * @author Oliwia Gowor
 * @version 5.0
 */
public class SameOrderNumberException extends Exception {

    /**
     * Non-parameter constructor
     */
    public SameOrderNumberException() {
    }

    /**
     * Exception class constructor
     *
     * @param message message to display
     */
    public SameOrderNumberException(String message) {
        super(message);
    }
}
