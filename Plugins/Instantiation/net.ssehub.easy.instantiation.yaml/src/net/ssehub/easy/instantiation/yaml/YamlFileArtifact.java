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
package net.ssehub.easy.instantiation.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Formatting;
import net.ssehub.easy.instantiation.core.model.templateModel.FormattingConfiguration;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a YAML file artifact.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(YamlArtifactCreator.class)
public class YamlFileArtifact extends FileArtifact implements IStringValueProvider, INodeParent {

    private List<YamlNode> data = new ArrayList<>();
    private boolean changedByNodes = false;
    
    /**
     * Creates an instance without file backing.
     */
    public YamlFileArtifact() {
        super();
    }
    
    /**
     * Creates an instance for a given file/artifact model.
     * 
     * @param file the file
     * @param model the artifact model instance
     * @see #initialize()
     */
    protected YamlFileArtifact(File file, ArtifactModel model) {
        super(file, model);
        initialize();
    }
    
    // checkstyle: stop exception type check

    /**
     * Initializes {@code data} from an underlying file.
     */
    private void initialize() {
        File f = getPath().getAbsolutePath();
        try {
            data.clear();
            if (f.exists()) {
                Yaml yaml = new Yaml();
                FileInputStream fis = new FileInputStream(f);
                for (Object document : yaml.loadAll(fis)) {
                    data.add(new YamlNode(document, this));
                }
                fis.close();
            }
        } catch (Throwable e) { // if the format is broken/not really correct, e.g., oktoflow data templates
            EASyLoggerFactory.INSTANCE.getLogger(YamlFileArtifact.class, Bundle.ID).warn(
                "While reading " + f + ": " + e.getMessage());
        }
    }

    // checkstyle: resume exception type check
    
    @Override
    public void artifactChanged(Object cause) throws VilException {
        super.artifactChanged(cause);
        initialize();
    }

    /**
     * Creates an instance (VIL constructor).
     * 
     * @return the instance
     */
    public static YamlFileArtifact create() {
        return new YamlFileArtifact();
    }

    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return ArtifactFactory.createArtifact(YamlFileArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static YamlFileArtifact convert(IFileSystemArtifact val) {
        YamlFileArtifact convertedValue = null;
        if (val instanceof YamlFileArtifact) {
            convertedValue = (YamlFileArtifact) val;
        } else if (val instanceof FileArtifact) {
            FileArtifact fa = (FileArtifact) val;
            try {
                convertedValue = ArtifactFactory.createArtifact(
                    YamlFileArtifact.class, fa.getPath().getAbsolutePath(), null);
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(YamlFileArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
        return convertedValue;
    }
    
    /**
     * Adds a new document.
     * 
     * @return the new document instance
     */
    public YamlNode addDocument() {
        YamlNode current = new YamlNode(this);
        data.add(current);
        notifyChanged();
        return current;
    }

    /**
     * Adds a given document.
     * 
     * @param node the node to add as document
     * @return {@code node}
     */
    public YamlNode addDocument(YamlNode node) {
        data.add(node);
        node.setParent(this);
        notifyChanged();
        return node;
    }
    
    /**
     * Returns the known number of documents.
     * 
     * @return the number of documents
     */
    public int getDocumentCount() {
        return data.size();
    }
    
    /**
     * Returns the specified document.
     * 
     * @param index the 0-based index of the document
     * @return the specified document as {@link YamlNode}
     * @throws IndexOutOfBoundsException if index &lt; 0 || index &gt;= {@link #getDocumentCount()}.
     */
    public YamlNode getDocument(int index) {
        return data.get(index);
    }

    /**
     * Removes the specified document.
     * 
     * @param index the 0-based index of the document
     * @throws IndexOutOfBoundsException if index &lt; 0 || index &gt;= {@link #getDocumentCount()}.
     */
    public void deleteDocument(int index) {
        data.remove(index);
        notifyChanged();
    }
    
    @Override
    public void store() throws VilException {
        super.store();
        if (changedByNodes) {
            try {
                File file = getPath().getAbsolutePath();
                file.getParentFile().mkdirs();
                FileWriter writer = new FileWriter(file);
                
                IndentationConfiguration iCfg = Formatting.getIndentationConfiguration();
                FormattingConfiguration fCfg = Formatting.getFormattingConfiguration();
                DumperOptions options = new DumperOptions();
                YamlNode.Sorting sorting = YamlNode.Sorting.INSERT;
                try {
                    sorting = YamlNode.Sorting.valueOf(fCfg.getProfileArgument("sorting", 
                        YamlNode.Sorting.NONE.name()));
                } catch (IllegalArgumentException e) {
                    // take default
                }
                FlowStyle style = FlowStyle.BLOCK;
                try {
                    style = FlowStyle.valueOf(fCfg.getProfileArgument("flowStyle", "BLOCK"));
                } catch (IllegalArgumentException e) {
                    // take default
                }
                options.setDefaultFlowStyle(style);
                
                int indent = 1;
                if (fCfg.getIndentSteps() > 0) {
                    indent = fCfg.getIndentSteps();
                } else if (iCfg.getIndentationStep() > 0) {
                    indent = iCfg.getIndentationStep();
                }
                
                int indicatorIndent = indent - 1;
                try {
                    indicatorIndent = Integer.parseInt(fCfg.getProfileArgument("indicatorIndent", 
                        String.valueOf(indicatorIndent)));
                } catch (IllegalArgumentException e) {
                    // take default
                }
                
                options.setIndent(indent);
                if (indicatorIndent >= 0 && indicatorIndent < indent) {
                    options.setIndicatorIndent(indicatorIndent);
                }
                options.setPrettyFlow(Boolean.valueOf(fCfg.getProfileArgument("prettyFlow", "true")));
                
                Representer representer = new Representer(options);
                //representer.addClassTag(ClassMap.class, Tag.OMAP);
                
                Yaml yaml = new Yaml(representer, options);
                boolean first = true;
                for (YamlNode node : data) {
                    if (!first) {
                        writer.append("--\n");
                    }
                    Map<String, Object> d = node.getData(sorting);
                    if (!d.isEmpty()) {
                        yaml.dump(d, writer);
                    }
                    first = false;
                }
                writer.close();
                changedByNodes = false;
            } catch (IOException e) {
                throw new VilException(e.getMessage(), e, VilException.ID_IO);
            }
        }
    }

    @Override
    public void notifyChanged() {
        changedByNodes = true;
    }
    
}
