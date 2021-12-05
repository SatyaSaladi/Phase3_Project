package restAPIBDD;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {


	@Test
	public void PostCall() {
		
		Logger logger = Logger.getLogger("APILogs");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.info("********* started the get call***********");
	
		RestAssured.given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body("[\n" + 
					"    {\n" + 
					"        \"id\": 100,\n" + 
					"        \"email\": \"abc@xyz.com\",\n" + 
					"        \"first_name\": \"Nik\",\n" + 
					"        \"last_name\": \"Shah\",\n" + 
					"        \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\n" + 
					"    }\n" + 
					"]")
			
			.when()
			.post()
			.then()
			.statusCode(201)
			.log()
			.all();
	}
}
