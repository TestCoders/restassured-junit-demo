import Interfaces.Users;
import io.restassured.response.Response;
import org.junit.*;
import templates.NewUser;
import templates.responses.AllUsers;
import templates.responses.Error;

public class RestAssuredTests {

    private String username = "testerdetest";
    private String role = "admin";
    private String password = "Welcome123";

    @Before
    public void beforeTest() {
        // Zorg er voor dat het test object draait.

        Properties.loadProperties();
    }

    @Test
    public void iAskForAListWithUsers() {
        // Get list with all users
        Response response = Users.get(System.getProperty("baseUrl"));
        // Assert list of all users is correct
        Assert.assertEquals("Response is not correct.", AllUsers.expectedResult(), response.getBody().print());
    }

    @Test
    public void iAddAUser() {
        // Add new user
        Response response_1 = Users.post(System.getProperty("baseUrl"), NewUser.user(username, role, password, true));
        // Assert the response
        Assert.assertEquals("Response is not correct.", templates.responses.NewUser.expectedResult(role, true, username, "3"), response_1.getBody().print());
        // Assert user is was added
        Response response_2 = Users.get(System.getProperty("baseUrl"), "3");
        Assert.assertEquals("Response is not correct.", templates.responses.NewUser.expectedResult(role, true, username, "3"), response_2.getBody().print());
    }

    @Test
    @Ignore("not implemented yet")
    public void iDeleteUser() {
        String id = "3";

        // Delete
        Response response_1 = Users.delete(System.getProperty("baseUrl"), id);
        // Assert user is not deleted because it is still active
        Assert.assertEquals("Response is not correct.", Error.userStillActive(id), response_1.getBody().print());

        // Make user inactive
        Users.put(System.getProperty("baseUrl"), id, true);
        // Delete
        Response response_2 = Users.delete(System.getProperty("baseUrl"), id);

        // Assert user is deleted
        Assert.assertEquals("Response is not correct.", "success", response_2.getBody().print());
        Response response_3 = Users.get(System.getProperty("baseUrl"));
        Assert.assertEquals("Response is not correct.", AllUsers.expectedResult(), response_3.getBody().print());
    }

    @After
    public void afterTest() {
    }

}
