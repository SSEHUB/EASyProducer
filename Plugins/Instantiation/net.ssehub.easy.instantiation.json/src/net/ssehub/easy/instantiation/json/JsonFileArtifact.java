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
package net.ssehub.easy.instantiation.json;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
 * Represents a JSON file artifact.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(JsonArtifactCreator.class)
public class JsonFileArtifact extends FileArtifact implements IStringValueProvider {

    private JsonNode data = new JsonNode();
    
    /**
     * Creates an instance without file backing.
     */
    public JsonFileArtifact() {
        super();
    }
    
    /**
     * Creates an instance for a given file/artifact model.
     * 
     * @param file the file
     * @param model the artifact model instance
     */
    protected JsonFileArtifact(File file, ArtifactModel model) {
        super(file, model);
        try {
            File f = getPath().getAbsolutePath();
            if (f.exists()) {
                ObjectMapper mapper = new ObjectMapper();
                Map<?, ?> data = mapper.readValue(f, Map.class);
                this.data = new JsonNode(data);
            }
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(JsonFileArtifact.class, Bundle.ID).error(
                "While reading " + file + ": " + e.getMessage());
        }
    }

    /**
     * Creates an instance (VIL constructor).
     * 
     * @return the instance
     */
    public static JsonFileArtifact create() {
        return new JsonFileArtifact();
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
        return ArtifactFactory.createArtifact(JsonFileArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static JsonFileArtifact convert(IFileSystemArtifact val) {
        JsonFileArtifact convertedValue = null;
        if (val instanceof JsonFileArtifact) {
            convertedValue = (JsonFileArtifact) val;
        } else if (val instanceof FileArtifact) {
            FileArtifact fa = (FileArtifact) val;
            try {
                convertedValue = ArtifactFactory.createArtifact(
                    JsonFileArtifact.class, fa.getPath().getAbsolutePath(), null);
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(JsonFileArtifact.class, Bundle.ID).error(e.getMessage());
            }
        }
        return convertedValue;
    }    
    
    /**
     * Returns the JSON node represented by this artifact.
     * 
     * @return the node
     */
    public JsonNode getData() {
        return data;
    }
    
    @Override
    public void store() throws VilException {
        super.store();
        try {
            File file = getPath().getAbsolutePath();
            file.getParentFile().mkdirs();
            
            FormattingConfiguration cfg = Formatting.getFormattingConfiguration();

            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer();
            if (Boolean.valueOf(cfg.getProfileArgument("prettyPrint", "true"))) {
                writer = mapper.writerWithDefaultPrettyPrinter();
            }
            writer.writeValue(file, data.getData());
        } catch (IOException e) {
            throw new VilException(e.getMessage(), e, VilException.ID_IO);
        }
    }
    

}
