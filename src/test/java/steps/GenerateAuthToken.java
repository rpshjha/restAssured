package steps;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import data.ConfigReader;
import data.DataHelper;
import data.Query;
import enums.Context;
import enums.Environment;
import enums.RequestType;
import io.restassured.response.Response;
import pojo.authToken.AuthTokenRequest;
import pojo.authToken.AuthTokenResponse;
import pojo.sendOTP.SendOTPRequest;
import pojo.sendOTP.SendOTPResponse;

public class GenerateAuthToken {

	private TestContext testContext;
	private Response response;

	public GenerateAuthToken(TestContext testContext) {
		this.testContext = testContext;
	}

	private static Logger log = Logger.getLogger(GenerateAuthToken.class);

	public void hitApiForSendOTP() {
//		String mobileno = String.valueOf((long) (Math.random() * 100000 + 7004000000L));
		String mobileno = "7702056221";
		testContext.getScenarioContext().setContext(Context.mobileNo, mobileno);

		SendOTPRequest sendOTP = new SendOTPRequest(mobileno, DataHelper.getGenerateTokenData().getAppId());
		RequestBuilder.setContentTypeAsJson();
		response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getSendOtp(), sendOTP);
		SendOTPResponse responseBody = new RestResponse<>(SendOTPResponse.class, response).getBody();

