package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactTypes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.AbstractCollectionWrapper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Realizes the implicit variable OTHERPROJECTS in {@link Script}.
 * 
 * @author Holger Eichelberger
 */
class OtherProjects implements Set<IArtifact> {

    private java.util.Set<IArtifact> data = new HashSet<IArtifact>();
    private TypeDescriptor<? extends IVilType>[] parameter;
    
    /**
     * Creates an instance.
     */
    OtherProjects() {
        parameter = TypeDescriptor.createArray(1);
        parameter[0] = ArtifactTypes.artifactType();
    }
    
    @Override
    public int getDimensionCount() {
        return 1;
    }

    @Override
    public TypeDescriptor<? extends IVilType> getDimensionType(int index) {
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
    public Set<IArtifact> selectByType(TypeDescriptor<? extends IVilType> type) {
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
    public Set<IArtifact> select(ExpressionEvaluator evaluator) throws ArtifactException {
        return new ListSet<IArtifact>(AbstractCollectionWrapper.select(this, evaluator), parameter);
    }

    @Override
    public Sequence<IArtifact> toSequence() {
        List<IArtifact> result = new ArrayList<IArtifact>();
        result.addAll(data);
        return new ListSequence<IArtifact>(result, parameter);
    }
    
    /**
     * Adds an artifact.
     * 
     * @param artifact the artifact to be added
     */
    void add(IArtifact artifact) {
        data.add(artifact);
    }

    @Override
    public IArtifact projectSingle() {
        return 1 == data.size() ? data.iterator().next() : null;
    }

}
