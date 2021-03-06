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
 *         &lt;choice>
 *           &lt;element ref="{}Directory.Map"/>
 *           &lt;element ref="{}Directory.Custom"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{}WorkFilePrefix.MapName"/>
 *           &lt;element ref="{}WorkFilePrefix.Unique"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="PageSize" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PageCount" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "directoryMap",
    "directoryCustom",
    "workFilePrefixMapName",
    "workFilePrefixUnique"
})
@XmlRootElement(name = "WorkSpace.File")
public class WorkSpaceFile {

    @XmlElement(name = "Directory.Map")
    protected DirectoryMap directoryMap;
    @XmlElement(name = "Directory.Custom")
    protected String directoryCustom;
    @XmlElement(name = "WorkFilePrefix.MapName")
    protected WorkFilePrefixMapName workFilePrefixMapName;
    @XmlElement(name = "WorkFilePrefix.Unique")
    protected WorkFilePrefixUnique workFilePrefixUnique;
    @XmlAttribute(name = "PageSize", required = true)
    protected String pageSize;
    @XmlAttribute(name = "PageCount", required = true)
    protected String pageCount;

    /**
     * Gets the value of the directoryMap property.
     * 
     * @return
     *     possible object is
     *     {@link DirectoryMap }
     *     
     */
    public DirectoryMap getDirectoryMap() {
        return directoryMap;
    }

    /**
     * Sets the value of the directoryMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectoryMap }
     *     
     */
    public void setDirectoryMap(DirectoryMap value) {
        this.directoryMap = value;
    }

    /**
     * Gets the value of the directoryCustom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectoryCustom() {
        return directoryCustom;
    }

    /**
     * Sets the value of the directoryCustom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectoryCustom(String value) {
        this.directoryCustom = value;
    }

    /**
     * Gets the value of the workFilePrefixMapName property.
     * 
     * @return
     *     possible object is
     *     {@link WorkFilePrefixMapName }
     *     
     */
    public WorkFilePrefixMapName getWorkFilePrefixMapName() {
        return workFilePrefixMapName;
    }

    /**
     * Sets the value of the workFilePrefixMapName property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkFilePrefixMapName }
     *     
     */
    public void setWorkFilePrefixMapName(WorkFilePrefixMapName value) {
        this.workFilePrefixMapName = value;
    }

    /**
     * Gets the value of the workFilePrefixUnique property.
     * 
     * @return
     *     possible object is
     *     {@link WorkFilePrefixUnique }
     *     
     */
    public WorkFilePrefixUnique getWorkFilePrefixUnique() {
        return workFilePrefixUnique;
    }

    /**
     * Sets the value of the workFilePrefixUnique property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkFilePrefixUnique }
     *     
     */
    public void setWorkFilePrefixUnique(WorkFilePrefixUnique value) {
        this.workFilePrefixUnique = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageSize(String value) {
        this.pageSize = value;
    }

    /**
     * Gets the value of the pageCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageCount(String value) {
        this.pageCount = value;
    }

}
