package dev.bujoralexandru;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final var pdfExporter = new PdfExporter();
        pdfExporter.draw();
    }
}
