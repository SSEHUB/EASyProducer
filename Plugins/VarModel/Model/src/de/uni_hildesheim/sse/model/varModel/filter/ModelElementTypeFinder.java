package de.uni_hildesheim.sse.model.varModel.filter;

import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * This class provides a visitor for providing a {@link ModelElementDescription} of a model element
 * in a specific {@link Project}. The search for the desired model element only requires the name of
 * that element and the {@link Project} the element is located in.
 * 
 * @author kroeher
 *
 */
public class ModelElementTypeFinder extends AbstractProjectVisitor {
    
    /**
     * This inner class is used as return type of the outer {@link ModelElementTypeFinder}
     * that stores the relevant information (name, type, and class) of the model element
     * found in a {@link Project}.
     * 
     * This information can be used to identify this model element in an IVML-file for efficiently
     * by searching only the relevant part of the corresponding parse tree.
     * 
     * @author kroeher
     *
     */
    public class ModelElementDescription {
        
        /**
         * Stores the name of the model element.
         */
        private String elementName;
        
        /**
         * Stores the type of the model element.
         */
        private String elementType;
        
        /**
         * Stores the class the model element is an instance of.
         */
        private ClassType elementClass;
        
        /**
         * Constructs an {@link ModelElementDescription} that provides the name, type and
         * class of a model element.
         * 
         * @param name the name of the model element as a {@link String}
         * @param type the type of the model element as a {@link String}
         * @param clazz the class the model element is an instance of as a {@link String}
         */
        public ModelElementDescription(String name, String type, ClassType clazz) {
            elementName = name;
            elementType = type;
            elementClass = clazz;
        }
        
        /**
         * Returns the name of the model element this {@link ModelElementDescription} describes.
         * 
         * @return the name of the model element as a {@link String}
         */
        public String getElementName() {
            return elementName;
        }
        
        /**
         * Returns the type of the model element this {@link ModelElementDescription} describes.
         * 
         * @return the type of the model element as a {@link String}
         */
        public String getElementType() {
            return elementType;
        }
        
        /**
         * Returns the class of the model element this {@link ModelElementDescription} describes.
         * 
         * @return the {@link ClassType} the the model element is an instance of
         */
        public ClassType getElementClass() {
            return elementClass;
        }
    }
    
    /**
     * Type descriptions.
     * 
     * @author kroeher
     *
     */
    public enum ClassType { PROJECT, DECISION_VARIABLE_DECLARATION, ENUM, ORDERED_ENUM, COMPOUND, MAPPING };
        
    /**
     * Constant strings that are used to map {@link ClassType}s to a textual representation.
     */
    private static final String DECISION_VARIABLE_TYPE = "DecisionVariableDeclaration";
    private static final String ENUM_TYPE = "enum";
    private static final String COMPOUND_TYPE = "compound";
    private static final String MAPPING_TYPE = "DerivedDatatype";
    
    /**
     * Stores the description of the the model element found in a given {@link Project}.
     */
    private ModelElementDescription elementTypeDescription;
    
    /**
     * Stores the {@link Project} in which the model element is located.
     */
    private Project targetProject;
    
    /**
     * Stores the name of the model element for which the {@link ModelElementDescription} should be found.
     */
    private String searchElementName;

    /**
     * Constructs a new {@link ModelElementTypeFinder}.
     * 
     * @param originProject the {@link Project} in which the model element is located
     * @param filterType specifies whether project imports shall be considered or not using a {@link FilterType}
     */
    public ModelElementTypeFinder(Project originProject, FilterType filterType) {
        super(originProject, filterType);
        targetProject = originProject;
    }
    
