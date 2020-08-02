package pojo.categories;

import java.util.List;

public class _3 {

	private Integer id;
	private String name;
	private Integer tenureStart;
	private Integer tenureEnd;
	private List<CategoryDetermination__> categoryDetermination = null;
	private Boolean active;
	private Boolean _new;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public _3() {
	}

	/**
	 *
	 * @param categoryDetermination
	 * @param tenureEnd
	 * @param tenureStart
	 * @param name
	 * @param active
	 * @param id
	 * @param _new
	 */
	public _3(Integer id, String name, Integer tenureStart, Integer tenureEnd,
			List<CategoryDetermination__> categoryDetermination, Boolean active, Boolean _new) {
		super();
		this.id = id;
		this.name = name;
		this.tenureStart = tenureStart;
		this.tenureEnd = tenureEnd;
		this.categoryDetermination = categoryDetermination;
		this.active = active;
		this._new = _new;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTenureStart() {
		return tenureStart;
	}

	public void setTenureStart(Integer tenureStart) {
		this.tenureStart = tenureStart;
	}

	public Integer getTenureEnd() {
		return tenureEnd;
	}

	public void setTenureEnd(Integer tenureEnd) {
		this.tenureEnd = tenureEnd;
	}

	public List<CategoryDetermination__> getCategoryDetermination() {
		return categoryDetermination;
	}

	public void setCategoryDetermination(List<CategoryDetermination__> categoryDetermination) {
		this.categoryDetermination = categoryDetermination;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getNew() {
		return _new;
	}

	public void setNew(Boolean _new) {
		this._new = _new;
	}

}
