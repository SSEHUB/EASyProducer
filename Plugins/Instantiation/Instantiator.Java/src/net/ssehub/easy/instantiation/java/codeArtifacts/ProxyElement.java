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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Pretends to be {@code delegate} while collecting and preserving the sequence along with
 * elements before. Used for stable sorting.
 */
class ProxyElement implements IJavaCodeElement {
    
    private List<IJavaCodeElement> before;
    private IJavaCodeElement delegate;
    
    ProxyElement() {
    }
    
    ProxyElement(IJavaCodeElement delegate) {
        this.delegate = delegate;
    }
    
    void setDelegate(IJavaCodeElement delegate) {
        this.delegate = delegate;
    }
    
    void addBefore(IJavaCodeElement element) {
        if (null == before) {
            before = new ArrayList<>();
        }
        before.add(element);
    }
    
    @Invisible
    public void addAll(List<IJavaCodeElement> list) {
        if (null != before) {
            list.addAll(before);
        }
        list.add(delegate);
    }
    
    @Override
    public void store(CodeWriter out) {
        if (null != before) {
            for (IJavaCodeElement e: before) {
                e.store(out);
            }
        }
        delegate.store(out);
        
    }

    @Override
    public IJavaCodeArtifact getArtifact() {
        return delegate.getArtifact();
    }

    @Override
    public IJavaCodeElement getParent() {
        return delegate.getParent();
    }

    @Override
    public void setParent(IJavaCodeElement parent) {
        delegate.setParent(parent);
    }

    @Override
    @Invisible
    public boolean hasJavadocComment() {
        return delegate.hasJavadocComment();
    }
    
    @Override
    @Invisible
    public boolean isAttribute() {
        return delegate.isAttribute();
    }
    
    @Override
    @Invisible
    public boolean isConstructor() {
        return delegate.isConstructor();
    }

    @Override
    @Invisible
    public boolean isMethod() {
        return delegate.isMethod();
    }
    
    @Invisible()
    @Override
    public String getSortKey() {
        return delegate.getSortKey();
    }
    
    /**
     * Groups subsequent (proxy) elements to {@code list}.
     * 
     * @param list the list to proxy
     * @return the proxied elements
     */
    public static List<IJavaCodeElement> proxy(List<IJavaCodeElement> list) {
        List<IJavaCodeElement> result = new ArrayList<>();
        ProxyElement last = null;
        for (IJavaCodeElement e : list) {
            if (null == last) {
                last = new ProxyElement();
            }
            if (e.isAttribute() || e.isConstructor() || e.isMethod() || e.isInitializer()) {
                if (last.delegate == null) {
                    last.delegate = e;
                } else {
                    result.add(last);
                    last = new ProxyElement(e);
                }
            } else {
                last.addBefore(e);
            }
        }
        if (null != last) {
            result.add(last);
        }
        return result;
    }
    
    /**
     * Unproxies (proxy) elements in {@code list}.
     * 
     * @param list the list to unproxy
     * @return the unproxied elements
     */
    public static List<IJavaCodeElement> unproxy(List<IJavaCodeElement> list) {
        List<IJavaCodeElement> result = new ArrayList<>();
        for (IJavaCodeElement e : list) {
            e.addAll(result);
        }
        return result;
    }
    
}
