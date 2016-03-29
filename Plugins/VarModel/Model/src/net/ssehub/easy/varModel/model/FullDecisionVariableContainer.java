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
package net.ssehub.easy.varModel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * An extended version of the a decision variable container which also supports realizing constraints. 
 * 
 * @author Holger Eichelberger
 */
public class FullDecisionVariableContainer extends BasicDecisionVariableContainer {

    private List<Constraint> realizing = new ArrayList<Constraint>();

    @Override
    public void addConstraint(Constraint constraint, boolean internal) {
        assert null != constraint;
        if (internal) {
            realizing.add(constraint);
        } else {
            super.addConstraint(constraint, internal);
        }
    }
    
    @Override
    public int getRealizingCount() {
        return realizing.size();
    }
    
    @Override
    public Constraint getRealizing(int index) {
        return realizing.get(index);
    }

}
