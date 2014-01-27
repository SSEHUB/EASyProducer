package de.uni_hildesheim.sse.instantiator.velocitylib;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;

public class Utils {

    public static VelocityEngine createVelocityEngine() {
        return createVelocityEngine(null);
    }
    
    public static void disableLogging(Properties properties) {
        if (null != properties) {
        	properties.put("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
        }
    }
    
    public static VelocityEngine createVelocityEngine(Properties properties) {
        VelocityEngine engine = new VelocityEngine();
        Properties prop = new Properties();
        if (null != properties) {
            prop.putAll(properties);
        }
        prop.put("resource.loader", "file");
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        prop.put("file.resource.loader.path", "");
        try {
            engine.init(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return engine;
    }

}
