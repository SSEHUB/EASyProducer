package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactTypes;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;
import net.ssehub.easy.instantiation.core.model.vilTypes.AbstractCollectionWrapper;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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

    @OperationMeta(name = {"notEmpty", "isNotEmpty"}, notOclCompliant = "isNotEmpty")
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
        return new ListSet<IArtifact>(AbstractCollectionWrapper.selectByType(this, type, false, false), parameter);
    }

    @Override
    public Set<IArtifact> selectByKind(TypeDescriptor<?> type) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.selectByType(this, type, true, false), parameter);
    }

    @Override
    public Set<IArtifact> typeReject(TypeDescriptor<?> type) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.selectByType(this, type, true, true), parameter);
    }

    @Override
    public Set<IArtifact> excluding(Collection<IArtifact> set) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.excluding(this, set), parameter);
    }

    @Override
    public Set<IArtifact> including(Collection<IArtifact> set) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.including(this, set), parameter);
    }

    @OperationMeta(useParameter = 0)
    @Override
    public Set<IArtifact> select(ExpressionEvaluator evaluator) throws VilException {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.select(this, evaluator, true), parameter);
    }

    @OperationMeta(useParameter = 0)
    @Override
    public Set<IArtifact> reject(ExpressionEvaluator evaluator) throws VilException {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.select(this, evaluator, false), parameter);
    }

    @Override
    public Set<?> collect(ExpressionEvaluator evaluator) throws VilException {
        return new ListSet<Object>(AbstractCollectionWrapper.collect(this, evaluator), parameter);
    }

    @OperationMeta(allowsAggregation = true)
    @Override
    public Object apply(ExpressionEvaluator evaluator) throws VilException {
        return AbstractCollectionWrapper.apply(this, evaluator);
    }

    @Override
    public Sequence<IArtifact> toSequence() {
        List<IArtifact> result = new ArrayList<IArtifact>();
        result.addAll(data);
        return new ListSequence<IArtifact>(result, parameter);
    }
    
    @Override
    public Sequence<IArtifact> asSequence() {
        return toSequence();
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

    @Override
    public Set<IArtifact> union(Set<IArtifact> set) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.union(this, set), parameter);
    }

    @Override
    public Set<IArtifact> intersection(Set<IArtifact> set) {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.intersection(this, set), parameter);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Object sum() {
        return null;
    }

    @Override
    public Object product() {
        return null;
    }
    
}
