//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.28 at 01:32:25 PM AEDT 
//


package com.ibm.msl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * 
 * A <i>Policy</i> represents an XML policy to apply to mappings.
 * Use only when '<i>generation/@engine</i>' is XSLT. 
 *       
 * 
 * <p>Java class for Policy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Policy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.ibm.com/2008/ccl/Mapping}policy" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Policy", propOrder = {
    "policy"
})
public class Policy {

    @XmlElements({
        @XmlElement(name = "missingSource", type = Policy.MissingSource.class),
        @XmlElement(name = "emptySource", type = Policy.EmptySource.class),
        @XmlElement(name = "nilSource", type = Policy.NilSource.class),
        @XmlElement(name = "unmappedTarget", type = Policy.UnmappedTarget.class),
        @XmlElement(name = "defaultValues", type = Policy.DefaultValues.class)
    })
    protected List<Object> policy;

    /**
     * Gets the value of the policy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the policy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Policy.MissingSource }
     * {@link Policy.EmptySource }
     * {@link Policy.NilSource }
     * {@link Policy.UnmappedTarget }
     * {@link Policy.DefaultValues }
     * 
     * 
     */
    public List<Object> getPolicy() {
        if (policy == null) {
            policy = new ArrayList<Object>();
        }
        return this.policy;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;anyAttribute processContents='lax'/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DefaultValues {

        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="auto" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nothing" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class EmptySource {

        @XmlAttribute(name = "auto")
        protected Boolean auto;
        @XmlAttribute(name = "default")
        protected Boolean _default;
        @XmlAttribute(name = "default_reqOnly")
        protected Boolean defaultReqOnly;
        @XmlAttribute(name = "empty")
        protected Boolean empty;
        @XmlAttribute(name = "nil_reqOnly")
        protected Boolean nilReqOnly;
        @XmlAttribute(name = "nil")
        protected Boolean nil;
        @XmlAttribute(name = "nothing")
        protected Boolean nothing;
        @XmlAttribute(name = "empty_reqOnly")
        protected Boolean emptyReqOnly;

        /**
         * Gets the value of the auto property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAuto() {
            return auto;
        }

        /**
         * Sets the value of the auto property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAuto(Boolean value) {
            this.auto = value;
        }

        /**
         * Gets the value of the default property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefault() {
            return _default;
        }

        /**
         * Sets the value of the default property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefault(Boolean value) {
            this._default = value;
        }

        /**
         * Gets the value of the defaultReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefaultReqOnly() {
            return defaultReqOnly;
        }

        /**
         * Sets the value of the defaultReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefaultReqOnly(Boolean value) {
            this.defaultReqOnly = value;
        }

        /**
         * Gets the value of the empty property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmpty() {
            return empty;
        }

        /**
         * Sets the value of the empty property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmpty(Boolean value) {
            this.empty = value;
        }

        /**
         * Gets the value of the nilReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNilReqOnly() {
            return nilReqOnly;
        }

        /**
         * Sets the value of the nilReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNilReqOnly(Boolean value) {
            this.nilReqOnly = value;
        }

        /**
         * Gets the value of the nil property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNil() {
            return nil;
        }

        /**
         * Sets the value of the nil property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNil(Boolean value) {
            this.nil = value;
        }

        /**
         * Gets the value of the nothing property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNothing() {
            return nothing;
        }

        /**
         * Sets the value of the nothing property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNothing(Boolean value) {
            this.nothing = value;
        }

        /**
         * Gets the value of the emptyReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmptyReqOnly() {
            return emptyReqOnly;
        }

        /**
         * Sets the value of the emptyReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmptyReqOnly(Boolean value) {
            this.emptyReqOnly = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="auto" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="reqonly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nothing" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MissingSource {

        @XmlAttribute(name = "auto")
        protected Boolean auto;
        @XmlAttribute(name = "default")
        protected Boolean _default;
        @XmlAttribute(name = "default_reqOnly")
        protected Boolean defaultReqOnly;
        @XmlAttribute(name = "empty")
        protected Boolean empty;
        @XmlAttribute(name = "reqonly")
        protected Boolean reqonly;
        @XmlAttribute(name = "nothing")
        protected Boolean nothing;
        @XmlAttribute(name = "empty_reqOnly")
        protected Boolean emptyReqOnly;
        @XmlAttribute(name = "nil_reqOnly")
        protected Boolean nilReqOnly;
        @XmlAttribute(name = "nil")
        protected Boolean nil;

        /**
         * Gets the value of the auto property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAuto() {
            return auto;
        }

        /**
         * Sets the value of the auto property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAuto(Boolean value) {
            this.auto = value;
        }

        /**
         * Gets the value of the default property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefault() {
            return _default;
        }

        /**
         * Sets the value of the default property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefault(Boolean value) {
            this._default = value;
        }

        /**
         * Gets the value of the defaultReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefaultReqOnly() {
            return defaultReqOnly;
        }

        /**
         * Sets the value of the defaultReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefaultReqOnly(Boolean value) {
            this.defaultReqOnly = value;
        }

        /**
         * Gets the value of the empty property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmpty() {
            return empty;
        }

        /**
         * Sets the value of the empty property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmpty(Boolean value) {
            this.empty = value;
        }

        /**
         * Gets the value of the reqonly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isReqonly() {
            return reqonly;
        }

        /**
         * Sets the value of the reqonly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setReqonly(Boolean value) {
            this.reqonly = value;
        }

        /**
         * Gets the value of the nothing property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNothing() {
            return nothing;
        }

        /**
         * Sets the value of the nothing property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNothing(Boolean value) {
            this.nothing = value;
        }

        /**
         * Gets the value of the emptyReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmptyReqOnly() {
            return emptyReqOnly;
        }

        /**
         * Sets the value of the emptyReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmptyReqOnly(Boolean value) {
            this.emptyReqOnly = value;
        }

        /**
         * Gets the value of the nilReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNilReqOnly() {
            return nilReqOnly;
        }

        /**
         * Sets the value of the nilReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNilReqOnly(Boolean value) {
            this.nilReqOnly = value;
        }

        /**
         * Gets the value of the nil property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNil() {
            return nil;
        }

        /**
         * Sets the value of the nil property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNil(Boolean value) {
            this.nil = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="auto" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nothing" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class NilSource {

        @XmlAttribute(name = "auto")
        protected Boolean auto;
        @XmlAttribute(name = "default")
        protected Boolean _default;
        @XmlAttribute(name = "default_reqOnly")
        protected Boolean defaultReqOnly;
        @XmlAttribute(name = "empty")
        protected Boolean empty;
        @XmlAttribute(name = "nothing")
        protected Boolean nothing;
        @XmlAttribute(name = "empty_reqOnly")
        protected Boolean emptyReqOnly;
        @XmlAttribute(name = "nil")
        protected Boolean nil;
        @XmlAttribute(name = "nil_reqOnly")
        protected Boolean nilReqOnly;

        /**
         * Gets the value of the auto property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAuto() {
            return auto;
        }

        /**
         * Sets the value of the auto property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAuto(Boolean value) {
            this.auto = value;
        }

        /**
         * Gets the value of the default property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefault() {
            return _default;
        }

        /**
         * Sets the value of the default property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefault(Boolean value) {
            this._default = value;
        }

        /**
         * Gets the value of the defaultReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefaultReqOnly() {
            return defaultReqOnly;
        }

        /**
         * Sets the value of the defaultReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefaultReqOnly(Boolean value) {
            this.defaultReqOnly = value;
        }

        /**
         * Gets the value of the empty property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmpty() {
            return empty;
        }

        /**
         * Sets the value of the empty property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmpty(Boolean value) {
            this.empty = value;
        }

        /**
         * Gets the value of the nothing property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNothing() {
            return nothing;
        }

        /**
         * Sets the value of the nothing property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNothing(Boolean value) {
            this.nothing = value;
        }

        /**
         * Gets the value of the emptyReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmptyReqOnly() {
            return emptyReqOnly;
        }

        /**
         * Sets the value of the emptyReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmptyReqOnly(Boolean value) {
            this.emptyReqOnly = value;
        }

        /**
         * Gets the value of the nil property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNil() {
            return nil;
        }

        /**
         * Sets the value of the nil property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNil(Boolean value) {
            this.nil = value;
        }

        /**
         * Gets the value of the nilReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNilReqOnly() {
            return nilReqOnly;
        }

        /**
         * Sets the value of the nilReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNilReqOnly(Boolean value) {
            this.nilReqOnly = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="auto" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="default_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nothing" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="empty_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="nil_reqOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UnmappedTarget {

        @XmlAttribute(name = "auto")
        protected Boolean auto;
        @XmlAttribute(name = "default")
        protected Boolean _default;
        @XmlAttribute(name = "default_reqOnly")
        protected Boolean defaultReqOnly;
        @XmlAttribute(name = "empty")
        protected Boolean empty;
        @XmlAttribute(name = "nothing")
        protected Boolean nothing;
        @XmlAttribute(name = "empty_reqOnly")
        protected Boolean emptyReqOnly;
        @XmlAttribute(name = "nil")
        protected Boolean nil;
        @XmlAttribute(name = "nil_reqOnly")
        protected Boolean nilReqOnly;

        /**
         * Gets the value of the auto property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAuto() {
            return auto;
        }

        /**
         * Sets the value of the auto property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAuto(Boolean value) {
            this.auto = value;
        }

        /**
         * Gets the value of the default property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefault() {
            return _default;
        }

        /**
         * Sets the value of the default property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefault(Boolean value) {
            this._default = value;
        }

        /**
         * Gets the value of the defaultReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefaultReqOnly() {
            return defaultReqOnly;
        }

        /**
         * Sets the value of the defaultReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefaultReqOnly(Boolean value) {
            this.defaultReqOnly = value;
        }

        /**
         * Gets the value of the empty property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmpty() {
            return empty;
        }

        /**
         * Sets the value of the empty property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmpty(Boolean value) {
            this.empty = value;
        }

        /**
         * Gets the value of the nothing property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNothing() {
            return nothing;
        }

        /**
         * Sets the value of the nothing property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNothing(Boolean value) {
            this.nothing = value;
        }

        /**
         * Gets the value of the emptyReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEmptyReqOnly() {
            return emptyReqOnly;
        }

        /**
         * Sets the value of the emptyReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEmptyReqOnly(Boolean value) {
            this.emptyReqOnly = value;
        }

        /**
         * Gets the value of the nil property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNil() {
            return nil;
        }

        /**
         * Sets the value of the nil property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNil(Boolean value) {
            this.nil = value;
        }

        /**
         * Gets the value of the nilReqOnly property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNilReqOnly() {
            return nilReqOnly;
        }

        /**
         * Sets the value of the nilReqOnly property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNilReqOnly(Boolean value) {
            this.nilReqOnly = value;
        }

    }

}
