import io.restassured.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApiCRUD {

    @Test
    public void testCreateUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name","john");
        requestBody.put("Job","QA");
        System.out.println(requestBody.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();

    }

}
