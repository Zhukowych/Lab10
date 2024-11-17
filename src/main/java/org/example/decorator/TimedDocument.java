package org.example.decorator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimedDocument extends AbstractDecorator {

    private long lastExecutionTime;

    public TimedDocument(Document wrappedDocument) {
        super(wrappedDocument);
    }

    @Override
    public String parse() {
        long startTime = System.currentTimeMillis();
        String result = wrappedDocument.parse();
        long finishTime = System.currentTimeMillis();
        this.lastExecutionTime = finishTime - startTime;
        return result;
    }

    @Override
    public String getPath() {
        return wrappedDocument.getPath();
    }
}
