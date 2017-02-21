package com.kpap.client.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * 专利库检索命中专利数量统计<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-17 下午01:19:18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sectionInfo", propOrder = {
    "patentCount",
    "sectionName"
})
public class SectionInfo {

    protected int patentCount; // 表示对应的专利类型的数量
    protected String sectionName; //表示专利类型，专利类型分别为：发明公开：FM；发明授权：SQ；实用新型：XX；外观设计：WG

    /**
     * Gets the value of the patentCount property.
     * 
     */
    public int getPatentCount() {
        return patentCount;
    }

    /**
     * Sets the value of the patentCount property.
     * 
     */
    public void setPatentCount(int value) {
        this.patentCount = value;
    }

    /**
     * Gets the value of the sectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * Sets the value of the sectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectionName(String value) {
        this.sectionName = value;
    }

}
