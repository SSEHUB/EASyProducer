package de.uni_hildesheim.sse.translation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.VersionedId;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;

/**
 * A class which specifically does the import translations. The methods
 * are available for reuse.
 * 
 * @author Holger Eichelberger
 */
public class ImportTranslator {

    /**
     * Processes versioned ids.
     * 
     * @param ids the ids to be processed
     * @return the (correct) related version restriction instances, <b>null</b>
     *         if <code>ids</code> is <b>null</b>)
     * @throws TranslatorException in case of semantic errors
     */
    private static VersionRestriction[] processVersionedId(EList<VersionedId> ids) 
        throws TranslatorException {
        VersionRestriction[] restrictions;
        if (null != ids) {
            List<VersionRestriction> tmp = new ArrayList<VersionRestriction>();
            for (VersionedId id : ids) {
                VersionRestriction.Operator operator = IvmlKeyWords
                        .getOperator(id.getOp());
                if (null == operator) {
                    throw new TranslatorException("unknown operator " + id.getOp(), id,
                            IvmlPackage.Literals.VERSIONED_ID__OP,
                            ErrorCodes.IMPORT);
                } else {
                    try {
                        tmp.add(new VersionRestriction(id.getName(), operator,
                                new Version(id.getVersion())));
                    } catch (VersionFormatException e) {
                        throw new TranslatorException(e, id, IvmlPackage.Literals.VERSIONED_ID__VERSION);
                    }
                }
            }
            restrictions = new VersionRestriction[tmp.size()];
            tmp.toArray(restrictions);
        } else {
            restrictions = null;
        }
        return restrictions;
    }

    /**
     * Processes a conflict statement including import restrictions. In case of
     * errors the respective element is not added to the resulting project.
     * 
     * @param conflictStmt the conflict statement
     * @return the related IVML model instance
     * @throws TranslatorException in case of semantic errors
     */
    public static ProjectImport processConflict(ConflictStmt conflictStmt) throws TranslatorException {
        String name = conflictStmt.getName();
        VersionRestriction[] restrictions = processVersionedId(conflictStmt.getConflicts());
        // no check for conflicts!
        if (!VarModel.INSTANCE.availableModels().hasModelInfo(name) && Utils.isImportResolutionEnabled()) {
            new TranslatorException(
                "project '" + name + "' cannot be resolved", conflictStmt,
                IvmlPackage.Literals.CONFLICT_STMT__NAME, ErrorCodes.IMPORT);
        }
        return new ProjectImport(name, null, true, false, restrictions);
    }

    /**
     * Processes an import statement including import restrictions. In case 
     * of errors the respective element is not added to the resulting project.
     * 
     * @param importStmt the import statement
     * @return the related IVML model instance
     * @throws TranslatorException in case of semantic errors
     */
    public static ProjectImport processImport(ImportStmt importStmt) throws TranslatorException {
        VersionRestriction[] restrictions = processVersionedId(importStmt.getVersions());
        String name = importStmt.getName();
        if (null != restrictions) {
            for (int r = 0; r < restrictions.length; r++) {
                if (!restrictions[r].getName().equals(name)) {
                    throw new TranslatorException("import restriction of '" + restrictions[r].getName() 
                        + "' is not equal to imported project '" + name + "'", importStmt, 
                        IvmlPackage.Literals.VERSION_STMT__VERSION, ErrorCodes.IMPORT);
                }
            }
        }
        String interfaceName = importStmt.getInterface(); // may be null, but thats ok ;)
        return new ProjectImport(name, interfaceName, false, false, restrictions); 
    }

}
