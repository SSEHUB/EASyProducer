/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.frontend;

import java.net.URI;
import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.GeneralReasonerCapabilities;
import net.ssehub.easy.reasoning.core.reasoner.IChainingReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerMessage;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.capabilities.IReasonerCapability;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements an abstract chained reasoner. This reasoner does not perform upgrades. Chained reasoners shall be
 * registered with the reasoner factory.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractChainedReasoner implements IChainingReasoner {
    
    private ReasonerDescriptor descriptor;
    private IChainingReasoner[] reasoners;
    private Configuration config;
    private ReasoningResult reasoningResult;
    private EvaluationResult evaluationResult;

    /**
     * Creates an reasoner chain with given name and version. The descriptor is constructed from the 
     * descriptors in the chain.
     * 
     * @param name the name of the reasoner
     * @param version a version description of the integrated reasoner (may be <b>null</b>)
     * @param chain the reasoners to be chained (must be implementations of {@link IChainingReasoner})
     * @throws IllegalArgumentException in case that one of the given reasoner descriptors is <b>null</b>, the reasoner
     *   is not registered in the reasoner frontend, the first reasoner does not provide 
     *   {@link GeneralReasonerCapabilities#STANDALONE_REASONING} or at least one of the reasoners does not implement 
     *   {@link IChainingReasoner}/{@link ReasonerFrontend#isChainingReasoner(ReasonerDescriptor)}
     */
    protected AbstractChainedReasoner(String name, String version, ReasonerDescriptor... chain) 
        throws IllegalArgumentException {
        this(deriveDescriptor(name, version, chain), chain);
    }

    /**
     * Creates an reasoner chain with given descriptor.
     * 
     * @param descriptor the descriptor of the reasoner
     * @param chain the reasoners to be chained (must be implementations of {@link IChainingReasoner})
     * @throws IllegalArgumentException in case that one of the given reasoner descriptors is <b>null</b>, the reasoner
     *   is not registered in the reasoner frontend, the first reasoner does not provide 
     *   {@link GeneralReasonerCapabilities#STANDALONE_REASONING} or at least one of the reasoners does not implement 
     *   {@link IChainingReasoner}/{@link ReasonerFrontend#isChainingReasoner(ReasonerDescriptor)}
     */
    protected AbstractChainedReasoner(ReasonerDescriptor descriptor, ReasonerDescriptor... chain) {
        this.descriptor = descriptor;
        if (chain.length > 0) {
            if (!chain[0].hasCapability(GeneralReasonerCapabilities.STANDALONE_REASONING)) {
                throw new IllegalArgumentException("First reasoner in chain is not standalone");
            }
        }
        reasoners = new IChainingReasoner[chain.length];
        for (int r = 0; r < reasoners.length; r++) {
            IReasoner tmp = ReasonerFrontend.getInstance().findReasoner(chain[r]);
            if (null == tmp) {
                throw new IllegalArgumentException("Reasoner " + r + " in chain is not registered/null");
            } else if (!(tmp instanceof IChainingReasoner)) {
                throw new IllegalArgumentException("Reasoner " + r + " in chain is not a chaining reasoner");
            } else {
                reasoners[r] = (IChainingReasoner) tmp;
            }
        }
    }
    
    /**
     * Implements a derived reasoner descriptor taking over capabilities.
     * 
     * @author Holger Eichelberger
     */
    private static class DerivedReasonerDescriptor extends ReasonerDescriptor {

        /**
         * Creates a new reasoner descriptor.
         * 
         * @param name the name of the reasoner
         * @param version a version description of the integrated reasoner (may be <b>null</b>)
         * @param license the license (may be <b>null</b>)
         * @param licenseRestriction a restriction of the license to be displayed, e.g. "valid until March 2020" (may 
         *     be <b>null</b>)
         */
        public DerivedReasonerDescriptor(String name, String version, String license, String licenseRestriction) {
            super(name, version, license, licenseRestriction, null);
        }
        
        /**
         * Adds the capabilities of <code>desc</code> to the capabilities of this reasoner descriptor.
         * 
         * @param desc the descriptor to take the capabilities from
         */
        private void addCapabilities(ReasonerDescriptor desc) {
            IReasonerCapability[] cap = desc.getCapabilities();
            for (int c = 0; c < cap.length; c++) {
                addCapability(cap[c]);
            }
        }
        
    }
    
    /**
     * Derives the descriptor from the descriptor chain.
     * 
     * @param name the name of the reasoner
     * @param version the version of the reasoner
     * @param chain the chain of reasoners
     * @return the derived reasoner descriptor
     */
    private static ReasonerDescriptor deriveDescriptor(String name, String version, ReasonerDescriptor[] chain) {
        String license = "";
        String licenseRestriction = "";
        for (int c = 0; c < chain.length; c++) {
            license = concatenate(license, chain[c].getLicense());
            licenseRestriction = concatenate(licenseRestriction, chain[c].getLicenseRestriction());
        }
        DerivedReasonerDescriptor result = new DerivedReasonerDescriptor(name, version, license, licenseRestriction);
        for (int c = 0; c < chain.length; c++) {
            result.addCapabilities(chain[c]);
        }
        return result;
    }
    
    /**
     * Concatenates two strings regarding <b>null</b> for <code>s2</code>.
     * 
     * @param s1 the first string
     * @param s2 the second string
     * @return the concatenated string
     */
    private static String concatenate(String s1, String s2) {
        String result = s1;
        if (null != s2) {
            if (result.length() > 0) {
                result += "\n";
            }
            result += s2;
        }
        return result;
    }

    @Override
    public ReasoningResult upgrade(URI url, ProgressObserver observer) {
        return null;
    }

    @Override
    public ReasonerDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        for (int r = 0; (null == reasoningResult || reasoningResult.hasConflict()) && r < reasoners.length; r++) {
            IChainingReasoner reasoner = reasoners[r];
            reasoner.setState(config, reasoningResult); // shall ignore null, null
            reasoningResult = reasoner.isConsistent(project, reasonerConfiguration, observer);
            config = reasoners[r].getLastConfiguration();
        }
        ReasoningResult result = reasoningResult;
        reasoningResult = null;
        return result;
    }

    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        if (null == config) {
            config = cfg;
        }
        for (int r = 0; (null == reasoningResult || reasoningResult.hasConflict()) && r < reasoners.length; r++) {
            IChainingReasoner reasoner = reasoners[r];
            reasoner.setState(config, reasoningResult); // shall ignore null, null
            reasoningResult = reasoner.check(project, config, reasonerConfiguration, observer);
            config = reasoners[r].getLastConfiguration();
        }
        ReasoningResult result = reasoningResult;
        reasoningResult = null;
        return result;
    }

    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        if (null == config) {
            config = cfg;
        }
        for (int r = 0; (null == reasoningResult || reasoningResult.hasConflict()) && r < reasoners.length; r++) {
            IChainingReasoner reasoner = reasoners[r];
            reasoner.setState(config, reasoningResult); // shall ignore null, null
            reasoningResult = reasoner.propagate(project, config, reasonerConfiguration, observer);
            config = reasoners[r].getLastConfiguration();
        }
        ReasoningResult result = reasoningResult;
        reasoningResult = null;
        return result;
    }

    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        if (null == config) {
            config = cfg;
        }
        for (int r = 0; (null == evaluationResult || evaluationResult.hasConflict()) && r < reasoners.length; r++) {
            IChainingReasoner reasoner = reasoners[r];
            reasoner.setState(config, evaluationResult); // shall ignore null, null
            evaluationResult = reasoner.evaluate(project, config, constraints, reasonerConfiguration, observer);
            config = reasoners[r].getLastConfiguration();
        }
        EvaluationResult result = evaluationResult;
        evaluationResult = null;
        return result;
    }

    @Override
    public void notify(IReasonerMessage message) {
        for (int r = 0; r < reasoners.length; r++) {
            reasoners[r].notify(message);
        }
    }

    @Override
    public IReasonerInstance createInstance(Project project, Configuration cfg,
        ReasonerConfiguration reasonerConfiguration) {
        return null; // TODO ??
    }

    @Override
    public void setState(Configuration config, ReasoningResult result) {
        this.config = config;
        this.reasoningResult = result;
    }

    @Override
    public void setState(Configuration config, EvaluationResult result) {
        this.config = config;
        this.evaluationResult = result;
    }
    
    @Override
    public Configuration getLastConfiguration() {
        Configuration result = config;
        config = null;
        return result;
    }

}
