//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.28 at 01:32:25 PM AEDT 
//


package com.ibm.msl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * A <i>Transaction</i> provides a container
 * to bound an operation, return and failure of a database mapping.
 *       
 * 
 * <p>Java class for Transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ibm.com/2008/ccl/Mapping}MappingGroup">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}select" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}insert" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}update" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}delete" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}return" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}rdbcall" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}rdbreturn" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}failure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction", propOrder = {
    "select",
    "insert",
    "update",
    "delete",
    "_return",
    "rdbcall",
    "rdbreturn",
    "failure"
})
public class Transaction
    extends MappingGroup
{

    protected DatabaseMapping select;
    protected DatabaseMapping insert;
    protected DatabaseMapping update;
    protected DatabaseMapping delete;
    @XmlElement(name = "return")
    protected DatabaseMapping _return;
    protected DatabaseMapping rdbcall;
    protected DatabaseMapping rdbreturn;
    protected DatabaseMapping failure;

    /**
     * Gets the value of the select property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getSelect() {
        return select;
    }

    /**
     * Sets the value of the select property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setSelect(DatabaseMapping value) {
        this.select = value;
    }

    /**
     * Gets the value of the insert property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getInsert() {
        return insert;
    }

    /**
     * Sets the value of the insert property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setInsert(DatabaseMapping value) {
        this.insert = value;
    }

    /**
     * Gets the value of the update property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getUpdate() {
        return update;
    }

    /**
     * Sets the value of the update property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setUpdate(DatabaseMapping value) {
        this.update = value;
    }

    /**
     * Gets the value of the delete property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setDelete(DatabaseMapping value) {
        this.delete = value;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setReturn(DatabaseMapping value) {
        this._return = value;
    }

    /**
     * Gets the value of the rdbcall property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getRdbcall() {
        return rdbcall;
    }

    /**
     * Sets the value of the rdbcall property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setRdbcall(DatabaseMapping value) {
        this.rdbcall = value;
    }

    /**
     * Gets the value of the rdbreturn property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getRdbreturn() {
        return rdbreturn;
    }

    /**
     * Sets the value of the rdbreturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setRdbreturn(DatabaseMapping value) {
        this.rdbreturn = value;
    }

    /**
     * Gets the value of the failure property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseMapping }
     *     
     */
    public DatabaseMapping getFailure() {
        return failure;
    }

    /**
     * Sets the value of the failure property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseMapping }
     *     
     */
    public void setFailure(DatabaseMapping value) {
        this.failure = value;
    }

}
