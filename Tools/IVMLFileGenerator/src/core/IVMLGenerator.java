package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import config.GeneratorConfiguration;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/*
 *     // e.g. AnyType
    public static final String EQUALS = "=";
    public static final String UNEQUALS = "<>";
    public static final String IS_TYPE_OF = "isTypeOf";
    public static final String IS_KIND_OF = "isKindOf";
    
    // e.g. Boolean
    public static final String NOT = "not";
    public static final String OR = "or";
    public static final String XOR = "xor";
    public static final String AND = "and";
    public static final String IMPLIES = "implies";
    
    // e.g. Integer, Real
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULT = "*";
    public static final String DIV = "/";
    public static final String DIV_INT = "div";
    public static final String GREATER = ">";
    public static final String LESS = "<";
    public static final String GREATER_EQUALS = ">=";
    public static final String LESS_EQUALS = "<=";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String ABS = "abs";
    public static final String INVERSE = "-";
    public static final String FLOOR = "floor";
    public static final String ROUND = "round";
    public static final String MOD = "mod";
 */


public class IVMLGenerator {
	
	private static final String[] BOOLEAN_OPERATORS_FULL = {"and", "or", "xor", "implies"};
	// The subset is required to avoid multiple "implies" in a single constraint
	private static final String[] BOOLEAN_OPERATORS_SUB = {"and", "or", "xor"};
	// TODO resolve the problem of two negations in a row without brackets (how to define brackets??)
	private static final String NEGATE = "not";
	private static final String[] ARITHMETIC_OPERATORS = {"=", "<>", ">", ">=", "<=", "<"};
	private static final String[] CALCULATION_OPERATORS_FULL = {"+", "-", "*", "/"};
	// The subset is required as module is not allowed for real variables
	private static final String[] CALCULATION_OPERATORS_SUB = {"+", "-", "*", "/"};
	
	private Project project;
	private List<DecisionVariableDeclaration> decisionVariableList = new ArrayList<DecisionVariableDeclaration>();
	private List <Constraint> logicalConstraintList = new ArrayList<Constraint>();
	private List <Constraint> arithmeticIntConstraintList = new ArrayList<Constraint>();
	private List <Constraint> arithmeticRealConstraintList = new ArrayList<Constraint>();
	//private List <Constraint> logicalConstraintList = new ArrayList<Constraint>();
	
	public IVMLGenerator () {}
	
	/**
	 * This method generates a new project.
	 * 
	 * @param pName the name of the project to be generated
	 * @return the generated project
	 */
	public Project generate(String pName) {
		reset();
		project = new Project(pName);
		generate(project);
		return project;
	}
	
