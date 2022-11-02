/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

import java.util.List;

/**
 * Model class of the application responsible for product data.
 *
 * @author Oliwia Gowor
 * @version 2.0
 */
public class Product {

    /**
     * Enumeration type representing VAT rates, by default extends Enum
     */
    public enum VatRate {
        ZERO(0.0), FIVE(0.05), EIGHT(0.08), TWENTYTHREE(0.23);
        Double vatRate;

        /**
         * Enum constructor.
         *
         * @param vatRate parameter representing VAT rate of the product
         */
        VatRate(Double vatRate) {
            this.vatRate = vatRate;
        }

        /**
         * Method returns VAT rate of the product.
         *
         * @return parameter representing VAT rate of the product
         */
        public Double getVatRate() {
            return vatRate;
        }

        /**
         * Method sets vatRate class parameter.
         *
         * @param vatRate parameter representing VAT rate of the product
         */
        public void setVatRate(Double vatRate) {
            this.vatRate = vatRate;
        }

    };

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
    private VatRate vatRate;
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
        this.name = "none";
        this.priceNetto = 0;
        this.vatRate = VatRate.ZERO;
        this.quantinity = 0;
        this.unit = "none";
        this.valueNetto = 0;
        this.valueVat = 0;
        this.valueBrutto = 0;
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
    public Product(String name, double priceNetto, VatRate vatRate, int quantinity, String unit) {
        this.name = name;
        this.priceNetto = priceNetto;
        this.vatRate = vatRate;
        this.quantinity = quantinity;
        this.unit = unit;
        //calculate value Netto
        this.valueNetto = calculateValueNetto(priceNetto,quantinity);
        //calculate value VAT
        this.valueVat = calculateValueVat(valueNetto, vatRate);
        //calculate value Brutto
        this.valueBrutto = calculateValueBrutto(valueNetto, valueVat);
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
    public VatRate getVatRate() {
        return vatRate;
    }

    /**
     * Method sets vatRate class parameter.
     *
     * @param vatRate parameter representing products VAT rate
     */
    public void setVatRate(VatRate vatRate) {
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
    
     /**
     * Method calculates value Netto.
     *
     * @param priceNetto parameter representing price Netto of the product
     * @param quantinity parameter representing quantinity of the product
     * @return calculated value Netto
     */
    private Double calculateValueNetto(Double priceNetto, int quantinity) {
        Double valueNettoTmp = 0.0;
        valueNettoTmp = priceNetto * quantinity;
        return valueNettoTmp;
    }
    
    /**
     * Method calculates value Brutto.
     *
     * @param valueNetto parameter representing value Netto of the product
     * @param valueVat parameter representing VAT value of the product
     * @return calculated value Brutto
     */
    private Double calculateValueBrutto(Double valueNetto, Double valueVat) {
        Double valueBruttoTmp = 0.0;
        valueBruttoTmp = valueNetto + valueVat;
        return valueBruttoTmp;
    }
    
    /**
     * Method calculates value VAT.
     *
     * @param valueNetto parameter representing value Netto of the product
     * @param vatRate parameter representing VAT rate of the product
     * @return calculated value VAT
     */
    private Double calculateValueVat(Double valueNetto, VatRate vatRate) {
        Double valueVatTmp = 0.0;
        valueVatTmp = valueNetto * vatRate.getVatRate();
        return valueVatTmp;
    }

}
