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
package de.uni_hildesheim.sse.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.dslCore.translation.MessageReceiver;
import net.ssehub.easy.varModel.cst.AbstractConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;

/**
 * A checking visitor for illegal compound accesses in declaration of derived data types.
 * 
 * @author Holger Eichelberger
 */
class DerivedTypeMetaCompoundAccessVisitor extends AbstractConstraintTreeVisitor {

    private MessageReceiver receiver;
    private EObject cause;
    private EStructuralFeature feature;
    
    /**
     * Creates a visitor bound to a given message receiver.
     * 
     * @param receiver the receiver
     */
    DerivedTypeMetaCompoundAccessVisitor(MessageReceiver receiver) {
        this.receiver = receiver;
    }
    
    /**
     * Defines the context for emitting errors. Call before visiting.
     * 
     * @param cause the cause
     * @param feature the structural feature
     */
    void setContext(EObject cause, EStructuralFeature feature) {
        this.cause = cause;
        this.feature = feature;
    }
    
    /**
     * Clears this visitor for reuse on the initially given receiver.
     */
    void clear() {
        setContext(null, null);
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        super.visitCompoundAccess(access);
        try {
            IDatatype type = access.getCompoundExpression().inferDatatype();
            if (MetaType.TYPE.isAssignableFrom(type)) {
                receiver.error("Use of type-qualifying slot-access expression on '" 
                    + IvmlDatatypeVisitor.getUnqualifiedType(type)
                    + "' is not allowed here", cause, feature, ErrorCodes.TYPE_CONSISTENCY);
            }
        } catch (CSTSemanticException e) {
            // is ok here, we just check and emit errors
        }
    }
    
}
