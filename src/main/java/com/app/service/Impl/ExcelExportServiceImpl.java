package com.app.service.Impl;


import com.app.entities.Element;
import com.app.repo.ElementRepo;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExcelExportServiceImpl {
    private final ElementRepo ElementRepo;

    public void exportUsersToExcel(HttpServletResponse response) throws IOException {
        List<Element> elements = ElementRepo.findAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Elements");

        // Create Header Row
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Nom", "Alias", "Note"};
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerStyle);
        }

        // Fill Data Rows
        int rowNum = 1;
        for (Element element : elements) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(element.getNom());
            row.createCell(1).setCellValue(element.getAlias());
            row.createCell(2).setCellValue(element.getNote());
        }

        // Auto-size columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}