package com.tienda.decorator;

public class LoggingDecorator extends MessageDecorator {
    public LoggingDecorator(Message message) {
        super(message);
    }

    @Override
    public void send(String content) {
        System.out.println("[LOG]: Registrando auditoría de notificación.");
        super.send(content);
    }
}
