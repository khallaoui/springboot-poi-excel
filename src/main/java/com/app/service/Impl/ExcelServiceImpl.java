package com.app.service.Impl;


import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Element;
import com.app.repo.ElementRepo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ExcelServiceImpl {

    private final ElementRepo elementRepo;

    public void importUsersFromExcel(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            List<Element> elementList = new ArrayList<>();
            Iterator<Row> rows = sheet.iterator();
            boolean firstRow = true;

            while (rows.hasNext()) {
                Row row = rows.next();

                // Skip header row
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                Element element = new Element();
                element.setNom(row.getCell(0).getStringCellValue());
                element.setAlias(row.getCell(1).getStringCellValue());
                element.setNote(row.getCell(2).getNumericCellValue());

                elementList.add(element);
            }

            workbook.close();
            elementRepo.saveAll(elementList);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading Excel file: " + e.getMessage());
        }
    }
}