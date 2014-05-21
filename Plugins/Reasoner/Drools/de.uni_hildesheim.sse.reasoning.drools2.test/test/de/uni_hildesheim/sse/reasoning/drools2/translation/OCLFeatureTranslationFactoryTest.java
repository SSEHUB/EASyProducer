package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls.OCLFeatureTranslationFactory;
import de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls.TranslationFragment;

/**
 * Tests the {@link OCLFeatureTranslationFactory}.
 * @author El-Sharkawy
 *
 */
public class OCLFeatureTranslationFactoryTest {

    /**
     * Tests whether for each Operation a {@link TranslationFragment} is defined inside the
     * {@link OCLFeatureTranslationFactory}.
     * @throws IllegalAccessException Should not occur (part of java.lang.reflect).
     * @throws IllegalArgumentException Should not occur (part of java.lang.reflect).
     */
    @Ignore("Not all Operations are translated, currently.")
    @Test
    public void testAllOperationsDefined() throws IllegalArgumentException, IllegalAccessException {
        Class<OCLFeatureTranslationFactory> factoryClass = OCLFeatureTranslationFactory.class;
        Field[] fields = factoryClass.getDeclaredFields();
        boolean mapFound = false;
        for (int i = 0; !mapFound && i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Object instance = field.get(null);
            if (instance instanceof Map<?, ?>) {
                mapFound = true;
                Map<?, ?> translationMap = (Map<?, ?>) instance;
                System.out.println(translationMap.size());
                Assert.assertEquals(Operation.getOperationsCount(), translationMap.size());
            }
        }
    }
}
