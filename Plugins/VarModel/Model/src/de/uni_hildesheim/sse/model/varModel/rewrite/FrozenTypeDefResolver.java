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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;

/**
 * Checks whether all instances of a given {@link DerivedDatatype} are frozen and will remove all constraints,
 * if all instances are frozen or if none exist.
 * @author El-Sharkawy
 *
 */
public class FrozenTypeDefResolver extends AbstractFrozenChecker<DerivedDatatype> {

    private Map<IDatatype, List<AbstractVariable>> allTypeDefDeclarations;

    /**
     * Default constructor of this class.
     * @param config A already initialized {@link Configuration}.
     */
    public FrozenTypeDefResolver(Configuration config) {
        super(config);
        allTypeDefDeclarations = new HashMap<IDatatype, List<AbstractVariable>>();
       
        DeclarationFinder declFinder = new DeclarationFinder(config.getProject(), FilterType.ALL, DerivedDatatype.TYPE);
        List<AbstractVariable> tmpList = declFinder.getVariableDeclarations(VisibilityType.ALL);
        for (int i = 0, n = tmpList.size(); i < n; i++) {
            AbstractVariable decl = tmpList.get(i);
            IDatatype dType = decl.getType();
            List<AbstractVariable> declList = allTypeDefDeclarations.get(dType);
            if (null == declList) {
                declList = new ArrayList<AbstractVariable>();
                allTypeDefDeclarations.put(dType, declList);
            }
            declList.add(decl);
        }
    }
    
    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return DerivedDatatype.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element) {
        DerivedDatatype dType = (DerivedDatatype) element;
        if (typeDefIsFrozen(dType)) {
            dType.setConstraints(null);
        }
        return dType;
    }

    /**
     * Checks whether all instances of the given type are frozen (or if no instance exist).
     * @param type A {@link DerivedDatatype} to test.
     * @return <tt>true</tt> if all instances are frozen or if no instance exist, <tt>false</tt>otherwise.
     */
    private boolean typeDefIsFrozen(IDatatype type) {
        boolean isFrozen = true;
        List<AbstractVariable> allDeclarations = allTypeDefDeclarations.get(type);
        if (null != allDeclarations) {
            for (int i = 0, n = allDeclarations.size(); i < n && isFrozen; i++) {
                AbstractVariable declaration = allDeclarations.get(i);
                isFrozen = isFrozen(declaration);
            }
        }
        
        return isFrozen;
    }
}
