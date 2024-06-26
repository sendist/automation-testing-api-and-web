package stepdefinitions.APITesting;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class GetUserSteps {
    private Response response;
    private RequestSpecification request;

    @Given("Set Valid Id")
    public void set_valid_id() {
            this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", "6637c63610f9d46c3543f735");
    }

    @Given("Set Valid Id and Invalid App-Id")
    public void set_valid_id_and_invalid_app_id() {
            this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", "6637c63610f9d46c3543f735")
                .header("app-id", "60d0fe4f5311236168a109ca");
    }

    @Given("Set Valid Id and Valid App-Id")
    public void set_valid_id_and_valid_app_id() {
            this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", "6637c63610f9d46c3543f735")
                .header("app-id", "6627132f6cae03d7fddee77b");
    }

    @Given("Set Invalid Id and Valid App-Id")
    public void set_invalid_id_and_valid_app_id() {
            this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", "6637c63610f9d46c3543f725")
                .header("app-id", "6627132f6cae03d7fddee77b");
    }

    @When("hit GET user by Id")
    public void hit_get_user_by_id_API() {
        response = this.request
                .when()
                .get("/user/{id}");
    }

    @Then("User get response error field containing message \"APP_ID_MISSING\"")
    public void user_get_response_error_field_containing_message_app_id_missing() {
        response.then()
                .assertThat()
                .body("error", equalTo("APP_ID_MISSING"));
    }

    @Then("User get response error field containing message \"APP_ID_NOT_EXIST\"")
    public void user_get_response_error_field_containing_message_app_id_not_exist() {
        response.then()
                .assertThat()
                .body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Then("User get response body with id field equals")
    public void user_get_response_body_with_id_field_equals() {
        response.then()
                .assertThat()
                .body("id", equalTo("6637c63610f9d46c3543f735"));
    }

    @Then("User get response error field containing message \"RESOURCE_NOT_FOUND\"")
    public void user_get_response_error_field_containing_message_resource_not_found() {
        response.then()
                .assertThat()
                .body("error", equalTo("RESOURCE_NOT_FOUND"));
    }

    @Then("User get status code Forbidden")
    public void user_get_status_code_forbidden() {
        response.then()
                .assertThat()
                .statusCode(403);
    }

    @Then("User get status code Ok")
    public void user_get_status_code_ok() {
        response.then()
                .assertThat()
                .statusCode(200);
    }
    
    @Then("User get status code Not Found")
    public void user_get_status_code_not_found() {
        response.then()
                .assertThat()
                .statusCode(404);
    }

}
