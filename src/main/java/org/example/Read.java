package org.example;
import  com.mongodb.client.*;
import org.bson.Document;
import org.apache.poi.ss.usermodel.*;
import  org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;


public class Read {
    public static void read_Data(MongoCollection<Document> collection) {
//        FindIterable fc = collection.find();
//        FindIterable<Document> docs = collection.find();
//        for (Document doc : docs) {
//            System.out.println(doc.toJson());
//        }
        readFromExel();
    }

    public static  void readFromExel(){
        try(FileInputStream fis = new FileInputStream("Employees.xlsx")) {
            Workbook wb = new XSSFWorkbook(fis);
            Sheet s = wb.getSheetAt(0);

            Row headerRow = s.getRow(0);
            int totCol = headerRow.getLastCellNum();
            for(int i = 1;i<totCol;i++) {
                Row curRow = s.getRow(i);
                if(curRow == null) continue;
                for(int j = 0;j<curRow.getLastCellNum();j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell dataCell = curRow.getCell(j);

                    String hcVal = headerCell.getStringCellValue();
                    String dcValue= "";

                    if(dataCell != null) {
                        switch (dataCell.getCellType()) {
                            case STRING:
                                dcVal = dataCell.getStringCellValue();
                                break;
                            case NUMERIC:
                                dcVal = String.valueOf(dataCell.getNumericCellValue());
                                break;
                            default:
                                dcVal = "";
                        }
                    }
                    System.out.println(hcVal + ": " + dcVal);
                }
                System.out.println("_____");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
