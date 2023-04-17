package com.mogodbdemo;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class mogodbdemo1 {

    public static void main(String[] args) {
        try {
            // 连接到本地 MongoDB 服务器
            MongoClient mongoClient = new MongoClient("192.168.0.106", 27017);

            // 连接到数据库
            MongoDatabase database = mongoClient.getDatabase("cx_mcs");

            // 获取集合
            MongoCollection<Document> collection = database.getCollection("mycollection");
            System.out.println(collection.toString());

            // 插入文档
            Document document = new Document("name", "John")
                    .append("age", 30)
                    .append("city", "New York");
            collection.insertOne(document);

            // 更新文档
            collection.updateOne(new Document("name", "John"), new Document("$set", new Document("age", 35)));

            // 删除文档
            collection.deleteOne(new Document("name", "John"));

            // 关闭连接
            mongoClient.close();

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
