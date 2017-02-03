package de.uni_hildesheim.sse.ui.hyperlinking;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;

import de.uni_hildesheim.sse.ivml.BasicType;
import de.uni_hildesheim.sse.ivml.DerivedType;
import de.uni_hildesheim.sse.ivml.Project;
import de.uni_hildesheim.sse.ivml.ProjectContents;
import de.uni_hildesheim.sse.ivml.QualifiedName;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.TypedefCompound;
import de.uni_hildesheim.sse.ivml.TypedefEnum;
import de.uni_hildesheim.sse.ivml.TypedefMapping;
import de.uni_hildesheim.sse.ivml.VariableDeclaration;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;
import de.uni_hildesheim.sse.ivml.impl.VariabilityUnitImpl;
import de.uni_hildesheim.sse.translation.Utils;
import de.uni_hildesheim.sse.translation.Utils.SplitResult;
import de.uni_hildesheim.sse.ui.XtextEditor;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;
import net.ssehub.easy.dslCore.ui.hyperlinking.AbstractEcoreModelQuery;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.filter.ModelElementTypeFinder.ClassType;
import net.ssehub.easy.varModel.model.filter.ModelElementTypeFinder.ModelElementDescription;

public class EcoreModelQuery extends AbstractEcoreModelQuery<Project, ModelElementDescription> {
	
	/**
	 * The instance of this {@link EcoreModelQuery} for retrieving elements from an
	 * Ecore-model.
	 */
	public static final EcoreModelQuery INSTANCE = new EcoreModelQuery();
	
	/**
	 * Constructs an instance of this {@link EcoreModelQuery}.
	 */
	private EcoreModelQuery() {}

	/**
	 * Returns the {@link Project} in the given resource (IVML-file).
	 * 
	 * @param resource the {@link XtextResource} from which the {@link Project} should be retrieved
	 * @return the {@link Project} in the given resource (IVML-file). May return <code>null</code> if the
	 * given resource is <code>null</code>, cannot be parsed, or there is no {@link Project} in that file
	 */
	protected Project getProject(XtextResource resource) {
		Project ivmlProject = null;
		ICompositeNode rootNode = getRootNode(resource);
		if (rootNode != null) {
			EObject rootObject = rootNode.getSemanticElement();
			if (rootObject != null && rootObject instanceof VariabilityUnitImpl) {				
				VariabilityUnitImpl varUnitImpl = (VariabilityUnitImpl) rootObject;
				// Only one project per resource (file) allowed, thus, take the first element of the list
				if (varUnitImpl.getProjects() != null && !varUnitImpl.getProjects().isEmpty()) {
					ivmlProject = varUnitImpl.getProjects().get(0);
				}
			}
		}
		return ivmlProject;
	}
	
	/**
	 * Returns the {@link Project} of the Ecore-model represented by the given root node.
	 * 
	 * @param rootNode the {@link ICompositeNode} which is the root of the Ecore-model from which the
	 * {@link Project} should be retrieved
	 * @return the {@link Project} in the given resource (IVML-file). May return <code>null</code> if the
	 * given root node is <code>null</code>, or there is no {@link Project} in that file
	 */
	public Project getProject(ICompositeNode rootNode) {
		Project ivmlProject = null;
		if (rootNode != null && rootNode.getSemanticElement() != null && rootNode.getSemanticElement() instanceof VariabilityUnitImpl) {
			VariabilityUnitImpl varUnitImpl = (VariabilityUnitImpl) rootNode.getSemanticElement();
			// Only one project per resource (file) allowed, thus, take the first element of the list
			if (varUnitImpl.getProjects() != null && !varUnitImpl.getProjects().isEmpty()) {
				ivmlProject = varUnitImpl.getProjects().get(0);
			}
		}
		return ivmlProject;
	}
	
