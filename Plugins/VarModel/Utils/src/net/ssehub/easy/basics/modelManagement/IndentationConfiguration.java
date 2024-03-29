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
package net.ssehub.easy.basics.modelManagement;

/**
 * Stores optional indentation configuration.
 * 
 * @author Holger Eichelberger
 */
public class IndentationConfiguration {

    private int step;
    private int tabEmu;
    private int additional;

    /**
     * Creates an indentation configuration object without tab emulation.
     * 
     * @param step the number of whitespaces per indentation step (positive integer, 0 or negative if 
     *     indentation shall be disabled)
     */
    public IndentationConfiguration(int step) {
        this(step, 0, 0);
    }
    
    /**
     * Creates an indentation configuration object.
     * 
     * @param step the number of whitespaces per indentation step (positive integer, 0 or negative if 
     *     indentation shall be disabled)
     * @param tabEmu the number of whitespaces per tab (0 or negative if disabled)
     */
    public IndentationConfiguration(int step, int tabEmu) {
        this(step, tabEmu, 0);
    }

    /**
     * Creates an indentation configuration object.
     * 
     * @param step the number of whitespaces per indentation step (positive integer, 0 or negative if 
     *     indentation shall be disabled)
     * @param tabEmu the number of whitespaces per tab (0 or negative if disabled)
     * @param additional additional whitespaces to be removed after indentation for extra formatting
     *     (language-dependent interpretation, non-negative integer)
     */
    public IndentationConfiguration(int step, int tabEmu, int additional) {
        this.step = step;
        this.tabEmu = tabEmu;
        this.additional  = Math.max(0, additional);
    }
    
    /**
     * Returns the number of whitespaces used for one indentation step.
     * 
     * @return the number of whitespaces (positive integer, 0 or negative if indentation shall be disabled)
     */
    public int getIndentationStep() {
        return step;
    }

    /**
     * Returns whether indentation is enabled.
     * 
     * @return <code>true</code> if indentation is enabled, <code>false</code> else
     */
    public boolean isIndentationEnabled() {
        return step > 0;
    }
    
    /**
     * Returns the number of whitespaces used to emulate a tabulator character.
     * 
     * @return the number of whitespaces (0 or negative if disabled)
     */
    public int getTabEmulation() {
        return tabEmu;
    }
    
    /**
     * Returns whether tab emulation is enabled.
     * 
     * @return <code>true</code> if tab emulation is enabled, <code>false</code> else
     */
    public boolean isTabEmulationEnabled() {
        return tabEmu > 0;
    }
    
    /**
     * The number of additional whitespaces to be considered after indentation (extra
     * indentation, language dependent).
     * 
     * @return the number of additional whitespaces (non-negative integer)
     */
    public int getAdditional() {
        return additional;
    }
    
}
