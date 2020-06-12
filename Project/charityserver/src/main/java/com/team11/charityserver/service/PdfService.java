package com.team11.charityserver.service;

import com.lowagie.text.Document;
import com.team11.charityserver.model.Donation;
import com.team11.charityserver.util.PdfUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PdfService extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        String fileName = new Date().getTime()+"_quotation.pdf";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","filename=" + new String(fileName.getBytes(), "iso8859-1"));
        List<Donation> products = (List<Donation>) model.get("sheet");
        PdfUtil pdfUtil = new PdfUtil();
        pdfUtil.createPDF(document, writer, products);
    }

}