	/**
	 * Returns the {@link EObject} of the parse tree of the given {@link XtextEditor}'s resource that matches the element
	 * described by the given {@link ModelElementDescription}.
	 * 
	 * The search for this object will be performed in the Ecore-model of the given IVML-editor's resource only. This
	 * requires that it is ensured that the given editor displays an IVML-file which includes the desired element.
	 * 
	 * @param ivmlEditor the {@link XtextEditor} which displays the IVML-file in which the desired element should
	 * be found
	 * @param elementDescription the {@link ModelElementDescription} that describes the {@link VarModel} element that should
	 * be found in the parse tree of the given editor's resource
	 * @return the {@link EObject} that matches the element described by the given {@link ModelElementDescription}. May
	 * return <code>null</code> if the element could not be found
	 */
	public EObject getEcoreElement(CommonXtextEditor<?, Project> ivmlEditor, ModelElementDescription elementDescription) {
		EObject desiredElement = null;
//		System.out.println("Search for: " + elementDescription.getElementType() + " " + elementDescription.getElementName() + " of class " + elementDescription.getElementClass());
		if (ivmlEditor != null && notEmpty(elementDescription)) {
			XtextResource ivmlEditorResource = getXtextResource(ivmlEditor);
			Project targetProject = getProject(ivmlEditorResource);
			if (targetProject != null) {
				/*
				 * TODO If required, search in other project elements, like imports, conflicts, interfaces, or
				 * version statements.
				 * 
				 * However, most element should now be found
				 */
				desiredElement = processProjectContents(targetProject.getContents(), elementDescription);
			}
		}
		return desiredElement;
	}
	
	/**
	 * Returns an {@link EObject} if this object is part of the given {@link ProjectContents} and
	 * matches the element described by the given {@link ModelElementDescription}.
	 * 
	 * @param projectContents the {@link ProjectContents} in which to search for the element described by
	 * the given {@link ModelElementDescription}
	 * @param elementDescription the {@link ModelElementDescription} that describes the {@link EObject} to be
	 * found in the {@link ProjectContents}
	 * @return an {@link EObject} if this object is part of the given projects {@link ProjectContents} and
	 * matches the element described by the given {@link ModelElementDescription}; <code>null</code> otherwise.
	 */
	private EObject processProjectContents(ProjectContents projectContents, ModelElementDescription elementDescription) {
		EObject matchingObject = null;
		if (projectContents != null && notEmpty(projectContents.getElements())) {
			
			SplitResult splittedProjectContents = Utils.split(projectContents.getElements());
			ClassType searchElementClass = elementDescription.getElementClass();
			
			// Process variable declarations
			if (searchElementClass == ClassType.DECISION_VARIABLE_DECLARATION) {
				matchingObject = processDecisionVariableDeclarations(splittedProjectContents.getVarDecls(), elementDescription);
				/*
				 * If none of the top-level decision variable declarations matches the given element
				 * description although it must be a decision variable declaration, search in all
				 * compounds if a nested declaration may match.
				 */
				if (matchingObject == null) {
					List<Typedef> compoundsOnlyList = getSpecificTypeDefs(splittedProjectContents.getTypedefs(), ClassType.COMPOUND);
					if (notEmpty(compoundsOnlyList)) {						
						int compoundCounter = 0;
						while (matchingObject == null && compoundCounter < compoundsOnlyList.size()) {
							TypedefCompound currentCompound = compoundsOnlyList.get(compoundCounter).getTCompound();
							matchingObject = processCompoundElements(currentCompound, elementDescription);
							compoundCounter ++;
						}
					}
				}
			}
			
			// Process type definitions for the specific type of type definition
			if (isTypeDefClass(searchElementClass)) {
				matchingObject = processTypeDefinitions(splittedProjectContents.getTypedefs(), elementDescription, searchElementClass);
			}
		}
		return matchingObject;
	}
	
