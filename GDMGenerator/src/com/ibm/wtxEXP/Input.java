//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.11 at 04:11:46 PM AEDT 
//


package com.ibm.wtxEXP;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Schema"/>
 *         &lt;element ref="{}NativeXSDCustomization" minOccurs="0"/>
 *         &lt;element ref="{}NameSpaces" minOccurs="0"/>
 *         &lt;element ref="{}SourceRule" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "schema",
    "nativeXSDCustomization",
    "nameSpaces",
    "sourceRule"
})
@XmlRootElement(name = "Input")
public class Input {

    @XmlElement(name = "Schema", required = true)
    protected Schema schema;
    @XmlElement(name = "NativeXSDCustomization")
    protected NativeXSDCustomization nativeXSDCustomization;
    @XmlElement(name = "NameSpaces")
    protected NameSpaces nameSpaces;
    @XmlElement(name = "SourceRule")
    protected SourceRule sourceRule;

    /**
     * Gets the value of the schema property.
     * 
     * @return
     *     possible object is
     *     {@link Schema }
     *     
     */
    public Schema getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schema }
     *     
     */
    public void setSchema(Schema value) {
        this.schema = value;
    }

    /**
     * Gets the value of the nativeXSDCustomization property.
     * 
     * @return
     *     possible object is
     *     {@link NativeXSDCustomization }
     *     
     */
    public NativeXSDCustomization getNativeXSDCustomization() {
        return nativeXSDCustomization;
    }

    /**
     * Sets the value of the nativeXSDCustomization property.
     * 
     * @param value
     *     allowed object is
     *     {@link NativeXSDCustomization }
     *     
     */
    public void setNativeXSDCustomization(NativeXSDCustomization value) {
        this.nativeXSDCustomization = value;
    }

    /**
     * Gets the value of the nameSpaces property.
     * 
     * @return
     *     possible object is
     *     {@link NameSpaces }
     *     
     */
    public NameSpaces getNameSpaces() {
        return nameSpaces;
    }

    /**
     * Sets the value of the nameSpaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameSpaces }
     *     
     */
    public void setNameSpaces(NameSpaces value) {
        this.nameSpaces = value;
    }

    /**
     * Gets the value of the sourceRule property.
     * 
     * @return
     *     possible object is
     *     {@link SourceRule }
     *     
     */
    public SourceRule getSourceRule() {
        return sourceRule;
    }

    /**
     * Sets the value of the sourceRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceRule }
     *     
     */
    public void setSourceRule(SourceRule value) {
        this.sourceRule = value;
    }

}
