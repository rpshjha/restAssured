package pojo.categories;

public class CategoryDetermination {

	private Integer id;
	private String attribute;
	private String operator;
	private String start;
	private String end;
	private Boolean active;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public CategoryDetermination() {
	}

	/**
	 *
	 * @param start
	 * @param active
	 * @param end
	 * @param id
	 * @param attribute
	 * @param operator
	 */
	public CategoryDetermination(Integer id, String attribute, String operator, String start, String end,
			Boolean active) {
		super();
		this.id = id;
		this.attribute = attribute;
		this.operator = operator;
		this.start = start;
		this.end = end;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
