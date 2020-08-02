package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apiEngine.ApiHeaders;
import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import data.DataHelper;
import enums.Context;
import enums.RequestType;
import enums.Responses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import pojo.vehiclePaymentDetails.Category;
import pojo.vehiclePaymentDetails.Model;
import pojo.vehiclePaymentDetails.Price;
import pojo.vehiclePaymentDetails.VehiclePaymentDetailsRequest;
import pojo.vehiclePaymentDetails.VehiclePaymentDetailsResponse;

public class VehiclePaymentDetailsSteps {

	protected Logger log = Logger.getLogger(VehicleListSteps.class);
	protected TestContext testContext;
	private VehiclePaymentDetailsRequest requestBody = new VehiclePaymentDetailsRequest();
	private VehiclePaymentDetailsResponse responseBody;
	private Response response;

	public VehiclePaymentDetailsSteps(TestContext context) {
		this.testContext = context;
	}

	@Given("^I perform POST operation for vehicle payment details$")
	public void hitApiForVehiclePaymentDetails() {

//		int cityId = DataHelper.getVehiclePaymentDetailsData().getCityId();
//		String tenure = DataHelper.getVehiclePaymentDetailsData().getTenure();
//		String startDate = DataHelper.getVehiclePaymentDetailsData().getStartDate();
//		String endDate = DataHelper.getVehiclePaymentDetailsData().getEndDate();
//		boolean isPriceRequired = DataHelper.getVehiclePaymentDetailsData().isPriceRequired();
//		boolean isDiscountRequired = DataHelper.getVehiclePaymentDetailsData().isDiscountRequired();
//		boolean isSecurityRequired = DataHelper.getVehiclePaymentDetailsData().isSecurityRequired();
//		boolean isGSTRequired = DataHelper.getVehiclePaymentDetailsData().isGSTRequired();
//
//		String categoryID = DataHelper.getVehiclePaymentDetailsData().getCategories();
//		Category categories = new Category(categoryID);
//		List<Category> categoriesList = new ArrayList<>();
//		categoriesList.add(categories);
//
//		VehiclePaymentDetailsRequest VehiclePaymentDetails = new VehiclePaymentDetailsRequest(cityId, tenure,
//				categoriesList, startDate, endDate, isPriceRequired, isDiscountRequired, isSecurityRequired,
//				isGSTRequired);

		response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getVehiclePaymentDetails(), requestBody);
		testContext.getResponseHelper().setResponse(Responses.currentApiResponse, response);
		responseBody = new RestResponse<>(VehiclePaymentDetailsResponse.class, response).getBody();
	}

	@Then("^price component should return valid values$")
	public void iReceivePriceDetails() {

		Price a = responseBody.getData().getCategories().get(0).getModels().get(0).getPriceDetails().getPrice().get(0);

		assertTrue(a.getPrice() != null, "checking if price is not returned as null");
		assertTrue(a.getTenure() != null, "checking if tenure is not returned as null");
		assertTrue(a.getValidFrom() != null, "checking if valid from not returned as null");
		assertTrue(a.getValidTo() != null, "checking if valid to not returned as null");

	}

	@When("I set cityId as {int}")
	public void i_set_cityId_as(Integer int1) {
		requestBody.setCityId(int1);
	}

	@When("I set tenure as {int}")
	public void i_set_tenure_as(Integer int1) {
		requestBody.setTenure(String.valueOf(int1));
	}

	@When("I set category id as {int}")
	public void i_set_category_id_as(Integer int1) {
		Category cat = new Category();
		cat.setId(String.valueOf(int1));
		requestBody.setCategories(Arrays.asList(cat));
	}

	@When("I give modelCode as {string} and variantCode as {string}")
	public void i_give_modelCode_as_and_variantCode_as(String string, String string2) {
		Model model = new Model();
		model.setVariantCode(string2);
		model.setModelCode(string);
		Category cat = new Category();
		cat.setModels(Arrays.asList(model));
		requestBody.setCategories(Arrays.asList(cat));
	}

	@When("I give startDate as {string}")
	public void i_give_startDate_as(String string) {
		requestBody.setStartDate(string);
	}

	@When("I set isPriceRequired as {string}")
	public void i_set_isPriceRequired_as(String string) {
		requestBody.setIsPriceRequired(Boolean.valueOf(string));
	}

	@When("I set isDiscountRequired as {string}")
	public void i_set_isDiscountRequired_as(String string) {
		requestBody.setIsDiscountRequired(Boolean.valueOf(string));
	}

	@When("I set isSecurityRequired as {string}")
	public void i_set_isSecurityRequired_as(String string) {
		requestBody.setIsSecurityRequired(Boolean.valueOf(string));
	}

	@When("I set isGSTRequired as {string}")
	public void i_set_isGSTRequired_as(String string) {
		requestBody.setIsGSTRequired(Boolean.valueOf(string));
	}

	@Then("I should get list of vehicles with category id as {int}")
	public void i_should_get_list_of_vehicles_with_category_id_as(Integer int1) {
		for (Category temp : responseBody.getData().getCategories()) {
			assertEquals(temp.getId(), String.valueOf(int1));
		}
	}

}
