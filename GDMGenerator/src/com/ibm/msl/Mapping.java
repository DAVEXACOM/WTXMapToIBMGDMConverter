//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.28 at 01:32:25 PM AEDT 
//


package com.ibm.msl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * A Mapping is used to associate one or more sources (inputs) with
 * one or more targets (outputs) in order to define a transformation.
 * 
 * Mappings can be categorized into the following:
 * <ul>
 * <li><b>General Transforms:</b> Move Submap Custom Assign Local</li>
 * <li><b>Control Flow Mechanisms:</b> Foreach Append Join Group If Elseif Else</li>
 * <li><b>Built-in Functions:</b> Concat Substring Normalize</li>
 * <li><b>Database Operations:</b> Select Insert Update Delete Routine</li>
 * </ul>
 * 
 * <b>attributes</b>
 * <ul>
 * <li><i>automap</i>
 * The Mapping was generated as a reult of using auto map action.
 * .</li>
 * </ul>
 *       
 * 
 * <p>Java class for Mapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Mapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="automap" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mapping")
@XmlSeeAlso({
    Expression.class,
    Assign.class,
    Passthrough.class,
    MappingDeclaration.class,
    Lookup.class,
    Function.class,
    DatabaseMapping.class,
    Move.class,
    Custom.class,
    Else.class,
    Append.class,
    Submap.class,
    Create.class,
    If.class,
    Foreach.class,
    Remove.class,
    Convert.class,
    Task.class,
    Join.class,
    Local.class,
    Group.class
})
public abstract class Mapping {

    @XmlAttribute(name = "automap")
    protected Boolean automap;

    /**
     * Gets the value of the automap property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutomap() {
        return automap;
    }

    /**
     * Sets the value of the automap property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutomap(Boolean value) {
        this.automap = value;
    }

}
