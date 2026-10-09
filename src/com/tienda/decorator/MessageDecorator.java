package com.tienda.decorator;

public abstract class MessageDecorator implements Message {
    protected Message wrappedMessage;

    public MessageDecorator(Message message) {
        this.wrappedMessage = message;
    }

    @Override
    public void send(String content) {
        wrappedMessage.send(content);
    }
}