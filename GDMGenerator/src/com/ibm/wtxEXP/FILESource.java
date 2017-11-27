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
 *         &lt;element ref="{}FilePath"/>
 *         &lt;element ref="{}FILE_Source.Transaction"/>
 *         &lt;element ref="{}Retry"/>
 *         &lt;element ref="{}DocumentVerification"/>
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
    "filePath",
    "fileSourceTransaction",
    "retry",
    "documentVerification"
})
@XmlRootElement(name = "FILE_Source")
public class FILESource {

    @XmlElement(name = "FilePath", required = true)
    protected String filePath;
    @XmlElement(name = "FILE_Source.Transaction", required = true)
    protected FILESourceTransaction fileSourceTransaction;
    @XmlElement(name = "Retry", required = true)
    protected Retry retry;
    @XmlElement(name = "DocumentVerification", required = true)
    protected String documentVerification;

    /**
     * Gets the value of the filePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the value of the filePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePath(String value) {
        this.filePath = value;
    }

    /**
     * Gets the value of the fileSourceTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link FILESourceTransaction }
     *     
     */
    public FILESourceTransaction getFILESourceTransaction() {
        return fileSourceTransaction;
    }

    /**
     * Sets the value of the fileSourceTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link FILESourceTransaction }
     *     
     */
    public void setFILESourceTransaction(FILESourceTransaction value) {
        this.fileSourceTransaction = value;
    }

    /**
     * Gets the value of the retry property.
     * 
     * @return
     *     possible object is
     *     {@link Retry }
     *     
     */
    public Retry getRetry() {
        return retry;
    }

    /**
     * Sets the value of the retry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Retry }
     *     
     */
    public void setRetry(Retry value) {
        this.retry = value;
    }

    /**
     * Gets the value of the documentVerification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentVerification() {
        return documentVerification;
    }

    /**
     * Sets the value of the documentVerification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentVerification(String value) {
        this.documentVerification = value;
    }

}