//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.11 at 04:11:46 PM AEDT 
//


package com.ibm.wtxEXP;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="OnSuccess" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OnFailure" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Scope" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "FILE_Source.Transaction")
public class FILESourceTransaction {

    @XmlAttribute(name = "OnSuccess")
    protected String onSuccess;
    @XmlAttribute(name = "OnFailure")
    protected String onFailure;
    @XmlAttribute(name = "Scope")
    protected String scope;

    /**
     * Gets the value of the onSuccess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnSuccess() {
        return onSuccess;
    }

    /**
     * Sets the value of the onSuccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnSuccess(String value) {
        this.onSuccess = value;
    }

    /**
     * Gets the value of the onFailure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnFailure() {
        return onFailure;
    }

    /**
     * Sets the value of the onFailure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnFailure(String value) {
        this.onFailure = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

}
