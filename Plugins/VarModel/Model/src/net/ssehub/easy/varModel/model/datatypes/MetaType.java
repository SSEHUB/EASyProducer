/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.datatypes;

import net.ssehub.easy.varModel.model.datatypes.Operation.ReturnTypeMode;

/**
 * Implements a data type which represents types (as result of type operations).
 * 
 * @author Holger Eichelberger
 */
public class MetaType extends BasisDatatype {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    public static final IDatatype TYPE = AnyType.META_TYPE;

    // we assume normalized operations to OCL -> simplifies reasoner translation
    public static final Operation EQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation NOTEQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation NOTEQUALS_ALIAS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);
    public static final Operation ALL_INSTANCES
        = new Operation(AnyType.SET_TYPE, ReturnTypeMode.IMMEDIATE_OPERAND_COLLECTION, OclKeyWords.ALL_INSTANCES, TYPE);

    // checkstyle: resume declaration order check

    static {
        AnyType.META_TYPE.setDelegate(new MetaType());
        AnyType.META_TYPE.addOperation(EQUALS);
        AnyType.META_TYPE.addOperation(NOTEQUALS);
        AnyType.META_TYPE.addOperation(NOTEQUALS_ALIAS);
        AnyType.META_TYPE.addOperation(ALL_INSTANCES);
    }
    
    /**
     * Creates the singleton instance of this class.
     */
    private MetaType() {
        super("MetaType", AnyType.META_TYPE);
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitMetaType(this);
    }
    
}
