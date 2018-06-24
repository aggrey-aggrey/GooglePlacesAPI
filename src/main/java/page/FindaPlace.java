package page;

import org.apache.logging.log4j.LogManager;
import utils.EndPointUrl;
import utils.TestUtils;
import org.apache.logging.log4j.Logger;
import base.RequestCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FindaPlace {
	
	private static Logger log = LogManager.getLogger(FindaPlace.class.getName());
	
	public static String placeASearch(){
		Response response;
		
		log.info("Starting Test Case : Find a Place");
				
		String endPointURI = EndPointUrl.getEndPoint("56.1103,47.47064","dallas", "jTPyEHU0l2FmCr10ny4Q", "Mdaab_RmdxrIhVIxmZ5vmA");
		response = RequestCalls.GETRequest(endPointURI);
		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		String title = jsonRes.getString("results.title");
		log.info("Name of the place we searched : " + title);
	   
		return title;
	}
}
