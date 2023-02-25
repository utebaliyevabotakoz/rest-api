import lombok.LombokUserData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static spec.Specs.request;
import static spec.Specs.response200;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LombokGroovy {

    @Test
    void singleUserWithLombokModel() {
        // @formatter:off
        LombokUserData data = given()
                .spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .spec(response200)
                .log().body()
                .extract().as(LombokUserData.class);
        // @formatter:on
        assertEquals(12, data.getData().getTotal());
    }


    @Test
    public void loginTestUsingGroovy() {
        // @formatter:off
        String data = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.name =~/.*?eus/}.name.flatten()",
                        hasItem("morpheus"));
        // @formatter:on
    }


}
