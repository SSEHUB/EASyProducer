package de.uni_hildesheim.sse.easy.java.artifacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * A Java fragment artifact, which is also a Java parent element. Please note that it may
 * be necessary to override {@link #deleteChild(FragmentArtifact)} depending on the child 
 * storage strategy of the actual implementation.
 * 
 * @author Holger Eichelberger
 */
abstract class JavaParentFragmentArtifact extends JavaFragmentArtifact implements IJavaParent {

    /**
     * Creates a new parent fragment artifact.
     * 
     * @param parent the parent of this artifact
     */
    protected JavaParentFragmentArtifact(IJavaParent parent) {
        super(parent);
    }
    
    @Override
    public void notifyChildChanged(FragmentArtifact child) {
        getParent().notifyChildChanged(child);
    }

    @Override
    public void deleteChild(FragmentArtifact child) throws ArtifactException {
        notifyChanged();
    }

    /**
     * Turns a dom tree expression into a string.
     * 
     * @param expression the expression
     * @return the string representation
     */
    private static String toString(Expression expression) {
        String value = expression.toString();
        if (expression instanceof StringLiteral) {
            value = value.substring(1, value.length() - 1);
        }
        return value;
    }
    
    /**
     * Returns the annotations for a given <code>modifierList</code>.
     * 
     * @param modifierList the modifier list to be processed
     * @return An ArraySet with all annotations
     */
    @OperationMeta(returnGenerics = JavaAnnotation.class)
    public Set<JavaAnnotation> annotations(List<IExtendedModifier> modifierList) {
        List<JavaAnnotation> list = new ArrayList<JavaAnnotation>();
        for (Object modifier : modifierList) {
            if (modifier instanceof org.eclipse.jdt.core.dom.Annotation) {
                org.eclipse.jdt.core.dom.Annotation annot = (org.eclipse.jdt.core.dom.Annotation) modifier;
                // Get annotation name and value
                Map<String, String> fields = new HashMap<String, String>();
                // possibly the unqualified name as not resolved unless not given as qualified name!
                String name = annot.getTypeName().getFullyQualifiedName(); 
                if (annot instanceof SingleMemberAnnotation) {
                    fields.put(JavaAnnotation.DEFAULT_FIELD, 
                        toString(((SingleMemberAnnotation) modifier).getValue()));
                } else if (annot instanceof NormalAnnotation) {
                    @SuppressWarnings("unchecked")
                    List<MemberValuePair> values = ((NormalAnnotation) annot).values();
                    for (MemberValuePair pair : values) {
                        fields.put(pair.getName().getIdentifier(), toString(pair.getValue()));
                    }
                }
                list.add(new JavaAnnotation(name, fields, this));
            }
        }
        return new ArraySet<JavaAnnotation>(list.toArray(new JavaAnnotation[list.size()]), JavaAnnotation.class);
    }

}
