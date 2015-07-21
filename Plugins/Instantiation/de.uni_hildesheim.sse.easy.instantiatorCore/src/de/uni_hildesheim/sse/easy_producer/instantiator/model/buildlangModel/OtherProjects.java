package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactTypes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.AbstractCollectionWrapper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Realizes the implicit variable OTHERPROJECTS in {@link Script}.
 * 
 * @author Holger Eichelberger
 */
class OtherProjects implements Set<IArtifact> {

    private java.util.Set<IArtifact> data = new HashSet<IArtifact>();
    private TypeDescriptor<?>[] parameter;
    private TypeDescriptor<?> type;
    
    /**
     * Creates an instance.
     */
    OtherProjects() {
        parameter = TypeDescriptor.createArray(1);
        parameter[0] = ArtifactTypes.artifactType();
        try {
            type = TypeRegistry.getSetType(parameter);
        } catch (VilException e) {
            type = TypeRegistry.DEFAULT.findType(Set.class);
        }
    }
    
    @Override
    public int getGenericParameterCount() {
        return 1;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        return parameter[index];
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean allowSequenceAdjustment() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isNotEmpty() {
        return !data.isEmpty();
    }

    @Override
    public boolean includes(IArtifact element) {
        return data.contains(element);
    }

    @Override
    public boolean excludes(IArtifact element) {
        return !data.contains(element);
    }

    @Override
    public int count(IArtifact element) {
        return data.contains(element) ? 1 : 0;
    }

    @Override
    public Iterator<IArtifact> iterator() {
        return data.iterator();
    }

    @Override
    public boolean isEquals(Collection<?> elements) {
        return AbstractCollectionWrapper.sameElements(this, elements);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "OTHERPROJECTS";
    }

    @Override
    public Set<IArtifact> selectByType(TypeDescriptor<?> type) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.selectByType(this, type), parameter);
    }

    @Override
    public Set<IArtifact> excluding(Collection<IArtifact> set) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.excluding(this, set), parameter);
    }

    @Override
    public Set<IArtifact> including(Collection<IArtifact> set) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.including(this, set), parameter);
    }

    @Override
    public Set<IArtifact> select(ExpressionEvaluator evaluator) throws VilException {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.select(this, evaluator), parameter);
    }

    @Override
    public Sequence<IArtifact> toSequence() {
        List<IArtifact> result = new ArrayList<IArtifact>();
        result.addAll(data);
        return new ListSequence<IArtifact>(result, parameter);
    }

    @Override
    public IArtifact add(IArtifact artifact) {
        data.add(artifact);
        return artifact;
    }

    @Override
    public IArtifact projectSingle() {
        return 1 == data.size() ? data.iterator().next() : null;
    }

    @Override
    public boolean remove(IArtifact element) {
        return data.remove(element);
    }

    @Override
    public java.util.Set<IArtifact> toMappedSet() {
        return null; // used internally only
    }

    @Override
    public TypeDescriptor<?> getType() {
        return type;
    }

}
