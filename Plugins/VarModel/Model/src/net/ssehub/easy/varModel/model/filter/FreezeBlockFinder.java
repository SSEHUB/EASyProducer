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
import java.util.List;

import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.Project;

/**
 * Finds all freeze blocks in a given project.
 * @author El-Sharkawy
 *
 */
public class FreezeBlockFinder extends AbstractFrozenElementsFinder {

    private List<FreezeBlock> freezeBlocks;
    
    /**
     * Default constructor for this class.
     * @param project The project which should be inspected.
     * @param filtertype Specifies whether imports shall be considered or not.
     */
    public FreezeBlockFinder(Project project, FilterType filtertype) {
        super(project, filtertype);
        freezeBlocks = new ArrayList<FreezeBlock>();
        project.accept(this);
    }
    
    /**
     * Returns a list of all freeze blocks in the specified project.
     * @return A maybe empty list of existing freeze blocks.
     */
    public List<FreezeBlock> getFreezeBlocks() {
        return freezeBlocks;
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Store freeze block
        freezeBlocks.add(freeze);
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // this is not a freeze block (may be within)
    }
}
