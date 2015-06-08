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
 *         &lt;element name="course_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="role_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="student_peekable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="updated_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "course_id",
    "created_at",
    "id",
    "role_id",
    "student_peekable",
    "updated_at",
    "user_id"
})
@XmlRootElement(name = "Enrollment")
public class ScEnrollment {

    protected int course_id;
    @XmlElement(required = true)
    protected String created_at;
    protected int id;
    @XmlElement(required = true)
    protected String role_id;
    @XmlElement(required = true)
    protected String student_peekable;
    @XmlElement(required = true)
    protected String updated_at;
    protected int user_id;

    /**
     * Gets the value of the course_id property.
     * 
     */
    public int getcourse_id() {
        return course_id;
    }

    /**
     * Sets the value of the course_id property.
     * 
     */
    public void setcourse_id(int value) {
        this.course_id = value;
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
     * Gets the value of the role_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getrole_id() {
        return role_id;
    }

    /**
     * Sets the value of the role_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setrole_id(String value) {
        this.role_id = value;
    }

    /**
     * Gets the value of the student_peekable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getstudent_peekable() {
        return student_peekable;
    }

    /**
     * Sets the value of the student_peekable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setstudent_peekable(String value) {
        this.student_peekable = value;
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
