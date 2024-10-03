package GetMethods;

import java.util.HashMap;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyExtractionOptions;

public class PostCalls {
	String accessToken;
	
	public static HashMap map = new HashMap(); 
	
	
	public void postdata() {
		map.put("brand",RestUtils.BrandName());
		map.put("brand",RestUtils.ModelYear());
		map.put("brand",RestUtils.Odometer());
		map.put("brand",RestUtils.OwnerName());
		map.put("brand",RestUtils.PlateID());
		map.put("brand",RestUtils.Product());
		
		RestAssured.baseURI= "https://cms-staging.carhubapp.com/api/web/car";
		RestAssured.basePath= "/add";
		
	}

public void testPost() {
		
	accessToken=((ResponseBodyExtractionOptions) given()
		.contentType("application/json")
		.body(map))
		.jsonPath().getString("accessToken");
    	
    	String tokenvalue = accessToken;
    	System.out.println("Token is " + tokenvalue);
		
		
		
		
		//.then()
	}
}
