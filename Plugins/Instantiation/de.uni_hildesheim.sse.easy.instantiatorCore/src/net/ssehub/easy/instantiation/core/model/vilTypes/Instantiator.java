package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a {@link IVilType} is an instantiator. An instantiator takes arbitrary parameters from VIL
 * and turns these settings into instantiated artifacts. Therefore it implements at least one 
 * method with the same name as {@link #value()} that will be made available to the VIL build language.
 * In case that the method is static, it will be called directly. Instantiator methods may throw exceptions. 
 * In case that the method is not static,
 * an instance of the annotated class will be created (similar to artifacts, i.e., a public static method
 * named "create", same return type as class, here without parameter, which then shall call create a new 
 * instance using the constructor of the class). It is encouraged that an instantiator returns the affected 
 * artifacts as return values (in particular as {@link Set VIL set}). Please note that classes 
 * marked with this annotation may additionally implement 
 * the interface {@link net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactNotifier}.
 * In this case, the instantiator methods shall be non-static. During execution of the VIL build flow, 
 * appropriate instances will be created and linked to the current artifact model.<br/>
 * If {@link ClassMeta} and this annotation are applied to the same class, this annotation takes precedence. 
 * Instantiators are registered using {@link TypeRegistry#registerType(Class)}.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Instantiator {

    /**
     * The name of the instantiator as it will appear in VIL build flows for production strategy execution.
     * To be recognized, instantiator methods must have the same name. Please note that VIL buildlanguage
     * keywords shall not be used as name as such instantiators will not be available!
     * 
     * @return the name
     */
    String value();
    
    /**
     * Whether this instantiator may react on implicit parameters 
     * such as {@link Constants#IMPLICIT_PARENT_PARAMETER_NAME}. <br/>
     * <code>true</code> for implicit parameters, <code>false</code> else
     * 
     * @return whether this instantiator may react on implicit parameters
     */
    boolean acceptsImplicitParameters() default false;
}
