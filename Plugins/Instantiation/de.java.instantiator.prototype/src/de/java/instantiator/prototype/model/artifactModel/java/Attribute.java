package de.java.instantiator.prototype.model.artifactModel.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import de.java.instantiator.prototype.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents a Java attribute.
 * 
 * @author Holger Eichelberger, Sass
 */
public class Attribute extends FragmentArtifact {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(Attribute.class, Bundle.ID);

    private FieldDeclaration fieldDeclaration;

    private String attributeName;

    /**
     * Default Constructor.
     * 
     * @param node
     *            The FieldDeclaration node
     * @param name
     *            The name of the attribute.
     */
    public Attribute(FieldDeclaration node, String name) {
        this.fieldDeclaration = node;
        this.attributeName = name;
    }

    @Override
    public void delete() throws ArtifactException {
        fieldDeclaration.delete();
    }

    @Override
    public String getName() throws ArtifactException {
        return attributeName;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void rename(String name) throws ArtifactException {
        List<VariableDeclarationFragment> list = fieldDeclaration.fragments();
        for (VariableDeclarationFragment variableDeclarationFragment : list) {
            variableDeclarationFragment.setName(fieldDeclaration.getAST().newSimpleName(name));
        }
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
     * Returns the annotations of this attribute.
     * 
     * @return An ArraySet with all annotations
     */
    @SuppressWarnings("unchecked")
    @OperationMeta(returnGenerics = Annotation.class)
    public Set<Annotation> annotations() {
        List<IExtendedModifier> modifierList = fieldDeclaration.modifiers();
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

    /**
     * Defines the (initial) value of this attribute.
     * 
     * @param value
     *            the value of this attribute
     */
    @SuppressWarnings("unchecked")
    public void setValue(Object value) {
        List<VariableDeclarationFragment> list = fieldDeclaration.fragments();
        for (VariableDeclarationFragment fragment : list) {
            /*
             * Determine the type of the fragment node and create a suitable expression. If value is null than set the
             * initializer directly.
             */
            if (value != null) {
                int type = fragment.getInitializer().getNodeType();
                Expression expression = null;
                switch (type) {
                case Expression.NUMBER_LITERAL:
                    expression = fieldDeclaration.getAST().newNumberLiteral(String.valueOf(value));
                    break;
                case Expression.STRING_LITERAL:
                    expression = fieldDeclaration.getAST().newStringLiteral();
                    ((StringLiteral) expression).setLiteralValue(String.valueOf(value));
                    break;
                case Expression.BOOLEAN_LITERAL:
                    expression = fieldDeclaration.getAST().newBooleanLiteral((Boolean) value);
                    break;
                case Expression.CHARACTER_LITERAL:
                    expression = fieldDeclaration.getAST().newCharacterLiteral();
                    ((StringLiteral) expression).setLiteralValue(String.valueOf(value));
                    break;
                case Expression.NULL_LITERAL:
                    expression = fieldDeclaration.getAST().newNullLiteral();
                    break;
                case Expression.TYPE_LITERAL:
                    expression = fieldDeclaration.getAST().newTypeLiteral();
                    break;
                default:
                    logger.error("Type '" + ASTNode.nodeClassForType(type) + "' not supported yet...");
                    break;
                }
                if (expression != null) {
                    fragment.setInitializer(expression);
                }
            } else {
                fragment.setInitializer(null);
            }
        }
    }

    /**
     * Makes an attribute constant.
     */
    @SuppressWarnings("unchecked")
    public void makeConstant() {
        List<IExtendedModifier> modifierList = fieldDeclaration.modifiers();
        logger.debug("Trying to make attribute '" + attributeName + "' constant...");
        /*
         * Test if modifier already exists. If they don't exist than add them to the modifier list.
         */
        if (testIfModifierExists(ModifierKeyword.STATIC_KEYWORD, modifierList)) {
            logger.debug("modifier 'static' already exists");
        } else {
            modifierList.add(fieldDeclaration.getAST().newModifier(Modifier.ModifierKeyword.STATIC_KEYWORD));
            logger.debug("Added 'static' modifier to '" + attributeName + "'");
        }
        if (testIfModifierExists(ModifierKeyword.FINAL_KEYWORD, modifierList)) {
            logger.debug("modifier 'final' already exists...");
        } else {
            modifierList.add(fieldDeclaration.getAST().newModifier(Modifier.ModifierKeyword.FINAL_KEYWORD));
            logger.debug("Added 'final' modifier to '" + attributeName + "'");
        }
    }

    /**
     * Test if a modifier keyword is already present.
     * 
     * @param keyword
     *            The modifier keyword
     * @param modifierList
     *            Live ordered list with modifiers.
     * @return true if keyword is present
     */
    private boolean testIfModifierExists(ModifierKeyword keyword, List<IExtendedModifier> modifierList) {
        boolean result = false;
        for (Object object : modifierList) {
            if (object.toString().equals(keyword.toString())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Makes a constant attribute variable.
     */
    @SuppressWarnings("unchecked")
    public void makeVariable() {
        List<IExtendedModifier> modifierList = fieldDeclaration.modifiers();
        List<IExtendedModifier> removeList = new ArrayList<IExtendedModifier>();
        logger.debug("Trying to make attribute '" + attributeName + "' variable...");
        for (Object modifier : modifierList) {
            /*
             * Mark modifier for deletion if it exists. To avoid NoSuchElementException this modifier will be put in a
             * separate list and will be removed later.
             */
            if (modifier.toString().equals(Modifier.ModifierKeyword.FINAL_KEYWORD.toString())
                    || modifier.toString().equals(Modifier.ModifierKeyword.STATIC_KEYWORD.toString())) {
                logger.debug("'" + modifier + "' flagged for deletion...");
                removeList.add((IExtendedModifier) modifier);
            }
        }
        logger.debug("Remove modifiers...");
        modifierList.removeAll(removeList);
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
    }

    /**
     * Getter for the FieldDeclaration of the Attribute.
     * 
     * @return Returns the FieldDeclaration of the Attribute.
     */
    public FieldDeclaration getFieldDeclaration() {
        return fieldDeclaration;
    }

}
