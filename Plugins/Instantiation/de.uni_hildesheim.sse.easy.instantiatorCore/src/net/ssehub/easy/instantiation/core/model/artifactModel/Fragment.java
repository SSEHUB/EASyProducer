package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Marker annotation for classes which act as fragments. This annotation is considered
 * recursively, i.e., if a top-level class is marked as a fragment, it is inherited to 
 * the derived subclasses.
 * 
 * @author Holger Eichelberger
 */
@Target(ElementType.TYPE)
public @interface Fragment {

}
