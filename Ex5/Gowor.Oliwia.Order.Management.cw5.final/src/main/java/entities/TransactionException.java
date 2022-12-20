/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * Exception class for objects of EntityTransaction class thrown when
 * transaction doesn't work properly.
 *
 * @author Oliwia Gowor
 * @version 5.0
 */
public class TransactionException extends Exception {

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public TransactionException(String message) {
        super(message);
    }

    /**
     * Non-parameter constructor
     */
    public TransactionException() {
    }
}
