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
 *         &lt;element ref="{}FetchAs"/>
 *         &lt;element ref="{}GET"/>
 *         &lt;element ref="{}Backup" minOccurs="0"/>
 *         &lt;element ref="{}MetaDataLocation" minOccurs="0"/>
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
    "fetchAs",
    "get",
    "backup",
    "metaDataLocation"
})
@XmlRootElement(name = "SourceRule")
public class SourceRule {

    @XmlElement(name = "FetchAs", required = true)
    protected FetchAs fetchAs;
    @XmlElement(name = "GET", required = true)
    protected GET get;
    @XmlElement(name = "Backup")
    protected Backup backup;
    @XmlElement(name = "MetaDataLocation")
    protected String metaDataLocation;

    /**
     * Gets the value of the fetchAs property.
     * 
     * @return
     *     possible object is
     *     {@link FetchAs }
     *     
     */
    public FetchAs getFetchAs() {
        return fetchAs;
    }

    /**
     * Sets the value of the fetchAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link FetchAs }
     *     
     */
    public void setFetchAs(FetchAs value) {
        this.fetchAs = value;
    }

    /**
     * Gets the value of the get property.
     * 
     * @return
     *     possible object is
     *     {@link GET }
     *     
     */
    public GET getGET() {
        return get;
    }

    /**
     * Sets the value of the get property.
     * 
     * @param value
     *     allowed object is
     *     {@link GET }
     *     
     */
    public void setGET(GET value) {
        this.get = value;
    }

    /**
     * Gets the value of the backup property.
     * 
     * @return
     *     possible object is
     *     {@link Backup }
     *     
     */
    public Backup getBackup() {
        return backup;
    }

    /**
     * Sets the value of the backup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Backup }
     *     
     */
    public void setBackup(Backup value) {
        this.backup = value;
    }

    /**
     * Gets the value of the metaDataLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaDataLocation() {
        return metaDataLocation;
    }

    /**
     * Sets the value of the metaDataLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaDataLocation(String value) {
        this.metaDataLocation = value;
    }

}