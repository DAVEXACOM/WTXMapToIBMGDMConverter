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
 *           &lt;element ref="{}Data.Always"/>
 *           &lt;element ref="{}Data.Never"/>
 *           &lt;element ref="{}Data.OnBurstError"/>
 *           &lt;element ref="{}Data.OnBurstWarningOrError"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{}Execution.Always"/>
 *           &lt;element ref="{}Execution.Never"/>
 *           &lt;element ref="{}Execution.OnBurstError"/>
 *           &lt;element ref="{}Execution.OnBurstWarningOrError"/>
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
    "dataAlways",
    "dataNever",
    "dataOnBurstError",
    "dataOnBurstWarningOrError",
    "executionAlways",
    "executionNever",
    "executionOnBurstError",
    "executionOnBurstWarningOrError"
})
@XmlRootElement(name = "BurstAudit")
public class BurstAudit {

    @XmlElement(name = "Data.Always")
    protected DataAlways dataAlways;
    @XmlElement(name = "Data.Never")
    protected DataNever dataNever;
    @XmlElement(name = "Data.OnBurstError")
    protected DataOnBurstError dataOnBurstError;
    @XmlElement(name = "Data.OnBurstWarningOrError")
    protected DataOnBurstWarningOrError dataOnBurstWarningOrError;
    @XmlElement(name = "Execution.Always")
    protected ExecutionAlways executionAlways;
    @XmlElement(name = "Execution.Never")
    protected ExecutionNever executionNever;
    @XmlElement(name = "Execution.OnBurstError")
    protected ExecutionOnBurstError executionOnBurstError;
    @XmlElement(name = "Execution.OnBurstWarningOrError")
    protected ExecutionOnBurstWarningOrError executionOnBurstWarningOrError;

    /**
     * Gets the value of the dataAlways property.
     * 
     * @return
     *     possible object is
     *     {@link DataAlways }
     *     
     */
    public DataAlways getDataAlways() {
        return dataAlways;
    }

    /**
     * Sets the value of the dataAlways property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataAlways }
     *     
     */
    public void setDataAlways(DataAlways value) {
        this.dataAlways = value;
    }

    /**
     * Gets the value of the dataNever property.
     * 
     * @return
     *     possible object is
     *     {@link DataNever }
     *     
     */
    public DataNever getDataNever() {
        return dataNever;
    }

    /**
     * Sets the value of the dataNever property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataNever }
     *     
     */
    public void setDataNever(DataNever value) {
        this.dataNever = value;
    }

    /**
     * Gets the value of the dataOnBurstError property.
     * 
     * @return
     *     possible object is
     *     {@link DataOnBurstError }
     *     
     */
    public DataOnBurstError getDataOnBurstError() {
        return dataOnBurstError;
    }

    /**
     * Sets the value of the dataOnBurstError property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataOnBurstError }
     *     
     */
    public void setDataOnBurstError(DataOnBurstError value) {
        this.dataOnBurstError = value;
    }

    /**
     * Gets the value of the dataOnBurstWarningOrError property.
     * 
     * @return
     *     possible object is
     *     {@link DataOnBurstWarningOrError }
     *     
     */
    public DataOnBurstWarningOrError getDataOnBurstWarningOrError() {
        return dataOnBurstWarningOrError;
    }

    /**
     * Sets the value of the dataOnBurstWarningOrError property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataOnBurstWarningOrError }
     *     
     */
    public void setDataOnBurstWarningOrError(DataOnBurstWarningOrError value) {
        this.dataOnBurstWarningOrError = value;
    }

    /**
     * Gets the value of the executionAlways property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionAlways }
     *     
     */
    public ExecutionAlways getExecutionAlways() {
        return executionAlways;
    }

    /**
     * Sets the value of the executionAlways property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionAlways }
     *     
     */
    public void setExecutionAlways(ExecutionAlways value) {
        this.executionAlways = value;
    }

    /**
     * Gets the value of the executionNever property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionNever }
     *     
     */
    public ExecutionNever getExecutionNever() {
        return executionNever;
    }

    /**
     * Sets the value of the executionNever property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionNever }
     *     
     */
    public void setExecutionNever(ExecutionNever value) {
        this.executionNever = value;
    }

    /**
     * Gets the value of the executionOnBurstError property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionOnBurstError }
     *     
     */
    public ExecutionOnBurstError getExecutionOnBurstError() {
        return executionOnBurstError;
    }

    /**
     * Sets the value of the executionOnBurstError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionOnBurstError }
     *     
     */
    public void setExecutionOnBurstError(ExecutionOnBurstError value) {
        this.executionOnBurstError = value;
    }

    /**
     * Gets the value of the executionOnBurstWarningOrError property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionOnBurstWarningOrError }
     *     
     */
    public ExecutionOnBurstWarningOrError getExecutionOnBurstWarningOrError() {
        return executionOnBurstWarningOrError;
    }

    /**
     * Sets the value of the executionOnBurstWarningOrError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionOnBurstWarningOrError }
     *     
     */
    public void setExecutionOnBurstWarningOrError(ExecutionOnBurstWarningOrError value) {
        this.executionOnBurstWarningOrError = value;
    }

}
