package org.example;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.io.FileOutputStream;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class Insert {
    public static void insert_data(MongoCollection<Document> collection , Scanner sc){
        System.out.println("Enter Employee ID:");
        int eId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Employee Name:");
        String eName = sc.nextLine();


        System.out.println("Enter Employee Salary:");
        double eSal = sc.nextDouble();

        Document doc = new Document("Employee_Id",eId).append("Employee_Name",eName).append("Employee_Salary",eSal);
        collection.insertOne(doc);
        System.out.println("Employee Data inserted...");

        saveToExcel(eId,eName,eSal);
    }

    public static void saveToExcel(int eId,String eNamme,double eSal) {
        Workbook wb = new XSSFWorkbook();
        Sheet s = wb.createSheet();

        Row header = s.createRow(0);
        header.createCell(0).setCellValue("Employee_Id");
        header.createCell(1).setCellValue("Employee_Name");
        header.createCell(2).setCellValue("Employee_salary");


        Row dataRow = s.createRow(1);
        dataRow.createCell(0).setCellValue(eId);
        dataRow.createCell(1).setCellValue(eNamme);
        dataRow.createCell(2).setCellValue(eSal);

        try(FileOutputStream fo = new FileOutputStream("Employees.xlsx")) {
            wb.write(fo);
            wb.close();
            System.out.println("data inserted to the excel successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
