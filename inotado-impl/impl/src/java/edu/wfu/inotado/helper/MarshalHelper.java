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

package edu.wfu.inotado.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.oxm.UncategorizedMappingException;
import org.springframework.oxm.UnmarshallingFailureException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MarshalHelper {
	private final Log log = LogFactory.getLog(this.getClass());

	private Jaxb2Marshaller marshaller;

	private JsonParser gsonParser = new JsonParser();

	public void setMarshaller(Jaxb2Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	@SuppressWarnings("unchecked")
	public <T> T unmarshal(String xml) {
		T obj = null;
		Source source = null;
		if (StringUtils.isNotEmpty(xml)) {
			source = new StreamSource(new StringReader(xml));
			try {
				obj = (T) this.marshaller.unmarshal(source);
			} catch (UnmarshallingFailureException e) {
				log.warn("Unable to unmarshal the xml: " + xml);
			}
		}
		return obj;
	}

	public String marshal(Object obj) {
		String xml = "";
		StringWriter out = new StringWriter();
		try {
			if (obj != null) {
				this.marshaller.marshal(obj, new StreamResult(out));
				// xml = prettyPrintXml(out.toString());
				xml = out.toString();
			} else {
				log.warn("the input object is null for marshaller!");
			}

		} catch (UncategorizedMappingException e) {
			log.error("Object not mapped correctly: "
					+ obj.getClass().getName(), e);
		}

		return xml;
	}

	/**
	 * Pretty-Prints the XML
	 * 
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("unused")
	private String prettyPrintXml(String xml) {
		DocumentBuilder documentBuilder;
		StringWriter stringWriter = new StringWriter();
		try {
			documentBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(
					xml.getBytes("UTF8"));
			Document document = documentBuilder.parse(inputStream);
			DOMImplementation domImplementation = document.getImplementation();

			if (domImplementation.hasFeature("LS", "3.0")
					&& domImplementation.hasFeature("Core", "2.0")) {
				DOMImplementationLS domImplementationLS = (DOMImplementationLS) domImplementation
						.getFeature("LS", "3.0");
				LSSerializer lsSerializer = domImplementationLS
						.createLSSerializer();
				DOMConfiguration domConfiguration = lsSerializer.getDomConfig();
				if (domConfiguration.canSetParameter("format-pretty-print",
						Boolean.TRUE)) {
					lsSerializer.getDomConfig().setParameter(
							"format-pretty-print", Boolean.TRUE);
					LSOutput lsOutput = domImplementationLS.createLSOutput();
					lsOutput.setEncoding("UTF-8");

					lsOutput.setCharacterStream(stringWriter);
					lsSerializer.write(document, lsOutput);
					return stringWriter.toString();
				} else {
					log.warn("DOMConfiguration 'format-pretty-print' parameter isn't settable.");
				}
			} else {
				log.warn("DOM 3.0 LS and/or DOM 2.0 Core not supported.");
			}
		} catch (ParserConfigurationException e) {
			log.error("Unable to parse xml: " + xml, e);
		} catch (UnsupportedEncodingException e) {
			log.error("Encoding unspported for xml: " + xml, e);
		} catch (SAXException e) {
			log.error("SAXException occurred: " + xml, e);
		} catch (IOException e) {
			log.error("IOException occurred:" + xml, e);
		}
		// return the input string if any error occurs
		return xml;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T unmarshalJson(String json, Class<T> type) {
		T obj = null;
		Gson gson = new Gson();
		if (StringUtils.isNotEmpty(json)) {
			JsonElement element = gsonParser.parse(json);
			if (element.isJsonArray()) {
				// process array
				JsonArray array = element.getAsJsonArray();
				List list = new ArrayList();
				for (int i = 0; i < array.size(); i++) {
					list.add(gson.fromJson(array.get(i), type));
				}
				obj = (T) list;

			} else {
				// process single element
				obj = (T) gson.fromJson(json, type);
			}

		} else {
			log.warn("The input Json string is empty");
		}
		return obj;
	}

	public String marshalJson(Object obj) {
		Gson gso = new Gson();
		return gso.toJson(obj);
	}

	public String prettyPrintJson(String json) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement je = gsonParser.parse(json);
		return gson.toJson(je);
	}

	public <T> T unmarshalByJackson(String json, Class<T> type) {

		T obj = null;
		ObjectMapper mapper = new ObjectMapper();
		if (StringUtils.isNotEmpty(json)) {
			try {
				obj = (T) mapper.readValue(json, type);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			log.warn("The input Json string is empty");
		}
		return obj;
	}
}
