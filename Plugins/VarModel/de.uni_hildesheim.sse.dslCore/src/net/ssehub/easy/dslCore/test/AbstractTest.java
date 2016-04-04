package net.ssehub.easy.dslCore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.ModelUtility;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.Message;

/**
 * An abstract test support class for reading, parsing and comparing models.
 * Due to architectural conventions, we avoid any jUnit dependencies in this bundle.
 * 
 * @param <R> the top-level result model class
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTest<R extends IModel> {

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    /**
     * Performs the resource initialization.
     */
    protected static void resourceInitialization() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
    }
    
    /**
     * Determines the actual directory with the test IVML files depending on the
     * JVM system specified property which may contain a specific
     * directory (or be empty -> default directory <code>testdata</code>).
     * 
     * @param property the JVM property to read out
     * 
     * @return the actual directory as file
     */
    public static File determineTestDataDir(String property) {
        File result;
        String externalLocation = System.getProperty(property);
        if (null == externalLocation) {
            result = new File("testdata");
        } else {
            result = new File(externalLocation);
        }
        return result;
    }

    /**
     * Asserts that the expected error codes match the errors stored in
     * <code>result</code>.
     * 
     * @param result the result from parsing and analyzing a project
     * @param warnings the warnings that occurred, to be modified as a side effect, may be <b>null</b>
     * @param expectedErrorCodes the allowed / expected error codes
     * @return the error message if the codes do not match, <code>null</code> else
     */
    protected String checkErrorCodes(TranslationResult<R> result, List<Message> warnings, int... expectedErrorCodes) {
        return checkErrorCodes(result.getMessageListSpecific(), warnings, expectedErrorCodes);
    }
    
    /**
     * Asserts that the expected error codes match the errors stored in
     * <code>result</code>.
     * 
     * @param messages the actual messages to be analyzed
     * @param warnings the warnings that occurred, to be modified as a side effect, may be <b>null</b>
     * @param expectedErrorCodes the allowed / expected error codes
     * @return the error message if the codes do not match, <code>null</code> else
     */
    protected String checkErrorCodes(List<Message> messages, List<Message> warnings, 
        int... expectedErrorCodes) {
        // test expected error codes - expected vs. actual and vice versa
        Set<Integer> expectedErrors = new HashSet<Integer>();
        HashMap<Integer, String> actualErrors = new HashMap<Integer, String>();
        if (null != expectedErrorCodes) {
            for (int i = 0; i < expectedErrorCodes.length; i++) {
                expectedErrors.add(expectedErrorCodes[i]);
            }
        }
        int size = 0;
        if (null != messages) {
            size = messages.size();
        }
        for (int i = 0; i < size; i++) {
            Message msg = messages.get(i);
            if (!msg.ignore()) {
                if (Status.ERROR == msg.getStatus()) {
                    int code = msg.getCode();
                    actualErrors.put(code, msg.getDescription());
                    expectedErrors.remove(code);
                } else if (Status.WARNING == msg.getStatus()) {
                    if (null != warnings) {
                        warnings.add(msg);
                    }
                }
            }
        }
        if (null != expectedErrorCodes) {
            for (int i = 0; i < expectedErrorCodes.length; i++) {
                actualErrors.remove(expectedErrorCodes[i]);
            }
        }
        String result = null;
        if (!actualErrors.isEmpty()) {
            result = "unexpected errors: ";
            Iterator<Map.Entry<Integer, String>> iter = actualErrors.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, String> entry = iter.next();
                result += entry.getValue() + "(" + entry.getKey() + ")";
                if (iter.hasNext()) {
                    result += ", ";
                }
            }
        }
        if (!expectedErrors.isEmpty()) {
            if (null == result) {
                result = "";
            } else {
                result += " ";
            }
            result += "expected error codes which did not occur (in the right amount): " + expectedErrors;
        }
        return result;
    }
    
    /**
     * Turns a file into a string for comparison.
     * 
     * @param file the file to be turned into a string
     * @return the resulting string
     * @throws IOException in case that <code>file</code> cannot be found/read
     */
    protected String file2String(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        String fileAsString = null;
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    fc.size());
            /* Instead of using default, pass in a decoder. */
            fileAsString = Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }
        return fileAsString;
    }

    /**
     * Returns whether the given character is a line end.
     * 
     * @param ch
     *            the character to test
     * @return <code>true</code> if it is a line end, <code>false</code> else
     */
    private static final boolean isLineEnd(Character ch) {
        return ch == '\n' || ch == '\r';
    }

    /**
     * Returns whether the given character is a whitespace but not a line end.
     * 
     * @param ch
     *            the character to test
     * @return <code>true</code> if it is a whitespace but not a line end,
     *         <code>false</code> else
     */
    private static final boolean isWhitespaceButNotLineEnd(Character ch) {
        return Character.isWhitespace(ch) && !isLineEnd(ch);
    }

    /**
     * Compares two strings containing models and, if needed,
     * returns the location where the strings are not equal.
     * 
     * @param fileAsString the file as a string
     * @param modelAsString the model as a string
     * @return the position in <code>fileAsString</code> where the inequality
     *   occurs, a negative value if the model contains more data, no problem if return 
     *   value same/larger than length of <code>fileAsString</code>            
     */
    protected int isEqual(String fileAsString, String modelAsString) {
        StringWithPosition file = new StringWithPosition(fileAsString);
        StringWithPosition model = new StringWithPosition(modelAsString);
        boolean ok = true;
        if (file.inRange() ^ model.inRange()) {
            ok = false; // in case that one is empty
        }
        boolean continueNextLine = false;
        while (ok && file.inRange() && model.inRange()) {
            if (file.at() == '/') {
                // check for leftmost position
                if (!file.inRange(-1) || Character.isWhitespace(file.at(-1))) {
                    // consider replacement comment starting with //* which replaces
                    // the next line
                    if (file.inRange(3) && '/' == file.at(1) && '*' == file.at(2)) {
                        file.inc(3); // three characters compared
                        ok = handleReplacementComment(file, model);
                    } else if (file.inRange(3) && '/' == file.at(1) && '*' != file.at(2)) {
                        file.consumeLine();
                        // skip following comparison of chars, continue in next line
                        // as this may be a comment
                        continueNextLine = true;
                    }
                }
            }
            if (!continueNextLine) {
                if (file.at() != model.at()) {
                    ok = handleWindowsLinuxLineEnd(file, model);
                }
                file.inc();
                model.inc();
            } else {
                continueNextLine = false;
            }
        }
        int result;
        if (ok && (model.inRange() || file.inRange())) {
            result = -1; // one file is longer -> not all parts tested
        } else if (ok) {
            result = fileAsString.length() + 1;
        } else {
            result = file.pos(); // just where we are -> problem
        }
        return result;
    }

    /**
     * Compare and handle possible line ends for equality over windows and linux conventions.
     * If <code>s1</code> and <code>s2</code> are at line ends, advance the positions over line
     * ends
     * 
     * @param s1 the first string to be compared
     * @param s2 the second string to be compared
     * @return <code>true</code> if <code>s1</code> and <code>s2</code> are at line ends and
     *   both were advanced, <code>false</code> if nothing changed
     */
    private boolean handleWindowsLinuxLineEnd(StringWithPosition s1, StringWithPosition s2) {
        boolean ok = false;
        char cf = s1.at();
        char cm = s2.at();
        if (cf == 10 && cm == 13) {
            if (s2.inRange(1) && 10 == s2.at(1)) {
                ok = true;
                s2.inc();
            }
        } else if (cf == 13 && cm == 10) {
            if (s1.inRange(1) && 10 == s1.at(1)) {
                ok = true;
                s1.inc();
            }
        }
        return ok;
    }
    
    /**
     * Handles a replacement comment, i.e. //* occurred in <code>expected</code>.
     * The current position in <code>actual</code> will be compared to <code>expected</code> and
     * if equal, the current and the next line in <code>expected</code> as well as the current line
     * in <code>actual</code> will be consumed
     * 
     * @param expected the expected string
     * @param actual the actual string
     * @return <code>true</code> if the comment is handled, <code>false</code>
     *   if a comparison problem occurred and the lines are not considered to be equal.
     */
    private boolean handleReplacementComment(StringWithPosition expected, StringWithPosition actual) {
        boolean ok = true;
        // skip whitespaces
        while (expected.inRange()) {
            if (isWhitespaceButNotLineEnd(expected.at())) {
                expected.inc();
            } else {
                break;
            }
        }
        // compare the remainder of the comment and the current line
        // of the model excluding the file end
        while (ok && expected.inRange() && actual.inRange()) {
            char fc = expected.at();
            char mc = actual.at();
            if (fc == mc) {
                if (isLineEnd(fc)) { // implies isLineEnd(mc)
                    break;
                }
                expected.inc();
                actual.inc();
            } else {
                ok = false;
            }
        }
        // read line end only
        expected.consumeLineEnd();
        actual.consumeLineEnd();
        // skip next line in fileAsString
        while (expected.inRange() && !isLineEnd(expected.at())) {
            expected.inc();
        }
        expected.consumeLineEnd();
        return ok;
    }

    /**
     * Asserts the equality of two strings containing models and, if needed,
     * prints the location where the strings are not equal.
     * 
     * @param fileAsString the file as a string
     * @param modelAsString the model as a string
     * @return <code>true</code> if both are considered as equal, <code>false</code> else
     * @see #checkEqualsAndPrint(String, String, PrintWriter)
     */
    protected boolean checkEqualsAndPrint(String fileAsString, String modelAsString) {
        return checkEqualsAndPrint(fileAsString, modelAsString, new PrintWriter(System.out));
    }
    
    /**
     * Asserts the equality of two strings containing models and, if needed,
     * prints the location where the strings are not equal. This also adds the error
     * cause to the given writer instead of printing it to <tt>System.err.println()</tt>.
     * 
     * @param fileAsString the file as a string
     * @param modelAsString the model as a string
     * @param writer A writer, which should be used for printing out a detailed error message
     * @return <code>true</code> if both are considered as equal, <code>false</code> else
     */
    protected boolean checkEqualsAndPrint(String fileAsString, String modelAsString, PrintWriter writer) {
        boolean equals = true;
        int pos = isEqual(fileAsString, modelAsString);
        /*
        System.out.println("failPos " + pos+" fileLength " + fileAsString.length() + " modelLength " 
            + modelAsString.length());        
        */
        if (pos < 0 || pos <= fileAsString.length() || (0 == fileAsString.length() && modelAsString.length() > 0)) {
            if (pos > 0) {
                writer.println(fileAsString.substring(0, pos));
            }
            // and the files
            writer.println();
            writer.println("FILE: ");
            writer.println(fileAsString);
            writer.println("MODEL: ");
            writer.println(modelAsString);
            writer.println();
            if (pos < 0) {
                writer.println("Error: Model contains more data than the file.");
            } else if (0 == fileAsString.length() && modelAsString.length() > 0) {
                writer.println("Error: File is empty, but model contains data.");
            } else if (pos <= fileAsString.length()) {
                writer.println("Error in file at index (1 - " + (fileAsString.length() + 1) + "): " + (pos + 1));
                int start = Math.max(0, pos);
                int end = Math.min(pos + 5, fileAsString.length());
                writer.println("Excerpt (+/- 5 chars): " + fileAsString.substring(start, end));
            }
            writer.println("--");
            equals = false;
        }
        return equals;
    }

    /**
     * Asserts the equality of two strings containing models and, if needed,
     * emits the location where the strings are not equal. The model string will be 
     * trimmed before comparison.
     * 
     * @param fileAsString the file as a string
     * @param model the model as a string in the writer
     * @return <b>null</b> if no error occurred, the formatted error string else
     * @throws IOException in case of (internal) IO problems
     * @see #checkEqualsAndPrint(String, String, PrintWriter)
     */
    protected String checkEqualsAndPrepareMessage(String fileAsString, Writer model) throws IOException {
        return checkEqualsAndPrepareMessage(fileAsString, model, true);
    }
    
    /**
     * Asserts the equality of two strings containing models and, if needed,
     * emits the location where the strings are not equal.
     * 
     * @param fileAsString the file as a string
     * @param model the model as a string in the writer
     * @param trimModel trim the model (string) on both sides before comparing it or only at the end
     * @return <b>null</b> if no error occurred, the formatted error string else
     * @throws IOException in case of (internal) IO problems
     * @see #checkEqualsAndPrint(String, String, PrintWriter)
     */
    protected String checkEqualsAndPrepareMessage(String fileAsString, Writer model, boolean trimModel) 
        throws IOException {
        String modelAsString = model.toString();
        if (trimModel) {
            fileAsString = fileAsString.trim();
            modelAsString = modelAsString.trim();
        } else {
            StringBuilder tmp = new StringBuilder(modelAsString);
            while (tmp.length() > 0 && (Character.isWhitespace(tmp.charAt(tmp.length() - 1)))) {
                tmp.deleteCharAt(tmp.length() - 1);
            }
            modelAsString = tmp.toString();
        }
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        boolean equal = checkEqualsAndPrint(fileAsString, modelAsString, pWriter);
        pWriter.flush();
        sWriter.flush();
        String errorMsg;
        if (equal) {
            errorMsg = null;
        } else {
            errorMsg = "comparison failed:\n" + sWriter.toString();
        }
        pWriter.close();
        sWriter.close();
        return errorMsg;
    }
    
    /**
     * Returns the message for missing expected warnings.
     * 
     * @param warnings the warnings to check
     * @param expectedWarnings the expected warnings
     * @return <b>null</b> in case of no message, the message text else
     */
    protected static String checkWarnings(List<Message> warnings, int... expectedWarnings) {
        String result = null;
        if (null != warnings && expectedWarnings.length > 0) {
            StringBuilder tmp = new StringBuilder();
            List<Message> tmpWarning = new ArrayList<Message>();
            tmpWarning.addAll(warnings);
            for (int e = 0; e < expectedWarnings.length; e++) {
                boolean found = false;
                for (int w = 0; !found && w < tmpWarning.size(); w++) {
                    found = (tmpWarning.get(w).getCode() == expectedWarnings[e]);
                }
                if (!found) {
                    if (tmp.length() > 0) {
                        tmp.append(", ");
                    }
                    tmp.append(expectedWarnings[e]);
                }
            }
            if (tmp.length() > 0) {
                result = "missing warning codes: " + tmp;
            }
        }
        return result;
    }
    
    /**
     * Setup data needed to compare test results for equality.
     * 
     * @param <R> the model type
     * @author Holger Eichelberger
     */
    protected static class EqualitySetup<R extends IModel> {
        private File file;
        private String expectedName;
        private String expectedVersion;
        private String startElement = "main";
        private File expectedTrace;
        private Map<String, Object> parameter;
        private File expectedOutputFile;
        private boolean enableEquals = true;
        private Integer expectedFailCode;
        private String expectedFailReason;
        private R model;

        /**
         * Creates an instance with no trace output and empty parameters.
         * 
         * @param file the file containing the model
         * @param expectedName the expected name of (at least one) containing project,
         *   (may be <b>null</b> to disable check)
         * @param expectedVersion the expected version of <code>expectedName</code>
         */
        public EqualitySetup(File file, String expectedName, String expectedVersion) {
            this(file, expectedName, expectedVersion, null, new HashMap<String, Object>());
        }
        
        /**
         * Creates an instance with empty parameters.
         * 
         * @param file the file containing the model
         * @param expectedName the expected name of (at least one) containing project,
         *   (may be <b>null</b> to disable check)
         * @param expectedVersion the expected version of <code>expectedName</code>
         * @param expectedTrace the expected execution trace (may be <b>null</b>
         *   if only parsing shall be tested)
         */
        public EqualitySetup(File file, String expectedName, String expectedVersion, File expectedTrace) {
            this(file, expectedName, expectedVersion, expectedTrace, new HashMap<String, Object>());
        }

        /**
         * Creates an instance with empty parameters.
         * 
         * @param file the file containing the model
         * @param expectedName the expected name of (at least one) containing project,
         *   (may be <b>null</b> to disable check)
         * @param expectedVersion the expected version of <code>expectedName</code>
         * @param expectedTrace the expected execution trace (may be <b>null</b>
         *   if only parsing shall be tested)
         * @param parameter mapping
         */
        public EqualitySetup(File file, String expectedName, String expectedVersion, File expectedTrace, 
            Map<String, Object> parameter) {
            this.file = file;
            this.expectedName = expectedName;
            this.expectedVersion = expectedVersion;
            this.expectedTrace = expectedTrace;
            this.parameter = parameter;
        }
        
        /**
         * Sets the (overriding) model. If using this method, ensure that the model you are using
         * is identical to the model used during tests.
         * 
         * @param model the model (may be <b>null</b> for none)
         */
        public void setModel(R model) {
            this.model = model;
        }
        
        /**
         * Returns the (overriding) model.
         * 
         * @return the model (may be <b>null</b> if there is none)
         */
        public R getModel() {
            return model;
        }

        /**
         * Returns the file containing the model.
         * 
         * @return the file containing the model
         */
        public File getFile() {
            return file;
        }

        /**
         * Returns the expected name of the model.
         * 
         * @return the expected name
         */
        public String getExpectedName() {
            return expectedName;
        }

        /**
         * Returns the expected version of the model.
         * 
         * @return the expected version
         */
        public String getExpectedVersion() {
            return expectedVersion;
        }

        /**
         * Returns the file containing the expected execution trace.
         * 
         * @return the file containing the execution trace
         */
        public File getExpectedTrace() {
            return expectedTrace;
        }

        /**
         * Returns the parameter mappings, i.e., the name of the top-level 
         * input parameter and their individual values.
         * 
         * @return the parameter mapping
         */
        public Map<String, Object> getParameter() {
            return parameter;
        }

        /**
         * Returns the name of the start element for execution.
         * 
         * @return the name of the start element ("main" by default)
         */
        public String getStartElement() {
            return startElement;
        }
        
        /**
         * Changes the name of the start element for execution.
         * 
         * @param startElement the new name of the start element
         */
        public void setStartElement(String startElement) {
            this.startElement = startElement;
        }

        /**
         * Returns the file containing the expected output.
         * 
         * @return the file containing the expected output
         */
        public File getExpectedOutputFile() {
            return expectedOutputFile;
        }

        /**
         * Defines the file containing the expected output.
         * 
         * @param expectedOutputFile the file containing the expected output
         */
        public void setExpectedOutputFile(File expectedOutputFile) {
            this.expectedOutputFile = expectedOutputFile;
        }
        
        /**
         * Returns wehther equal comparison shall be enabled.
         * 
         * @return <code>true</code> if enabled, <code>false</code> else
         */
        public boolean enableEquals() {
            return enableEquals;
        }
        
        /**
         * Enables or disables the actual equals test and passes through to execution.
         * 
         * @param enableEquals whether equals shall be enabled (default <code>true</code>)
         */
        public void setEnableEquals(boolean enableEquals) {
            this.enableEquals = enableEquals;
        }
        
        /**
         * Sets an optional reason for expected execution failure.
         * 
         * @param failReason the reason for failing (may be <b>null</b> for none)
         */
        public void setExpectedFailReason(String failReason) {
            this.expectedFailReason = failReason;
        }
        
        /**
         * Returns the expected fail reason (if the execution failed).
         * 
         * @return the reason or <b>null</b> if unknown, not set or not failing
         */
        public String getExpectedFailReason() {
            return expectedFailReason;
        }
        
        /**
         * Defines an optional expected failure code.
         * 
         * @param failCode the failure code
         */
        public void setExpectedFailCode(Integer failCode) {
            this.expectedFailCode = failCode;
        }
        
        /**
         * The expected failure code.
         * 
         * @return the failure code (may be <b>null</b> if not set)
         */
        public Integer getExpectedFailCode() {
            return expectedFailCode;
        }
        
    }
    
    /**
     * Asserts the naming and the version in <code>result</code>.
     * 
     * @param data the data describing the setup
     * @param result the data obtained from parsing
     * 
     * @return the message to be used in assertions
     */
    protected String assertNamingAndVersion(EqualitySetup<R> data, TranslationResult<R> result) {
        String message = null;
        if (null != data.expectedName) {
            boolean found = false;
            for (int r = 0; !found && r < result.getResultCount(); r++) {
                R script = result.getResult(r);
                if (script.getName().equals(data.expectedName)) {
                    if (null != data.expectedVersion) {
                        found = Version.toString(script.getVersion()).equals(data.expectedVersion);
                    } else {
                        found = true;
                    }
                }
            }
            if (!found) {
                message = "does not contain " + data.expectedName 
                    + (data.expectedVersion == null ? "" : " " + data.expectedVersion);
            }
        }
        return message;
    }

    /**
     * Turns a list of messages into a readable string.
     * 
     * @param messages the messages to be turned into a string
     * @return the textual representation of the messages
     */
    public static String toString(List<Message> messages) {
        StringBuilder result = new StringBuilder();
        if (null != messages && !messages.isEmpty()) {
            for (int m = 0; m < messages.size(); m++) {
                if (m > 0) {
                    result.append(", ");
                }
                result.append(messages.get(m).getDescription());
            }
        }
        return result.toString();
    }
    
}
