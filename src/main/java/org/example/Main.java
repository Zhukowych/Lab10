package org.example;

import org.example.decorator.CachedDocument;
import org.example.decorator.SmartDocument;

public class Main {
    public static void main(String[] args) {

        SmartDocument document = new SmartDocument("/home/zhukowych/Projects/ucu/OOP/Lab10/DecoratorPractice/img.png");
        CachedDocument cachedDocument = new CachedDocument(document);
        System.out.println(cachedDocument.parse());
    }
}