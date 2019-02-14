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
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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
     * @param columns the output columns - will be written in the given sequence, even duplicates; if not given, the 
     *     measurement identifiers of the first record will be taken and sorted alpha-numerically. However, if 
     *     <code>file</code> does already exist, the column sequence is not guaranteed to match.
     */
    public TSVMeasurementCollector(File file, Object... columns) {
        this(file, file, columns);
    }

    /**
     * Creates a new measurement collector.
     * 
     * @param id the id of the collector for checking whether an appropriate one is installed
     * @param file the output file
     * @param columns the output columns - will be written in the given sequence, even duplicates; if not given, the 
     *     measurement identifiers of the first record will be taken and sorted alpha-numerically. However, if 
     *     <code>file</code> does already exist, the column sequence is not guaranteed to match.
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
     * Ensures the installation of an appropriate measurement collector. If no collector exists, a new one is created
     * and a potentially existing file is deleted before.
     * 
     * @param out the file where to write the measurement data to - also used as identification of the collector
     * @param columns the output columns; if not given, the  measurement identifiers of the first record will be taken 
     * and sorted alpha-numerically. 
     */
    public static void ensureCollector(File out, Object... columns) {
        if (!out.equals(MeasurementCollector.getInstance().getId())) {
            out.delete();
            MeasurementCollector.setInstance(new TSVMeasurementCollector(out, columns));
        }
    }

    @Override
    protected void endMeasurement(MeasurementRecord record) {
        if (null == columns || 0 == columns.length) {
            Collection<IMeasurementIdentifier> ids = record.getMeasurementIdentifiers();
            columns = new IMeasurementIdentifier[ids.size()];
            ids.toArray(columns);
            Arrays.sort(columns, new Comparator<IMeasurementIdentifier>() {

                @Override
                public int compare(IMeasurementIdentifier o1, IMeasurementIdentifier o2) {
                    return o1.name().compareTo(o2.name());
                }
            });
        }
        boolean writeHeader = !file.exists() || 0 == file.length();
        PrintStream out = null;
        try {
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            out = new PrintStream(new FileOutputStream(file, true));
            if (writeHeader) {
                printSep(out, "model name");
                printSep(out, "URI");
                printSep(out, "tag");
                printSep(out, "runCount");
                printSep(out, "caller");
                for (IMeasurementIdentifier identifier : columns) {
                    printSep(out, identifier.name());
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
            printSep(out, record.getTag());
            printSep(out, record.getRunCount());
            printSep(out, record.getCaller());
            for (IMeasurementIdentifier identifier : columns) {
                Double measurement = record.getMeasurement(identifier);
                if (null != measurement) {
                    printSep(out, measurement);
                }
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

    /**
     * Prints a string value.
     * 
     * @param out the output stream
     * @param value the string value
     */
    private static void print(PrintStream out, String value) {
        out.print(value);
    }

    /**
     * Prints an integer value.
     * 
     * @param out the output stream
     * @param value the integer value
     */
    private static void print(PrintStream out, int value) {
        out.print(value);
    }

    /**
     * Prints a string value and a separator.
     * 
     * @param out the output stream
     * @param value the string value
     * 
     * @see #printSeparator(PrintStream)
     */
    private static void printSep(PrintStream out, String value) {
        print(out, value);
        printSeparator(out);
    }
    
    /**
     * Prints an integer value and a separator.
     * 
     * @param out the output stream
     * @param value the integer value
     * 
     * @see #printSeparator(PrintStream)
     */
    private static void printSep(PrintStream out, int value) {
        print(out, value);
        printSeparator(out);
    }
    
    /**
     * Prints a double value.
     * 
     * @param out the output stream
     * @param value the double value
     */
    private static void print(PrintStream out, Double value) {
        String tmp = String.format(Locale.ROOT, "%.2f", value).replace('.', ','); // for Excel
        out.print(tmp);
    }

    /**
     * Prints a double value and a separator.
     * 
     * @param out the output stream
     * @param value the double value
     * 
     * @see #printSeparator(PrintStream)
     */
    private static void printSep(PrintStream out, Double value) {
        print(out, value);
        printSeparator(out);
    }

}
