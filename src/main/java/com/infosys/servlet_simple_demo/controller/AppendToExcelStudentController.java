package com.infosys.servlet_simple_demo.controller;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppendToExcelStudentController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String FILE_PATH="D:/Information Technology/Java/Project/maven-project/studentMessage.xlsx";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String message=req.getParameter("message");
		
		File file=new File(FILE_PATH);
		Workbook workbook;
		Sheet sheet;;
		
		if(file.exists()) {
			FileInputStream fileIn=new FileInputStream(FILE_PATH);
			workbook=new XSSFWorkbook(fileIn);
			sheet=workbook.getSheetAt(0);
			fileIn.close();
			
		}else {
			workbook=new XSSFWorkbook();
			sheet=workbook.createSheet();
			Row header=sheet.createRow(0);
			header.createCell(0).setCellValue("Name");
			header.createCell(1).setCellValue("Email");
			header.createCell(2).setCellValue("Message");
			
			Row row=sheet.createRow(1);
			row.createCell(0).setCellValue(name);
			row.createCell(1).setCellValue(req.getParameter("email"));
			row.createCell(2).setCellValue(req.getParameter("message"));
			
		}
		
		int lastRowNum=sheet.getLastRowNum(); //Here it gets the last value of the row position <Starting 0>
		Row row=sheet.createRow(lastRowNum+1); //Here it initializes the value of the row next to the previous row
		row.createCell(0).setCellValue(name);
		row.createCell(1).setCellValue(email);
		row.createCell(2).setCellValue(message);
		
		
		//Write back to file
		try(FileOutputStream out=new FileOutputStream(FILE_PATH);){
			workbook.write(out);
			out.close();
		}
		workbook.close();

	}

}
