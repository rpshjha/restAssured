package steps;

import static org.testng.Assert.assertEquals;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import commonUtils.JavaUtils;
import cucumber.TestContext;
import enums.RequestType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.modelImage.ModelImageDTOList;
import pojo.modelImage.ModelImageResponse;

public class ModelImageSteps {

	public ModelImageSteps(TestContext testContext) {
		this.testContext = testContext;
	}

	private static Response response;
	private ModelImageResponse responseBody;

	private TestContext testContext;

	@Given("^I perform GET operation for model image$")
	public void hitApiForCarImageVariant() {
		RequestBuilder.setAppID("1");
		response = RequestBuilder.createRequest(RequestType.GET, EndPoints.getModelVariantImages());
		responseBody = new RestResponse<>(ModelImageResponse.class, response).getBody();
	}

	@Then("I should get model imageUrl which are valid")
	public void i_should_get_imageUrl_which_are_valid() {

		for (ModelImageDTOList temp : responseBody.getData().getModelImageDTOList()) {
			assertEquals(JavaUtils.isUrlValid(temp.getImageUrl()), true);
		}

	}

}
