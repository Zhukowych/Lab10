package org.example.decorator;

public class MockedDocument extends AbstractDecorator {

    public MockedDocument() {
        super(null);
    }

    @Override
    public String parse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        return "Mocked parse result";
    }

    @Override
    public String getPath() {
        return "mocked path";
    }
}
