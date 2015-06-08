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
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="assignment_submissions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="badge_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bb_deployment_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="course">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="bb_cloud_course_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bbid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="course_template_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="edit_description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="inactive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lms_identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="product_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="school_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="system_origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="updated_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="course_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="due_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="externalidentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lms_identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parent_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="product_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rubric" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rubric_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="school_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="system_origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "", propOrder = { "active", "assignment_submissions",
		"badge_id", "bb_deployment_status", "course", "course_id",
		"created_at", "description", "due_date", "externalidentifier", "id",
		"kind", "lms_identifier", "name", "parent_id", "product_id", "rubric",
		"rubric_id", "school_id", "system_origin", "template", "updated_at" })
@XmlRootElement(name = "Assignment")
public class ScAssignment {

	@XmlElement(required = true)
	protected String active;
	@XmlElement(required = true)
	protected List<ScAssignmentSubmitssion> assignment_submissions = new ArrayList<ScAssignmentSubmitssion>();
	@XmlElement(required = true)
	protected String badge_id;
	@XmlElement(required = true)
	protected String bb_deployment_status;
	@XmlElement(required = true)
	protected ScAssignment.course course;
	protected int course_id;
	@XmlElement(required = true)
	protected String created_at;
	@XmlElement(required = true)
	protected String description;
	@XmlElement(required = true)
	protected String due_date;
	@XmlElement(required = true)
	protected String externalidentifier;
	protected int id;
	@XmlElement(required = true)
	protected String kind;
	@XmlElement(required = true)
	protected String lms_identifier;
	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	protected String parent_id;
	@XmlElement(required = true)
	protected String product_id;
	@XmlElement(required = true)
	protected ScRubric rubric;
	protected int rubric_id;
	protected int school_id;
	@XmlElement(required = true)
	protected String system_origin;
	@XmlElement(required = true)
	protected String template;
	@XmlElement(required = true)
	protected String updated_at;

	/**
	 * Gets the value of the active property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getactive() {
		return active;
	}

	/**
	 * Sets the value of the active property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setactive(String value) {
		this.active = value;
	}

	/**
	 * Gets the value of the assignment_submissions property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public List<ScAssignmentSubmitssion> getassignment_submissions() {
		return assignment_submissions;
	}

	/**
	 * Sets the value of the assignment_submissions property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void addassignment_submissions(ScAssignmentSubmitssion value) {
		this.assignment_submissions.add(value);
	}

	/**
	 * Gets the value of the badge_id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getbadge_id() {
		return badge_id;
	}

	/**
	 * Sets the value of the badge_id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setbadge_id(String value) {
		this.badge_id = value;
	}

	/**
	 * Gets the value of the bb_deployment_status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getbb_deployment_status() {
		return bb_deployment_status;
	}

	/**
	 * Sets the value of the bb_deployment_status property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setbb_deployment_status(String value) {
		this.bb_deployment_status = value;
	}

	/**
	 * Gets the value of the course property.
	 * 
	 * @return possible object is {@link ScAssignment.course }
	 * 
	 */
	public ScAssignment.course getcourse() {
		return course;
	}

	/**
	 * Sets the value of the course property.
	 * 
	 * @param value
	 *            allowed object is {@link ScAssignment.course }
	 * 
	 */
	public void setcourse(ScAssignment.course value) {
		this.course = value;
	}

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
	 * @return possible object is {@link String }
	 * 
	 */
	public String getcreated_at() {
		return created_at;
	}

	/**
	 * Sets the value of the created_at property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setcreated_at(String value) {
		this.created_at = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getdescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setdescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the due_date property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getdue_date() {
		return due_date;
	}

	/**
	 * Sets the value of the due_date property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setdue_date(String value) {
		this.due_date = value;
	}

	/**
	 * Gets the value of the externalidentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getexternalidentifier() {
		return externalidentifier;
	}

	/**
	 * Sets the value of the externalidentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setexternalidentifier(String value) {
		this.externalidentifier = value;
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
	 * @return possible object is {@link String }
	 * 
	 */
	public String getkind() {
		return kind;
	}

	/**
	 * Sets the value of the kind property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setkind(String value) {
		this.kind = value;
	}

	/**
	 * Gets the value of the lms_identifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getlms_identifier() {
		return lms_identifier;
	}

	/**
	 * Sets the value of the lms_identifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setlms_identifier(String value) {
		this.lms_identifier = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getname() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setname(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the parent_id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getparent_id() {
		return parent_id;
	}

	/**
	 * Sets the value of the parent_id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setparent_id(String value) {
		this.parent_id = value;
	}

	/**
	 * Gets the value of the product_id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getproduct_id() {
		return product_id;
	}

	/**
	 * Sets the value of the product_id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setproduct_id(String value) {
		this.product_id = value;
	}

	/**
	 * Gets the value of the rubric property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public ScRubric getrubric() {
		return rubric;
	}

	/**
	 * Sets the value of the rubric property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setrubric(ScRubric value) {
		this.rubric = value;
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
	 * @return possible object is {@link String }
	 * 
	 */
	public String getsystem_origin() {
		return system_origin;
	}

