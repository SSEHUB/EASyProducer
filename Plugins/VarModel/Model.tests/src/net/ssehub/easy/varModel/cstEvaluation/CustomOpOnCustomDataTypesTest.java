/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Some further tests drawn by practical examples from QM.
 * 
 * @author Holger Eichelberger
 */
public class CustomOpOnCustomDataTypesTest {

    private static final boolean DEBUG = false;
    
    private DecisionVariableDeclaration intType;
    private DecisionVariableDeclaration stringType;
    private DecisionVariableDeclaration tuples1;
    private DecisionVariableDeclaration tuples2;
    private Configuration cfg;
    private ConstraintSyntaxTree expr;
    private EvaluationVisitor visitor;

    /**
     * Creates the field type type.
     * 
     * @param prj the parent project
     * @return the field type type
     */
    private Compound createFieldType(Project prj) {
        Compound fieldType = new Compound("FieldType", prj);
        prj.add(fieldType);
        DecisionVariableDeclaration name = new DecisionVariableDeclaration("name", StringType.TYPE, fieldType);
        fieldType.add(name);
        return fieldType;
    }

    /**
     * Creates the field type.
     * 
     * @param prj the parent project
     * @param fieldType the field type type
     * @return the field type
     */
    private Compound createFieldDef(Project prj, Compound fieldType) {
        Compound field = new Compound("Field", prj);
        prj.add(field);
        DecisionVariableDeclaration name = new DecisionVariableDeclaration("name", StringType.TYPE, field);
        field.add(name);
        Reference typeRef = new Reference("typeRef", fieldType, prj);
        DecisionVariableDeclaration type = new DecisionVariableDeclaration("type", typeRef, field);
        field.add(type);
        DecisionVariableDeclaration keyPart = new DecisionVariableDeclaration("keyPart", BooleanType.TYPE, field);
        field.add(keyPart);
        return field;
    }

    /**
     * Creates the tuple type.
     * 
     * @param prj the parent project
     * @param fieldsType the fields type
     * @return the tuple type
     */
    private Compound createTuple(Project prj, IDatatype fieldsType) {
        Compound tupleType = new Compound("Tuple", prj);
        prj.add(tupleType);
        DecisionVariableDeclaration name = new DecisionVariableDeclaration("name", StringType.TYPE, tupleType);
        tupleType.add(name);
        DecisionVariableDeclaration fields = new DecisionVariableDeclaration("fields", fieldsType, tupleType);
        tupleType.add(fields);
        return tupleType;
    }

    /**
     * Creates the collect field types operation.
     * 
     * @param prj the parent project
     * @param tuples the tuples type
     * @param tuple the tuple type
     * @param field the field type
     * @param fieldType the fieldType type
     * @throws CSTSemanticException in case of constraint syntax errors
     */
    private void createCollectFieldTypesOperation(Project prj, IDatatype tuples, Compound tuple, Compound field, 
        Compound fieldType) 
        throws CSTSemanticException {
        OperationDefinition collectFieldTypes = new OperationDefinition(prj);
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[1];
        params[0] = new DecisionVariableDeclaration("tuples", tuples, collectFieldTypes);

        DecisionVariableDeclaration cDecl1 = new DecisionVariableDeclaration("tuple", tuple, collectFieldTypes);
        DecisionVariableDeclaration fDecl1 = new DecisionVariableDeclaration("field", field, collectFieldTypes);
        ConstraintSyntaxTree fExpr = new CompoundAccess(new Variable(fDecl1), "type");
        fExpr.inferDatatype();
        ConstraintSyntaxTree fCollectExpr = new ContainerOperationCall(
            new CompoundAccess(new Variable(cDecl1), "fields"), "collect", fExpr, fDecl1);
        fCollectExpr.inferDatatype();
        ConstraintSyntaxTree expr = new ContainerOperationCall(
            new Variable(params[0]), "collect", fCollectExpr, cDecl1);
        expr.inferDatatype();
        expr = new OCLFeatureCall(expr, "flatten", (ConstraintSyntaxTree[]) null);
        IDatatype exprType = expr.inferDatatype();
        
        IDatatype resultType = new Sequence("fieldTypeRefSeq", 
            new Reference("fieldTypeRef", fieldType, collectFieldTypes), collectFieldTypes);
        Assert.assertTrue(resultType.isAssignableFrom(exprType));
        collectFieldTypes.setOperation(new CustomOperation(resultType, 
            "collectFieldTypes", prj.getType(), expr, params));
        prj.add(collectFieldTypes);
    }
    
