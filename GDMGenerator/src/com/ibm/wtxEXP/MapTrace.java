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
 *         &lt;element ref="{}ContentTrace.File"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Switch" default="OFF">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="ON"/>
 *             &lt;enumeration value="OFF"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contentTraceFile"
})
@XmlRootElement(name = "MapTrace")
public class MapTrace {

    @XmlElement(name = "ContentTrace.File", required = true)
    protected ContentTraceFile contentTraceFile;
    @XmlAttribute(name = "Switch")
    protected String _switch;

    /**
     * Gets the value of the contentTraceFile property.
     * 
     * @return
     *     possible object is
     *     {@link ContentTraceFile }
     *     
     */
    public ContentTraceFile getContentTraceFile() {
        return contentTraceFile;
    }

    /**
     * Sets the value of the contentTraceFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentTraceFile }
     *     
     */
    public void setContentTraceFile(ContentTraceFile value) {
        this.contentTraceFile = value;
    }

    /**
     * Gets the value of the switch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitch() {
        if (_switch == null) {
            return "OFF";
        } else {
            return _switch;
        }
    }

    /**
     * Sets the value of the switch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitch(String value) {
        this._switch = value;
    }

}