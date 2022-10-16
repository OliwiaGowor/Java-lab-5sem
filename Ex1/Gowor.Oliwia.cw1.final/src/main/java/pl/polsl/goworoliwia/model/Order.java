/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;


import java.util.List;

/**
 *
 * @author SuperStudent
 */
public class Order {

    private String number;
    private Buyer buyer;
    private Date orderDate;
    private List<Product> products;
    private String paymentMethod;
    private double sumNetto;
    private double sumBrutto;
    private double sumVat;

    public Order() {
    }
    
    //Constructor
    public Order(String number, Date purchaseDate, Buyer buyer, List<Product> products, String paymentMethod) {
        this.number = number;
        this.orderDate = purchaseDate;
        this.buyer = buyer;
        this.products = products;
        this.paymentMethod = paymentMethod;
        //calculate sumNetto
        for (int i = 0; i < products.size(); i++) {
            this.sumNetto += products.get(i).getValueNetto();
        }
        //calculate sumBrutto
        for (int i = 0; i < products.size(); i++) {
            this.sumBrutto += products.get(i).getValueBrutto();
        }
        //calculate sumVat
        for (int i = 0; i < products.size(); i++) {
            this.sumVat += products.get(i).getValueVat();
        }
    }

    //Getters and setters
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public String getNumber() {
        return number;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getSumNetto() {
        return sumNetto;
    }

    public double getSumBrutto() {
        return sumBrutto;
    }

    public double getSumVat() {
        return sumVat;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

}
