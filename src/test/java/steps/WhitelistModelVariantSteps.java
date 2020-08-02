package steps;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import enums.RequestType;
import enums.Responses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import pojo.whitelistModel.BodyType;
import pojo.whitelistModel.ModelVariant;
import pojo.whitelistModel.Variant;
import pojo.whitelistModel.WhitelistModelRequest;
import pojo.whitelistModel.WhitelistModelResponse;

public class WhitelistModelVariantSteps {

	protected Logger log = Logger.getLogger(WhitelistModelVariantSteps.class);
	protected TestContext testContext;
	private WhitelistModelResponse responseBody;
	private Response response;
	private WhitelistModelRequest requestBody = new WhitelistModelRequest();

	public WhitelistModelVariantSteps(TestContext context) {
		this.testContext = context;
	}

	@Given("^I perform POST operation for whitelist model master api$")
	public void hitApiForWhitelistModel() {

		response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getWhitelistModelMaster(), requestBody);
		testContext.getResponseHelper().setResponse(Responses.currentApiResponse, response);
		responseBody = new RestResponse<>(WhitelistModelResponse.class, response).getBody();
	}

	@When("I set resolution as {string}")
	public void i_set_resolution_as(String string) {
		requestBody.setResolution(string);
	}

	@When("I set isColorsRequired as {string}")
	public void i_set_isColorsRequired_as(String string) {
		requestBody.setIsColorsRequired(Boolean.valueOf(string));
	}

	@When("I set isBodyTypesRequired as {string}")
	public void i_set_isBodyTypesRequired_as(String string) {
		requestBody.setIsBodyTypesRequired(Boolean.valueOf(string));
	}

	@When("I set isEnginTypesRequired as {string}")
	public void i_set_isEnginTypesRequired_as(String string) {
		requestBody.setIsEnginTypesRequired(Boolean.valueOf(string));
	}

	@When("I set isTransmissionTypesRequired as {string}")
	public void i_set_isTransmissionTypesRequired_as(String string) {
		requestBody.setIsTransmissionTypesRequired(Boolean.valueOf(string));
	}

	@When("I set isFuelTypesRequired as {string}")
	public void i_set_isFuelTypesRequired_as(String string) {
		requestBody.setIsFuelTypesRequired(Boolean.valueOf(string));
	}

	@When("I set modelCodes as")
	public void i_set_modelCodes_as(io.cucumber.datatable.DataTable dataTable) {
		requestBody.setModelCodes(dataTable.asList());
	}

	@When("I set variantCodes as")
	public void i_set_variantCodes_as(io.cucumber.datatable.DataTable dataTable) {
		requestBody.setVariantCodes(dataTable.asList());
	}

	@When("I set bodyTypes as")
	public void i_set_bodyTypes_as(io.cucumber.datatable.DataTable dataTable) {
		requestBody.setBodyTypes(dataTable.asList());
	}

	@When("I set enginTypes as")
	public void i_set_enginTypes_as(io.cucumber.datatable.DataTable dataTable) {
		requestBody.setEnginTypes(dataTable.asList());
	}

	@When("I set channelTypes as")
	public void i_set_channelTypes_as(io.cucumber.datatable.DataTable dataTable) {
		requestBody.setChannelTypes(dataTable.asList());
	}

	@When("I set colorCodes as")
	public void i_set_colorCodes_as(io.cucumber.datatable.DataTable dataTable) {
		requestBody.setColorCodes(dataTable.asList());
	}

	@Then("I should get list of vehicles with modelCode as")
	public void i_should_get_list_of_vehicles_with_modelCode_as(DataTable dataTable) {

		List<String> modelCode = new ArrayList<String>();
		List<String> datatable = new ArrayList<>();

		log.info("verifying list of vehicles with model code");
		for (ModelVariant modelVariant : responseBody.getData().getModelVariants())
			modelCode.add(modelVariant.getModelCode());

		while (dataTable.asList().listIterator().hasNext())
			datatable.add(dataTable.asList().listIterator().next());

		Collections.sort(datatable);
		Collections.sort(modelCode);
		assertEquals(modelCode, datatable);
	}

	@Then("I should get list of vehicles with variantCode as")
	public void i_should_get_list_of_vehicles_with_variantCode_as(io.cucumber.datatable.DataTable dataTable) {

		List<String> variantCode = new ArrayList<String>();
		List<String> datatable = new ArrayList<>();

		log.info("verifying list of vehicles with variant code");
		for (ModelVariant modelVariant : responseBody.getData().getModelVariants())
			for (Variant variant : modelVariant.getVariants())
				variantCode.add(variant.getVariantCode());

		while (dataTable.asList().listIterator().hasNext())
			datatable.add(dataTable.asList().listIterator().next());

		Collections.sort(datatable);
		Collections.sort(variantCode);
		assertEquals(variantCode, datatable);
	}

	@Then("I should get list of vehicles with bodyType as")
	public void i_should_get_list_of_vehicles_with_bodyType_as(io.cucumber.datatable.DataTable dataTable) {

		List<String> bodyType = new ArrayList<String>();
		List<String> datatable = new ArrayList<>();

		log.info("verifying list of vehicles with body type code");
		for (ModelVariant modelVariant : responseBody.getData().getModelVariants())
			for (Variant variant : modelVariant.getVariants())
//				for(BodyType body : variant.getBodyTy)
//					bodyType.add(body.)
//
//		while (dataTable.asList().listIterator().hasNext())
//			datatable.add(dataTable.asList().listIterator().next());

		Collections.sort(datatable);
		Collections.sort(bodyType);
		assertEquals(bodyType, datatable);
	}

	@Then("I should get list of vehicles with enginType as")
	public void i_should_get_list_of_vehicles_with_enginType_as(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should get list of vehicles with channelType as")
	public void i_should_get_list_of_vehicles_with_channelType_as(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should get list of vehicles with colorCode as")
	public void i_should_get_list_of_vehicles_with_colorCode_as(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

}
