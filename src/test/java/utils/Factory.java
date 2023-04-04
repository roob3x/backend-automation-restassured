package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    Response response;

    public String key(String key) {
        return response.getBody().jsonPath().getString(key);
    }
    public List<String> keyList(String key){
        List<String> keys = new ArrayList<String>();
        keys = response.getBody().jsonPath().getList(key);
        return keys;
    }

    public Response getResponse() {
        return response;
    }

    public void get(String url, String endpoint) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(url)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        this.response = response;
    }

    public void getLogin(String url, String endpoint, String username, String password) {
        Response response = RestAssured
                .given()
                .param(username)
                .param(password)
                .contentType(ContentType.JSON)
                .baseUri(url)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        this.response = response;
    }

    public void post(String url, String endpoint,Object json) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(url)
                .when()
                .body(json)
                .post(endpoint)
                .then()
                .extract()
                .response();
        this.response = response;
    }

    public void delete(String url, String endpoint) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(url)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
        this.response = response;
    }
}
