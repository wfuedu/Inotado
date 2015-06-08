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
 *         &lt;element name="assignment_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="badge_grant_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grade_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lis_result_sourcedid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passback_url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="updated_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "assignment_id",
    "badge_grant_id",
    "created_at",
    "grade",
    "grade_id",
    "id",
    "lis_result_sourcedid",
    "passback_url",
    "state",
    "updated_at",
    "user",
    "user_id"
})
@XmlRootElement(name = "AssignmentSubmitssion")
public class ScAssignmentSubmitssion {

    protected int assignment_id;
    @XmlElement(required = true)
    protected String badge_grant_id;
    @XmlElement(required = true)
    protected String created_at;
    @XmlElement(required = true)
    protected ScGrade grade;
    protected int grade_id;
    protected int id;
    @XmlElement(required = true)
    protected String lis_result_sourcedid;
    @XmlElement(required = true)
    protected String passback_url;
    protected int state;
    @XmlElement(required = true)
    protected String updated_at;
    @XmlElement(required = true)
    protected ScUser user;
    protected int user_id;

    /**
     * Gets the value of the assignment_id property.
     * 
     */
    public int getassignment_id() {
        return assignment_id;
    }

    /**
     * Sets the value of the assignment_id property.
     * 
     */
    public void setassignment_id(int value) {
        this.assignment_id = value;
    }

    /**
     * Gets the value of the badge_grant_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getbadge_grant_id() {
        return badge_grant_id;
    }

    /**
     * Sets the value of the badge_grant_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setbadge_grant_id(String value) {
        this.badge_grant_id = value;
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
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ScGrade getgrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */    public void setgrade(ScGrade value) {

        this.grade = value;
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
     * Gets the value of the lis_result_sourcedid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getlis_result_sourcedid() {
        return lis_result_sourcedid;
    }

    /**
     * Sets the value of the lis_result_sourcedid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setlis_result_sourcedid(String value) {
        this.lis_result_sourcedid = value;
    }

    /**
     * Gets the value of the passback_url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getpassback_url() {
        return passback_url;
    }

    /**
     * Sets the value of the passback_url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setpassback_url(String value) {
        this.passback_url = value;
    }

    /**
     * Gets the value of the state property.
     * 
     */
    public int getstate() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     */
    public void setstate(int value) {
        this.state = value;
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

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ScUser getuser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setuser(ScUser value) {
        this.user = value;
    }

    /**
     * Gets the value of the user_id property.
     * 
     */
    public int getuser_id() {
        return user_id;
    }

    /**
     * Sets the value of the user_id property.
     * 
     */
    public void setuser_id(int value) {
        this.user_id = value;
    }

}
