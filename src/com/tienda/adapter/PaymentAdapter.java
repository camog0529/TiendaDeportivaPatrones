package com.tienda.adapter;

public class PaymentAdapter implements PaymentProcessor {
    private final ExternalPaymentService externalService;

    public PaymentAdapter(ExternalPaymentService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void processPayment(double amount) {
        // Traducimos el método esperado por nuestra tienda al de la biblioteca externa
        externalService.makeTransaction(amount);
    }
}