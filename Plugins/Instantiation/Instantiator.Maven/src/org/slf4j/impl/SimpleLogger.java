/**
 * Copyright (c) 2004-2012 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.slf4j.impl;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.IInstantiatorTracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;

/**
 * Simple implementation of an SLF4J logger for turning maven messages into VIL messages. This class is based
 * on the original SLF4J simple implementation.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class SimpleLogger extends MarkerIgnoringBase {

  private static final int LOG_LEVEL_TRACE = LocationAwareLogger.TRACE_INT;
  private static final int LOG_LEVEL_DEBUG = LocationAwareLogger.DEBUG_INT;
  private static final int LOG_LEVEL_INFO = LocationAwareLogger.INFO_INT;
  private static final int LOG_LEVEL_WARN = LocationAwareLogger.WARN_INT;
  private static final int LOG_LEVEL_ERROR = LocationAwareLogger.ERROR_INT;

  private static boolean INITIALIZED = false;

  private static int DEFAULT_LOG_LEVEL = LOG_LEVEL_INFO;
  private static IInstantiatorTracer tracer = TracerFactory.createInstantitorTracer();

  static void init() {
    INITIALIZED = true;
  }

  /** The current log level */
  protected int currentLogLevel = LOG_LEVEL_INFO;

  /**
   * Package access allows only {@link SimpleLoggerFactory} to instantiate
   * SimpleLogger instances.
   */
  SimpleLogger(String name) {
    if (!INITIALIZED) {
      init();
    }
    this.name = name;
    this.currentLogLevel = DEFAULT_LOG_LEVEL;
  }

  /**
   * This is our internal implementation for logging regular (non-parameterized)
   * log messages.
   *
   * @param level   One of the LOG_LEVEL_XXX constants defining the log level
   * @param message The message itself
   * @param t       The exception whose stack trace should be logged
   */
  private void log(int level, String message, Throwable t) {
    if (isLevelEnabled(level)) {
        tracer.traceMessage(message);
    }
  }

  /**
   * For formatted messages, first substitute arguments and then log.
   *
   * @param level the log level
   * @param format the formatting string
   * @param arg1 the first argument to be replaced
   * @param arg2 the second argument to be replaced
   */
  private void formatAndLog(int level, String format, Object arg1, Object arg2) {
    if (isLevelEnabled(level)) {
        FormattingTuple tp = MessageFormatter.format(format, arg1, arg2);
        log(level, tp.getMessage(), tp.getThrowable());
    }
  }

  /**
   * For formatted messages, first substitute arguments and then log.
   *
   * @param level
   * @param format
   * @param arguments a list of 3 ore more arguments
   */
  private void formatAndLog(int level, String format, Object... arguments) {
    if (!isLevelEnabled(level)) {
      return;
    }
    FormattingTuple tp = MessageFormatter.arrayFormat(format, arguments);
    log(level, tp.getMessage(), tp.getThrowable());
  }

  /**
   * Is the given log level currently enabled?
   *
   * @param logLevel is this level enabled?
   */
  protected boolean isLevelEnabled(int logLevel) {
    // log level are numerically ordered so can use simple numeric
    // comparison
    return (logLevel >= currentLogLevel);
  }

  @Override
  public boolean isTraceEnabled() {
    return isLevelEnabled(LOG_LEVEL_TRACE);
  }

  @Override
  public void trace(String msg) {
    log(LOG_LEVEL_TRACE, msg, null);
  }

  @Override
  public void trace(String format, Object param1) {
    formatAndLog(LOG_LEVEL_TRACE, format, param1, null);
  }

  @Override
  public void trace(String format, Object param1, Object param2) {
    formatAndLog(LOG_LEVEL_TRACE, format, param1, param2);
  }

  @Override
  public void trace(String format, Object... argArray) {
    formatAndLog(LOG_LEVEL_TRACE, format, argArray);
  }

  @Override
  public void trace(String msg, Throwable t) {
    log(LOG_LEVEL_TRACE, msg, t);
  }

  @Override
  public boolean isDebugEnabled() {
    return isLevelEnabled(LOG_LEVEL_DEBUG);
  }

  @Override
  public void debug(String msg) {
    log(LOG_LEVEL_DEBUG, msg, null);
  }

  @Override
  public void debug(String format, Object param1) {
    formatAndLog(LOG_LEVEL_DEBUG, format, param1, null);
  }

  @Override
  public void debug(String format, Object param1, Object param2) {
    formatAndLog(LOG_LEVEL_DEBUG, format, param1, param2);
  }

  @Override
  public void debug(String format, Object... argArray) {
    formatAndLog(LOG_LEVEL_DEBUG, format, argArray);
  }

  @Override
  public void debug(String msg, Throwable t) {
    log(LOG_LEVEL_DEBUG, msg, t);
  }

  @Override
  public boolean isInfoEnabled() {
    return isLevelEnabled(LOG_LEVEL_INFO);
  }

  @Override
  public void info(String msg) {
    log(LOG_LEVEL_INFO, msg, null);
  }

  @Override
  public void info(String format, Object arg) {
    formatAndLog(LOG_LEVEL_INFO, format, arg, null);
  }

  @Override
  public void info(String format, Object arg1, Object arg2) {
    formatAndLog(LOG_LEVEL_INFO, format, arg1, arg2);
  }

  @Override
  public void info(String format, Object... argArray) {
    formatAndLog(LOG_LEVEL_INFO, format, argArray);
  }

  @Override
  public void info(String msg, Throwable t) {
    log(LOG_LEVEL_INFO, msg, t);
  }

  @Override
  public boolean isWarnEnabled() {
    return isLevelEnabled(LOG_LEVEL_WARN);
  }

  @Override
  public void warn(String msg) {
    log(LOG_LEVEL_WARN, msg, null);
  }

  @Override
  public void warn(String format, Object arg) {
    formatAndLog(LOG_LEVEL_WARN, format, arg, null);
  }

  @Override
  public void warn(String format, Object arg1, Object arg2) {
    formatAndLog(LOG_LEVEL_WARN, format, arg1, arg2);
  }

  @Override
  public void warn(String format, Object... argArray) {
    formatAndLog(LOG_LEVEL_WARN, format, argArray);
  }

  @Override
  public void warn(String msg, Throwable t) {
    log(LOG_LEVEL_WARN, msg, t);
  }

  @Override
  public boolean isErrorEnabled() {
    return isLevelEnabled(LOG_LEVEL_ERROR);
  }

  @Override
  public void error(String msg) {
    log(LOG_LEVEL_ERROR, msg, null);
  }

  @Override
  public void error(String format, Object arg) {
    formatAndLog(LOG_LEVEL_ERROR, format, arg, null);
  }

  @Override
  public void error(String format, Object arg1, Object arg2) {
    formatAndLog(LOG_LEVEL_ERROR, format, arg1, arg2);
  }

  @Override
  public void error(String format, Object... argArray) {
    formatAndLog(LOG_LEVEL_ERROR, format, argArray);
  }

  @Override
  public void error(String msg, Throwable t) {
    log(LOG_LEVEL_ERROR, msg, t);
  }
  
}
