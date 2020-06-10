package datafieldcreate;

public class Field {
	String enName;
	String cnName;
	String type;
	String defaultValue;
	String isNullValue;
	String description;
	public String getIsNullValue() {
		return isNullValue;
	}
	public void setIsNullValue(String isNullValue) {
		this.isNullValue = isNullValue;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
