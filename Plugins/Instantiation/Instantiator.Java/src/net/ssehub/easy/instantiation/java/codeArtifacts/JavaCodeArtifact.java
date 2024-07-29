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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
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
import net.ssehub.easy.instantiation.java.Bundle;
import net.ssehub.easy.instantiation.java.artifacts.JavaFileArtifact;

/**
 * Represents a Java source code artifact (without compiler backend). Can be {@link #disable() disabled for storing}
 * to just enable collecting code fragments that can then be emitted through {@link #toPackage()}, {@link #toImports()}
 * via individual classes or {@link #toString()}.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(JavaCodeArtifactCreator.class)
public class JavaCodeArtifact extends FileArtifact implements IJavaCodeArtifact, IStringValueProvider, Storable {

    static final JavaCodeArtifact EMPTY = new JavaCodeArtifact(); 
    private static final Comparator<IJavaCodeImport> IMPORT_COMPARATOR = 
        (i1, i2) -> i1.getName().compareTo(i2.getName());
    
    private File file;
    private String packageName;
    private List<IJavaCodeImport> imports = new ArrayList<>();
    private List<IJavaCodeElement> elements = new ArrayList<>();
    private String comment;
    private boolean store = true;
    
    /**
     * Creates an instance without file backing.
     */
    public JavaCodeArtifact() {
        super();
        this.store = false;
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
     * Disables storing this artifact as it shall be used only for creating code fragments.
     * 
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeArtifact disable() {
        this.store = false;
        return this;
    }

    /**
     * (Re-)enables storing this artifact.
     * 
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeArtifact enable() {
        this.store = false;
        return this;
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
        } else if (val instanceof FileArtifact) {
            FileArtifact fa = (FileArtifact) val;
            try {
                convertedValue = ArtifactFactory.createArtifact(
                    JavaCodeArtifact.class, fa.getPath().getAbsolutePath(), null);
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(JavaCodeArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
        return convertedValue;
    }    

    @Invisible
    @Conversion
    public static JavaCodeArtifact convert(JavaFileArtifact val) {
        return convert((IFileSystemArtifact) val);
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

    /**
     * Adds a public class with the given name.
     * 
     * @param name the class name
     * @param comment the javadoc comment of the class
     * @return the class
     */
    public JavaCodeClass addClass(String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeClass(name, this, comment));
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

    @Override
    public void store(CodeWriter out) {
        storeHeader(out);
        for (int e = 0; e < elements.size(); e++) {
            if (e > 0) {
                out.println();
            }
            elements.get(e).store(out);
        }
    }

    /**
     * Stores the imports to {@code out}.
     * 
     * @param out the code writer
     */
    protected void storeImports(CodeWriter out) {
        char lastStart = 0;
        for (IJavaCodeImport imp: sortImports()) {
            char start = imp.getName().charAt(0);
            if (lastStart != 0 && lastStart != start) {
                out.println();
            }
            imp.store(out);
            lastStart = start;
        }
    }
    
    /**
     * Returns whether this class has a package declaration.
     * 
     * @return {@code true} for package, {@code false} else
     */
    public boolean hasPackage() {
        return (null != packageName && packageName.length() > 0);
    }
    
    /**
     * Stores the package declaration to {@code out}.
     * 
     * @param out the code writer
     */
    protected void storePackage(CodeWriter out) {
        if (hasPackage()) {
            out.println("package " + packageName + ";");
        }        
    }
    
    /**
     * Stores the header (file comment, package declaration, imports) to {@code out}.
     * 
     * @param out the code writer
     */
    protected void storeHeader(CodeWriter out) {
        storeComment(out);
        if (hasPackage()) {
            storePackage(out);
            out.println();
        }
        if (imports.size() > 0) {
            storeImports(out);
            out.println();
        }
    }
 
    @Invisible
    @Override
    public void store() throws VilException {
        if (store) {
            CodeWriter out = new CodeWriter(file);
            store(out);
            out.close();
        }
    }
    
    /**
     * Just returns the collected imports code fragment.
     * 
     * @return the imports code fragment
     * @see #disable()
     */
    public String toImports() {
        return Storable.getString(o -> storeImports(o));
    }
    
    /**
     * Just returns the collected package code fragment.
     * 
     * @return the package code fragment
     * @see #disable()
     */
    public String toPackage() {
        return Storable.getString(o -> storePackage(o));
    }

    /**
     * Just returns the collected package code fragment.
     * 
     * @return the package code fragment
     * @see #disable()
     */
    public String toHeader() {
        return Storable.getString(o -> storeHeader(o));
    }

    /**
     * Sorts the imports.
     * 
     * @return the sorted imports
     */
    private List<IJavaCodeImport> sortImports() {
        List<IJavaCodeImport> javaStatic = new ArrayList<>();
        List<IJavaCodeImport> restStatic = new ArrayList<>();
        List<IJavaCodeImport> java = new ArrayList<>();
        List<IJavaCodeImport> rest = new ArrayList<>();
        for (IJavaCodeImport i: imports) {
            if (i.getName().startsWith("java")) {
                if (i.isStatic()) {
                    javaStatic.add(i);
                } else {
                    java.add(i);
                }
            } else {
                if (i.isStatic()) {
                    restStatic.add(i);
                } else {
                    rest.add(i);
                }
            }
        }

        Collections.sort(javaStatic, IMPORT_COMPARATOR);
        Collections.sort(restStatic, IMPORT_COMPARATOR);
        Collections.sort(java, IMPORT_COMPARATOR);
        Collections.sort(rest, IMPORT_COMPARATOR);

        List<IJavaCodeImport> result = new ArrayList<IJavaCodeImport>(imports.size());
        result.addAll(java);
        result.addAll(rest);
        result.addAll(javaStatic);
        result.addAll(restStatic);
        return result;
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
    public String validateStaticMethodCall(String name, JavaCodeImportScope scope) {
        int pos = name.lastIndexOf('.');
        if (pos > 0) {
            String[] parts = name.split("\\.");
            pos = parts.length - 2;
            while (pos > 0 && (parts[pos].endsWith(")"))) {
                pos--;
            }
            String type = String.join(".", Arrays.copyOfRange(parts, 0, pos + 1));
            String mName = parts[pos + 1];
            int aPos = mName.indexOf("(");
            if (aPos > 0) {
                mName = mName.substring(0, aPos);
            }
            String qualifiedMethod = type + "." + mName;
            name = String.join(".", Arrays.copyOfRange(parts, pos + 1, parts.length));
            
            if (JavaCodeImportScope.CLASS == scope) {
                IJavaCodeImport imp = findMatchingImport(type, true);
                if (null == imp) {
                    new JavaCodeImport(type, this, false); // added automatically
                }
                aPos = type.lastIndexOf('.');
                String simpleTypeName = type;
                if (pos > 0) {
                    simpleTypeName = type.substring(aPos + 1);
                }
                name = simpleTypeName + "." + name;
            } else if (JavaCodeImportScope.METHOD == scope) {
                // direct static import?
                IJavaCodeImport imp = findMatchingImport(qualifiedMethod, true);
                // is there a wildcard static import?
                if (null == imp) {
                    imp = findMatchingImport(type + ".*", true);
                }
                if (null == imp) {
                    // create direct static import, to be on the safe side no wildcard
                    new JavaCodeImport(qualifiedMethod, this, true); // added automatically
                }
            }
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
        if (!imports.stream().anyMatch(i -> i.isStatic() == imp.isStatic() && i.isWildcard() == imp.isWildcard() 
            && i.getName().equals(imp.getName()))) {
            imports.add(imp);
        }
    }
   
}