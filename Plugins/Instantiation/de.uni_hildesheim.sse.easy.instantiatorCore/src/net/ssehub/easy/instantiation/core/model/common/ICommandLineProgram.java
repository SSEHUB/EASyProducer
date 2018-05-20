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
package net.ssehub.easy.instantiation.core.model.common;

import java.io.PrintStream;

/**
 * Interface for separating a command line program with own libraries from instantiator code
 * to enable optional loading of heavy-weight libraries. Instances registered with {@link CommandLineProgramRegistry}
 * just need to implement the interface and register themselves with a common name. Instances to be created by 
 * dynamic classloading via {@link CommandLineProgramRegistry#obainCommandLineProgram(String)} are expected to declare 
 * a public constructor without arguments. Please call always {@link #prepare()} before 
 * {@link #execute(String[], String, PrintStream, PrintStream)} to obtain a fresh instance if needed, e.g.,
 * in case that the command line program maintains a certain state.
 * 
 * @author Holger Eichelberger
 */
public interface ICommandLineProgram {

    /**
     * Executes a command line program.
     * 
     * @param args the program arguments
     * @param workingDirectory the working directory
     * @param stdout the stdout stream
     * @param stderr the stderr stream
     * @return the command line return code
     */
    public int execute(String[] args, String workingDirectory, PrintStream stdout, PrintStream stderr); 

    /**
     * Prepares for execution. 
     * 
     * @return the instance to be executed, may be <b>this</b> or a differnt instance
     */
    public ICommandLineProgram prepare();
    
}
