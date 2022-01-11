package com.example.travalBuddy.controller;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	
	public static void createPDF(String pdfFilename) {

		Document doc = new Document();
		PdfWriter docWriter = null;
		System.out.println("File name"+pdfFilename);
		DecimalFormat df = new DecimalFormat("0.00");

		try {

			// special font sizes
			Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
			Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

			// file path
			String path = "C:\\Dev Env\\" + pdfFilename + ".pdf";
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));

			// document header attributes
			doc.addAuthor("betterThanZero");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("pareshp");
			doc.addTitle("Bill");
			doc.setPageSize(PageSize.A4);

			// open document
			doc.open();

			Paragraph paragraphMainHeading = new Paragraph("Travel Buddy Holidays");
			Font bfBold14 = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, new BaseColor(0, 0, 0));
			paragraphMainHeading.setFont(bfBold14);
			paragraphMainHeading.setAlignment(Element.ALIGN_RIGHT);

			// create a paragraph
			Paragraph paragraphAddress = new Paragraph("");
			Font bfBold8 = new Font(FontFamily.TIMES_ROMAN, 8, Font.NORMAL, new BaseColor(0, 0, 0));
			paragraphAddress.setFont(bfBold8);
			paragraphAddress.setAlignment(Element.ALIGN_RIGHT);


			// specify column widths
			float[] columnWidths = { 1.5f, 1.5f, 1f, 2f };
			// create PDF table with the given widths
			PdfPTable table = new PdfPTable(columnWidths);
			// set table width a percentage of the page width
			table.setWidthPercentage(90f);

			// insert column headings
			insertCell(table, "Bill No.", Element.ALIGN_LEFT, 1, bfBold12, 1);
			insertCell(table, "" + Math.random(), Element.ALIGN_LEFT, 1, bf12, 1);
			insertCell(table, "Bill To", Element.ALIGN_LEFT, 1, bfBold12, 2);
			insertCell(table, "Paresh Wasudev Pathak\nPimple Gurav Pune", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(table, "Bill Date", Element.ALIGN_LEFT, 1, bfBold12, 1);
			insertCell(table, "" + LocalDate.now(), Element.ALIGN_LEFT, 1, bf12, 1);
			insertCell(table, "Booking Date", Element.ALIGN_LEFT, 1, bfBold12, 1);
			insertCell(table, "" + LocalDate.now(), Element.ALIGN_LEFT, 1, bf12, 1);

			insertCell(table, "", Element.ALIGN_LEFT, 4, bf12, 1);
			table.setHeaderRows(1);

			float[] columnWidthForDetails = { 0.5f, 2f, 1f, 2f };
			// create PDF table with the given widths
			PdfPTable detailsTable = new PdfPTable(columnWidthForDetails);
			// set table width a percentage of the page width
			detailsTable.setWidthPercentage(90f);

			// insert column headings
			insertCell(detailsTable, "Sr.No", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "Passanger Name", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Travel From", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Kolkata", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "1", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "Paresh Pathak", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Travel To", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Pune", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "2", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "Paresh Pathak", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Date of Travel", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Pune", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "3", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "Paresh Pathak", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Flight Details", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Indigo", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "4", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "PRN No.", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "XDSDF", Element.ALIGN_RIGHT, 1, bfBold12, 1);

			insertCell(detailsTable, "5", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Ticket No.", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "-", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "6", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Ticket Amount", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "55090", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "7", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Service Charges", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "700", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "8", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Tra/Cancellation charges", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "", Element.ALIGN_RIGHT, 1, bf12, 1);

			insertCell(detailsTable, "9", Element.ALIGN_CENTER, 1, bf12, 1);
			insertCell(detailsTable, "", Element.ALIGN_LEFT, 1, bf12, 2);
			insertCell(detailsTable, "Net payable", Element.ALIGN_LEFT, 1, bfBold12, 2);
			insertCell(detailsTable, "55790", Element.ALIGN_RIGHT, 1, bfBold12, 1);

			table.setHeaderRows(1);
			Image image = Image.getInstance("C:\\Dev Env\\img.jpg");
			image.setAlignment(Element.ALIGN_LEFT);
			image.scaleAbsolute(100, 100);

			float[] columnWidthForHeader = { 1.0f, 1.5f };
			PdfPTable headerTable = new PdfPTable(columnWidthForHeader);
			headerTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			headerTable.addCell(image);
			
			Paragraph p = new Paragraph("Travel Buddy Holidays\nCreative Lifestyle CHS\nPimple Gurav, Pune");
			p.setAlignment(Element.ALIGN_RIGHT);
			PdfPCell c = new PdfPCell();
			c.setLeft(450);
			c.addElement(p);
			c.setBorder(PdfPCell.NO_BORDER);
			headerTable.addCell(c);
			//headerTable.addCell("");

			Image image1 = Image.getInstance("C:\\Dev Env\\sign.png");
			image1.setAlignment(Element.ALIGN_RIGHT);
			image1.scaleAbsolute(90, 90);
			
			// Add to document
			Paragraph test = new Paragraph();
			test.add(headerTable);
			//test.setIndentationLeft(150);
			
			// add the PDF table to the paragraph
			doc.add(test);
			// doc.add(paragraphMainHeading);
			paragraphAddress.add(table);
			paragraphAddress.add(detailsTable);
			doc.add(paragraphAddress);
			doc.add(image1);

		} catch (DocumentException dex) {
			dex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (doc != null) {
				// close the document
				doc.close();
			}
			if (docWriter != null) {
				// close the writer
				docWriter.close();
			}
		}
	}

	private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font, int rowSpan) {

		// create a new cell with the specified Text and Font
		PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		// set the cell alignment
		cell.setHorizontalAlignment(align);
		// set the cell column span in case you want to merge two or more cells
		cell.setColspan(colspan);
		// cell.setRowspan(rowSpan);
		// in case there is no text and you wan to create an empty row
		if (text.trim().equalsIgnoreCase("")) {
			cell.setMinimumHeight(10f);
		}
		// add the call to the table
		table.addCell(cell);

	}

}
