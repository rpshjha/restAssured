package steps;

import static data.DataHelper.getVehicleListData;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import commonUtils.BusinessFunctions;
import commonUtils.JavaUtils;
import cucumber.TestContext;
import data.Query;
import enums.RequestType;
import enums.Responses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.carListing.ColorOption;
import pojo.carListing.Filter;
import pojo.carListing.Sort;
import pojo.carListing.Vehicle;
import pojo.carListing.VehicleListRequest;
import pojo.carListing.VehicleListResponse;
import testData.VehicleListTestData;

public class VehicleListSteps {

	protected Logger log = Logger.getLogger(VehicleListSteps.class);
	protected TestContext testContext;
	private VehicleListResponse responseBody;
	private Response response;
	Filter filter;
	Sort sort;

	public VehicleListSteps(TestContext context) {
		this.testContext = context;
		this.filter = new Filter();
		this.sort = new Sort();
	}

	@Given("^I perform POST operation for vehicle list$")
	public void hitApiForVehicleList() {
		
//		RequestBuilder.resetRequest();
		
		response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getVehicleListing());
		testContext.getResponseHelper().setResponse(Responses.currentApiResponse, response);
		responseBody = new RestResponse<>(VehicleListResponse.class, response).getBody();
	}

	@Given("^I perform POST operation for vehicle list with mandatory body$")
	public void hitApiForVehicleListWithMandatoryBody() {
		
//		RequestBuilder.resetRequest();
		
		VehicleListTestData vehicleData = getVehicleListData();
		int cityId = vehicleData.getCityId();
		int tenureId = vehicleData.getTenureId();
		String resolution = "xxhdpi";
		filter.setCityId(cityId);
		filter.setTenureId(tenureId);
		filter.setResolution(resolution);
		sort.setPrice("ASC");
		RequestBuilder.setContentTypeAsJson();
		VehicleListRequest request = new VehicleListRequest(filter,sort);
		response = RequestBuilder.createRequest(RequestType.POST, EndPoints.getVehicleListing(), request);
		testContext.getResponseHelper().setResponse(Responses.currentApiResponse, response);
		responseBody = new RestResponse<>(VehicleListResponse.class, response).getBody();
	}

	@And("^I should get list of vehicles$")
	public void getListOfVehicles() {
		assertTrue(responseBody.getData().getVehicles().size() > 0,
				"checking if vehicle list returned should be greater than 0");
	}

	@And("^vehicle list should be of new type$")
	public void vehicleListShouldBeNew() {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(Query.GET_IS_NEW_TYPE_FROM_CATEGORY_ID(v.getCategoryId()), true,
					"checking if vehicle is of new type");
		}
	}

	@And("^vehicle list should be of used type$")
	public void vehicleListShouldBeUsed() {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(Query.GET_IS_NEW_TYPE_FROM_CATEGORY_ID(v.getCategoryId()), false,
					"checking if vehicle is of used type");
		}
	}

	@And("^I set model code \"([^\"]*)\" as filter$")
	public void setModelCodeAsFilter(String modelCode) {
		List<String> list = new ArrayList<>();
		list.add(modelCode);
		filter.setModelCode(list);
	}

	@And("^I set variant code \"([^\"]*)\" as filter$")
	public void setVariantCodeAsFilter(String variantCode) {
		List<String> list = new ArrayList<>();
		list.add(variantCode);
		filter.setVariantCode(list);
	}

	@And("^I set bodyType \"([^\"]*)\" as filter$")
	public void setBodyTypeAsFilter(String bodyType) {
		List<String> list = new ArrayList<>();
		list.add(bodyType);
		filter.setBodyType(list);
	}

	@And("^I set registrationType \"([^\"]*)\" as filter$")
	public void setRegTypeAsFilter(String regType) {
		List<String> list = new ArrayList<>();
		list.add(regType);
		filter.setRegistrationType((list));
	}

	@And("^I set channelType \"([^\"]*)\" as filter$")
	public void setChannelTypeAsFilter(String channelType) {
		List<String> list = new ArrayList<>();
		list.add(channelType);
		filter.setChannelType((list));
	}

	@And("^I set color code \"([^\"]*)\" as filter$")
	public void setColorTypeAsFilter(String color) {
		List<String> list = new ArrayList<>();
		list.add(color);
		filter.setColorCode(list);
	}

	@Then("^I should only get list of vehicles having model code as \"(.*)\"$")
	public void shouldGetVehiclesWithModelCodeAs(String modelCode) {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(v.getModelCode(), modelCode, "checking if model code is same as expected");
		}
	}

	@Then("^I should only get list of vehicles having body type as \"([^\"]*)\"$")
	public void shouldGetVehiclesWithbodyTypeAs(String bodyType) {

		for (Vehicle v : responseBody.getData().getVehicles()) {
//			for (String body_type : bodyType.asList())
			assertEquals(v.getBodyType(), bodyType, "checking if body type is same as expected");
		}
	}

	@Then("^I should only get list of vehicles having registration type as \"([^\"]*)\"$")
	public void shouldGetVehiclesWithRegTypeAs(String regType) {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(v.getRegistrationType(), regType, "checking if reg type is same as expected");
		}
	}

	@Then("^I should only get list of vehicles having channel type as \"([^\"]*)\"$")
	public void shouldGetVehiclesWithChannelTypeAs(String channelType) {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(v.getChannelType(), channelType, "checking if channel type is same as expected");
		}
	}

	@Then("^I should only get list of vehicles having color code as \"([^\"]*)\"$")
	public void shouldGetVehiclesWithColorTypeAs(String color) {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(v.getColorOptions().get(0).getColorCode(), color,
					"checking if color code is same as expected");
		}
	}

	@Then("^I should only get list of vehicles having variant code as \"(.*)\"$")
	public void shouldGetVehiclesWithVariantCodeAs(String variantCode) {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(v.getVariantCode(), variantCode, "checking if variant code is same as expected");
		}
	}

	@When("^I set Vehicle type as \"([^\"]*)\"$")
	public void setVehicleTypeAs(String vehicleType) {

		switch (vehicleType) {
		case "new":
			filter.setIsNew(true);
			break;
		case "used":
			filter.setIsNew(false);
			break;
		default:
			log.info("please specify vehicle type as either new or used");
			break;
		}
	}

	@And("^vehicle list with given model type should be returned$")
	public void vehicleListreturnedShouldMatchModelCode() {

		for (Vehicle v : responseBody.getData().getVehicles()) {
			assertEquals(Query.GET_IS_NEW_TYPE_FROM_CATEGORY_ID(v.getCategoryId()), false,
					"checking if vehicle is of used type");
		}
	}

	@And("^price of vehicle should be sorted in descending order$")
	public void isSortedDesc() {

		List<Double> actualPrice = new ArrayList<Double>();

		for (Vehicle v : responseBody.getData().getVehicles()) {
			double effPrice = BusinessFunctions.GetPriceAfterDiscount(v.getBasePrice().getTotalWithGST(), v.getDiscount().getValue(),
					v.getDiscount().getType());
			System.out.println(effPrice);
			actualPrice.add(effPrice);
		}

		assertEquals(JavaUtils.isSortedDescending(actualPrice), true,
				"checking if price of vehicle is sorted in descending order");
	}

	@And("^price of vehicle should be sorted in ascending order$")
	public void isSortedAsc() {

		List<Double> actualPrice = new ArrayList<Double>();
		for (Vehicle v : responseBody.getData().getVehicles()) {
			double effPrice = BusinessFunctions.GetPriceAfterDiscount(v.getBasePrice().getTotalWithGST(), v.getDiscount().getValue(),
					v.getDiscount().getType());

			actualPrice.add(effPrice);
		}

		assertEquals(JavaUtils.isSortedAscending(actualPrice), true,
				"checking if price of vehicle is sorted in ascending order");

	}

	@And("^I should get discount as stored in DB$")
	public void discountShouldMatchDB() {
		List<Vehicle> listOfVehicle = responseBody.getData().getVehicles();
		String carName = listOfVehicle.get(0).getDesc();
		assertEquals(String.valueOf(listOfVehicle.get(0).getDiscount().getValue()),
				Query.GET_DISCOUNT_ON_CAR_BY_TENURE(carName, getVehicleListData().getTenureId()));
	}

	@And("^I should get price as stored in DB$")
	public void priceShouldMatchDB() {
		List<Vehicle> listOfVehicle = responseBody.getData().getVehicles();
		String carName = listOfVehicle.get(0).getDesc();
		assertEquals(listOfVehicle.get(0).getBasePrice(),
				Query.GET_PRICE_OF_CAR_BY_TENURE(carName, getVehicleListData().getTenureId()));
	}

	@Given("I should get list of vehicle image")
	public void i_should_get_list_of_vehicle_image() throws IOException {

		for (Vehicle vehicle : responseBody.getData().getVehicles())
			for (ColorOption colorOption : vehicle.getColorOptions()) {
				try {
					assertEquals(JavaUtils.isUrlValid(colorOption.getVehicleImage()), true);
					FileUtils.writeStringToFile(new File("./src/test/resources/vehicle_url.txt"),
							colorOption.getVehicleImage() + "\n", StandardCharsets.UTF_8, true);
				} catch (AssertionError e) {
					System.err.println("url is invalid : " + colorOption.getVehicleImage());
					Assert.fail("url is invalid : " + colorOption.getVehicleImage());
				}
			}

	}

	@Given("I should get list of color image")
	public void i_should_get_list_of_color_image() throws IOException {

		for (Vehicle vehicle : responseBody.getData().getVehicles())
			for (ColorOption colorOption : vehicle.getColorOptions())
				assertEquals(JavaUtils.isUrlValid(colorOption.getColorIcon()), true);

	}

	@Then("registration Type should be fetched from DB")
	public void registration_Type_should_be_fetched_from_DB() {

		for (Vehicle vehicle : responseBody.getData().getVehicles()) {
			if (null != vehicle.getRegistrationType() && !vehicle.getRegistrationType().isEmpty())
				assertEquals(vehicle.getRegistrationType(), Query.GET_REGISTRATION_TYPE(vehicle.getCategoryId()));
		}
	}

	@Then("channel Type should be fetched from DB")
	public void channel_Type_should_be_fetched_from_DB() {

		for (Vehicle vehicle : responseBody.getData().getVehicles()) {
			if (null != vehicle.getChannelType() && !vehicle.getChannelType().isEmpty())
				assertEquals(vehicle.getChannelType(),
						Query.GET_CHANNEL_NAME(vehicle.getVariantCode(), vehicle.getDesc()));
		}
	}

	@Then("body Type should be fetched from DB")
	public void body_Type_should_be_fetched_from_DB() {

		for (Vehicle vehicle : responseBody.getData().getVehicles()) {
			if (null != vehicle.getBodyType() && !vehicle.getBodyType().isEmpty())
				assertEquals(vehicle.getBodyType(),
						Query.GET_BODY_TYPE(vehicle.getVariantCode(), vehicle.getDesc()));
		}
	}

	@Then("fuel Type should be fetched from DB")
	public void fuel_Type_should_be_fetched_from_DB() {

		for (Vehicle vehicle : responseBody.getData().getVehicles()) {
			if (null != vehicle.getFuelType() && !vehicle.getFuelType().isEmpty())
				assertEquals(vehicle.getFuelType(),
						Query.GET_FUEL_TYPE(vehicle.getVariantCode(), vehicle.getDesc()));
		}
	}

	@Then("transmission Type should be fetched from DB")
	public void transmission_Type_should_be_fetched_from_DB() {

		for (Vehicle vehicle : responseBody.getData().getVehicles()) {
			if (null != vehicle.getTransmissionType() && !vehicle.getTransmissionType().isEmpty())
				assertEquals(vehicle.getTransmissionType(),
						Query.GET_TRANSMISSION_TYPE(vehicle.getVariantCode(), vehicle.getDesc()));
		}
	}

}