    /**
     * Returns a {@link ModelElementDescription} of the model element specified by the given element name.
     * 
     * @param elementName the name of the model element as a {@link String} for which the description should be created
     * @return the {@link ModelElementDescription}. May return <code>null</code> if the
     * given model element name is empty, the {@link Project} does not exist, or the element could not be found.
     */
    public ModelElementDescription getDatatypeByElementName(String elementName) {
        ModelElementDescription elementDescription = null;
        if (targetProject != null && elementName != null && !elementName.isEmpty()) {
            searchElementName = elementName;            
            targetProject.accept(this);
            elementDescription = elementTypeDescription;
        }
        return elementDescription;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        if (decl.getName() != null && decl.getName().equals(searchElementName)) {
            IDatatype foundType = decl.getType();
            if (foundType != null) {
                String fullType = StringProvider.toIvmlString(foundType);
                elementTypeDescription = new ModelElementDescription(searchElementName, fullType,
                        ClassType.DECISION_VARIABLE_DECLARATION);
            }
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO implement if required   
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // TODO implement if required  
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        int freezableCounter = 0;
        boolean matchingFreezableFound = false;
        while (!matchingFreezableFound && freezableCounter < freeze.getFreezableCount()) {
            IFreezable currentFreezable = freeze.getFreezable(freezableCounter);
            if (currentFreezable.getName() != null && currentFreezable.getName().equals(searchElementName)) {
                matchingFreezableFound = true;
                IDatatype foundType = currentFreezable.getType();
                if (foundType != null) {                    
                    elementTypeDescription = new ModelElementDescription(searchElementName, foundType.getName(),
                            getClassTypeFromFreezable(currentFreezable));
                }
            }
            freezableCounter++;
        }
    }
    
    /**
     * Returns the {@link ClassType} the given {@link IFreezable} is an instance of.
     *  
     * @param freezable the {@link IFreezable} for which the actual {@link ClassType} should be determined
     * @return the {@link ClassType} the given {@link IFreezable} is an instance of or <code>null</code> if
     * there is no {@link ClassType} for the actual type of the {@link IFreezable} defined.
     */
    private ClassType getClassTypeFromFreezable(IFreezable freezable) {
        ClassType type = null;
        if (freezable instanceof DecisionVariableDeclaration) {
            type = ClassType.DECISION_VARIABLE_DECLARATION;
        } else if (freezable instanceof Project) {
            type = ClassType.PROJECT;
        }
        return type;
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // TODO implement if required  
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
     // TODO implement if required
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO implement if required   
    }

    @Override
    public void visitComment(Comment comment) {
        // This is not needed for finding a model element's type
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO implement if required  
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO implement if required
    }

    @Override
    public void visitEnum(Enum eenum) {
        if (eenum.getName() != null && eenum.getName().equals(searchElementName)) {
            elementTypeDescription = new ModelElementDescription(searchElementName, toString(ClassType.ENUM),
                    ClassType.ENUM);
        }
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        if (eenum.getName() != null && eenum.getName().equals(searchElementName)) {
            elementTypeDescription = new ModelElementDescription(searchElementName, toString(ClassType.ENUM),
                    ClassType.ENUM);
        }
    }

    @Override
    public void visitCompound(Compound compound) {
        if (compound.getName() != null && compound.getName().equals(searchElementName)) {
            elementTypeDescription = new ModelElementDescription(searchElementName, toString(ClassType.COMPOUND),
                    ClassType.COMPOUND);
        } else {
            // If the compound is not the element of interest, maybe one of its nested elements
            int nestedElementCounter = 0;
            while (elementTypeDescription == null && nestedElementCounter < compound.getDeclarationCount()) {
                visitDecisionVariableDeclaration(compound.getDeclaration(nestedElementCounter));
                nestedElementCounter++;
            }
        }
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        if (datatype.getName() != null && datatype.getName().equals(searchElementName)) {
            elementTypeDescription = new ModelElementDescription(searchElementName, toString(ClassType.MAPPING),
                    ClassType.MAPPING);
        }
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO implement if required
    }

    @Override
    public void visitReference(Reference reference) {
        // TODO implement if required
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // TODO implement if required
    }

    @Override
    public void visitSet(Set set) {
        // TODO implement if required
    }

    /**
     * Returns the textual representation of a {@link ClassType}.
     * 
     * @param type the {@link ClassType} to be turned into a {@link String}
     * @return the textual representation of the given {@link ClassType}. May return an
     * empty {@link String} if the given {@link ClassType} cannot be resolved.
     */
    public static String toString(ClassType type) {
        String classTypeAsString;
        switch (type) {
        case DECISION_VARIABLE_DECLARATION:
            classTypeAsString = DECISION_VARIABLE_TYPE;
            break;
        case ENUM:
            classTypeAsString = ENUM_TYPE;
            break;
        case ORDERED_ENUM:
            classTypeAsString = ENUM_TYPE;
            break;
        case COMPOUND:
            classTypeAsString = COMPOUND_TYPE;
            break;
        case MAPPING:
            classTypeAsString = MAPPING_TYPE;
            break;
        default:
            classTypeAsString = "";
            break;
        }
        return classTypeAsString;
    }
}
