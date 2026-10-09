package com.tienda.proxy;

public class SecurityInventoryProxy implements InventoryService {
    private final InventoryService realService;
    private final String userRole;

    public SecurityInventoryProxy(InventoryService realService, String userRole) {
        this.realService = realService;
        this.userRole = userRole;
    }

    @Override
    public boolean checkStock(String product) {
        System.out.println("[PROXY] Verificando permisos de seguridad para el rol: " + userRole);
        if ("ADMIN".equalsIgnoreCase(userRole) || "EMPLOYEE".equalsIgnoreCase(userRole)) {
            System.out.println("[PROXY] Acceso concedido.");
            return realService.checkStock(product);
        } else {
            System.out.println("[PROXY] ❌ ACCESO DENEGADO: Permisos insuficientes para consultar inventario.");
            return false;
        }
    }
}