	/**
	 * Returns an {@link EObject} if this object is part of the given list of {@link VariableDeclaration}s and
	 * matches the element described by the given {@link ModelElementDescription}.
	 * 
	 * @param varDecls the list of {@link VariableDeclaration}s in which to search for the element described by
	 * the given {@link ModelElementDescription}
	 * @param elementDescription the {@link ModelElementDescription} that describes the {@link EObject} to be
	 * found in the list of {@link VariableDeclaration}s
	 * @return an {@link EObject} if this object is part of the given list of {@link VariableDeclaration}s and
	 * matches the element described by the given {@link ModelElementDescription}; <code>null</code> otherwise.
	 */
	private EObject processDecisionVariableDeclarations(List<VariableDeclaration> varDecls, ModelElementDescription elementDescription) {
		EObject matchingObject = null;
		if (notEmpty(varDecls)) {			
			int declsCounter = 0;
			while (matchingObject == null && declsCounter < varDecls.size()) {
				VariableDeclaration currentElement = varDecls.get(declsCounter);
				
				// Do not reorder the following comparisons; may lead to jumps to wrong declarations.
				
				// Compare with basic type and name of the current declaration.
				if(matchingObject == null && compareByBasicType(currentElement, elementDescription)) {
					matchingObject = currentElement;
				}
				/*
				 *  If it is not a basic type, compare with qualified name (e.g. compound-type name)
				 *  and name of the current declaration.
				 */
				if (matchingObject == null && compareByQualifiedName(currentElement, elementDescription)) {
					matchingObject = currentElement;
				}
				
				/*
				 *  If it is not a basic type or a qualified name, compare with derived types (e.g. setOf, sequenceOf,
				 *  or refTo/By or any combination of that) and name of the current declaration
				 */
				if (matchingObject == null && compareByDerivedType(currentElement, elementDescription)) {
					matchingObject = currentElement;
				}
				declsCounter++;
			}
		}
		return matchingObject;
	}
	
	/**
	 * Checks whether the given {@link ModelElementDescription} describes the given {@link VariableDeclaration}. This is
	 * done by checking the basic type and the name of the {@link VariableDeclaration} against the type and the name defined
	 * in the {@link ModelElementDescription}.
	 * 
	 * @param varDecl the {@link VariableDeclaration} that is checked against the {@link ModelElementDescription} by type and
	 * name
	 * @param elementDescription the {@link ModelElementDescription} that is checked against the {@link VariableDeclaration}
	 * by type and name
	 * @return <code>true</code> if the given {@link ModelElementDescription} describes the given {@link VariableDeclaration}.
	 * <code>False</code> otherwise.
	 */
	private boolean compareByBasicType(VariableDeclaration varDecl, ModelElementDescription elementDescription) {
		boolean varDeclMatchesElementDescription = false;
		Type currentElementType = varDecl.getType();
		if (currentElementType != null) {			
			BasicType currentElementBasicType = currentElementType.getType();
			if (currentElementBasicType != null && currentElementBasicType.getType().equals(elementDescription.getElementType())) {
				// If the type matches, check for the name of the current VariableDeclaration
				varDeclMatchesElementDescription = equalNames(varDecl, elementDescription);
			}
		}
		return varDeclMatchesElementDescription;
	}
	
	/**
	 * Checks whether the given {@link ModelElementDescription} describes the given {@link VariableDeclaration}. This is
	 * done by checking the qualified name of the {@link VariableDeclaration} against the type defined in the {@link ModelElementDescription}
	 * and by checking the name of the {@link VariableDeclaration} against the name defined in the {@link ModelElementDescription}.
	 * 
	 * @param varDecl the {@link VariableDeclaration} that is checked against the {@link ModelElementDescription} by qualified name (type) and
	 * name
	 * @param elementDescription the {@link ModelElementDescription} that is checked against the {@link VariableDeclaration}
	 * by qualified name (type) and name
	 * @return <code>true</code> if the given {@link ModelElementDescription} describes the given {@link VariableDeclaration}.
	 * <code>False</code> otherwise.
	 */
	private boolean compareByQualifiedName(VariableDeclaration varDecl, ModelElementDescription elementDescription) {
		boolean varDeclMatchesElementDescription = false;
		Type currentElementType = varDecl.getType();
		if (currentElementType != null) {			
			QualifiedName currentElementQName = currentElementType.getId();
			if (currentElementQName != null) {
				EList<String> qNameList =  currentElementQName.getQName();
				if (notEmpty(qNameList)) {
					int qNameCounter = 0;
					while (!varDeclMatchesElementDescription && qNameCounter < qNameList.size()) {
						String currentQName = qNameList.get(qNameCounter);
						if (currentQName.equals(elementDescription.getElementType())) {
							// If the QualifiedName matches the type of the elementDescription, check for the name
							varDeclMatchesElementDescription = equalNames(varDecl, elementDescription);
						}
						qNameCounter++;
					}
				}
			}
		}
		return varDeclMatchesElementDescription;
	}
	
