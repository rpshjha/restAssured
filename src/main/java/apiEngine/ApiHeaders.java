package apiEngine;

import org.apache.log4j.Logger;

public class ApiHeaders {

	private static Logger log = Logger.getLogger(ApiHeaders.class);

	public static io.restassured.http.Header setContentTypeAsJson() {
		log.info("setting content type as json");
		return new io.restassured.http.Header("Content-Type", "application/json");
	}

	public static io.restassured.http.Header setAuthToken(String value) {
		log.info("setting auth token as header");
		return new io.restassured.http.Header("Authorization", value);
	}

	public static io.restassured.http.Header setAppID(String value) {
		log.info("setting app id as header");
		return new io.restassured.http.Header("x-app-id", value);
	}

}
