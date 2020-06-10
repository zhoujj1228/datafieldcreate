package datafieldcreate;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import util.ExcelUtil;
import util.PathUtil;

public class DataFieldParser {
	static String excelPath = PathUtil.getProjectPath() + "/config/datafieldConfig.xlsx";
	public static HashMap<String, DataField> dataFieldMap = new DataFieldParser().parse(excelPath);
	
	public static void main(String[] args) {
		String excelPath = PathUtil.getProjectPath() + "/config/datafieldConfig.xlsx";
		new DataFieldParser().parse(excelPath);
	}
	
	public HashMap<String, DataField> parse(String excelPath) {
		HashMap<String, List<List<String>>> sheetNameMap = ExcelUtil.getSheetNameMapBy03OR07Excel(excelPath, 0, 0);
		Collection<List<List<String>>> values = sheetNameMap.values();
		HashMap<String, DataField> result = new HashMap<String, DataField>();
		
		for (List<List<String>> lists : values) {
			DataField domainConfig = new DataField();
			int enNameIndex = -1;
			int cnNameIndex = -1;
			int typeIndex = -1;
			int defaultValueIndex = -1;
			int isNullValueIndex = -1;
			int descriptionIndex = -1;
			boolean startItorDataField = false;
			for(List<String> list : lists) {
				//遍历到表名
				if(isDomainEnName(list)) {
					domainConfig.setDomainEnName(list.get(1));
				}
				//遍历到中文描述
				if(isDomainCnName(list)) {
					domainConfig.setDomainCnName(list.get(1));
				}
				//遍历到新增链接
				if(isAddLink(list)) {
					domainConfig.setAddLink(list.get(1));
				}
				//遍历到新增链接
				if(isUpdateLink(list)) {
					domainConfig.setUpdateLink(list.get(1));
				}
				//遍历到字段标题
				if(isDataFieldTitle(list)) {
					enNameIndex = initEnNameIndex(list);
					cnNameIndex = initCnNameIndex(list);
					typeIndex = initTypeIndex(list);
					defaultValueIndex = initDefaultValueIndex(list);
					isNullValueIndex = initIsNullValueIndex(list);
					descriptionIndex = initDescriptionIndex(list);
					startItorDataField = true;
					continue;
				}
				//遍历到字段信息
				if(startItorDataField) {
					if(list == null || list.size() <= 0) {
						continue;
					}
					Field dataField = new Field();
					initDataField(enNameIndex, cnNameIndex, typeIndex, defaultValueIndex, isNullValueIndex,
							descriptionIndex, list, dataField);
					
					domainConfig.addDataField(dataField);
				}
			}
			
			
			result.put(domainConfig.getDomainEnName(), domainConfig);
		}
		return result;
	}

	private boolean isUpdateLink(List<String> list) {
		if(list == null || list.size() <= 0) {
			return false;
		}
		String tempStr = list.get(0);
		if(tempStr.contentEquals("更新链接")) {
			return true;
		}
	
		return false;
	}

	private boolean isAddLink(List<String> list) {
		if(list == null || list.size() <= 0) {
			return false;
		}
		String tempStr = list.get(0);
		if(tempStr.contentEquals("新增链接")) {
			return true;
		}
	
		return false;
	}

	private int initDescriptionIndex(List<String> list) {
		if(list == null || list.size() <= 0) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			String tempStr = list.get(i);
			if(tempStr.contentEquals("说明")) {
				return i;
			}
		}
		return -1;
	}

	private int initIsNullValueIndex(List<String> list) {
		if(list == null || list.size() <= 0) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			String tempStr = list.get(i);
			if(tempStr.contentEquals("非空")) {
				return i;
			}
		}
		return -1;
	}

	private int initDefaultValueIndex(List<String> list) {
		if(list == null || list.size() <= 0) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			String tempStr = list.get(i);
			if(tempStr.contentEquals("默认值")) {
				return i;
			}
		}
		return -1;
	}

	private int initTypeIndex(List<String> list) {
		if(list == null || list.size() <= 0) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			String tempStr = list.get(i);
			if(tempStr.contentEquals("类型")) {
				return i;
			}
		}
		return -1;
	}

	private int initCnNameIndex(List<String> list) {
		if(list == null || list.size() <= 0) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			String tempStr = list.get(i);
			if(tempStr.contentEquals("中文名称")) {
				return i;
			}
		}
		return -1;
	}

	private int initEnNameIndex(List<String> list) {
		if(list == null || list.size() <= 0) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			String tempStr = list.get(i);
			if(tempStr.contentEquals("字段名称")) {
				return i;
			}
		}
		return -1;
	}

	private boolean isDataFieldTitle(List<String> list) {
		if(list == null || list.size() <= 0) {
			return false;
		}
		String tempStr = list.get(0);
		if(tempStr.contentEquals("字段名称")) {
			return true;
		}
		return false;
	}

	private boolean isDomainCnName(List<String> list) {
		if(list == null || list.size() <= 0) {
			return false;
		}
		String tempStr = list.get(0);
		if(tempStr.contentEquals("中文描述")) {
			return true;
		}
	
		return false;
	}

	private boolean isDomainEnName(List<String> list) {
		if(list == null || list.size() <= 0) {
			return false;
		}
		String tempStr = list.get(0);
		if(tempStr.contentEquals("表名")) {
			return true;
		}
		return false;
	}

	private void initDataField(int enNameIndex, int cnNameIndex, int typeIndex, int defaultValueIndex, int isNullValueIndex,
			int descriptionIndex, List<String> list, Field dataField) {
		if(cnNameIndex > -1) {
			dataField.setCnName(list.get(cnNameIndex));
		}
		if(enNameIndex > -1) {
			dataField.setEnName(list.get(enNameIndex));
		}
		if(defaultValueIndex > -1) {
			dataField.setDefaultValue(list.get(defaultValueIndex));
		}
		if(descriptionIndex > -1) {
			dataField.setDescription(list.get(descriptionIndex));
		}
		if(isNullValueIndex > -1) {
			dataField.setIsNullValue(list.get(isNullValueIndex));
		}
		if(typeIndex > -1) {
			dataField.setType(list.get(typeIndex));
		}
	}
}
