package templates;

public class NewUser {

    public static String user(String username, String role, String password, boolean active) {
        return "{\n" +
                "  \"userName\": \"" + username + "\",\n" +
                "  \"role\": \"" + role + "\",\n" +
                "  \"passWord\": \"" + password + "\",\n" +
                "  \"active\": " + active + "\n" +
                "}";
    }

}
