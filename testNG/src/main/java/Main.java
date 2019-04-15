
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> arrayPhone = new ArrayList<>();
    private static ArrayList<String> arrayEmail = new ArrayList<>();
    private static ArrayList<String> arrayEmail1 = new ArrayList<>();
    private static ArrayList<String> allowedPermissions = new ArrayList<>();

    public static void main(String[] args) throws UnknownHostException {
        MongoConnectMorphia mongoConnect = new MongoConnectMorphia();
        //System.out.println(mongoConnect.getDataStore("stage-platform").getCollection(Client.class));
        mongoConnect.morphyaConnect();
        System.out.println(mongoConnect.getMongoClient("5c97dccecbc5371e9dc3f70c").get_id());
        //   DAO dao = new MongoConnectMorphia();


        DefaultLocation coordinats = new DefaultLocation();
        DefaultLocation client1Location = new DefaultLocation("Point", "by", coordinats.getCoordinates());
        Client client0 = new Client("1Gosha11222A", "Got", client1Location, getArrayPhone(), getArrayEmail(), getAllowedPermissions());
        Client clientCteated = Request.createClient(client0);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11" + Request.getClientById(clientCteated.get_id()));

/*
        Request request = new Request();
//       DefaultLocation.setCoordinates();
        DefaultLocation coordinats = new DefaultLocation();
        DefaultLocation client1Location = new DefaultLocation("Point", "by", coordinats.getCoordinates());
        Client client0 = new Client("1Gosha11222A", "Got", client1Location, getArrayPhone(), getArrayEmail(), getAllowedPermissions());
        Client client1 = new Client("Goshaaa3112212", "Got", client1Location, getArrayPhone(), getArrayEmail(), getAllowedPermissions());
        Client client2 = new Client("Gosha3332", "Got", client1Location, getArrayPhone(), getArrayEmail1(), getAllowedPermissions());

        System.out.println("******GET TOKEN");
        System.out.println(request.getToken());

        System.out.println("******GET CLIENT BY ID");
        System.out.println(request.getClientById("5c97dccecbc5371e9dc3f70c"));

        System.out.println("*********CREATE CLIENT");
//        Client createdClient = request.createClient(client0);
//        System.out.println(createdClient.getName());


        System.out.println("******* UPDATE CLIENT");
//        Client updatedClient = request.updateClient(client2, "591d6aebfc66aa76e77b378d");
//        System.out.println(updatedClient.getName());

        System.out.println("******* DELETE CLIENT");
//        System.out.println(request.deleteClient("5c97dccecbc5371e9dc3f70c"));



        */


        //request.postRequestExampleTest1();
//        Simple simple = new Simple();
        //  simple.putRequestExampleTest();

        // AppsDeveloperBlog a = new AppsDeveloperBlog();
        // a.validate_response_headers_test();

    }

    public static ArrayList<String> getArrayPhone() {
        arrayPhone.clear();
        arrayPhone.add("123123");
        return arrayPhone;
    }

    public static ArrayList<String> getArrayEmail() {
        arrayEmail.clear();
        arrayEmail.add("1tesetd21224y16a@jtk.ru");
        return arrayEmail;
    }

    public static ArrayList<String> getArrayEmail1() {
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
