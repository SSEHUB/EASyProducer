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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * This Formatter is used by the EASyLogger to format the logging output.
 * 
 * @author Sass
 *
 */
public final class LogFormatter extends Formatter {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        // StringBuilder for output
        StringBuilder sb = new StringBuilder();
        // Start with Date
        Date date = new Date(record.getMillis());
        sb.append("[" + DATE_FORMAT.format(date)).append("]\t");
        // Add log level to log message
        sb.append("[" + record.getLevel() + "]\t")
            .append(formatMessage(record));
        
        // Create only debug links for eclipse if EASy-Producer is run inside Eclipse in debugging mode.
        if (EASyLoggerFactory.DEBUG) {
            appendEclipseDebugLink(record, sb);
        }
        
        sb.append(LINE_SEPARATOR);
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            record.getThrown().printStackTrace(pw);
            pw.close();
            sb.append(sw.toString());
        }
        return sb.toString();
    }

    /**
     * Appends a clickable link for the Eclipse IDE, which points to the file and line number where the Message was
     * created.
     * <b>Note:</b>
     * <ul>
     * <li>Only useful when Code was compiled with debug information</li>
     * <li>Only useful when EASy is executed inside Eclipse</li>
     * </ul>
     * @param record the log record to be formatted.
     * @param sb the formatted log record (which is currently build.
     */
    private void appendEclipseDebugLink(LogRecord record, StringBuilder sb) {
        String className = record.getMessage().substring(1, record.getMessage().indexOf("]"));
        final StackTraceElement callerFrame = getCallerStackFrame(className);
        final String fileName = null != callerFrame ? callerFrame.getFileName() : null;
        if (null != fileName) {
            final int lineNumber = callerFrame.getLineNumber();
            // This creates a link to the line when used in Eclipse
            sb.append(" (");
            sb.append(fileName);
            if (-1 != lineNumber) {
                sb.append(":");
                sb.append(lineNumber);
            }
            sb.append(")");
        }
    }
    
    /**
     * Gets the CallerStackFrame for the Class throwing the exception.
     * 
     * @param callerName Name of the class
     * @return  StackTraceElement of callerName
     */
    private StackTraceElement getCallerStackFrame(final String callerName) {
        StackTraceElement callerFrame = null;
        final StackTraceElement[] stack = new Throwable().getStackTrace();
        // Search the stack trace to find the calling class
        for (int i = 0; i < stack.length; i++) {
            final StackTraceElement frame = stack[i];
            if (frame.getClassName().endsWith(callerName)) {
                callerFrame = frame;
                break;
            }
        }
        return callerFrame;
    }
}
