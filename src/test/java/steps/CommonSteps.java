package steps;

import static apiEngine.RequestBuilder.setAppID;
import static apiEngine.RequestBuilder.setAuthHeader;
import static apiEngine.RequestBuilder.setHeader;
import static apiEngine.RequestBuilder.setParams;
import static apiEngine.RequestBuilder.setQueryParams;
import static apiEngine.RequestBuilder.withBody;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.log4j.Logger;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.cliftonlabs.json_simple.JsonObject;

import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import enums.Responses;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class CommonSteps {

	protected Logger log = Logger.getLogger(CommonSteps.class);
	private TestContext testContext;
	private static Response response;

	public CommonSteps(TestContext testContext) {
		this.testContext = testContext;
	}

	@Before
	public void before(Scenario scenario) {
		log.info("starting scenario :" + scenario.getName());
		RequestBuilder.resetRequest();
	}

	@After
	public void after(Scenario scenario) {
		log.info("scenario :" + scenario.getName() + " " + scenario.getStatus());
		log.info("ending scenario :" + scenario.getName());
	}

	@And("^author of this test case is \"([^\"]*)\"$")
	public void assignAuthor(String author) {
		ExtentCucumberAdapter.getCurrentStep().assignAuthor(author);
	}

	@Given("^I set content type with value '(.*)'$")
	public void userSetsContentTypeWithValue(String contentType) {
		setHeader("Content-Type", contentType);
	}

	@Given("^I set content type as Json$")
	public void userSetsContentTypeasJson() {
		setHeader("Content-Type", "application/json");
	}

	@Given("^I set query param values as :$")
	public void i_set_query_param_values(DataTable table) {

		for (int i = 0; i < table.asMaps().size(); i++)
			for (String temp : table.asMaps().get(0).keySet())
				setQueryParams(temp, table.asMaps().get(i).get(temp));
	}

	@Given("^I set param values as :$")
	public void i_set_param_values(DataTable table) {

		for (int i = 0; i < table.asMaps().size(); i++)
			for (String temp : table.asMaps().get(0).keySet())
				setParams(temp, table.asMaps().get(i).get(temp));
	}

	@Given("^I set body parameters in string as :$")
	public void setBodyAs(DataTable table) {
		JsonObject json = new JsonObject();

		for (int i = 0; i < table.asMaps().size(); i++) {
			for (String temp : table.asMaps().get(0).keySet()) {
				String value = table.asMaps().get(i).get(temp);

				if (null != value) {
					if (value.equals("true") || value.equals("false"))
						json.put(temp, Boolean.valueOf(value));
					else
						json.put(temp, value);
				}
			}
		}
		withBody(json.toJson());
	}

	@Given("^I set body parameters as \"(.*?)\"$")
	public void setGivenStringAsBody(String value) {

		if (null != value)
			withBody(StringEscapeUtils.unescapeJson(value));
	}

	@Given("^I set body parameters in list as :$")
	public void setBodyInListAs(DataTable table) {
		JsonObject json = new JsonObject();

		for (int i = 0; i < table.asMaps().size(); i++) {
			for (String key : table.asMaps().get(0).keySet()) {
				String value = table.asMaps().get(i).get(key);

				if (null != value) {
					if (value.equals("true") || value.equals("false")) {
						json.put(key, Boolean.valueOf(value));
					} else {
						List<String> list = new ArrayList<>();
						list.add(value);
						json.put(key, list);
					}
				}
			}
		}
		withBody(json.toJson());
	}

	@Given("^I set auth token as header$")
	public void setAuthTokenAsHeader() {
		setAuthHeader(new GenerateAuthToken(testContext).getToken());
	}

	@Given("^I set app id (\\d+) as header$")
	public void setAppIdHeader(int appId) {
		setAppID(String.valueOf(appId));
	}

	@Given("^I set correlation id (\\d+) as header$")
	public void setcorrelationIdHeader(double correlationId) {
		setHeader("x-correlation-id", String.valueOf(correlationId));
	}

	@And("^I should get a sucessfull response$")
	public void validateIfResponseIsSuccess() {
		try {
			log.info("checking if response is successful");
			addTestStepLog("checking if response is successful");
			response = testContext.getResponseHelper().getResponse(Responses.currentApiResponse);

			try {
				assertTrue(RestResponse.isSuccessful(), "checking if response received is sucessfull");
			} catch (AssertionError e) {
				fail(e.getMessage() + "\nActual Status Code : " + response.getStatusCode() + " "
						+ response.getStatusLine());
				addTestStepLog(response.getBody().asString());
			}

		} catch (NullPointerException e1) {
			log.info("could not verify status code");
			addTestStepLog("could not verify status code");
			log.info(e1.getMessage());
		}
	}

}
