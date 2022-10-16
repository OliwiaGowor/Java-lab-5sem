/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

/**
 *
 * @author SuperStudent
 */
public class Product {

    private String name;
    private double priceNetto;
    private double valueNetto;
    private double valueBrutto;
    private double valueVat;
    private double vatRate;
    private int quantinity;
    private String unit;

    public Product(String name, double priceNetto, double vatRate, int quantinity, String unit) {
        this.name = name;
        this.priceNetto = priceNetto;
        this.valueNetto = priceNetto * quantinity;
        this.valueBrutto = valueNetto + valueVat;
        this.valueVat = valueNetto * (vatRate / 100);
        this.vatRate = vatRate;
        this.quantinity = quantinity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceNetto() {
        return priceNetto;
    }

    public void setPriceNetto(double priceNetto) {
        this.priceNetto = priceNetto;
    }

    public double getValueNetto() {
        return valueNetto;
    }

    public void setValueNetto(double valueNetto) {
        this.valueNetto = valueNetto;
    }

    public double getValueBrutto() {
        return valueBrutto;
    }

    public void setValueBrutto(double valueBrutto) {
        this.valueBrutto = valueBrutto;
    }

    public double getValueVat() {
        return valueVat;
    }

    public void setValueVat(double valueVat) {
        this.valueVat = valueVat;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public int getQuantinity() {
        return quantinity;
    }

    public void setQuantinity(int quantinity) {
        this.quantinity = quantinity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
