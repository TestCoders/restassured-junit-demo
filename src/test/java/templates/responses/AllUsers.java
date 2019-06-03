package templates.responses;

public class AllUsers {

    public static String expectedResult() {
        return "{\"allUsers\":[{\"role\":\"admin\",\"active\":true,\"username\":\"testadmin\",\"id\":1},{\"role\":\"user\",\"active\":true,\"username\":\"testuser\",\"id\":2}]}";
    }
}
