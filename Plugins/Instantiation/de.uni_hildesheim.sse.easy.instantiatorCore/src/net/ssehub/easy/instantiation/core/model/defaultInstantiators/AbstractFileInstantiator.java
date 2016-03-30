package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import java.io.File;
import java.util.Iterator;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;

/**
 * An abstract file instantiator providing helpful functionality..
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractFileInstantiator implements IVilType {

    /**
     * Turns an object into a string as parameter to the command line compiler.
     * 
     * @param object the object to be turned into a string
     * @return the string representing the object
     */
    protected static String toString(Object object) {
        String result;
        if (object instanceof Collection) {
            StringBuilder tmp = new StringBuilder();
            Iterator<?> iter = ((Collection<?>) object).iterator();
            while (iter.hasNext()) {
                tmp.append(toString(iter.next()));
                if (iter.hasNext()) {
                    tmp.append(File.pathSeparator);
                }
            }
            result = tmp.toString();
        } else {
            result = StringValueHelper.getStringValue(object, null);
        }
        return result;
    }
    
    /**
     * Determines the target path from a VIL path and ensures its existence.
     * 
     * @param target the VIL target path
     * @return the target path as a string or <b>null</b> if none shall be set
     */
    protected static File determineTargetPath(Path target) {
        File result = null; 
        File targetPath = target.getAbsolutePath();
        if (FileUtils.isFile(targetPath)) {
            targetPath = targetPath.getParentFile();
        }
        String targetPathString = targetPath.getPath();
        // normalize?
        if (!targetPathString.equals(".")) {
            result = targetPath.getAbsoluteFile();
            if (!result.exists()) {
                result.mkdirs();
            }
        } // else shall not be used as parameter...
        return result;
    }

}
