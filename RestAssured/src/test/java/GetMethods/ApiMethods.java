package GetMethods;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class ApiMethods {
	
	String token;
	String getProfile;
	String newProfile;
	String accessToken;
	///Using HashMap
	
    @Test(priority=1)
	void CreatingUser() 	
	{
    	
    	HashMap data = new HashMap();
    			data.put("phoneNumber","+966909606303");
    	        data.put("register", false);
    	        data.put("userType", "customer");
    	
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		
			.post("https://cms-staging.carhubapp.com/api/v2/auth/register")
		
		.then()
		
			.statusCode(200)
			.body("message", equalTo ("auth.otpSentSuccessfully"))
			.log().all();
		
	}
    
    
    @Test(priority=2)
   	void GetUsers() 	
   	{
       	
       	JSONObject data = new JSONObject();
       			data.put("phoneNumber","+966909606303");
       	        data.put("register", false);
       	        data.put("userType", "customer");
       	
   		given()
   		.contentType("application/json")
   		.body(data.toString())
   		
   		
   		.when()
   		
   			.post("https://cms-staging.carhubapp.com/api/v2/auth/register")
   		
   		.then()
   		
   			.body("message", equalTo ("auth.otpSentSuccessfully"))
   		
   			.statusCode(200)	
   			.log().all();
   		
   	}
    
    @Test(priority=3)
    void LoginUser()
    {
    	HashMap data = new HashMap();
		data.put("language","en");
        data.put("password", "29293");
        data.put("userType", "customer");
        data.put("username", "+966909606303");
    	
        accessToken=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		
			.post("https://cms-staging.carhubapp.com/api/auth/login")
			
			 .jsonPath().getString("accessToken");
        	
        	String tokenvalue = accessToken;
        	System.out.println("Token is " + tokenvalue);
			
		
		//.then()
		
			//.statusCode(200)
			//.log().all();
    	
    	
    }
    
    
    @Test(priority=4)
   void GetProfile()
   {
    	
    	
    	HashMap getProfile = new HashMap();
    	getProfile.put("Authorization", accessToken);
    	  
    	newProfile=given()
    				.contentType("application/json")
    				.body(getProfile)
    				
    	.when()
    			
    		.get("https://cms-staging.carhubapp.com/api/profile")	
    		.jsonPath().getString("accessToken");
    	
    	//String Profile = newProfile;
    	System.out.println("Profile data " + newProfile);
    	
   
    }
    

    
    @Test(priority=5)
    void LogoutUser() {
    	
    	HashMap datalogout = new HashMap();
    	datalogout.put("Authorization", accessToken);
    	  
    	accessToken=given()
    				.contentType("application/json")
    				.body(datalogout)
    				
    	.when()
    			
    		.get("https://cms-staging.carhubapp.com/api/auth/logout")	
    		.jsonPath().getString("accessToken");
    	
    	//https://cms-staging.carhubapp.com/api/web/car/add
   } 
    
}
