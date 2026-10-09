package com.tienda;

import com.tienda.facade.PurchaseFacade;

public class Main {
    public static void main(String[] args) {
        // Simulación 1: Un empleado intentando gestionar una compra (Permiso concedido en Proxy)
        PurchaseFacade tiendaEmpleado = new PurchaseFacade("EMPLOYEE");
        tiendaEmpleado.executePurchase("Zapatillas Nike Air Max", 120.50);

        // Simulación 2: Un cliente externo intentando comprar (Acceso denegado en el Proxy de inventario)
        PurchaseFacade tiendaClienteAnonimo = new PurchaseFacade("CUSTOMER");
        tiendaClienteAnonimo.executePurchase("Balón de Fútbol Adidas", 35.00);
    }
}
