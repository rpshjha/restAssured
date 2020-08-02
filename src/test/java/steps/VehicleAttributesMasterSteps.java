package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import data.Query;
import enums.RequestType;
import enums.Responses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.vehicleAttributeMaster.BodyType;
import pojo.vehicleAttributeMaster.ChannelType;
import pojo.vehicleAttributeMaster.Color;
import pojo.vehicleAttributeMaster.Model;
import pojo.vehicleAttributeMaster.RegistrationType;
import pojo.vehicleAttributeMaster.TransmissionType;
import pojo.vehicleAttributeMaster.Variant;
import pojo.vehicleAttributeMaster.VehicleAttributesMasterResponse;

public class VehicleAttributesMasterSteps {

	private TestContext testContext;
	private Response response;
	private VehicleAttributesMasterResponse responseBody;

	public VehicleAttributesMasterSteps(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("^I perform GET operation for vehicle attributes master$")
	public void hitApiForAttributesMaster() {

		response = RequestBuilder.createRequest(RequestType.GET, EndPoints.getVehicleAttributesMaster());
		testContext.getResponseHelper().setResponse(Responses.currentApiResponse, response);
		responseBody = new RestResponse<>(VehicleAttributesMasterResponse.class, response).getBody();
	}

	@Given("^I should get error code as All required values must be provided$")
	public void expectErrorCode() {

		assertEquals(responseBody.getErrors().get(0).getErrorCode(), "All required values must be provided.");
	}

	@Then("I should get model as null")
	public void i_should_get_model_as_null() {
		assertEquals(null, responseBody.getData().getModel());
	}

	@Then("I should get variant as null")
	public void i_should_get_variant_as_null() {
		assertEquals(responseBody.getData().getVariant(), null);
	}

	@Then("I should get color as null")
	public void i_should_get_color_as_null() {
		assertEquals(responseBody.getData().getColor(), null);
	}

	@Then("I should get body type as null")
	public void i_should_get_body_type_as_null() {
		assertEquals(responseBody.getData().getBodyType(), null);
	}

	@Then("I should get channel type as null")
	public void i_should_get_channel_type_as_null() {
		assertEquals(responseBody.getData().getChannelType(), null);
	}

	@Then("I should get registration type as null")
	public void i_should_get_registration_type_as_null() {
		assertEquals(responseBody.getData().getRegistrationType(), null);
	}

	@Then("I should get transmission type as null")
	public void i_should_get_transmission_type_as_null() {
		assertEquals(responseBody.getData().getTransmissionType(), null);
	}

	@Then("I should get all the models stored in the DB")
	public void i_should_get_all_the_models_stored_in_the_DB() {

		List<String> modelCode = new ArrayList<>();
//		List<String> modelDesc = new ArrayList<>();

		for (Model temp : responseBody.getData().getModel()) {
			modelCode.add(temp.getModelCode());
//			modelDesc.add(temp.getModelDesc());
		}
		Collections.sort(modelCode);
		assertEquals(Query.GET_ALL_MODEL_CD(), modelCode, "checking if model code returned is fetched from DB");

	}

	@Then("I should get all the variant stored in the DB")
	public void i_should_get_all_the_variant_stored_in_the_DB() {

		List<String> variantCode = new ArrayList<>();

		for (Variant temp : responseBody.getData().getVariant()) {
			variantCode.add(temp.getVariantCode());
		}
		Collections.sort(variantCode);
		assertEquals(Query.GET_ALL_VARIANT_CD(), variantCode, "checking if variant code returned is fetched from DB");

	}

	@Then("I should get all the color stored in the DB")
	public void i_should_get_all_the_color_stored_in_the_DB() {

		List<String> color = new ArrayList<>();

		for (Color temp : responseBody.getData().getColor()) {
			color.add(temp.getEcolorCd());
		}
		Collections.sort(color);
		assertEquals(Query.GET_ALL_COLOR_CD(), color, "checking if color code returned is fetched from DB");

	}

	@Then("I should get all the body type stored in the DB")
	public void i_should_get_all_the_body_type_stored_in_the_DB() {

		List<String> bodyType = new ArrayList<>();

		for (BodyType temp : responseBody.getData().getBodyType()) {
			bodyType.add(temp.getId());
		}
		Collections.sort(bodyType);
		assertEquals(Query.GET_ALL_BODY_TYPE(), bodyType, "checking if body type returned is fetched from DB");

	}

	@Then("I should get all the channel type stored in the DB")
	public void i_should_get_all_the_channel_type_stored_in_the_DB() {

		List<String> channelType = new ArrayList<>();

		for (ChannelType temp : responseBody.getData().getChannelType()) {
			channelType.add(temp.getChannelType());
		}
		Collections.sort(channelType);
		assertEquals(Query.GET_ALL_CHANNEL_TYPE(), channelType, "checking if channel type returned is fetched from DB");

	}

	@Then("I should get all the registration type stored in the DB")
	public void i_should_get_all_the_registration_type_stored_in_the_DB() {

		List<String> regType = new ArrayList<>();

		for (RegistrationType temp : responseBody.getData().getRegistrationType()) {
			regType.add(temp.getRegistrationType());
		}
		Collections.sort(regType);
		assertEquals(Query.GET_ALL_REGISTRATION_TYPE(), regType,
				"checking if registration type returned is fetched from DB");

	}

	@Then("I should get all the transmission type stored in the DB")
	public void i_should_get_all_the_transmission_type_stored_in_the_DB() {

		List<String> transmissionType = new ArrayList<>();

		for (TransmissionType temp : responseBody.getData().getTransmissionType()) {
			transmissionType.add(temp.getId());
		}
		Collections.sort(transmissionType);
		assertEquals(Query.GET_ALL_TRANSMISSION_TYPE(), transmissionType,
				"checking if transmission type returned is fetched from DB");

	}

}
