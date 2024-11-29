package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeToStringWriter;
import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

public interface Storable {
    
    @Invisible
    public void store(CodeWriter out);

    public default int getElementCount() {
        return 1;
    }

    public default String toCode() {
        return getString(o -> store(o));
    }

    public static String getString(Consumer<CodeWriter> store) {
        CodeToStringWriter out = new CodeToStringWriter();
        store.accept(out);
        return out.getString();
    }
}
