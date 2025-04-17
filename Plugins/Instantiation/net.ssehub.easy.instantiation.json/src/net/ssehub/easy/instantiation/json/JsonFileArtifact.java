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

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.json.JsonNode.Sorting;

/**
 * Represents a JSON file artifact.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(JsonArtifactCreator.class)
public class JsonFileArtifact extends FileArtifact implements IStringValueProvider, INodeParent {

    private JsonNode data = new JsonNode(this);
    private boolean changedByNodes = false;
    
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
     * @see #initialize()
     */
    protected JsonFileArtifact(File file, ArtifactModel model) {
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
            if (f.exists()) {
                ObjectMapper mapper = new ObjectMapper();
                java.util.Map<?, ?> data = mapper.readValue(
                    FileUtils.readFileToByteArray(f), java.util.Map.class);
                this.data = new JsonNode(data, this);
            }
        } catch (Throwable e) { // if the format is broken/not really correct
            EASyLoggerFactory.INSTANCE.getLogger(JsonFileArtifact.class, Bundle.ID).warn(
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
     * Returns whether a field for {@code name} is known / was added before.
     * 
     * @param name the name of the field
     * @return {@code true} if the field exists, {@code false} else
     */
    public boolean has(String name) {
        return data.has(name);
    }

    /**
     * Adds a single value.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addValue(String name, Object value) {
        return data.addValue(name, value);
    }

    /**
     * Adds an object as sub-structure.
     * 
     * @param name the name of the field
     * @return the node representing the object
     */
    public JsonNode addObject(String name) {
        return data.addObject(name);
    }

    /**
     * Deletes a field and its value.
     * 
     * @param name the name of the field
     * @return <b>this</b> for chaining
     */
    public JsonNode delete(String name) {
        return data.delete(name);
    }

    /**
     * Adds a field with value list.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addList(String name, Sequence<?> value) {
        return data.addList(name, value);
    }

    /**
     * Adds the fields within the given map to this node.
     * 
     * @param value the map value(s)
     * @return <b>this</b> for chaining
     */
    public JsonNode addValues(Map<Object, Object> value) {
        return data.addValues(value);
    }
    
    /**
     * Adds a field with value map.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addMap(String name, Map<?, ?> value) {
        return data.addMap(name, value);
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
        if (changedByNodes) {
            try {
                File file = getPath().getAbsolutePath();
                file.getParentFile().mkdirs();
                
                IndentationConfiguration iCfg = Formatting.getIndentationConfiguration();
                FormattingConfiguration fCfg = Formatting.getFormattingConfiguration();
    
                ObjectMapper mapper = new ObjectMapper();
                Sorting sorting = Sorting.NONE;
                try {
                    sorting = Sorting.valueOf(fCfg.getProfileArgument("sorting", "NONE").toUpperCase());
                } catch (IllegalArgumentException e) {
                    // stay with NONE
                }
                ObjectWriter writer = mapper.writer();
                if (Boolean.valueOf(fCfg.getProfileArgument("prettyPrint", "true"))) {
                    int indent = 1;
                    if (fCfg.getIndentSteps() > 0) {
                        indent = fCfg.getIndentSteps();
                    } else if (iCfg.getIndentationStep() > 0) {
                        indent = iCfg.getIndentationStep();
                    }
                    String indentString = "";
                    for (int i = 1; i < indent; i++) {
                        indentString += " ";
                    }
                    
                    DefaultPrettyPrinter.Indenter indenter = 
                        new DefaultIndenter(indentString, DefaultIndenter.SYS_LF);
                    DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
                    printer.indentObjectsWith(indenter);
                    printer.indentArraysWith(indenter);
                    writer = mapper.writer(printer);
                }
                writer.writeValue(file, data.getData(sorting));
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
