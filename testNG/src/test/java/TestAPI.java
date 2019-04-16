import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.CLI;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.TestNGException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TestAPI {
    private static ArrayList<String> arrayPhone = new ArrayList<>();
    private static ArrayList<String> arrayEmail = new ArrayList<>();
    private static ArrayList<String> arrayEmail1 = new ArrayList<>();
    private static ArrayList<String> allowedPermissions = new ArrayList<>();

    private Request request = new Request();
    private MongoConnectMorphia mongoConnectMorphia = new MongoConnectMorphia();
    // private Client customClient = new Client("1Gosha11222A", "Got", client1Location, getArrayPhone(), getArrayEmail(), getAllowedPermissions());;
    private Client mongoClient;
    private static Client client0API;
    private static Client client1API;
    private static Client client2API;

    @BeforeClass
    public static void preparation() throws UnknownHostException {
        //  MongoConnectMorphia mongoConnect = new MongoConnectMorphia();
        //   mongoConnectMorphia.morphyaConnect();
        System.out.println("TOKEN in before TEST CLASS" + Request.getToken());
        MongoConnectMorphia.morphyaConnect();
        DefaultLocation coordinats = new DefaultLocation();
        DefaultLocation client1Location = new DefaultLocation("Point", "by", coordinats.getCoordinates());
        Client client0 = new Client("1Gosha111222222A", "Got", client1Location, getArrayPhone(), getArrayEmail(), getAllowedPermissions());
        Client client1 = new Client("Goshaaa3112212", "Got", client1Location, getArrayPhone(), getArrayEmail(), getAllowedPermissions());
        Client client2 = new Client("Gosha3332", "Got", client1Location, getArrayPhone(), getArrayEmail1(), getAllowedPermissions());
        Client client0API = Request.createClient(client0);
        Client client1API = Request.createClient(client1);
        Client client2API = Request.createClient(client2);
    }


    @Test
    public static void createClient()  {

            Assert.assertEquals(Request.createClient(client0API), MongoConnectMorphia.getMongoClient(client0API.get_id()));
    }

    @Test
    public void getClient() {

            Client customClient = request.getClientById(client0API.get_id());
            Client mongoClient = mongoConnectMorphia.getMongoClient(client0API.get_id());
            Assert.assertEquals(customClient, mongoClient);

    }

  /*  @Test
    public void createClient(Client client) throws Exception {
        Client customClient = request.createClient(client);
        Client gottedClient = request.getClientById(client.get_id());
        mongoClient = mongoConnectMorphia.getMongoClient(customClient.get_id());
        Assert.assertEquals(gottedClient, mongoClient);
    } */

    @Test
    public void updateClient() {
        Client customClient = request.updateClient(client1API, client1API.get_id());
        Client gottedClient = request.getClientById(client1API.get_id());
        mongoClient = mongoConnectMorphia.getMongoClient(customClient.get_id());
        Assert.assertEquals(gottedClient, mongoClient);
    }

    public static ArrayList<String> getArrayPhone() throws NullPointerException {
        arrayPhone.clear();
        arrayPhone.add("123123");
        return arrayPhone;
    }

    public static ArrayList<String> getArrayEmail() throws NullPointerException{
        arrayEmail.clear();
        arrayEmail.add("1teseted21224222y16a@jtk.ru");
        return arrayEmail;
    }

    public static ArrayList<String> getArrayEmail1() throws NullPointerException {
        arrayEmail1.clear();
        arrayEmail1.add("test6a@jk.ru");
        return arrayEmail1;
    }

    public static ArrayList<String> getAllowedPermissions() {
        allowedPermissions.clear();
        allowedPermissions.add("user:user:create:general");
        return allowedPermissions;
    }

}
