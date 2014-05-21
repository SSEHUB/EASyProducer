package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ITypeResolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * A type resolver for IVML models.
 * 
 * @author Holger Eichelberger
 */
public class IvmlTypeResolver implements ITypeResolver {

    @SuppressWarnings("unused")
    private Project project;

    /**
     * Creates an IVML type resolver.
     * 
     * @param project the IVML model
     */
    public IvmlTypeResolver(Project project) {
        this.project = project;
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> resolveType(String name) {
        return null;
    }

    @Override
    public TypeDescriptor<? extends IVilType> resolveInstantiator(String name) {
        return null;
    }

}
