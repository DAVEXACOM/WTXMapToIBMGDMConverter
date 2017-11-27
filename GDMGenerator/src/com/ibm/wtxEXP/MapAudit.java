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
 *         &lt;element ref="{}BurstAudit"/>
 *         &lt;element ref="{}SummaryAudit"/>
 *         &lt;element ref="{}SettingsAudit"/>
 *         &lt;choice>
 *           &lt;element ref="{}AuditLocation.File"/>
 *           &lt;element ref="{}AuditLocation.Memory"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Switch" use="required">
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
    "burstAudit",
    "summaryAudit",
    "settingsAudit",
    "auditLocationFile",
    "auditLocationMemory"
})
@XmlRootElement(name = "MapAudit")
public class MapAudit {

    @XmlElement(name = "BurstAudit", required = true)
    protected BurstAudit burstAudit;
    @XmlElement(name = "SummaryAudit", required = true)
    protected SummaryAudit summaryAudit;
    @XmlElement(name = "SettingsAudit", required = true)
    protected SettingsAudit settingsAudit;
    @XmlElement(name = "AuditLocation.File")
    protected AuditLocationFile auditLocationFile;
    @XmlElement(name = "AuditLocation.Memory")
    protected AuditLocationMemory auditLocationMemory;
    @XmlAttribute(name = "Switch", required = true)
    protected String _switch;

    /**
     * Gets the value of the burstAudit property.
     * 
     * @return
     *     possible object is
     *     {@link BurstAudit }
     *     
     */
    public BurstAudit getBurstAudit() {
        return burstAudit;
    }

    /**
     * Sets the value of the burstAudit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BurstAudit }
     *     
     */
    public void setBurstAudit(BurstAudit value) {
        this.burstAudit = value;
    }

    /**
     * Gets the value of the summaryAudit property.
     * 
     * @return
     *     possible object is
     *     {@link SummaryAudit }
     *     
     */
    public SummaryAudit getSummaryAudit() {
        return summaryAudit;
    }

    /**
     * Sets the value of the summaryAudit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryAudit }
     *     
     */
    public void setSummaryAudit(SummaryAudit value) {
        this.summaryAudit = value;
    }

    /**
     * Gets the value of the settingsAudit property.
     * 
     * @return
     *     possible object is
     *     {@link SettingsAudit }
     *     
     */
    public SettingsAudit getSettingsAudit() {
        return settingsAudit;
    }

    /**
     * Sets the value of the settingsAudit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettingsAudit }
     *     
     */
    public void setSettingsAudit(SettingsAudit value) {
        this.settingsAudit = value;
    }

    /**
     * Gets the value of the auditLocationFile property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLocationFile }
     *     
     */
    public AuditLocationFile getAuditLocationFile() {
        return auditLocationFile;
    }

    /**
     * Sets the value of the auditLocationFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLocationFile }
     *     
     */
    public void setAuditLocationFile(AuditLocationFile value) {
        this.auditLocationFile = value;
    }

    /**
     * Gets the value of the auditLocationMemory property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLocationMemory }
     *     
     */
    public AuditLocationMemory getAuditLocationMemory() {
        return auditLocationMemory;
    }

    /**
     * Sets the value of the auditLocationMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLocationMemory }
     *     
     */
    public void setAuditLocationMemory(AuditLocationMemory value) {
        this.auditLocationMemory = value;
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
        return _switch;
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