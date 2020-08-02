package pojo.vehicleAttributeMaster;

public class RegistrationType {

	private String registrationType;
	private String description;
	private Integer createdDate;
	private Integer modifiedDate;
	private String createdBy;
	private String modifiedBy;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RegistrationType() {
	}

	/**
	 *
	 * @param createdDate
	 * @param registrationType
	 * @param createdBy
	 * @param modifiedDate
	 * @param description
	 * @param modifiedBy
	 */
	public RegistrationType(String registrationType, String description, Integer createdDate, Integer modifiedDate,
			String createdBy, String modifiedBy) {
		super();
		this.registrationType = registrationType;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Integer modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
