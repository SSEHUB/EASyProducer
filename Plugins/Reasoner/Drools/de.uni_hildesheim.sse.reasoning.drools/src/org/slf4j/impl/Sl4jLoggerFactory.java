package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class Sl4jLoggerFactory implements ILoggerFactory {

    private static final Logger sl4jLogger = new Sl4jLogger();
    
    @Override
    public Logger getLogger(String arg0) {
        return sl4jLogger;
    }

}
