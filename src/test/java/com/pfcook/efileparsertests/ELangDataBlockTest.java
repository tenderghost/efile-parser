package com.pfcook.efileparsertests;

import com.pfcook.efileparser.ELangDataBlock;

public class ELangDataBlockTest {

	public static void main(String[] args) {
		ELangDataBlock edb = new ELangDataBlock();
		edb.setTypeName("任务表单模型");
		edb.setEntityName("业务表单");
		
		String str = edb.toString();
		System.out.println(str);
	}
}
