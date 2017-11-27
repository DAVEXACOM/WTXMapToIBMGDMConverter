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
 *         &lt;choice>
 *           &lt;element ref="{}Directory.Map"/>
 *           &lt;element ref="{}Directory.Custom"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{}FileName.Default"/>
 *           &lt;element ref="{}FileName.Custom"/>
 *         &lt;/choice>
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
    "directoryMap",
    "directoryCustom",
    "fileNameDefault",
    "fileNameCustom"
})
@XmlRootElement(name = "TraceLocation.File")
public class TraceLocationFile {

    @XmlElement(name = "Directory.Map")
    protected DirectoryMap directoryMap;
    @XmlElement(name = "Directory.Custom")
    protected String directoryCustom;
    @XmlElement(name = "FileName.Default")
    protected FileNameDefault fileNameDefault;
    @XmlElement(name = "FileName.Custom")
    protected FileNameCustom fileNameCustom;

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
     * Gets the value of the fileNameDefault property.
     * 
     * @return
     *     possible object is
     *     {@link FileNameDefault }
     *     
     */
    public FileNameDefault getFileNameDefault() {
        return fileNameDefault;
    }

    /**
     * Sets the value of the fileNameDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileNameDefault }
     *     
     */
    public void setFileNameDefault(FileNameDefault value) {
        this.fileNameDefault = value;
    }

    /**
     * Gets the value of the fileNameCustom property.
     * 
     * @return
     *     possible object is
     *     {@link FileNameCustom }
     *     
     */
    public FileNameCustom getFileNameCustom() {
        return fileNameCustom;
    }

    /**
     * Sets the value of the fileNameCustom property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileNameCustom }
     *     
     */
    public void setFileNameCustom(FileNameCustom value) {
        this.fileNameCustom = value;
    }

}
