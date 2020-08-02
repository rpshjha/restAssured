package data;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Query {

	public static String GET_OTP(String mobileOrEmail) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		String query;

		if (mobileOrEmail.matches("\\d{10}"))
			query = "SELECT OTP from public.user_mobile_otp_history where mobile_no ='" + mobileOrEmail
					+ "' ORDER BY created_date DESC limit 1";
		else
			query = "SELECT OTP from public.user_mobile_otp_history where mobile_no ='" + mobileOrEmail
					+ "' ORDER BY created_date DESC limit 1";

		return DBUtils.getData(Database.COMMON_USER_MANAGEMENT, query);
	}

	public static void RESET_OTP_ATTEMPT_COUNTER(String mobileno) {
		String query = "update user_mobile_otp set attempt_counter = 0 where user_mobile_otp.mobile_no = '" + mobileno
				+ "'";
		DBUtils.executeQuery(Database.COMMON_USER_MANAGEMENT, query);
	}

	public static String GET_TENURE_VALUE(int tenure) {
		String query = "SELECT value from tenure_v2 where id = " + tenure + "";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static Map<String, String> GET_SPECIFICATIONS(String carName) {

		String query = "select DISTINCT model_attributes_v2.attr_label, model_attributes_v2.attr_value from model_attributes_v2 "
				+ "left join whitelist_reference_model_v2 on model_attributes_v2.reference_model_fkid =whitelist_reference_model_v2.id "
				+ "where whitelist_reference_model_v2.variant_desc = '" + carName + "' "
				+ "and model_attributes_v2.attr_type = 'Specifications'";

		return DBUtils.getDataInMap(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query, "attr_label", "attr_value");
	}

	public static Map<String, String> GET_OVERVIEW(String carName) {

		String query = "select DISTINCT model_attributes_v2.attr_label, model_attributes_v2.attr_value from model_attributes_v2 "
				+ "left join whitelist_reference_model_v2 on model_attributes_v2.reference_model_fkid =whitelist_reference_model_v2.id "
				+ "where whitelist_reference_model_v2.variant_desc = '" + carName + "' "
				+ "and model_attributes_v2.attr_type = 'Overview'";

		return DBUtils.getDataInMap(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query, "attr_label", "attr_value");
	}

	public static Map<String, Map<String, String>> GET_FEATURES(String carName) {

		String query = "select DISTINCT model_attributes_v2.attrparent_label, model_attributes_v2.attr_label, model_attributes_v2.attr_value from model_attributes_v2 "
				+ "left join whitelist_reference_model_v2 on model_attributes_v2.reference_model_fkid =whitelist_reference_model_v2.id "
				+ "where whitelist_reference_model_v2.variant_desc = '" + carName + "' "
				+ "and model_attributes_v2.attr_type = 'Features'";

		return DBUtils.getDataInMap(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query, "attrparent_label", "attr_label",
				"attr_value");
	}

	public static String GET_VARIANT_CD_FROM_CAR_NAME(String carName) {

		String query = "SELECT whitelist_reference_model_v2.variant_cd "
				+ "FROM public.whitelist_reference_model_v2 where variant_desc like '%" + carName + "%'";

		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static Float GET_PRICE_OF_CAR_BY_TENURE(String carName, int tenure) {

		String variantCd = GET_VARIANT_CD_FROM_CAR_NAME(carName);

		String query = "select DISTINCT category_models.tenure_id, price_details.price_per_month from price_details "
				+ "left join category_models ON category_models.id = price_details.category_model_id where "
				+ "price_details.valid_from < now() " + "and price_details.valid_to > now() "
				+ "and price_details.is_active = true " + "and category_models.variant_cd = '" + variantCd + "'";

		try {
			Float price = Float.valueOf(DBUtils.getDataInMap(Database.PAYMENT, query, "tenure_id", "price_per_month")
					.get(GET_TENURE_VALUE(tenure)));
//			return Math.round(price);
			return price;
		} catch (NullPointerException e) {
			return 0f;
		}
	}

	public static Set<String> GET_TENURE_OFFERED(String carName) {
		String variantCd = GET_VARIANT_CD_FROM_CAR_NAME(carName);

		String query = "select DISTINCT category_models.tenure_id, price_details.price_per_month from price_details "
				+ "left join category_models ON category_models.id = price_details.category_model_id where "
				+ "price_details.valid_from < now() " + "and price_details.valid_to > now() "
				+ "and price_details.is_active = true " + "and category_models.variant_cd = '" + variantCd + "'";

		return DBUtils.getDataInMap(Database.PAYMENT, query, "tenure_id", "price_per_month").keySet();
	}

	public static String GET_DISCOUNT_ON_CAR_BY_TENURE(String carName, int tenure) {
		String variantCd = GET_VARIANT_CD_FROM_CAR_NAME(carName);

		String query = "select DISTINCT category_models.tenure_id, discount_details.discount_value, discount_details.discount_type from price_details left join category_models ON category_models.id = price_details.category_model_id right join discount_details ON discount_details.category_models_fkid = price_details.category_model_id where price_details.valid_from < now() and price_details.valid_to > now() and price_details.is_active = true and discount_details.valid_from < now() and discount_details.valid_to > now() and discount_details.is_active = true and category_models.variant_cd = '"
				+ variantCd + "'";

		try {
			Float discount = Float.valueOf(
					DBUtils.getDataInMap(Database.PAYMENT, query, "tenure_id", "discount_type", "discount_value")
							.get(GET_TENURE_VALUE(tenure)).values().stream().findFirst().get());
//			return Math.round(discount);
			// return discount;
			return String.valueOf(discount);
		} catch (NullPointerException e) {
//			return 0f;
			return "";
		}
	}

	public static String GET_DISCOUNT_TYPE(String carName, int tenure) {

		String variantCd = GET_VARIANT_CD_FROM_CAR_NAME(carName);

		String query = "select DISTINCT category_models.tenure_id, discount_details.discount_value, discount_details.discount_type from price_details left join category_models ON category_models.id = price_details.category_model_id right join discount_details ON discount_details.category_models_fkid = price_details.category_model_id where price_details.valid_from < now() and price_details.valid_to > now() and price_details.is_active = true and discount_details.valid_from < now() and discount_details.valid_to > now() and discount_details.is_active = true and category_models.variant_cd = '"
				+ variantCd + "' and category_models.tenure_id = '" + tenure + "'";

		try {
			return DBUtils.getDataInMap(Database.PAYMENT, query, "tenure_id", "discount_type", "discount_value")
					.get(GET_TENURE_VALUE(tenure)).keySet().stream().findFirst().get();
		} catch (NullPointerException e) {
			return "";
		}
	}

	public static String GET_CAT_NAME_BY_CAT_ID(int catID) {

		String query = "select name from category_master where id = " + catID + "";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static Integer GET_TENURE_START_BY_CAT_ID(int catID) {
		String query = "select tenure_start from category_master where id = " + catID + "";
		return Integer.valueOf(DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query));
	}

	public static int GET_TENURE_END_BY_CAT_ID(int catID) {
		String query = "select tenure_end from category_master where id = " + catID + "";
		return Integer.valueOf(DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query));
	}

	public static boolean GET_IS_NEW_TYPE_FROM_CATEGORY_ID(int catID) {
		String query = "select is_new from category_master where id = " + catID + "";
		return Boolean.valueOf(DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query));
	}

	public static List<String> GET_ALL_MODEL_CD() {
		String query = "select distinct whitelist_reference_model_v2.model_cd from whitelist_reference_model_v2";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_MODEL_DESC() {
		String query = "select distinct whitelist_reference_model_v2.model_desc from whitelist_reference_model_v2 ";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_VARIANT_CD() {
		String query = "select distinct whitelist_reference_model_v2.variant_cd from whitelist_reference_model_v2";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_COLOR_CD() {
		String query = "select distinct color_v2.ecolor_cd from color_v2";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_BODY_TYPE() {
		String query = "select distinct body_type_v2.body_cd from body_type_v2";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_CHANNEL_TYPE() {
		String query = "select distinct channel_type.channel_type from channel_type";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_TRANSMISSION_TYPE() {
		String query = "select distinct transmission_cd from transmission_type_v2";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_ALL_REGISTRATION_TYPE() {
		String query = "select distinct registration_type.registration_type from registration_type";
		return DBUtils.getDataInList(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static String GET_REGISTRATION_TYPE(int categoryID) {
		String query = "SELECT start FROM public.category_determination where category_fkid = " + categoryID
				+ " and attribute = 'REG' and is_active = true";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static String GET_CHANNEL_NAME(String variant_cd, String manual_desc) {
		String query = "select distinct whitelist_reference_model_v2.channel from whitelist_reference_model_v2 where whitelist_reference_model_v2.variant_cd = '"
				+ variant_cd + "' and whitelist_reference_model_v2.manual_desc = '" + manual_desc + "'";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static String GET_BODY_TYPE(String variant_cd, String manual_desc) {
		String query = "select distinct whitelist_reference_model_v2.body_cd from whitelist_reference_model_v2 where whitelist_reference_model_v2.variant_cd = '"
				+ variant_cd + "' and whitelist_reference_model_v2.manual_desc = '" + manual_desc + "'";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static String GET_FUEL_TYPE(String variant_cd, String manual_desc) {
		String query = "select distinct whitelist_reference_model_v2.fuel_type_desc from whitelist_reference_model_v2 where whitelist_reference_model_v2.variant_cd = '"
				+ variant_cd + "' and whitelist_reference_model_v2.manual_desc = '" + manual_desc + "'";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static String GET_TRANSMISSION_TYPE(String variant_cd, String manual_desc) {
		String query = "select distinct whitelist_reference_model_v2.transmission_cd from whitelist_reference_model_v2 where whitelist_reference_model_v2.variant_cd = '"
				+ variant_cd + "' and whitelist_reference_model_v2.manual_desc = '" + manual_desc + "'";
		return DBUtils.getData(Database.SUBSCRIBE_VEHICLE_MANAGEMENT, query);
	}

	public static List<String> GET_PARTNER_NAME_BY_CITY_GROUP_ID(int cityGroupId) {
		String query = "select partner_master.name_alias from city_partner_mapping "
				+ "left join partner_master on partner_master.id = city_partner_mapping.partner_id "
				+ "where partner_master.partner_role_fkid = city_partner_mapping.partner_role "
				+ "and city_partner_mapping.city_group_id = " + cityGroupId + "";
		return DBUtils.getDataInList(Database.PARTNER_ACL, query);
	}

	public static void main(String[] args) {

		System.out.println(GET_PARTNER_NAME_BY_CITY_GROUP_ID(1));
	}

}
