/**
 * Contains the VIL artifact model. The classes in this package can be understood
 * as meta-classes of artifacts. Instances of these classes represent real artifacts.
 * Artifacts are {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType 
 * VIL types} in order to be available in the VIL editors. Currently, there are five
 * fundamental types: 
 * <ul>
 *   <li>{@link 
 *   de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path path expressions} for 
 *   denoting file system and language-specific paths.
 *   <li>{@link 
 *   de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.SimpleArtifact simple artifacts},
 *   which cannot be decomposed. Typically, generic folders and simple generic components shall be represented
 *   as simple artifacts. Some of those artifacts act as default representation through the 
 *   {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory}, i.e., 
 *   any real artifact which is not specified by a more specific artifact class is represented by those
 *   artifact types.</li>
 *   <li>{@link 
 *   de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact fragment artifacts},
 *   representing decomposed artifact fragments such as a Java method or a SQL statement.</li>
 *   <li>{@link 
 *   de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.CompositeArtifact composite artifacts},
 *   representing decomposable artifacts consisting of fragments. In case of resolution conflicts, composite 
 *   artifacts have more priority than simple artifacts, e.g., if there is a simple artifact and a composite
 *   artifact representation of Java source classes, the composite will be taken. However, if there are
 *   resolution conflicts in the same type of artifacts, e.g., multiple composite representations, then
 *   the first one loaded by Java will take precedence.</li>
 *  <li>The types in {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes} are most basic
 *  and enable building a bridge to the variability model with own VIL-specific operations.</li>
 * </ul>
 * Instances of all artifact types can be obtained from 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory}. This is in particular 
 * true for instances of the {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel} 
 * which provides an environment for instantiating artifacts, i.e., it manages created artifacts. While the
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory} may be used standalone,
 * the correct internal listener registration is done by 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel} so that model and 
 * artifacts are informed about changes and can be kept up to date, i.e., artifact instances shall be created using 
 * methods of {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel}. <br/>
 * 
 * Subclassing these artifact types (and registering them with the artifact factory through the Eclipse DS mechanism) 
 * transparently leads to more specific artifact types with more specific operations. Please note that even the simple
 * names of VilTypes and artifacts shall be unique (unless they shall override existing implementations) due to the 
 * transparent embedding into the VIL languages. Types must be registered in 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry}.<br/>
 * 
 * All operations marked by the annotation {@link 
 * de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible Invisible} will not be available
 * through the VIL languages. However, the (semantics of the) Invisible annotation may be inherited if required.
 * By convention, collections are returned in terms of type-parameterized
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set sets} or 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence sequences}. However,
 * an artifact method returning a collection must be annotated by 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta#returnGenerics()} in order
 * to defined the actual types used in the collection (this is not available via Java mechanisms). Further, operations 
 * and  classes may be marked by the following annotations:<li>
 * <ul> {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion Conversion} to indicate type 
 *      conversion operations considered for automatic type conversion when calling methods from a VIL expression. These
 *      methods must be static, take one parameter of the source type and return the target type.</ul>
 * <ul> {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta OperationMeta} for renaming
 *      operations (for operator implementations), determining their operator type or, as mentioned above, making the 
 *      type parameters of a generic return type explicit. Basically, all three information types are optional.</ul>
 * <ul> {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassMeta ClassMeta} for renaming the 
 *      annotated class, i.e., hiding the Java implementation name.</ul>
 * </li>
 * Collections may define generic iterator operations such as checking a condition or applying a 
 * transformation expression to each element. Therefore, a non-static operation on a collection receiving 
 * (at the moment exactly) one ExpressionEvaluator instance as parameter (possibly more parameters) will be
 * considered by VIL as an iterator operation. The ExpressionEvaluator will carry an iterator variable of the first 
 * parameter (element type) of the collection as well as an expression parameterized over that variable (i.e., it uses 
 * the [undbound] variable). The job of the respective collection operation is to apply the expression to each element 
 * in the collection, i.e., to bind the variable to each collection element (via the runtime variable of the temporarily
 * attached EvaluationVisitor in the ExpressionEvaluator), to call the respective evaluation operation of the 
 * ExpressionEvaluator and to handle the returned evaluation result appropriately.<br/>
 * Artifact or instantiator operations may cause VIL rules and templates to fail if they return a non-true result, 
 * i.e., an empty 
 * collection or <b>null</b>. However, in order to state explicitly that an operation cannot be executed, an operation 
 * shall throw an {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException}.<br/>
 * Basically, artifact or instantiator operations are identified by their name, the number, sequence and type of their 
 * parameter. However, some operations such as template processors may require an unlimited number of not previously
 * defined parameters. In this case, VIL allows to pass in named parameters. In the respective artifact or
 * instantiator operations, named parameters are represented by a <code>Map<String, Object></code> as last parameter 
 * which receives the names and the actual values of given named VIL parameters.
 * The interpretation of named parameters belongs to the respective method.<br>
 * Types implementing {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IActualTypeProvider} may
 * determine a more recent type during dynamic dispatch.
 */
package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;