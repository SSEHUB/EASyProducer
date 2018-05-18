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
package net.ssehub.easy.instantiation.core.model.common;

import java.lang.reflect.InvocationTargetException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;

/**
 * Some utility functions.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Returns the parent project.
     * 
     * @param <T> the project type
     * @param modelElement the model (language) element
     * @param cls the class of the project type
     * @return the parent project
     */
    public static <T> T getParentProject(ILanguageElement modelElement, Class<T> cls) {
        T parentProject = null;
        if (modelElement != null) {
            ILanguageElement par = modelElement.getParent();
            while (null != par && !cls.isInstance(par)) {
                par = par.getParent();
            }
            if (cls.isInstance(par)) {
                parentProject = cls.cast(par);
            }
        }
        return parentProject;
    }

    /**
     * Obtains a command line program instance through dynamic class loading.
     * 
     * @param className the class name
     * @return the instance or <b>null</b> if no instance can be created, reason will occur in log
     */
    public static ICommandLineProgram obainCommandLineProgram(String className) {
        ICommandLineProgram result = null;
        try {
            Class<?> cls = Class.forName(className);
            if (cls.isAssignableFrom(ICommandLineProgram.class)) {
                Object inst = cls.getDeclaredConstructor().newInstance();
                if (inst instanceof ICommandLineProgram) {
                    result = (ICommandLineProgram) inst;
                }
            } else {
                getLogger().error(className + " is not instance of " + ICommandLineProgram.class.getName()
                    + ". Cannot create command line program instance.");
            }
        } catch (ClassNotFoundException e) {
            getLogger().warn(className + " cannot be found on classpath.");
        } catch (InstantiationException e) {
            getLogger().exception(e);
        } catch (IllegalAccessException e) {
            getLogger().exception(e);
        } catch (IllegalArgumentException e) {
            getLogger().exception(e);
        } catch (InvocationTargetException e) {
            getLogger().exception(e);
        } catch (NoSuchMethodException e) {
            getLogger().warn(className + " does not have a public non-arg constructor.");
        } catch (SecurityException e) {
            getLogger().exception(e);
        }
        return result;
    }
    
    /**
     * Returns the logger for this class.
     *  
     * @return the logger
     */
    private static EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(Utils.class, Bundle.ID);
    }

}
