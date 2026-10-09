package com.tienda.decorator;

public class CompressionDecorator extends MessageDecorator {
    public CompressionDecorator(Message message) {
        super(message);
    }

    @Override
    public void send(String content) {
        String compressedData = "ZIP(" + content + ")";
        System.out.println("[COMPRESSION]: Contenido optimizado y reducido.");
        super.send(compressedData);
    }
}
