package de.java.instantiator.prototype.model.artifactModel.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a Java annotation.
 * 
 * @author Holger Eichelberger
 */
public class Method extends FragmentArtifact {
    
    private MethodDeclaration methodDeclaration;
    
    /**
     * Default Constructor.
     * 
     * @param node The Method Declaration
     */
    public Method(MethodDeclaration node) {
        this.methodDeclaration = node;
    }

    @Override
    public void delete() throws ArtifactException {
        methodDeclaration.delete();
    }

    @Override
    public String getName() throws ArtifactException {
        return methodDeclaration.getName().toString();
    }

    @Override
    public void rename(String name) throws ArtifactException {
        methodDeclaration.setName(methodDeclaration.getAST().newSimpleName(name));
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFragmentArtifact(this);
    }
    
    /**
     * Returns the annotations of this method.
     * 
     * @return the annotations
     */
    @OperationMeta(returnGenerics = Annotation.class)
    public Set<Annotation> annotations() {
        List<IExtendedModifier> modifierList = methodDeclaration.modifiers();
        List<Annotation> list = new ArrayList<Annotation>();
        for (Object modifier : modifierList) {
            if (modifier instanceof SingleMemberAnnotation) {
                // Get annotation name and value
                String name = ((org.eclipse.jdt.core.dom.Annotation) modifier).getTypeName().toString();
                Expression expression = ((SingleMemberAnnotation) modifier).getValue();
                String value = expression.toString();
                if (expression instanceof StringLiteral) {
                    value = value.substring(1, value.length() - 1);
                }
                Annotation annotation = new Annotation(name, value);
                list.add(annotation);
            }
        }
        return new ArraySet<Annotation>(list.toArray(new Annotation[list.size()]), Annotation.class);
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Getter for the MethodDeclaration of the method.
     * 
     * @return Returns the MethodDeclaration of the method.
     */
    public MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

}
