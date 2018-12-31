package com.prism.dashboard.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.prism.dashboard.model.PacStatusModel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfReport {
	 public static ByteArrayInputStream pacStatusReport(List<PacStatusModel> data) {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {

	            PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(60);
	            table.setWidths(new int[]{3, 3});

	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	            
	        /*    PdfPCell title;
	            title=new PdfPCell(new Phrase("Project Approval Status", headFont));
	            title.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(title);
            */
	            PdfPCell hcell;
	            
	            hcell = new PdfPCell(new Phrase("Status Description", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Number of projects", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            for (PacStatusModel value : data) {

	                PdfPCell cell;             

	                cell = new PdfPCell(new Phrase(value.getStatus_desc()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	
	                cell = new PdfPCell(new Phrase(Integer.toString(value.getCount())));
	                cell.setPaddingLeft(3);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	            }

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(table);
	            document.addTitle("Project approval status");
	            document.close();
	            
	        } catch (DocumentException ex) {
	        
	            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
}
