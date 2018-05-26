/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.values;

/**
 * Adapts the value visitor interface with an empty implementation.
 * 
 * @author Holger Eichelberger
 */
public class ValueVisitorAdapter implements IValueVisitor {

    @Override
    public void visitConstraintValue(ConstraintValue value) {
    }

    @Override
    public void visitEnumValue(EnumValue value) {
    }

    @Override
    public void visitStringValue(StringValue value) {
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
    }

    @Override
    public void visitIntValue(IntValue value) {
    }

    @Override
    public void visitRealValue(RealValue value) {
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
    }

    @Override
    public void visitNullValue(NullValue value) {
    }

    @Override
    public void visitVersionValue(VersionValue value) {
    }

}
