package com.tienda.adapter;

public class ExternalPaymentService {
    public void makeTransaction(double value) {
        System.out.println("[API EXTERNA] Transacción completada exitosamente por un valor de: $" + value);
    }
}