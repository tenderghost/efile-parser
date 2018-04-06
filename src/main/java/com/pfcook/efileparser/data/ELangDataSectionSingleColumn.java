package com.pfcook.efileparser.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents single column data section, format is:<pre>
 * @ 序号 属性名 属性值
 * # 1  属性1   值1
 * ...
 * </pre>
 * @author LENOVO
 *
 */
public class ELangDataSectionSingleColumn {
	private static final String DATA_HEADER_TEMPLATE = "@@ %s %s %s";
	private static final String DATA_ROW_TEMPLATE = "# %s %s '%s'";
	
	private String indexColumnName = "序号";
	private String keyColumnName   = "属性名";
	private String valueColumnName = "属性值";
	
	private List<KeyValuePair> dataList = new ArrayList<KeyValuePair>();
	
	public void addData(String key, String value) {
		this.dataList.add(new KeyValuePair(key, value));
	}
	
	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		BufferedWriter bw = new BufferedWriter(sw);
		try {
			bw.write(String.format(DATA_HEADER_TEMPLATE, indexColumnName, keyColumnName, valueColumnName));
			bw.newLine();
			
			// write data list
			for(int i = 0; i < dataList.size(); i++) {
				KeyValuePair kvp = dataList.get(i);
				bw.write(String.format(DATA_ROW_TEMPLATE, i+1, kvp.key, kvp.value));
				bw.newLine();
			}
			
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
	
	/**
	 * A key-value pair
	 * @author LENOVO
	 *
	 */
	class KeyValuePair {
		private String key;
		private String value;
		
		public KeyValuePair(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		ELangDataSectionSingleColumn sc = new ELangDataSectionSingleColumn();
		sc.addData("接收单位", "南京供电公司");
		sc.addData("审核人", "张三");
		sc.addData("审核意见", "同意");
		sc.addData("审核环节", "运方专业");
		
		System.out.println(sc.toString());
	}
}
