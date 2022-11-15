/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.gowor.oliwia.model;

/**
 * Model class of the application responsible for buyer data.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class Buyer {

    /**
     * Value represents name of the buyer.
     */
    private String name;
    /**
     * Value represents surname of the buyer.
     */
    private String surname;
    /**
     * Value represents buyers address.
     */
    private String address;

    /**
     * Non-parameter constructor.
     */
    public Buyer() {
        this.name = "name";
        this.surname = "surname";
        this.address = "address";
    }

    /**
     * Buyer class constructor.
     *
     * @param name parameter representing name of the buyer
     * @param surname parameter representing surname of the buyer
     * @param address parameter representing buyers address
     */
    public Buyer(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    /**
     * Method returns name class parameter.
     *
     * @return parameter representing name of the buyer
     */
    public String getName() {
        return name;
    }

    /**
     * Method sets name parameter.
     *
     * @param name parameter representing name of the buyer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns surname class parameter.
     *
     * @return parameter representing surname of the buyer
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Method sets surname parameter.
     *
     * @param surname parameter representing surname of the buyer
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method returns address class parameter.
     *
     * @return parameter representing buyers address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method sets address parameter.
     *
     * @param address parameter representing buyers address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method converts buyer's data to one string.
     *
     * @return string with all buyer data
     */
    @Override
    public String toString() {
        return name + " " + surname + " address: " + address;
    }

}
