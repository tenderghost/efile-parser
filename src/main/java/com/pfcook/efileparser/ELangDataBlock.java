package com.pfcook.efileparser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Basic data organization unit in E language <br/>
 * 
 * <类名::实体名>
 * 
 * </类名::实体名>
 * 
 * @author LENOVO
 *
 */
public class ELangDataBlock {
	/**
	 * type name of data block is MUST have.
	 */
	private String typeName;
	
	/**
	 * entity name of data block is OPTIONAL.
	 */
	private String entityName;
	
	
	
	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public String getEntityName() {
		return entityName;
	}



	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String toString() {
		StringWriter sw = new StringWriter();
		
		BufferedWriter bw = new BufferedWriter(sw);
		
		String dataBlockName = entityName == null ? typeName : typeName + "::" + entityName;
		
		try {
			bw.write(String.format("<%s>", dataBlockName));
			bw.newLine();
			
			bw.write(String.format("</%s>", dataBlockName));
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sw.toString();
	}
}
