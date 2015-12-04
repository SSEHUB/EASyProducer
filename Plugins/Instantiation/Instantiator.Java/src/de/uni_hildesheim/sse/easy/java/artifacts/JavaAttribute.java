package de.uni_hildesheim.sse.easy.java.artifacts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents a Java attribute.
 * 
 * @author Holger Eichelberger, Sass
 */
public class JavaAttribute extends JavaParentFragmentArtifact {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(JavaAttribute.class, Bundle.ID);

    private FieldDeclaration fieldDeclaration;

    private String attributeName;
    
    /**
     * Default Constructor.
     * 
     * @param node The FieldDeclaration node
     * @param name The name of the attribute.
     * @param parent the parent artifact or fragment
     */
    public JavaAttribute(FieldDeclaration node, String name, IJavaParent parent) {
        super(parent);
        this.fieldDeclaration = node;
        this.attributeName = name;
    }

    @Override
    public void delete() throws VilException {
        fieldDeclaration.delete();
        super.delete();
        store();
        notifyChanged();
    }

    @Override
    public String getName() throws VilException {
        return attributeName;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void rename(String name) throws VilException {
        List<VariableDeclarationFragment> list = fieldDeclaration.fragments();
        for (VariableDeclarationFragment variableDeclarationFragment : list) {
            variableDeclarationFragment.setName(fieldDeclaration.getAST().newSimpleName(name));
        }
        notifyChanged();
    }

    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws VilException {
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
    @OperationMeta(returnGenerics = JavaAnnotation.class)
    public Set<JavaAnnotation> annotations() {
        return annotations(fieldDeclaration.modifiers());
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
                if (value instanceof DecisionVariable) {
                    value = ((DecisionVariable) value).getValue();
                }
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
                    expression = fieldDeclaration.getAST().newBooleanLiteral(Boolean.valueOf(value.toString()));
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
                    notifyChanged();
                }
            } else {
                fragment.setInitializer(null);
                notifyChanged();
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
        notifyChanged();
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
        notifyChanged();
    }

    /**
     * Getter for the FieldDeclaration of the Attribute.
     * 
     * @return Returns the FieldDeclaration of the Attribute.
     */
    @Invisible
    FieldDeclaration getFieldDeclaration() {
        return fieldDeclaration;
    }

    @Invisible
    @Override
    public String getStringValue(StringComparator comparator) {
        return "attribute '" + getNameSafe() + "'";
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }

    // override deleteChild in case of stored attributes or other substructures
}
