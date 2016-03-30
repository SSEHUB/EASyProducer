package de.uni_hildesheim.sse.persistency.xml.mapper;

import com.thoughtworks.xstream.mapper.ClassAliasingMapper;
import com.thoughtworks.xstream.mapper.Mapper;

import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;

/**
 * Class Aliasing Mapper that shortens the class names.
 * 
 * @author Sass
 *
 */
public class ClassNameAliasingMapper extends ClassAliasingMapper {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ClassNameAliasingMapper.class,
            Bundle.ID);

    /**
     * Constructor.
     * 
     * @param wrapped wrapped mapper
     */
    public ClassNameAliasingMapper(Mapper wrapped) {
        super(wrapped);
    }

    @Override
    public Class<?> realClass(String elementName) {
        Class<?> cls = null;
        try {
            if (XmlIo.CLASSES.containsKey(elementName)) {
                if (!elementName.equals("nulltype")) {
                    cls = Class.forName(XmlIo.CLASSES.get(elementName));
                    // Fallback
                    if (cls == null) {
                        cls = super.realClass(elementName);
                    }
                } 
            }
        } catch (IllegalArgumentException e) {
            logger.exception(e);
        } catch (ClassNotFoundException e) {
            logger.exception(e);
        }
        return cls;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String serializedClass(Class type) {
        String className = null;
        try {
            if (type != null) {
                className = type.getSimpleName();
                // Add appendix to alias to separate the distinguished types coming from IVML, VIL and VTL.
                String appendix = "";
                if (type.getName().contains("varModel")) {
                    appendix = "v";
                }
                if (type.getName().contains("buildlang")) {
                    appendix = "b";
                }
                if (type.getName().contains("templang")) {
                    appendix = "t";
                }
                if (type.getName().contains("common")) {
                    appendix = "c";
                }
                if (type.getName().contains("vilTypes")) {
                    appendix = "vt";
                }
                if (type.getName().contains("templateModel")) {
                    appendix = "tm";
                }
                // shorten the string a bit by removing vowels
                String newClassName = className.replaceAll("[AEIOUaeiou]", "");
                className = newClassName + appendix;
                XmlIo.CLASSES.put(className, type.getName());
            } else {
                className = "nulltype";
                XmlIo.CLASSES.put(className, className);
            }
        } catch (IllegalArgumentException e) {
            logger.exception(e);
        }
        return className;
    }
    
}