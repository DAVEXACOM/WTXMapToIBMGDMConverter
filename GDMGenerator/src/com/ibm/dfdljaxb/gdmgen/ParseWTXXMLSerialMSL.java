package com.ibm.dfdljaxb.gdmgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import com.ibm.dfdl.grammar.DFDLGrammarFactory;
import com.ibm.dfdl.grammar.IDFDLGrammar;
import com.ibm.dfdl.processor.DFDLProcessorFactory;
import com.ibm.dfdl.processor.IDFDLErrorHandler;
import com.ibm.dfdl.processor.IDFDLParser;
import com.ibm.dfdl.processor.IDFDLProcessor;
import com.ibm.dfdl.processor.IDFDLProcessorErrorHandler;
import com.ibm.dfdl.processor.exceptions.DFDLException;
import com.ibm.dfdl.processor.exceptions.DFDLNotRecognizedException;
import com.ibm.dfdl.processor.trace.IDFDLUserTraceListener;
import com.ibm.msl.Assign;
import com.ibm.msl.Convert;
import com.ibm.msl.CustomFunction;
import com.ibm.msl.Documentation;
import com.ibm.msl.Function;
import com.ibm.msl.Generation;
import com.ibm.msl.Import;
import com.ibm.msl.Imports;
import com.ibm.msl.InlinedXMLSchema;
import com.ibm.msl.MappingDeclaration;
import com.ibm.msl.MappingDesignator;
import com.ibm.msl.MappingRoot;
import com.ibm.msl.Move;
import com.ibm.msl.Namespace;
import com.ibm.msl.Namespaces;
import com.ibm.msl.ObjectFactory;
import com.ibm.msl.Param;


