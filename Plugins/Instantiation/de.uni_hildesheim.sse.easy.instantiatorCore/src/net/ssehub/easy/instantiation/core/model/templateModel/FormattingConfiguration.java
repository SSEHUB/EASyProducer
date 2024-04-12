/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

/**
 * Stores VTL formatting configurations.
 * 
 * @author Holger Eichelberger
 */
public class FormattingConfiguration {
    
    private String lineEnding;
    private int lineLength;
    private String profile;

    /**
     * Creates an empty configuration.
     */
    public FormattingConfiguration() {
    }
    
    /**
     * Defines the line ending.
     * 
     * @param lineEnding the line ending
     */
    public void setLineEnding(String lineEnding) {
        this.lineEnding = lineEnding;
    }

    /**
     * Returns the line ending. Call {@link #setLineEnding(String)} before.
     * 
     * @return the line ending
     */
    public String getLineEnding() {
        return lineEnding;
    }

    /**
     * Defines the line length.
     * 
     * @param lineLength the line length in characters
     */
    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    /**
     * Returns the line length. Call {@link #setLineLength(int)} before.
     * 
     * @return the line length, invalid if not positive
     */
    public int getLineLength() {
        return lineLength;
    }

    /**
     * Defines the formatting profile for specific/context sensitive settings.
     * 
     * @param profile the profile name
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Returns the formatting profile for specific/context sensitive settings.
     * 
     * @return profile name
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Returns the line ending using the Java default if there is no configuration instance or no line ending defined
     * in the given configuration.
     *  
     * @param cfg the configuration to get the line ending from (may be <b>null</b>)
     * @return the line ending, defaults to the Java default line ending if no configuration / setting is given
     */
    public static String getLineEnding(FormattingConfiguration cfg) {
        String result = null;
        if (null != cfg) {
            result = cfg.getLineEnding();
        } 
        if (null == result) {
            result = System.getProperty("line.separator");
        }
        return result;
    }

}