	/**
	 * Checks whether the given {@link ModelElementDescription} describes the given {@link VariableDeclaration}. This is
	 * done by re-constructing the full type definition under the assumption that the given {@link VariableDeclaration} is constructed by
	 * a combination of (derived) types, e.g. <i>sequenceOf(refBy(MyInteger))</i>. This re-constructed type is than checked against the
	 * type of the given {@link ModelElementDescription}. If this type is equal and the name of the {@link VariableDeclaration} and in the
	 * {@link ModelElementDescription} are equal, both elements describe the same model element.
	 * 
	 * @param varDecl the {@link VariableDeclaration} that is checked against the {@link ModelElementDescription} by type and name
	 * @param elementDescription the {@link ModelElementDescription} that is checked against the {@link VariableDeclaration}
	 * by type and name
	 * @return <code>true</code> if the given {@link ModelElementDescription} describes the given {@link VariableDeclaration}.
	 * <code>False</code> otherwise.
	 */
	private boolean compareByDerivedType(VariableDeclaration varDecl, ModelElementDescription elementDescription) {
		boolean varDeclMatchesElementDescription = false;
		String fullTypeDefinition = constructFullTypeDefinition(varDecl.getType());
		if (fullTypeDefinition != null && fullTypeDefinition.equals(elementDescription.getElementType())) {
			// If the full type matches the type of the elementDescription, check for the name
			varDeclMatchesElementDescription = equalNames(varDecl, elementDescription);
		}
		return varDeclMatchesElementDescription;
	}
	
