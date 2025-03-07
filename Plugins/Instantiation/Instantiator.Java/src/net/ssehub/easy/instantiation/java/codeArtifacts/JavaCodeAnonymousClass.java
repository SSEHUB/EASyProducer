/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

public class JavaCodeAnonymousClass extends JavaCodeClass {

    private JavaCodeArgumentListExpression args;
    
    JavaCodeAnonymousClass(String name, JavaCodeClass enclosing) {
        super(name, enclosing);
        args = new JavaCodeArgumentListExpression(this);
    }
    
    static JavaCodeExpression toExpression(JavaCodeAnonymousClass cls) {
        return new JavaCodeExpression(null) {

            @Override
            public void store(CodeWriter out) {
                cls.store(out);
            }
            
        };
    }
    
    /**
     * Adds an expression as call argument.
     * 
     * @param ex the expression, may be <b>null</b> for none
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeAnonymousClass addArgument(JavaCodeExpression ex) {
        args.addArgument(ex);
        return this;
    }
    
    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.print("new ");
        out.print(getName());
        storeGenerics(out);
        out.print("(");
        args.store(out);
        out.print(")");
        storeBlock(out);
    }

}
