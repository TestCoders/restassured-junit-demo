package Interfaces;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;

import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;

public class Users {

    public static Response get(String url) {
        return given()
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(url);
    }

    public static Response get(String url, String id) {
        return given()
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(url + "/" + id);
    }

    public static Response post(String url, String body) {
        return given()
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .body(body)
                .when()
                .post(url);
    }

    public static Response put(String url,String id, boolean active) {
        return given()
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .body("{\"active\": " + active + "}")
                .when()
                .put(url + "/" + id);
    }

    public static Response delete(String url, String id) {
        return given()
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .when()
                .delete(url + "/" + id);
    }

}