    /**
     * Creates the field check operation.
     * 
     * @param prj the parent project
     * @param tuples the tuples type
     * @throws CSTSemanticException in case of constraint syntax errors
     */
    private void createFieldCheckOperation(Project prj, IDatatype tuples) throws CSTSemanticException {
        OperationDefinition collectFieldTypes = new OperationDefinition(prj);
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[2];
        params[0] = new DecisionVariableDeclaration("fTuples", tuples, collectFieldTypes);
        params[1] = new DecisionVariableDeclaration("aTuples", tuples, collectFieldTypes);

        ConstraintSyntaxTree cf0 = new OCLFeatureCall(new Variable(params[0]), "collectFieldTypes", prj);
        cf0.inferDatatype();
        ConstraintSyntaxTree cf1 = new OCLFeatureCall(new Variable(params[1]), "collectFieldTypes", prj);
        cf1.inferDatatype();
        ConstraintSyntaxTree expr = new OCLFeatureCall(cf0, "==", cf1);
        IDatatype exprType = expr.inferDatatype();

        IDatatype resultType = BooleanType.TYPE;
        Assert.assertTrue(resultType.isAssignableFrom(exprType));
    
        collectFieldTypes.setOperation(new CustomOperation(resultType, "fieldCheck", prj.getType(), expr, params));
        prj.add(collectFieldTypes);
    }
    
    /**
     * Sets the value of a variable.
     * 
     * @param cfg the configuration
     * @param varDecl the variable declaration
     * @param value the value
     * 
     * @throws ConfigurationException in case of configuration problems
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems
     */
    private void setValue(Configuration cfg, AbstractVariable varDecl, Object[] value) 
        throws ConfigurationException, ValueDoesNotMatchTypeException {
        cfg.getDecision(varDecl).setValue(ValueFactory.createValue(varDecl.getType(), value), AssignmentState.ASSIGNED);
    }
    
