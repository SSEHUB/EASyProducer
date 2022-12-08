package au.com.jcloud.lxd.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by david.vittor on 31/07/16.
 */
public enum StatusCode {
    OPERATION_CREATED(100),
    STARTED(101),
    STOPPED(102),
    RUNNING(103),
    CANCELLING(104),
    PENDING(105),
    STARTING(106),
    STOPPING(107),
    ABORTING(108),
    FREEZING(109),
    FROZEN(110),
    THAWED(111),
    SUCCESS(200),
    FAILURE(400),
    CANCELLED(401);

    private int value;

    StatusCode(int value) {
        this.value = value;
    }
    
    public int getValue() {
    	return value;
    }

    public static StatusCode parse(int value) {
        for (StatusCode statusCode : values()) {
            if (statusCode.value == value) {
                return statusCode;
            }
        }
        return null;
    }

    public static StatusCode parse(String value) {
        if (StringUtils.isNotBlank(value) && StringUtils.isNumeric(value)) {
            int intValue = Integer.parseInt(value);
            return StatusCode.parse(intValue);
        }
        return null;
    }
}
