package org.example.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTimedDocument {

    @Test
    public void testTimedDocument() {
        MockedDocument mockedDocument = new MockedDocument();
        TimedDocument document = new TimedDocument(mockedDocument);
        Assertions.assertEquals(document.parse(), mockedDocument.parse());
    }

    @Test
    public void testTimeCapture() {
        MockedDocument mockedDocument = new MockedDocument();
        TimedDocument document = new TimedDocument(mockedDocument);
        document.parse();
        Assertions.assertTrue(document.getLastExecutionTime() >= 1000);
    }

}
