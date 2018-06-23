package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class  RequestCalls {/*
	 * This class will be responsible for firing requests
	 */
	private static final Logger log = LogManager.getLogger(RequestCalls.class.getName());
	private static String q;
	private static String at;
	private static String app_id;
	private static String app_code;
	
	
	public RequestCalls(String longLat, String placeName, String appId, String appCode){
		q = placeName;
	   at = longLat;
	   app_id = appId;
	   app_code = appCode;
		
	}
	
	public static String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public static String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public static String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public static String getApp_code() {
		return app_code;
	}

	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}

	public static Response GETRequest(String uRI) {
	
	
		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("at", getAt());
		requestSpecification.param("q", getQ() );
		requestSpecification.param("app_id", getApp_id());
		requestSpecification.param("app_code", getApp_code());
		
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response POSTRequest(String uRI, String strJSON, String sessionID) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID+"");
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	

	public static Response PUTRequest(String uRI, String strJSON) {
		log.info("Inside PUTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String uRI, String strJSON) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	

}
