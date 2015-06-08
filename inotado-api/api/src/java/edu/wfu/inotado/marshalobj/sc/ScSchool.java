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
 *         &lt;element name="address_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bbhostname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="can_pay_with_card" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_application_key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="created_at" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="force_assignment_kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="organization_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prevent_lms_role_update" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sandbox" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sso_secret" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="test" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tool_consumer_instance_guid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tool_consumer_instance_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="track_payment" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "address_id",
    "bbhostname",
    "can_pay_with_card",
    "client_application_key",
    "created_at",
    "expiration",
    "force_assignment_kind",
    "id",
    "name",
    "organization_id",
    "prevent_lms_role_update",
    "sandbox",
    "sso_secret",
    "test",
    "tool_consumer_instance_guid",
    "tool_consumer_instance_name",
    "track_payment",
    "updated_at"
})
@XmlRootElement(name = "School")
public class ScSchool {

    @XmlElement(required = true)
    protected String address_id;
    @XmlElement(required = true)
    protected String bbhostname;
    @XmlElement(required = true)
    protected String can_pay_with_card;
    @XmlElement(required = true)
    protected String client_application_key;
    @XmlElement(required = true)
    protected String created_at;
    @XmlElement(required = true)
    protected String expiration;
    @XmlElement(required = true)
    protected String force_assignment_kind;
    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String organization_id;
    @XmlElement(required = true)
    protected String prevent_lms_role_update;
    @XmlElement(required = true)
    protected String sandbox;
    @XmlElement(required = true)
    protected String sso_secret;
    @XmlElement(required = true)
    protected String test;
    @XmlElement(required = true)
    protected String tool_consumer_instance_guid;
    @XmlElement(required = true)
    protected String tool_consumer_instance_name;
    @XmlElement(required = true)
    protected String track_payment;
    @XmlElement(required = true)
    protected String updated_at;

    /**
     * Gets the value of the address_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getaddress_id() {
        return address_id;
    }

    /**
     * Sets the value of the address_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setaddress_id(String value) {
        this.address_id = value;
    }

    /**
     * Gets the value of the bbhostname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getbbhostname() {
        return bbhostname;
    }

    /**
     * Sets the value of the bbhostname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setbbhostname(String value) {
        this.bbhostname = value;
    }

    /**
     * Gets the value of the can_pay_with_card property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getcan_pay_with_card() {
        return can_pay_with_card;
    }

    /**
     * Sets the value of the can_pay_with_card property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setcan_pay_with_card(String value) {
        this.can_pay_with_card = value;
    }

    /**
     * Gets the value of the client_application_key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getclient_application_key() {
        return client_application_key;
    }

    /**
     * Sets the value of the client_application_key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setclient_application_key(String value) {
        this.client_application_key = value;
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
     * Gets the value of the expiration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getexpiration() {
        return expiration;
    }

    /**
     * Sets the value of the expiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setexpiration(String value) {
        this.expiration = value;
    }

    /**
     * Gets the value of the force_assignment_kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getforce_assignment_kind() {
        return force_assignment_kind;
    }

    /**
     * Sets the value of the force_assignment_kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setforce_assignment_kind(String value) {
        this.force_assignment_kind = value;
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
     * Gets the value of the organization_id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getorganization_id() {
        return organization_id;
    }

    /**
     * Sets the value of the organization_id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setorganization_id(String value) {
        this.organization_id = value;
    }

    /**
     * Gets the value of the prevent_lms_role_update property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getprevent_lms_role_update() {
        return prevent_lms_role_update;
    }

    /**
     * Sets the value of the prevent_lms_role_update property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setprevent_lms_role_update(String value) {
        this.prevent_lms_role_update = value;
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
     * Gets the value of the sso_secret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getsso_secret() {
        return sso_secret;
    }

    /**
     * Sets the value of the sso_secret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setsso_secret(String value) {
        this.sso_secret = value;
    }

    /**
     * Gets the value of the test property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gettest() {
        return test;
    }

    /**
     * Sets the value of the test property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void settest(String value) {
        this.test = value;
    }

    /**
     * Gets the value of the tool_consumer_instance_guid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gettool_consumer_instance_guid() {
        return tool_consumer_instance_guid;
    }

    /**
     * Sets the value of the tool_consumer_instance_guid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void settool_consumer_instance_guid(String value) {
        this.tool_consumer_instance_guid = value;
    }

    /**
     * Gets the value of the tool_consumer_instance_name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gettool_consumer_instance_name() {
        return tool_consumer_instance_name;
    }

    /**
     * Sets the value of the tool_consumer_instance_name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void settool_consumer_instance_name(String value) {
        this.tool_consumer_instance_name = value;
    }

    /**
     * Gets the value of the track_payment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String gettrack_payment() {
        return track_payment;
    }

    /**
     * Sets the value of the track_payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void settrack_payment(String value) {
        this.track_payment = value;
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
