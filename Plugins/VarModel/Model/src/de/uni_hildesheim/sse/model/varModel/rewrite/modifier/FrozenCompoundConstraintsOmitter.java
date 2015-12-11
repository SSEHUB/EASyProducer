///*
// * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// * 
// *   http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
package de.uni_hildesheim.sse.model.varModel.rewrite.modifier;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import de.uni_hildesheim.sse.model.confModel.Configuration;
//import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
//import de.uni_hildesheim.sse.model.varModel.Constraint;
//import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
//import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
//import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
//import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
//import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
//import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
//import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
//
//public class FrozenCompoundConstraintsOmitter extends AbstractFrozenChecker<Compound> {
//
//    private Map<IDatatype, List<AbstractVariable>> allDeclarations;
//    
//    public FrozenCompoundConstraintsOmitter(Configuration config) {
//        super(config);
//        
//        allDeclarations = new HashMap<IDatatype, List<AbstractVariable>>();
//        
//        DeclarationFinder declFinder = new DeclarationFinder(config.getProject(), FilterType.ALL, null);
//        List<AbstractVariable> tmpList = declFinder.getVariableDeclarations(VisibilityType.ALL);
//        for (int i = 0, n = tmpList.size(); i < n; i++) {
//            AbstractVariable decl = tmpList.get(i);
//            addDeclaration(decl);
//        }
//    }
//
//    private void addDeclaration(AbstractVariable decl) {
//        IDatatype type = decl.getType();
//        List<AbstractVariable> declList = allDeclarations.get(type);
//        if (null == declList) {
//            declList = new ArrayList<AbstractVariable>();
//            allDeclarations.put(type, declList);
//        }
//        declList.add(decl);
//    }
//
//    @Override
//    public Class<? extends ContainableModelElement> getModifyingModelClass() {
//        return Compound.class;
//    }
//
//    @Override
//    public ContainableModelElement handleModelElement(ContainableModelElement element) {
//        Compound cType = (Compound) element;
//        
//        for (int i = 0, n = cType.getConstraintsCount(); i < n; i++) {
//            Constraint constraint = cType.getConstraint(i);
//            DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(constraint.getConsSyntax());
//            Set<AbstractVariable> declarations = finder.getDeclarations();
//            boolean allFrozen = declarations.isEmpty();
//            if (!allFrozen) {
//                allFrozen = true;
//                Iterator<AbstractVariable> itr = declarations.iterator();
//                while (itr.hasNext() && allFrozen) {
//                    allFrozen = isFrozen(itr.next());
//                }
//            }
//            
//            if (allFrozen) {
//                cType.removeConstraint(constraint);
//            }
//        }
//        return cType;
//    }
//
//}
