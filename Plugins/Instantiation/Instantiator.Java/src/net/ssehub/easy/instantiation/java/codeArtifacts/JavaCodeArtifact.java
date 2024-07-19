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
import java.util.Arrays;
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
    private List<IJavaCodeImport> imports = new ArrayList<>();
    private List<IJavaCodeElement> elements = new ArrayList<>();
    private String comment;
    
    /**
     * Creates an instance. [public for testing]
     */
    public JavaCodeArtifact() {
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
    
    /**
     * Sets the (optional) package name.
     * 
     * @param packageName the package name
     * @return <b>this</b> (for chaining)
     */
    @OperationMeta(name = {"package"})
    public JavaCodeArtifact setPackage(String packageName) {
        this.packageName = packageName;
        return this;
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
        elements.add(new JavaCodeText(text, true, true));
    }
    
    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text) {
        elements.add(new JavaCodeText(text, false, true));
    }
    
    /**
     * Sets an artifact wide lead-in comment.
     * 
     * @param comment the comment
     * @return <b>this</b> (for chaining)
     */
    @OperationMeta(name = {"comment"})
    public JavaCodeArtifact setComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Stores the artifact comment.
     * 
     * @param out the code writer
     */
    private void storeComment(CodeWriter out) {
        if (null != comment) {
            String cmt = comment;
            cmt = cmt.replace("\\n", "\n").replace("\\r", "\r");
            if (cmt.length() != comment.length()) { // multiline
                if (!cmt.trim().startsWith("/*")) {
                    String[] lines = cmt.split("\\r?\\n|\\r");
                    out.println("/*");
                    Arrays.stream(lines).forEach(s -> out.println(" * " + s));
                    out.println(" */");
                }
            } else {
                if (!cmt.trim().startsWith("//")) {
                    out.println("// " + cmt);
                }
            }
        }
    }
    
    @Invisible
    @Override
    public void store() throws VilException {
        CodeWriter out = new CodeWriter(file);
        storeComment(out);
        if (null != packageName && packageName.length() > 0) {
            out.println("package " + packageName + ";");
            out.println();
        }
        if (imports.size() > 0) {
            for (IJavaCodeImport imp: imports) {
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

    @Invisible
    @Override
    public void validateType(IJavaCodeTypeSpecification type) {
        String typeName = type.getOutputTypeName();
        int pos = typeName.lastIndexOf('.');
        if (pos > 0) {
            if (null == findMatchingImport(typeName, false)) {
                new JavaCodeImport(typeName, this); // added automatically
            }
            type.setOutputTypeName(typeName.substring(pos + 1));
        }
        /*CodeToStringWriter tmp = new CodeToStringWriter();
        tmp.print("VALIDATE: ");
        type.store(tmp);
        System.out.println(tmp.getString()+" "+type.getGenericCount());*/
    }
    
    @Invisible
    @Override
    public String validateStaticMethodCall(String name) {
        int pos = name.lastIndexOf('.');
        if (pos > 0) {
            // direct static import?
            IJavaCodeImport imp = findMatchingImport(name, true);
            // wildcard static import
            if (null == imp) {
                imp = findMatchingImport(name.substring(0, pos) + "*", true);
            }
            if (null == imp) {
                // create direct static import, to be on the safe side no wildcard
                new JavaCodeImport(name, this, true); // added automatically
            }
            name = name.substring(pos);
        }
        return name;
    }

    /**
     * Tries to find an import matching {@code imp}. {@code imp} may be a simple or a qualified name. 
     * 
     * @param imp the import
     * @param isStatic shall we look for a static import
     * @return the matching import, {@link JavaCodeImport#DEFAULT} for {@code java.lang} or <b>null</b> for no match
     */
    private IJavaCodeImport findMatchingImport(String imp, boolean isStatic) {
        IJavaCodeImport result = null;
        String impPrefix = "";
        int pos = imp.lastIndexOf('.');
        if (pos > 0) {
            impPrefix = imp.substring(0, pos);
        }
        if (JavaCodeImport.DEFAULT.getName().equals(impPrefix)) {
            result = JavaCodeImport.DEFAULT;
        } else {
            for (IJavaCodeImport i : imports) {
                if (i.isStatic() == isStatic) {
                    String iName = i.getName();
                    boolean found = false;
                    if (i.isWildcard()) {
                        found = impPrefix.equals(iName.substring(0, iName.length() - 1));
                    } else {
                        found = iName.equals(imp);
                    }
                    if (found) {
                        result = i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Explicitly adds an import to this artifact.
     * 
     * @param imp the import (may be a wildcard), static can be set on the result
     * @return the existing or new code import
     */
    public JavaCodeImport addImport(String imp) {
        JavaCodeImport result = null;
        IJavaCodeImport found = findMatchingImport(imp, false);
        if (null == found) {
            result = new JavaCodeImport(imp, this);
        } else if (found instanceof JavaCodeImport) {
            result = (JavaCodeImport) found;
        }
        return result;
    }

    @Invisible
    @Override
    public void registerImport(IJavaCodeImport imp) {
        imports.add(imp);
    }
    
}