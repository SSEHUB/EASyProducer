package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
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

/**
 * Represents the Python code artifact in VTL.
 * 
 * @author Kevin Schaperjahn
 */
@ArtifactCreator(PythonCodeArtifactCreator.class)
public class PythonCodeArtifact extends FileArtifact implements IPythonCodeArtifact, IStringValueProvider, Storable {
    
    private List<IPythonCodeImport> imports = new ArrayList<>();
    private PythonCodeBlock block;
    private PythonCodeDocComment comment;
    private File file;
    private String moduleName = "";
    private boolean store = false;

    public PythonCodeArtifact(File file, ArtifactModel model) {
        super(file, model);
        this.file = file;
        if (file != null) {
            moduleName = file.getName().replace(".py", "");
        }
        this.store = true;
        this.block = new PythonCodeBlock(this);
    }

    public PythonCodeArtifact(String moduleName) {
        this(null, null);
        this.moduleName = moduleName;
        this.store = false;
    }

    public static PythonCodeArtifact create(String moduleName) {
        return new PythonCodeArtifact(moduleName);
    }
    
    @Override
    public boolean enableAutoStore() {
        return false;
    }    

    public PythonCodeArtifact disable() {
        this.store = false;
        return this;
    }

    public PythonCodeArtifact enable() {
        this.store = true;
        return this;
    }

    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return ArtifactFactory.createArtifact(PythonCodeArtifact.class, path.getAbsolutePath(),
                        path.getArtifactModel());
    }

    @Invisible
    @Conversion
    public static PythonCodeArtifact convert(IFileSystemArtifact val) {
        PythonCodeArtifact convertedValue = null;
        if (val instanceof PythonCodeArtifact) {
            convertedValue = (PythonCodeArtifact) val;
        } else if (val instanceof FileArtifact) {
            FileArtifact fa = (FileArtifact) val;
            try {
                convertedValue = ArtifactFactory.createArtifact(PythonCodeArtifact.class,
                                fa.getPath().getAbsolutePath(), null);
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(PythonCodeArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
        return convertedValue;
    }

    @Invisible
    @Conversion
    public static PythonCodeArtifact convert(Path path) throws VilException {
        return ArtifactFactory.createArtifact(PythonCodeArtifact.class, path.getAbsolutePath(),
                        path.getArtifactModel());
    }

    @Override
    public Object determineActualValue(Object object) {
        Object result = object;
        if (!(object instanceof PythonCodeArtifact)) { // secondary artifact
                                                       // conversion, allow for
                                                       // VTL parameter assng.
            if (object instanceof FileArtifact) {
                result = convert((IFileSystemArtifact) object);
            }
        }
        return super.determineActualValue(result);
    }

    public String getModule() {
        return moduleName;
    }

    @Override
    public int getElementCount() {
        int result = 0;
        if (comment != null) {
            result += comment.getElementCount();
        }
        // imports are part of block

/*        if (!imports.isEmpty()) {
            result += imports.size() + 1;
        }*/

        result += block.getElementCount();

        return result;
    }

    public String toImports() {
        return Storable.getString(o -> storeImports(o));
    }

    public String toHeader() {
        return Storable.getString(o -> storeHeader(o));
    }

    protected void storeImports(CodeWriter out) {
        for (IPythonCodeImport imp : imports) {
            imp.store(out);
        }
    }

    protected void storeHeader(CodeWriter out) {
        if (comment != null) {
            comment.store(out);
            out.println();
        }
        // imports are part of block
/*        if (imports.size() > 0) {
            storeImports(out);
            out.println();
        }*/
    }

    @Invisible
    @Override
    public void store() throws VilException {
        if (store && (imports.size() > 0 || block.getElementCount() > 0)) {
            CodeWriter out = new CodeWriter(file);
            store(out);
            out.close();
        } else { // "emulate" functionality of file artifact if python artifact has not been used explicitly
            super.store();
        }
    }

    @Override
    public void store(CodeWriter out) {
        storeHeader(out);
        block.store(out);
    }

    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void delete() throws VilException {
        super.delete();
    }

    @OperationMeta(name = { "comment" })
    public PythonCodeArtifact setComment(String comment) {
        this.comment = new PythonCodeDocComment(comment, null);
        return this;
    }

    public void add(String text) {
        block.add(text);
    }

    public void addRaw(String text) {
        block.addRaw(text);
    }

    public PythonCodeClass addClass(String name) {
        return block.addClass(name);
    }

    public PythonCodeClass addClass(String name, String comment) {
        return block.addClass(name, comment);
    }

    public PythonCodeAssign addAssign(String varName, String expr) {
        return block.addAssign(varName, expr);
    }

    public PythonCodeAssign addAssign(String varName, String type, String expr) {
        return block.addAssign(varName, type, expr);
    }

    public PythonCodeMatch addMatch(String expr) {
        return block.addMatch(expr);
    }

    public PythonCodeFunction addFunc(String name) {
        return block.addFunc(name);
    }

    public PythonCodeFunction addFunc(String name, String comment) {
        return block.addFunc(name, comment);
    }
    
    /**
     * Adds a call to {@code sys.path.insert} with given {@code position} adding {@code path} to the system path.
     * 
     * @param position the position where to add the {@code path}
     * @param path the path to add
     * @return the function call for chaining
     */
    public PythonCodeFnCall addSysPathInsert(int position, String path) {
        addImport("sys");
        return addCall("sys.path.insert").addArgument(position).addStringArgument(path);
    }

    public PythonCodeTypeAlias addTypeAlias(String name, String expr) {
        return block.addTypeAlias(name, expr);
    }

    public PythonCodeFnCall addCall(String name) {
        return addCall(name, PythonCodeImportScope.NONE);
    }

    public PythonCodeFnCall addCall(String name, PythonCodeImportScope scope) {
        return block.addCall(name, scope);
    }

    public PythonCodeBlock addComment(String comment) {
        return block.addComment(comment);
    }

    public PythonCodeBlock addSLComment(String comment) {
        return block.addSLComment(comment);
    }

    public PythonCodeBlock addSLComment(String comment, boolean enclosed) {
        return block.addSLComment(comment, enclosed);
    }

    public void addEmptyLine() {
        block.addEmptyLine();
    }

    public PythonCodeForLoop addFor(String element, String array) {
        return block.addFor(element, array);
    }

    public PythonCodeForLoop addFor(String element, String rangeStart, String rangeEnd) {
        return block.addFor(element, rangeStart, rangeEnd);
    }

    public PythonCodeForLoop addFor(String element, String rangeStart, String rangeEnd, String rangeStep) {
        return block.addFor(element, rangeStart, rangeEnd, rangeStep);
    }

    public PythonCodeAlternative addIf(String condition) {
        return block.addIf(condition);
    }

    public PythonCodeWhileLoop addWhile(String condition) {
        return block.addWhile(condition);
    }

    public PythonCodeTryBlock addTry() {
        return block.addTry();
    }

    public PythonCodeRaise addRaise(String expr) {
        return block.addRaise(expr);
    }

    public PythonCodeWith addWith(String expr) {
        return block.addWith(expr);
    }

    public PythonCodeWith addWith(String expr, String varName) {
        return block.addWith(expr, varName);
    }

    public PythonCodeDelete addDelete(String varName) {
        return block.addDelete(varName);
    }

    public PythonCodeAssert addAssert(String expr) {
        return block.addAssert(expr);
    }

    public PythonCodeAssert addAssert(String expr, String msg) {
        return block.addAssert(expr, msg);
    }

    public PythonCodeImport addImport(String imp) {
        IPythonCodeImport found = findMatchingImport(imp);
        if (found != null && found instanceof PythonCodeImport) {
            return (PythonCodeImport) found;
        }

        return new PythonCodeImport(this, imp, true);
    }

    public PythonCodeImport addImport(String from, String imp) {
        IPythonCodeImport found = findMatchingImport(from);
        if (found != null && found instanceof PythonCodeImport) {
            return (PythonCodeImport) found;
        }

        return new PythonCodeImport(this, from, imp, true);
    }

    private IPythonCodeImport findMatchingImport(String imp) {
        for (IPythonCodeImport i : imports) {
            String iName = i.getName();

            boolean found = false;
            if (i.isWildcard()) {
                String impPrefix = "";
                int pos = imp.lastIndexOf('.');
                if (pos > 0) {
                    impPrefix = imp.substring(0, pos);
                }

                found = impPrefix.equals(iName.substring(0, iName.length() - 1));
            } else {
                found = iName.equals(imp);
            }

            if (found) {
                return i;
            }
        }

        return null;
    }

    @Override
    public void validateType(IPythonCodeTypeSpec type) {
        String typeName = type.getOutputTypeName();
        int pos = typeName.lastIndexOf('.');
        if (pos > 0) {
            if (findMatchingImport(typeName) == null) {
                new PythonCodeImport(this, typeName, false); // automatically registered
            }
            type.setOutputTypeName(typeName.substring(pos + 1));
        }
    }

    // eqivalent to validateStaticMethodCall for Java code artifacts
    @Override
    public String validateFuncCall(String name, PythonCodeImportScope scope) {
        if (scope == PythonCodeImportScope.NONE) {
            return name;
        }

        int modulePos = name.lastIndexOf('.');
        if (modulePos < 0) {
            return name;
        }

        String module = name.substring(0, modulePos);
        String fnName = name.substring(modulePos + 1);

        switch (scope) {
        // import function from module (from ... import ...)
        case FUNC:
            if (findMatchingImport(name) == null) {
                new PythonCodeImport(this, module, fnName, false); // automatically registered
            }

            return fnName;

        // import whole module (import ...)
        case MODULE:
            int nestedModulePos = module.lastIndexOf('.');
            if (nestedModulePos > 0) {
                fnName = name.substring(nestedModulePos + 1);
            } else {
                fnName = name;
            }

            if (findMatchingImport(name) == null) {
                new PythonCodeImport(this, module, false); // automatically registered
            }

            return fnName;

        default:
            return name;
        }
    }

    @Override
    public void registerImport(IPythonCodeImport imp, boolean explicit) {
        if (!imports.stream().anyMatch(i -> i.match(imp))) {
            imports.add(imp);
            block.addElt(imp, !explicit);
        }
    }
}