package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExportExcelStudentController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4698507844653000919L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/vdn.openxmlformats-officedocuments.spreadsheetml.sheet");
		resp.setHeader("Content-Disposition", "attachment;filename=data.xlsx");
		
		try(Workbook workbook=new XSSFWorkbook();){
			Sheet sheet=workbook.createSheet("Data");
			
			Row header=sheet.createRow(0);
			header.createCell(0).setCellValue("Name");
			header.createCell(1).setCellValue("Email");
			header.createCell(2).setCellValue("Message");
			
			Row row=sheet.createRow(1);
			row.createCell(0).setCellValue(req.getParameter("name"));
			row.createCell(1).setCellValue(req.getParameter("email"));
			row.createCell(2).setCellValue(req.getParameter("message"));
			
			try(OutputStream out=resp.getOutputStream();){
				workbook.write(out);
			}
			
		}
		
		
	}
	
	

}
