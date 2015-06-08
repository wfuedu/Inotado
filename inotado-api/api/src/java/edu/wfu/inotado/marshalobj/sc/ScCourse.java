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
 *         &lt;element name="assignments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bbid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="course_documents" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="course_standards" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="course_template_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enrollments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lms_identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="school_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="system_origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "assignments",
    "bbid",
    "course_documents",
    "course_standards",
    "course_template_id",
    "created_at",
    "enrollments",
    "id",
    "kind",
    "lms_identifier",
    "name",
    "school_id",
    "system_origin",
    "template",
    "updated_at"
})
@XmlRootElement(name = "Course")
public class ScCourse {

    @XmlElement(required = true)
    protected List<ScAssignment> assignments = new ArrayList<ScAssignment>();
    @XmlElement(required = true)
    protected String bbid;
    @XmlElement(required = true)
    protected List<ScCourseDocument> course_documents = new ArrayList<ScCourseDocument>();
    @XmlElement(required = true)
    protected List<ScCourseStandard> course_standards = new ArrayList<ScCourseStandard>();
    @XmlElement(required = true)
    protected String course_template_id;
    @XmlElement(required = true)
    protected String created_at;
    @XmlElement(required = true)
    protected List<ScEnrollment> enrollments = new ArrayList<ScEnrollment>();
    protected int id;
    @XmlElement(required = true)
    protected String kind;
    @XmlElement(required = true)
    protected String lms_identifier;
    @XmlElement(required = true)
    protected String name;
    protected int school_id;
    @XmlElement(required = true)
    protected String system_origin;
    protected int template;
    @XmlElement(required = true)
    protected String updated_at;

    /**
     * Gets the value of the assignments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<ScAssignment> getassignments() {
        return assignments;
    }

    /**
     * Sets the value of the assignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void addassignments(ScAssignment value) {
        this.assignments.add(value);
    }

    /**
     * Gets the value of the bbid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getbbid() {
        return bbid;
    }

    /**
     * Sets the value of the bbid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setbbid(String value) {
        this.bbid = value;
    }

    /**
     * Gets the value of the course_documents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<ScCourseDocument> getcourse_documents() {
        return course_documents;
    }

    /**
     * Sets the value of the course_documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void addcourse_documents(ScCourseDocument value) {
        this.course_documents.add(value);
    }

    /**
     * Gets the value of the course_standards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<ScCourseStandard> getcourse_standards() {
        return course_standards;
    }

    /**
     * Sets the value of the course_standards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void addcourse_standards(ScCourseStandard value) {
        this.course_standards.add(value);
    }

    /**
     * Gets the value of the course_template_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getcourse_template_id() {
        return course_template_id;
    }

    /**
     * Sets the value of the course_template_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setcourse_template_id(String value) {
        this.course_template_id = value;
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
     * Gets the value of the enrollments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<ScEnrollment> getenrollments() {
        return enrollments;
    }

    /**
     * Sets the value of the enrollments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void addenrollments(ScEnrollment value) {
        this.enrollments.add(value);
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
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getkind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setkind(String value) {
        this.kind = value;
    }

    /**
     * Gets the value of the lms_identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getlms_identifier() {
        return lms_identifier;
    }

    /**
     * Sets the value of the lms_identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setlms_identifier(String value) {
        this.lms_identifier = value;
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
     * Gets the value of the school_id property.
     * 
     */
    public int getschool_id() {
        return school_id;
    }

    /**
     * Sets the value of the school_id property.
     * 
     */
    public void setschool_id(int value) {
        this.school_id = value;
    }

    /**
     * Gets the value of the system_origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getsystem_origin() {
        return system_origin;
    }

    /**
     * Sets the value of the system_origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setsystem_origin(String value) {
        this.system_origin = value;
    }

    /**
     * Gets the value of the template property.
     * 
     */
    public int gettemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     */
    public void settemplate(int value) {
        this.template = value;
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
