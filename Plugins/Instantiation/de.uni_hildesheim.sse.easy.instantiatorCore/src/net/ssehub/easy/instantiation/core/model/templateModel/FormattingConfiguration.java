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

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores VTL formatting configurations.
 * 
 * @author Holger Eichelberger
 */
public class FormattingConfiguration {
    
    private String lineEnding;
    private String lineEndingOrig;
    private int lineLength;
    private String profile;
    private boolean useTabs = false;
    private int indentSteps = -1;
    private Charset charset;
    private Map<String, String> profileArguments = new HashMap<String, String>();

    /**
     * Creates an empty configuration.
     */
    public FormattingConfiguration() {
    }

    /**
     * Creates an empty configuration with default values for line length and ending.
     * 
     * @param lineLength the maximum line length
     * @param lineEnding the line ending to use
     */
    public FormattingConfiguration(int lineLength, String lineEnding) {
        this.lineLength = lineLength;
        setLineEnding(lineEnding);
    }

    /**
     * Defines the line ending.
     * 
     * @param lineEnding the line ending
     */
    public void setLineEnding(String lineEnding) {
        this.lineEndingOrig = lineEnding;
        if (null != lineEnding) {
            String tmp = lineEnding.toLowerCase();
            if (tmp.equals("windows")) {
                lineEnding = "\r\n";
            } else if ((tmp.equals("linux") || tmp.equals("unix") || tmp.equals("mac") || tmp.equals("macos"))) {
                lineEnding = "\n";
            }
        }
        this.lineEnding = lineEnding;
    }

    /**
     * Returns the effective line ending. Call {@link #setLineEnding(String)} before.
     * 
     * @return the line ending
     */
    public String getLineEnding() {
        return lineEnding;
    }

    /**
     * Returns the line ending as specified originally. Call {@link #setLineEnding(String)} before.
     * 
     * @return the line ending
     */
    public String getLineEndingOrig() {
        return lineEndingOrig;
    }

    /**
     * Defines the line length.
     * 
     * @param lineLength the line length in characters (ignored in formatting if negative)
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
     * Defines a profile-specific argument.
     * 
     * @param name the name of the argument, ignored if <b>null</b>
     * @param value the value of the argument
     */
    public void setProfileArgument(String name, String value) {
        if (name != null) {
            this.profileArguments.put(name, value);
        }
    }

    /**
     * Returns a profile-specific argument.
     * 
     * @param name the name of the argument
     * @return the argument value, may be <b>null</b> in particular if {@code name} is <b>null</b>
     */
    public String getProfileArgument(String name) {
        return getProfileArgument(name, null);
    }

    /**
     * Returns a profile-specific argument.
     * 
     * @param name the name of the argument
     * @param dflt the default value if no argument was found
     * @return the argument value, may be {@code dflt} in particular if {@code name} is <b>null</b>
     */
    public String getProfileArgument(String name, String dflt) {
        String result = dflt;
        if (name != null) {
            String tmp = profileArguments.get(name);
            if (tmp != null) {
                result = tmp;
            }
        }
        return result;
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

    /**
     * Returns whether tabs shall be used instead of whitespaces for indentation.
     * 
     * @return {@code true} for tabs, {@code false} else
     */
    public boolean useTabs() {
        return useTabs;
    }

    /**
     * Defines whether tabs shall be used instead of whitespaces for indentation.
     * 
     * @param useTabs {@code true} for tabs, {@code false} else
     */
    public void setUseTabs(boolean useTabs) {
        this.useTabs = useTabs;
    }

    /**
     * Returns the number of indentation steps per indentation level.
     * 
     * @return the number of indentation steps
     */
    public int getIndentSteps() {
        return indentSteps;
    }

    /**
     * Changes the number of indentation steps per indentation level.
     * 
     * @param indentSteps the number of indentation steps (negative is set to 0)
     */
    public void setIndentSteps(int indentSteps) {
        this.indentSteps = Math.max(0, indentSteps); // well, 0...
    }
    
    /**
     * Returns the requested output charset.
     * 
     * @return the charset, may be <b>null</b> for undefined/system default
     */
    public Charset getCharset() {
        return charset;
    }

    /**
     * Chantes the output charset.
     * 
     * @param charset the charset, may be <b>null</b> for undefined/system default
     */
    public void setCharset(Charset charset) {
        this.charset = charset;
    }

}
