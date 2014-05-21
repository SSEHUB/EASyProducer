package de.uni_hildesheim.sse.utils.logger;

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
    
    private static final  SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        // StringBuilder for output
        StringBuilder sb = new StringBuilder();
        // Start with Date
        Date date = new Date(record.getMillis());
        sb.append("[" + DATE_FORMAT.format(date)).append("]\t");
        // Add log level to log message
        sb.append("[" + record.getLevel() + "]\t")
            .append(formatMessage(record))
            .append(LINE_SEPARATOR);
        
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            record.getThrown().printStackTrace(pw);
            pw.close();
            sb.append(sw.toString());
        }
        return sb.toString();
    }
}
