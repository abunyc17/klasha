package com.assessment.klasha.util;

import com.assessment.klasha.model.request.CsvMapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/
@Configuration
public class CSVReader {

    public static List<CsvMapper> readCsvFile() throws IOException {
        List<CsvMapper> csvMapperList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource("exchange_rate.csv");
        XSSFWorkbook sheets = new XSSFWorkbook(resource.getInputStream());
        XSSFSheet workSheet = sheets.getSheetAt(1);
        int worksheetCount = workSheet.getPhysicalNumberOfRows();
        if(worksheetCount == 0){
            throw new RuntimeException("Empty CSV file");
        }
        for(int i = 0; i < workSheet.getPhysicalNumberOfRows();i++){
            CsvMapper csvMapperValue = new CsvMapper();
            XSSFRow row = workSheet.getRow(i);
            csvMapperValue.setSourceCurrency(row.getCell(0).getStringCellValue());
            csvMapperValue.setTargetCurrency(row.getCell(1).getStringCellValue());
            csvMapperValue.setRate(row.getCell(2).getNumericCellValue());
            csvMapperValue.setxColumn(row.getCell(3).getNumericCellValue());
            csvMapperList.add(csvMapperValue);

        }

        return csvMapperList;

    }
}