	/**
	 * Sets the value of the system_origin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setsystem_origin(String value) {
		this.system_origin = value;
	}

	/**
	 * Gets the value of the template property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String gettemplate() {
		return template;
	}

	/**
	 * Sets the value of the template property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void settemplate(String value) {
		this.template = value;
	}

	/**
	 * Gets the value of the updated_at property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getupdated_at() {
		return updated_at;
	}

	/**
	 * Sets the value of the updated_at property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setupdated_at(String value) {
		this.updated_at = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="bb_cloud_course_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="bbid" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="course_template_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="edit_description" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
	 *         &lt;element name="inactive" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="lms_identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="product_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
	@XmlType(name = "", propOrder = { "bb_cloud_course_id", "bbid",
			"course_template_id", "created_at", "description",
			"edit_description", "id", "inactive", "kind", "lms_identifier",
			"name", "product_id", "school_id", "system_origin", "template",
			"updated_at" })
	public static class course {

		@XmlElement(required = true)
		protected String bb_cloud_course_id;
		@XmlElement(required = true)
		protected String bbid;
		@XmlElement(required = true)
		protected String course_template_id;
		@XmlElement(required = true)
		protected String created_at;
		@XmlElement(required = true)
		protected String description;
		@XmlElement(required = true)
		protected String edit_description;
		protected int id;
		@XmlElement(required = true)
		protected String inactive;
		@XmlElement(required = true)
		protected String kind;
		@XmlElement(required = true)
		protected String lms_identifier;
		@XmlElement(required = true)
		protected String name;
		@XmlElement(required = true)
		protected String product_id;
		protected int school_id;
		@XmlElement(required = true)
		protected String system_origin;
		protected int template;
		@XmlElement(required = true)
		protected String updated_at;

		/**
		 * Gets the value of the bb_cloud_course_id property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getbb_cloud_course_id() {
			return bb_cloud_course_id;
		}

		/**
		 * Sets the value of the bb_cloud_course_id property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setbb_cloud_course_id(String value) {
			this.bb_cloud_course_id = value;
		}

		/**
		 * Gets the value of the bbid property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getbbid() {
			return bbid;
		}

		/**
		 * Sets the value of the bbid property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setbbid(String value) {
			this.bbid = value;
		}

		/**
		 * Gets the value of the course_template_id property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getcourse_template_id() {
			return course_template_id;
		}

		/**
		 * Sets the value of the course_template_id property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setcourse_template_id(String value) {
			this.course_template_id = value;
		}

		/**
		 * Gets the value of the created_at property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getcreated_at() {
			return created_at;
		}

		/**
		 * Sets the value of the created_at property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setcreated_at(String value) {
			this.created_at = value;
		}

		/**
		 * Gets the value of the description property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getdescription() {
			return description;
		}

		/**
		 * Sets the value of the description property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setdescription(String value) {
			this.description = value;
		}

		/**
		 * Gets the value of the edit_description property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getedit_description() {
			return edit_description;
		}

		/**
		 * Sets the value of the edit_description property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setedit_description(String value) {
			this.edit_description = value;
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
		 * Gets the value of the inactive property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getinactive() {
			return inactive;
		}

		/**
		 * Sets the value of the inactive property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setinactive(String value) {
			this.inactive = value;
		}

		/**
		 * Gets the value of the kind property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getkind() {
			return kind;
		}

		/**
		 * Sets the value of the kind property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setkind(String value) {
			this.kind = value;
		}

		/**
		 * Gets the value of the lms_identifier property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getlms_identifier() {
			return lms_identifier;
		}

		/**
		 * Sets the value of the lms_identifier property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setlms_identifier(String value) {
			this.lms_identifier = value;
		}

		/**
		 * Gets the value of the name property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getname() {
			return name != null ? name.trim() : name;
		}

		/**
		 * Sets the value of the name property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setname(String value) {
			this.name = value != null ? name.trim() : name;
		}

		/**
		 * Gets the value of the product_id property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getproduct_id() {
			return product_id;
		}

		/**
		 * Sets the value of the product_id property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setproduct_id(String value) {
			this.product_id = value;
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
		 * @return possible object is {@link String }
		 * 
		 */
		public String getsystem_origin() {
			return system_origin;
		}

		/**
		 * Sets the value of the system_origin property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
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
		 * @return possible object is {@link String }
		 * 
		 */
		public String getupdated_at() {
			return updated_at;
		}

		/**
		 * Sets the value of the updated_at property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setupdated_at(String value) {
			this.updated_at = value;
		}

	}

}
