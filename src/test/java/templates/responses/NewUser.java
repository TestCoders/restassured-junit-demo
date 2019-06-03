package templates.responses;

public class NewUser {

    public static String expectedResult(String role, boolean active, String username, String id) {
        return "{\"role\":\"" + role + "\",\"active\":" + active + ",\"username\":\"" + username + "\",\"id\":" + id + "}";
    }

}
