import lombok.UsersResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static spec.Specs.request;
import static spec.Specs.response200;

public class LombokGroovyTest {

    @Test
    void checkUsersCountTest() {
        UsersResponseDto responseDto = given().spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .spec(response200)
                .log().body()
                .extract().as(UsersResponseDto.class);

        Assertions.assertEquals(12, responseDto.getTotal());
        Assertions.assertEquals(6, responseDto.getPerPage());
        Assertions.assertEquals(6, responseDto.getUsers().size());
    }

    @Test
    void checkContainsNeededUserTest() {
        String expectedUserEmail = "lindsay.ferguson@reqres.in";
        given().spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?reqres.in/}.email.flatten()",
                        hasItem(expectedUserEmail));
    }

}
