/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.utils.modelManagement;

import java.util.Locale;

/**
 * Provides internationalization support, i.e., which locale is valid for loading models.
 * Instances of this class cannot be created directly rather than being obtained from {@link ModelManagement}.
 * 
 * @author Holger Eichelberger
 */
public class ModelLocale {

    private Locale locale;

    /**
     * Prevents object creation from outside this package.
     */
    ModelLocale() {
    }
    
    /**
     * Defines the preferred <code>locale</code> for descriptive texts.
     * 
     * @param locale the preferred locale, may be <b>null</b>
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    /**
     * Returns the preferred <code>locale</code> for descriptive texts.
     * 
     * @return the preferred locale as defined previously via {@link #setLocale(Locale)}, may
     *   be <b>null</b>, in particular when {@link #setLocale(Locale)} has not been called before
     */
    public Locale getLocale() {
        return locale;
    }
    
    /**
     * Returns the actual locale.
     * 
     * @return the preferred locale if defined, the default system locale else
     */
    Locale getActualLocale() {
        Locale result;
        if (null != locale) {
            result = locale;
        } else {
            result = Locale.getDefault();
        }
        return result;
    }
    
}
