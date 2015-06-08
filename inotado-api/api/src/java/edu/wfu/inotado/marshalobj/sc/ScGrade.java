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
 *         &lt;element name="bonus_score" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grade_parts" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="penalty_percent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rubric_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="total_score" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "bonus_score",
    "created_at",
    "grade_parts",
    "id",
    "penalty_percent",
    "rubric_id",
    "total_score",
    "updated_at"
})
@XmlRootElement(name = "Grade")
public class ScGrade {

    protected int bonus_score;
    @XmlElement(required = true)
    protected String created_at;
    @XmlElement(required = true)
    protected List<ScGradePart> grade_parts = new ArrayList<ScGradePart>();
    protected int id;
    @XmlElement(required = true)
    protected String penalty_percent;
    protected int rubric_id;
    protected double total_score;
    @XmlElement(required = true)
    protected String updated_at;

    /**
     * Gets the value of the bonus_score property.
     * 
     */
    public int getbonus_score() {
        return bonus_score;
    }

    /**
     * Sets the value of the bonus_score property.
     * 
     */
    public void setbonus_score(int value) {
        this.bonus_score = value;
    }

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
     * Gets the value of the grade_parts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<ScGradePart> getgrade_parts() {
        return grade_parts;
    }

    /**
     * Sets the value of the grade_parts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void addgrade_parts(ScGradePart value) {
        this.grade_parts.add(value);
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
     * Gets the value of the penalty_percent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getpenalty_percent() {
        return penalty_percent;
    }

    /**
     * Sets the value of the penalty_percent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setpenalty_percent(String value) {
        this.penalty_percent = value;
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
     * Gets the value of the total_score property.
     * 
     */
    public double gettotal_score() {
        return total_score;
    }

    /**
     * Sets the value of the total_score property.
     * 
     */
    public void settotal_score(double value) {
        this.total_score = value;
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
