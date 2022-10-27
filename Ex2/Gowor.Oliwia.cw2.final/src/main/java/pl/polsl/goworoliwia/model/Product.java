/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

/**
 * Model class of the application responsible for product data.
 *
 * @author Oliwia Gowor
 * @version 1.0
 */
public class Product {

    /**
     * Value represents name of the product.
     */
    private String name;
    /**
     * Value represents price Netto of the product.
     */
    private double priceNetto;
    /**
     * Value represents value Netto of the product.
     */
    private double valueNetto;
    /**
     * Value represents value Brutto of the product.
     */
    private double valueBrutto;
    /**
     * Value represents value VAT of the product.
     */
    private double valueVat;

    /**
     * Value represents VAT Rate of the product.
     */
    private VatRates.VatRate vatRate;
    /**
     * Value represents quantinity of the product.
     */
    private int quantinity;
    /**
     * Value represents products unit.
     */
    private String unit;

    /**
     * Non-parameter constructor.
     */
    public Product() {
    }

    /**
     * Class contructor.
     *
     * @param name parameter represents name of the product
     * @param priceNetto parameter represents price Netto of the product
     * @param vatRate parameter represents VAT Rate of the product
     * @param quantinity parameter represents quantinity of the product
     * @param unit parameter represents products unit
     */
    public Product(String name, double priceNetto, VatRates.VatRate vatRate, int quantinity, String unit) {
        this.name = name;
        this.priceNetto = priceNetto;
        this.vatRate = vatRate;
        this.quantinity = quantinity;
        this.unit = unit;
        //calculate value Netto
        this.valueNetto = priceNetto * quantinity;
        //calculate value VAT
        this.valueVat = valueNetto * vatRate.getVatRate();
        //calculate value Brutto
        this.valueBrutto = valueNetto + valueVat;
    }

    /**
     * Method returns name class parameter.
     *
     * @return parameter representing name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Method sets name class parameter.
     *
     * @param name parameter representing name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns priceNetto class parameter.
     *
     * @return parameter representing price Netto of the product
     */
    public double getPriceNetto() {
        return priceNetto;
    }

    /**
     * Method sets priceNetto class parameter.
     *
     * @param priceNetto parameter representing price Netto of the product
     */
    public void setPriceNetto(double priceNetto) {
        this.priceNetto = priceNetto;
    }

    /**
     * Method returns valueNetto class parameter.
     *
     * @return parameter representing value Netto of the product
     */
    public double getValueNetto() {
        return valueNetto;
    }

    /**
     * Method sets valueNetto class parameter.
     *
     * @param valueNetto parameter representing value Netto of the product
     */
    public void setValueNetto(double valueNetto) {
        this.valueNetto = valueNetto;
    }

    /**
     * Method returns valueBrutto class parameter.
     *
     * @return parameter representing value Brutto of the product
     */
    public double getValueBrutto() {
        return valueBrutto;
    }

    /**
     * Method sets valueBrutto class parameter.
     *
     * @param valueBrutto parameter representing value Brutto of the product
     */
    public void setValueBrutto(double valueBrutto) {
        this.valueBrutto = valueBrutto;
    }

    /**
     * Method returns valueVat class parameter.
     *
     * @return parameter representing VAT value of the product
     */
    public double getValueVat() {
        return valueVat;
    }

    /**
     * Method sets valueVat class parameter.
     *
     * @param valueVat parameter representing VAT value of the product
     */
    public void setValueVat(double valueVat) {
        this.valueVat = valueVat;
    }

    /**
     * Method returns vatRate class parameter.
     *
     * @return parameter representing VAT rate of the product
     */
    public VatRates.VatRate getVatRate() {
        return vatRate;
    }

    /**
     * Method sets vatRate class parameter.
     *
     * @param vatRate parameter representing products VAT rate
     */
    public void setVatRate(VatRates.VatRate vatRate) {
        this.vatRate = vatRate;
    }

    /**
     * Method returns quantinity class parameter.
     *
     * @return parameter representing quantinity of the product
     */
    public int getQuantinity() {
        return quantinity;
    }

    /**
     * Method sets quantinity class parameter.
     *
     * @param quantinity parameter representing quantinity of the product
     */
    public void setQuantinity(int quantinity) {
        this.quantinity = quantinity;
    }

    /**
     * Method returns unit class parameter.
     *
     * @return parameter representing unit of the product
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Method sets unit class parameter.
     *
     * @param unit parameter representing unit of the product
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
