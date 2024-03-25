package Base;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

public abstract class BaseAPITest {
    protected static final String BASE_URL = "https://simple-grocery-store-api.glitch.me";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}