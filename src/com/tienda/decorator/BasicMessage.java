package com.tienda.decorator;

public class BasicMessage implements Message {
    @Override
    public void send(String content) {
        System.out.println("Enviando SMS/Email básico: " + content);
    }
}