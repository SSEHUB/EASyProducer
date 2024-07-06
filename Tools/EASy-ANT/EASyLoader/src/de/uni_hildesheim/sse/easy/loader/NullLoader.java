/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.loader;

/**
 * A loader that does nothing. May be helpful in testing when some common mechanisms rely on an EASy loader
 * while the test wants to setup a specific loading sequence, a subset, etc.
 * 
 * @author Holger Eichelberger
 */
public class NullLoader implements ILoader {

    @Override
    public void startup() {
    }

    @Override
    public void shutdown() {
    }
    
    @Override
    public void setVerbose(boolean verbose) {
    }

    @Override
    public void setLoader(ClassLoader loader) {
    }

}
