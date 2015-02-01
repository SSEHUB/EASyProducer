package core;

import java.io.FileWriter;
import java.io.IOException;

public class Generator {

	private static FileWriter writer;
	
	private static int random = 0;
	
	private static boolean addEnumDef = true;
	
	private static VariableType variableType = VariableType.NULL;
	
	private static OperationType operationType = OperationType.NULL;
	
	public static void main(String[] args) {

		String model = Configuration.FOLDER_PATH + Configuration.FILE_NAME + Configuration.FILE_EXTENSION;        
        
		Distribution.distributeProportions();
        
        try {
        	writer = new FileWriter(model, true);
        	appendLine("project " + Configuration.FILE_NAME + " {", 0);
		    createVariables();  
		    createConstraints();
        	appendLine("}", 0);
            writer.close();   
            System.out.println("Model generated!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
               
        
	}
	
	private static void createVariables() {
		for (int i = 0; i < Configuration.VARIABLES; i++) {
			random = generateRandom(1, 100);
			if ((100 + 1 > random) && (random > Distribution.variableDist.get(0))) {
				createBasicVariable(i);
			} else {
				createDerivedVariable(i);
			}
        }		
	}
	
	private static void createBasicVariable(Integer index) {
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.basicVariablesDist.get(0))) {			
			appendLine(declareVariable("Boolean", index), 1);
			Registry.booleanVariables.add(createVariableName(index));
		}
		if ((Distribution.basicVariablesDist.get(0) + 1 > random) && (random > Distribution.basicVariablesDist.get(1))) {
			appendLine(declareVariable("Integer", index), 1);
			Registry.integerVariables.add(createVariableName(index));
		}
		if ((Distribution.basicVariablesDist.get(1) + 1 > random) && (random > Distribution.basicVariablesDist.get(2))) {
			appendLine(declareVariable("Real", index), 1);
			Registry.realVariables.add(createVariableName(index));
		}
		if ((Distribution.basicVariablesDist.get(2) + 1 > random) && (random > Distribution.basicVariablesDist.get(3))) {
			if (addEnumDef) {
				appendLine("enum Colour {red, green, blue};", 1);
				addEnumDef = false;
			}
			appendLine(declareVariable("Colour", index), 1);
			Registry.enumVariables.add(createVariableName(index));
		}
		if ((Distribution.basicVariablesDist.get(3) + 1 > random) && (random > Distribution.basicVariablesDist.get(4))) {
			appendLine(declareVariable("String", index), 1);
			Registry.stringVariables.add(createVariableName(index));
		}
		if ((Distribution.basicVariablesDist.get(4) + 1 > random) && (random > Distribution.basicVariablesDist.get(5))) {
			// Attribute
		}
		if ((Distribution.basicVariablesDist.get(5) + 1 > random) && (random > 0)) {
			appendLine(declareVariable("Constraint", index), 1);
			Registry.constraintVariables.add(createVariableName(index));
		}
	}
	
