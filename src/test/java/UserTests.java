import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserTests {

    @Test
    public void updateUserDetails()
    {
        Response response=given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion123151241 resident\"\n" +
                        "}")
                .put("https://reqres.in/api/users");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(),200);

    }
    @Test
    public void deleteUser()
    {
        Response response=given()
                .delete("https://reqres.in/api/users/2");
        Assert.assertEquals(response.statusCode(),204);
    }
    @Test
    public void checkForDelayedResponse()
    {
        Response response=given()
                .get("https://reqres.in/api/users?delay=1");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void checkForLoginUnsuccessful()
    {
       Response response= given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login");
       Assert.assertEquals(response.statusCode(),400);

    }

}
