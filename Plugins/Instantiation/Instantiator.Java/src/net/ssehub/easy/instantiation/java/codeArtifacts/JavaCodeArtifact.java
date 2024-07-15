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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a Java source code artifact (without compiler backend).
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(JavaCodeArtifactCreator.class)
public class JavaCodeArtifact extends FileArtifact implements IJavaCodeArtifact, IStringValueProvider {

    static final JavaCodeArtifact EMPTY = new JavaCodeArtifact(); 
    
    private File file;
    private String packageName;
    private List<JavaCodeImport> imports = new ArrayList<>();
    private List<IJavaCodeElement> elements = new ArrayList<>();
    
    /**
     * Creates an instance.
     */
    protected JavaCodeArtifact() {
        super();
    }
    
    /**
     * Creates an instance for a given file/artifact model.
     * 
     * @param file the file
     * @param model the artifact model instance
     */
    protected JavaCodeArtifact(File file, ArtifactModel model) {
        super(file, model);
        this.file = file;
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return ArtifactFactory.createArtifact(JavaCodeArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static JavaCodeArtifact convert(IFileSystemArtifact val) {
        JavaCodeArtifact convertedValue = null;
        if (val instanceof JavaCodeArtifact) {
            convertedValue = (JavaCodeArtifact) val;
        }
        return convertedValue;
    }    

    /**
     * Adds a public class with the given name.
     * 
     * @param name the class name
     * @return the class
     */
    public JavaCodeClass addClass(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeClass(name, this));
    }
    
    /*public JavaCodeJavadocComment setJavadocComment(String comment) {
        return new JavaCodeJavadocComment(comment);
    }*/ // --> plain comment

    public JavaCodeImport addImport(String imp) {
        return IJavaCodeElement.add(elements, new JavaCodeImport(imp, this));
    }
    
    @Invisible
    @Override
    public String validateType(String type) {
        return type; // TODO -> imports
    }
    
    /**
     * Sets the (optional) package name.
     * 
     * @param packageName the package name
     */
    @OperationMeta(name = {"package"})
    public void setPackage(String packageName) {
        this.packageName = packageName;
    }
    
    /**
     * Returns the (optional) package name.
     * 
     * @return the package name
     */
    public String getPackage() {
        return packageName;
    }

    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void delete() throws VilException {
        super.delete();
    }
    
    /**
     * Adds text and indents it.
     * 
     * @param text the text
     */
    public void add(String text) {
        elements.add(new JavaCodeText(text, true));
    }
    
    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text) {
        elements.add(new JavaCodeText(text, false));
    }
    
    @Invisible
    @Override
    public void store() throws VilException {
        CodeWriter out = new CodeWriter(file);
        // TODO comment
        if (null != packageName && packageName.length() > 0) {
            out.println("package " + packageName + ";");
            out.println();
        }
        if (imports.size() > 0) {
            for (JavaCodeImport imp: imports) {
                imp.store(out);
            }
            out.println();
        }
        for (int e = 0; e < elements.size(); e++) {
            if (e > 0) {
                out.println();
            }
            elements.get(e).store(out);
        }
        out.close();
    }
    
}
