/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

/**
 * Model class of the application responsible for date data.
 *
 * @author Oliwia Gowor
 * @version 2.0
 */
public class Date {

    /**
     * Value represents year of the date.
     */
    private int year;
    /**
     * Value represents month of the date.
     */
    private int month;
    /**
     * Value represents day of the date.
     */
    private int day;

    /**
     * Non-parameter Date class constructor
     */
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    /**
     * Date class constructor.
     *
     * @param year represents year of the date
     * @param month represents month of the date
     * @param day represents day of the date
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Method returns day class parameter.
     *
     * @return parameter representing day of the date
     */
    public int getDay() {
        return day;
    }

    /**
     * Method sets day parameter.
     *
     * @param day parameter representing day of the date
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Method returns month class parameter.
     *
     * @return parameter representing month of the date
     */
    public int getMonth() {
        return month;
    }

    /**
     * Method sets month parameter.
     *
     * @param month parameter representing month of the date
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Method returns year class parameter.
     *
     * @return parameter representing year of the date
     */
    public int getYear() {
        return year;
    }

    /**
     * Method sets year parameter.
     *
     * @param year parameter representing year of the date
     */
    public void setYear(int year) {
        this.year = year;
    }

}
