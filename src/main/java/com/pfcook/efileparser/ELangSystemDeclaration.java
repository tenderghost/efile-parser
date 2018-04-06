package com.pfcook.efileparser;

/**
 * Represents a system declaration in E language. <br />
 * eg. <code>&lt;!System=OMS Version=1.0 Code=UTF-8 Data=1.0!&gt;<code>
 * @author pfcook.com
 */
public class ELangSystemDeclaration {
	private static final String SYSTEM_DECLARATION_TEMPLATE = "<!System=%s Version=%s Code=%s Data=%s!>";
	
	
	private String system = "OMS";
	private String version = "1.0";
	private String code = "UTF-8";
	private String data = "1.0";
		
	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format(SYSTEM_DECLARATION_TEMPLATE, system, version, code, data);
	}
}
