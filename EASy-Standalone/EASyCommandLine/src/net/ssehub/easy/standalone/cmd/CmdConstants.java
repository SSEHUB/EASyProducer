/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.standalone.cmd;

/**
 * Command line constants. System return values: 
 * {@link #SYSTEM_OK} if the execution is ok, {@link #SYSTEM_IO_EXC} if an I/O problem occurred, 
 * {@link #SYSTEM_MODELMGT_EXC} if a model management problem occurred, 
 * {@link #SYSTEM_PERSISTENCE_EXC} if a high-level EASy problem (persistence layer) 
 * occurred, {@link #SYSTEM_VIL_EXC} if a VIL execution problem occurred, {@link #SYSTEM_VERSION_EXC} if a version 
 * number format is wrong, {@link #SYSTEM_NPE_EXC} if an internal null problem occurred, {@link #SYSTEM_SECURITY_EXC}
 * if a security problem occurred or {@link #SYSTEM_INDEX_EXC} if an index access problem occurred (usually not 
 * enough command line arguments).
 * 
 * @author Holger Eichelberger
 */
public class CmdConstants {
    
    public static final int SYSTEM_OK = 0;
    public static final int SYSTEM_IO_EXC = 1;
    public static final int SYSTEM_MODELMGT_EXC = 2;
    public static final int SYSTEM_PERSISTENCE_EXC = 3;
    public static final int SYSTEM_VIL_EXC = 4;
    public static final int SYSTEM_VERSION_EXC = 5;
    public static final int SYSTEM_NPE_EXC = 6;
    public static final int SYSTEM_SECURITY_EXC = 7;
    public static final int SYSTEM_INDEX_EXC = 8;
    public static final int SYSTEM_REASONER_CONFLICT = 10;
    public static final int SYSTEM_NO_REASONER = 11;
    public static final int SYSTEM_NO_PREDECESSOR = 12;
    
}