	private static void createDerivedVariable(Integer index) {
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.derivedVariablesDist.get(0))) {
			// Sequence
		}
		if ((Distribution.derivedVariablesDist.get(0) + 1 > random) && (random > Distribution.derivedVariablesDist.get(1))) {
			// Set
		}
		if ((Distribution.derivedVariablesDist.get(1) + 1 > random) && (random > Distribution.derivedVariablesDist.get(2))) {
			// TypeDef
		}
		if ((Distribution.derivedVariablesDist.get(2) + 1 > random) && (random > Distribution.derivedVariablesDist.get(3))) {
			// Compound
		}
		if ((Distribution.derivedVariablesDist.get(3) + 1 > random) && (random > Distribution.derivedVariablesDist.get(4))) {
			// Refines
		}
		if ((Distribution.derivedVariablesDist.get(4) + 1 > random) && (random > 0)) {
			// RefTo
		}
	}
	
	private static String declareVariable(String text, int index) {
		return (text + " " + createVariableName(index) + ";");
	}
	
	private static String createVariableName(int index) {
		return Configuration.FILE_NAME + "_" + index;
	}
	
	
	private static void createConstraints() {
		for (int i = 0; i < Configuration.CONSTRAINTS; i++) {
			random = generateRandom(1, 100);
			String constraint = "FAIL";
			if ((100 + 1 > random) && (random > Distribution.constraintsDist.get(0))) {
				constraint = createAssignment() + ";";
			} else {
				constraint = createExpression(false, false, true) + ";";
			}
			appendLine(constraint, 1);
        }	
	}
	
	private static String createAssignment() {
		String operation = "=";
		String lhs = addVariable();
		String rhs = createExpression(); 
		variableType = VariableType.NULL;
		return lhs + " " + operation + " " + rhs;
	}
	
	private static String createExpression() {
		String exp = "";
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.expressionDist.get(0))) {
			exp = createExpression(true, false, false);
		}
		if ((Distribution.expressionDist.get(0) + 1 > random) && (random > Distribution.expressionDist.get(1))) {
			exp = createExpression(false, true, false);
		}
		if ((Distribution.expressionDist.get(1) + 1 > random) && (random > 0)) {
			exp = createExpression(false, false, true);
		}			
		return exp;
	}

	private static String createExpression(boolean variable, boolean constant, boolean expression) {
		String exp = "";
		if (variable) {
			exp = addVariable();
		}
		if (constant) {
			exp = addConstant();
		}
		if (expression) {
			String operation = selectOperationGroup();
			String lhs = createExpression();
			String rhs = createExpression();
			exp = lhs + " " + operation + " " + rhs;
		}		
		return "(" + exp + ")";
	}
	
	private static String addConstant() {		
		return "CONSTANT";
	}
	
	private static String addVariable() {
		String variable = "VARIABLE";
		switch (variableType) {
		case NULL:  
        	variable = selectRandomVariable();
            break;
        case BOOLEAN:  
        	variable = Registry.booleanVariables.get(generateRandom(0, Registry.booleanVariables.size() - 1));
            break;
        case INTEGER:  
        	variable = Registry.integerVariables.get(generateRandom(0, Registry.integerVariables.size() - 1));
            break;
        case REAL:  
        	variable = Registry.realVariables.get(generateRandom(0, Registry.realVariables.size() - 1));
            break;
        case ENUM:          		
        	variable = Registry.enumVariables.get(generateRandom(0, Registry.enumVariables.size() - 1));
            break;
        case STRING:  
        	variable = Registry.stringVariables.get(generateRandom(0, Registry.stringVariables.size() - 1));
            break;
        case CONSTRAINT:  
        	variable = Registry.constraintVariables.get(generateRandom(0, Registry.constraintVariables.size() - 1));
            break;       
        default: 
        	variable = Registry.booleanVariables.get(generateRandom(0, Registry.booleanVariables.size() - 1));
            break;
    }
		return variable;
	}
	
	private static String selectRandomVariable() {
		int random = generateRandom(1, 5);
		String variable = "VARIABLE";
		switch (random) {		
        case 1:  
        	variable = Registry.booleanVariables.get(generateRandom(0, Registry.booleanVariables.size() - 1));
            variableType = VariableType.BOOLEAN;
        	break;
        case 2:  
        	variable = Registry.integerVariables.get(generateRandom(0, Registry.integerVariables.size() - 1));
        	variableType = VariableType.INTEGER;
        	break;
        case 3:  
        	variable = Registry.realVariables.get(generateRandom(0, Registry.realVariables.size() - 1));
        	variableType = VariableType.REAL;
        	break;
        case 4:          		
        	variable = Registry.enumVariables.get(generateRandom(0, Registry.enumVariables.size() - 1));
        	variableType = VariableType.ENUM;
        	break;
        case 5:  
        	variable = Registry.stringVariables.get(generateRandom(0, Registry.stringVariables.size() - 1));
        	variableType = VariableType.STRING;
        	break;              
        default: 
        	variable = Registry.booleanVariables.get(generateRandom(0, Registry.booleanVariables.size() - 1));
        	variableType = VariableType.BOOLEAN;
        	break;
    }
		return variable;
	}

	private static String selectOperationGroup() {
		String operation = "";
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.operationsDist.get(0))) {
			operation = selectBoolAlgebraOperation();
		}
		if ((Distribution.operationsDist.get(0) + 1 > random) && (random > Distribution.operationsDist.get(1))) {
			operation = selectEqualityOperation();
		}
		if ((Distribution.operationsDist.get(1) + 1 > random) && (random > Distribution.operationsDist.get(2))) {
			operation = selectAritCountOperation();
		}
		if ((Distribution.operationsDist.get(2) + 1 > random) && (random > Distribution.operationsDist.get(3))) {
			operation = selectAritCompOperation();
		}
		if ((Distribution.operationsDist.get(3) + 1 > random) && (random > Distribution.operationsDist.get(4))) {
			operation = selectAritCompOperation();
		}
		if ((Distribution.operationsDist.get(4) + 1 > random) && (random > 0)) {
			operation = addImpliesOperation();
		}
		return operation;
	}
	
	private static String addImpliesOperation() {
		return "implies";
		
	}

	private static String selectBoolAlgebraOperation() {
		String operation = "";
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.boolAlgebraOperationsDist.get(0))) {
			operation = "and";
		}
		if ((Distribution.boolAlgebraOperationsDist.get(0) + 1 > random) && (random > Distribution.boolAlgebraOperationsDist.get(1))) {
			operation = "or";
		}
		if ((Distribution.boolAlgebraOperationsDist.get(1) + 1 > random) && (random > Distribution.boolAlgebraOperationsDist.get(2))) {
			operation = "xor";
		}
		if ((Distribution.boolAlgebraOperationsDist.get(2) + 1 > random) && (random > 0)) {
			operation = "not";
		}
		return operation;
	}
	
	private static String selectEqualityOperation() {
		String operation = "";
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.equalityOperationsDist.get(0))) {
			operation = "==";
		}
		if ((Distribution.equalityOperationsDist.get(0) + 1 > random) && (random > Distribution.equalityOperationsDist.get(1))) {
			operation = "!=";
		}		
		return operation;
	}
	
	private static String selectAritCountOperation() {
		String operation = "";
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.aritCountOperationsDist.get(0))) {
			operation = "+";
		}
		if ((Distribution.aritCountOperationsDist.get(0) + 1 > random) && (random > Distribution.aritCountOperationsDist.get(1))) {
			operation = "-";
		}
		if ((Distribution.aritCountOperationsDist.get(1) + 1 > random) && (random > Distribution.aritCountOperationsDist.get(2))) {
			operation = "*";
		}
		if ((Distribution.aritCountOperationsDist.get(2) + 1 > random) && (random > 0)) {
			operation = "/";
		}
		return operation;
	}
	
	private static String selectAritCompOperation() {
		String operation = "";
		random = generateRandom(1, 100);
		if ((100 + 1 > random) && (random > Distribution.aritCompOperationsDist.get(0))) {
			operation = ">";
		}
		if ((Distribution.aritCompOperationsDist.get(0) + 1 > random) && (random > Distribution.aritCompOperationsDist.get(1))) {
			operation = ">";
		}
		if ((Distribution.aritCompOperationsDist.get(1) + 1 > random) && (random > Distribution.aritCompOperationsDist.get(2))) {
			operation = "=>";
		}
		if ((Distribution.aritCompOperationsDist.get(2) + 1 > random) && (random > 0)) {
			operation = "<=";
		}
		return operation;
	}
	
	private static void appendLine(String line, int indent) {
		try {
			String tabs = "";
			for (int i = 0; i < indent; i++) {
				tabs= tabs + Formating.TAB;
			}
			writer.write(tabs + line + Formating.LINEBREAK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int generateRandom(int min, int max) {			
		Integer random = min + (int)(Math.random() * ((max - min) + 1));
		return random;
	}
	

}
