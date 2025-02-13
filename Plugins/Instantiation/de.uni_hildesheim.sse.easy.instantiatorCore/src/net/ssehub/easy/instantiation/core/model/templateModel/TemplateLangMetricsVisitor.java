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
package net.ssehub.easy.instantiation.core.model.templateModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.Compound;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.VilTemplateProcessor;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ContainerInitializerExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;
import net.ssehub.easy.instantiation.core.model.expressions.FieldAccessExpression;
import net.ssehub.easy.instantiation.core.model.expressions.MultiAndExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ParenthesisExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationExpression;
import net.ssehub.easy.instantiation.core.model.expressions.StringExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ValueAssignmentExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VilTypeExpression;

/**
 * Visitor for collecting selected metrics on VTL files.
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangMetricsVisitor implements ITemplateLangVisitor {

    private static Set<String> processedImports = new HashSet<>();

    // initial values -> reset()
    private int numberOfDefs;
    private int numberOfContentStmts;
    private int numberOfContentAlternatives;
    private int numberOfContentLoops;
    private int numberOfBuilderBlockExpressions;
    private int numberOfVariableDeclarations;
    private StatisticsAggregator builderBlocksPerDef = new StatisticsAggregator("#builder/def");
    private StatisticsAggregator callChainsInDefs = new StatisticsAggregator("#callChains/def");
    private StatisticsAggregator callChainsInContentStatements = new StatisticsAggregator("#callChains/content");
    private StatisticsAggregator variableExpressionsInContentStatements = new StatisticsAggregator("#varEx/content");
    private StatisticsAggregator mcCabe = new StatisticsAggregator("McCabe/def");
    private int emptyLines;
    private int commentLines;
    private int codeLines;
    private String name;
    
    private transient boolean inContentStatement = false;
    
    /**
     * A simple averaging statistics aggregator.
     * 
     * @author Holger Eichelberger
     */
    public static class StatisticsAggregator {
        
        private String name;
        private double avgMin;
        private double sum;
        private double avgMax;
        private int avgCount;
        private double avgSum;
        private double totalSum;

        /**
         * Creates a statistics aggregator.
         * 
         * @param name the name of the values to aggregate
         */
        public StatisticsAggregator(String name) {
            this.name = name;
        }
        
        /**
         * Rests the aggregator.
         */
        public void reset() {
            avgMin = 0;
            sum = 0;
            avgMax = 0;
            avgCount = 0;
            avgSum = 0;
            totalSum = 0;
        }
        
        /**
         * Returns the name of the aggreated values.
         * 
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Adds a single value.
         * 
         * @param value the value
         */
        public void add(int value) {
            sum += value;
            totalSum += value;
        }
        
        /**
         * Aggregates the single values to an average, resets the single values.
         */
        public void aggregate() {
            avgMax = Math.max(avgMax, sum);
            avgSum += sum;
            avgMin = (0 == avgCount ? 0 : Math.min(avgMin, sum));
            avgCount++;
            sum = 0;
        }

        /**
         * Returns the aggregated average. Requires calling {@link #aggregate()} at least once before.
         * 
         * @return the aggregated average
         */
        public double getAverage() {
            return 0 == avgCount ? 0 : avgSum / ((double) avgCount);
        }

        /**
         * Returns the minimum of the aggregated averages. Requires calling {@link #aggregate()} at least once before.
         * 
         * @return the minimum
         */
        public double getAverageMin() {
            return avgMin;
        }

        /**
         * Returns the maximum of the aggregated averages. Requires calling {@link #aggregate()} at least once before.
         * 
         * @return the maximum
         */
        public double getAverageMax() {
            return avgMax;
        }
        
        /**
         * Returns the number of values contributing to the average.
         * 
         * @return the number of values
         */
        public int getAverageCount() {
            return avgCount;
        }

        /**
         * Returns the total sum of values added to this object.
         * 
         * @return the total sum of values
         */
        public double getTotalSum() {
            return totalSum;
        }

    }
    
    /**
     * Creates an instance.
     */
    public TemplateLangMetricsVisitor() {
        reset();
    }
    
    /**
     * Rests the instance for reuse.
     */
    public void reset() {
        name = "";
        numberOfDefs = 0;
        numberOfContentStmts = 0;
        numberOfContentAlternatives = 0;
        numberOfContentLoops = 0;
        numberOfBuilderBlockExpressions = 0;
        numberOfVariableDeclarations = 0;
        builderBlocksPerDef.reset();
        callChainsInDefs.reset();
        callChainsInContentStatements.reset();
        variableExpressionsInContentStatements.reset();
        mcCabe.reset();
        emptyLines = 0;
        commentLines = 0;
        codeLines = 0;
    }

    @Override
    public Object visitTemplate(Template template) throws VilException {
        name = template.getName();
        for (int d = 0; d < template.getVariableDeclarationCount(); d++) {
            template.getVariableDeclaration(d).accept(this);
        }
        for (int d = 0; d < template.getDefCount(); d++) {
            template.getDef(d).accept(this);
        }
        ModelInfo<Template> info = TemplateModel.INSTANCE.availableModels().getModelInfo(template);  
        if (null != info) {
            File f = new File(info.getLocation());
            try {
                List<String> lines = FileUtils.readLines(f, Charset.defaultCharset());
                boolean inComment = false;
                for (String l: lines) {
                    l = l.trim();
                    if (l.isBlank()) {
                        emptyLines++;
                    } else if (l.startsWith("//")) { // simplified, no String parsing
                        commentLines++;
                    } else if (l.startsWith("/*")) { // simplified, no String parsing
                        inComment = true;
                    }
                    if (inComment) {
                        commentLines++;
                        inComment = !l.endsWith("*/");
                    } else if (!l.isBlank()) {
                        codeLines++;
                    }
                }
            } catch (IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID)
                    .error("Reading " + info.getLocation() + ": " + e.getMessage());
            }
        } else {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID)
                .error("No model information for VTL template '" + template.getName() + "'");
        }
        return null;
    }

    @Override
    public Object visitDef(Def def) throws VilException {
        mcCabe.add(1);
        numberOfDefs++;
        for (int e = 0; e < def.getBodyElementCount(); e++) {
            def.getBodyElement(e).accept(this);
        }
        builderBlocksPerDef.aggregate();
        mcCabe.aggregate();
        return null;
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilException {
        for (int e = 0; e < block.getBodyElementCount(); e++) {
            block.getBodyElement(e).accept(this);
        }
        return null;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilException {
        mcCabe.add(1);
        alternative.getIfStatement().accept(this);
        if (null != alternative.getElseStatement()) {
            alternative.getElseStatement().accept(this);
        }
        return null;
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilException {
        mcCabe.add(1);
        loop.getLoopStatement().accept(this);
        return null;
    }

    @Override
    public Object visitWhile(WhileStatement stmt) throws VilException {
        mcCabe.add(1);
        stmt.getLoopStatement().accept(this);
        return null;
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilException {
        mcCabe.add(swtch.getAlternativeCount());
        for (int a = 0; a < swtch.getAlternativeCount(); a++) {
            swtch.getAlternative(a).getValue().accept(this);
        }
        return null;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilException {
        numberOfContentStmts++;
        inContentStatement = true;
        cnt.getContent().accept(this);
        inContentStatement = false;
        callChainsInContentStatements.aggregate();
        variableExpressionsInContentStatements.aggregate();
        return null;
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilException {
        return null;
    }
    
    /**
     * Registers a call chain call.
     */
    private void incCallChain() {
        if (inContentStatement) {
            callChainsInContentStatements.add(1);
        } else {
            callChainsInDefs.add(1);
        }
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException {
        incCallChain();
        for (int a = 0; a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitFlush(FlushStatement flush) throws VilException {
        return null;
    }

    @Override
    public Object visitContentAlternativeExpression(ContentAlternativeExpression ex) throws VilException {
        numberOfContentAlternatives++;
        return null;
    }

    @Override
    public Object visitContentLoopExpression(ContentLoopExpression ex) throws VilException {
        numberOfContentLoops++;
        return null;
    }

    @Override
    public Object visitContentVarDeclExpression(ContentVarDeclExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitContentImportExpression(ContentImportExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        numberOfVariableDeclarations++;
        if (null != var.getExpression()) {
            var.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        statement.getExpression().accept(this);
        callChainsInDefs.aggregate();
        return null;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return null;
    }

    @Override
    public Object visitCompound(Compound compound) throws VilException {
        return null;
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        par.getExpr().accept(this);
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        incCallChain();
        for (int a = 0; a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) throws VilException {
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return null;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        // not declaration.expression here, leads to double-counting, e.g., in callArgs
        if (inContentStatement) {
            variableExpressionsInContentStatements.add(1);
        }
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        ex.getExpression().accept(this);
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        if (null != ex.getValueExpression()) {
            ex.getValueExpression().accept(this);
        }
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        for (int i = 0; i < ex.getExpressionsCount(); i++) {
            ex.getExpression(i).accept(this);
        }
        return null;
    }

    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        incCallChain();
        for (int a = 0; a < ex.getArgumentsCount(); a++) {
            ex.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
        for (int e = 0; e < ex.getExpressionCount(); e++) {
            ex.getExpression(e).accept(this);
        }
        return null;
    }

    @Override
    public Object visitStringExpression(StringExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitBuilderBlockExpression(BuilderBlockExpression ex) throws VilException {
        numberOfBuilderBlockExpressions++;
        builderBlocksPerDef.add(1);
        ex.getVariable().getExpression().accept(this);
        ex.getBlock().accept(this);
        return null;
    }
    
    @Override
    public String toString() {
        // short summary
        return String.format("name %s codeLines %d/%d/%d MC %.0f[%.0f|%.0f|%.0f] defs %d bb %d[%.0f|%.0f|%.0f] "
            + "CC/def [%.0f|%.0f|%.0f] CC/content [%.0f|%.0f|%.0f] vars/content [%.0f|%.0f|%.0f]", name, 
            codeLines, commentLines, emptyLines, 
            mcCabe.getTotalSum(), mcCabe.getAverageMin(), mcCabe.getAverage(), mcCabe.getAverageMax(),
            numberOfDefs, numberOfBuilderBlockExpressions, 
            builderBlocksPerDef.getAverageMin(), builderBlocksPerDef.getAverage(), builderBlocksPerDef.getAverageMax(),
            callChainsInDefs.getAverageMin(), callChainsInDefs.getAverage(), callChainsInDefs.getAverageMax(),
            callChainsInContentStatements.getAverageMin(), callChainsInContentStatements.getAverage(), 
                callChainsInContentStatements.getAverageMax(),
            variableExpressionsInContentStatements.getAverageMin(), variableExpressionsInContentStatements.getAverage(),
                variableExpressionsInContentStatements.getAverageMax());
    }

    /**
     * Returns the number of defs in the analyzed template(s).
     * 
     * @return the number of defs
     */
    public int getNumberOfDefs() {
        return numberOfDefs;
    }

    /**
     * Returns the number of content statements in the analyzed template(s).
     * 
     * @return the number of content statements
     */
    public int getNumberOfContentStmts() {
        return numberOfContentStmts;
    }

    /**
     * Returns the number of content alternatives in the analyzed template(s).
     * 
     * @return the number of content alternatives
     */
    public int getNumberOfContentAlternatives() {
        return numberOfContentAlternatives;
    }

    /**
     * Returns the number of content loops in the analyzed template(s).
     * 
     * @return the number of content loops
     */
    public int getNumberOfContentLoops() {
        return numberOfContentLoops;
    }

    /**
     * Returns the number of (nested) builder block expressions in the analyzed template(s).
     * 
     * @return the number of builder block expressions
     */
    public int getNumberOfBuilderBlockExpressions() {
        return numberOfBuilderBlockExpressions;
    }

    /**
     * Returns the number of explicit variable declarations in the analyzed template(s).
     * 
     * @return the number of variable declarations
     */
    public int getNumberOfVariableDeclarations() {
        return numberOfVariableDeclarations;
    }

    /**
     * Returns the number of builder blocks per def in the analyzed template(s).
     * 
     * @return the number of builder blocks as average/min/max
     */
    public StatisticsAggregator getBuilderBlocksPerDef() {
        return builderBlocksPerDef;
    }

    /**
     * Returns the lengths of call chains per def in the analyzed template(s).
     * 
     * @return the lengths of call chains  as average/min/max
     */
    public StatisticsAggregator getCallChainsInDefs() {
        return callChainsInDefs;
    }

    /**
     * Returns the lengths of call chains per content statment in the analyzed template(s).
     * 
     * @return the lengths of call chains as average/min/max
     */
    public StatisticsAggregator getCallChainsInContentStatements() {
        return callChainsInContentStatements;
    }

    /**
     * Returns the number of variable expressions per content statment in the analyzed template(s).
     * 
     * @return the lengths of variable expressions as average/min/max
     */
    public StatisticsAggregator getVariableExpressionsInContentStatements() {
        return variableExpressionsInContentStatements;
    }

    /**
     * Returns the McCabe complexity, as total value for the analyzed template(s), as statistics per def.
     * 
     * @return the McCabe complexity
     */
    public StatisticsAggregator getMcCabe() {
        return mcCabe;
    }

    /**
     * Returns the number of empty lines for the analyzed template(s).
     * 
     * @return the empty lines
     */
    public int getEmptyLines() {
        return emptyLines;
    }

    /**
     * Returns the number of comment lines for the analyzed template(s).
     * 
     * @return the comment lines
     */
    public int getCommentLines() {
        return commentLines;
    }

    /**
     * Returns the number of code lines for the analyzed template(s).
     * 
     * @return the code lines
     */
    public int getCodeLines() {
        return codeLines;
    }

    /**
     * The name of the last analyzed template.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Collects and records metrics for {@code template}; requires system properties {@code easy.vtl.metrics.file} or 
     * {@code easy.vtl.metrics} to be set; results are appended to file if {@code easy.vtl.metrics.file} is set. Imports
     * will be marked with negative execution times as they are only available on top-level.
     * 
     * @param template the template
     * @param executionTime the execution time of the template
     */
    public static void recordMetrics(Template template, long executionTime) {
        String file = System.getProperty("easy.vtl.metrics.file");
        if (Boolean.valueOf(System.getProperty("easy.vtl.metrics", "false")) || file != null) {
            recordMetricsRec(template, executionTime, file);
        }
    }
    
    /**
     * Clears the so far processed imports.
     */
    public static void clearProcessedImports() {
        processedImports.clear();
    }

    /**
     * Collects and records metrics for {@code template} and is imports.
     * 
     * @param template the template to consider recursively
     * @param executionTime the execution time, may be negative for imports (available only top-level)
     * @param file the output file
     */
    private static void recordMetricsRec(Template template, long executionTime, String file) {
        for (int i = 0; i < template.getImportsCount(); i++) {
            ModelImport<Template> imp = template.getImport(i);
            if (!processedImports.contains(imp.getName()) && !imp.isWildcard()) {
                processedImports.add(imp.getName());
                Template imported = imp.getResolved();
                if (null != imported) {
                    recordMetricsRec(imported, -1, file);
                }
            }
        }
        recordMetrics(template, executionTime, file);
    }
    
    /**
     * Collects and records metrics for {@code template}.
     * 
     * @param template the template to process
     * @param executionTime the execution time, may be negative for imports (available only top-level)
     * @param file the output file
     */
    private static void recordMetrics(Template template, long executionTime, String file) {
        try {
            TemplateLangMetricsVisitor metrics = new TemplateLangMetricsVisitor();
            template.accept(metrics);
            if (null != file && file.length() > 0) {
                File f = new File(file);
                boolean header = !f.exists() || f.length() == 0;
                try (PrintStream out = new PrintStream(new FileOutputStream(f, true))) {
                    if (header) {
                        out.print("time\tname\texectime\tLOC\tCLOC\tELOC\tMcCabe\t");
                        printStatisticsHeadline(out, metrics.getMcCabe());
                        out.print("#defs\t#builder\t");
                        printStatisticsHeadline(out, metrics.getBuilderBlocksPerDef());
                        printStatisticsHeadline(out, metrics.getCallChainsInDefs());
                        printStatisticsHeadline(out, metrics.getCallChainsInContentStatements());
                        printStatisticsHeadline(out, metrics.getVariableExpressionsInContentStatements());
                        out.println();
                    }
                    printMetricsValue(out, System.currentTimeMillis());
                    printMetricsValue(out, template.getName());
                    printMetricsValue(out, executionTime);
                    printMetricsValue(out, metrics.getCodeLines());
                    printMetricsValue(out, metrics.getCommentLines());
                    printMetricsValue(out, metrics.getEmptyLines());
                    printMetricsValue(out, metrics.getMcCabe().getTotalSum());
                    printStatistics(out, metrics.getMcCabe());
                    printMetricsValue(out, metrics.getNumberOfDefs());
                    printMetricsValue(out, metrics.getNumberOfBuilderBlockExpressions());
                    printStatistics(out, metrics.getBuilderBlocksPerDef());
                    printStatistics(out, metrics.getCallChainsInDefs());
                    printStatistics(out, metrics.getCallChainsInContentStatements());
                    printStatistics(out, metrics.getVariableExpressionsInContentStatements());
                    out.println();
                } catch (IOException e) {
                    Bundle.getLogger(VilTemplateProcessor.class).error("Writing metrics for '" + template.getName() 
                        + "': " + e.getMessage());
                }
            } else {
                System.out.println(metrics + " " + executionTime + "ms");
            }
        } catch (VilException t) {
            Bundle.getLogger(VilTemplateProcessor.class).error("Calculating metrics for '" + template.getName() 
                + "': " + t.getMessage());
        }
    }
    
    /**
     * Prints a single metrics value to the TSV output stream.
     * 
     * @param out the stream
     * @param value the value
     */
    private static void printMetricsValue(PrintStream out, Object value) {
        if (value instanceof Double || value instanceof Float) {
            value = value.toString().replace('.', ','); // for Excel
        }
        out.print(value);
        out.print("\t");
    }
    
    /**
     * Prints headline entries for a statistics element/aggregator to the TSV output stream.
     * 
     * @param out the stream
     * @param stat the statistics element/aggregator
     */
    private static void printStatisticsHeadline(PrintStream out, StatisticsAggregator stat) {
        out.print(stat.getName() + " min\t");
        out.print(stat.getName() + " avg\t");
        out.print(stat.getName() + " max\t");
    }
    
    /**
     * Prints the values of a statistics element/aggregator.
     * 
     * @param out the output stream to print to
     * @param stat the statistics element/aggregator
     */
    private static void printStatistics(PrintStream out, TemplateLangMetricsVisitor.StatisticsAggregator stat) {
        printMetricsValue(out, stat.getAverageMin());
        printMetricsValue(out, stat.getAverage());
        printMetricsValue(out, stat.getAverageMax());
    }

}