	/**
	 * Returns the full type definition based on the given {@link Type}.
	 * 
	 * This leads to re-construction of combined types like <i>sequenceOf(refBy(MyInteger))</i>.
	 * 
	 * @param type the {@link Type} from where to start re-constructing the full type definition by recursively checking
	 * the sub-types (any valid combination of derived types, qualified names, and basic types).
	 * @return the full type definition as a {@link String}. May return an empty String the given type is <code>null</code>.
	 */
	private String constructFullTypeDefinition(Type type) {
		String fullTypeDefinition = "";
		if (type != null) {
			if (type.getDerived() != null) {				
				DerivedType derivedType = type.getDerived();
				fullTypeDefinition = derivedType.getOp() + "(";
				fullTypeDefinition = fullTypeDefinition + constructFullTypeDefinition(derivedType.getType());
				fullTypeDefinition = fullTypeDefinition + ")";
			} else if (type.getType() != null) {
				fullTypeDefinition = fullTypeDefinition + type.getType().getType();
			} else if (type.getId() != null) {
				QualifiedName qName = type.getId();
				if (qName != null) {
					EList<String> qNameList =  qName.getQName();
					if (notEmpty(qNameList)) {
						int qNameCounter = 1;
						fullTypeDefinition = fullTypeDefinition + qNameList.get(0);
						while (qNameCounter < qNameList.size()) {
							fullTypeDefinition = fullTypeDefinition + ", " + qNameList.get(qNameCounter);
							qNameCounter++;
						}
					}
				}
			}
		}
		return fullTypeDefinition;
	}
	
	
	/**
	 * Checks whether the name of the given {@link VariableDeclaration} equals the name of the given {@ ModelElementDescription}.
	 * This is done by iterating over all variable declaration parts of the {@link VariableDeclaration} and checking whether one of
	 * these parts match the name of the {@ ModelElementDescription}.
	 * 
	 * @param varDecl the {@link VariableDeclaration} of which all variable declaration parts are checked against the name defined
	 * by the given {@ ModelElementDescription}
	 * @param elementDescription the {@link ModelElementDescription} which name is checked against all variable declaration parts
	 * of the given {@link VariableDeclaration} 
	 * @return <code>true</code> if the name defined in the given {@link ModelElementDescription} matches one variable declaration
	 * part of the given {@link VariableDeclaration}. <code>False</code> otherwise.
	 */
	private boolean equalNames(VariableDeclaration varDecl, ModelElementDescription elementDescription) {
		boolean namesEqual = false;
		if (varDecl != null) {			
			EList<VariableDeclarationPart> varDeclParts = varDecl.getDecls();
			if (notEmpty(varDeclParts)) {
				int varDeclPartCounter = 0;
				while (!namesEqual && varDeclPartCounter < varDeclParts.size()) {
					VariableDeclarationPart currentVarDeclPart = varDeclParts.get(varDeclPartCounter);
					if (currentVarDeclPart.getName().equals(elementDescription.getElementName())) {
						namesEqual = true;
					}
					varDeclPartCounter++;
				}
			}
		}
		return namesEqual;
	}
	
	/**
	 * Returns an {@link EObject} if this object is part of the given list of {@link Typedef}s and
	 * matches the element described by the given {@link ModelElementDescription}.
	 * 
	 * This method compares a filtered subset of the given list of {@link Typedef}. Which specific type of
	 * {@link Typedef} will be used depends on the given {@link ClassType} <i>searchType</i>.
	 * 
	 *  Currently supported types are: <code>Compound</code>, <code>Enum</code> (which will also include <code>OrderedEnum</code>,
	 *  and <code>Mapping</code>.
	 * 
	 * <b>Note that</b> this kind of comparison requires to ensure that the given {@link ModelElementDescription} describes
	 * a {@link Typedef}.
	 * 
	 * @param typeDefs the full list of {@link Typedef}s in which to search for the element described by the given
	 * {@link ModelElementDescription}. Filtering this full list will be done by this method in accordance to the
	 * type defined by <i>searchType</i>
	 * @param elementDescription the {@link ModelElementDescription} that describes the element for which the
	 * {@link EObject} should be found in the list of {@link Typedef}s
	 * @param searchType the specific type of {@link Typedef} to look for: one of {@link ClassType}
	 * @return an {@link EObject} if this object is part of the given list of {@link Typedef}s and
	 * matches the element described by the given {@link ModelElementDescription}
	 * <code>null</code> otherwise.
	 */
	private EObject processTypeDefinitions(List<Typedef> typeDefs, ModelElementDescription elementDescription, ClassType searchType) {
		EObject matchingObject = null;
		List<Typedef> filteredTypeDefs = getSpecificTypeDefs(typeDefs, searchType);
		if (notEmpty(filteredTypeDefs)) {
			int typeDefCounter = 0;
			while (matchingObject == null && typeDefCounter < filteredTypeDefs.size()) {
				switch (searchType) {
				case COMPOUND:
					TypedefCompound currentCompoundDef = filteredTypeDefs.get(typeDefCounter).getTCompound();
					if (currentCompoundDef.getName().equals(elementDescription.getElementName())) {
						matchingObject = currentCompoundDef;
					}
					break;
				case ENUM:
					/*
					 *  We do not differentiate between ordered or unordered enums here, thus,
					 *  the list returned will include both type definitions.
					 */
					TypedefEnum currentEnumDef = filteredTypeDefs.get(typeDefCounter).getTEnum();
					if (currentEnumDef.getName().equals(elementDescription.getElementName())) {
						matchingObject = currentEnumDef;
					}
					break;
				case MAPPING:
					TypedefMapping currentMappingDef = filteredTypeDefs.get(typeDefCounter).getTMapping();
					if (currentMappingDef.getNewType().equals(elementDescription.getElementName())) {
						matchingObject = currentMappingDef;
					}
					break;
			    default:
					// Should never be reached
					break;
				}
				typeDefCounter++;
			}
		}
		return matchingObject;
	}
	
