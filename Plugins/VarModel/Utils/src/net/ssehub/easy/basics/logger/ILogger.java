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
package net.ssehub.easy.basics.logger;

/**
 * Interface for concrete Loggers, which can be handled by the {@link EASyLoggerFactory}.
 * 
 * @author Sass
 *
 */
public interface ILogger {
    
    /**
     * Log an INFO message.
     * <p>
     * If the logger is currently enabled for the INFO message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void info(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an ERROR message.
     * <p>
     * If the logger is currently enabled for the ERROR message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void error(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an WARN message.
     * <p>
     * If the logger is currently enabled for the WARN message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void warn(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an DEBUG message.
     * <p>
     * If the logger is currently enabled for the DEBUG message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void debug(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an EXCEPTION message.
     * <p>
     * If the logger is currently enabled for the EXCEPTION message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void exception(String msg, Class<?> clazz, String bundleName);
}
