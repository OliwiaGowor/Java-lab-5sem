/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.model;

import java.util.Arrays;
import java.util.List;

/**
 * Model class of the application responsible for order data.
 *
 * @author Oliwia Gowor
 * @version 4.0
 */
public class Order {

    /**
     * Value represents number of the order.
     */
    private String number;
    /**
     * Value represents orders buyer.
     */
    private Buyer buyer;
    /**
     * Value represents date of the order.
     */
    private Date orderDate;
    /**
     * Value represents list of products form the order.
     */
    private List<Product> products;
    /**
     * Value represents orders payment method.
     */
    private String paymentMethod;
    /**
     * Value represents sum of Netto value of the products in the order.
     */
    private double sumNetto;
    /**
     * Value represents sum of Brutto value of the products in the order.
     */
    private double sumBrutto;
    /**
     * Value represents sum of VAT value of the products in the order.
     */
    private double sumVat;

    /**
     * Non-parameter constructor
     */
    public Order() {
        this.number = "number";
        this.orderDate = new Date();
        this.buyer = new Buyer();
        this.products = Arrays.asList(new Product(), new Product());
        this.paymentMethod = "payment";
        this.sumNetto = 0;
        this.sumVat = 0;
        this.sumBrutto = 0;
    }

    /**
     * Order class constructor.
     *
     * @param number represents number of the order
     * @param purchaseDate represents date of the order
     * @param buyer represents orders buyer
     * @param products represents list of products form the order
     * @param paymentMethod represents orders payment method
     */
    public Order(String number, Date purchaseDate, Buyer buyer, List<Product> products, String paymentMethod) {
        this.number = number;
        this.orderDate = purchaseDate;
        this.buyer = buyer;
        this.products = products;
        this.paymentMethod = paymentMethod;
        //calculate sumNetto
        this.sumNetto = calculateSumNetto(products);
        //calculate sumBrutto
        this.sumVat = calculateSumVat(products);
        //calculate sumVat
        this.sumBrutto = calculateSumBrutto(products);
    }

    /**
     * Method returns number class parameter.
     *
     * @return parameter representing number of the order
     */
    public String getNumber() {
        return number;
    }

    /**
     * Method sets number parameter.
     *
     * @param number parameter representing number of the order
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Method returns buyer class parameter.
     *
     * @return parameter representing orders buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Method sets buyer parameter.
     *
     * @param buyer parameter representing orders buyer
     */
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    /**
     * Method returns orderDate class parameter.
     *
     * @return parameter representing date of the order
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Method sets orderDate parameter.
     *
     * @param orderDate parameter representing date of the order
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Method returns products class parameter.
     *
     * @return parameter representing list of products form the order
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Method sets products parameter.
     *
     * @param products parameter representing list of products form the order
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Method returns paymentMethod class parameter.
     *
     * @return parameter representing orders payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Method sets paymentMethod parameter.
     *
     * @param paymentMethod parameter representing orders payment method
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Method returns sumNetto class parameter.
     *
     * @return parameter representing sum of Netto value of the products in the
     * order
     */
    public double getSumNetto() {
        return sumNetto;
    }

    /**
     * Method returns sumBrutto class parameter.
     *
     * @return parameter representing representing sum of Brutto value of the
     * products in the order
     */
    public double getSumBrutto() {
        return sumBrutto;
    }

    /**
     * Method returns sumVat class parameter.
     *
     * @return parameter representing sum of VAT value of the products in the
     * order
     */
    public double getSumVat() {
        return sumVat;
    }

    /**
     * Method adds given product to products list.
     *
     * @param product parameter representing product to add to the list
     * @return true when product was added, false when it wasn't
     */
    public Boolean addNewProduct(Product product) {
        if (product != null) {
            products.add(product);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method calculates sumNetto parameter.
     *
     * @param givenProducts parameter represents list of products to calculate
     * sum Netto of
     * @return calculated sumNetto parameter
     */
    private Double calculateSumNetto(List<Product> givenProducts) {
        Double sumNetto = 0.0;
        for (Product product : givenProducts) {
            sumNetto += product.getValueNetto();
        }
        return sumNetto;
    }

    /**
     * Method calculates sumVat parameter.
     *
     * @param givenProducts parameter represents list of products to calculate
     * sum VAT of
     * @return calculated sumVat parameter
     */
    private Double calculateSumVat(List<Product> givenProducts) {
        Double sumVat = 0.0;
        for (Product product : givenProducts) {
            sumVat += product.getValueVat();
        }
        return sumVat;
    }

    /**
     * Method calculates sumBrutto parameter.
     *
     * @param givenProducts parameter represents list of products to calculate
     * sum Brutto of
     * @return calculated sumBrutto parameter
     */
    private Double calculateSumBrutto(List<Product> givenProducts) {
        Double sumBrutto = 0.0;
        for (Product product : givenProducts) {
            sumBrutto += product.getValueBrutto();
        }
        return sumBrutto;
    }

}
