//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.28 at 01:32:25 PM AEDT 
//


package com.ibm.msl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * From v1050, an <i>Updates</i> is a container Mapping that allows certain
 * Mappings to be applied between children of the input and output of the parent
 * <i>passthrough</i> to "override" the implicit data copy with specific mappings
 * that determine the target output.
 *       
 * 
 * <p>Java class for Updates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Updates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.ibm.com/2008/ccl/Mapping}nested" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Updates", propOrder = {
    "nested"
})
public class Updates {

    @XmlElementRefs({
        @XmlElementRef(name = "custom", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "insert", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "update", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "select", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "delete", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "remove", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lookup", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "task", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "create", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "join", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "transaction", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "submap", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "foreach", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "local", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "if", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "move", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "condition", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "expression", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "passthrough", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "append", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "group", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "convert", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "customFunction", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "assign", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "function", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rdbcall", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> nested;

    /**
     * Gets the value of the nested property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nested property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNested().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Custom }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link Remove }{@code >}
     * {@link JAXBElement }{@code <}{@link Lookup }{@code >}
     * {@link JAXBElement }{@code <}{@link Task }{@code >}
     * {@link JAXBElement }{@code <}{@link Create }{@code >}
     * {@link JAXBElement }{@code <}{@link Join }{@code >}
     * {@link JAXBElement }{@code <}{@link Transaction }{@code >}
     * {@link JAXBElement }{@code <}{@link Submap }{@code >}
     * {@link JAXBElement }{@code <}{@link Foreach }{@code >}
     * {@link JAXBElement }{@code <}{@link Local }{@code >}
     * {@link JAXBElement }{@code <}{@link If }{@code >}
     * {@link JAXBElement }{@code <}{@link Move }{@code >}
     * {@link JAXBElement }{@code <}{@link Condition }{@code >}
     * {@link JAXBElement }{@code <}{@link Expression }{@code >}
     * {@link JAXBElement }{@code <}{@link Passthrough }{@code >}
     * {@link JAXBElement }{@code <}{@link Append }{@code >}
     * {@link JAXBElement }{@code <}{@link Group }{@code >}
     * {@link JAXBElement }{@code <}{@link Convert }{@code >}
     * {@link JAXBElement }{@code <}{@link CustomFunction }{@code >}
     * {@link JAXBElement }{@code <}{@link Assign }{@code >}
     * {@link JAXBElement }{@code <}{@link Function }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getNested() {
        if (nested == null) {
            nested = new ArrayList<JAXBElement<?>>();
        }
        return this.nested;
    }

}
