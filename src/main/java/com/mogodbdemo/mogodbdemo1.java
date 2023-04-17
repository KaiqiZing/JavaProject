package com.mogodbdemo;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class mogodbdemo1 {

    public static void main(String[] args) {
        try {
            // ���ӵ����� MongoDB ������
            MongoClient mongoClient = new MongoClient("192.168.0.106", 27017);

            // ���ӵ����ݿ�
            MongoDatabase database = mongoClient.getDatabase("cx_mcs");

            // ��ȡ����
            MongoCollection<Document> collection = database.getCollection("mycollection");
            System.out.println(collection.toString());

            // �����ĵ�
            Document document = new Document("name", "John")
                    .append("age", 30)
                    .append("city", "New York");
            collection.insertOne(document);

            // �����ĵ�
            collection.updateOne(new Document("name", "John"), new Document("$set", new Document("age", 35)));

            // ɾ���ĵ�
            collection.deleteOne(new Document("name", "John"));

            // �ر�����
            mongoClient.close();

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
