package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ITypedModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * A pseudo instance for testing.
 * 
 * @author Holger Eichelberger
 */
public class PseudoModel implements ITypedModel {

    @Override
    public void setVersion(Version version) {
    }

    @Override
    public Version getVersion() {
        return null;
    }

    @Override
    public String getName() {
        return "<pseudo>";
    }

    @Override
    public int getImportsCount() {
        return 0;
    }

    @Override
    public ModelImport<?> getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ModelImport<?> getSuper() {
        return null;
    }

    @Override
    public IndentationConfiguration getIndentationConfiguration() {
        return null;
    }

    @Override
    public String getQualifiedName() {
        return getName();
    }

    @Override
    public int getOperationsCount() {
        return 0;
    }

    @Override
    public IMetaOperation getOperation(int index) {
        return null;
    }

    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return false;
    }

    @Override
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        return null;
    }

    @Override
    public boolean isBasicType() {
        return false;
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return TypeRegistry.DEFAULT;
    }

    @Override
    public boolean enableDynamicDispatch() {
        return true;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public IMetaOperation addPlaceholderOperation(String name, int parameterCount, boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return false; // shall not be handled by IActualTypeProvider
    }

    @Override
    public void dispose() {
    }

}
