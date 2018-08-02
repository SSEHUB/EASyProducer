/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.varModel.testSupport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.io.FileUtils;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * A measurement collector that stores to TSV (tab-separated-values) files.
 * Always appends to the given file. Might be clearing/deleting the target file before use is helpful.
 * 
 * @author Holger Eichelberger
 */
public class TSVMeasurementCollector extends MeasurementCollector {

    private File file;
    private IMeasurementIdentifier[] columns;

    /**
     * Creates a new measurement collector using <code>file</code> as id.
     * 
     * @param file the output file
     * @param columns the output columns - will be written in the given sequence, even duplicates
     */
    public TSVMeasurementCollector(File file, Object... columns) {
        this(file, file, columns);
    }

    /**
     * Creates a new measurement collector.
     * 
     * @param id the id of the collector for checking whether an appropriate one is installed
     * @param file the output file
     * @param columns the output columns - will be written in the given sequence, even duplicates
     */
    public TSVMeasurementCollector(Object id, File file, Object... columns) {
        super(id);
        this.file = file;
        List<IMeasurementIdentifier> tmp = new ArrayList<IMeasurementIdentifier>();
        for (int c = 0; c < columns.length; c++) {
            IMeasurementIdentifier identifier = obtainIdentifier(columns[c]);
            if (null != identifier) {
                tmp.add(identifier);
            }
        }
        
        this.columns = new IMeasurementIdentifier[tmp.size()];
        tmp.toArray(this.columns);
    }
    
    /**
     * Ensures the installation of an appropriate measurement collector.
     * 
     * @param out the file where to write the measurement data to - also used as identification of the collector
     * @param columns the output columns - deferred evaluation only if needed
     */
    public static void ensureCollector(File out, IColumnProvider columns) {
        if (!out.equals(MeasurementCollector.getInstance().getId())) {
            out.delete();
            MeasurementCollector.setInstance(new TSVMeasurementCollector(out, columns.measurementColumns()));
        }
    }

    @Override
    protected void endMeasurement(MeasurementRecord record) {
        boolean writeHeader = !file.exists() || 0 == file.length();
        PrintStream out = null;
        try {
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            out = new PrintStream(new FileOutputStream(file, true));
            if (writeHeader) {
                out.print("model name");
                printSeparator(out);
                out.print("URI");
                printSeparator(out);
                out.print("tag");
                printSeparator(out);
                out.print("caller");
                printSeparator(out);
                for (IMeasurementIdentifier identifier : columns) {
                    out.print(identifier.name());
                    printSeparator(out);
                }
                printEOL(out);
            }
            Configuration cfg = record.getConfiguration();
            out.print(cfg.getProject().getName());
            printSeparator(out);
            ModelInfo<Project> info = VarModel.INSTANCE.availableModels().getModelInfo(cfg.getProject());
            if (null != info) {
                out.print(info.getLocation());
            }
            printSeparator(out);
            out.print(record.getTag());
            printSeparator(out);
            out.print(record.getCaller());
            printSeparator(out);
            for (IMeasurementIdentifier identifier : columns) {
                Double measurement = record.getMeasurement(identifier);
                if (null != measurement) {
                    out.print(measurement);
                }
                printSeparator(out);
            }
            printEOL(out);
        } catch (IOException e) {
            FileUtils.closeQuietly(out); // works with null
            EASyLoggerFactory.INSTANCE.getLogger(TSVMeasurementCollector.class, 
                "net.ssehub.easy.varModel.tests").error(e.getMessage());
        }
    }

    /**
     * Prints a separator to <code>out</code>.
     * 
     * @param out the output stream
     */
    private static void printSeparator(PrintStream out) {
        out.print("\t");
    }

    /**
     * Prints an End-Of-Line to <code>out</code>.
     * 
     * @param out the output stream
     */
    private static void printEOL(PrintStream out) {
        out.println();
    }
    
}
