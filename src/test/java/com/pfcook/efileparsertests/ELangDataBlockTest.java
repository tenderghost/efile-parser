package com.pfcook.efileparsertests;

import com.pfcook.efileparser.ELangDataBlock;

public class ELangDataBlockTest {

	public static void main(String[] args) {
		ELangDataBlock edb = new ELangDataBlock();
		edb.setTypeName("�����ģ��");
		edb.setEntityName("ҵ���");
		
		String str = edb.toString();
		System.out.println(str);
	}
}
