package dev.bujoralexandru;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PdfExporter {

    public void draw() throws IOException {

        final var doc = new PDDocument();


        newPage(doc);

        doc.save("Test.pdf");
        doc.close();
    }

    private void newPage(PDDocument doc) throws IOException {

        final var page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));

        List<List> data = new ArrayList();
        data.add(new ArrayList<>(
                Arrays.asList("Column One", "Column Two", "Column Three", "Column Four", "Column Five")));
        for (int i = 1; i <= 100; i++) {
            data.add(new ArrayList<>(
                    Arrays.asList("Row " + i + " Col One", "Row " + i + " Col Two", "Row " + i + " Col Three", "Row " + i + " Col Four", "Row " + i + " Col Five")));
        }
        final var dataTable = new BaseTable(
                page.getMediaBox().getUpperRightY() - 20,
                page.getMediaBox().getUpperRightY() - 20,
                20,
                PDRectangle.A4.getHeight() - 40,
                20,
                doc,
                page,
                true,
                true
        );
        DataTable t = new DataTable(dataTable, page);
        t.addListToTable(data, DataTable.HASHEADER);
        dataTable.draw();

        doc.addPage(page);
    }
}

