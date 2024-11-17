package org.example.decorator;

public abstract class AbstractDecorator implements Document {

    protected Document wrappedDocument;

    public AbstractDecorator(Document wrappedDocument) {
        this.wrappedDocument = wrappedDocument;
    }

}
