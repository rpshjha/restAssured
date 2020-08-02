package testData;

import com.opencsv.bean.CsvBindByName;

public class ModelImageTestData {
	
	public ModelImageTestData() {
		// TODO Auto-generated constructor stub
	}

	@CsvBindByName
	private int xAppId;

	@CsvBindByName
	private int modelId;

	@CsvBindByName
	private String colorId;

	@CsvBindByName
	private String resolution;

	@CsvBindByName
	private String modelCd;

	@CsvBindByName
	private String variantCd;

	public int getxAppId() {
		return xAppId;
	}

	public int getModelId() {
		return modelId;
	}

	public String getColorId() {
		return colorId;
	}

	public String getResolution() {
		return resolution;
	}

	public String getModelCd() {
		return modelCd;
	}

	public String getVariantCd() {
		return variantCd;
	}

}