	private EObject processCompoundElements(TypedefCompound compound, ModelElementDescription elementDescription) {
		EObject matchingObject = null;
		if (notEmpty(compound.getElements())) {
			SplitResult splittedNestedElements = Utils.split(compound.getElements());
			if (splittedNestedElements != null) {
				List<VariableDeclaration> nestedDeclarations = splittedNestedElements.getVarDecls();
				matchingObject = processDecisionVariableDeclarations(nestedDeclarations, elementDescription);
			}
		}
		return matchingObject;
	}
	
	/**
	 * Checks whether the given {@link ClassType} describes a type definition in IVML, e.g.:
	 * 
	 * <i>Enum</i>
	 * <i>OrderedEnum</i>
	 * <i>Compound</i>
	 * <i>Mapping</i>
	 * 
	 * 
	 * @param type the {@link ClassType} to check whether this is a class used in IVML to define
	 * a new type 
	 * @return <code>true</code> if the given {@link ClassType} matches one of the types listed above.
	 * <code>False</code> otherwise. 
	 */
	private boolean isTypeDefClass(ClassType type) {
		boolean isTypeDefClass = false;
		if (type == ClassType.ENUM
				|| type == ClassType.ORDERED_ENUM
				|| type == ClassType.COMPOUND
				|| type == ClassType.MAPPING) {
			isTypeDefClass = true;
		}
		return isTypeDefClass;
	}
	
	/**
	 * Creates a sub-list of the given list of {@link Typedef}s in which only type definitions are included that provide
	 * the specific type definition described by the given {@link ClassType}.
	 * 
	 * @param typeDefs the list of {@link Typedef}s from which a subset of specific type definitions should be returned
	 * @param specificType the specific type of {@link Typedef}s to be included in a new list.
	 * @return a sub-list of the given list of {@link Typedef}s in which only type definitions are included that provide
	 * the specific type definition described by the given {@link ClassType}. May return <code>null</code> if the given list
	 * of type definitions is <code>null</code> or empty. May return an empty list if the given list does not contain
	 * type definitions of the desired specific type.
	 */
	private List<Typedef> getSpecificTypeDefs(List<Typedef> typeDefs, ClassType specificType) {
		List<Typedef> result = null;
		if (notEmpty(typeDefs)) {
			result = new ArrayList<Typedef>();
			for (Typedef def : typeDefs) {
				if (specificType == ClassType.COMPOUND && def.getTCompound() != null) {
					result.add(def);
				} else if (specificType == ClassType.ENUM && def.getTEnum() != null) {
					result.add(def);
				} else if (specificType == ClassType.MAPPING && def.getTMapping() != null) {
					result.add(def);
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Checks whether the given {@link ModelElementDescription} is not <code>null</code> and all information
	 * is available (the nested {@link String}s are not <code>null</code> or empty).
	 * 
	 * @param elementDescription the {@link ModelElementDescription} to check
	 * @return <code>true</code> if the given {@link ModelElementDescription} is not <code>null</code> and all information
	 * is available. <code>False</code> otherwise.
	 */
	private boolean notEmpty(ModelElementDescription elementDescription) {
		return elementDescription != null
				&& notEmpty(elementDescription.getElementName())
				&& notEmpty(elementDescription.getElementType())
				&& elementDescription.getElementClass() != null;
	}
	

    @Override
    public String getName(Project project) {
        return project.getName();
    }
    
}
