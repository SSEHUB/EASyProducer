package org.slf4j.impl;

import org.slf4j.Logger;
import org.slf4j.Marker;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;

public class Sl4jLogger implements Logger {
    
    private static EASyLogger easyLoggerInstance = EASyLoggerFactory.INSTANCE.getLogger(Sl4jLogger.class, "Drools");

    @Override
    public void debug(String arg0) {
        easyLoggerInstance.warn("blubb" + arg0);        
    }

    @Override
    public void debug(String arg0, Object arg1) {
        easyLoggerInstance.warn(arg0);        
    }

    @Override
    public void debug(String arg0, Object[] arg1) {
        easyLoggerInstance.warn(arg0);        
    }

    @Override
    public void debug(String arg0, Throwable arg1) {
        easyLoggerInstance.warn(arg0);        
    }

    @Override
    public void debug(Marker arg0, String arg1) {
        easyLoggerInstance.warn(arg1);        
    }

    @Override
    public void debug(String arg0, Object arg1, Object arg2) {
        easyLoggerInstance.warn(arg0);        
    }

    @Override
    public void debug(Marker arg0, String arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void debug(Marker arg0, String arg1, Object[] arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void debug(Marker arg0, String arg1, Throwable arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(String arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(String arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(String arg0, Object[] arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(String arg0, Throwable arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(Marker arg0, String arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(String arg0, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(Marker arg0, String arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(Marker arg0, String arg1, Object[] arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(Marker arg0, String arg1, Throwable arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void info(String arg0) {
        easyLoggerInstance.info("blubb" + arg0);  
    }

    @Override
    public void info(String arg0, Object arg1) {
        easyLoggerInstance.info("blubb" + arg0);  
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(String arg0, Object[] arg1) {
        easyLoggerInstance.info("blubb" + arg0);  
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(String arg0, Throwable arg1) {
        easyLoggerInstance.info("blubb" + arg0);  
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(Marker arg0, String arg1) {
        easyLoggerInstance.info("blubb" + arg0);  
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(String arg0, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(Marker arg0, String arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(Marker arg0, String arg1, Object[] arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(Marker arg0, String arg1, Throwable arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isDebugEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDebugEnabled(Marker arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isErrorEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isErrorEnabled(Marker arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isInfoEnabled(Marker arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTraceEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTraceEnabled(Marker arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWarnEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWarnEnabled(Marker arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void trace(String arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(String arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(String arg0, Object[] arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(String arg0, Throwable arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(Marker arg0, String arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(String arg0, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(Marker arg0, String arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(Marker arg0, String arg1, Object[] arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(Marker arg0, String arg1, Throwable arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(String arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(String arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(String arg0, Object[] arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(String arg0, Throwable arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(Marker arg0, String arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(String arg0, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(Marker arg0, String arg1, Object arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(Marker arg0, String arg1, Object[] arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(Marker arg0, String arg1, Throwable arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub
        
    }

}
