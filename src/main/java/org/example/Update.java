package org.example;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.*;

public class Update {
    public static void update_Data(MongoCollection<Document> collection, Scanner sc) {
        System.out.println("Enter Employee ID to Update the Employee Salary...");
        int eId = sc.nextInt();

        System.out.println("Enter new salary for the Employee " + eId);
        double nSal = sc.nextDouble();

        collection.updateOne(Filters.eq("Employee_Id",eId), Updates.set("Employee_Salary",nSal));
        System.out.println("Salary of the Employee " + eId + " Updated Successfully");
    }
}
