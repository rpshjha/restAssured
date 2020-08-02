package pojo.carListing;

import java.util.List;

public class VehicleListRequest {
	private Filter filter;
	private Sort sort;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public VehicleListRequest() {
	}

	/**
	 *
	 * @param filter
	 * @param sort
	 */
	public VehicleListRequest(Filter filter, Sort sort) {
		super();
		this.filter = filter;
		this.sort = sort;
	}

	public VehicleListRequest(Filter filter) {
		super();
		this.filter = filter;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
