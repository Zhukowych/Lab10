package org.example.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMockedDocument {

    @Test
    public void testMockedPath() {
        Assertions.assertEquals("mocked path", new MockedDocument().getPath());
    }

    @Test
    public void testMockedDocument() {
        Assertions.assertEquals("Mocked parse result", new MockedDocument().parse());
    }

}
