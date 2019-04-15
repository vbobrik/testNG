

import com.mongodb.*;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sun.xml.fastinfoset.util.CharArray;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.query.Query;
//import main.java.Client;
import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.*;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnectMorphia implements DAO {
    private static String login = "platform";
    private static String pass = "SBUhX8Kmpcr7T";
    private static String dbName = "stage-platform";
    private static String host = "mongodb://platform:SBUhX8Kmpcr7T@10.10.0.27:27017,10.10.0.26:27017,10.10.0.28:27017";
    private static Datastore datastore;
    //  private List<Client> clientslist;

    public static void morphyaConnect() throws UnknownHostException {

        final Morphia morphia = new Morphia();
        datastore = morphia.createDatastore(new MongoClient(new MongoClientURI(host)), dbName);
        morphia.map(Client.class);
        morphia.mapPackage("main.com.java");
        System.out.println("-------******-------" + datastore.getCount(Client.class));
        datastore.getCollection(Client.class);

        Client client = datastore.find(Client.class).field("_id").equal("5c97dccecbc5371e9dc3f70c").get();
        System.out.println("----*****-----custom name is " + client.getName());
        //    Query<Client> query = datastore.createQuery(Client.class);
        //    List<Client> clientslist = query.asList();
        //    System.out.println(clientslist.toString());
        //   datastore.find(Client.class).field("name");
 /*       datastore.find(Client.class).forEach((clientEach)->
                System.out.println("------!!!!!!!!------" + clientEach.getName()));
*/
        // System.out.println("------!!!!!!!!------" + datastore.find(Client.class).forEach());
    }

    public static Client getMongoClient(String clientId) {
        return datastore.find(Client.class).field("_id").equal(clientId).get();
    }

    public List<Client> getAll() {
        List<Client> allClients = new ArrayList<>();
        for(Client client: datastore.find(Client.class)) {
            allClients.add(client);
        }
        //   List<Client> o = datastore.find(Client.class);

        return allClients;
    }

    //  CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
    // fromProviders(PojoCodecProvider.builder().automatic(true).build()));


    public void connectionDB() {
     /*   Morphia morphia = new Morphia;
        MongoClient mongoConnect = new MongoClient();
        Datastore datastore = morphia.createDatastore(mongoConnect, "stage-platform");

        morphia.map(Client.class);
        datastore.find(Client.class).field("users").toString(); */


//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .codecRegistry(pojoCodecRegistry)
//                .build();
//        MongoClient mongoClient = MongoClients.create(settings);
//        MongoDatabase database = database.withCodecRegistry(pojoCodecRegistry);
//        MongoCollection<Client> collection = database.getCollection("clients", Client.class);
//        collection = collection.withCodecRegistry(pojoCodecRegistry);


    }

    public Datastore getDataStore(String dbName) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://platform:SBUhX8Kmpcr7T@10.10.0.27:27017,10.10.0.26:27017,10.10.0.28:27017"));
        MongoClient mongoClient1 = new MongoClient(new MongoClientURI(" mongodb://[platform:SBUhX8Kmpcr7T@]" +
                "10.10.0.27[:27017]" +
                "[,10.10.0.26[:27017],10.10.0.28[:27017]]" +
                "[/[stage-platform][?options]]"));
        return new Morphia().map(Client.class).createDatastore(mongoClient, dbName);


    }
}
