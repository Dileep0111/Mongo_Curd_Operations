package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter DataBase name...");
        String dbName = sc.nextLine();
        MongoCollection<Document> collection = getCollection(dbName);

        while (true) {
            System.out.println("Enter 1 to 'INSERT_DATA'");
            System.out.println("Enter 2 to 'UPDATE_DATA'");
            System.out.println("Enter 3 to 'DELETE_DATA'");
            System.out.println("Enter 4 to 'READ_DATA'");
            System.out.println("Enter any other number to 'EXIT'");
            int num;
            if (sc.hasNext()) {
                num = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Thank you For visiting... See you again...");
                return;
            }

            switch (num) {
                case 1:
                    Insert.insert_data(collection, sc);
                    break;
                case 2:
                    Update.update_Data(collection, sc);
                    break;
                case 3:
                    Delete.delete_Data(collection, sc);
                    break;
                case 4:
                    Read.read_Data(collection);
                    break;
                default:
                    System.out.println("Exiting....");
                    return;

            }
        }
    }

    public static  MongoCollection<Document> getCollection(String dbName) {
        MongoClient mc = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mc.getDatabase(dbName);
        System.out.println(db.listCollectionNames());
        return  db.getCollection("First");
    }
}
