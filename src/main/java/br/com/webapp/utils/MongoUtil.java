package br.com.webapp.utils;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import br.com.webapp.domains.Enterprise;
import br.com.webapp.enums.StatusEnum;

public class MongoUtil {

	public static void main(String[] args) throws UnknownHostException {
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		
		DB db = mongo.getDB("webapp");
		
		DBCollection table = db.getCollection("user");
		BasicDBObject document = new BasicDBObject();
		document.put("cnpj", "100000000000");
		document.put("name", "UOL Diveo");
		//document.put("status", Enterprise.StatusEnum.);
		table.insert(document);
		
		Set<String> tables = db.getCollectionNames();
		
		for(String coll : tables){
			System.out.println(coll);
		}
	}
}
