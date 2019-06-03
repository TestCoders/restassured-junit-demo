package templates.responses;

public class Error {

    public static String userStillActive(String id) {
        return "{\"Error\":\"User: " + id + " cannot be deleted because the user is still active \"}";
    }

}
