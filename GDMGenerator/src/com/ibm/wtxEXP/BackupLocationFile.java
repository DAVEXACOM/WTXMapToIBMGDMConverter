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
 *         &lt;element ref="{}Directory.Map"/>
 *         &lt;element ref="{}FileName.Unique"/>
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
    "fileNameUnique"
})
@XmlRootElement(name = "BackupLocation.File")
public class BackupLocationFile {

    @XmlElement(name = "Directory.Map", required = true)
    protected DirectoryMap directoryMap;
    @XmlElement(name = "FileName.Unique", required = true)
    protected FileNameUnique fileNameUnique;

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
     * Gets the value of the fileNameUnique property.
     * 
     * @return
     *     possible object is
     *     {@link FileNameUnique }
     *     
     */
    public FileNameUnique getFileNameUnique() {
        return fileNameUnique;
    }

    /**
     * Sets the value of the fileNameUnique property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileNameUnique }
     *     
     */
    public void setFileNameUnique(FileNameUnique value) {
        this.fileNameUnique = value;
    }

}