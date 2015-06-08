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
 *         &lt;element name="accessibility_mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bb_cloud_user_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date_of_birth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ethnicity_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="family_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="freshbooks_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="funding_source_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hmh_one_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invisible" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invitation_accepted_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invitation_limit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invitation_sent_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invitation_token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invited_by_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invited_by_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lms_identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password_changed_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sandbox" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sso_source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="updated_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="welcomed" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "accessibility_mode",
    "bb_cloud_user_id",
    "created_at",
    "date_of_birth",
    "district",
    "email",
    "ethnicity_id",
    "family_id",
    "first_name",
    "freshbooks_id",
    "funding_source_id",
    "hmh_one_id",
    "id",
    "invisible",
    "invitation_accepted_at",
    "invitation_limit",
    "invitation_sent_at",
    "invitation_token",
    "invited_by_id",
    "invited_by_type",
    "last_name",
    "lms_identifier",
    "password_changed_at",
    "sandbox",
    "sso_source",
    "telephone",
    "title",
    "updated_at",
    "user_title",
    "welcomed"
})
@XmlRootElement(name = "User")
public class ScUser {

    @XmlElement(required = true)
    protected String accessibility_mode;
    @XmlElement(required = true)
    protected String bb_cloud_user_id;
    @XmlElement(required = true)
    protected String created_at;
    @XmlElement(required = true)
    protected String date_of_birth;
    @XmlElement(required = true)
    protected String district;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String ethnicity_id;
    @XmlElement(required = true)
    protected String family_id;
    @XmlElement(required = true)
    protected String first_name;
    @XmlElement(required = true)
    protected String freshbooks_id;
    @XmlElement(required = true)
    protected String funding_source_id;
    @XmlElement(required = true)
    protected String hmh_one_id;
    protected int id;
    @XmlElement(required = true)
    protected String invisible;
    @XmlElement(required = true)
    protected String invitation_accepted_at;
    @XmlElement(required = true)
    protected String invitation_limit;
    @XmlElement(required = true)
    protected String invitation_sent_at;
    @XmlElement(required = true)
    protected String invitation_token;
    @XmlElement(required = true)
    protected String invited_by_id;
    @XmlElement(required = true)
    protected String invited_by_type;
    @XmlElement(required = true)
    protected String last_name;
    @XmlElement(required = true)
    protected String lms_identifier;
    @XmlElement(required = true)
    protected String password_changed_at;
    @XmlElement(required = true)
    protected String sandbox;
    @XmlElement(required = true)
    protected String sso_source;
    @XmlElement(required = true)
    protected String telephone;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String updated_at;
    @XmlElement(required = true)
    protected String user_title;
    @XmlElement(required = true)
    protected String welcomed;

    /**
     * Gets the value of the accessibility_mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getaccessibility_mode() {
        return accessibility_mode;
    }

    /**
     * Sets the value of the accessibility_mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setaccessibility_mode(String value) {
        this.accessibility_mode = value;
    }

    /**
     * Gets the value of the bb_cloud_user_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getbb_cloud_user_id() {
        return bb_cloud_user_id;
    }

    /**
     * Sets the value of the bb_cloud_user_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setbb_cloud_user_id(String value) {
        this.bb_cloud_user_id = value;
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
     * Gets the value of the date_of_birth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getdate_of_birth() {
        return date_of_birth;
    }

    /**
     * Sets the value of the date_of_birth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setdate_of_birth(String value) {
        this.date_of_birth = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getdistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setdistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getemail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setemail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the ethnicity_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getethnicity_id() {
        return ethnicity_id;
    }

    /**
     * Sets the value of the ethnicity_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setethnicity_id(String value) {
        this.ethnicity_id = value;
    }

    /**
     * Gets the value of the family_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getfamily_id() {
        return family_id;
    }

    /**
     * Sets the value of the family_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setfamily_id(String value) {
        this.family_id = value;
    }

    /**
     * Gets the value of the first_name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getfirst_name() {
        return first_name;
    }

    /**
     * Sets the value of the first_name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setfirst_name(String value) {
        this.first_name = value;
    }

    /**
     * Gets the value of the freshbooks_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getfreshbooks_id() {
        return freshbooks_id;
    }

    /**
     * Sets the value of the freshbooks_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setfreshbooks_id(String value) {
        this.freshbooks_id = value;
    }

    /**
     * Gets the value of the funding_source_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getfunding_source_id() {
        return funding_source_id;
    }

    /**
     * Sets the value of the funding_source_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setfunding_source_id(String value) {
        this.funding_source_id = value;
    }

    /**
     * Gets the value of the hmh_one_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gethmh_one_id() {
        return hmh_one_id;
    }

    /**
     * Sets the value of the hmh_one_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void sethmh_one_id(String value) {
        this.hmh_one_id = value;
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
     * Gets the value of the invisible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvisible() {
        return invisible;
    }

    /**
     * Sets the value of the invisible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvisible(String value) {
        this.invisible = value;
    }

    /**
     * Gets the value of the invitation_accepted_at property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvitation_accepted_at() {
        return invitation_accepted_at;
    }

    /**
     * Sets the value of the invitation_accepted_at property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvitation_accepted_at(String value) {
        this.invitation_accepted_at = value;
    }

    /**
     * Gets the value of the invitation_limit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvitation_limit() {
        return invitation_limit;
    }

    /**
     * Sets the value of the invitation_limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvitation_limit(String value) {
        this.invitation_limit = value;
    }

    /**
     * Gets the value of the invitation_sent_at property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvitation_sent_at() {
        return invitation_sent_at;
    }

    /**
     * Sets the value of the invitation_sent_at property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvitation_sent_at(String value) {
        this.invitation_sent_at = value;
    }

    /**
     * Gets the value of the invitation_token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvitation_token() {
        return invitation_token;
    }

    /**
     * Sets the value of the invitation_token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvitation_token(String value) {
        this.invitation_token = value;
    }

    /**
     * Gets the value of the invited_by_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvited_by_id() {
        return invited_by_id;
    }

    /**
     * Sets the value of the invited_by_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvited_by_id(String value) {
        this.invited_by_id = value;
    }

    /**
     * Gets the value of the invited_by_type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getinvited_by_type() {
        return invited_by_type;
    }

    /**
     * Sets the value of the invited_by_type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setinvited_by_type(String value) {
        this.invited_by_type = value;
    }

    /**
     * Gets the value of the last_name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getlast_name() {
        return last_name;
    }

    /**
     * Sets the value of the last_name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setlast_name(String value) {
        this.last_name = value;
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
     * Gets the value of the password_changed_at property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getpassword_changed_at() {
        return password_changed_at;
    }

    /**
     * Sets the value of the password_changed_at property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setpassword_changed_at(String value) {
        this.password_changed_at = value;
    }

    /**
     * Gets the value of the sandbox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getsandbox() {
        return sandbox;
    }

    /**
     * Sets the value of the sandbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setsandbox(String value) {
        this.sandbox = value;
    }

    /**
     * Gets the value of the sso_source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getsso_source() {
        return sso_source;
    }

    /**
     * Sets the value of the sso_source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setsso_source(String value) {
        this.sso_source = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gettelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void settelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gettitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void settitle(String value) {
        this.title = value;
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
     * Gets the value of the user_title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getuser_title() {
        return user_title;
    }

    /**
     * Sets the value of the user_title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setuser_title(String value) {
        this.user_title = value;
    }

    /**
     * Gets the value of the welcomed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getwelcomed() {
        return welcomed;
    }

    /**
     * Sets the value of the welcomed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setwelcomed(String value) {
        this.welcomed = value;
    }

}
