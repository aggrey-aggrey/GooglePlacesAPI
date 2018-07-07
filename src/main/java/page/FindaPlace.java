package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.RequestCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.EndPointUrl;
import utils.TestUtils;

public class FindaPlace {

	private static Logger log = LogManager.getLogger(FindaPlace.class.getName());

	public static String searchForAPlace(String resource, String latitudeLongitude, String nameOfPlace, String appId,
			String appCode) {
		Response response;

		log.info("Starting Test Case : Find a Place");

		String endPointURI = EndPointUrl.getEndPoint(resource, latitudeLongitude, nameOfPlace, appId, appCode);
		response = RequestCalls.GETRequest(endPointURI);
		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		String title = jsonRes.getString("results.items");
		log.info("Name of the place we searched : " + title);

		return title;
	}

}
