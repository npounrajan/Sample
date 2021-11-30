package ObjectRepository;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;


public class APIPage {

    public Response postMethodAPI(String url, String path, String postParam) {
        RestAssured.baseURI = url;
        Response response;
        File requestBody = new File(path);
        response = RestAssured.given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(postParam);
        return response;
    }

    public Response getMethodAPI(String url, String param) {
        RestAssured.baseURI = url;
        Response response;
        response = RestAssured.given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(param);
        return response;
    }
    public Response deleteMethodAPI(String url, String param) {
        RestAssured.baseURI = url;
        Response response;
        response = RestAssured.given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(param);
        return response;
    }

    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public int getCreatedRecordId(Response response) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("data.id");
    }

    public String getStatusMessage(Response response) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("status");
    }

    public String getDeleteConfirmation(Response response){
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get("message");
    }

}
