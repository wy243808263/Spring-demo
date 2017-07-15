package com.mongo;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDBUtil {

	private static final Logger LOGGER = Logger.getLogger(MongoDBUtil.class);

	public static void main(String[] args) {
		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("mydb");
			DBCollection userCol = db.getCollection("users");
			/*
			for(int i=1;i<5;i++){
				userCol.insert(new BasicDBObject()
						.append("name", "name"+i)
						.append("pass", "pass"+i)
						.append("Email", "email"+i+"@mail.com")
						.sappend("like", new ArrayList<String>(0)));
			}
			*/
			DBCursor cursor = userCol.find();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} catch (UnknownHostException e) {
			LOGGER.error("Can not connect to MongoDB service." + e.toString());
		}
	}

}
