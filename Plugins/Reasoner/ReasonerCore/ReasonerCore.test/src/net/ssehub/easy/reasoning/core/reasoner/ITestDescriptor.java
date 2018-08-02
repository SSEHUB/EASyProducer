/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.reasoning.core.reasoner;

/**
 * Contains common code to perform direct reasoner testing.
 * 
 * @author Holger Eichelberger
 */
public interface ITestDescriptor {

    /**
     * Defines reasoner capabilities which may not be supported and, thus, shall not be tested.
     * 
     * @author Eichelberger
     */
    public enum Capabilities {
        CHECK,
        CONSISTENT
    }

    /**
     * Creates a reasoner instance to test against.
     * 
     * @return the reasoner instance
     */
    public IReasoner createReasoner();

    /**
     * Returns the system property.
     * 
     * @return the system property
     */
    public String getSystemProperty();
    
    /**
     * Returns the plugin id of the containing test.
     * 
     * @return the plugin id
     */
    public String getPluginId();
    
    /**
     * Supposed to register the reasoner with the ReasonerFrontend.
     */
    public void registerResoner();

    /**
     * Supposed to unregister the reasoner from the ReasonerFrontend.
     */
    public void unregisterReasoner();

    /**
     * Returns whether <code>capability</code> is supported.
     * 
     * @param capability the capability to check for
     * @return <code>true</code> if <code>capability</code> is supported, <code>false</code> else
     */
    public boolean isSupported(Capabilities capability);
      
    /**
     * Returns the name of the reasoner.
     * 
     * @return the name of the reasoner
     */
    public String getName();
    
    /**
     * Returns the version of the reasoner.
     * 
     * @return the version of the reasoner
     */
    public String getVersion();
    
    /**
     * Returns the measurements relevant for the tests denoted by this descriptor.
     * 
     * @return the measurements
     */
    public IMeasurementKey[] measurements();
    
    /**
     * Returns the name of the measurement file.
     * 
     * @return the name of the measurement file
     */
    public String getMeasurementFileName();

}
