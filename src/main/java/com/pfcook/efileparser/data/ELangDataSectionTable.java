package com.pfcook.efileparser.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ELangDataSectionTable {
	private List<String> columnNames = new ArrayList<String>(5);
	private List<ELangDataRow> dataRows = new ArrayList<ELangDataRow>(5);
	
	/**
	 * Default constructor.
	 * <b>NOTE:<b> this default constructor will add the first column "序号" by default as it's so common.
	 */
	public ELangDataSectionTable() {
		appendColumn("序号");
	}
	
	/**
	 * Check if the column exists
	 * @param columnName
	 * @return true if the column is exists, otherwise false.
	 */
	public boolean isColumnExists(String columnName) {
		return this.columnNames.contains(columnName);
	}
	
	/**
	 * Append new column to this data table.
	 * @param columnName
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 * @see java.util.List#add()
	 */
	public boolean appendColumn(String columnName) {
		return columnNames.add(columnName);
	}
	
	/**
	 * Create a data row for client to fill data.
	 */
	public ELangDataRow createRow() {
		// TODO how to check if a user fill all the columns of the data, in other words, how to ensure data integrity?
		ELangDataRow dataRow = new ELangDataRow(this);
		
		this.dataRows.add(dataRow);
		
		return dataRow;
	}
	
	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		BufferedWriter bw = new BufferedWriter(sw);
		
		try {
			// Write Columns, eg. @ 序号 属性名1 属性名2 属性名3
			bw.write("@ ");
			for (String columnName: columnNames) {
				bw.write(columnName);
				bw.write(" ");
			}
			bw.newLine();
			bw.flush();
			
			
			// Write Rows
			for (int i = 0; i < this.dataRows.size(); i++) {
				bw.write("# ");
				
				ELangDataRow dataRow = this.dataRows.get(i);
				for (String columnName: columnNames) {
					bw.write(dataRow.getValue(columnName));
					bw.write(" ");
				}
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sw.toString();
	}

	public static void main(String[] args) {
		ELangDataSectionTable dataTable = new ELangDataSectionTable();
		dataTable.appendColumn("发令单位");
		dataTable.appendColumn("发令时间");
		dataTable.appendColumn("发令人");
		
		ELangDataRow dataRow = dataTable.createRow();
		dataRow.setValue("序号", "1");
		dataRow.setValue("发令单位", "单位1");
		dataRow.setValue("发令时间", "2018-03-21");
		dataRow.setValue("发令人", "张三");
		
		String str = dataTable.toString();
		System.out.println(str);
	}
}
