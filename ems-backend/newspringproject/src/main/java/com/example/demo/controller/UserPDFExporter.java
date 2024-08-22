package com.example.demo.controller;

import java.awt.Color;

import java.io.IOException;
import java.util.List;



import com.example.demo.dto.EmployeeDto;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

public class UserPDFExporter {
 private List<EmployeeDto> listUsers;

public UserPDFExporter(List<EmployeeDto> listUsers) {
	super();
	this.listUsers = listUsers;
}
 private void writeTableHeader(PdfPTable table) {
	 PdfPCell cell=new PdfPCell();
	 cell.setBackgroundColor(Color.blue);
	 cell.setPadding(5);
	 
	 Font font= FontFactory.getFont(FontFactory.HELVETICA);
	 font.setColor(Color.white);
	 cell.setPhrase(new Phrase("User ID",font));
	 table.addCell(cell);
	 cell.setPhrase(new Phrase("Firstname",font));
	 table.addCell(cell);
	 cell.setPhrase(new Phrase("lastname",font));
	 table.addCell(cell);
	 cell.setPhrase(new Phrase("email",font));
	 table.addCell(cell);
 }
private void writeTableData(PdfPTable table) {
	 for(EmployeeDto user: listUsers) {
		 table.addCell(String.valueOf(user.getId()));
		 table.addCell(user.getFirstname());
		 table.addCell(user.getLastname());
		 table.addCell(user.getEmail());
	 }
	 
 }

public void export(HttpServletResponse response) throws DocumentException, IOException {
	Document document =new Document(PageSize.A4);
	
	PdfWriter.getInstance(document,response.getOutputStream());
	document.open();
	 Font font= FontFactory.getFont(FontFactory.HELVETICA);
	 font.setColor(Color.black);
	Paragraph title=new Paragraph("List of Users",font);
	document.add(title);	
	PdfPTable table=new PdfPTable(4);
	
	table.setWidthPercentage(100);
	table.setSpacingBefore(15);
	writeTableHeader(table);
	writeTableData(table);
	document.add(table)
;	document.close();
}
 
}
