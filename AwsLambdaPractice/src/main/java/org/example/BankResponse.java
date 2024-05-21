package org.example;

import java.math.BigDecimal;

public class BankResponse {
    //Lo que se requiere de la funcion es que en la request, se envie una cantidad deseada por un usuario para solicitar un prestamo, en que plazo lo puede pagar y el interes que se le colocara a ese prestamo. Entonces en base a eso, se calculara cual sera el valor de la cuota.
    private BigDecimal valorCuota;
    private Integer plazo;
    private BigDecimal interes;
    //Si el usuario tiene una cuenta registrada en el supuesto banco, tendra un descuento
    private BigDecimal cuotaConCuenta;
    private BigDecimal interesConCuenta;
    private Integer plazoConCuenta;

    public BankResponse(BigDecimal valorCuota, Integer plazo, BigDecimal interes, BigDecimal cuotaConCuenta, BigDecimal interesConCuenta, Integer plazoConCuenta) {
        this.valorCuota = valorCuota;
        this.plazo = plazo;
        this.interes = interes;
        this.cuotaConCuenta = cuotaConCuenta;
        this.interesConCuenta = interesConCuenta;
        this.plazoConCuenta = plazoConCuenta;
    }


    public BigDecimal getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getCuotaConCuenta() {
        return cuotaConCuenta;
    }

    public void setCuotaConCuenta(BigDecimal cuotaConCuenta) {
        this.cuotaConCuenta = cuotaConCuenta;
    }

    public BigDecimal getInteresConCuenta() {
        return interesConCuenta;
    }

    public void setInteresConCuenta(BigDecimal interesConCuenta) {
        this.interesConCuenta = interesConCuenta;
    }

    public Integer getPlazoConCuenta() {
        return plazoConCuenta;
    }

    public void setPlazoConCuenta(Integer plazoConCuenta) {
        this.plazoConCuenta = plazoConCuenta;
    }
}
