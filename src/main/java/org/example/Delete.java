package org.example;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import  java.util.*;
public class Delete {
    public static  void delete_Data(MongoCollection<Document> collection, Scanner sc) {
        System.out.println("Enter Employee ID to Delete that Employee");
        int eId = sc.nextInt();

        collection.deleteOne(Filters.eq("Employee_Id",eId));
        System.out.println("Employee with a id: " + eId + " deleted successfully..");

//        deleteByExcel(eId);
    }

//    public static void deleteByExcel(int eId) {
//        try(FileInputStream fis = new FileInputStream("Employees.xlsx")) {
//            Workbook wb = new XSSFWorkbook(fis);
//            Sheet s = wb.getSheetAt(0);
//            Iterator<Row> rowIterator = s.iterator();
//            boolean f = false;
//
//            while (rowIterator.hasNext()) {
//                Row r  = rowIterator.next();
//                Cell c = r.getCell(0);
//                if(c.getCellType() == CellType.NUMERIC && (int) c.getNumericCellValue() == eId) {
//                    rowIterator.remove();
//                    f = true;
//                    System.out.println("Employee with id: " + eId + " removed from excel...");
//                    break;
//                }
//            }
//
//            if (!f) {
//                System.out.println("Employee with ID: " + eId + " not found in Excel file.");
//            }
//
//            try (FileOutputStream outFile = new FileOutputStream("employees.xlsx")) {
//                wb.write(outFile);
//                wb.close();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}