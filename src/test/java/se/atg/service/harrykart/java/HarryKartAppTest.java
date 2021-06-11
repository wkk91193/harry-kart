package se.atg.service.harrykart.java;

import com.eclipsesource.json.JsonObject;
import helpers.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.*;

import java.io.IOException;
import java.net.URI;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("java-test")
public class HarryKartAppTest {

    private final static URI harryKartApp = URI.create("http://localhost:8181/java/api/play");

    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Trying to GET instead of POST should return 405 Method not allowed")
    void useGetOnPostEndpointShouldNotBePossible() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get(harryKartApp);
        Assert.assertEquals(response.statusCode(),405);
    }

    @Test
    @DisplayName("Test rankings produced for happy path in order TIMETOBELUCKY, HERCULES BOKO,_CARGO DOOR")
    void testRankingForHappyPath() {
        try {

            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", ContentType.XML);
            httpRequest.body(Utils.generateStringFromResource("input_happy_path_TIMETOBELUCKY_HERCULES BOKO_CARGO DOOR.xml"))  ;

            Response response = httpRequest.post(harryKartApp);

            // Retrieve the body of the Response
            ResponseBody body = response.getBody();
            JsonObject responseJsonObject = Utils.parseJsonStringToJSONObject(body.asString());
            JsonObject actual = Utils.parseJsonStringToJSONObject(Utils.generateStringFromResource("output_happy_path_TIMETOBELUCKY_HERCULES BOKO_CARGO DOOR.json"));
            Assert.assertEquals(responseJsonObject,actual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test response for invalid xml")
    void testRankingForInvalidXML() {
        try {

            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", ContentType.XML);
            httpRequest.body(Utils.generateStringFromResource("input_invalid_xml.xml"))  ;

            Response response = httpRequest.post(harryKartApp);

            // Retrieve the body of the Response
            ResponseBody body = response.getBody();
            JsonObject responseJsonObject = Utils.parseJsonStringToJSONObject(body.asString());
            JsonObject actual = Utils.parseJsonStringToJSONObject(Utils.generateStringFromResource("output_invalid_xml.json"));
            Assert.assertEquals(responseJsonObject,actual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test response for invalid powerup")
    void testRankingForInvalidPowerup() {
        try {

            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", ContentType.XML);
            httpRequest.body(Utils.generateStringFromResource("input_invalid_number_powerups.xml"))  ;

            Response response = httpRequest.post(harryKartApp);

            // Retrieve the body of the Response
            ResponseBody body = response.getBody();
            JsonObject responseJsonObject = Utils.parseJsonStringToJSONObject(body.asString());
            JsonObject actual = Utils.parseJsonStringToJSONObject(Utils.generateStringFromResource("output_invalid_number_powerups.json"));
            Assert.assertEquals(responseJsonObject,actual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test response for invalid participantName")
    void testRankingForInvalidParticipantName() {
        try {

            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", ContentType.XML);
            httpRequest.body(Utils.generateStringFromResource("input_invalid_participant_name.xml"))  ;

            Response response = httpRequest.post(harryKartApp);

            // Retrieve the body of the Response
            ResponseBody body = response.getBody();
            JsonObject responseJsonObject = Utils.parseJsonStringToJSONObject(body.asString());
            JsonObject actual = Utils.parseJsonStringToJSONObject(Utils.generateStringFromResource("output_invalid_participant_name.json"));
            Assert.assertEquals(responseJsonObject,actual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    @DisplayName("Test response for invalid base speed")
    void testRankingForInvalidBaseSpeed() {
        try {

            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", ContentType.XML);
            httpRequest.body(Utils.generateStringFromResource("input_invalid_base_speed.xml"))  ;

            Response response = httpRequest.post(harryKartApp);

            // Retrieve the body of the Response
            ResponseBody body = response.getBody();
            JsonObject responseJsonObject = Utils.parseJsonStringToJSONObject(body.asString());
            JsonObject actual = Utils.parseJsonStringToJSONObject(Utils.generateStringFromResource("output_invalid_base_speed.json"));
            Assert.assertEquals(responseJsonObject,actual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
