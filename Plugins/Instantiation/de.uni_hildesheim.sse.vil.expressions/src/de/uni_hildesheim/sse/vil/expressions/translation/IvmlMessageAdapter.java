/*
 * Copyright 2009-2021 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression;

/**
 * Adapts messages, in particular warnings that may be resolved later. Individual class as temporary instances may 
 * be used, e.g., for VTL contents expression resolution.
 * 
 * @author Holger Eichelberger
 */
public class IvmlMessageAdapter {
    
    private Map<VarModelIdentifierExpression, EObject> ivmlWarnings 
        = new HashMap<VarModelIdentifierExpression, EObject>();
    
    /**
     * Notifies the receiver about an unknown expression.
     * 
     * @param vmie the expression
     * @param arg the language element causing the expression
     */
    public void notify(VarModelIdentifierExpression vmie, Constant arg) {
        ivmlWarnings.put(vmie, arg);
    }
    
    /**
     * Notifies the receiver about a resolved expression.
     * 
     * @param ex the resolved expression
     */
    public void resolve(VarModelIdentifierExpression ex) {
        ivmlWarnings.remove(ex);
    }

    /**
     * Processes the IVML warnings not resolved by "function pointers" so far. Clears all collected warnings.
     * 
     * @param warningConsumer consumes the warnings, e.g., to emit warnings
     */
    public void processAndClear(Consumer<Map.Entry<VarModelIdentifierExpression, EObject>> warningConsumer) {
        for (Map.Entry<VarModelIdentifierExpression, EObject> ent : ivmlWarnings.entrySet()) {
            VarModelIdentifierExpression ex = ent.getKey();
            if (!ex.isMarkedAsResolved()) {
                warningConsumer.accept(ent);
            }
        }
        ivmlWarnings.clear();
    }
    

}
