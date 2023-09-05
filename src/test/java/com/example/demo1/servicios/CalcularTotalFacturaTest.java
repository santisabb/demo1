package com.example.demo1.servicios;

import com.example.demo1.entidades.Factura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcularTotalFacturaTest {

    @Test
    void calcularTotal() {
        Factura factura = new Factura(123456L, 1500.50, "Factura B", "Sabbioni, Santiago");
        CalcularTotalFactura calcular = new CalcularTotalFactura();

        double total = calcular.calcularTotal(factura);
        System.out.println("Total: " + total);

        assertTrue(total > 0);
    }
}