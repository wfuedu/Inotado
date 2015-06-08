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

package edu.wfu.inotado.tool.pages;

import junit.framework.TestCase;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;

public abstract class TestBase extends TestCase{
	
	protected static final String BEAN_NAME_MESSAGE_SERVICE = "messageService";
	 
    private ApplicationContextMock applicationContextMock;
 
    private WicketTester tester = null;
 
    public void setUp() throws Exception {
        //Creates a new application context mock.
        applicationContextMock = new ApplicationContextMock();
 
        //Creates a new WicketTester 
        tester = new WicketTester();
        //Configures the SpringBean annotation support to use the mock application context. 
        //TODO This ensures that the mock objects are injected instead of the actual bean classes.
        //tester.getApplication().getComponentInstantiationListeners().add(new SpringComponentInjector(tester.getApplication(), applicationContextMock));
        setupTest();
    }
 
    /**
     * Subclasses can use this method to provide the configuration needed by
     * each test.
     */
    protected abstract void setupTest();
 
    /**
     * Adds mock to the mock application context.
     * @param beanName  The name of the mock bean.
     * @param mock  The mock object.
     */
    protected void addMock(String beanName, Object mock) {
        applicationContextMock.putBean(beanName, mock);
    }
 
    protected ApplicationContextMock getApplicationContextMock() {
        return applicationContextMock;
    }
 
    protected WicketTester getTester() {
        return tester;
    }
}