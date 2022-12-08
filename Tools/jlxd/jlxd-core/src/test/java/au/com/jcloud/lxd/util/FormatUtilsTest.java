package au.com.jcloud.lxd.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class FormatUtilsTest {

	@Test
	public void convertIntegerToMB_shouldHandle0() {
		assertEquals("0.00",FormatUtils.convertIntegerToMB(0L));
	}
	
	@Test
	public void convertIntegerToMB_shouldHandleSmallIntegers() {
		assertEquals("0.00",FormatUtils.convertIntegerToMB(1024L));
		assertEquals("0.98",FormatUtils.convertIntegerToMB(1024000L));
	}
	
	@Test
	public void convertIntegerToMB_shouldHandleLargeInteger() {
		assertEquals("8.78",FormatUtils.convertIntegerToMB(9207808L));
		assertEquals("9.11",FormatUtils.convertIntegerToMB(9555968L));
	}
	
	@Test
	public void convertIntegerToMB_shouldHandleRoundUp() {
		assertEquals("0.00",FormatUtils.convertIntegerToMB(5*1024L));
		assertEquals("0.01",FormatUtils.convertIntegerToMB(6*1024L));
	}
	
	@Test
	public void convertIntegerToKB_shouldHandle0() {
		assertEquals("0.00",FormatUtils.convertIntegerToKB(0L));
	}
	
	@Test
	public void convertIntegerToKB_shouldHandleSmallIntegers() {
		assertEquals("0.25",FormatUtils.convertIntegerToKB(256L));
		assertEquals("0.50",FormatUtils.convertIntegerToKB(513L));
	}
	
	@Test
	public void convertIntegerToKB_shouldHandleLargeInteger() {
		assertEquals("90.63",FormatUtils.convertIntegerToKB(92808L));
		assertEquals("9332.00",FormatUtils.convertIntegerToKB(9555968L));
	}
	
	@Test
	public void convertIntegerToKB_shouldHandleRoundUp() {
		assertEquals("0.00",FormatUtils.convertIntegerToKB(5L));
		assertEquals("0.01",FormatUtils.convertIntegerToKB(6L));
	}
	
	@Test
	public void convertDateToISO_shouldWork() throws ParseException {
		Date date = FormatUtils.DATE_FORMAT_ISO8601_SHORT.parse("20170512");
		assertEquals("2017-05-12", FormatUtils.convertDateToISO(date));
	}
	
	@Test
	public void convertDateTimeToISO_shouldWork() throws ParseException {
		Date date = FormatUtils.DATE_FORMAT_ISO8601_LONG.parse("20170512T1918");
		assertEquals("2017-05-12T19:18", FormatUtils.convertDateTimeToISO(date));
	}
}
