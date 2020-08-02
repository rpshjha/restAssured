package cucumber;

public class TestContext {

	private ScenarioContext scenarioContext;
	private ResponseHelper<Object> responseHelper;

	public TestContext() {
		this.scenarioContext = new ScenarioContext();
		this.responseHelper = new ResponseHelper<Object>();
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public ResponseHelper<Object> getResponseHelper() {
		return responseHelper;
	}

}
