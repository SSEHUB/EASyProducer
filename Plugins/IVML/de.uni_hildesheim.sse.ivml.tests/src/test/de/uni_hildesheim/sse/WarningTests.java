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
package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.translation.ErrorCodes;
import de.uni_hildesheim.sse.translation.ExpressionTranslator;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.varModel.capabilities.DefaultReasonerAccess;
import net.ssehub.easy.varModel.capabilities.IvmlReasonerCapabilities;
import net.ssehub.easy.varModel.model.Project;

/**
 * Tests for warnings.
 * 
 * @author Holger Eichelberger
 */
public class WarningTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(getTestDataDir(), "warnings");

    /**
     * Individual tests can store here their expected warnings. Will be cleared automatically
     * during {@link #assertEqual(File, String, String, int...)} when calling 
     * {@link #checkWarningCodes(TranslationResult)}.
     */
    private Set<Integer> expectedWarnings = new HashSet<Integer>();

    /**
     * Creates a file in {@link #DIR}.
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Whether implicit ref-by leads to a warning.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAutoRefBy() throws IOException {
        if (ExpressionTranslator.WARN_IMPLICIT_REFBY) {
            expectedWarnings.add(ErrorCodes.REF_BY);
        }
        assertEqual(createFile("autoRefBy"), null, null);
    }
    
    /**
     * Whether qualified constraints in compounds lead to a warning (over-quantization).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundQuantification() throws IOException {
        if (!DefaultReasonerAccess.hasCapability(IvmlReasonerCapabilities.QUALIFIED_COMPOUND_ACCESS)) {
            expectedWarnings.add(ErrorCodes.TYPE_QUALIFICATION);
        }
        assertEqual(createFile("compoundQuantification"), null, null);
    }

    @Override
    protected void checkWarningCodes(TranslationResult<Project> result) {
        // errors are checked separately through provided arguments to assertEqual
        List<Message> unmatched = new ArrayList<Message>();
        for (int m = 0; m < result.getMessageCount(); m++) {
            Message msg = result.getMessage(m);
            if (Status.WARNING == msg.getStatus()) {
                if (!expectedWarnings.remove(msg.getCode())) {
                    unmatched.add(msg);
                }
            }
        }
        if (!unmatched.isEmpty()) {
            String tmp = "";
            for (Message msg : unmatched) {
                if (tmp.length() > 0) {
                    tmp += ", ";
                }
                tmp = tmp + msg.getDescription() + " (" + msg.getCode() + ")";
            }
            Assert.fail("Unexpected warnings occurred: " + tmp);
        }
        if (!expectedWarnings.isEmpty()) {
            Assert.fail("Expected warnings did not occur: " + expectedWarnings);
            expectedWarnings.clear();        
        }
    }

}
