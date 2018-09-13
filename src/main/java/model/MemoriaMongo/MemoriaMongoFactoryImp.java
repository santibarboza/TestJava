package model.MemoriaMongo;
import model.RepresentacionMemoria.Memoria;
import com.mongodb.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import model.RepresentacionMemoria.*;
import model.Mapeo.*;
 
import org.bson.Document;

public class MemoriaMongoFactoryImp{
	public MemoriaMongoFactoryImp(){}
	public MemoriaMongo iniciarMemoria(Memoria Memoria, String id){
		String Mongo_URI="mongodb://ocuns:ocuns22@ds141401.mlab.com:41401/ocuns";
  		MongoClient mongoClient = new MongoClient(new MongoClientURI(Mongo_URI));
  		DB database = mongoClient.getDB("ocuns");
	 	//System.out.println("Name: "+database.getName() );
		DBCollection collection= database.getCollection("memorias");
		//System.out.println("Count: "+collection.count());
		return new MemoriaMongoImp(memoria,collection,id);
	}
}