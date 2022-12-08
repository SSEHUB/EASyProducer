package au.com.jcloud.lxd.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {

	public static final String DATE_PATTERN_ISO8601_SHORT = "yyyyMMdd";
	public static final String DATE_PATTERN_ISO8601_SHORT_EXT = "yyyy-MM-dd";
	public static final String DATE_PATTERN_ISO8601_LONG = "yyyyMMdd'T'HHmm";
	public static final String DATE_PATTERN_ISO8601_LONG_EXT = "yyyy-MM-dd'T'HH:mm";
	public static final DateFormat DATE_FORMAT_ISO8601_SHORT = new SimpleDateFormat(DATE_PATTERN_ISO8601_SHORT);
	public static final DateFormat DATE_FORMAT_ISO8601_SHORT_EXT = new SimpleDateFormat(DATE_PATTERN_ISO8601_SHORT_EXT);
	public static final DateFormat DATE_FORMAT_ISO8601_LONG = new SimpleDateFormat(DATE_PATTERN_ISO8601_LONG);
	public static final DateFormat DATE_FORMAT_ISO8601_LONG_EXT = new SimpleDateFormat(DATE_PATTERN_ISO8601_LONG_EXT);

	public static String convertDateTimeToISO(Date date) {
		return DATE_FORMAT_ISO8601_LONG_EXT.format(date);
	}
	
	public static String convertDateToISO(Date date) {
		return DATE_FORMAT_ISO8601_SHORT_EXT.format(date);
	}

	public static String convertIntegerToMB(Long input) {
		return String.valueOf(new BigDecimal(Double.valueOf(input) / 1024 / 1024).setScale(2, RoundingMode.HALF_UP));
	}
	
	public static String convertIntegerToKB(Long input) {
		return String.valueOf(new BigDecimal(Double.valueOf(input) / 1024).setScale(2, RoundingMode.HALF_UP));
	}

}
