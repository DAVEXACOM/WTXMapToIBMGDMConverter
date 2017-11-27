package com.ibm.dfdljaxb.gdmgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.ByteArrayOutputStream;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import com.ibm.msl.Cast;
import com.ibm.msl.Documentation;
import com.ibm.msl.Generation;
import com.ibm.msl.Import;
import com.ibm.msl.Imports;
import com.ibm.msl.MappingDeclaration;
import com.ibm.msl.MappingDesignator;
import com.ibm.msl.MappingRoot;
import com.ibm.msl.Move;
import com.ibm.msl.Assign;
import com.ibm.msl.Function;
import com.ibm.msl.Namespace;
import com.ibm.msl.Namespaces;
import com.ibm.msl.ObjectFactory;
import com.ibm.msl.Param;
import com.ibm.msl.Task;
import com.ibm.msl.Variable;

import javax.xml.namespace.QName;

import com.ibm.dfdl.grammar.DFDLGrammarFactory;
import com.ibm.dfdl.grammar.IDFDLGrammar;
import com.ibm.dfdl.processor.DFDLProcessorFactory;
import com.ibm.dfdl.processor.IDFDLDocHandler;
import com.ibm.dfdl.processor.IDFDLErrorHandler;
import com.ibm.dfdl.processor.IDFDLParser;
import com.ibm.dfdl.processor.IDFDLProcessor;
import com.ibm.dfdl.processor.IDFDLProcessorErrorHandler;
import com.ibm.dfdl.processor.IDFDLRegionHandler;
import com.ibm.dfdl.processor.exceptions.DFDLException;
import com.ibm.dfdl.processor.exceptions.DFDLNotRecognizedException;
import com.ibm.dfdl.processor.trace.IDFDLUserTraceListener;
import com.ibm.dfdl.processor.types.DFDLBOMType;


import com.ibm.dictionary.*;

public class ParseDictionary {

