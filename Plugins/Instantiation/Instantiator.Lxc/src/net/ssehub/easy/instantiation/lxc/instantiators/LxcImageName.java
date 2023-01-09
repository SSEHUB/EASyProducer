/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.lxc.instantiators;

import java.util.Map;

import au.com.jcloud.lxd.model.Image;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to obtain the name of a docker image.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcImageName")
public class LxcImageName extends AbstractLxcInstantiator {

    // checkstyle: stop exception type check

    /**
     * Returns the name of a LXC image.
     * 
     * @param fingerprint the fingerprint of the image to return the name for
     * @return the name, if not found <b>null</b> (undefined)
     * @throws VilException
     *             in case of artifact / parameter problems
     */
    public static String lxcImageName(String fingerprint) throws VilException {
        String name = null;
        try {
            Map<String, Image> imgs = createClient().loadImageMap();

            if (imgs.containsKey(fingerprint)) {
                name = imgs.get(fingerprint).getAliases().toString().replaceAll("[\\]\\[\\(\\)]", "");
            }
        } catch (Throwable e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        }
        return name;
    }

    // checkstyle: resume exception type check

}
