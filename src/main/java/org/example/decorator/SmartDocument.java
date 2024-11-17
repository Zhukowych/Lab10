package org.example.decorator;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;


@AllArgsConstructor
public class SmartDocument implements Document {
    private String path;

    @SneakyThrows
    public String parse() {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("/home/zhukowych/Projects/ucu/OOP/Lab10/DecoratorPractice/");
            tesseract.setLanguage("eng");
            return tesseract.doOCR(new File(path));
        } catch (TesseractException exp) {
            exp.printStackTrace();
        }

        return "";
    }

    @Override
    public String getPath() {
        return this.path;
    }

}