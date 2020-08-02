package pojo.vehicleAttributeMaster;

public class ChannelType {
	private String channelType;
	private String description;
	private Integer createdDate;
	private Object modifiedDate;
	private Object createdBy;
	private Object modifiedBy;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ChannelType() {
	}

	/**
	 *
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param description
	 * @param channelType
	 * @param modifiedBy
	 */
	public ChannelType(String channelType, String description, Integer createdDate, Object modifiedDate,
			Object createdBy, Object modifiedBy) {
		super();
		this.channelType = channelType;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
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

	public Object getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Object modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Object getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Object createdBy) {
		this.createdBy = createdBy;
	}

	public Object getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Object modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
