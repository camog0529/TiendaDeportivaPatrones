package com.tienda.proxy;

public class RealInventoryService implements InventoryService {
    @Override
    public boolean checkStock(String product) {
        System.out.println("[DB REAL] Consultando inventario en la base de datos para: " + product);
        return true;
    }
}