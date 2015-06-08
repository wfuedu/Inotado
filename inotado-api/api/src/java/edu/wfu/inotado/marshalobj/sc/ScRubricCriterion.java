/*Licensed to The Apereo Foundation under one or more contributor license
agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership.

The Apereo Foundation licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

See the License for the specific language governing permissions and
limitations under the License.*/

package edu.wfu.inotado.marshalobj.sc;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gradable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grade_scales" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="max_score" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="min_score" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rubric_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="updated_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "created_at",
    "gradable",
    "grade_scales",
    "id",
    "max_score",
    "min_score",
    "name",
    "rubric_id",
    "updated_at"
})
@XmlRootElement(name = "RubricCriterion")
public class ScRubricCriterion {

    @XmlElement(required = true)
    protected String created_at;
    @XmlElement(required = true)
    protected String gradable;
    @XmlElement(required = true)
    protected List<ScGradeScale> grade_scales = new ArrayList<ScGradeScale>();
    protected int id;
    protected double max_score;
    protected double min_score;
    @XmlElement(required = true)
    protected String name;
    protected int rubric_id;
    @XmlElement(required = true)
    protected String updated_at;

    /**
     * Gets the value of the created_at property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getcreated_at() {
        return created_at;
    }

    /**
     * Sets the value of the created_at property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setcreated_at(String value) {
        this.created_at = value;
    }

    /**
     * Gets the value of the gradable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getgradable() {
        return gradable;
    }

    /**
     * Sets the value of the gradable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setgradable(String value) {
        this.gradable = value;
    }

    /**
     * Gets the value of the grade_scales property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<ScGradeScale> getgrade_scales() {
        return grade_scales;
    }

    /**
     * Sets the value of the grade_scales property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void addgrade_scales(ScGradeScale value) {
        this.grade_scales.add(value);
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getid() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setid(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the max_score property.
     * 
     */
    public double getmax_score() {
        return max_score;
    }

    /**
     * Sets the value of the max_score property.
     * 
     */
    public void setmax_score(double value) {
        this.max_score = value;
    }

    /**
     * Gets the value of the min_score property.
     * 
     */
    public double getmin_score() {
        return min_score;
    }

    /**
     * Sets the value of the min_score property.
     * 
     */
    public void setmin_score(double value) {
        this.min_score = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getname() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setname(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the rubric_id property.
     * 
     */
    public int getrubric_id() {
        return rubric_id;
    }

    /**
     * Sets the value of the rubric_id property.
     * 
     */
    public void setrubric_id(int value) {
        this.rubric_id = value;
    }

    /**
     * Gets the value of the updated_at property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getupdated_at() {
        return updated_at;
    }

    /**
     * Sets the value of the updated_at property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setupdated_at(String value) {
        this.updated_at = value;
    }

}