    /**
     * Asserts that the evaluation visitor result is boolean and <code>expected</code>.
     * 
     * @param visitor the evaluation visitor
     * @param expected the expected value
     */
    private void assertEvalVisitorBoolResult(EvaluationVisitor visitor, boolean expected) {
        Assert.assertTrue("no result calculated", visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(expected, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
    }
    
    /**
     * Creates common parts, which are used in all tests.
     * 
     * @throws CSTSemanticException in case of CST problems (shall not occur)
     * @throws ConfigurationException in case of configuration problems (shall not occur)
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems (shall not occur)
     */
    @Before
    public void setUp() throws CSTSemanticException, ConfigurationException, ValueDoesNotMatchTypeException {
        Project prj = new Project("KeyPartTest");
        Compound fieldType = createFieldType(prj);
        Compound field = createFieldDef(prj, fieldType);
        DerivedDatatype fields = new DerivedDatatype("Fields", new Sequence("seqField", field, prj), prj);
        prj.add(fields);
        Compound tuple = createTuple(prj, fields);
        DerivedDatatype tuples = new DerivedDatatype("Tuples", new Sequence("seqTuple", tuple, prj), prj);
        prj.add(tuples);
        
        createCollectFieldTypesOperation(prj, tuples, tuple, field, fieldType);
        createFieldCheckOperation(prj, tuples);
        
        intType = new DecisionVariableDeclaration("intType", fieldType, prj);
        prj.add(intType);
        stringType = new DecisionVariableDeclaration("stringType", fieldType, prj);
        prj.add(stringType);
        tuples1 = new DecisionVariableDeclaration("output", tuples, prj);
        prj.add(tuples1);
        tuples2 = new DecisionVariableDeclaration("aOutput", tuples, prj);
        prj.add(tuples2);
        if (DEBUG) {
            System.out.println(StringProvider.toIvmlString(prj));
        }
        
        expr = new OCLFeatureCall(new Variable(tuples1), "fieldCheck", prj, new Variable(tuples2));
        expr.inferDatatype();
        if (DEBUG) {
            System.out.println(StringProvider.toIvmlString(expr));
        }
        
        cfg = new Configuration(prj);
        setValue(cfg, intType, new Object[]{"name", "INTEGER"});
        setValue(cfg, stringType, new Object[]{"name", "STRING"});
        visitor = new EvaluationVisitor();
        visitor.init(cfg, AssignmentState.DEFAULT, false, null);
    }

    /**
     * Performs a test with both tuples empty.
     * 
     * @throws ConfigurationException in case of configuration problems (shall not occur)
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems (shall not occur)
     */
    @Test
    public void bothEmptyTest() throws ConfigurationException, ValueDoesNotMatchTypeException {
        setValue(cfg, tuples1, ValueFactory.EMPTY);
        setValue(cfg, tuples2, ValueFactory.EMPTY);
        visitor.visit(expr);
        assertEvalVisitorBoolResult(visitor, true);
        visitor.clearResult();
    }
    
    /**
     * Performs a test with both tuples empty.
     * 
     * @throws ConfigurationException in case of configuration problems (shall not occur)
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems (shall not occur)
     */
    @Test
    public void oneEmptyTest() throws ConfigurationException, ValueDoesNotMatchTypeException {
        setValue(cfg, tuples1, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", intType, "keyPart", "true"}                
            }}
            });
        setValue(cfg, tuples2, ValueFactory.EMPTY);
        visitor.visit(expr);
        assertEvalVisitorBoolResult(visitor, false);
        visitor.clearResult();
    }

    /**
     * Performs a test with both tuples empty.
     * 
     * @throws ConfigurationException in case of configuration problems (shall not occur)
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems (shall not occur)
     */
    @Test
    public void bothIdenticalTest() throws ConfigurationException, ValueDoesNotMatchTypeException {
        // both identical -> true
        setValue(cfg, tuples1, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", intType, "keyPart", "true"}                
            }}
            });
        setValue(cfg, tuples2, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", intType, "keyPart", "true"}                
            }}
            });
        visitor.visit(expr);
        assertEvalVisitorBoolResult(visitor, true);
        visitor.clearResult();
    }

    /**
     * Performs a test with both tuples empty.
     * 
     * @throws ConfigurationException in case of configuration problems (shall not occur)
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems (shall not occur)
     */
    @Test
    public void bothDifferInKeyPartOnlyTest() throws ConfigurationException, ValueDoesNotMatchTypeException {
        setValue(cfg, tuples1, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", intType, "keyPart", "true"}                
            }}
            });
        setValue(cfg, tuples2, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", intType, "keyPart", "false"}                
            }}
            });
        visitor.visit(expr);
        assertEvalVisitorBoolResult(visitor, true);
        visitor.clearResult();
    }

    /**
     * Performs a test with both tuples empty.
     * 
     * @throws ConfigurationException in case of configuration problems (shall not occur)
     * @throws ValueDoesNotMatchTypeException in case of value assignment problems (shall not occur)
     */
    @Test
    public void bothDifferInTypeTest() throws ConfigurationException, ValueDoesNotMatchTypeException {
        setValue(cfg, tuples1, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", intType, "keyPart", "true"}                
            }}
            });
        setValue(cfg, tuples2, new Object[]{
            new Object[]{"name", "t1", "fields", new Object[]{
                new Object[]{"name", "f1", "type", stringType, "keyPart", "true"}                
            }}
            });
        visitor.visit(expr);
        assertEvalVisitorBoolResult(visitor, false);
        visitor.clearResult();
    }
    
}
