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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
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
    private Set<String> importExclusions;
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
     * Creates an instance without file backing.
     * 
     * @return the instance
     */
    public static JavaCodeArtifact create() {
        return new JavaCodeArtifact();
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
                fa.setEnableContentStore(false); // decisions are made based on the original artifact
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(JavaCodeArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
        return convertedValue;
    } 
    
    /**
     * Conversion operation.
     * 
     * @param path
     *            the path to be converted
     * @return the converted value
     * @throws VilException
     *             in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static JavaCodeArtifact convert(Path path) throws VilException {
        return ArtifactFactory.createArtifact(JavaCodeArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }

    @Invisible
    @Conversion
    public static JavaCodeArtifact convert(JavaFileArtifact val) {
        return convert((IFileSystemArtifact) val);
    }
    
    @Override
    public Object determineActualValue(Object object) {
        Object result = object;
        if (!(object instanceof JavaCodeArtifact)) { // secondary artifact conversion, allow for VTL parameter assng.
            if (object instanceof FileArtifact) {
                result = convert((IFileSystemArtifact) object);
            }
        }
        return super.determineActualValue(result);
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

    /**
     * Adds a public enum with the given name.
     * 
     * @param name the enum name
     * @return the enum
     */
    public JavaCodeEnum addEnum(String name) {
        return IJavaCodeElement.add(elements, new JavaCodeEnum(name, this));
    }

    /**
     * Adds a public enum with the given name.
     * 
     * @param name the enum name
     * @param comment the javadoc comment of the class
     * @return the enum
     */
    public JavaCodeEnum addEnum(String name, String comment) {
        return IJavaCodeElement.add(elements, new JavaCodeEnum(name, this, comment));
    }
    
    /**
     * Sets the (optional) package name.
     * 
     * @param packageName the package name, ignored if <b>null</b> or empty
     * @return <b>this</b> (for chaining)
     */
    public JavaCodeArtifact setPackage(String packageName) {
        this.packageName = packageName;
        return this;
    }
    
    /**
     * Returns the (optional) package name.
     * 
     * @return the package name, may be <b>null</b> or empty for none
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
     * @param indent {@code true} if {@code text} shall be indented, {@code false} if the text is preformatted
     */
    public void addRaw(String text, boolean indent) {
        elements.add(new JavaCodeText(text, indent, true));
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
    
    @Override
    public int getElementCount() {
        int result = 0;
        if (null != comment) {
            result += 1 + StringUtils.countMatches(comment, "\\n");
        }
        if (hasPackage()) {
            result += 1;
        }
        if (!imports.isEmpty()) {
            result += imports.size() + 1;
        }
        for (int e = 0; e < elements.size(); e++) {
            result += elements.get(e).getElementCount();
        }
        result += Math.max(0, elements.size() - 1);
        return result;
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
    
    @Invisible
    @Override
    public boolean enableAutoStore() {
        return false;
    }
    
    @Invisible
    @Override
    public boolean enableContentStore() {
        return false;
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
    
    private String removeNonTypeChars(String text) {
        return text.replace("\n", "").replace("\r", "").replace(" ", "");
    }

    @Invisible
    @Override
    public void validateType(IJavaCodeTypeSpecification type) {
        String typeName = type.getOutputTypeName();
        boolean varArg = false;
        if (typeName.endsWith(IJavaCodeTypeSpecification.VARARG_TYPE_POSTFIX)) {
            varArg = true;
            typeName = typeName.substring(0, typeName.length() 
                - IJavaCodeTypeSpecification.VARARG_TYPE_POSTFIX.length());
        }
        String prefix = "";
        String marker = " super ";
        int pos = typeName.lastIndexOf(marker);
        if (pos < 0) {
            marker = " extends ";
            pos = typeName.lastIndexOf(marker);
        }
        if (pos > 0) {
            pos += marker.length();
            prefix = typeName.substring(0, pos);
            typeName = typeName.substring(pos);
        }
        typeName = removeNonTypeChars(typeName); // sometimes there is a pre-formatted input, indended (?)
        String plainTypeName = typeName;
        pos = typeName.lastIndexOf('.');
        if (pos > 0) {
            String simpleTypeName = typeName.substring(pos + 1);
            JavaCodeClass cls = JavaCodeClass.getParentCodeClass(type);
            String simpleClsName = cls != null ? cls.getName() : "";
            if (!simpleClsName.equals(simpleTypeName) && !isExcludedImport(typeName)) { 
                // do not import if class name overlaps import or import is excluded
                String newOutputTypeName = prefix + simpleTypeName;
                IJavaCodeImport match = findMatchingImport(typeName, false);
                if (null == match) {
                    new JavaCodeImport(typeName, this); // added automatically
                } else {
                    if (!plainTypeName.equals(match.getName())) { // exists but differs, keep FQN
                        newOutputTypeName = plainTypeName;
                    }
                }
                type.setOutputTypeName(newOutputTypeName);
                type.setVarArg(varArg);
            }
        }
    }
    
    private static boolean seemsToBeClass(String name) {
        return name.length() > 0 && Character.isUpperCase(name.charAt(0));
    }
    
    @Invisible
    @Override
    public String validateStaticName(String name, JavaCodeImportScope scope) {
        String origName = name;
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
            if (scope == JavaCodeImportScope.CLASS_NO_METHOD) {
                type = type + "." + name;
            }
            if (JavaCodeImportScope.CLASS == scope || JavaCodeImportScope.METHOD_CLASS_IMPORT == scope 
                || JavaCodeImportScope.CLASS_NO_METHOD == scope) {
                if (isExcludedImport(type)) {
                    name = origName;
                } else {
                    IJavaCodeImport imp = findMatchingImport(type, true);
                    if (null == imp && type.contains(".")) { // no local imports
                        new JavaCodeImport(type, this, false); // added automatically
                    }
                    aPos = type.lastIndexOf('.');
                    String simpleTypeName = type;
                    if (pos > 0) {
                        simpleTypeName = type.substring(aPos + 1);
                    }
                    if (JavaCodeImportScope.CLASS == scope 
                        || (JavaCodeImportScope.METHOD_CLASS_IMPORT == scope && seemsToBeClass(simpleTypeName))) {
                        name = simpleTypeName + "." + name;
                    } // else like .METHOD
                }
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
        String impSimpleName = imp;
        int pos = imp.lastIndexOf('.');
        if (pos > 0) {
            impPrefix = imp.substring(0, pos);
            impSimpleName = imp.substring(pos + 1);
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
                        found = iName.equals(imp) || i.getSimpleName().equals(impSimpleName);
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
    
    public void addImportExclusion(String imp) {
        if (null == importExclusions) {
            importExclusions = new HashSet<>();
        }
        importExclusions.add(imp);
    }

    @Override
    public JavaCodeImport addImport(String imp) {
        return addImport(imp, false);
    }

    public JavaCodeImport addStaticImport(String imp) {
        return addImport(imp, true);
    }

    private JavaCodeImport addImport(String imp, boolean isStatic) {
        JavaCodeImport result = null;
        IJavaCodeImport found = findMatchingImport(imp, false);
        if (null == found) {
            result = new JavaCodeImport(imp, this);
            result.setStatic(isStatic);
        } else if (found instanceof JavaCodeImport) {
            result = (JavaCodeImport) found;
        }
        return result;
    }
    
    private boolean isExcludedImport(String imp) {
        return null != importExclusions && importExclusions.contains(imp);
    }

    @Invisible
    @Override
    public void registerImport(IJavaCodeImport imp) {
        if (!imports.stream().anyMatch(i -> i.isStatic() == imp.isStatic() && i.isWildcard() == imp.isWildcard() 
            && i.getName().equals(imp.getName()))) {
            if (!isExcludedImport(imp.getName())) {
                imports.add(imp);
            }
        }
    }
    
    @Invisible
    public Iterable<IJavaCodeImport> imports() {
        return imports;
    }
   
}