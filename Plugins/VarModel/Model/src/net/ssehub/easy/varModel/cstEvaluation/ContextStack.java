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
package net.ssehub.easy.varModel.cstEvaluation;

import java.util.Stack;

import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.varModel.confModel.ConfigurationInitializerRegistry;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Realizes a context stack for evaluating nested self expressions.
 * 
 * @author Holger Eichelberger
 */
class ContextStack {
    
    /**
     * Implements a poolable stack frame. To maximize pool use, we do not differentiate the frames into different 
     * sub-classes her.
     * 
     * @author Holger Eichelberger
     */
    private static class StackFrame {
        
        private EvaluationAccessor ex;
        private ContainerInitializer init;
        private DecisionVariableDeclaration var;
        private int index = -1;
        private String slot;
        private Value self;
        
    }
    
    private static final Pool<StackFrame> POOL = new Pool<StackFrame>(new IPoolManager<StackFrame>() {

        @Override
        public StackFrame create() {
            return new StackFrame();
        }

        @Override
        public void clear(StackFrame instance) {
            instance.ex = null;
            instance.self = null;
            instance.init = null;
            instance.index = -1;
            instance.slot = null;
        }
    });
    
    private Stack<StackFrame> stack = new Stack<StackFrame>();
    private int currentStart = -1;
    
    /**
     * Pushes a context frame for the given expression.
     * 
     * @param ex the expression (will not be released 
     */
    void push(EvaluationAccessor ex) {
        StackFrame frame = POOL.getInstance();
        frame.ex = ex;
        stack.push(frame);
        if (frame != null) {
            currentStart = stack.size() - 1;
        }
    }

    /**
     * Pushes an empty frame.
     */
    void push() {
        stack.push(POOL.getInstance());
    }

    /**
     * Pushes a frame with given initializer.
     * 
     * @param init the initializer
     * @see #push()
     * @see #setContainerIndex(int)
     */
    void push(ContainerInitializer init) {
        push();
        setContainerInitializer(init);
    }
    
    /**
     * Sets the (top-level) variable in the actual frame. Requires {@link #push()} before.
     * 
     * @param var the variable
     */
    void setVariable(DecisionVariableDeclaration var) {
        StackFrame frame = stack.peek();
        frame.var = var;
        frame.self = null; // clear cache 
    }

    /**
     * Sets the container initializer in the actual frame. Requires {@link #push()} before.
     * 
     * @param init the initializer
     * @see #push()
     */
    void setContainerInitializer(ContainerInitializer init) {
        StackFrame frame = stack.peek();
        frame.init = init;
        frame.self = null; // clear cache 
    }

    /**
     * Sets the container index in the actual frame. Requires {@link #push()} before.
     * 
     * @param index the index value
     * @see #push()
     */
    void setContainerIndex(int index) {
        StackFrame frame = stack.peek();
        frame.index = index;
        frame.self = null; // clear cache 
    }

    /**
     * Sets the compound slot in the actual frame. Requires {@link #push()} before.
     * 
     * @param slot the new slot
     * @see #push()
     */
    void setCompoundSlot(String slot) {
        StackFrame frame = stack.peek();
        frame.slot = slot;
        frame.self = null; // clear cache 
    }

    /**
     * Pops a context frame.
     */
    void pop() {
        StackFrame frame = stack.pop();
        if (frame.ex != null) {
            currentStart = stack.size() - 1;
            while (currentStart >= 0 && null == stack.get(currentStart).ex) {
                currentStart--;
            }
        }
        POOL.releaseInstance(frame);
    }
    
    /**
     * Clears the whole stack.
     */
    void clear() {
        while (!stack.isEmpty()) {
            pop();
        }
        currentStart = -1;
    }
    
    /**
     * Returns the value for <i>self</i> in the current context.
     * 
     * @return the expression for self
     */
    Value getSelfValue() {
        Value result = null;
        if (currentStart >= 0) {
            StackFrame top = stack.peek();
            result = top.self; // cached ? 
            if (null == result) {
                EvaluationAccessor ex = stack.get(currentStart).ex;
                EvaluationAccessor seed = ex;
                for (int pos = currentStart + 1, n = stack.size() - 1; pos < n; pos++) {
                    StackFrame frame = stack.get(pos);
                    EvaluationAccessor old = ex;
                    IDecisionVariable var = ex.getVariable();
                    if (frame.index >= 0) {
                        ensureCapacity(var, frame);
                        ex = ContainerElementAccessor.POOL.getInstance().bind(var, frame.index, ex.getContext());
                    } else if (frame.slot != null) {
                        ex = CompoundSlotAccessor.POOL.getInstance().bind(var, frame.slot, ex.getContext());
                    } else if (frame.var != null) {
                        ex = VariableAccessor.POOL.getInstance().bind(frame.var, ex.getContext());
                    }
                    if (old != seed) {
                        old.release();
                    }
                }
                result = ex.getValue();
                top.self = result; // cache
                if (ex != seed) {
                    ex.release();
                }
            }
        }
        return result;
    }

    /**
     * Ensures the capacity of a container variable.
     * 
     * @param var the variable
     * @param frame the stack frame with the access index to ensure fore
     */
    private void ensureCapacity(IDecisionVariable var, StackFrame frame) {
        int index = frame.index;
        ContainerInitializer init = frame.init;
        if (var.getNestedElementsCount() <= index && var instanceof ContainerVariable) {
            ContainerVariable cVar = (ContainerVariable) var;
            while (cVar.getNestedElementsCount() <= index) {
                IDecisionVariable element = null;
                if (null != init) {
                    ConstraintSyntaxTree initEx = init.getExpression(cVar.getNestedElementsCount());
                    try {
                        element = cVar.addNestedElement(initEx.inferDatatype());
                    } catch (CSTSemanticException e) {
                        // ok, element = null
                    }
                } 
                if (null == element) {
                    element = cVar.addNestedElement();
                }
                ConfigurationInitializerRegistry.getInitializer().resolveDefaultValue(element);
            }
        }
    }

}