		try {
			if (responseBody.getError().booleanValue()
					&& responseBody.getErrors().get(0).getErrorCode().equals("OTP.LIMIT.EXCEEDED")) {
				log.info("error occured " + responseBody.getErrors().get(0).getErrorMessage());
				Query.RESET_OTP_ATTEMPT_COUNTER(mobileno);
				response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getSendOtp(), sendOTP);
				responseBody = new RestResponse<>(SendOTPResponse.class, response).getBody();
			}
			if (!responseBody.getError().booleanValue())
				testContext.getScenarioContext().setContext(Context.OTP, Query.GET_OTP(mobileno));
			else
				Assert.fail(responseBody.getErrors().get(0).getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(response.getStatusLine());
		}
	}

	public String hitApiForAuthToken() {

		AuthTokenRequest authToken = null;
		try {
			String mobileno = testContext.getScenarioContext().getContext(Context.mobileNo).toString();
			authToken = new AuthTokenRequest(DataHelper.getGenerateTokenData().getAppId(), mobileno,
					testContext.getScenarioContext().getContext(Context.OTP).toString());
		} catch (NullPointerException e) {
			Assert.fail("unable to fetch OTP, hence not able to set it in test context");
		}

		RequestBuilder.setContentTypeAsJson();

		response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getAuthToken(), authToken);
		AuthTokenResponse responseBody = new RestResponse<>(AuthTokenResponse.class, response).getBody();

		try {
			if (!responseBody.getError().booleanValue())
				testContext.getScenarioContext().setContext(Context.userTokenID, responseBody.getData().getIdToken());
		} catch (Exception e) {
			Assert.fail(response.getStatusLine());
		}

		return testContext.getScenarioContext().getContext(Context.userTokenID).toString();
	}

	/**
	 * @return {@link String} idToken
	 */
	public String getToken() {

		File file = new File("./src/test/resources/idToken-" + ConfigReader.getProperty("environment") + ".txt");
		String idToken = "";

		switch (ConfigReader.getProperty("environment")) {
		case Environment.PROD:

			idToken = generateTokenForSMPEXTERNALProd();
			writeTokenInFile(file, idToken);
			RequestBuilder.resetRequest();
			return idToken;

		case Environment.PREPROD:

//			idToken = generateTokenForSMPEXTERNALPreProd();
			idToken = generateTokenForSUB(file);
			writeTokenInFile(file, idToken);
			RequestBuilder.resetRequest();
			return idToken;

		case Environment.QA:

//			idToken = generateTokenForSMPEXTERNALQA();
			idToken = generateTokenForSUB(file);
			writeTokenInFile(file, idToken);
			RequestBuilder.resetRequest();
			return idToken;

		default:
			System.err.println("Invalid Environment");
			break;
		}

		return idToken;
	}
	
	
	public String generateTokenForSUB(File file) {
		String idToken = "";
		
		if (file.exists()) {
		long time = file.lastModified();
		long diff = System.currentTimeMillis() - time;
		long diffInMins = TimeUnit.MILLISECONDS.toMinutes(diff);

		/**
		 * checking if valid authorization token already exists
		 * 
		 */
		if (diffInMins < 30) {
			log.info("Authorization token already exists");
			try {
				idToken = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			/**
			 * Generating new token
			 */
			GenerateAuthToken token = new GenerateAuthToken(testContext);
			token.hitApiForSendOTP();
			idToken = token.hitApiForAuthToken();
			try {
				// storing id token in text file
				FileUtils.write(file, "", StandardCharsets.UTF_8);
				FileUtils.writeStringToFile(file, idToken, StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} else {

		/**
		 * Generating new token
		 */
		GenerateAuthToken token = new GenerateAuthToken(testContext);
		token.hitApiForSendOTP();
		idToken = token.hitApiForAuthToken();
		try {
			// storing id token in text file
			FileUtils.write(file, "", StandardCharsets.UTF_8);
			FileUtils.writeStringToFile(file, idToken, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	return idToken.trim();
	}

	private void writeTokenInFile(File file, String idToken) {
		try {
			// storing id token in text file
			FileUtils.write(file, "", StandardCharsets.UTF_8);
			FileUtils.writeStringToFile(file, idToken, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String generateTokenForSMPEXTERNALProd() {
		String uri = "https://msil-token.auth.ap-south-1.amazoncognito.com/oauth2/token";

		String userName = "7aold64i2hvfsg6ijipsfp3ci";
		String password = "1pr8b5l0p1rkrh6jjq10vfs6fqa71ah59si6gju6eijadlniv8h4";

		RequestBuilder.setContentTypeAs("application/x-www-form-urlencoded");
		RequestBuilder.setBasicAuthCredentials(userName, password);
		RequestBuilder.setQueryParams("grant_type", "client_credentials");
		RequestBuilder.setQueryParams("scope", "subscribe-web/subscribe-web-scope");

		return RequestBuilder.createRequest(RequestType.POST, uri).getBody().jsonPath().get("access_token");
	}

	public String generateTokenForSMPEXTERNALQA() {
		String uri = "https://msil-token-qa.auth.ap-south-1.amazoncognito.com/oauth2/token";
		
		String userName = "21v5s6lonk0buabc5hpsa3shdu";
		String password = "1l8bjfq8rmgdq5h0l8p1p47dujc1a8r184ts0dqp1s5nuphjvpdk";

		RequestBuilder.setContentTypeAs("application/x-www-form-urlencoded");
		RequestBuilder.setBasicAuthCredentials(userName, password);
		RequestBuilder.setQueryParams("grant_type", "client_credentials");
		RequestBuilder.setQueryParams("scope", "subscribe-web/subscribe-web-scope");

		return RequestBuilder.createRequest(RequestType.POST, uri).getBody().jsonPath().get("access_token");
	}

	public String generateTokenForSMPEXTERNALPreProd() {
		String uri = "https://msil-token-preprod.auth.ap-south-1.amazoncognito.com/oauth2/token";
		
		String userName = "6b207gqemrckktmhnhqqoqn1iv";
		String password = "p1p5hslnc8iei46fijg2ioknnldke29crehg7b8s4n2usgdaqls";

		RequestBuilder.setContentTypeAs("application/x-www-form-urlencoded");
		RequestBuilder.setBasicAuthCredentials(userName, password);
		RequestBuilder.setQueryParams("grant_type", "client_credentials");
		RequestBuilder.setQueryParams("scope", "subscribe-web/subscribe-web-scope");

		return RequestBuilder.createRequest(RequestType.POST, uri).getBody().jsonPath().get("access_token");
	}

}
