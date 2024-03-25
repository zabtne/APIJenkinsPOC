package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import Base.BaseAPITest;
import PojoClasses.DetailedProduct;
import Utils.JsonHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProductAPITest extends BaseAPITest {

    @Test
    public void testGetAllProducts() throws IOException {
  
    	Response response = RestAssured.given()
            .contentType(ContentType.JSON)
        .when()
            .get("/products");

        response.then()
            .statusCode(200)
            .contentType(ContentType.JSON);

        response.then()
            .body("$", Matchers.hasSize(Matchers.greaterThan(0)));

        assertTrue(JsonHelper.CompareStringToJsonFile(response.getBody().asString(), "Products.json"));
    }
    
    @Test
    public void testGetCertainProduct() throws JsonProcessingException
	{
    	DetailedProduct expectedProduct = new DetailedProduct(4643, "coffee","Starbucks Coffee Variety Pack, 100% Arabica","Starbucks",40.91, 14, true);
    	Response response = RestAssured.given()
	    .pathParam("productId", expectedProduct.getId())
	    .when()
	    .get("/products/{productId}");
    	
    	response.then()
	    .statusCode(200);
    	
    	DetailedProduct actualProduct = response.then()
	    .contentType(ContentType.JSON).extract().as(DetailedProduct.class);
    	
    	assertTrue(actualProduct.equals(expectedProduct));
	    
	}
}