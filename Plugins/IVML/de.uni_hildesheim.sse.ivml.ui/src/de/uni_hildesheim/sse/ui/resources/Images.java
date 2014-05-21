package de.uni_hildesheim.sse.ui.resources;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.ivml.Project;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;

public class Images {

	public static final String NAME_COMMENT = "comment.jpg";
	public static final String NAME_IDENTIFIER = "identifier.jpg";
	public static final String NAME_VARIABLE = "decision_variable.gif";
	public static final String NAME_ATTRIBUTE = "attribute.jpg";
	public static final String NAME_EVAL = "eval.jpg";
	public static final String NAME_FREEZE = "freeze.jpg";
	public static final String NAME_FREEZE_BUT = "freeze_but.jpg";
	public static final String NAME_EXPORT = "export.jpg";
	public static final String NAME_INTERFACE = "interface.jpg";
	public static final String NAME_CONSTRAINT = "constraint.jpg";
	public static final String NAME_TYPE = "type.jpg";
	public static final String NAME_CONFLICTS = "conflicts.jpg";
	public static final String NAME_IMPORT = "import.jpg";
	public static final String NAME_IMPORT_ELEMENT = "import_elem.jpg";
	public static final String NAME_VERSION = "version.jpg";
	public static final String NAME_ENUM_LITERAL = "enumLiteral.jpg";
	public static final String NAME_TYPEDEF = "typedef.jpg";
	public static final String NAME_COMPOUND = "compound.jpg";
	public static final String NAME_ENUM = "enum.jpg";
	public static final String NAME_PROJECT = "project.jpg";
	public static final String NAME_PROJECTCONTENTS = "projectContent.jpg";
	public static final String NAME_OPERATION = "operation.jpg";
	public static final String NAME_OPERATIONDEFINITION = "operationDefinition.jpg";
	public static final String NAME_CONSTANT = "constant.jpg";
	public static final String NAME_REFINEMENT = "refinement.jpg";
	public static final String NAME_DERIVATION = "derivation.jpg";
	public static final String NAME_ATTACHMENT = "attachment.jpg";
	public static final String NAME_DSL = "dsl.jpg";

	private static final Map<Class<?>, String> MAPPING = new HashMap<Class<?>, String>();

	static {
		MAPPING.put(Operation.class, NAME_OPERATION);
		MAPPING.put(Attribute.class, NAME_ATTRIBUTE);
		MAPPING.put(Project.class, NAME_PROJECT);
		MAPPING.put(DecisionVariableDeclaration.class, NAME_VARIABLE);
		MAPPING.put(Compound.class, NAME_COMPOUND);
		MAPPING.put(de.uni_hildesheim.sse.model.varModel.datatypes.Enum.class, Images.NAME_ENUM);
		MAPPING.put(OrderedEnum.class, NAME_ENUM);
		MAPPING.put(EnumLiteral.class, NAME_ENUM_LITERAL);
		MAPPING.put(ProjectInterface.class, NAME_INTERFACE);
		MAPPING.put(DerivedDatatype.class, NAME_TYPEDEF);
		MAPPING.put(OperationDefinition.class, NAME_OPERATIONDEFINITION);
	}
	
	public static String get(Class<?> key) {
		return MAPPING.get(key);
	}

}