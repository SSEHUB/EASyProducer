package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaField;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        return new RuntimeEnvironment<VariableDeclaration>(VariableDeclaration.class) {

            @Override
            protected IExpressionVisitor createEvaluationProcessor() {
                return null; // only relevant for import/export/template resolution
            }

            @Override
            protected void releaseEvaluationProcessor(IExpressionVisitor processor) {
            }
            
        };
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public IMetaField getField(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public IMetaType getSuperType() {
        return null;
    }

    @Override
    public int getGenericParameterCount() {
        return 0;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

}