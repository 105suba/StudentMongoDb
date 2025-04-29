package com.mph.mongo;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Defines the connection string to MongoDB running on localhost:27017.
        //If MongoDB is remote, replace localhost with the remote server address.
		String uri="mongodb://localhost:27017";
		try(MongoClient mongoClient=MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("Student");
            MongoCollection<Document> collection = database.getCollection("studentdetails");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            Document doc = new Document("name", name)
                    .append("email", email)
                    .append("age", age);
            collection.insertOne(doc);
            System.out.println("User data stored successfully in MongoDB!");
            scanner.close();
		}
		catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }

	}

}
