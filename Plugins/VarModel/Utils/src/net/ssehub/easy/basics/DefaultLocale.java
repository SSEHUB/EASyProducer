/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.basics;

import java.util.Locale;

/**
 * Provides access to the default locale.
 * 
 * @author Holger Eichelberger
 */
public class DefaultLocale {

    public static final Locale INITIAL_LOCALE = new Locale("en", "us");
    private static Locale defaultLocale = INITIAL_LOCALE;

    /**
     * Changes the default locale for evaluation.
     * 
     * @param locale the new locale, ignored if <b>null</b>
     */
    public static void setDefaultLocale(Locale locale) {
        if (null != locale)  {
            defaultLocale = locale;
        }
    }

    /**
     * Returns the default locale for evaluation.
     * 
     * @return the locale
     */
    public static Locale getDefaultLocale() {
        return defaultLocale;
    }
    
    /**
     * Turns the locale into a string.
     * 
     * @param locale the locale
     * @return the locale as string
     */
    public static String toString(Locale locale) {
        String result = locale.getLanguage();
        String ctry = locale.getCountry();
        if (ctry.length() > 0) {
            result += "_" + ctry;
        }
        return result;
    }

    /**
     * Turns <code>loc</code> into a locale.
     * 
     * @param loc a string specifying a locale (form: lang[_country]).
     * @return the locale
     */
    public static Locale toLocale(String loc) {
        Locale locale;
        int pos = loc.indexOf("_");
        if (pos < 0 && pos + 1 < loc.length()) {
            locale = new Locale(loc);
        } else {
            locale = new Locale(loc.substring(0, pos), loc.substring(pos + 1));
        }
        return locale;
    }

}
