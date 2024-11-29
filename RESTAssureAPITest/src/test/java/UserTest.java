import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void UserCreate() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String bodyPayLoad = "{\n" +
                "  \"id\": 23422353,\n" +
                "  \"username\": \"SinanKerem12\",\n" +
                "  \"firstName\": \"Sinann\",\n" +
                "  \"lastName\": \"Doğann\",\n" +
                "  \"email\": \"mystic.kerem12@gmail.com\",\n" +
                "  \"password\": \"Qweasd1.\",\n" +
                "  \"phone\": \"05445535353\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .post("/v2/user")
                .then()
                .statusCode(200);


    }

    @Test
    public void GetUserInfo() {
        UserCreate();
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .get("/v2/user/SinanKerem12")
                .then()
                .statusCode(200);
    }

    @Test
    public void UserUpdate() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String bodyPayLoad = "{\n" +
                "  \"id\": 23422353,\n" +
                "  \"username\": \"SinanKerem1243\",\n" +
                "  \"firstName\": \"Sinan\",\n" +
                "  \"lastName\": \"Doğan\",\n" +
                "  \"email\": \"mystic.kerem@gmail.com\",\n" +
                "  \"password\": \"Qweasd1.\",\n" +
                "  \"phone\": \"05445535353\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .put("/v2/user/SinanKerem12")
                .then()
                .statusCode(200);
    }

    @Test
    public void UserDelete() {
        UserCreate();
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .delete("/v2/user/SinanKerem12")
                .then()
                .statusCode(200);
    }
}
