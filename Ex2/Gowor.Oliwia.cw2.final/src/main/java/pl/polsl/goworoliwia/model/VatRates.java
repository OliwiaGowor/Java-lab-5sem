/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.goworoliwia.model;

/**
 *
 * @author oliwia
 */
public class VatRates {

    public enum VatRate {
        ZERO(0.0), FIVE(0.05), EIGHT(0.08), TWENTYTHREE(0.23);
        Double vatRate;

        VatRate(Double vatRate) {
            this.vatRate = vatRate;
        }

        public Double getVatRate() {
            return vatRate;
        }

        public void setVatRate(Double vatRate) {
            this.vatRate = vatRate;
        }

    };

}
