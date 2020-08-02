package pojo.fetchDealerList;

import java.util.List;

public class DealerList {
	private Integer id;
	private String type;
	private String name;
	private String code;
	private String nameAlias;
	private String roleCode;
	private String roleName;
	private String email;
	private String phone;
	private List<Attribute> attributes = null;
	private List<Address> address = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public DealerList() {
	}

	/**
	 *
	 * @param code
	 * @param address
	 * @param nameAlias
	 * @param phone
	 * @param roleCode
	 * @param name
	 * @param roleName
	 * @param attributes
	 * @param id
	 * @param type
	 * @param email
	 */
	public DealerList(Integer id, String type, String name, String code, String nameAlias, String roleCode,
			String roleName, String email, String phone, List<Attribute> attributes, List<Address> address) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.code = code;
		this.nameAlias = nameAlias;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.email = email;
		this.phone = phone;
		this.attributes = attributes;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameAlias() {
		return nameAlias;
	}

	public void setNameAlias(String nameAlias) {
		this.nameAlias = nameAlias;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
