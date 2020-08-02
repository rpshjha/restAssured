package commonUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;
import static org.testng.Assert.assertEquals;

public class JavaUtils {

	private static Logger log = Logger.getLogger(JavaUtils.class);

	/**
	 * 
	 * checks if given list is ascending order
	 * 
	 * @param list
	 * @return {@link Boolean}
	 */
	public static boolean isSortedAscending(List<Double> list) {

		log.info("checking if provided list is in ascending order");
		addTestStepLog("checking if provided list is in ascending order");
		boolean sorted = true;

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) <= (list.get(i)))
				sorted = true;
			else
				return false;
		}
		return sorted;
	}

	/**
	 * checks if given list is in descending order
	 * 
	 * @param list
	 * @author rupeshkumar02
	 * @return {@link Boolean}
	 */
	public static boolean isSortedDescending(List<Double> list) {

		log.info("checking if provided list is in descending order");
		addTestStepLog("checking if provided list is in descending order");
		boolean sorted = true;

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) >= (list.get(i)))
				sorted = true;
			else
				return false;
		}
		return sorted;
	}

	public static boolean isUrlValid(String url) {
		System.out.println("verifying url is valid =>\n" + url + "\n ");
		/* Try creating a valid URL */
		try {
			new URL(url).toURI();
			URL obj = new URL(url);
			// Opening a connection
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			// Sending the request
			conn.setRequestMethod("GET");
			int response = conn.getResponseCode();
			assertEquals(response, 200);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
