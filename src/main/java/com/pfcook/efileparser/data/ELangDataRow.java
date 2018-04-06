package com.pfcook.efileparser.data;

import java.util.HashMap;
import java.util.Map;

/**
 * A row in data table.
 * @author pfcook
 * @see {@link ELangDataSectionTable}
 */
public class ELangDataRow {
	private ELangDataSectionTable parentDataTable;
	
	private Map<String, String> dataMap = new HashMap<String, String>();
	
	public ELangDataRow(ELangDataSectionTable parentDataTable) {
		this.parentDataTable = parentDataTable;
	}
	
	/**
	 * Set data to the new object.
	 * @param columnName
	 * @param value
	 * @throws ColumnNotDefinedException if columnName not exists.
	 */
	public void setValue(String columnName, String value) {
		if (!isColumnExists(columnName)) {
			// TODO I should define dedicate exception type for this library.
			throw new RuntimeException(String.format("Column [%s] not defined!", columnName));
		}
		
		this.dataMap.put(columnName, value);
	}
	
	/**
	 * Get data from row by columnName.
	 * @param columnName
	 * @return
	 */
	public String getValue(String columnName) {
		if (!isColumnExists(columnName)) {
			// TODO I should define dedicate exception type for this library.
			throw new RuntimeException(String.format("Column [%s] not defined!", columnName));
		}
		
		return this.dataMap.get(columnName);
	}
	
	private boolean isColumnExists(String columnName) {
		return this.parentDataTable.isColumnExists(columnName);
	}
}
