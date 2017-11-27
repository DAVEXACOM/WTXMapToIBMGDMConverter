/**********************************************************************
* IBM Confidential
*
* OCO Source Materials
*
* (C) Copyright IBM Corp. 2012  All Rights Reserved.
*
* The source code for this program is not published or otherwise  
* divested of its trade secrets, irrespective of what has been 
* deposited with the U.S. Copyright Office.
**********************************************************************/
package com.ibm.dfdljaxb.gdmgen;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


import javax.xml.datatype.XMLGregorianCalendar;

import com.ibm.dfdl.processor.IDFDLDocHandler;
import com.ibm.dfdl.processor.types.DFDLBOMType;
import com.ibm.dfdl.processor.types.DFDLSchemaType;
import com.ibm.dictionary.DictionaryCSV;
import com.ibm.dictionary.DictionaryCSV.SubstMapping;

/**
 * Example implementation of the DFDL IDFDLDocHandler interface.
 * 
 * This simple implementation prints to stdout on each call. A realistic use 
 * would build an appropriate data structure from the information received. 
 */

public class PrintDocHandler implements IDFDLDocHandler {
	
	
	// - static string values for the fields
	private static final String DictionaryCSV_s = "DictionaryCSV";
	private static final String MAPDef_s = "MAPDef";
	private static final String src_schema_s = "src_schema";
	private static final String src_message_s = "src_message";
	private static final String src_parser_s = "src_parser";
	private static final String trg_schema_s = "trg_schema";
	private static final String trg_message_s = "trg_message";
	private static final String trg_parser_s = "trg_parser";
	private static final String src_field_s = "src_field";
	private static final String trg_field_s = "trg_field";
	private static final String spare1_s = "spare1";
	private static final String spare2_s = "spare2";
	private static final String description_s = "description";
	
	String context = ""; //@PJ - This keeps a placeholder for the field we have just parsed.....
	
	
	String value = "";
		
	
	public DictionaryCSV csvModel;
	
	public PrintDocHandler(){
		// No implementation required
	}
	
	DictionaryCSV myCSV = null; //@PJ -  this is the JAXB model we will populate
	
	SubstMapping m = null;
	
	String myCSVvalue = null; //@DA
	
	public void elementValue(XMLGregorianCalendar value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
	}
	
	public DictionaryCSV getModel()
	{
		
		return this.csvModel;
	}

	
	public void elementValue(String value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");

		myCSVvalue = value.toString();
		System.out.println("myCSV: elementValue("+myCSVvalue+")");		
		// - set field values based on the 'context' of the parse....
		switch (context){
		 case src_schema_s:
			 csvModel.mapDef.setSrcSchema(value);
             break;
         case src_message_s:
        	 csvModel.mapDef.setSrcMessage(value);
             break;
         case src_parser_s:
        	 csvModel.mapDef.setSrcParser(value);
             break;
         case trg_schema_s:
        	 csvModel.mapDef.setTrgSchema(value);
             break;
         case trg_message_s:
        	 csvModel.mapDef.setTrgMessage(value);
             break;
         case trg_parser_s:
        	 csvModel.mapDef.setTrgParser(value);
             break; 
         case src_field_s:
        	 m.setSrcField(value);
             break;
         case trg_field_s:
             m.setTrgField(value);
             break;
         case spare1_s:
             m.setSpare1(value);
             break;
         case spare2_s:
             m.setSpare2(value);
             break;
         case description_s:
             m.setDescription(value);
             csvModel.substMapping.add(m); //@PJ This is the last field so add the mapping to the ArrayList
             break;
		}	
		
	}

	
	public void elementValue(int value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Integer(value).toString()+")");
	}

	
	public void elementValue(long value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Long(value).toString()+")");
	}

	
	public void elementValue(short value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Short(value).toString()+")");
	}

	
	public void elementValue(BigDecimal value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
	}

	
	public void elementValue(BigInteger value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
	}

	
	public void elementValue(float value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Float(value).toString()+")");
	}

	
	public void elementValue(double value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Double(value).toString()+")");
	}

	
	public void elementValue(boolean value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Boolean(value).toString()+")");
	}

	
	public void elementValue(byte value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Byte(value).toString()+")");
	}

	
	public void elementValue(byte[] value, DFDLSchemaType type) {		
		System.out.println("DocHandler: elementValue(" + new String(value).toString() +")");
	}
	
	
	public void elementNilValue() {
		System.out.println("DocHandler: elementValue is NIL");
	}

	
	public void endDocument(long byteOffset) {
		System.out.println("DocHandler: endDocument(" + byteOffset + ")");
	}

	
	public void endElement(long byteOffset) {
		System.out.println("DocHandler: endElement(" + byteOffset + ")");
	}

	
	public void startDocument(String dfdlVersion, String schema, DFDLBOMType unicodeByteOrderMark) {
		this.csvModel = new DictionaryCSV();
		
		
		System.out.println("DocHandler: startDocument("+dfdlVersion+", "+schema+", "+unicodeByteOrderMark+")");
		
	}	

	
	public void startElement(String name, String namespace, String elementSCD, long byteOffset) {
		
		//@PJ - The start Element event gives us a way to set the context for the next 'field value' event
		//@PJ - and to initialise the internal JAXB objects as necessary
		  switch (name) {
	         case DictionaryCSV_s:
	             csvModel.mapDef = new DictionaryCSV.MAPDef();
	             csvModel.substMapping = new ArrayList<DictionaryCSV.SubstMapping>();
	             
	             break;
	         case src_schema_s:
	             context = src_schema_s;
	             break;
	         case src_message_s:
	             context = src_message_s;
	             break;
	         case src_parser_s:
	             context = src_parser_s;
	             break;
	         case trg_schema_s:
	             context = trg_schema_s;
	             break;
	         case trg_message_s:
	             context = trg_message_s;
	             break;
	         case src_field_s:
	        	 m = new SubstMapping(); //@PJ Source Field is the first field so create a new mapping
	             context = src_field_s;
	             break;
	         case trg_field_s:
	             context = trg_field_s;
	             break;
	         case spare1_s:
	             context = spare1_s;
	             break;
	         case spare2_s:
	             context = spare2_s;
	             break;
	         case description_s:
	             context = description_s;
	             break;
	         case trg_parser_s:
	             context = trg_parser_s;
	             break;
		  }
		
		System.out.println("DocHandler: startElement(name:'"+name+"' namespace:'"+namespace+"' offset:" + byteOffset + ")");
	}

}
