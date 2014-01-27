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

package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

/**
 * Defines a rule block, i.e., a set of rule elements.
 * 
 * @author Holger Eichelberger
 */
public abstract class RuleBlock extends ProjectElement implements IRuleBlock {

    private IRuleElement[] body;

    /**
     * Creates a new rule block.
     * 
     * @param name the name of the block (may be <b>null</b> if none is required)
     * @param body the body
     */
    protected RuleBlock(String name, IRuleElement[] body) {
        super(name);
        this.body = body;
    }
    
    @Override
    public int getBodyElementCount() {
        return null == body ? 0 : body.length;
    }
    
    @Override
    public IRuleElement getBodyElement(int index) {
        if (null == body) {
            throw new IndexOutOfBoundsException();
        }
        return body[index];
    }
    
    /**
     * Appends an element to this body.
     * 
     * @param elt the element to be appended
     */
    protected void append(IRuleElement elt) {
        if (null != elt) {
            if (null == body) {
                body = new IRuleElement[1];
            } else {
                IRuleElement[] tmp = new IRuleElement[body.length + 1];
                System.arraycopy(body, 0, tmp, 0, body.length);
                body = tmp;
            }
            body[body.length - 1] = elt;
        }
    }

}
