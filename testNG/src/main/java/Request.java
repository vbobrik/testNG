import static io.restassured.RestAssured.*;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {

    private static String userName = "v.bobrik@kino-mo.com";
    private static String password = "NIKita-1995.@";
    private static String BASE_URI = "https://stage-platform.kino-mo.com";
    private static String BASE_PATH = "/api/admin/0";

    public static String getToken() {
        Response token = given().contentType("application/json")
                .baseUri(BASE_URI + BASE_PATH)
                .basePath("/session")
                .get();

        if (token.jsonPath().getInt("status") == 200) {
            return token.jsonPath().getString("message.sessionToken");
        } else {
            JsonObject credentials = new JsonObject();
            credentials.addProperty("password", password);
            credentials.addProperty("username", userName);

            Response response = given()
                    .contentType("application/json")
                    .body(credentials)
                    .put(BASE_URI + BASE_PATH + "/session");
            return response.jsonPath().getString("message.sessionToken");
        }
    }

    public static Client getClientById(String clientId) {

        return given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
                .get(BASE_URI + BASE_PATH + "/client/" + clientId)
                .jsonPath().getObject("message", Client.class);
    }

    public static Client getClientByIdOverride(Client client) {

        return given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
                .get(BASE_URI + BASE_PATH + "/client/" + client.get_id())
                .jsonPath().getObject("message", Client.class);
    }

    public static Client createClient(Client client) {

        Response response = given()
                .header("km-auth", getToken())
                .contentType("application/json")
                .body(client)
                .put(BASE_URI + BASE_PATH + "/client");
//        Client eee = new Client();
//
//         eee = (Client) response.getBody().jsonPath().getObject("message", Client.class);
//
//        client.set_id(eee.get_id());
        return response.jsonPath().getObject("message", Client.class);

    }

    public static Client updateClient(Client clientForUpdate, String clientId) {
        Response response = given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
                .body(clientForUpdate)
                .post(BASE_URI + BASE_PATH + "/client/" + clientId);

        return clientForUpdate;
    }

    public String deleteClient(String id) {
        return given()
                .header("km-auth", getToken())
                .header("Content-Type", "application/json")
                .delete(BASE_URI + BASE_PATH + "/client/" + id)
                .getBody().asString();
    }

    public static JSONObject jsonClientBody() {
        Client client = new Client();

        JSONObject jsonObject1 = new JSONObject()
                .put("phone", client.getPhone())
                .put("name", client.getName())
                .put("legalName", client.getLegalName())
                .put("email", client.getEmail())
                .put("allowedPermissions", "[\"user:user:create:general\"]")
                .put("defaultLocation", "{type: \"Point\", coordinates: [53.90453979999999, 27.561524400000053], countryCode: \"by\"}");

        return jsonObject1;
    }

    //  .jsonPath().getBode.getObject("message", Client.class);
//                .getBody().jsonPath().getObject("message", Client.class);
//                .jsonPath().getObject("message", Client.class);
//                .then()
//                .assertThat()
//                .log().all()
//                .statusCode(200)
//                .extract().body().toString();
//        return response.getBody().asString();


    //return response.getBody().as(Client.class);
    //Client message = response.getBody().jsonPath().getJsonObject("message");

    //return unknown;
}
