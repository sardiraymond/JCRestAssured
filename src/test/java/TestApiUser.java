import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApiUser {

    String endpoint = "https://reqres.in/api/users?page=2";


    @Test
    public void testGetListUser() {
        Response response = RestAssured.get(endpoint);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.header("content-type"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testIdOne() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }

    @Test
    public void testIdTwo() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8));


    }
}
