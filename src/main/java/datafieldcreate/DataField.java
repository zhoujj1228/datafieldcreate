package datafieldcreate;

import java.util.ArrayList;
import java.util.List;

public class DataField {
	String domainEnName;
	String domainCnName;
	String addLink;
	String updateLink;
	List<Field> fieldList = new ArrayList<>();
	
	public void addDataField(Field df) {
		fieldList.add(df);
	}
	
	public String getAddLink() {
		return addLink;
	}

	public void setAddLink(String addLink) {
		this.addLink = addLink;
	}

	public String getUpdateLink() {
		return updateLink;
	}

	public void setUpdateLink(String updateLink) {
		this.updateLink = updateLink;
	}

	public String getDomainEnName() {
		return domainEnName;
	}
	public void setDomainEnName(String domainEnName) {
		this.domainEnName = domainEnName;
	}
	public String getDomainCnName() {
		return domainCnName;
	}
	public void setDomainCnName(String domainCnName) {
		this.domainCnName = domainCnName;
	}
	public List<Field> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}
	
	
	
}
