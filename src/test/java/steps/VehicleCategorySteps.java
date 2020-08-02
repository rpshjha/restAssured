package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import data.Query;
import enums.Context;
import enums.RequestType;
import enums.Responses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.categories.VehicleCategoryResponse;

public class VehicleCategorySteps {

	public VehicleCategorySteps(TestContext testContext) {
		this.testContext = testContext;
	}

	private static Response response;
	private VehicleCategoryResponse responseBody;
	private TestContext testContext;

	@Given("^I perform GET operation for vehicle category$")
	public void hitApiForvehicleCat() {

		response = RequestBuilder.createRequest(RequestType.GET, EndPoints.getVehicleCategories());
		responseBody = new RestResponse<>(VehicleCategoryResponse.class, response).getBody();

		testContext.getResponseHelper().setResponse(Responses.currentApiResponse, response);
	}

	@When("^I should see category name and id$")
	public void I_should_see_category_name_and_id() {

		String catName = responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getName();
		int catID = responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getId();
		testContext.getScenarioContext().setContext(Context.categoryID, catID);
		String catNameDB = Query.GET_CAT_NAME_BY_CAT_ID(catID);
		assertEquals(catName, catNameDB);
	}

	@When("^I should see tenure start and tenure end$")
	public void tenureStartAndEndShouldBeFetched() {

		int tenureStart = responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getTenureStart();
		int tenureEnd = responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getTenureEnd();

		assertTrue(tenureStart != 0, "checking if tenure start is fetched");
		assertTrue(tenureEnd != 0, "checking if tenure end is fetched");
	}

	@When("^tenure start and tenure end should be correctly mapped to DB$")
	public void tenureStartAndTenureEndShouldMapToDb() {

		int catID;
		try {
			catID = (int) testContext.getScenarioContext().getContext(Context.categoryID);
		} catch (NullPointerException e) {
			catID = responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getId();
		}
		Integer tenureStartDB = Query.GET_TENURE_START_BY_CAT_ID(catID);
		Integer tenureEndDb = Query.GET_TENURE_END_BY_CAT_ID(catID);

		assertEquals(responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getTenureStart(),
				tenureStartDB);
		assertEquals(responseBody.getData().getVehicleCategoryAndAttributesResponseTO().get1().getTenureEnd(),
				tenureEndDb);
	}

}
