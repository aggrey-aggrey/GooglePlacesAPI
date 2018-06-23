package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.RequestCalls;



public class EndPointUrl {
	private static Logger log = LogManager.getLogger(EndPointUrl.class.getName());
	public static final String URL = "https://places.cit.api.here.com/places/v1/";
	//https://places.cit.api.here.com/places/v1/autosuggest?at=40.74917,-73.98529&q=chrysler&app_id=mYAPPId&app_code=MyAPPcode
	public String q, at, app_id, app_code;
	
	public static String getEndPoint(String longLat,String placeName, String appId, String appCode) 
	{
		RequestCalls requestCalls = new RequestCalls(longLat, placeName, appId, appCode);
		
		log.info("Base URI : " + URL + "autosuggest?" + "at=" + RequestCalls.getAt() + "&" + "q=" + RequestCalls.getQ() + "&" + "app_id=" + RequestCalls.getApp_id() +   "&" + "app_code=" + RequestCalls.getApp_code());
		return URL;	
	}
	
	/**public static String getEndPoint(String resource){
		log.info("URI End Point : " + URL + resource);
		return URL + resource;
	}**/

}