import com.ibm.wtxEXP.*;

	public class ParseWTXXMLSerialMSL {

 		static String baseMapName=null;
	           
		public static void main(String[] args) throws URISyntaxException, IOException {
			
			String Path = args.length >= 1 ? args[0] : "../GeneratedMapTargetApp/"; // default arg 1
			String MapName = args.length >= 2 ? args[1] : "SGServiceHBHCHK";        // default arg 2
			baseMapName = MapName;
			ObjectFactory factory = new ObjectFactory();
			String TXXML_FILE="SGServiceHBHCHKMeta.xml";
						
			TXXML_FILE = MapName+"Meta.xml";
			
			ParseWTXXMLSerialMSL wtxToMslParser = new ParseWTXXMLSerialMSL(); // Give us a handle for access to the class variables	

			PrintDocHandler dictionary = ParseDictionary();
			
			/* Construct from a JAXB parser */

			System.out.println("Building based on JAXB parsing");
			
		        JAXBContext jaxbInContext;
				try {
					jaxbInContext = JAXBContext.newInstance("com.ibm.wtxEXP");
		        Unmarshaller jaxbUnmarshaller = jaxbInContext.createUnmarshaller();
		        MMS MMSObj = (MMS)jaxbUnmarshaller.unmarshal(new File(TXXML_FILE));

		        System.out.println("TX Map count: "+MMSObj.getMapcount());
		        System.out.println("TX Map path: "+MMSObj.getPath());

		        int totalMaps = MMSObj.getMap().size();
				Map MyMap = null;
		        System.out.println("Number of maps: "+totalMaps); 

				for (int i = 0; i < totalMaps;i++) 

				{
			    List<Map> MapList = MMSObj.getMap();
								        
		        MyMap = MapList.get(i);
		        System.out.println("Name of Map "+i+":"+MyMap.getName());	

				}
				
			//@DAwtx MyMap should be the last one [3] at this point which is all I currently support
				
				int totalInputs = MyMap.getInput().size();
				Input MyInput = null;
		        System.out.println("Number of inputs: "+totalInputs); 
				for (int i = 0; i < totalInputs;i++) 

				{
			    List<Input> InputList = MyMap.getInput();			        
		        MyInput = InputList.get(i);
		        System.out.println("Name of Input Schema Card name: "+MyInput.getSchema().getCardname());	
		        System.out.println("Name of Input Schema: "+MyInput.getSourceRule().getMetaDataLocation());
				}
				
				int totalOutputs = MyMap.getOutput().size(); 
				Output MyOutput = null;
		        System.out.println("Number of outputs: "+totalOutputs); 

				for (int i = 0; i < totalOutputs;i++) 

				{
					//@DAwtx navigate to the last (or only output)	
				List<Output> OutputList = MyMap.getOutput();
				MyOutput = OutputList.get(i);
		        System.out.println("Name of Output Schema Card name: "+MyOutput.getSchema().getCardname());	
		        System.out.println("Name of Output Schema: "+MyOutput.getSchema().getTypetree().replaceFirst(".mtt",".xsd"));
		        
				}			
				
		    // @DAwtx used the IIB Generate Classes for JAXB against a wtxEXP MMS schema to generate Java Objects	
			// @DAwtx used the IIB Generate Classes for JAXB against the MSL schema to generate the Java objects 
            // @DAwtx unmarshall the wtx export of map file and marshall an IIB GDM
		        
			// Create the basic map based on hard coded values
			MappingRoot MyMapRoot = new MappingRoot();
			Documentation MyDoc = new Documentation();
			MyDoc.setDescription("generated via JAXB map generation API from WTX Map at " + new Date().toString());
			MyMapRoot.setDocumentation(MyDoc);
			MyMapRoot.setDomainID("com.ibm.msl.mapping.xml");
			MyMapRoot.setDomainIDExtension("mb");
			MyMapRoot.setMainMap(true);
			MyMapRoot.setTargetNamespace("default");
			MyMapRoot.setVersion("8.0.5.0");			
			
	// add the input and output map designators for the source and target objects
			
			MappingDesignator myInpMD = new MappingDesignator();
			// @DAChoice1 following uses the wtx map export file
			// myInpMD.setPath("/"+MyInput.getSourceRule().getMetaDataLocation());
			// @DAChoice1 following gets the srcSchema from the dictionary		
			myInpMD.setPath("/"+dictionary.getModel().mapDef.srcSchema);

			MyMapRoot.getInput().add(myInpMD); 	
			
			MappingDesignator myOutMD = new MappingDesignator();
			// @DAChoice1 following uses the wtx map export file
			// myOutMD.setPath("/"+MyOutput.getSchema().getTypetree().replaceFirst(".mtt",".xsd"));
 			// @DAChoice1 following gets the srcSchema from the dictionary			
			myOutMD.setPath("/"+dictionary.getModel().mapDef.trgSchema);
		
			MyMapRoot.getOutput().add(myOutMD);		
    			
		
			
	/*@DAFuture1 Maps calling functional maps could require custom Java, we need a place holder Java class imported and an extension namespace of prefix 
	//		<imports>
    //	        <import kind="java" location="com.da.javaholder.placeholder" namespace="xalan://com.da.javaholder.placeholder"/>
    //	    </imports>
	//      <namespace kind="extension" prefix="placeholder" uri="xalan://com.da.javaholder.placeholder"/>
		
            Import MyPlaceHolderImport = new Import();
            MyPlaceHolderImport.setKind("java");
            MyPlaceHolderImport.setLocation("com.da.javaholder.placeholder");
            MyPlaceHolderImport.setNamespace("xalan://com.da.javaholder.placeholder");
            Imports MyPlaceHolderImports = new Imports();
            MyPlaceHolderImports.getImport().add(MyPlaceHolderImport);
			MyMapRoot.setImports(MyPlaceHolderImports);
			
			Namespace javaPrefixNS = new Namespace();
			javaPrefixNS.setKind("extension");
			javaPrefixNS.setPrefix("placeholder");
			javaPrefixNS.setUri("xalan://com.da.javaholder.placeholder");

			myNSlist.getNamespace().add(javaPrefixNS); DAWTX Maps calling functional maps @DAFuture1*/
			Namespaces myNSlist = new Namespaces();

    //additional add the namespaces list - need to do this without hard coding or pass in as parms		
			
			Namespace firstNS = new Namespace();
			firstNS.setKind("extension");
			firstNS.setPrefix("fn");
			firstNS.setUri("http://www.w3.org/2005/xpath-functions");
			
			myNSlist.getNamespace().add(firstNS); 
						
            MyMapRoot.setNamespaces(myNSlist); 
			
			Generation MyMapGen = new Generation();
			MyMapGen.setEngine("xquery");
			MyMapRoot.setGeneration(MyMapGen);
			
			// Build the Map Declaration
			MappingDeclaration MyMapDecl = new MappingDeclaration();
			MyMapDecl.setName(MapName);		
			
			MappingDesignator myDecInpMD = new MappingDesignator();
			
			//@DAwtx need to get this from the dictionary as SGServiceRequest does not appear in the WTX map meta data		
			myDecInpMD.setPath("mb:msg("+dictionary.getModel().mapDef.srcMessage+",assembly,"+dictionary.getModel().mapDef.srcParser+",Properties)");
			myDecInpMD.setVar("ComIbmMessageAssembly_"+dictionary.getModel().mapDef.srcMessage);			
			MyMapDecl.getInput().add(myDecInpMD);
											
			MappingDesignator myDecOutMD = new MappingDesignator();
			
			//@DAWTX need to get this from the dictionary as HBHCHKREQ does not appear in the WTX map meta data
			myDecOutMD.setPath("mb:msg("+dictionary.getModel().mapDef.trgMessage+",assembly,"+dictionary.getModel().mapDef.trgParser+",Properties)");
			myDecOutMD.setVar("ComIbmMessageAssembly_"+dictionary.getModel().mapDef.trgMessage);
			MyMapDecl.getOutput().add(myDecOutMD);		
				
			MyMapRoot.getMappingDeclaration().add(MyMapDecl);
			
			// @DAwtx add the input map designators for the source and target objects
			// do a move for the properties		IN: $ComIbmMessageAssembly_SGServiceRequest/Properties	OUT: $ComIbmMessageAssembly_HBHCHKREQ/Properties
		    //   <move>
	        //    <documentation description="copy properties across"/>
	        //    <input path="$ComIbmMessageAssembly_SGServiceRequest/Properties"/>
	        //    <output path="$ComIbmMessageAssembly_HBHCHKREQ/Properties"/>
	        //   </move>
			
			Move MyPrMove = new Move();
			Documentation MyPrMoveDoc = new Documentation();
			MyPrMoveDoc.setDescription("copy properties across");
			MyPrMove.setDocumentation(MyPrMoveDoc);
			MappingDesignator MyInpPrMoveDesignator = new MappingDesignator();
			MappingDesignator MyOutPrMoveDesignator = new MappingDesignator();
			
			// @DAChoice1 Doing it based on the WTX Map XML export file..... could be different every time
			//MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+MyInput.getSchema().getTypetree().replaceFirst("All.mtt", "Request")+"/Properties"); 
			// Doing it based on the dictionary
			MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+dictionary.getModel().mapDef.srcMessage+"/Properties"); 
			
			MyPrMove.getInput().add(MyInpPrMoveDesignator);
			// @DAChoice1 Doing it based on the WTX Map XML export file..... could be different every time			
			//MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+MyOutput.getSchema().getType().replaceFirst("_", "").substring(0, MyOutput.getSchema().getType().indexOf(' ')-1)+"/Properties");
			// Doing it based on the dictionary
			MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+dictionary.getModel().mapDef.trgMessage+"/Properties");
			
			MyPrMove.setOutput(MyOutPrMoveDesignator);

			JAXBElement<Move> MoveJaxbPr = factory.createMove(MyPrMove);
			
			MyMapDecl.getNested().add(MoveJaxbPr);  

			int totalMapRules = MyOutput.getMapRule().size();		
			MapRule MyMapRule = null;
	        System.out.println("Number of MapRules: "+totalMapRules); 

			for (int i = 0; i < totalMapRules;i++) 

			{//@DAWtx this is the main mapping for loop
			 //@DAwtx navigate to the last (or only output)	this is all that is supported at the moment
				List<MapRule> MapRuleList = MyOutput.getMapRule();
	        
	        MyMapRule = MapRuleList.get(i);
	        //@DAwtx output some general information
	        System.out.println("***** Starting processing for MapRule number: "+MyMapRule.getRulenumber()); 
	        System.out.println("ObjectSet (Target Field): "+MyMapRule.getObjectset()); 
	        System.out.println("ObjectRule(Source Field/Operation): "+MyMapRule.getObjectrule()); 
	        
	        //@DAwtx need to workout what kind of function we have
	        //=SrhInterfaceCode:SrhServiceRequestName:SGServiceRequest Element:Global:SGSAllIn
	        //=SrhSource:SrhIdentity:SGServiceRequest Element:Global:SGSAllIn
	        //=0
	        //=TEXTTONUMBER(LEFT(CustNum:CustDtlRq:BusinessData:SGServiceRequest Element:Global:SGSAllIn,5))
	        //="hello"
	        // its either numeric only in which case an assign = so set txFunction = ASSIGNNUM
	        // if it starts with an =" its an assign = so set txFunction = ASSIGNTEXT
	        // it contains a "(" in which cases it is a function and we want to set txFunction = substring from 1 to the first "("
	        // if it's none of the above it must be either an input field to output file move
	        
	        
	        String txFunction = MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length()).toUpperCase();
	        System.out.println("Determine processing for the function:"+ txFunction);
            if (isNumeric(txFunction)) { txFunction = "ASSIGNNUM";
            								System.out.println("Modifying the main function type to function:"+ txFunction);                                              
            							   } // its a numerical assign
            if (txFunction.startsWith("\"")) { txFunction = "ASSIGNTEXT";
										System.out.println("Modifying the main function type to function:"+ txFunction);                                              
            						   } // its a text assign
            if (txFunction.contains("(")) { txFunction = txFunction.substring(0, txFunction.indexOf("("));
										System.out.println("Modifying the main function type to function:"+ txFunction);                                              
            							} // get the first function
            //@DAwtx only the act on the first function NUMBERTOTEXT(LEFT..... work off NUMBERTOTEXT
            //@DAwtx full rule is copied to the documentation field in the GDM for manual update
       
	        switch(txFunction) {
	           case "NUMBERTOTEXT" :
	           case "TEXTTONUMBER" :	   
	              System.out.println("NUMBERTOTEXT/TEXTTONUMBER detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length())); 
	              System.out.println("We'll do a convert");
	              
		          JAXBElement<Convert> ConvertJaxbEl = factory.createConvert(buildConvert(factory, MyMapDecl, MyOutput, MyMapRule, dictionary));				
				  MyMapDecl.getNested().add(ConvertJaxbEl);
	              break;
	           case "LOWERCASE" :
		              System.out.println("LOWERCASE detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length())); 
		              System.out.println("We'll do a move to create the association");
		              
					  JAXBElement<Move> MoveLCJaxbEl = factory.createMove(buildMove(factory, MyMapDecl, MyOutput, MyMapRule,dictionary));
					  MyMapDecl.getNested().add(MoveLCJaxbEl);

	              break;
	           case "UPPERCASE" :
		              System.out.println("UPPERCASE detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length())); 
		              System.out.println("We'll do a move to create the association");
		              
					  JAXBElement<Move> MoveUCJaxbEl = factory.createMove(buildMove(factory, MyMapDecl, MyOutput, MyMapRule,dictionary));
					  MyMapDecl.getNested().add(MoveUCJaxbEl);

	              break;
	           case "NOTYETIMPELMENTED" :
		              System.out.println("NOTYETIMPELMENTED detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length()));
		              System.out.println("We'll do a custom function");
		    		  
		              JAXBElement<CustomFunction> CustFuncJaxbEl = factory.createCustomFunction(buildCustFunc(factory, MyMapDecl, MyOutput, MyMapRule));				
		    		  MyMapDecl.getNested().add(CustFuncJaxbEl);
	              break;
	           case "ASSIGNNUM" :
		              System.out.println("ASSIGNNUM detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length()));
		              System.out.println("We'll do an assign");
		  			  
		              JAXBElement<Assign> AssignJaxbElN = factory.createAssign(buildAssign(factory, MyMapDecl, MyOutput, MyMapRule, dictionary));				
					  MyMapDecl.getNested().add(AssignJaxbElN);
		          break;
	           case "ASSIGNTEXT" :
		              System.out.println("ASSIGNTEXT detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length())); 
		              System.out.println("We'll do an assign");
		              
		              JAXBElement<Assign> AssignJaxbElT = factory.createAssign(buildAssign(factory, MyMapDecl, MyOutput, MyMapRule, dictionary));				
					  MyMapDecl.getNested().add(AssignJaxbElT);
		              
		          break;
	           default :
		              System.out.println("Default (Move) or as yet unsupported function detected:"+MyMapRule.getObjectrule().substring(1, MyMapRule.getObjectrule().length())); 
		              System.out.println("We'll do a move to simply create the association");
		              
					  JAXBElement<Move> MoveJaxbEl = factory.createMove(buildMove(factory, MyMapDecl, MyOutput, MyMapRule, dictionary));
					  MyMapDecl.getNested().add(MoveJaxbEl);
	        }
	        System.out.println("***** Ending processing for MapRule number: "+MyMapRule.getRulenumber()+"\n"); 
	                       
			}//DAWtx this is the end of the main mapping for loop
				
				// Write the map file using the JaxB marshaller to write XML to file
				File file = new File(Path + MapName + ".map");
				JAXBContext jaxbContext = JAXBContext.newInstance(MappingRoot.class);

				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            
				// @DA@ MappingRoot does not have a @XMLRootElement annotation so you have to wrap it - maybe the IIB shipped MSL.xsd schema needs updating
				// @DA@ this link explains http://www.source4code.info/2013/07/jaxb-marshal-element-missing-xmlrootelement-annotation.html
				
				QName qName = new QName("http://www.ibm.com/2008/ccl/Mapping","mappingRoot");
				JAXBElement<MappingRoot> myRoot = new JAXBElement<MappingRoot>(qName,MappingRoot.class, MyMapRoot);
				
				jaxbMarshaller.marshal(myRoot, file);
				jaxbMarshaller.marshal(myRoot, System.out);

	            //@DAwtx now refresh GeneratedMapTargetApp project  
				//@DAwtx then open	../GeneratedMapTargetApp/yourmap.map to check results
				
		      } catch (JAXBException e) {
				e.printStackTrace();
		      }		
			
		}

		public static Move buildMove(ObjectFactory factory,MappingDeclaration MyMapDecl, Output MyOutput, MapRule MyMapRule,PrintDocHandler dictionary)
		{
		    System.out.println("Performing a Move for Rule number: "+MyMapRule.getRulenumber()
		    		+" Object Rule (Source/Function):"+MyMapRule.getObjectrule()
		    		+" Object Set (Target)"+MyMapRule.getObjectset()); 
		    
			Move MyMove = new Move();
			Documentation MyMoveDoc = new Documentation();
    		MyMoveDoc.setDescription("WTX Map association. rule number:"+MyMapRule.getRulenumber()+" Source Field/Operation:"+MyMapRule.getObjectrule()+" Target Field:"+MyMapRule.getObjectset()); 				
    		MyMove.setDocumentation(MyMoveDoc);

			MappingDesignator MyInpMoveDesignator = new MappingDesignator();
			MappingDesignator MyOutMoveDesignator = new MappingDesignator();	
			
			// The ObjectRule is the source field (Input  to the Move)
			// The ObjectSet  is the target field (Output of the Move)
			// The Input message type (XML or Other) determines the type of refactoring required.

			if (dictionary.getModel().mapDef.srcParser.equalsIgnoreCase("XMLNSC")) {
				
				// If the Input Parser is XML then (so XML to something)
				MyInpMoveDesignator.setPath(
					// example build "$ComIbmMessageAssembly_SGServiceRequest/SGServiceRequest/SrhServiceRequestName/SrhInterfaceCode" 
					// from the ObjectRule "=SrhInterfaceCode:SrhServiceRequestName:SGServiceRequest Element:Global:SGSAllIn"
					//                  	
					   "$ComIbmMessageAssembly_"+refactorTxXMLFmt(MyMapRule.getObjectrule(),dictionary));
			} else {

		       // If Input Parser is not XML (so non-XML to something)
				MyInpMoveDesignator.setPath(
					//example build "$ComIbmMessageAssembly_HBHCHKREQ/HBHCHKREQ/HBHDR_REQ/TRCDNAME"
					//from the ObjectRule "=TRCDNAME_11 Field:HBHDR_REQ Group:HBHCHKReqOut"
					//	                   =TRCDNAME_18 Field:HBHDR_RPY Group:HBHCHKRPY
			           "$ComIbmMessageAssembly_"+refactorTxFixFmt(MyMapRule.getObjectrule(),dictionary));
			}
			MyMove.getInput().add(MyInpMoveDesignator);
			
			if (dictionary.getModel().mapDef.trgParser.equalsIgnoreCase("XMLNSC")) {
				// If the Output Parser is XML then
				MyOutMoveDesignator.setPath(		
						// example build "$ComIbmMessageAssembly_SGServiceRequest/SGServiceRequest/SrhServiceRequestName/SrhInterfaceCode" 
						// from the ObjectSet "SrhInterfaceCode:SrhServiceRequestName:SGServiceRequest Element:Global:SGSAllIn"
						 "$ComIbmMessageAssembly_"+refactorTxXMLFmt(MyMapRule.getObjectset(),dictionary));				
			} else {
			       // If Output Parser is not XML

				MyOutMoveDesignator.setPath(
						//example build "$ComIbmMessageAssembly_HBHCHKREQ/HBHCHKREQ/HBHDR_REQ/TRCDNAME"
						//from the ObjectSet "TRCDNAME_11 Field:HBHDR_REQ Group:HBHCHKReqOut"
				          "$ComIbmMessageAssembly_"+refactorTxFixFmt(MyMapRule.getObjectset(),dictionary)); 			
			}
			
			MyMove.setOutput(MyOutMoveDesignator);

		  return MyMove;  
		}
		
		
		public static Convert buildConvert(ObjectFactory factory,MappingDeclaration MyMapDecl, Output MyOutput, MapRule MyMapRule,PrintDocHandler dictionary)
		{
			  System.out.println("Performing a Convert for Rule number: "+MyMapRule.getRulenumber()
			    		+" Object Rule (Source/Function):"+MyMapRule.getObjectrule()
			    		+" Object Set (Target)"+MyMapRule.getObjectset());  

			    Convert MyConvFunc = new Convert();
				Documentation MyConvDoc = new Documentation();
	    		MyConvDoc.setDescription("WTX Map association. rule number:"+MyMapRule.getRulenumber()+" Source Field/Operation:"+MyMapRule.getObjectrule()+" Target Field:"+MyMapRule.getObjectset()); 				
	    		MyConvFunc.setDocumentation(MyConvDoc);
	    		MyConvFunc.setDefaultValue("0"); // if the conversion does not work set a zero value in the target field

			    // path - need to extract CustNum:CustDtlRq:BusinessData:SGServiceRequest Element:Global:SGSAllIn
	    		// and pass to refactorTxXML or refactorTxFix
				// example remove =TEXTTONUMBER(LEFT( from the beginning THEN remove ,5)) from the end
				String MyPath = new String();
				//drop the = and the end ",5))" if it exists
				try {
					MyPath = MyMapRule.getObjectrule().substring(1,MyMapRule.getObjectrule().indexOf(","));
					
				} catch (Exception e) {
					MyPath = MyMapRule.getObjectrule();
				}
				
				//drop the "TEXTTONUMBER(LEFT(" if it exists and put the = back on
				try {
					MyPath = "="+MyPath.substring(MyPath.lastIndexOf("(")+1,MyPath.length());		 									
				} catch (Exception e) {
					System.out.println("Why has TEXTTONUMBER/NUMBERTOTEXT got no open bracket: "+MyPath);	 									
				}
				
				//drop any end of brackets that might be present
				try {
					MyPath = MyPath.substring(0,MyPath.indexOf(")"));
					System.out.println("End of brackets removed");
				} catch (Exception e) {
					System.out.println("No End of brackets");

				}
				
//				MyPath = "="+MyPath.substring(MyPath.lastIndexOf("(")+1,MyPath.length());		 					
				
				System.out.println("Source path for the convert: "+MyPath); //"=CustNum:CustDtlRq:BusinessData:SGServiceRequest Element:Global:SGSAllIn"

				MappingDesignator MyInpConvDesignator = new MappingDesignator();
				MappingDesignator MyOutConvDesignator = new MappingDesignator();		

				// The ObjectRule is the source field (Input  to the Move)
				// The ObjectSet  is the target field (Output of the Move)
				// * is the original working versions.

				if (dictionary.getModel().mapDef.srcParser.equalsIgnoreCase("XMLNSC")) {
					// If Input Parser is XML (so XML to something)
				
					MyInpConvDesignator.setPath(
								"$ComIbmMessageAssembly_"+refactorTxXMLFmt(MyPath,dictionary));
					// example get "CustNum" from "=CustNum:CustDtlRq:BusinessData etc" 
					MyInpConvDesignator.setVar(MyPath.substring(1,MyPath.indexOf(":"))); 
				}else{
					// If Input Parser is not XML (so non-XML to something)
					MyInpConvDesignator.setPath(
							   "$ComIbmMessageAssembly_"+refactorTxFixFmt(MyPath,dictionary));
					// example get "PORTIDNF_20" from "=PORTIDNF_20 Field:HBHDR_RPY Group:HBHCHKRPY"
					MyInpConvDesignator.setVar(MyPath.substring(1,MyPath.indexOf(" "))); 				
				}
				
				MyConvFunc.getInput().add(MyInpConvDesignator);
				
				if (dictionary.getModel().mapDef.trgParser.equalsIgnoreCase("XMLNSC")) {
					// If the Output Parser is XML then
				
				MyOutConvDesignator.setPath(
				          "$ComIbmMessageAssembly_"+refactorTxXMLFmt(MyMapRule.getObjectset(),dictionary));
				}else{
					// If the Output Parser is not XML then
					
				MyOutConvDesignator.setPath(
				          "$ComIbmMessageAssembly_"+refactorTxFixFmt(MyMapRule.getObjectset(),dictionary));					
				}
				
				MyConvFunc.setOutput(MyOutConvDesignator);

		  return MyConvFunc;  
		}	
		
		public static Assign buildAssign(ObjectFactory factory,MappingDeclaration MyMapDecl, Output MyOutput, MapRule MyMapRule, PrintDocHandler dictionary)
		{       	
        	/*	!!build this!!<assign value="0"><output path="$ComIbmMessageAssembly_HBHCHKREQ/HBHCHKREQ/IMSLL"/</assign>
        	    !!from this!! <Output><Schema cardnumber="1" cardname="Out" typetree="HB37.mtt" type="HB_HCHKREQ Record CopyBook"/>  */
	    System.out.println("Performing an Assign for Rule number:"+MyMapRule.getRulenumber()
	    		+" Where Object Set (Target)="+MyMapRule.getObjectset());  

		Assign MyAssign = new Assign();
		Documentation MyAssignDoc = new Documentation();
		MyAssignDoc.setDescription("WTX Map value assignment. Rule number:"+MyMapRule.getRulenumber()+" Source Field/Operation:"+MyMapRule.getObjectrule()+" Target Field:"+MyMapRule.getObjectset()); 				
		MyAssign.setDocumentation(MyAssignDoc);
		// grab the value to assign and strip off the leading =
		MyAssign.setValue(MyMapRule.getObjectrule().replaceFirst("=","")); 
		// now we need to determine the target field from the Objectset
		MappingDesignator MyOutAssignDesignator = new MappingDesignator();
		//object set : IMSLL_8 Field:HBHCHKReqOut			
		
		/*@DAChoice3 Do it using the WTX Map XML export data - need to decide which way to do this
		  @DAchoice3 MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_" +MyOutput.getSchema().getType().replaceFirst("_", "").substring(0, MyOutput.getSchema().getType().indexOf(' ')-1)+"/"          
          @DAChoice3                                                       +MyOutput.getSchema().getType().replaceFirst("_", "").substring(0, MyOutput.getSchema().getType().indexOf(' ')-1)+"/"         
          @DAChoice3                                                        +MyMapRule.getObjectset().substring(0, MyMapRule.getObjectset().indexOf('_'))); */
		//@DAChoice3 Do it using the dictionary
		String temp = null;
		try {
			temp = MyMapRule.getObjectset().substring(0, MyMapRule.getObjectset().indexOf(' '));
		} catch (Exception e) {
		    System.out.println("No spaces found in target object to set: "+MyMapRule.getRulenumber());
		    temp = MyMapRule.getObjectset();
		}
		
		temp = MyMapRule.getObjectset(); //@DAFix5 maybe don't do the above so set it back
		
	    System.out.println("target object to set before refactor: "+temp); 
	    //CISKey:Customer:ListOfCustomers:CustData:CustDtlRs:BusinessData:SGServiceReply
	    // needs to become   $ComIbmMessageAssembly_SGServiceReply/SGServiceReply/BusinessData/CustDtlRs/CustData/ListOfCustomers/Customer/CISKey"


	    if (dictionary.getModel().mapDef.trgParser.equalsIgnoreCase("XMLNSC")) {
			// If the Output Parser is XML then
		    System.out.println("Output parser is XML: "+dictionary.getModel().mapDef.trgParser); 
		    temp = refactorTxXMLFmt(temp,dictionary);
		    System.out.println("target object to set after refactor: "+temp); 
		
			// build "$ComIbmMessageAssembly_SGServiceRequest/SGServiceRequest/SrhServiceRequestName/SrhInterfaceCode" 
			// from the ObjectSet "SrhInterfaceCode:SrhServiceRequestName:SGServiceRequest Element:Global:SGSAllIn"

		MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_" 
                					 +lookupSubst(dictionary, temp)); //@DARevisit9 - xml won't need a lookup just +temp
		} else {
		       // *If Output Parser is not XML
			   //build "$ComIbmMessageAssembly_HBHCHKREQ/HBHCHKREQ/HBHDR_REQ/TRCDNAME"
			   //from the ObjectSet "TRCDNAME_11 Field:HBHDR_REQ Group:HBHCHKReqOut"	

		    System.out.println("Output parser is not XML: "+dictionary.getModel().mapDef.trgParser); 
                 
		    temp = refactorTxFixFmt(temp,dictionary); 

			MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_"+temp);
			
			System.out.println("Setting Output Path to: $ComIbmMessageAssembly_"+temp); 	    		    
    
		}
		
		MyAssign.setOutput(MyOutAssignDesignator);

		  return MyAssign;  
		}
		
		public static CustomFunction buildCustFunc(ObjectFactory factory,MappingDeclaration MyMapDecl, Output MyOutput, MapRule MyMapRule)
		{
		    System.out.println("Performing a Custom function for Rule number: "+MyMapRule.getRulenumber()
		    		+" Object Rule (Source/Function):"+MyMapRule.getObjectrule()
		    		+" Object Set (Target)"+MyMapRule.getObjectset()); ; 

    	//@DAFuture2  save this section in case CustomFunctions are required 
		//@DAFuture2 in reality This will probably be a Move because it will still need Input and Output it will just
		//@DAFuture2 might be a case of doing a Move and copying the function to documentation and then suggesting the equivalent GDM function
    	        	
		    CustomFunction MyCusFunc = new CustomFunction();
		    Documentation MyCusFuncDoc = new Documentation();
		    MyCusFuncDoc.setDescription("WTX Map value assignment. rule number:"+MyMapRule.getRulenumber()+" Source Field/Operation:"+MyMapRule.getObjectrule()+" Target Field:"+MyMapRule.getObjectset()); 				

		    MyCusFuncDoc.setValue(MyMapRule.getObjectrule());
		    MyCusFunc.setDocumentation(MyCusFuncDoc);
		    MyCusFunc.setLang("wtx");
		    MyCusFunc.setRef("placeholder:sampleTransform");
		    MappingDesignator MyOutCusFuncDesignator = new MappingDesignator();
					
		    MyOutCusFuncDesignator.setPath(
			                    // "$ComIbmMessageAssembly_" +metaData.docHandler.getModel().gdmDef.targetMessage+"/"           
                                //                           +metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
		    		MyMapRule.getObjectrule());

		    MyCusFunc.getOutput().add(MyOutCusFuncDesignator);

		  return MyCusFunc;  
		}
		
		
		private static String refactorTxXMLFmt(String wtxObjectRule,PrintDocHandler dictionary) {
			
			final StringBuffer sb = new StringBuffer();
			String MapDesPath = new String();
		    System.out.println("refactorTxXMLFmt - Called with Object string:"+wtxObjectRule);
            // example
			//=SrhInterfaceCode:SrhServiceRequestName:SGServiceRequest Element:Global:SGSAllIn
			// drop = off the front and drop from Element onwards
			// use SGServiceRequest twice

		    String temp = null;
		    try {
			    temp = wtxObjectRule.substring(0, wtxObjectRule.indexOf(' '));
				
				} catch (Exception e) 
				{
					temp =  wtxObjectRule;
				} // @DAwtx if no spaces so use whole string
				
		    temp = temp.replaceFirst("=","");

		    System.out.println("refactorTxXMLFmt - base Object element path:"+temp); 		    		    		        
		    // target             field1               field2
		    //example SrhInterfaceCode:SrhServiceRequestName:SGServiceRequest
		    int counter = 0; //  number of elements(depth) always one more than the number of : separator but start at 0 as we'll use an array that starts at 0
		    for( int i=0; i<temp.length(); i++ ) {
		        if( temp.charAt(i) == ':' ) {
		            counter++;
		        } 
		    }
		    System.out.println("refactorTxXMLFmt - base Object element path depth:"+counter); 
		    	    	
		    String[] fields = temp.split(":");
	        System.out.println("refactorTxXMLFmt - list of Fields in element path:"+Arrays.toString(fields));
	        
			sb.setLength(0);
			//@DARevisit1  We get an extra slash on the end but it seems to get ignored by the GDM mapping editor anyway        
		    for( int i=counter; i>=0; i-- ) {
				sb.append(fields[i]).append("/");
				System.out.println("refactorTxXMLFmt - refactored Object Rule element path after field "+i+":"+sb);
		        } 
		    //@DARevisit1 double up on the first field name in the MapDesPath 
			System.out.println("refactorTxXMLFmt - Final refactored Map Path:"+fields[counter]+"/"+sb); //@DARevisit1 not for XML!!
			//@DARevisit1 <output path="$ComIbmMessageAssembly_SGServiceRPY/SGServiceRPY/sequence/SyhVersion/"/>
			//@DARevisit1 <output path="$ComIbmMessageAssembly_SGServiceReply/SGServiceReply/SyhVersion/"/>			
		    //@DARevisit1 - having gotten each field pass to the dictionaries substitution lookup	    
			//@DARevisit1 next line needs fixing ... its not always fields 2,2,1,0
			//@DARevisit1 temporarily remove the lookup in the dictionary - 
			//@DARevisit1 I'd need to base the lookup line on the counter value so counter,counter,counter-1,counter-2 until zero
			//@DARevisit1 checkout the @ServiceID convert as well!
			//@DARevisit1 MapDesPath = lookupSubst(dictionary, fields[2])+"/"+lookupSubst(dictionary, fields[2])+"/"+lookupSubst(dictionary, fields[1])+"/"+lookupSubst(dictionary, fields[0]);		
			//@DArevisit1 add the extra copy of the leading field
			MapDesPath = fields[counter]+"/"+sb;
		    
			return MapDesPath;
			}

	private static String refactorTxFixFmt(String wtxObjectSet,PrintDocHandler dictionary) {
		String MapDesPath = new String();
	    System.out.println("refactorTxFixFmt - Called with Object string:"+wtxObjectSet);
		// example
		//=TRCDNAME_11 Field:HBHDR_REQ Group:HBHCHKReqOut - from a move to COBOL
		//=TRCDNAME_18 Field:HBHDR_RPY Group:HBHCHKRPY - from a move from COBOL
	    //=IMSZZ_9 Field:HBHCHKReqOut - from an assign to COBOL
	    //=TRCDNAME_11 Field:HBHDR_REQ Group:HBHCHKReqOut - from an assign to COBOL (same as from the move)
		//get the Group , uppercase, drop the out or lookup a substitution list

	    // @DARevist - see commentary inline about rewriting this function.

	    String target = null;
	    try {
    		target = wtxObjectSet.substring(0, wtxObjectSet.indexOf(' '));
			
		} catch (Exception e) {
			System.out.println("refactorTxFixFmt - no spaces found in string");
			target = wtxObjectSet; //@DAFix5
		}
	    try {
		    target = target.replaceFirst("=","");
			
		} catch (Exception e) {
			System.out.println("refactorTxFixFmt - no equals found in string");
		}
	    
	    System.out.println("refactorTxFixFmt - target field from Object element path:"+target);

	    String temp = wtxObjectSet.substring(wtxObjectSet.indexOf(' ')+1,wtxObjectSet.length() );
	    System.out.println("refactorTxFixFmt - remaining Object element path after target:"+temp);

	    int counter = 1; // start at 1 , number of elements(depth) is always one more that the : separator
		for( int i=0; i<temp.length(); i++ ) {
	    	
	        if( temp.charAt(i) == ':' ) {
	        	
	            counter++;
	        } 
	    }
	    System.out.println("refactorTxFixFmt - base Object element path depth:"+counter); 
	    	
	    	String field = null;
	    	try {
	    		field = temp.substring(0, temp.indexOf(' '));
	    	} catch (Exception e) {
	    		field = temp;
	    		System.out.println("refactorTxFixFmt - No spaces to remove from:"+field); 
	    	}
	    
	    	String group = null;
	    	try {
	    		group = temp.substring(temp.indexOf(' ')+1,temp.length());
	    	} catch (Exception e) {
	    		group = temp;
	    		System.out.println("refactorTxFixFmt - No spaces to remove from:"+group);  
	    	}
	    	    
	    	try {
	    		target = target.substring(0,target.indexOf("_")); //@DAREvisit2 should use dictionary or not? for targets maybe just drop the _NN as done here and not use dicutionary
	
	    	} catch (Exception e) {
	    		System.out.println("refactorTxFixFmt - No _NN to remove from:"+target);  
	    	}
	    
	    	field = field.substring(field.indexOf("Field:")+("Field:").length(),field.length());
	    
	    	group = group.substring(group.indexOf("Group:")+("Group:").length(),group.length());
	    	group = group.substring(0,group.length());       //@DAFix just go to the end of the group

	    	group = group.toUpperCase(); //@DARevist2 for COBOL an uppercase is probably ok. Could let the dictionary take care of it but could result in a big dictionary
	       
	    	System.out.println("refactorTxFixFmt - target:"+target); 	    
	    	System.out.println("refactorTxFixFmt - field :"+field);
	    	System.out.println("refactorTxFixFmt - group :"+group);	
	    	
	    	if (counter >2) {//@DAREvisit
	    	System.out.println("refactorTxFixFmt - Final Map Path is group as field and target:"+group+"/"+group+"/"+field+"/"+target );
	    	MapDesPath = lookupSubst(dictionary, group)+"/"+lookupSubst(dictionary, group)+"/"+lookupSubst(dictionary, field)+"/"+lookupSubst(dictionary, target);
	    	}else{
	    		//@DARevisit There is no field if counter is less than 2 and the code will have placed the group name value in field (and the value in group will be of no use)
	    		//@DAREvisit we need a better way of building up a stringbuffer as we loop round using the counter going from 
	    		//@DARevisit : to : instead of making assumptions about what's a group, what's a field and how many there are.
		    	System.out.println("refactorTxFixFmt - Final Map Path is field as group and target:"+field+"/"+field+"/"+target );
		    	MapDesPath = lookupSubst(dictionary, field)+"/"+lookupSubst(dictionary, field)+"/"+lookupSubst(dictionary, target);		
	    	}
	    	
        //@DAChoice2 without or with lookup in dictionary
		//@DAChoice2 MapDesPath = group+"/"+group+"/"+field+"/"+target;
		//@DAChoice2 MapDesPath = lookupSubst(dictionary, group)+"/"+lookupSubst(dictionary, group)+"/"+lookupSubst(dictionary, field)+"/"+lookupSubst(dictionary, target);
		
		return MapDesPath;
		}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //@DAwtx match a number with optional '-' and decimal.
	}
	
/********************************************************************/

	public static PrintDocHandler ParseDictionary()throws URISyntaxException, IOException {

		/**
		 * @param args 
		 */
		PrintDocHandler docHandler = null; // Get visibility of the docHandler outside of the Main Method
		
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
			parser.setRootElement("DictionaryCSV", null);
			
			// set document to parse - the CSV file containing our mapping meta-data
			// take input from diction file called	MapName+"Dictionary.csv"

			File inputFile = new File(baseMapName+"Dictionary.csv");
			
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
			metaData.docHandler = new PrintDocHandler(); 
			//Create a new instance of the doc handler - this gives us
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
				// the parser will call the docHandler methods - See PrintDocHandler.java
				// in order to grab the element values as the parser runs
				success = parser.parseAll();		
				System.out.println("\nParsing complete: parseAll() returned " + success);
				
				// validate that the object is being populated....

				System.out.println("sourceMessage:"+ metaData.docHandler.getModel().mapDef.srcMessage);
				System.out.println("sourceSchema :"+ metaData.docHandler.getModel().mapDef.srcSchema);
				System.out.println("sourceParser :"+ metaData.docHandler.getModel().mapDef.srcParser);				
				System.out.println("targetMessage:"+ metaData.docHandler.getModel().mapDef.trgMessage);
				System.out.println("targetSchema :"+ metaData.docHandler.getModel().mapDef.trgSchema);
				System.out.println("targetParser :"+ metaData.docHandler.getModel().mapDef.trgParser);
				
				for (int i = 0; i < metaData.docHandler.getModel().getSubstMapping().size();i++)
				{		
					System.out.println("Source Field Value Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).srcField);
					System.out.println("Target Field Value Line:" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).trgField);
					System.out.println("Description Value Line :" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).description);
					System.out.println("spare 1 Value Line     :" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).spare1);
					System.out.println("spare 2 Value Line     :" + i + " " +  metaData.docHandler.getModel().getSubstMapping().get(i).spare2);
					
				}				
				
				if (!success){
					System.exit(1);
				}
				
			} catch (DFDLException e) {
				System.err.println("DFDL exception while processing : " + e.getMessage() );
			}
			return metaData.docHandler;
			}
			
			public static String lookupSubst(PrintDocHandler dictionary, String mySubstValue) {

				for (int i = 0; i < dictionary.getModel().getSubstMapping().size();i++)
				{
					System.out.println("lookupSubst - looking up:"+mySubstValue+" at row offset:"+i);
				
					if ((dictionary.getModel().getSubstMapping().get(i).srcField).equalsIgnoreCase(mySubstValue)) 
					{ // if your substitution value is found return the replacement
						System.out.println("lookupSubst - looked up:"+mySubstValue+" returning:"+dictionary.getModel().getSubstMapping().get(i).trgField);
						return(dictionary.getModel().getSubstMapping().get(i).trgField);  //match 
					} // end if
				} // end of the loop for substitution entries
				    System.out.println("lookupSubst - no substitution required");
					return(mySubstValue);  // no substitution required 

				}
	
/********************************************************************/
	
}// end
