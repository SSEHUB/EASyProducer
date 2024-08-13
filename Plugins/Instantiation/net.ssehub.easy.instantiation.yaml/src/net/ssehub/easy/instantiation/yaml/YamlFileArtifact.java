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
public class YamlFileArtifact extends FileArtifact implements IStringValueProvider {

    private List<YamlNode> data = new ArrayList<>();
    
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
     */
    protected YamlFileArtifact(File file, ArtifactModel model) {
        super(file, model);
        try {
            Yaml yaml = new Yaml();
            File f = getPath().getAbsolutePath();
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(file);
                for (Object document : yaml.loadAll(fis)) {
                    data.add(new YamlNode(document));
                }
                fis.close();
            }
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(YamlFileArtifact.class, Bundle.ID).error(
                "While reading " + file + ": " + e.getMessage());
        }
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
        YamlNode current = new YamlNode();
        data.add(current);
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
        return node;
    }
    
    @Override
    public void store() throws VilException {
        super.store();
        try {
            File file = getPath().getAbsolutePath();
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            
            FormattingConfiguration cfg = Formatting.getFormattingConfiguration();
            DumperOptions options = new DumperOptions();
            FlowStyle style = FlowStyle.BLOCK;
            try {
                style = FlowStyle.valueOf(cfg.getProfileArgument("flowStyle", "BLOCK"));
            } catch (IllegalArgumentException e) {
                // take default
            }
            options.setDefaultFlowStyle(style);
            options.setIndent(cfg.getIndentSteps());
            options.setPrettyFlow(Boolean.valueOf(cfg.getProfileArgument("prettyFlow", "true")));
            
            Representer representer = new Representer(options);
            //representer.addClassTag(ClassMap.class, Tag.OMAP);
            
            Yaml yaml = new Yaml(representer, options);
            boolean first = true;
            for (YamlNode node : data) {
                if (!first) {
                    writer.append("--\n");
                }
                Map<String, Object> d = node.getData();
                if (!d.isEmpty()) {
                    yaml.dump(node.getData(), writer);
                }
                first = false;
            }
            writer.close();
        } catch (IOException e) {
            throw new VilException(e.getMessage(), e, VilException.ID_IO);
        }
    }
    
}
