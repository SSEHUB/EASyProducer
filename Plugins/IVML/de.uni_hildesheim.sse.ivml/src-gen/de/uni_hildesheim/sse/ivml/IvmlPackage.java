/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.ivml.IvmlFactory
 * @model kind="package"
 * @generated
 */
public interface IvmlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "ivml";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.uni_hildesheim.de/sse/Ivml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ivml";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IvmlPackage eINSTANCE = de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl.init();

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.VariabilityUnitImpl <em>Variability Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.VariabilityUnitImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVariabilityUnit()
   * @generated
   */
  int VARIABILITY_UNIT = 0;

  /**
   * The feature id for the '<em><b>Projects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABILITY_UNIT__PROJECTS = 0;

  /**
   * The number of structural features of the '<em>Variability Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABILITY_UNIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ProjectImpl <em>Project</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ProjectImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getProject()
   * @generated
   */
  int PROJECT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__NAME = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__VERSION = 1;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__IMPORTS = 2;

  /**
   * The feature id for the '<em><b>Conflicts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__CONFLICTS = 3;

  /**
   * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__INTERFACES = 4;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__CONTENTS = 5;

  /**
   * The number of structural features of the '<em>Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ProjectContentsImpl <em>Project Contents</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ProjectContentsImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getProjectContents()
   * @generated
   */
  int PROJECT_CONTENTS = 2;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT_CONTENTS__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Project Contents</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT_CONTENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefImpl <em>Typedef</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypedefImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedef()
   * @generated
   */
  int TYPEDEF = 3;

  /**
   * The feature id for the '<em><b>TEnum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF__TENUM = 0;

  /**
   * The feature id for the '<em><b>TCompound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF__TCOMPOUND = 1;

  /**
   * The feature id for the '<em><b>TMapping</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF__TMAPPING = 2;

  /**
   * The number of structural features of the '<em>Typedef</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefEnumImpl <em>Typedef Enum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypedefEnumImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefEnum()
   * @generated
   */
  int TYPEDEF_ENUM = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM__NAME = 0;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM__LITERALS = 1;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM__CONSTRAINT = 2;

  /**
   * The number of structural features of the '<em>Typedef Enum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefEnumLiteralImpl <em>Typedef Enum Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypedefEnumLiteralImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefEnumLiteral()
   * @generated
   */
  int TYPEDEF_ENUM_LITERAL = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM_LITERAL__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM_LITERAL__VALUE = 1;

  /**
   * The number of structural features of the '<em>Typedef Enum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_ENUM_LITERAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefCompoundImpl <em>Typedef Compound</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypedefCompoundImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefCompound()
   * @generated
   */
  int TYPEDEF_COMPOUND = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_COMPOUND__NAME = 0;

  /**
   * The feature id for the '<em><b>Super</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_COMPOUND__SUPER = 1;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_COMPOUND__ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>Typedef Compound</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_COMPOUND_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AttrAssignmentImpl <em>Attr Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AttrAssignmentImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAttrAssignment()
   * @generated
   */
  int ATTR_ASSIGNMENT = 7;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_ASSIGNMENT__PARTS = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_ASSIGNMENT__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>Attr Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AttrAssignmentPartImpl <em>Attr Assignment Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AttrAssignmentPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAttrAssignmentPart()
   * @generated
   */
  int ATTR_ASSIGNMENT_PART = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_ASSIGNMENT_PART__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_ASSIGNMENT_PART__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attr Assignment Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_ASSIGNMENT_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefMappingImpl <em>Typedef Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypedefMappingImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefMapping()
   * @generated
   */
  int TYPEDEF_MAPPING = 9;

  /**
   * The feature id for the '<em><b>New Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_MAPPING__NEW_TYPE = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_MAPPING__TYPE = 1;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_MAPPING__CONSTRAINT = 2;

  /**
   * The number of structural features of the '<em>Typedef Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefConstraintImpl <em>Typedef Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypedefConstraintImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefConstraint()
   * @generated
   */
  int TYPEDEF_CONSTRAINT = 10;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_CONSTRAINT__EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>Typedef Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_CONSTRAINT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.VariableDeclarationImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVariableDeclaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 11;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__DECLS = 1;

  /**
   * The number of structural features of the '<em>Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.VariableDeclarationPartImpl <em>Variable Declaration Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.VariableDeclarationPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVariableDeclarationPart()
   * @generated
   */
  int VARIABLE_DECLARATION_PART = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_PART__NAME = 0;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_PART__DEFAULT = 1;

  /**
   * The number of structural features of the '<em>Variable Declaration Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.BasicTypeImpl <em>Basic Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.BasicTypeImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getBasicType()
   * @generated
   */
  int BASIC_TYPE = 13;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE__TYPE = 0;

  /**
   * The number of structural features of the '<em>Basic Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.TypeImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getType()
   * @generated
   */
  int TYPE = 14;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__ID = 1;

  /**
   * The feature id for the '<em><b>Derived</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__DERIVED = 2;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.NumValueImpl <em>Num Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.NumValueImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getNumValue()
   * @generated
   */
  int NUM_VALUE = 15;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_VALUE__VAL = 0;

  /**
   * The number of structural features of the '<em>Num Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.QualifiedNameImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getQualifiedName()
   * @generated
   */
  int QUALIFIED_NAME = 16;

  /**
   * The feature id for the '<em><b>QName</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__QNAME = 0;

  /**
   * The number of structural features of the '<em>Qualified Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AccessNameImpl <em>Access Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AccessNameImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAccessName()
   * @generated
   */
  int ACCESS_NAME = 17;

  /**
   * The feature id for the '<em><b>AName</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESS_NAME__ANAME = 0;

  /**
   * The number of structural features of the '<em>Access Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESS_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ValueImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getValue()
   * @generated
   */
  int VALUE = 18;

  /**
   * The feature id for the '<em><b>NValue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__NVALUE = 0;

  /**
   * The feature id for the '<em><b>SValue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__SVALUE = 1;

  /**
   * The feature id for the '<em><b>QValue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__QVALUE = 2;

  /**
   * The feature id for the '<em><b>BValue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__BVALUE = 3;

  /**
   * The feature id for the '<em><b>Null Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__NULL_VALUE = 4;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.DerivedTypeImpl <em>Derived Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.DerivedTypeImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDerivedType()
   * @generated
   */
  int DERIVED_TYPE = 19;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_TYPE__OP = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Derived Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.DslContextImpl <em>Dsl Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.DslContextImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDslContext()
   * @generated
   */
  int DSL_CONTEXT = 20;

  /**
   * The feature id for the '<em><b>Stop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DSL_CONTEXT__STOP = 0;

  /**
   * The feature id for the '<em><b>Escape</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DSL_CONTEXT__ESCAPE = 1;

  /**
   * The feature id for the '<em><b>Command</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DSL_CONTEXT__COMMAND = 2;

  /**
   * The feature id for the '<em><b>Dsl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DSL_CONTEXT__DSL = 3;

  /**
   * The number of structural features of the '<em>Dsl Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DSL_CONTEXT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AttributeToImpl <em>Attribute To</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AttributeToImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAttributeTo()
   * @generated
   */
  int ATTRIBUTE_TO = 21;

  /**
   * The feature id for the '<em><b>Attribute Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_TO__ATTRIBUTE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Attribute Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_TO__ATTRIBUTE_DECL = 1;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_TO__NAMES = 2;

  /**
   * The number of structural features of the '<em>Attribute To</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_TO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl <em>Freeze</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.FreezeImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreeze()
   * @generated
   */
  int FREEZE = 22;

  /**
   * The feature id for the '<em><b>Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE__NAMES = 0;

  /**
   * The feature id for the '<em><b>But</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE__BUT = 1;

  /**
   * The number of structural features of the '<em>Freeze</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeStatementImpl <em>Freeze Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.FreezeStatementImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreezeStatement()
   * @generated
   */
  int FREEZE_STATEMENT = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_STATEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_STATEMENT__ACCESS = 1;

  /**
   * The number of structural features of the '<em>Freeze Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_STATEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeButListImpl <em>Freeze But List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.FreezeButListImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreezeButList()
   * @generated
   */
  int FREEZE_BUT_LIST = 24;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_BUT_LIST__LIST = 0;

  /**
   * The number of structural features of the '<em>Freeze But List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_BUT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl <em>Freeze But Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreezeButExpression()
   * @generated
   */
  int FREEZE_BUT_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_BUT_EXPRESSION__NAME = 0;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_BUT_EXPRESSION__ACCESS = 1;

  /**
   * The feature id for the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_BUT_EXPRESSION__WILDCARD = 2;

  /**
   * The number of structural features of the '<em>Freeze But Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FREEZE_BUT_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.EvalImpl <em>Eval</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.EvalImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getEval()
   * @generated
   */
  int EVAL = 26;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL__NESTED = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL__STATEMENTS = 1;

  /**
   * The number of structural features of the '<em>Eval</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.InterfaceDeclarationImpl <em>Interface Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.InterfaceDeclarationImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getInterfaceDeclaration()
   * @generated
   */
  int INTERFACE_DECLARATION = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION__EXPORTS = 1;

  /**
   * The number of structural features of the '<em>Interface Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ExportImpl <em>Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ExportImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExport()
   * @generated
   */
  int EXPORT = 28;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT__NAMES = 0;

  /**
   * The number of structural features of the '<em>Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ImportStmtImpl <em>Import Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ImportStmtImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getImportStmt()
   * @generated
   */
  int IMPORT_STMT = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STMT__NAME = 0;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STMT__INTERFACE = 1;

  /**
   * The feature id for the '<em><b>Versions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STMT__VERSIONS = 2;

  /**
   * The number of structural features of the '<em>Import Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STMT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ConflictStmtImpl <em>Conflict Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ConflictStmtImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getConflictStmt()
   * @generated
   */
  int CONFLICT_STMT = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFLICT_STMT__NAME = 0;

  /**
   * The feature id for the '<em><b>Conflicts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFLICT_STMT__CONFLICTS = 1;

  /**
   * The number of structural features of the '<em>Conflict Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFLICT_STMT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.VersionedIdImpl <em>Versioned Id</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.VersionedIdImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVersionedId()
   * @generated
   */
  int VERSIONED_ID = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSIONED_ID__NAME = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSIONED_ID__OP = 1;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSIONED_ID__VERSION = 2;

  /**
   * The number of structural features of the '<em>Versioned Id</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSIONED_ID_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.VersionStmtImpl <em>Version Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.VersionStmtImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVersionStmt()
   * @generated
   */
  int VERSION_STMT = 32;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_STMT__VERSION = 0;

  /**
   * The number of structural features of the '<em>Version Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_STMT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl <em>Op Def Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getOpDefStatement()
   * @generated
   */
  int OP_DEF_STATEMENT = 33;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_STATEMENT__RESULT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_STATEMENT__ID = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_STATEMENT__PARAM = 2;

  /**
   * The feature id for the '<em><b>Impl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_STATEMENT__IMPL = 3;

  /**
   * The number of structural features of the '<em>Op Def Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_STATEMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.OpDefParameterListImpl <em>Op Def Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.OpDefParameterListImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getOpDefParameterList()
   * @generated
   */
  int OP_DEF_PARAMETER_LIST = 34;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_PARAMETER_LIST__LIST = 0;

  /**
   * The number of structural features of the '<em>Op Def Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.OpDefParameterImpl <em>Op Def Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.OpDefParameterImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getOpDefParameter()
   * @generated
   */
  int OP_DEF_PARAMETER = 35;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_PARAMETER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_PARAMETER__ID = 1;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_PARAMETER__VAL = 2;

  /**
   * The number of structural features of the '<em>Op Def Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DEF_PARAMETER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ExpressionStatementImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 36;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPR = 0;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 37;

  /**
   * The feature id for the '<em><b>Let</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__LET = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPR = 1;

  /**
   * The feature id for the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__COLLECTION = 2;

  /**
   * The feature id for the '<em><b>Dsl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__DSL = 3;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl <em>Let Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLetExpression()
   * @generated
   */
  int LET_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION__NAME = 1;

  /**
   * The feature id for the '<em><b>Value Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION__VALUE_EXPR = 2;

  /**
   * The feature id for the '<em><b>Sub Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION__SUB_EXPR = 3;

  /**
   * The number of structural features of the '<em>Let Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAssignmentExpression()
   * @generated
   */
  int ASSIGNMENT_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Assignment Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionPartImpl <em>Assignment Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAssignmentExpressionPart()
   * @generated
   */
  int ASSIGNMENT_EXPRESSION_PART = 40;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_PART__EX = 1;

  /**
   * The feature id for the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_PART__COLLECTION = 2;

  /**
   * The number of structural features of the '<em>Assignment Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_PART_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionImpl <em>Implication Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getImplicationExpression()
   * @generated
   */
  int IMPLICATION_EXPRESSION = 41;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Implication Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionPartImpl <em>Implication Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getImplicationExpressionPart()
   * @generated
   */
  int IMPLICATION_EXPRESSION_PART = 42;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Implication Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.LogicalExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLogicalExpression()
   * @generated
   */
  int LOGICAL_EXPRESSION = 43;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.LogicalExpressionPartImpl <em>Logical Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.LogicalExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLogicalExpressionPart()
   * @generated
   */
  int LOGICAL_EXPRESSION_PART = 44;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Logical Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.EqualityExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 45;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl <em>Equality Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getEqualityExpressionPart()
   * @generated
   */
  int EQUALITY_EXPRESSION_PART = 46;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART__EX = 1;

  /**
   * The feature id for the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART__COLLECTION = 2;

  /**
   * The number of structural features of the '<em>Equality Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.RelationalExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 47;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.RelationalExpressionPartImpl <em>Relational Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.RelationalExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getRelationalExpressionPart()
   * @generated
   */
  int RELATIONAL_EXPRESSION_PART = 48;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Relational Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 49;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionPartImpl <em>Additive Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAdditiveExpressionPart()
   * @generated
   */
  int ADDITIVE_EXPRESSION_PART = 50;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Additive Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 51;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionPartImpl <em>Multiplicative Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionPartImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getMultiplicativeExpressionPart()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION_PART = 52;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART__EXPR = 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.UnaryExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 53;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OP = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPR = 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 54;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__CALL = 0;

  /**
   * The feature id for the '<em><b>FCalls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__FCALLS = 1;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__ACCESS = 2;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__LEFT = 3;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.CallImpl <em>Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.CallImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getCall()
   * @generated
   */
  int CALL = 55;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__CALL = 0;

  /**
   * The feature id for the '<em><b>Set Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__SET_OP = 1;

  /**
   * The feature id for the '<em><b>Array Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__ARRAY_EX = 2;

  /**
   * The number of structural features of the '<em>Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.FeatureCallImpl <em>Feature Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.FeatureCallImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFeatureCall()
   * @generated
   */
  int FEATURE_CALL = 56;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__NAME = 0;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__PARAM = 1;

  /**
   * The number of structural features of the '<em>Feature Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.SetOpImpl <em>Set Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.SetOpImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getSetOp()
   * @generated
   */
  int SET_OP = 57;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_OP__NAME = 0;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_OP__DECL = 1;

  /**
   * The feature id for the '<em><b>Decl Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_OP__DECL_EX = 2;

  /**
   * The number of structural features of the '<em>Set Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_OP_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.DeclaratorImpl <em>Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.DeclaratorImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDeclarator()
   * @generated
   */
  int DECLARATOR = 58;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__DECL = 0;

  /**
   * The number of structural features of the '<em>Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.DeclarationImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 59;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__ID = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__INIT = 2;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ActualParameterListImpl <em>Actual Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ActualParameterListImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getActualParameterList()
   * @generated
   */
  int ACTUAL_PARAMETER_LIST = 60;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PARAMETER_LIST__PARAM = 0;

  /**
   * The number of structural features of the '<em>Actual Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl <em>Expression Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionAccess()
   * @generated
   */
  int EXPRESSION_ACCESS = 61;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ACCESS__NAME = 0;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ACCESS__CALLS = 1;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ACCESS__ACCESS = 2;

  /**
   * The number of structural features of the '<em>Expression Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ACCESS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.PrimaryExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 62;

  /**
   * The feature id for the '<em><b>Lit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__LIT = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EX = 1;

  /**
   * The feature id for the '<em><b>If Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__IF_EX = 2;

  /**
   * The feature id for the '<em><b>Ref Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__REF_NAME = 3;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__CALLS = 4;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__ACCESS = 5;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.CollectionInitializerImpl <em>Collection Initializer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.CollectionInitializerImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getCollectionInitializer()
   * @generated
   */
  int COLLECTION_INITIALIZER = 63;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_INITIALIZER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_INITIALIZER__INIT = 1;

  /**
   * The number of structural features of the '<em>Collection Initializer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_INITIALIZER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListOrRangeImpl <em>Expression List Or Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ExpressionListOrRangeImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionListOrRange()
   * @generated
   */
  int EXPRESSION_LIST_OR_RANGE = 64;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_OR_RANGE__LIST = 0;

  /**
   * The number of structural features of the '<em>Expression List Or Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_OR_RANGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl <em>Expression List Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionListEntry()
   * @generated
   */
  int EXPRESSION_LIST_ENTRY = 65;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_ENTRY__NAME = 0;

  /**
   * The feature id for the '<em><b>Attrib</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_ENTRY__ATTRIB = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_ENTRY__VALUE = 2;

  /**
   * The feature id for the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_ENTRY__COLLECTION = 3;

  /**
   * The number of structural features of the '<em>Expression List Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_ENTRY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.LiteralImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 66;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__VAL = 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl <em>If Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl
   * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getIfExpression()
   * @generated
   */
  int IF_EXPRESSION = 67;

  /**
   * The feature id for the '<em><b>If Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__IF_EX = 0;

  /**
   * The feature id for the '<em><b>Then Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__THEN_EX = 1;

  /**
   * The feature id for the '<em><b>Else Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__ELSE_EX = 2;

  /**
   * The number of structural features of the '<em>If Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.VariabilityUnit <em>Variability Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variability Unit</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariabilityUnit
   * @generated
   */
  EClass getVariabilityUnit();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.VariabilityUnit#getProjects <em>Projects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Projects</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariabilityUnit#getProjects()
   * @see #getVariabilityUnit()
   * @generated
   */
  EReference getVariabilityUnit_Projects();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Project <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Project</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project
   * @generated
   */
  EClass getProject();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.Project#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project#getName()
   * @see #getProject()
   * @generated
   */
  EAttribute getProject_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Project#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project#getVersion()
   * @see #getProject()
   * @generated
   */
  EReference getProject_Version();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Project#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project#getImports()
   * @see #getProject()
   * @generated
   */
  EReference getProject_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Project#getConflicts <em>Conflicts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conflicts</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project#getConflicts()
   * @see #getProject()
   * @generated
   */
  EReference getProject_Conflicts();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Project#getInterfaces <em>Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interfaces</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project#getInterfaces()
   * @see #getProject()
   * @generated
   */
  EReference getProject_Interfaces();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Project#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Contents</em>'.
   * @see de.uni_hildesheim.sse.ivml.Project#getContents()
   * @see #getProject()
   * @generated
   */
  EReference getProject_Contents();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ProjectContents <em>Project Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Project Contents</em>'.
   * @see de.uni_hildesheim.sse.ivml.ProjectContents
   * @generated
   */
  EClass getProjectContents();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ProjectContents#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.uni_hildesheim.sse.ivml.ProjectContents#getElements()
   * @see #getProjectContents()
   * @generated
   */
  EReference getProjectContents_Elements();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Typedef <em>Typedef</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef</em>'.
   * @see de.uni_hildesheim.sse.ivml.Typedef
   * @generated
   */
  EClass getTypedef();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Typedef#getTEnum <em>TEnum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>TEnum</em>'.
   * @see de.uni_hildesheim.sse.ivml.Typedef#getTEnum()
   * @see #getTypedef()
   * @generated
   */
  EReference getTypedef_TEnum();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Typedef#getTCompound <em>TCompound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>TCompound</em>'.
   * @see de.uni_hildesheim.sse.ivml.Typedef#getTCompound()
   * @see #getTypedef()
   * @generated
   */
  EReference getTypedef_TCompound();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Typedef#getTMapping <em>TMapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>TMapping</em>'.
   * @see de.uni_hildesheim.sse.ivml.Typedef#getTMapping()
   * @see #getTypedef()
   * @generated
   */
  EReference getTypedef_TMapping();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.TypedefEnum <em>Typedef Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Enum</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnum
   * @generated
   */
  EClass getTypedefEnum();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnum#getName()
   * @see #getTypedefEnum()
   * @generated
   */
  EAttribute getTypedefEnum_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnum#getLiterals()
   * @see #getTypedefEnum()
   * @generated
   */
  EReference getTypedefEnum_Literals();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnum#getConstraint()
   * @see #getTypedefEnum()
   * @generated
   */
  EReference getTypedefEnum_Constraint();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.TypedefEnumLiteral <em>Typedef Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Enum Literal</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnumLiteral
   * @generated
   */
  EClass getTypedefEnumLiteral();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.TypedefEnumLiteral#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnumLiteral#getName()
   * @see #getTypedefEnumLiteral()
   * @generated
   */
  EAttribute getTypedefEnumLiteral_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.TypedefEnumLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnumLiteral#getValue()
   * @see #getTypedefEnumLiteral()
   * @generated
   */
  EReference getTypedefEnumLiteral_Value();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.TypedefCompound <em>Typedef Compound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Compound</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefCompound
   * @generated
   */
  EClass getTypedefCompound();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.TypedefCompound#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefCompound#getName()
   * @see #getTypedefCompound()
   * @generated
   */
  EAttribute getTypedefCompound_Name();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.TypedefCompound#getSuper <em>Super</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Super</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefCompound#getSuper()
   * @see #getTypedefCompound()
   * @generated
   */
  EAttribute getTypedefCompound_Super();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.TypedefCompound#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefCompound#getElements()
   * @see #getTypedefCompound()
   * @generated
   */
  EReference getTypedefCompound_Elements();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AttrAssignment <em>Attr Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Assignment</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignment
   * @generated
   */
  EClass getAttrAssignment();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.AttrAssignment#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignment#getParts()
   * @see #getAttrAssignment()
   * @generated
   */
  EReference getAttrAssignment_Parts();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.AttrAssignment#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignment#getElements()
   * @see #getAttrAssignment()
   * @generated
   */
  EReference getAttrAssignment_Elements();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AttrAssignmentPart <em>Attr Assignment Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Assignment Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignmentPart
   * @generated
   */
  EClass getAttrAssignmentPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.AttrAssignmentPart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignmentPart#getName()
   * @see #getAttrAssignmentPart()
   * @generated
   */
  EAttribute getAttrAssignmentPart_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AttrAssignmentPart#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignmentPart#getValue()
   * @see #getAttrAssignmentPart()
   * @generated
   */
  EReference getAttrAssignmentPart_Value();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.TypedefMapping <em>Typedef Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Mapping</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefMapping
   * @generated
   */
  EClass getTypedefMapping();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getNewType <em>New Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>New Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefMapping#getNewType()
   * @see #getTypedefMapping()
   * @generated
   */
  EAttribute getTypedefMapping_NewType();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefMapping#getType()
   * @see #getTypedefMapping()
   * @generated
   */
  EReference getTypedefMapping_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefMapping#getConstraint()
   * @see #getTypedefMapping()
   * @generated
   */
  EReference getTypedefMapping_Constraint();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.TypedefConstraint <em>Typedef Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef Constraint</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefConstraint
   * @generated
   */
  EClass getTypedefConstraint();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.TypedefConstraint#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see de.uni_hildesheim.sse.ivml.TypedefConstraint#getExpressions()
   * @see #getTypedefConstraint()
   * @generated
   */
  EReference getTypedefConstraint_Expressions();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclaration
   * @generated
   */
  EClass getVariableDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.VariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclaration#getType()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Type();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.VariableDeclaration#getDecls <em>Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decls</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclaration#getDecls()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Decls();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.VariableDeclarationPart <em>Variable Declaration Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclarationPart
   * @generated
   */
  EClass getVariableDeclarationPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.VariableDeclarationPart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclarationPart#getName()
   * @see #getVariableDeclarationPart()
   * @generated
   */
  EAttribute getVariableDeclarationPart_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.VariableDeclarationPart#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclarationPart#getDefault()
   * @see #getVariableDeclarationPart()
   * @generated
   */
  EReference getVariableDeclarationPart_Default();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.BasicType <em>Basic Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.BasicType
   * @generated
   */
  EClass getBasicType();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.BasicType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.BasicType#getType()
   * @see #getBasicType()
   * @generated
   */
  EAttribute getBasicType_Type();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Type#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.Type#getType()
   * @see #getType()
   * @generated
   */
  EReference getType_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Type#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.ivml.Type#getId()
   * @see #getType()
   * @generated
   */
  EReference getType_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Type#getDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Derived</em>'.
   * @see de.uni_hildesheim.sse.ivml.Type#getDerived()
   * @see #getType()
   * @generated
   */
  EReference getType_Derived();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.NumValue <em>Num Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Num Value</em>'.
   * @see de.uni_hildesheim.sse.ivml.NumValue
   * @generated
   */
  EClass getNumValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.NumValue#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see de.uni_hildesheim.sse.ivml.NumValue#getVal()
   * @see #getNumValue()
   * @generated
   */
  EAttribute getNumValue_Val();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.QualifiedName
   * @generated
   */
  EClass getQualifiedName();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.ivml.QualifiedName#getQName <em>QName</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>QName</em>'.
   * @see de.uni_hildesheim.sse.ivml.QualifiedName#getQName()
   * @see #getQualifiedName()
   * @generated
   */
  EAttribute getQualifiedName_QName();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AccessName <em>Access Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Access Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.AccessName
   * @generated
   */
  EClass getAccessName();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.ivml.AccessName#getAName <em>AName</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>AName</em>'.
   * @see de.uni_hildesheim.sse.ivml.AccessName#getAName()
   * @see #getAccessName()
   * @generated
   */
  EAttribute getAccessName_AName();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see de.uni_hildesheim.sse.ivml.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Value#getNValue <em>NValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>NValue</em>'.
   * @see de.uni_hildesheim.sse.ivml.Value#getNValue()
   * @see #getValue()
   * @generated
   */
  EReference getValue_NValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.Value#getSValue <em>SValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>SValue</em>'.
   * @see de.uni_hildesheim.sse.ivml.Value#getSValue()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_SValue();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Value#getQValue <em>QValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>QValue</em>'.
   * @see de.uni_hildesheim.sse.ivml.Value#getQValue()
   * @see #getValue()
   * @generated
   */
  EReference getValue_QValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.Value#getBValue <em>BValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>BValue</em>'.
   * @see de.uni_hildesheim.sse.ivml.Value#getBValue()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_BValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.Value#getNullValue <em>Null Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Null Value</em>'.
   * @see de.uni_hildesheim.sse.ivml.Value#getNullValue()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_NullValue();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.DerivedType <em>Derived Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Derived Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.DerivedType
   * @generated
   */
  EClass getDerivedType();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.DerivedType#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.DerivedType#getOp()
   * @see #getDerivedType()
   * @generated
   */
  EAttribute getDerivedType_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.DerivedType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.DerivedType#getType()
   * @see #getDerivedType()
   * @generated
   */
  EReference getDerivedType_Type();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.DslContext <em>Dsl Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dsl Context</em>'.
   * @see de.uni_hildesheim.sse.ivml.DslContext
   * @generated
   */
  EClass getDslContext();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.DslContext#getStop <em>Stop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Stop</em>'.
   * @see de.uni_hildesheim.sse.ivml.DslContext#getStop()
   * @see #getDslContext()
   * @generated
   */
  EAttribute getDslContext_Stop();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.DslContext#getEscape <em>Escape</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape</em>'.
   * @see de.uni_hildesheim.sse.ivml.DslContext#getEscape()
   * @see #getDslContext()
   * @generated
   */
  EAttribute getDslContext_Escape();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.DslContext#getCommand <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Command</em>'.
   * @see de.uni_hildesheim.sse.ivml.DslContext#getCommand()
   * @see #getDslContext()
   * @generated
   */
  EAttribute getDslContext_Command();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.DslContext#getDsl <em>Dsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dsl</em>'.
   * @see de.uni_hildesheim.sse.ivml.DslContext#getDsl()
   * @see #getDslContext()
   * @generated
   */
  EAttribute getDslContext_Dsl();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AttributeTo <em>Attribute To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute To</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttributeTo
   * @generated
   */
  EClass getAttributeTo();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeType <em>Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attribute Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeType()
   * @see #getAttributeTo()
   * @generated
   */
  EReference getAttributeTo_AttributeType();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeDecl <em>Attribute Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attribute Decl</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeDecl()
   * @see #getAttributeTo()
   * @generated
   */
  EReference getAttributeTo_AttributeDecl();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.ivml.AttributeTo#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Names</em>'.
   * @see de.uni_hildesheim.sse.ivml.AttributeTo#getNames()
   * @see #getAttributeTo()
   * @generated
   */
  EAttribute getAttributeTo_Names();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Freeze <em>Freeze</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Freeze</em>'.
   * @see de.uni_hildesheim.sse.ivml.Freeze
   * @generated
   */
  EClass getFreeze();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Freeze#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Names</em>'.
   * @see de.uni_hildesheim.sse.ivml.Freeze#getNames()
   * @see #getFreeze()
   * @generated
   */
  EReference getFreeze_Names();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Freeze#getBut <em>But</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>But</em>'.
   * @see de.uni_hildesheim.sse.ivml.Freeze#getBut()
   * @see #getFreeze()
   * @generated
   */
  EReference getFreeze_But();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.FreezeStatement <em>Freeze Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Freeze Statement</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeStatement
   * @generated
   */
  EClass getFreezeStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeStatement#getName()
   * @see #getFreezeStatement()
   * @generated
   */
  EReference getFreezeStatement_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeStatement#getAccess()
   * @see #getFreezeStatement()
   * @generated
   */
  EReference getFreezeStatement_Access();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.FreezeButList <em>Freeze But List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Freeze But List</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeButList
   * @generated
   */
  EClass getFreezeButList();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.FreezeButList#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeButList#getList()
   * @see #getFreezeButList()
   * @generated
   */
  EReference getFreezeButList_List();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression <em>Freeze But Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Freeze But Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeButExpression
   * @generated
   */
  EClass getFreezeButExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeButExpression#getName()
   * @see #getFreezeButExpression()
   * @generated
   */
  EReference getFreezeButExpression_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeButExpression#getAccess()
   * @see #getFreezeButExpression()
   * @generated
   */
  EReference getFreezeButExpression_Access();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getWildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wildcard</em>'.
   * @see de.uni_hildesheim.sse.ivml.FreezeButExpression#getWildcard()
   * @see #getFreezeButExpression()
   * @generated
   */
  EAttribute getFreezeButExpression_Wildcard();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Eval <em>Eval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Eval</em>'.
   * @see de.uni_hildesheim.sse.ivml.Eval
   * @generated
   */
  EClass getEval();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Eval#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested</em>'.
   * @see de.uni_hildesheim.sse.ivml.Eval#getNested()
   * @see #getEval()
   * @generated
   */
  EReference getEval_Nested();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Eval#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.uni_hildesheim.sse.ivml.Eval#getStatements()
   * @see #getEval()
   * @generated
   */
  EReference getEval_Statements();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration <em>Interface Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Declaration</em>'.
   * @see de.uni_hildesheim.sse.ivml.InterfaceDeclaration
   * @generated
   */
  EClass getInterfaceDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getName()
   * @see #getInterfaceDeclaration()
   * @generated
   */
  EAttribute getInterfaceDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getExports <em>Exports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exports</em>'.
   * @see de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getExports()
   * @see #getInterfaceDeclaration()
   * @generated
   */
  EReference getInterfaceDeclaration_Exports();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Export <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Export</em>'.
   * @see de.uni_hildesheim.sse.ivml.Export
   * @generated
   */
  EClass getExport();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.ivml.Export#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Names</em>'.
   * @see de.uni_hildesheim.sse.ivml.Export#getNames()
   * @see #getExport()
   * @generated
   */
  EAttribute getExport_Names();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ImportStmt <em>Import Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Stmt</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImportStmt
   * @generated
   */
  EClass getImportStmt();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImportStmt#getName()
   * @see #getImportStmt()
   * @generated
   */
  EAttribute getImportStmt_Name();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImportStmt#getInterface()
   * @see #getImportStmt()
   * @generated
   */
  EAttribute getImportStmt_Interface();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getVersions <em>Versions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Versions</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImportStmt#getVersions()
   * @see #getImportStmt()
   * @generated
   */
  EReference getImportStmt_Versions();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ConflictStmt <em>Conflict Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conflict Stmt</em>'.
   * @see de.uni_hildesheim.sse.ivml.ConflictStmt
   * @generated
   */
  EClass getConflictStmt();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ConflictStmt#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.ConflictStmt#getName()
   * @see #getConflictStmt()
   * @generated
   */
  EAttribute getConflictStmt_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ConflictStmt#getConflicts <em>Conflicts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conflicts</em>'.
   * @see de.uni_hildesheim.sse.ivml.ConflictStmt#getConflicts()
   * @see #getConflictStmt()
   * @generated
   */
  EReference getConflictStmt_Conflicts();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.VersionedId <em>Versioned Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Versioned Id</em>'.
   * @see de.uni_hildesheim.sse.ivml.VersionedId
   * @generated
   */
  EClass getVersionedId();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.VersionedId#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.VersionedId#getName()
   * @see #getVersionedId()
   * @generated
   */
  EAttribute getVersionedId_Name();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.VersionedId#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.VersionedId#getOp()
   * @see #getVersionedId()
   * @generated
   */
  EAttribute getVersionedId_Op();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.VersionedId#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see de.uni_hildesheim.sse.ivml.VersionedId#getVersion()
   * @see #getVersionedId()
   * @generated
   */
  EAttribute getVersionedId_Version();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.VersionStmt <em>Version Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Version Stmt</em>'.
   * @see de.uni_hildesheim.sse.ivml.VersionStmt
   * @generated
   */
  EClass getVersionStmt();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.VersionStmt#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see de.uni_hildesheim.sse.ivml.VersionStmt#getVersion()
   * @see #getVersionStmt()
   * @generated
   */
  EAttribute getVersionStmt_Version();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.OpDefStatement <em>Op Def Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Def Statement</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefStatement
   * @generated
   */
  EClass getOpDefStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefStatement#getResult()
   * @see #getOpDefStatement()
   * @generated
   */
  EReference getOpDefStatement_Result();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefStatement#getId()
   * @see #getOpDefStatement()
   * @generated
   */
  EAttribute getOpDefStatement_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefStatement#getParam()
   * @see #getOpDefStatement()
   * @generated
   */
  EReference getOpDefStatement_Param();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getImpl <em>Impl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Impl</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefStatement#getImpl()
   * @see #getOpDefStatement()
   * @generated
   */
  EReference getOpDefStatement_Impl();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.OpDefParameterList <em>Op Def Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Def Parameter List</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameterList
   * @generated
   */
  EClass getOpDefParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.OpDefParameterList#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameterList#getList()
   * @see #getOpDefParameterList()
   * @generated
   */
  EReference getOpDefParameterList_List();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.OpDefParameter <em>Op Def Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Def Parameter</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameter
   * @generated
   */
  EClass getOpDefParameter();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameter#getType()
   * @see #getOpDefParameter()
   * @generated
   */
  EReference getOpDefParameter_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameter#getId()
   * @see #getOpDefParameter()
   * @generated
   */
  EAttribute getOpDefParameter_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameter#getVal()
   * @see #getOpDefParameter()
   * @generated
   */
  EReference getOpDefParameter_Val();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.ExpressionStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionStatement#getExpr()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Expression#getLet <em>Let</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Let</em>'.
   * @see de.uni_hildesheim.sse.ivml.Expression#getLet()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Let();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Expression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.ivml.Expression#getExpr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Expression#getCollection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collection</em>'.
   * @see de.uni_hildesheim.sse.ivml.Expression#getCollection()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Collection();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Expression#getDsl <em>Dsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dsl</em>'.
   * @see de.uni_hildesheim.sse.ivml.Expression#getDsl()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Dsl();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.LetExpression <em>Let Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.LetExpression
   * @generated
   */
  EClass getLetExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.LetExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.LetExpression#getType()
   * @see #getLetExpression()
   * @generated
   */
  EReference getLetExpression_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.LetExpression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.LetExpression#getName()
   * @see #getLetExpression()
   * @generated
   */
  EAttribute getLetExpression_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.LetExpression#getValueExpr <em>Value Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Expr</em>'.
   * @see de.uni_hildesheim.sse.ivml.LetExpression#getValueExpr()
   * @see #getLetExpression()
   * @generated
   */
  EReference getLetExpression_ValueExpr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.LetExpression#getSubExpr <em>Sub Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Expr</em>'.
   * @see de.uni_hildesheim.sse.ivml.LetExpression#getSubExpr()
   * @see #getLetExpression()
   * @generated
   */
  EReference getLetExpression_SubExpr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpression
   * @generated
   */
  EClass getAssignmentExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AssignmentExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpression#getLeft()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Left();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.AssignmentExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpression#getRight()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart <em>Assignment Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpressionPart
   * @generated
   */
  EClass getAssignmentExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getOp()
   * @see #getAssignmentExpressionPart()
   * @generated
   */
  EAttribute getAssignmentExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getEx()
   * @see #getAssignmentExpressionPart()
   * @generated
   */
  EReference getAssignmentExpressionPart_Ex();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getCollection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collection</em>'.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getCollection()
   * @see #getAssignmentExpressionPart()
   * @generated
   */
  EReference getAssignmentExpressionPart_Collection();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ImplicationExpression <em>Implication Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implication Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpression
   * @generated
   */
  EClass getImplicationExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.ImplicationExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpression#getLeft()
   * @see #getImplicationExpression()
   * @generated
   */
  EReference getImplicationExpression_Left();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ImplicationExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpression#getRight()
   * @see #getImplicationExpression()
   * @generated
   */
  EReference getImplicationExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ImplicationExpressionPart <em>Implication Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implication Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpressionPart
   * @generated
   */
  EClass getImplicationExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ImplicationExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpressionPart#getOp()
   * @see #getImplicationExpressionPart()
   * @generated
   */
  EAttribute getImplicationExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.ImplicationExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpressionPart#getEx()
   * @see #getImplicationExpressionPart()
   * @generated
   */
  EReference getImplicationExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpression
   * @generated
   */
  EClass getLogicalExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.LogicalExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpression#getLeft()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_Left();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.LogicalExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpression#getRight()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.LogicalExpressionPart <em>Logical Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpressionPart
   * @generated
   */
  EClass getLogicalExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.LogicalExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpressionPart#getOp()
   * @see #getLogicalExpressionPart()
   * @generated
   */
  EAttribute getLogicalExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.LogicalExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpressionPart#getEx()
   * @see #getLogicalExpressionPart()
   * @generated
   */
  EReference getLogicalExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.EqualityExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpression#getLeft()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.EqualityExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpression#getRight()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.EqualityExpressionPart <em>Equality Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpressionPart
   * @generated
   */
  EClass getEqualityExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.EqualityExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpressionPart#getOp()
   * @see #getEqualityExpressionPart()
   * @generated
   */
  EAttribute getEqualityExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.EqualityExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpressionPart#getEx()
   * @see #getEqualityExpressionPart()
   * @generated
   */
  EReference getEqualityExpressionPart_Ex();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.EqualityExpressionPart#getCollection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collection</em>'.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpressionPart#getCollection()
   * @see #getEqualityExpressionPart()
   * @generated
   */
  EReference getEqualityExpressionPart_Collection();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.RelationalExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpression#getLeft()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.RelationalExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpression#getRight()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.RelationalExpressionPart <em>Relational Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpressionPart
   * @generated
   */
  EClass getRelationalExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.RelationalExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpressionPart#getOp()
   * @see #getRelationalExpressionPart()
   * @generated
   */
  EAttribute getRelationalExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.RelationalExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpressionPart#getEx()
   * @see #getRelationalExpressionPart()
   * @generated
   */
  EReference getRelationalExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AdditiveExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpression#getLeft()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Left();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.AdditiveExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpression#getRight()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.AdditiveExpressionPart <em>Additive Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpressionPart
   * @generated
   */
  EClass getAdditiveExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.AdditiveExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpressionPart#getOp()
   * @see #getAdditiveExpressionPart()
   * @generated
   */
  EAttribute getAdditiveExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.AdditiveExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpressionPart#getEx()
   * @see #getAdditiveExpressionPart()
   * @generated
   */
  EReference getAdditiveExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getLeft()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getRight()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart <em>Multiplicative Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression Part</em>'.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart
   * @generated
   */
  EClass getMultiplicativeExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart#getOp()
   * @see #getMultiplicativeExpressionPart()
   * @generated
   */
  EAttribute getMultiplicativeExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart#getExpr()
   * @see #getMultiplicativeExpressionPart()
   * @generated
   */
  EReference getMultiplicativeExpressionPart_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.UnaryExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.UnaryExpression#getOp()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.UnaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.ivml.UnaryExpression#getExpr()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PostfixExpression#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.ivml.PostfixExpression#getCall()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Call();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.PostfixExpression#getFCalls <em>FCalls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>FCalls</em>'.
   * @see de.uni_hildesheim.sse.ivml.PostfixExpression#getFCalls()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_FCalls();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PostfixExpression#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see de.uni_hildesheim.sse.ivml.PostfixExpression#getAccess()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Access();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PostfixExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.ivml.PostfixExpression#getLeft()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Left();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.ivml.Call
   * @generated
   */
  EClass getCall();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Call#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.ivml.Call#getCall()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Call();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Call#getSetOp <em>Set Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Set Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.Call#getSetOp()
   * @see #getCall()
   * @generated
   */
  EReference getCall_SetOp();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Call#getArrayEx <em>Array Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.Call#getArrayEx()
   * @see #getCall()
   * @generated
   */
  EReference getCall_ArrayEx();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.FeatureCall <em>Feature Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Call</em>'.
   * @see de.uni_hildesheim.sse.ivml.FeatureCall
   * @generated
   */
  EClass getFeatureCall();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.FeatureCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.FeatureCall#getName()
   * @see #getFeatureCall()
   * @generated
   */
  EAttribute getFeatureCall_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.FeatureCall#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.ivml.FeatureCall#getParam()
   * @see #getFeatureCall()
   * @generated
   */
  EReference getFeatureCall_Param();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.SetOp <em>Set Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Op</em>'.
   * @see de.uni_hildesheim.sse.ivml.SetOp
   * @generated
   */
  EClass getSetOp();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.SetOp#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.SetOp#getName()
   * @see #getSetOp()
   * @generated
   */
  EAttribute getSetOp_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.SetOp#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl</em>'.
   * @see de.uni_hildesheim.sse.ivml.SetOp#getDecl()
   * @see #getSetOp()
   * @generated
   */
  EReference getSetOp_Decl();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.SetOp#getDeclEx <em>Decl Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.SetOp#getDeclEx()
   * @see #getSetOp()
   * @generated
   */
  EReference getSetOp_DeclEx();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator</em>'.
   * @see de.uni_hildesheim.sse.ivml.Declarator
   * @generated
   */
  EClass getDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.Declarator#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decl</em>'.
   * @see de.uni_hildesheim.sse.ivml.Declarator#getDecl()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_Decl();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see de.uni_hildesheim.sse.ivml.Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.ivml.Declaration#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.ivml.Declaration#getId()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Declaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.Declaration#getType()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Declaration#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see de.uni_hildesheim.sse.ivml.Declaration#getInit()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_Init();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ActualParameterList <em>Actual Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actual Parameter List</em>'.
   * @see de.uni_hildesheim.sse.ivml.ActualParameterList
   * @generated
   */
  EClass getActualParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ActualParameterList#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.ivml.ActualParameterList#getParam()
   * @see #getActualParameterList()
   * @generated
   */
  EReference getActualParameterList_Param();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ExpressionAccess <em>Expression Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Access</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionAccess
   * @generated
   */
  EClass getExpressionAccess();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ExpressionAccess#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionAccess#getName()
   * @see #getExpressionAccess()
   * @generated
   */
  EAttribute getExpressionAccess_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ExpressionAccess#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionAccess#getCalls()
   * @see #getExpressionAccess()
   * @generated
   */
  EReference getExpressionAccess_Calls();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.ExpressionAccess#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionAccess#getAccess()
   * @see #getExpressionAccess()
   * @generated
   */
  EReference getExpressionAccess_Access();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getLit <em>Lit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lit</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression#getLit()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Lit();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression#getEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Ex();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getIfEx <em>If Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression#getIfEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_IfEx();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getRefName <em>Ref Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression#getRefName()
   * @see #getPrimaryExpression()
   * @generated
   */
  EAttribute getPrimaryExpression_RefName();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression#getCalls()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Calls();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression#getAccess()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Access();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.CollectionInitializer <em>Collection Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Initializer</em>'.
   * @see de.uni_hildesheim.sse.ivml.CollectionInitializer
   * @generated
   */
  EClass getCollectionInitializer();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.CollectionInitializer#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.ivml.CollectionInitializer#getType()
   * @see #getCollectionInitializer()
   * @generated
   */
  EReference getCollectionInitializer_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.CollectionInitializer#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see de.uni_hildesheim.sse.ivml.CollectionInitializer#getInit()
   * @see #getCollectionInitializer()
   * @generated
   */
  EReference getCollectionInitializer_Init();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ExpressionListOrRange <em>Expression List Or Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression List Or Range</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListOrRange
   * @generated
   */
  EClass getExpressionListOrRange();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.ivml.ExpressionListOrRange#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListOrRange#getList()
   * @see #getExpressionListOrRange()
   * @generated
   */
  EReference getExpressionListOrRange_List();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.ExpressionListEntry <em>Expression List Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression List Entry</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListEntry
   * @generated
   */
  EClass getExpressionListEntry();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ExpressionListEntry#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListEntry#getName()
   * @see #getExpressionListEntry()
   * @generated
   */
  EAttribute getExpressionListEntry_Name();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.ivml.ExpressionListEntry#getAttrib <em>Attrib</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attrib</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListEntry#getAttrib()
   * @see #getExpressionListEntry()
   * @generated
   */
  EAttribute getExpressionListEntry_Attrib();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.ExpressionListEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListEntry#getValue()
   * @see #getExpressionListEntry()
   * @generated
   */
  EReference getExpressionListEntry_Value();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.ExpressionListEntry#getCollection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collection</em>'.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListEntry#getCollection()
   * @see #getExpressionListEntry()
   * @generated
   */
  EReference getExpressionListEntry_Collection();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see de.uni_hildesheim.sse.ivml.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.Literal#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see de.uni_hildesheim.sse.ivml.Literal#getVal()
   * @see #getLiteral()
   * @generated
   */
  EReference getLiteral_Val();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.ivml.IfExpression <em>If Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Expression</em>'.
   * @see de.uni_hildesheim.sse.ivml.IfExpression
   * @generated
   */
  EClass getIfExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.IfExpression#getIfEx <em>If Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.IfExpression#getIfEx()
   * @see #getIfExpression()
   * @generated
   */
  EReference getIfExpression_IfEx();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.IfExpression#getThenEx <em>Then Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.IfExpression#getThenEx()
   * @see #getIfExpression()
   * @generated
   */
  EReference getIfExpression_ThenEx();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.ivml.IfExpression#getElseEx <em>Else Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Ex</em>'.
   * @see de.uni_hildesheim.sse.ivml.IfExpression#getElseEx()
   * @see #getIfExpression()
   * @generated
   */
  EReference getIfExpression_ElseEx();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IvmlFactory getIvmlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.VariabilityUnitImpl <em>Variability Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.VariabilityUnitImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVariabilityUnit()
     * @generated
     */
    EClass VARIABILITY_UNIT = eINSTANCE.getVariabilityUnit();

    /**
     * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABILITY_UNIT__PROJECTS = eINSTANCE.getVariabilityUnit_Projects();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ProjectImpl <em>Project</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ProjectImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getProject()
     * @generated
     */
    EClass PROJECT = eINSTANCE.getProject();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__VERSION = eINSTANCE.getProject_Version();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__IMPORTS = eINSTANCE.getProject_Imports();

    /**
     * The meta object literal for the '<em><b>Conflicts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__CONFLICTS = eINSTANCE.getProject_Conflicts();

    /**
     * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__INTERFACES = eINSTANCE.getProject_Interfaces();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__CONTENTS = eINSTANCE.getProject_Contents();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ProjectContentsImpl <em>Project Contents</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ProjectContentsImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getProjectContents()
     * @generated
     */
    EClass PROJECT_CONTENTS = eINSTANCE.getProjectContents();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT_CONTENTS__ELEMENTS = eINSTANCE.getProjectContents_Elements();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefImpl <em>Typedef</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypedefImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedef()
     * @generated
     */
    EClass TYPEDEF = eINSTANCE.getTypedef();

    /**
     * The meta object literal for the '<em><b>TEnum</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF__TENUM = eINSTANCE.getTypedef_TEnum();

    /**
     * The meta object literal for the '<em><b>TCompound</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF__TCOMPOUND = eINSTANCE.getTypedef_TCompound();

    /**
     * The meta object literal for the '<em><b>TMapping</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF__TMAPPING = eINSTANCE.getTypedef_TMapping();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefEnumImpl <em>Typedef Enum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypedefEnumImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefEnum()
     * @generated
     */
    EClass TYPEDEF_ENUM = eINSTANCE.getTypedefEnum();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_ENUM__NAME = eINSTANCE.getTypedefEnum_Name();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_ENUM__LITERALS = eINSTANCE.getTypedefEnum_Literals();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_ENUM__CONSTRAINT = eINSTANCE.getTypedefEnum_Constraint();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefEnumLiteralImpl <em>Typedef Enum Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypedefEnumLiteralImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefEnumLiteral()
     * @generated
     */
    EClass TYPEDEF_ENUM_LITERAL = eINSTANCE.getTypedefEnumLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_ENUM_LITERAL__NAME = eINSTANCE.getTypedefEnumLiteral_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_ENUM_LITERAL__VALUE = eINSTANCE.getTypedefEnumLiteral_Value();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefCompoundImpl <em>Typedef Compound</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypedefCompoundImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefCompound()
     * @generated
     */
    EClass TYPEDEF_COMPOUND = eINSTANCE.getTypedefCompound();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_COMPOUND__NAME = eINSTANCE.getTypedefCompound_Name();

    /**
     * The meta object literal for the '<em><b>Super</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_COMPOUND__SUPER = eINSTANCE.getTypedefCompound_Super();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_COMPOUND__ELEMENTS = eINSTANCE.getTypedefCompound_Elements();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AttrAssignmentImpl <em>Attr Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AttrAssignmentImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAttrAssignment()
     * @generated
     */
    EClass ATTR_ASSIGNMENT = eINSTANCE.getAttrAssignment();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_ASSIGNMENT__PARTS = eINSTANCE.getAttrAssignment_Parts();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_ASSIGNMENT__ELEMENTS = eINSTANCE.getAttrAssignment_Elements();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AttrAssignmentPartImpl <em>Attr Assignment Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AttrAssignmentPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAttrAssignmentPart()
     * @generated
     */
    EClass ATTR_ASSIGNMENT_PART = eINSTANCE.getAttrAssignmentPart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR_ASSIGNMENT_PART__NAME = eINSTANCE.getAttrAssignmentPart_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_ASSIGNMENT_PART__VALUE = eINSTANCE.getAttrAssignmentPart_Value();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefMappingImpl <em>Typedef Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypedefMappingImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefMapping()
     * @generated
     */
    EClass TYPEDEF_MAPPING = eINSTANCE.getTypedefMapping();

    /**
     * The meta object literal for the '<em><b>New Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_MAPPING__NEW_TYPE = eINSTANCE.getTypedefMapping_NewType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_MAPPING__TYPE = eINSTANCE.getTypedefMapping_Type();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_MAPPING__CONSTRAINT = eINSTANCE.getTypedefMapping_Constraint();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypedefConstraintImpl <em>Typedef Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypedefConstraintImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getTypedefConstraint()
     * @generated
     */
    EClass TYPEDEF_CONSTRAINT = eINSTANCE.getTypedefConstraint();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_CONSTRAINT__EXPRESSIONS = eINSTANCE.getTypedefConstraint_Expressions();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.VariableDeclarationImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVariableDeclaration()
     * @generated
     */
    EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__DECLS = eINSTANCE.getVariableDeclaration_Decls();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.VariableDeclarationPartImpl <em>Variable Declaration Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.VariableDeclarationPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVariableDeclarationPart()
     * @generated
     */
    EClass VARIABLE_DECLARATION_PART = eINSTANCE.getVariableDeclarationPart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION_PART__NAME = eINSTANCE.getVariableDeclarationPart_Name();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION_PART__DEFAULT = eINSTANCE.getVariableDeclarationPart_Default();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.BasicTypeImpl <em>Basic Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.BasicTypeImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getBasicType()
     * @generated
     */
    EClass BASIC_TYPE = eINSTANCE.getBasicType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASIC_TYPE__TYPE = eINSTANCE.getBasicType_Type();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.TypeImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__TYPE = eINSTANCE.getType_Type();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__ID = eINSTANCE.getType_Id();

    /**
     * The meta object literal for the '<em><b>Derived</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__DERIVED = eINSTANCE.getType_Derived();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.NumValueImpl <em>Num Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.NumValueImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getNumValue()
     * @generated
     */
    EClass NUM_VALUE = eINSTANCE.getNumValue();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUM_VALUE__VAL = eINSTANCE.getNumValue_Val();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.QualifiedNameImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getQualifiedName()
     * @generated
     */
    EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

    /**
     * The meta object literal for the '<em><b>QName</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_NAME__QNAME = eINSTANCE.getQualifiedName_QName();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AccessNameImpl <em>Access Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AccessNameImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAccessName()
     * @generated
     */
    EClass ACCESS_NAME = eINSTANCE.getAccessName();

    /**
     * The meta object literal for the '<em><b>AName</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACCESS_NAME__ANAME = eINSTANCE.getAccessName_AName();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ValueImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '<em><b>NValue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE__NVALUE = eINSTANCE.getValue_NValue();

    /**
     * The meta object literal for the '<em><b>SValue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__SVALUE = eINSTANCE.getValue_SValue();

    /**
     * The meta object literal for the '<em><b>QValue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE__QVALUE = eINSTANCE.getValue_QValue();

    /**
     * The meta object literal for the '<em><b>BValue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__BVALUE = eINSTANCE.getValue_BValue();

    /**
     * The meta object literal for the '<em><b>Null Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__NULL_VALUE = eINSTANCE.getValue_NullValue();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.DerivedTypeImpl <em>Derived Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.DerivedTypeImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDerivedType()
     * @generated
     */
    EClass DERIVED_TYPE = eINSTANCE.getDerivedType();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DERIVED_TYPE__OP = eINSTANCE.getDerivedType_Op();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DERIVED_TYPE__TYPE = eINSTANCE.getDerivedType_Type();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.DslContextImpl <em>Dsl Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.DslContextImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDslContext()
     * @generated
     */
    EClass DSL_CONTEXT = eINSTANCE.getDslContext();

    /**
     * The meta object literal for the '<em><b>Stop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DSL_CONTEXT__STOP = eINSTANCE.getDslContext_Stop();

    /**
     * The meta object literal for the '<em><b>Escape</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DSL_CONTEXT__ESCAPE = eINSTANCE.getDslContext_Escape();

    /**
     * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DSL_CONTEXT__COMMAND = eINSTANCE.getDslContext_Command();

    /**
     * The meta object literal for the '<em><b>Dsl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DSL_CONTEXT__DSL = eINSTANCE.getDslContext_Dsl();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AttributeToImpl <em>Attribute To</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AttributeToImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAttributeTo()
     * @generated
     */
    EClass ATTRIBUTE_TO = eINSTANCE.getAttributeTo();

    /**
     * The meta object literal for the '<em><b>Attribute Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_TO__ATTRIBUTE_TYPE = eINSTANCE.getAttributeTo_AttributeType();

    /**
     * The meta object literal for the '<em><b>Attribute Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_TO__ATTRIBUTE_DECL = eINSTANCE.getAttributeTo_AttributeDecl();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_TO__NAMES = eINSTANCE.getAttributeTo_Names();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl <em>Freeze</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.FreezeImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreeze()
     * @generated
     */
    EClass FREEZE = eINSTANCE.getFreeze();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE__NAMES = eINSTANCE.getFreeze_Names();

    /**
     * The meta object literal for the '<em><b>But</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE__BUT = eINSTANCE.getFreeze_But();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeStatementImpl <em>Freeze Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.FreezeStatementImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreezeStatement()
     * @generated
     */
    EClass FREEZE_STATEMENT = eINSTANCE.getFreezeStatement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE_STATEMENT__NAME = eINSTANCE.getFreezeStatement_Name();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE_STATEMENT__ACCESS = eINSTANCE.getFreezeStatement_Access();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeButListImpl <em>Freeze But List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.FreezeButListImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreezeButList()
     * @generated
     */
    EClass FREEZE_BUT_LIST = eINSTANCE.getFreezeButList();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE_BUT_LIST__LIST = eINSTANCE.getFreezeButList_List();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl <em>Freeze But Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFreezeButExpression()
     * @generated
     */
    EClass FREEZE_BUT_EXPRESSION = eINSTANCE.getFreezeButExpression();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE_BUT_EXPRESSION__NAME = eINSTANCE.getFreezeButExpression_Name();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FREEZE_BUT_EXPRESSION__ACCESS = eINSTANCE.getFreezeButExpression_Access();

    /**
     * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FREEZE_BUT_EXPRESSION__WILDCARD = eINSTANCE.getFreezeButExpression_Wildcard();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.EvalImpl <em>Eval</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.EvalImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getEval()
     * @generated
     */
    EClass EVAL = eINSTANCE.getEval();

    /**
     * The meta object literal for the '<em><b>Nested</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVAL__NESTED = eINSTANCE.getEval_Nested();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVAL__STATEMENTS = eINSTANCE.getEval_Statements();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.InterfaceDeclarationImpl <em>Interface Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.InterfaceDeclarationImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getInterfaceDeclaration()
     * @generated
     */
    EClass INTERFACE_DECLARATION = eINSTANCE.getInterfaceDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_DECLARATION__NAME = eINSTANCE.getInterfaceDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_DECLARATION__EXPORTS = eINSTANCE.getInterfaceDeclaration_Exports();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ExportImpl <em>Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ExportImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExport()
     * @generated
     */
    EClass EXPORT = eINSTANCE.getExport();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPORT__NAMES = eINSTANCE.getExport_Names();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ImportStmtImpl <em>Import Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ImportStmtImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getImportStmt()
     * @generated
     */
    EClass IMPORT_STMT = eINSTANCE.getImportStmt();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_STMT__NAME = eINSTANCE.getImportStmt_Name();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_STMT__INTERFACE = eINSTANCE.getImportStmt_Interface();

    /**
     * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_STMT__VERSIONS = eINSTANCE.getImportStmt_Versions();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ConflictStmtImpl <em>Conflict Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ConflictStmtImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getConflictStmt()
     * @generated
     */
    EClass CONFLICT_STMT = eINSTANCE.getConflictStmt();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFLICT_STMT__NAME = eINSTANCE.getConflictStmt_Name();

    /**
     * The meta object literal for the '<em><b>Conflicts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFLICT_STMT__CONFLICTS = eINSTANCE.getConflictStmt_Conflicts();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.VersionedIdImpl <em>Versioned Id</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.VersionedIdImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVersionedId()
     * @generated
     */
    EClass VERSIONED_ID = eINSTANCE.getVersionedId();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERSIONED_ID__NAME = eINSTANCE.getVersionedId_Name();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERSIONED_ID__OP = eINSTANCE.getVersionedId_Op();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERSIONED_ID__VERSION = eINSTANCE.getVersionedId_Version();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.VersionStmtImpl <em>Version Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.VersionStmtImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getVersionStmt()
     * @generated
     */
    EClass VERSION_STMT = eINSTANCE.getVersionStmt();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERSION_STMT__VERSION = eINSTANCE.getVersionStmt_Version();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl <em>Op Def Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getOpDefStatement()
     * @generated
     */
    EClass OP_DEF_STATEMENT = eINSTANCE.getOpDefStatement();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DEF_STATEMENT__RESULT = eINSTANCE.getOpDefStatement_Result();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OP_DEF_STATEMENT__ID = eINSTANCE.getOpDefStatement_Id();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DEF_STATEMENT__PARAM = eINSTANCE.getOpDefStatement_Param();

    /**
     * The meta object literal for the '<em><b>Impl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DEF_STATEMENT__IMPL = eINSTANCE.getOpDefStatement_Impl();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.OpDefParameterListImpl <em>Op Def Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.OpDefParameterListImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getOpDefParameterList()
     * @generated
     */
    EClass OP_DEF_PARAMETER_LIST = eINSTANCE.getOpDefParameterList();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DEF_PARAMETER_LIST__LIST = eINSTANCE.getOpDefParameterList_List();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.OpDefParameterImpl <em>Op Def Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.OpDefParameterImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getOpDefParameter()
     * @generated
     */
    EClass OP_DEF_PARAMETER = eINSTANCE.getOpDefParameter();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DEF_PARAMETER__TYPE = eINSTANCE.getOpDefParameter_Type();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OP_DEF_PARAMETER__ID = eINSTANCE.getOpDefParameter_Id();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DEF_PARAMETER__VAL = eINSTANCE.getOpDefParameter_Val();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ExpressionStatementImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__EXPR = eINSTANCE.getExpressionStatement_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Let</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__LET = eINSTANCE.getExpression_Let();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPR = eINSTANCE.getExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__COLLECTION = eINSTANCE.getExpression_Collection();

    /**
     * The meta object literal for the '<em><b>Dsl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__DSL = eINSTANCE.getExpression_Dsl();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl <em>Let Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLetExpression()
     * @generated
     */
    EClass LET_EXPRESSION = eINSTANCE.getLetExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXPRESSION__TYPE = eINSTANCE.getLetExpression_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LET_EXPRESSION__NAME = eINSTANCE.getLetExpression_Name();

    /**
     * The meta object literal for the '<em><b>Value Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXPRESSION__VALUE_EXPR = eINSTANCE.getLetExpression_ValueExpr();

    /**
     * The meta object literal for the '<em><b>Sub Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXPRESSION__SUB_EXPR = eINSTANCE.getLetExpression_SubExpr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAssignmentExpression()
     * @generated
     */
    EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__LEFT = eINSTANCE.getAssignmentExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__RIGHT = eINSTANCE.getAssignmentExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionPartImpl <em>Assignment Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AssignmentExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAssignmentExpressionPart()
     * @generated
     */
    EClass ASSIGNMENT_EXPRESSION_PART = eINSTANCE.getAssignmentExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_EXPRESSION_PART__OP = eINSTANCE.getAssignmentExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION_PART__EX = eINSTANCE.getAssignmentExpressionPart_Ex();

    /**
     * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION_PART__COLLECTION = eINSTANCE.getAssignmentExpressionPart_Collection();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionImpl <em>Implication Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getImplicationExpression()
     * @generated
     */
    EClass IMPLICATION_EXPRESSION = eINSTANCE.getImplicationExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLICATION_EXPRESSION__LEFT = eINSTANCE.getImplicationExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLICATION_EXPRESSION__RIGHT = eINSTANCE.getImplicationExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionPartImpl <em>Implication Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ImplicationExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getImplicationExpressionPart()
     * @generated
     */
    EClass IMPLICATION_EXPRESSION_PART = eINSTANCE.getImplicationExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPLICATION_EXPRESSION_PART__OP = eINSTANCE.getImplicationExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLICATION_EXPRESSION_PART__EX = eINSTANCE.getImplicationExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.LogicalExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLogicalExpression()
     * @generated
     */
    EClass LOGICAL_EXPRESSION = eINSTANCE.getLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__LEFT = eINSTANCE.getLogicalExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__RIGHT = eINSTANCE.getLogicalExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.LogicalExpressionPartImpl <em>Logical Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.LogicalExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLogicalExpressionPart()
     * @generated
     */
    EClass LOGICAL_EXPRESSION_PART = eINSTANCE.getLogicalExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_EXPRESSION_PART__OP = eINSTANCE.getLogicalExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION_PART__EX = eINSTANCE.getLogicalExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.EqualityExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__LEFT = eINSTANCE.getEqualityExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__RIGHT = eINSTANCE.getEqualityExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl <em>Equality Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getEqualityExpressionPart()
     * @generated
     */
    EClass EQUALITY_EXPRESSION_PART = eINSTANCE.getEqualityExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION_PART__OP = eINSTANCE.getEqualityExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION_PART__EX = eINSTANCE.getEqualityExpressionPart_Ex();

    /**
     * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION_PART__COLLECTION = eINSTANCE.getEqualityExpressionPart_Collection();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.RelationalExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__LEFT = eINSTANCE.getRelationalExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__RIGHT = eINSTANCE.getRelationalExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.RelationalExpressionPartImpl <em>Relational Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.RelationalExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getRelationalExpressionPart()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION_PART = eINSTANCE.getRelationalExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION_PART__OP = eINSTANCE.getRelationalExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION_PART__EX = eINSTANCE.getRelationalExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAdditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__LEFT = eINSTANCE.getAdditiveExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__RIGHT = eINSTANCE.getAdditiveExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionPartImpl <em>Additive Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.AdditiveExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getAdditiveExpressionPart()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION_PART = eINSTANCE.getAdditiveExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION_PART__OP = eINSTANCE.getAdditiveExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION_PART__EX = eINSTANCE.getAdditiveExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getMultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__LEFT = eINSTANCE.getMultiplicativeExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__RIGHT = eINSTANCE.getMultiplicativeExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionPartImpl <em>Multiplicative Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.MultiplicativeExpressionPartImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getMultiplicativeExpressionPart()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION_PART = eINSTANCE.getMultiplicativeExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION_PART__OP = eINSTANCE.getMultiplicativeExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION_PART__EXPR = eINSTANCE.getMultiplicativeExpressionPart_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.UnaryExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__OP = eINSTANCE.getUnaryExpression_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXPR = eINSTANCE.getUnaryExpression_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getPostfixExpression()
     * @generated
     */
    EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__CALL = eINSTANCE.getPostfixExpression_Call();

    /**
     * The meta object literal for the '<em><b>FCalls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__FCALLS = eINSTANCE.getPostfixExpression_FCalls();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__ACCESS = eINSTANCE.getPostfixExpression_Access();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__LEFT = eINSTANCE.getPostfixExpression_Left();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.CallImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getCall()
     * @generated
     */
    EClass CALL = eINSTANCE.getCall();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__CALL = eINSTANCE.getCall_Call();

    /**
     * The meta object literal for the '<em><b>Set Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__SET_OP = eINSTANCE.getCall_SetOp();

    /**
     * The meta object literal for the '<em><b>Array Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__ARRAY_EX = eINSTANCE.getCall_ArrayEx();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.FeatureCallImpl <em>Feature Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.FeatureCallImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getFeatureCall()
     * @generated
     */
    EClass FEATURE_CALL = eINSTANCE.getFeatureCall();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE_CALL__NAME = eINSTANCE.getFeatureCall_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL__PARAM = eINSTANCE.getFeatureCall_Param();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.SetOpImpl <em>Set Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.SetOpImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getSetOp()
     * @generated
     */
    EClass SET_OP = eINSTANCE.getSetOp();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SET_OP__NAME = eINSTANCE.getSetOp_Name();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_OP__DECL = eINSTANCE.getSetOp_Decl();

    /**
     * The meta object literal for the '<em><b>Decl Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_OP__DECL_EX = eINSTANCE.getSetOp_DeclEx();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.DeclaratorImpl <em>Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.DeclaratorImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDeclarator()
     * @generated
     */
    EClass DECLARATOR = eINSTANCE.getDeclarator();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__DECL = eINSTANCE.getDeclarator_Decl();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.DeclarationImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getDeclaration()
     * @generated
     */
    EClass DECLARATION = eINSTANCE.getDeclaration();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION__ID = eINSTANCE.getDeclaration_Id();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION__TYPE = eINSTANCE.getDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION__INIT = eINSTANCE.getDeclaration_Init();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ActualParameterListImpl <em>Actual Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ActualParameterListImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getActualParameterList()
     * @generated
     */
    EClass ACTUAL_PARAMETER_LIST = eINSTANCE.getActualParameterList();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTUAL_PARAMETER_LIST__PARAM = eINSTANCE.getActualParameterList_Param();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl <em>Expression Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionAccess()
     * @generated
     */
    EClass EXPRESSION_ACCESS = eINSTANCE.getExpressionAccess();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_ACCESS__NAME = eINSTANCE.getExpressionAccess_Name();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_ACCESS__CALLS = eINSTANCE.getExpressionAccess_Calls();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_ACCESS__ACCESS = eINSTANCE.getExpressionAccess_Access();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.PrimaryExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '<em><b>Lit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__LIT = eINSTANCE.getPrimaryExpression_Lit();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__EX = eINSTANCE.getPrimaryExpression_Ex();

    /**
     * The meta object literal for the '<em><b>If Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__IF_EX = eINSTANCE.getPrimaryExpression_IfEx();

    /**
     * The meta object literal for the '<em><b>Ref Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMARY_EXPRESSION__REF_NAME = eINSTANCE.getPrimaryExpression_RefName();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__CALLS = eINSTANCE.getPrimaryExpression_Calls();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__ACCESS = eINSTANCE.getPrimaryExpression_Access();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.CollectionInitializerImpl <em>Collection Initializer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.CollectionInitializerImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getCollectionInitializer()
     * @generated
     */
    EClass COLLECTION_INITIALIZER = eINSTANCE.getCollectionInitializer();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_INITIALIZER__TYPE = eINSTANCE.getCollectionInitializer_Type();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_INITIALIZER__INIT = eINSTANCE.getCollectionInitializer_Init();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListOrRangeImpl <em>Expression List Or Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ExpressionListOrRangeImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionListOrRange()
     * @generated
     */
    EClass EXPRESSION_LIST_OR_RANGE = eINSTANCE.getExpressionListOrRange();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST_OR_RANGE__LIST = eINSTANCE.getExpressionListOrRange_List();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl <em>Expression List Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getExpressionListEntry()
     * @generated
     */
    EClass EXPRESSION_LIST_ENTRY = eINSTANCE.getExpressionListEntry();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_LIST_ENTRY__NAME = eINSTANCE.getExpressionListEntry_Name();

    /**
     * The meta object literal for the '<em><b>Attrib</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_LIST_ENTRY__ATTRIB = eINSTANCE.getExpressionListEntry_Attrib();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST_ENTRY__VALUE = eINSTANCE.getExpressionListEntry_Value();

    /**
     * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST_ENTRY__COLLECTION = eINSTANCE.getExpressionListEntry_Collection();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.LiteralImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LITERAL__VAL = eINSTANCE.getLiteral_Val();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl <em>If Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl
     * @see de.uni_hildesheim.sse.ivml.impl.IvmlPackageImpl#getIfExpression()
     * @generated
     */
    EClass IF_EXPRESSION = eINSTANCE.getIfExpression();

    /**
     * The meta object literal for the '<em><b>If Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXPRESSION__IF_EX = eINSTANCE.getIfExpression_IfEx();

    /**
     * The meta object literal for the '<em><b>Then Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXPRESSION__THEN_EX = eINSTANCE.getIfExpression_ThenEx();

    /**
     * The meta object literal for the '<em><b>Else Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXPRESSION__ELSE_EX = eINSTANCE.getIfExpression_ElseEx();

  }

} //IvmlPackage
