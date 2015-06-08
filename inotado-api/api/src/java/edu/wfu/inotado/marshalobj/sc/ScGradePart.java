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
 *         &lt;element name="comment_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grade_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="grade_scale_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rubric_criterion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rubric_criterion_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "comment_id",
    "created_at",
    "grade_id",
    "grade_scale_id",
    "id",
    "rubric_criterion",
    "rubric_criterion_id",
    "score",
    "updated_at"
})
@XmlRootElement(name = "GradePart")
public class ScGradePart {

    @XmlElement(required = true)
    protected String comment_id;
    @XmlElement(required = true)
    protected String created_at;
    protected int grade_id;
    protected int grade_scale_id;
    protected int id;
    @XmlElement(required = true)
    protected ScRubricCriterion rubric_criterion;
    protected int rubric_criterion_id;
    protected double score;
    @XmlElement(required = true)
    protected String updated_at;

    /**
     * Gets the value of the comment_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getcomment_id() {
        return comment_id;
    }

    /**
     * Sets the value of the comment_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setcomment_id(String value) {
        this.comment_id = value;
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
     * Gets the value of the grade_id property.
     * 
     */
    public int getgrade_id() {
        return grade_id;
    }

    /**
     * Sets the value of the grade_id property.
     * 
     */
    public void setgrade_id(int value) {
        this.grade_id = value;
    }

    /**
     * Gets the value of the grade_scale_id property.
     * 
     */
    public int getgrade_scale_id() {
        return grade_scale_id;
    }

    /**
     * Sets the value of the grade_scale_id property.
     * 
     */
    public void setgrade_scale_id(int value) {
        this.grade_scale_id = value;
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
     * Gets the value of the rubric_criterion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ScRubricCriterion getrubric_criterion() {
        return rubric_criterion;
    }

    /**
     * Sets the value of the rubric_criterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setrubric_criterion(ScRubricCriterion value) {
        this.rubric_criterion = value;
    }

    /**
     * Gets the value of the rubric_criterion_id property.
     * 
     */
    public int getrubric_criterion_id() {
        return rubric_criterion_id;
    }

    /**
     * Sets the value of the rubric_criterion_id property.
     * 
     */
    public void setrubric_criterion_id(int value) {
        this.rubric_criterion_id = value;
    }

    /**
     * Gets the value of the score property.
     * 
     */
    public double getscore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     * 
     */
    public void setscore(double value) {
        this.score = value;
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
