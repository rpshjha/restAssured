package apiEngine;

import data.ConfigReader;
import enums.Environment;

public class EndPoints {

	private static String BASE_URL;
	private static String vehicleCategories = "/api/subscribe/vehicle/vehicle-categories";
	private static String priceFilter = "/api/common/getValueByKey";
	private static String send_otp = "/sendotp";
	private static String auth_token = "/api/account/otp/authtoken";
	private static String vehicleList = "/api/subscribe/vehicle/list";
//	private static String vehicleList = "/smp-external/api/subscribe/vehicle/list";
	private static String variantImages = "/api/subscribe/vehicle/variantimages";
	private static String vehicle_payment_details = "/payment/vehicle-payment-details";
	private static String vehicleAttributesMaster = "/api/subscribe/vehicle/vehicle-attributes-master";
	private static String whitelistModelMaster = "/api/subscribe/vehicle/whitelists/model-variant";
	private static String fetchDealerFromCityGp = "/api/partner/city-group-dealers?cityGroupId=1";

//	private static String serverToServerQAToken = 
//	private static String serverToServerPreprodToken = "https://msil-token-qa.auth.ap-south-1.amazoncognito.com/oauth2/token?grant_type=client_credentials&scope=subscribe-web/subscribe-web-scope";

	public static String getDealerlistFromCityGp() {
		return getBaseUrl() + fetchDealerFromCityGp;
	}

	public static String getWhitelistModelMaster() {
		return getBaseUrl() + whitelistModelMaster;
	}

	public static String getVehicleAttributesMaster() {
		return getBaseUrl() + vehicleAttributesMaster;
	}

	public static String getVehicleCategories() {
		return getBaseUrl() + vehicleCategories;
	}

	public static String getPriceFilter() {
		return getBaseUrl() + priceFilter;
	}

	public static String getSendOtp() {
		return getBaseUrl() + send_otp;
	}

	public static String getAuthToken() {
		return getBaseUrl() + auth_token;
	}

	public static String getVehicleListing() {
		return getBaseUrl() + vehicleList;
	}

	public static String getModelVariantImages() {
		return getBaseUrl() + variantImages;
	}

	public static String getVehiclePaymentDetails() {
		return getBaseUrl() + vehicle_payment_details;
	}

	public static String getBaseUrl() {

		switch (ConfigReader.getProperty("environment")) {
		case Environment.DEV:
			BASE_URL = ConfigReader.getProperty("api_dev");
			break;
		case Environment.QA:
			BASE_URL = ConfigReader.getProperty("api_qa");
			break;
		case Environment.PREPROD:
			BASE_URL = ConfigReader.getProperty("api_preprod");
			break;
		case Environment.PROD:
			BASE_URL = ConfigReader.getProperty("api_prod");
			break;
		default:
			System.err.println("please specify environment as DEV, QA or PREPROD");
			BASE_URL = null;
			break;
		}

		return BASE_URL;
	}

}