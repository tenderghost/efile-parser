package com.pfcook.efileparser.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.pfcook.efileparser.ELangDataBlock;

public class ELangDataBlockTest {
	
	@Test
	public void testToString() {
		ELangDataBlock edb = new ELangDataBlock();
		edb.setTypeName("月度停电检修计划流程");
		edb.setEntityName("调度审批");
		
		String str = edb.toString();
		
		boolean contains = str.contains("<月度停电检修计划流程::调度审批>");
		assertTrue(contains);
	}
}