	/**
	 * This method generates a new project with a specific version number.
	 * 
	 * @param pName the name of the project to be generated
	 * @param pVersion the version string in terms of i(.i)* with i integer numbers 
	 * @return the generated project
	 */
	public Project generate(String pName, String pVersion) {
		reset();
		project = new Project(pName);
		Version projectVersion = null;
		try {
			projectVersion = new Version(pVersion);
		} catch (VersionFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setVersion(projectVersion);
		generate(project);
		return project;
	}

	/**
	 * This method generates the project content with respect
	 * to the specified configuration flags and values given by
	 * the generator configuration.
	 *  
	 * @param project the project for which the content is generated
	 */
	private void generate(Project project) {
		/*
		 *  TODO Complete the list of possible combinations
		 *  for generating more complex files!
		 */
		if (GeneratorConfiguration.INSTANCE.getUseBooleanElements()) {
			// Generate Boolean variables
			generateDecisionVariables(GeneratorConfiguration.INSTANCE.getBoolVarNum(), project,
					BooleanType.TYPE, GeneratorConfiguration.INSTANCE.getBoolVariableName());			
		}
		
		if (GeneratorConfiguration.INSTANCE.getUseIntElements()) {
			// Generate integer variables
			generateDecisionVariables(GeneratorConfiguration.INSTANCE.getIntVarNum(), project,
					IntegerType.TYPE, GeneratorConfiguration.INSTANCE.getIntVariableName());
		} 
		
		if (GeneratorConfiguration.INSTANCE.getUseRealElements()) {
			// Generate real variables
			generateDecisionVariables(GeneratorConfiguration.INSTANCE.getRealVarNum(), project,
					RealType.TYPE, GeneratorConfiguration.INSTANCE.getRealVariableName());
		}
		
		/*
		 * Finally, generate constraints accordingly to the specified number of constraints
		 * and the specified complexity level.
		 */
		generateConstraints(project);
	}
	
	/**
	 * This method generated decision variables of the specified type and,
	 * in case that the isConfiguration flag is set to true, defines
	 * random values for each variable.
	 * 
	 * @param varNum the number of variables to be generated
	 * @param project the project to which the variables will be added
	 * @param type the type of variables to be generated
	 * @param varName the (basic) name of the variables to be generated (a
	 * number for correct identification will be added by this method)
	 */
	private void generateDecisionVariables(int varNum, Project project, IDatatype type, String varName) {
		String vName = "";
		DecisionVariableDeclaration decVar = null;

		for (int i=0; i<varNum; i++) {
			vName = varName + i;
			decVar = new DecisionVariableDeclaration(vName, type, project);
			if (GeneratorConfiguration.INSTANCE.getIsConfiguration()) {
				try {
					decVar.setValue(getRandomValue(type));
				} catch (ValueDoesNotMatchTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			decisionVariableList.add(decVar);
			project.add(decVar);
		}
	}
	
	/**
	 * This is the basic method for generating constraints. It
	 * calls other (specific) constraint generation methods accordingly
	 * to the specified constraint types and the complexity level.
	 * 
	 * @param project the project to which the generated constraints will added
	 */
	private void generateConstraints(Project project) {
		int numberOfConstraints;
		// Generate (basic) logical constraints using Boolean variables
		if (GeneratorConfiguration.INSTANCE.getUseBooleanElements()) {			
			numberOfConstraints = GeneratorConfiguration.INSTANCE.getLogicalConstraintNum();
			// Basic logical constraints
			for (int i=0; i<numberOfConstraints; i++) {
				logicalConstraintList.add(generateLogicalConstraint(new Variable(getRandomVariable(BooleanType.TYPE)),
						new Variable(getRandomVariable(BooleanType.TYPE))));
			}
		}
		// Generate (basic) arithmetic constraints using integer variables
		if(GeneratorConfiguration.INSTANCE.getUseIntElements()) {
			numberOfConstraints = GeneratorConfiguration.INSTANCE.getArithmeticConstraintNum();
			// Basic arithmetic constraints
			for (int i=0; i<numberOfConstraints; i++) {
				arithmeticIntConstraintList.add(generateArithmeticConstraint(new Variable(getRandomVariable(IntegerType.TYPE)),
						new Variable(getRandomVariable(IntegerType.TYPE)), IntegerType.TYPE));
			}
		}
		
		/*
		 *  Generate (basic) arithmetic constraints using real variables
		 *  It is required to call the same loop twice in case that integer
		 *  as well as real variables have to be restricted for the same project
		 *  (there is only a single variable for specifying the number of arithmetic
		 *  constraints which will define the number for both types simultaneously).
		 */
		if(GeneratorConfiguration.INSTANCE.getUseRealElements()) {
			numberOfConstraints = GeneratorConfiguration.INSTANCE.getArithmeticConstraintNum();
			// Basic arithmetic constraints
			for (int i=0; i<numberOfConstraints; i++) {
				arithmeticRealConstraintList.add(generateArithmeticConstraint(new Variable(getRandomVariable(RealType.TYPE)),
						new Variable(getRandomVariable(RealType.TYPE)), RealType.TYPE));
			}
		}
		
		// Create more complex constraints accordingly to the specified complexity level
		if (GeneratorConfiguration.INSTANCE.getComplexityLevel() > 1) {
			generateComplexConstraints();	
		}
		
		// Finally, add all constraints to the project
		addAllConstraints(project);
	}
	
	/**
	 * This method delegates the generation of complex constraints to the appropriate
	 * generation methods based on the basic constraints generated by the (basic)
	 * constraint generation method. The types of constraints, which will be generated,
	 * and their complexity depends on the specified complexity level and the available
	 * types of (basic) constraints as well as the decision variables. 
	 */
	private void generateComplexConstraints() {
		
		if (GeneratorConfiguration.INSTANCE.getUseBooleanElements()) {
			extendLogicalConstraints(GeneratorConfiguration.INSTANCE.getLogicalConstraintNum());
		}
		
		if (GeneratorConfiguration.INSTANCE.getUseIntElements()) {
			extendArithmeticConstraints(GeneratorConfiguration.INSTANCE.getArithmeticConstraintNum(),
					IntegerType.TYPE);
		}
		
		if (GeneratorConfiguration.INSTANCE.getUseRealElements()) {
			extendArithmeticConstraints(GeneratorConfiguration.INSTANCE.getArithmeticConstraintNum(),
					RealType.TYPE);
		}
		
	}
	
	/**
	 * This method generates more complex arithmetic constraints using
	 * integer or real variables only accordingly to the specified
	 * complexity level.
	 * 
	 * @param numberOfConstraints the number of constraints to be generated
	 */
	private void extendArithmeticConstraints(int numberOfConstraints, IDatatype type) {
		List <Constraint> targetConstraintList = null;
		if (type == IntegerType.TYPE) {
			targetConstraintList = arithmeticIntConstraintList;
		} else {
			targetConstraintList = arithmeticRealConstraintList;
		}
		
		// Relate two arithmetic constraints by a Boolean operator (no calculation)
		if (GeneratorConfiguration.INSTANCE.getComplexityLevel() == 2) {
			Constraint existingConstraint = null;
			Constraint additionalConstraint = null;
			
			for (int i=0; i<numberOfConstraints; i++) {
				existingConstraint = targetConstraintList.get(i);
				targetConstraintList.remove(i);
				additionalConstraint = generateArithmeticConstraint(new Variable(getRandomVariable(type)),
						new Variable(getRandomVariable(type)), type);
				targetConstraintList.add(i, generateLogicalConstraint(existingConstraint,
						additionalConstraint, false));
			}
		}
		// Relate two arithmetic constraints by a Boolean operator (including calculation)
		if (GeneratorConfiguration.INSTANCE.getComplexityLevel() == 3) {
			Constraint existingConstraint = null;
			Constraint additionalConstraint = null;
			
			for (int i=0; i<numberOfConstraints; i++) {
				existingConstraint = targetConstraintList.get(i);
				targetConstraintList.remove(i);
				additionalConstraint = generateCalculation(new Variable(getRandomVariable(type)),
						new Variable(getRandomVariable(type)), type);
				targetConstraintList.add(i, generateLogicalConstraint(existingConstraint,
						additionalConstraint, false));
			}
		}
	}
	
	/**
	 * This method generates more complex logical constraints using Boolean
	 * variables only accordingly to the specified complexity level.
	 * 
	 * @param numberOfConstraints the number of constraints to be generated
	 */
	private void extendLogicalConstraints(int numberOfConstraints) {
		Random random = new Random();
		// 3-operand logical constraints using Boolean variables
		if (GeneratorConfiguration.INSTANCE.getComplexityLevel() == 2) {
			Constraint constraint = null;
			
			for (int i=0; i<numberOfConstraints; i++) {
				constraint = logicalConstraintList.get(i);
				logicalConstraintList.remove(i);
				logicalConstraintList.add(i, generateLogicalConstraint(constraint,
						new Variable(getRandomVariable(BooleanType.TYPE)), random.nextBoolean()));
			}
		}
		// 4-operand logical constraints using Boolean variables
		if (GeneratorConfiguration.INSTANCE.getComplexityLevel() == 3) {
			Constraint existingConstraint = null;
			Constraint additionalConstraint = null;
			
			for (int i=0; i<numberOfConstraints; i++) {
				existingConstraint = logicalConstraintList.get(i);
				logicalConstraintList.remove(i);
				additionalConstraint = generateLogicalConstraint(new Variable(getRandomVariable(BooleanType.TYPE)),
						new Variable(getRandomVariable(BooleanType.TYPE)));
				logicalConstraintList.add(i, generateLogicalConstraint(existingConstraint,
						additionalConstraint, random.nextBoolean()));
			}
		}
	}
	
	/**
	 * This method generates a simple arithmetic constraint by relating two
	 * (integer or real) variables via a random arithmetic operator
	 * (excluding calculations).
	 * 
	 * @param leftOperand the left-sided variable of the constraint
	 * @param rightOperand the right-sided variable of the constraint (this
	 * variable will be replaced randomly by a constant value)
	 * @param type the type of the variable for generating constant values
	 * accordingly to the available variable type 
	 * @return the generated constraint consisting of two (integer or real)
	 * variables or a variable and a constant value.
	 */
	private Constraint generateArithmeticConstraint(Variable leftOperand, Variable rightOperand, IDatatype type) {
		Constraint constraint = null;
		Random random = new Random();
		OCLFeatureCall constrImpl = null;
		ConstantValue constVal = null;
		
		try {
			constVal = new ConstantValue(ValueFactory.createValue(type, getRandomValue(type)));
		} catch (ValueDoesNotMatchTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (random.nextBoolean()) {
			constrImpl = new OCLFeatureCall(leftOperand,
					ARITHMETIC_OPERATORS[random.nextInt(ARITHMETIC_OPERATORS.length)], rightOperand);
		} else {
			constrImpl = new OCLFeatureCall(leftOperand,
					ARITHMETIC_OPERATORS[random.nextInt(ARITHMETIC_OPERATORS.length)], constVal);
		}
		
		try {
			constraint = new Constraint(constrImpl, project);
		} catch (CSTSemanticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return constraint;
	}
	
	/**
	 * This method generates a constraint which includes a value calculation in terms of
	 * relating the given operands by a calculation operator and relate a random variable
	 * of the same type by an arithmetic operaotr. For exmaple:
	 * 
	 * leftOperand + rightOperand >= randomVariable
	 * 
	 * @param leftOperand the left operand of the calculation
	 * @param rightOperand the right operand of the calculation
	 * @param type the type of the variables in order to differentiate between real and integer operators
	 * @return a constraint which includes a calculation
	 */
	private Constraint generateCalculation(Variable leftOperand, Variable rightOperand, IDatatype type) {
		Constraint constraint = null;
		Random random = new Random();
		OCLFeatureCall calcPart = null;
		OCLFeatureCall constrImpl = null;
		
		if (type == IntegerType.TYPE) {
			calcPart = new OCLFeatureCall(leftOperand,
					CALCULATION_OPERATORS_FULL[random.nextInt(CALCULATION_OPERATORS_FULL.length)], rightOperand);
		} else {
			// If calculations including real values shall be generated, no "modulo" is allowed as operator
			calcPart = new OCLFeatureCall(leftOperand,
					CALCULATION_OPERATORS_SUB[random.nextInt(CALCULATION_OPERATORS_SUB.length)], rightOperand);
		}

		constrImpl = new OCLFeatureCall(calcPart,
				ARITHMETIC_OPERATORS[random.nextInt(ARITHMETIC_OPERATORS.length)],
				new Variable(getRandomVariable(type)));
		
		try {
			constraint = new Constraint(constrImpl, project);
		} catch (CSTSemanticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return constraint;
	}
		
	/**
	 * This method generates a simple logical constraint by relating two
	 * (Boolean) variables via a random logical operator.
	 * 
	 * @param leftOperand the left-sided variable of the constraint
	 * @param rightOperand the right-sided variable of the constraint
	 * @return the generated constraint consisting of two (Boolean) variables.
	 */
	private Constraint generateLogicalConstraint(Variable leftOperand, Variable rightOperand) {
		Constraint constraint = null;
		Random random = new Random();
		OCLFeatureCall constrImpl = null;
		
		constrImpl = new OCLFeatureCall(leftOperand,
				BOOLEAN_OPERATORS_FULL[random.nextInt(BOOLEAN_OPERATORS_FULL.length)], rightOperand);
		
		try {
			constraint = new Constraint(constrImpl, project);
		} catch (CSTSemanticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return constraint;
	}
	
	/**
	 * This method generates a logical constraint by relating another constraint
	 * with a (Boolean) variables via a random logical operator.
	 * 
	 * @param leftOperand the left-sided partial constraint of the constraint to be generated
	 * @param rightOperand the right-sided variable of the constraint to be generated
	 * @param negate true if one of the operands shall be negated (random selection).
	 * Otherwise false.
	 * @return the generated constraint consisting of a left-sided partial constraint and a
	 * right-sided (Boolean) variable.
	 */
	private Constraint generateLogicalConstraint(Constraint leftOperand, Variable rightOperand, boolean negate) {
		Constraint constraint = null;
		Random random = new Random();
		OCLFeatureCall constrImpl = null;
		
		// If one part of the constraint shall be negated...
		if (negate) {
			OCLFeatureCall negatedPart = null;
			// Chose randomly which one (left or right) and add it to the constraint implementation.
			if (random.nextBoolean()) {
				negatedPart = new OCLFeatureCall(new Parenthesis(leftOperand.getConsSyntax()), NEGATE);
				// To avoid multiple "implies" in a single constraint, use the subset of boolean operators
				constrImpl = new OCLFeatureCall(negatedPart,
						BOOLEAN_OPERATORS_SUB[random.nextInt(BOOLEAN_OPERATORS_SUB.length)], rightOperand);
			} else {
				negatedPart = new OCLFeatureCall(new Parenthesis(rightOperand), NEGATE);
				// To avoid multiple "implies" in a single constraint, use the subset of boolean operators
				constrImpl = new OCLFeatureCall(new Parenthesis(leftOperand.getConsSyntax()),
						BOOLEAN_OPERATORS_SUB[random.nextInt(BOOLEAN_OPERATORS_SUB.length)], negatedPart);
			}
			
		} else {
			// If no negation required, just produce a constraint.
			// To avoid multiple "implies" in a single constraint, use the subset of boolean operators
			constrImpl = new OCLFeatureCall(new Parenthesis(leftOperand.getConsSyntax()),
					BOOLEAN_OPERATORS_SUB[random.nextInt(BOOLEAN_OPERATORS_SUB.length)], rightOperand);
		}
		
		try {
			constraint = new Constraint(constrImpl, project);
		} catch (CSTSemanticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return constraint;
	}
	
	/**
	 * This method generates a logical constraint by relating two constraints
	 * via a random logical operator.
	 * 
	 * @param leftOperand the left-sided partial constraint of the constraint to be generated
	 * @param rightOperand the right-sided partial constraint of the constraint to be generated
	 * @param negate true if one of the operands shall be negated (random selection). Otherwise false.
	 * @return the generated constraint consisting of two partial constraints.
	 */
	private Constraint generateLogicalConstraint(Constraint leftOperand, Constraint rightOperand, boolean negate) {
		Constraint constraint = null;
		Random random = new Random();
		OCLFeatureCall constrImpl = null;
		
		// If one part of the constraint shall be negated...
		if (negate) {
			OCLFeatureCall negatedPart = null;
			// Chose randomly which one (left or right) and add it to the constraint implementation.
			if (random.nextBoolean()) {
				negatedPart = new OCLFeatureCall(new Parenthesis(leftOperand.getConsSyntax()), NEGATE);
				// To avoid multiple "implies" in a single constraint, use the subset of boolean operators
				constrImpl = new OCLFeatureCall(new Parenthesis(negatedPart),
						BOOLEAN_OPERATORS_SUB[random.nextInt(BOOLEAN_OPERATORS_SUB.length)],
						new Parenthesis(rightOperand.getConsSyntax()));
			} else {
				negatedPart = new OCLFeatureCall(new Parenthesis(rightOperand.getConsSyntax()), NEGATE);
				// To avoid multiple "implies" in a single constraint, use the subset of boolean operators
				constrImpl = new OCLFeatureCall(new Parenthesis(leftOperand.getConsSyntax()),
						BOOLEAN_OPERATORS_SUB[random.nextInt(BOOLEAN_OPERATORS_SUB.length)],
						new Parenthesis(negatedPart));
			}
			
		} else {
			// If no negation required, just produce a constraint.
			// To avoid multiple "implies" in a single constraint, use the subset of boolean operators
			constrImpl = new OCLFeatureCall(new Parenthesis(leftOperand.getConsSyntax()),
					BOOLEAN_OPERATORS_SUB[random.nextInt(BOOLEAN_OPERATORS_SUB.length)], 
					new Parenthesis(rightOperand.getConsSyntax()));
		}
		
		try {
			constraint = new Constraint(constrImpl, project);
		} catch (CSTSemanticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return constraint;
	}
	
	/**
	 * This method returns a random decision variable declaration of a specific type
	 * (one of the previously defined variables of the generator) for including it
	 * as part of a constraint definition.
	 * However, this method does not guarantee that each variable of the current
	 * project will be part of at least on constraint. Neither will this be handled
	 * by the constraint generation method above.
	 * @param varType the type of the variable to be returned (based on VarModel types)
	 * @return a random decision variable declaration of the specified type
	 */
	private DecisionVariableDeclaration getRandomVariable(IDatatype varType) {
		Random random = new Random();
		DecisionVariableDeclaration randomVar = null;

		while (randomVar == null || randomVar.getType() != varType) {
			randomVar = decisionVariableList.get(random.nextInt(decisionVariableList.size()));
		}
		
		return randomVar;
	}

	/**
	 * This method generates random values for decision variables.
	 * 
	 * @param valType the type of the value to be generated (based on VarModel types)
	 * @return an object representing the generated value
	 */
	private Object getRandomValue(IDatatype valType){
		Random random = new Random();
		Object valueObj = null;
		
		if (valType == BooleanType.TYPE) {
			valueObj = random.nextBoolean();
		}
		
		if (valType == IntegerType.TYPE) {
			valueObj = random.nextInt(GeneratorConfiguration.INSTANCE.getIntVarBounds());
		}
		
		if (valType == RealType.TYPE) {
			float value = random.nextFloat();
			valueObj = value * GeneratorConfiguration.INSTANCE.getRealValMultiplicator();
		}
		
		if (valType == StringType.TYPE) {
			// TODO if needed at all
		}
		
		return valueObj;			
	}

	/**
	 * This method adds all constraints of all constraint lists to a given project.
	 * 
	 * @param project the project to which the constraints will be added.
	 */
	private void addAllConstraints(Project project) {
		
		for (int i=0; i<logicalConstraintList.size(); i++) {
			project.add(logicalConstraintList.get(i));
		}
		
		for (int i=0; i<arithmeticIntConstraintList.size(); i++) {
			project.add(arithmeticIntConstraintList.get(i));
		}
		
		for (int i=0; i<arithmeticRealConstraintList.size(); i++) {
			project.add(arithmeticRealConstraintList.get(i));
		}
	}
	
	/**
	 * This method resets all class variables in terms of clearing
	 * lists, setting object references to null, etc.
	 * This is required if the generation process is called multiple
	 * times (guarantees that no old objects are still in the cache).
	 */
	private void reset() {
		project = null;
		decisionVariableList.clear();
		logicalConstraintList.clear();
		arithmeticIntConstraintList.clear();
		arithmeticRealConstraintList.clear();
	}
}