	/**
	 * @param args 
	 */
	PrintDocHandler docHandler = null; // Get visibility of the docHandler outside of the Main Method

//@DAWTX	
//@DAWTX - need to rewrite this and the DFDL model and the CSV as a substitution dictionary
//@DAWTX - and won't need the MSL generation part as ParseWTXXMLSerialMSL.java will do that	
	public static void main(String[] args) throws URISyntaxException, IOException {
		
		/*
		 * Construct a grammar from a schema file with DFDL annotations 
		 */
		
		ParseDictionary metaData = new ParseDictionary(); // Give us a handle for access to the class variables
		
		System.out.println("Building grammar");
		System.out.println("----------------");
		IDFDLErrorHandler grammarErrorHandler = new PrintErrorHandler();
		DFDLGrammarFactory grammarFactory = new DFDLGrammarFactory();
		grammarFactory.setErrorHandler(grammarErrorHandler);
		
		URI schemaUri = new URI("./DictionaryCSV.xsd"); //@DAinput1
		
		IDFDLGrammar grammar=null;
		try {
			grammar = grammarFactory.buildGrammarFromSchema(schemaUri, null);			
		} catch (DFDLException e) {
			System.err.println("DFDL Exception building schema: " + e.getMessage() );
			System.exit(1);
		} 
		
		/*
		 * Construct a DFDL Parser
		 */
		System.out.println("\nConstructing and initialising Parser");
		System.out.println("------------------------------------");
		DFDLProcessorFactory processorFactory = new DFDLProcessorFactory();
		IDFDLParser parser = processorFactory.createParser();
		
		
		/* 
		 * set required Parser properties
		 */
		
		// set grammar
		parser.setGrammar(grammar);
		
		// set root element
		parser.setRootElement("DictionaryCSV", null); //@DAinput2
		
		// set document to parse - the CSV file containing our mapping meta-data
		File inputFile = new File("DictionaryMeta.csv"); //@DAinput3
		InputStream documentInputStream = null;
		try {
			documentInputStream = new FileInputStream(inputFile);
			documentInputStream.mark(Integer.MAX_VALUE);
		} catch (FileNotFoundException fnf) {
			System.err.println("Document file "+inputFile+" not found: "+fnf.getMessage());
			System.exit(1);
		}
		
		try {
			parser.setInputDocument(documentInputStream, false);
		} catch (DFDLException e) {
			System.err.println("DFDLException setting document: " + e.getMessage() );
			System.exit(1);
		}
		
		
		/*
		 * set desired Parser handlers
		 */
		
		// set document handler
		metaData.docHandler = new PrintDocHandler(); //@PJ Create a new instance of the doc handler - this gives us
		// access to the internal IOMapModelMetaCSV object which is being created in the PrintDocHandler Class
		parser.setDocumentHandler(metaData.docHandler);
		
		// set error handler
		IDFDLProcessorErrorHandler errorHandler = new PrintErrorHandler();
		parser.setErrorHandler(errorHandler);
		
		// set region handler
		// Note: uncomment to see region handler output - this is quite verbose 
		//IDFDLRegionHandler regionHandler = new PrintRegionHandler();
		//parser.setRegionHandler(regionHandler);
		
		// add a trace listener
		IDFDLUserTraceListener traceListener = new PrintTraceListener();
		parser.addUserTraceListener(traceListener);
		
		// set parser feature : validation
		try {
			parser.setFeature(IDFDLProcessor.DFDL_FEATURE_VALIDATION, true);
		} catch (DFDLNotRecognizedException e) {
			System.err.println("Unknown DFDL processor feature : " + e.getMessage() );
			System.exit(1);
		}
		
		// set parser variable : predefined DFDL variable 'encoding'
		try {
			parser.setVariable("encoding", "http://www.ogf.org/dfdl/dfdl-1.0/", "ISO-8859-1");
		} catch (DFDLException e) {
			System.err.println("DFDL Exception while setting variable: " + e.getMessage() );
			System.exit(1);
		}
		
		/*
		 * parse
		 */
		
		boolean success;
		try {
			// One-step parsing method
			System.out.println("\nParsing with parseAll()");
			System.out.println("-----------------------");
			// the parser will call the docHandler methods - See PrintDocHandler.java @DA@
			// in order to grab the element values as the parser runs
			success = parser.parseAll();		
			System.out.println("\nParsing complete: parseAll() returned " + success);
			
			// validate that the object is being populated....

			System.out.println("sourceMessage:"+ metaData.docHandler.getModel().mapDef.srcMessage);
			System.out.println("sourceSchema:"+ metaData.docHandler.getModel().mapDef.srcSchema);
			System.out.println("targetMessage:"+ metaData.docHandler.getModel().mapDef.trgMessage);
			System.out.println("targetSchema:"+ metaData.docHandler.getModel().mapDef.trgSchema);
			System.out.println("sourceParser:"+ metaData.docHandler.getModel().mapDef.srcParser);
			System.out.println("targetParser:"+ metaData.docHandler.getModel().mapDef.trgParser);
			for (int i = 0; i < metaData.docHandler.getModel().getSubstMapping().size();i++)
			{
					
				System.out.println("Source Field Value Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).srcField);
				System.out.println("Target Field Value Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).trgField);
				System.out.println("Description Value Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).description);
				System.out.println("spare 1 Value Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).spare1);
				System.out.println("spare 2 Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).spare2);
				
			}
           
			// test a lookup of the first substitution
			System.out.println("Test of first substitution returns:" + lookupSubst(metaData, metaData.docHandler.getModel().getSubstMapping().get(0).srcField));
			
			
			if (!success){
				System.exit(1);
			}
			
		} catch (DFDLException e) {
			System.err.println("DFDL exception while processing : " + e.getMessage() );
			System.exit(1);
		}

/*		@DA Following commented out code shows how to set GDM map values based on looked up values - its sample code from another parser I wrote - keep for now
		
		// used the IIB Generate Classes for JAXB against the MSL schema to generate the Java objects 
		// we don't need to use the DFDL serializer because the JAXB marshaller can be told to write XML to file.	

		// Create the basic map based on hard coded values
		MappingRoot MyMapRoot = new MappingRoot();
		Documentation MyDoc = new Documentation();
		MyDoc.setDescription("generated via JAXB map generation API at " + new Date().toString());
		MyMapRoot.setDocumentation(MyDoc);
		MyMapRoot.setDomainID("com.ibm.msl.mapping.xml");
		MyMapRoot.setDomainIDExtension("mb");
		MyMapRoot.setMainMap(true);
		MyMapRoot.setTargetNamespace("default");
		MyMapRoot.setVersion("8.0.5.0");
		
// add the input and output map designators for the source and target objects
		
//@DA   metaData.docHandler.getModel().gdmDef.sourceSchema to replace "Input_Model.xsd"	
		MappingDesignator myInpMD = new MappingDesignator();
		myInpMD.setPath("/"+metaData.docHandler.getModel().mapDef.srcSchema);
//@DA	myInpMD.setPath("/Input_Model.xsd");
		MyMapRoot.getInput().add(myInpMD); 
		
//@DA metaData.docHandler.getModel().gdmDef.targetSchema to replace "Output_Model.xsd"		
		MappingDesignator myOutMD = new MappingDesignator();
		myOutMD.setPath("/"+metaData.docHandler.getModel().mapDef.trgSchema);		
//@DA	myOutMD.setPath("/Output_Model.xsd");
		MyMapRoot.getOutput().add(myOutMD);		

	    //@DAnsl add the namespaces list 		
		
		Namespaces myNSlist = new Namespaces();
		Namespace firstNS = new Namespace();
		firstNS.setKind("supplement");
		firstNS.setPrefix("io");
		firstNS.setUri("http://www.da.com/modelSchema");
		
		myNSlist.getNamespace().add(firstNS); 
		
		Namespace secondNS = new Namespace();
		secondNS.setKind("extension");
		secondNS.setPrefix("fn");
		secondNS.setUri("http://www.w3.org/2005/xpath-functions");

		myNSlist.getNamespace().add(secondNS); 
						
        MyMapRoot.setNamespaces(myNSlist); //@DAnsl

		
		Generation MyMapGen = new Generation();
		MyMapGen.setEngine("xquery");
		MyMapRoot.setGeneration(MyMapGen);
		
		// Build the Map Declaration
		MappingDeclaration MyMapDecl = new MappingDeclaration();
		MyMapDecl.setName(MapName);
	
		// add the input map designators for the source and target objects
		
//@DA  metaData.docHandler.getModel().gdmDef.sourceMessage to replace "inmodel"
//@DA  metaData.docHandler.getModel().gdmDef.sourceParser to replace "XMLNSC"
		
		MappingDesignator myDecInpMD = new MappingDesignator();
		myDecInpMD.setNamespace("http://www.da.com/modelSchema");		
//@DA	myDecInpMD.setPath("mb:msg(inmodel,assembly,XMLNSC,Properties)");
//@DA	myDecInpMD.setVar("ComIbmMessageAssembly_inmodel");	
		myDecInpMD.setPath("mb:msg("+metaData.docHandler.getModel().mapDef.srcMessage+",assembly,"   
                                    +metaData.docHandler.getModel().mapDef.srcParser+",Properties)");
		myDecInpMD.setVar("ComIbmMessageAssembly_"+metaData.docHandler.getModel().mapDef.srcMessage);
		
		MyMapDecl.getInput().add(myDecInpMD);
		
		// add the output map designators for the source and target objects
		
//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
//@DA metaData.docHandler.getModel().gdmDef.targetParser to replace "XMLNSC"
		
		MappingDesignator myDecOutMD = new MappingDesignator();
		myDecOutMD.setNamespace("http://www.da.com/modelSchema");		
//@DA	myDecOutMD.setPath("mb:msg(outmodel,assembly,XMLNSC,Properties)");
//@DA	myDecOutMD.setVar("ComIbmMessageAssembly_outmodel");
		myDecOutMD.setPath("mb:msg("+metaData.docHandler.getModel().mapDef.trgMessage+",assembly,"   
                                    +metaData.docHandler.getModel().mapDef.trgParser+",Properties)");
		myDecOutMD.setVar("ComIbmMessageAssembly_"+metaData.docHandler.getModel().mapDef.trgMessage);

		MyMapDecl.getOutput().add(myDecOutMD);		
			
		MyMapRoot.getMappingDeclaration().add(MyMapDecl);

		// do a move to copy the properties from input to output
//@DA metaData.docHandler.getModel().gdmDef.sourceMessage to replace "inmodel"
//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
		
		Move MyPrMove = new Move();
		Documentation MyPrMoveDoc = new Documentation();
		MyPrMoveDoc.setDescription("copy properties across");
		MyPrMove.setDocumentation(MyPrMoveDoc);
		MappingDesignator MyInpPrMoveDesignator = new MappingDesignator();
		MappingDesignator MyOutPrMoveDesignator = new MappingDesignator();
		
//@DA	MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/Properties");	
		MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().mapDef.srcMessage+"/Properties");
		
		MyPrMove.getInput().add(MyInpPrMoveDesignator);
		
//@DA	MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/Properties");
		MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().mapDef.trgMessage+"/Properties");
		
		MyPrMove.setOutput(MyOutPrMoveDesignator);

		JAXBElement<Move> MoveJaxbEl = factory.createMove(MyPrMove);
		
		MyMapDecl.getNested().add(MoveJaxbEl); */
		
		
	}


public static String lookupSubst(ParseDictionary metaData, String mySubstValue) {

	for (int i = 0; i < metaData.docHandler.getModel().getSubstMapping().size();i++)
	{
	
		if ((metaData.docHandler.getModel().getSubstMapping().get(i).srcField).equalsIgnoreCase(mySubstValue)) 
		{ // if your substitution value is found return the replacement
			System.out.println("looked up:"+mySubstValue+" returning:"+metaData.docHandler.getModel().getSubstMapping().get(i).trgField);
			return(metaData.docHandler.getModel().getSubstMapping().get(i).trgField);  //match 
		} // end if
	} // end of the loop for substitution entries
    System.out.println("no substitution required");
	return(mySubstValue);  // no substitution required 

	}
}
