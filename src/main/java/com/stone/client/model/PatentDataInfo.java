package com.kpap.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patentDataInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patentDataInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataList" type="{http://client.eval.ipph.cn/}patentIndexInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sectionList" type="{http://client.eval.ipph.cn/}sectionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patentDataInfo", propOrder = {
    "company",
    "dataList",
    "sectionList"
})
public class PatentDataInfo {

    protected String company;
    @XmlElement(nillable = true)
    protected List<PatentIndexInfo> dataList;
    @XmlElement(nillable = true)
    protected List<SectionInfo> sectionList;

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the dataList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PatentIndexInfo }
     * 
     * 
     */
    public List<PatentIndexInfo> getDataList() {
        if (dataList == null) {
            dataList = new ArrayList<PatentIndexInfo>();
        }
        return this.dataList;
    }

    /**
     * Gets the value of the sectionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sectionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSectionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SectionInfo }
     * 
     * 
     */
    public List<SectionInfo> getSectionList() {
        if (sectionList == null) {
            sectionList = new ArrayList<SectionInfo>();
        }
        return this.sectionList;
    }

}
