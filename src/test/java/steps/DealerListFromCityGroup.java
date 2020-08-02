package steps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import apiEngine.EndPoints;
import apiEngine.RequestBuilder;
import apiEngine.RestResponse;
import cucumber.TestContext;
import data.Query;
import enums.RequestType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.fetchDealerList.City;
import pojo.fetchDealerList.DealerList;
import pojo.fetchDealerList.DealerListResponse;
import pojo.fetchDealerList.Detail;

public class DealerListFromCityGroup {

	public DealerListFromCityGroup(TestContext testContext) {
		this.testContext = testContext;
	}

	private static Response response;
	private DealerListResponse responseBody;

	private TestContext testContext;

	@Given("^I perform GET operation for dealer list$")
	public void hitApiForDealerList() {
		RequestBuilder.setAppID("1");
		response = RequestBuilder.createRequest(RequestType.GET, EndPoints.getDealerlistFromCityGp());
		responseBody = new RestResponse<>(DealerListResponse.class, response).getBody();
	}

	@Then("^dealer list should be fetched by cityGroupId {int}$")
	public void dealer_list_should_be_fetched_by_cityGroupId(Integer cityGroupID) {

		List<String> dealerList = new ArrayList<String>();

		for (Detail temp : responseBody.getData().getDetails()) {

			for (City temp1 : temp.getCities()) {

				for (DealerList temp2 : temp1.getDealerList()) {

					dealerList.add(temp2.getNameAlias());
				}
			}
		}
		
		Assert.assertEquals(dealerList.size(), Query.GET_PARTNER_NAME_BY_CITY_GROUP_ID(cityGroupID));
	}

}
