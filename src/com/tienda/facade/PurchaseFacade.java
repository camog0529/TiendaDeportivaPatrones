package com.tienda.facade;

import com.tienda.adapter.*;
import com.tienda.decorator.*;
import com.tienda.proxy.*;

public class PurchaseFacade {
    private final InventoryService inventoryProxy;
    private final PaymentProcessor paymentProcessor;

    public PurchaseFacade(String userRole) {
        // Inicializamos los componentes requeridos aplicando los patrones estructurales
        this.inventoryProxy = new SecurityInventoryProxy(new RealInventoryService(), userRole);
        this.paymentProcessor = new PaymentAdapter(new ExternalPaymentService());
    }

    public void executePurchase(String product, double amount) {
        System.out.println("\n=== INICIANDO PROCESO DE COMPRA (VÍA FACADE) ===");

        // 1. Validar Stock usando el Proxy de Seguridad
        if (!inventoryProxy.checkStock(product)) {
            System.out.println("Compra cancelada por problemas de autorización de inventario.");
            return;
        }

        // 2. Procesar Pago usando el Adapter de la API externa
        paymentProcessor.processPayment(amount);

        // 3. Enviar Notificaciones Combinadas usando Decorator (Log + Compresión apilados)
        Message notification = new CompressionDecorator(new LoggingDecorator(new BasicMessage()));
        notification.send("Compra exitosa de: " + product + " por un valor de $" + amount);

        System.out.println("=== PROCESO DE COMPRA FINALIZADO CON ÉXITO ===\n");
    }
}
