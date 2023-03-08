import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.Optional.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class TestMovieNowPlaying {

    //SetURL
    String endpoint = "https://api.themoviedb.org/3/movie/nowplaying";

    //SetQueryparam
    String apiKey = "7bd02e3ea9447c68052a48099abbb44a";
    String language = "en-US";
    int page = 1;

    @Test
    public void MovieNowPlaying() {
        Response response = RestAssured.get(endpoint);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.header("content-type"));
        Assert.assertEquals(response.getStatusCode(), 401);

//    @Test
//    public void getnowplayingmovies(){
//        given()
//                .queryParam("api_key", apiKey)
//                .queryParam("language", language)
//                .queryParam("page", page)
//                .when()
//                .get(endpoint)
//                .then()
//                .statusCode(404);

    }



}
