package com.mogodbdemo;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class mogodbdemo1 {

    public static void main(String[] args) {
        try {
            // ??????¡À??? MongoDB ¡¤????¡Â
            MongoClient mongoClient = new MongoClient("192.168.0.106", 27017);

            // ????????????
            MongoDatabase database = mongoClient.getDatabase("cx_mcs");

            // ????????
            MongoCollection<Document> collection = database.getCollection("cms_page");
            System.out.println(collection);

            // ?????¨¦??
            MongoCursor<Document> cursor = collection.find().iterator();
            System.out.println(cursor);

            // ¡À¨¦?¨²?¨¢????
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());
            }

//            // ????????
//            Document document = new Document("name", "John")
//                    .append("age", 30)
//                    .append("city", "New York");
//            collection.insertOne(document);
//
//            // ?¨¹??????
//            collection.updateOne(new Document("name", "John"), new Document("$set", new Document("age", 35)));
//
//            // ????????
//            collection.deleteOne(new Document("name", "John"));

            // ??¡À?????
            mongoClient.close();

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
