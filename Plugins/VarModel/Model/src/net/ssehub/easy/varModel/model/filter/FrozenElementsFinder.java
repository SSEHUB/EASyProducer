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
package net.ssehub.easy.varModel.model.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.Project;

/**
 * This class searches through a project (and its imports) for finding frozen elements.
 * @author El-Sharkawy
 *
 */
public class FrozenElementsFinder extends AbstractFrozenElementsFinder {
    
    private List<IFreezable> frozenElements;
    private Map<IFreezable, FreezeBlock> frozenMap;
    
    /**
     * Default constructor for this class.
     * @param project The project which should be inspected.
     * @param filtertype Specifies whether imports shall be considered or not.
     */
    public FrozenElementsFinder(Project project, FilterType filtertype) {
        super(project, filtertype);
        frozenElements = new ArrayList<IFreezable>();
        frozenMap = new HashMap<IFreezable, FreezeBlock>();
        project.accept(this);
    }
    
    /**
     * Returns all discovered frozen elements.
     * @return All frozen elements.
     */
    public List<IFreezable> getFrozenElements() {
        return frozenElements;
    }
    
    /**
     * Returns the freeze block to the given <code>freezable</code>.
     * 
     * @param freezable the freezable
     * @return the freeze block (if also in {@link #getFrozenElements()}, <b>null</b> else)
     */
    public FreezeBlock getFreezeBlock(IFreezable freezable) {
        return frozenMap.get(freezable);
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Save frozen elements.
        for (int i = 0; i < freeze.getFreezableCount(); i++) {
            IFreezable freezable = freeze.getFreezable(i);
            frozenElements.add(freezable);
            frozenMap.put(freezable, freeze);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // if used within a freeze block, this will be handled by visitFreezeBlock
    }
    
}
