/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Part of the {@link VilExecutionThread} to inform other threads when the instantiation was finished or aborted.
 * @author El-Sharkawy
 */
public interface IVilExecutionListener {

    /**
     * VIL execution (instantiation) was aborted through an error.
     * @param plp The {@link PLPInfo}, which should be instantiated and is the source for this error.
     * @param exc The error which lead to the abortion.
     */
    public void vilExecutionAborted(PLPInfo plp, VilException exc);
    
    /**
     * VIL execution (instantiation) was finished.
     * This is usually the case if script execution reached the end of the script, but may also be the case
     * if the user aborted the instantiation.
     * @param plp The {@link PLPInfo}, which was be instantiated
     */
    public void vilExecutionFinished(PLPInfo plp);
}
