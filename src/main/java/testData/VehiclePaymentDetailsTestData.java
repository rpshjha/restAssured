package testData;

import com.opencsv.bean.CsvBindByName;

public class VehiclePaymentDetailsTestData {

	public VehiclePaymentDetailsTestData() {
		// TODO Auto-generated constructor stub
	}

	@CsvBindByName
	int cityId;
	@CsvBindByName
	String tenure;
	@CsvBindByName
	int id;
	@CsvBindByName
	String modelCode;
	@CsvBindByName
	String variantCode;
	@CsvBindByName
	String startDate;
	@CsvBindByName
	String endDate;
	@CsvBindByName
	boolean isPriceRequired;
	@CsvBindByName
	boolean isDiscountRequired;
	@CsvBindByName
	boolean isSecurityRequired;
	@CsvBindByName
	boolean isGSTRequired;
	@CsvBindByName
	String categories;

	public int getCityId() {
		return cityId;
	}

	public String getTenure() {
		return tenure;
	}

	public int getId() {
		return id;
	}

	public String getModelCode() {
		return modelCode;
	}

	public String getVariantCode() {
		return variantCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public boolean isPriceRequired() {
		return isPriceRequired;
	}

	public boolean isDiscountRequired() {
		return isDiscountRequired;
	}

	public boolean isSecurityRequired() {
		return isSecurityRequired;
	}

	public boolean isGSTRequired() {
		return isGSTRequired;
	}

	public String getCategories() {
		return categories;
	}

}
