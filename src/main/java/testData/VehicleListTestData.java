package testData;

import com.opencsv.bean.CsvBindByName;

public class VehicleListTestData {
	
	public VehicleListTestData() {
		// TODO Auto-generated constructor stub
	}

	@CsvBindByName
	private int cityId;

	@CsvBindByName
	private int tenureId;

	@CsvBindByName
	private boolean isNew;

	@CsvBindByName
	private String resolution;

	public int getCityId() {
		return cityId;
	}

	public int getTenureId() {
		return tenureId;
	}

	public boolean getIsNew() {
		return isNew;
	}

	public String getResolution() {
		return resolution;
	}

}
