package com.team11.charityserver.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.team11.charityserver.model.Donation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PdfUtil {

    public void createPDF(Document document, PdfWriter writer, List<Donation> donations) throws IOException {
        //Document document = new Document(PageSize.A4);
        try {
            document.addTitle("sheet of donations");
            document.addAuthor("zzhou");
            document.addSubject("donation sheet.");
            document.addKeywords("donation.");
            document.open();
            PdfPTable table = createTable(writer,donations);
            document.add(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
    public static PdfPTable createTable(PdfWriter writer,List<Donation> donations) throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        int size = 20;
        Font font=new Font(2,12,20);

        cell = new PdfPCell(new Phrase("Date", font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("ProjectId", font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Money", font));
        cell.setFixedHeight(size);
        table.addCell(cell);

        for (Donation donation : donations) {
            cell = new PdfPCell(new Phrase(donation.getDate() + "", font));
            cell.setFixedHeight(size);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(donation.getProjectId() + "", font));
            cell.setFixedHeight(size);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(donation.getMoney() + "", font));
            cell.setFixedHeight(size);
            table.addCell(cell);
        }

        return table;
    }
}

