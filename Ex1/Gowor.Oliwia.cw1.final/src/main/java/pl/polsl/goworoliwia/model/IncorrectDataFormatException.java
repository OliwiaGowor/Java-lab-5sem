/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

/**
 *
 * @author oliwia
 */
public class IncorrectDataFormatException extends Exception {
    /**
     * Non-parameter constructor
     */
    public IncorrectDataFormatException(){   
    }
    
    /**
     * Exception class constructor
     * @param message display message
     */
    public IncorrectDataFormatException(String message) {
        super(message);
    }
}
