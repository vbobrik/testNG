

import com.google.gson.JsonObject;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

@Entity("clients")
public class Client {
    @Id()
    private static String _id;
    private static String name;
    private static String legalName;
    //    private String defaultLocation;
    private static ArrayList<String> allowedPermissions;
    private static ArrayList<String> phone;
    private static ArrayList<String> email;
    private static DefaultLocation defaultLocation;

    //   private DefaultLocation location = {type: "Point", coordinates: [53.90453979999999, 27.561524400000053], countryCode: "by"};
// "allowedPermissions": ["user:user:create:general"]
    public Client(String name, String legalName, DefaultLocation defaultLocation, ArrayList<String> phone, ArrayList<String> email, ArrayList<String> allowedPermissions) {
        this.name = name;
        this.legalName = legalName;
        this.defaultLocation = defaultLocation;
        this.phone = phone;
        this.email = email;
        this.allowedPermissions = allowedPermissions;
//        JsonObject body = new JsonObject();
//        body.addProperty("name", name);
//        body.addProperty("legalName", legalName);
//        body.addProperty("defaultLocation", defaultLocation);
//        body.addProperty("phone", phone);
//        body.addProperty("email", email);
    }

    public Client() {
    }

    public static String get_id() {
        return _id;
    }

    public static void set_id(String _id) {
        Client._id = _id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Client.name = name;
    }

    public static String getLegalName() {
        return legalName;
    }

    public static void setLegalName(String legalName) {
        Client.legalName = legalName;
    }

    public static ArrayList<String> getAllowedPermissions() {
        return allowedPermissions;
    }

    public static void setAllowedPermissions(ArrayList<String> allowedPermissions) {
        Client.allowedPermissions = allowedPermissions;
    }

    public static ArrayList<String> getPhone() {
        return phone;
    }

    public static void setPhone(ArrayList<String> phone) {
        Client.phone = phone;
    }

    public static ArrayList<String> getEmail() {
        return email;
    }

    public static void setEmail(ArrayList<String> email) {
        Client.email = email;
    }

    public static DefaultLocation getDefaultLocation() {
        return defaultLocation;
    }

    public static void setDefaultLocation(DefaultLocation defaultLocation) {
        Client.defaultLocation = defaultLocation;
    }

    @Override
    public String toString() {
        return "Client{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", legalName='" + legalName + '\'' +
                ", allowedPermissions=" + allowedPermissions +
                ", phone=" + phone +
                ", email=" + email +
                ", defaultLocation=" + defaultLocation +
                '}';
    }

  /*  @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Client) {
            Client aClient = (Client) object;
            if (get_id() == aClient.get_id() & getName() == aClient.getName() & getEmail() == aClient.getEmail() &
                    getLegalName() == aClient.getLegalName() & getPhone() == aClient.getPhone()
                    & getAllowedPermissions() == aClient.getAllowedPermissions() & getDefaultLocation() == aClient.getDefaultLocation()) {
                return true;
            }
        }
        return false;
    }
    */
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(get_id(), client.get_id()) &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getLegalName(), client.getLegalName()) &&
                Objects.equals(getAllowedPermissions(), client.getAllowedPermissions()) &&
                Objects.equals(getPhone(), client.getPhone()) &&
                Objects.equals(getEmail(), client.getEmail()) &&
                Objects.equals(getDefaultLocation(), client.getDefaultLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getName(), getLegalName(), getAllowedPermissions(), getPhone(), getEmail(), getDefaultLocation());
    }
    */
}
