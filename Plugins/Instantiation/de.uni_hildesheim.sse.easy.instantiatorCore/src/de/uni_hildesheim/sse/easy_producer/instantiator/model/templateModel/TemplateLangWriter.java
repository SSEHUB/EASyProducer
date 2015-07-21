package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import static de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Constants.*;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.WriterVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * For writing a template language model to a print stream. Needed for persisting the 
 * model after external creation / modification. Does currently not consider Comments.
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangWriter extends WriterVisitor<VariableDeclaration> implements ITemplateLangVisitor {

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public TemplateLangWriter(Writer out) {
        super(out);
    }
    
    /**
     * Returns the number of non-default Java extensions in <code>template</code>.
     * 
     * @param template the template to consider
     * @return the number of non-default Java extensions
     */
    private int getNonDefaultJavaExtensionCount(Template template) {
        int count = 0;
        for (int e = 0, n = template.getJavaExtensionCount(); e < n; e++) {
            if (!template.getJavaExtension(e).isDefault()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Object visitTemplate(Template template) throws VilException {
        for (int i = 0; i < template.getImportsCount(); i++) {
            ModelImport<? extends Template> ref = template.getImport(i);
            printIndentation();
            print("import ");
            print(ref.getName());
            println(";");
        }
        if (template.getImportsCount() > 0) {
            println();
        }
        for (int e = 0; e < template.getJavaExtensionCount(); e++) {
            template.getJavaExtension(e).accept(this);
        }
        if (getNonDefaultJavaExtensionCount(template) > 0) {
            println();
        }
        for (int a = 0; a < template.getAdviceCount(); a++) {
            template.getAdvice(a).accept(this);
        }
        printIndenationHint(template.getIndentationConfiguration());
        printIndentation();
        print("template ");
        print(template.getName());
        printParameterList(template);
        if (null != template.getSuper()) {
            print(" extends ");
            print(template.getSuper().getName());
        }
        println(" {");
        int contained = template.getVariableDeclarationCount() + template.getDefCount() + o2i(template.getVersion()) 
            + template.getTypedefCount();
        if (contained > 0) {
            println();
            increaseIndentation();
            if (null != template.getVersion()) {
                printIndentation();
                printVersion(template.getVersion());
                println();
            }
            if (template.getTypedefCount() > 0) {
                printTypedefs(template);
                println();
            }
            for (int v = 0; v < template.getVariableDeclarationCount(); v++) {
                template.getVariableDeclaration(v).accept((IVisitor) this);
            }
            if (template.getVariableDeclarationCount() > 0) {
                println();
            }
            for (int d = 0; d < template.getDefCount(); d++) {
                if (d > 0) {
                    println();
                }
                template.getDef(d).accept(this);
            }
            decreaseIndentation();
            println();
        }
        printIndentation();
        println("}");
        return null;
    }
    
    /**
     * Prints the indentation hint related to the given <code>config</code>.
     * 
     * @param config the configuration to be printed
     */
    private void printIndenationHint(IndentationConfiguration config) {
        if (null != config && config.isIndentationEnabled()) {
            printIndentation();
            print("@indent(");
            printIndentationHintEntry(INDENTATION_HINT_INDENTATION, config.getIndentationStep());
            if (config.isTabEmulationEnabled()) {
                print(", ");
                printIndentationHintEntry(INDENTATION_HINT_TAB_EMU, config.getTabEmulation());
            }
            if (config.getAdditional() != 1) { // don't print the default
                print(", ");
                printIndentationHintEntry(INDENTATION_HINT_ADDITIONAL, config.getAdditional());
            }
            println(")");
        }
    }

    /**
     * Prints the an indentation hint entry.
     * 
     * @param name the name of the entry
     * @param value the actual value
     */
    private void printIndentationHintEntry(String name, int value) {
        print(name);
        print(" = ");
        print(value);
    }
    
    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilException {
        if (!ext.isDefault()) {
            printIndentation();
            print("extension ");
            print(ext.getName());
            println(";");
        }
        return null;
    }

    @Override
    public Object visitDef(Def def) throws VilException {
        printIndentation();
        print("def ");
        if (null != def.getSpecifiedType()) {
            printType(def.getSpecifiedType());
            print(" ");
        }
        print(def.getName());
        printParameterList(def);
        print(" ");
        visitTemplateBlock(def);
        println();
        return null;
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilException {
        println("{");
        increaseIndentation();
        for (int b = 0; b < block.getBodyElementCount(); b++) {
            block.getBodyElement(b).accept(this);
        }
        decreaseIndentation();
        printIndentation();
        print("}");
        return null;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilException {
        printIndentation();
        print("if (");
        alternative.getCondition().accept(this);
        print(") ");
        boolean printIndentation = isPrintExpressionStatementIndentation();
        boolean ifIsBlock = alternative.getIfStatement().isBlock();
        boolean lastIsBlock = ifIsBlock;
        setPrintExpressionStatementIndentation(ifIsBlock);
        alternative.getIfStatement().accept(this);
        if (null != alternative.getElseStatement()) {
            if (!ifIsBlock) {
                increaseIndentation();
                printIndentation();
                decreaseIndentation();
            } else {
                print(" ");
            }
            print("else ");
            boolean elseIsBlock = alternative.getElseStatement().isBlock();
            lastIsBlock = elseIsBlock;
            setPrintExpressionStatementIndentation(elseIsBlock);
            alternative.getElseStatement().accept(this);
        }
        setPrintExpressionStatementIndentation(printIndentation);
        if (lastIsBlock) {
            println();
        }
        return null;
    }
    
    /**
     * Prints a separator expression.
     * 
     * @param expression the expression to be printed
     * @throws VilException in case of evaluation problems
     */
    private void printSeparatorExpression(Expression expression) throws VilException {
        if (null != expression) {
            print(", ");
            expression.accept(this);
        }
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilException {
        printIndentation();
        print("for (");
        printType(loop.getIteratorVariable().getType());
        printWhitespace();
        print(loop.getIteratorVariable().getName());
        print(" : ");
        loop.getContainerExpression().accept(this);
        printSeparatorExpression(loop.getSeparatorExpression());
        if (null != loop.getSeparatorExpression()) {
            printSeparatorExpression(loop.getFinalSeparatorExpression());
        }
        print(") ");
        boolean printIndentation = isPrintExpressionStatementIndentation();
        boolean isStmtBlock = loop.getLoopStatement().isBlock();
        setPrintExpressionStatementIndentation(isStmtBlock);
        loop.getLoopStatement().accept(this);
        setPrintExpressionStatementIndentation(printIndentation);
        if (isStmtBlock) {
            println();
        }
        return null;
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilException {
        printIndentation();
        print("switch(");
        swtch.getSwitchExpression().accept(this);
        println(") {");
        increaseIndentation();
        for (int a = 0; a < swtch.getAlternativeCount(); a++) {
            SwitchStatement.Alternative alt = swtch.getAlternative(a);
            printIndentation();
            if (alt.isDefault()) {
                print("default : ");
            } else {
                alt.getCondition().accept(this);
                print(" : ");
            }
            alt.getValue().accept(this);
            if (a + 1 < swtch.getAlternativeCount()) {
                println(",");
            } else {
                println();
            }
        }
        decreaseIndentation();
        printIndentation();
        println("}");
        return null;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilException {
        printIndentation();
        if (!cnt.printLineEnd()) {
            print("print ");
        }
        String terminal = cnt.getTerminal();
        print(terminal);
        // TODO: Catching of exception ok?
        try {
            setInContent(true);
            cnt.getContent().accept(this);
            setInContent(false);
//            content = content.replace(terminal, "\\" + terminal);
//            print(content);
            print(terminal);
            if (null != cnt.getIndentExpression()) {
                print(" | ");
                cnt.getIndentExpression().accept(this);
                print(";");
            }
            println();
        } catch (VilException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException {
        if (call.isSuper()) {
            print("super.");
        }
        if (null != call.getPrefix()) {
            print(call.getPrefix());
            print(Constants.QUALIFICATION_SEPARATOR);
        }
        print(call.getName());
        printArgumentList(call, 0);
        return null;
    }

}
