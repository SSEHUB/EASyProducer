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
package net.ssehub.easy.instantiation.core.model.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;

/**
 * A registry for command line programs.
 * 
 * @author Holger Eichelberger
 */
public class CommandLineProgramRegistry {

    private static Map<String, ICommandLineProgram> programs = new HashMap<String, ICommandLineProgram>();

    /**
     * Registers a program instance.
     * 
     * @param name the name of the program (nothing happens if <b>null</b>)
     * @param instance the instance (nothing happens if <b>null</b>)
     */
    public static void registerProgram(String name, ICommandLineProgram instance) {
        if (null != name && null != instance) {
            programs.put(name, instance);
        }
    }

    /**
     * Returns a registered program instance.
     * 
     * @param name the name of the program
     * @return the registered program (may be <b>null</b> for none)
     */
    public static ICommandLineProgram getRegisteredProgram(String name) {
        return null != name ? programs.get(name) : null;
    }

    /**
     * Unregisters a program instance.
     * 
     * @param name the name of the program (nothing happens if <b>null</b>)
     */
    public static void unregisterProgram(String name) {
        if (null != name) {
            programs.remove(name);
        }
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
        return EASyLoggerFactory.INSTANCE.getLogger(CommandLineProgramRegistry.class, Bundle.ID);
    }
    
}
