package Interfaces;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;

public class Authentication {

    /**
     * Ongebruikte Authentication class waarin de Bearer-token wordt vastgesteld.
     *
     * Let op: dit is een voorbeeld class, wellicht werkt de oplossing waar je aan werkt iets anders!!
     *
     * De functie returned een goed opgemaakte Bearer-token.
     *
     * @param url baseUrl of the application
     */

    public static String getBearerToken(String url) {
        String bearerToken;

        Response bearer = given()
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .formParam("grant_type", "password")
                .formParam("client_id", "client-id")
                .formParam("username", System.getProperty("properties.username"))
                .formParam("password", System.getProperty("properties.password"))
                .when()
                .post(url + "url van de authentication endpoint");

        bearerToken = bearer.getBody().print();
        bearerToken = JsonPath.read(bearerToken, "$..access_token")
                .toString()
                .replace("[\"", "")
                .replace("\"]", "");

        return "Bearer " + bearerToken;
    }

}
