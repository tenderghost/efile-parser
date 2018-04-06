package com.pfcook.efileparser.data;

/**
 * True data section in data block, it has 3 types: tables, single column, multiple columns.
 * 
 * @author LENOVO
 *
 */
public class ELangDataSection {
	public static final char DATA_TYPE_TABLE = 'T';
	public static final char DATA_TYPE_SINGLE_COLUMN = 'S';
	public static final char DATA_TYPE_MULTI_COLUMN = 'M';
}
