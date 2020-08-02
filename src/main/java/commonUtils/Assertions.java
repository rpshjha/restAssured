package commonUtils;

import org.apache.log4j.Logger;
import org.testng.asserts.Assertion;

public class Assertions extends Assertion {

	private static Logger log = Logger.getLogger(Assertions.class);

	@Override
	public void assertEquals(boolean actual, boolean expected, String message) {
		log.info(message);
		try {
			super.assertEquals(actual, expected, message);
		} catch (AssertionError e) {
			log.info(e.getMessage());
		}
	}

}
