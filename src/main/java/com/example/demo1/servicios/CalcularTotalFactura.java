package com.example.demo1.servicios;

import com.example.demo1.entidades.Factura;

public class CalcularTotalFactura {
    public double calcularTotal(Factura factura) {
        double iva = 0.21;
        double totalActual = factura.getTotal();
        double totalFinal = 0;

        totalFinal = totalActual + (totalActual * iva);

        return totalFinal;
    }
}
