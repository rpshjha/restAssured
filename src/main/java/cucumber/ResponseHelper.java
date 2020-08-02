package cucumber;

import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;

import enums.Responses;
import io.restassured.response.Response;

public class ResponseHelper<T> {

	private Map<Responses, Response> apiResponse = new Hashtable<Responses, Response>();
	private T data;
	private static Logger log = Logger.getLogger(ResponseHelper.class);

//	public ResponseHelper(Class<T> t) {
//		try {
//			this.data = t.newInstance();
//		} catch (Exception e) {
//			throw new RuntimeException("There should be a default constructor in the Response POJO");
//		}
//	}

//	public ResponseHelper() {
//		apiResponse = new Hashtable<Responses, Response>();
//	}

	public void setResponse(Responses key, Response value) {
		log.info("setting current response into test context");
		apiResponse.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public void setBody(Responses key, Response value) {
		this.data = (T) apiResponse.put(key, value);
	}

	public Response getResponse(Responses key) {
		return apiResponse.get(key);
	}

	@SuppressWarnings("unchecked")
	public T getBody(Responses key) {
		try {
			data = (T) apiResponse.get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
