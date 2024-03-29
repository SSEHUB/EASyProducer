/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

package services;

import java.util.ArrayList;
import java.util.List;

import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;

import services.Item;

public class FruitsCatalogImpl implements Catalog {
    
    @Property
    public String currencyCode = "USD";
    
    @Reference
    public CurrencyConverter currencyConverter;
    
    private List<Item> catalog = new ArrayList<Item>();

    #if($graphic=="true")
    	@Init
    public void init() {
        String currencySymbol = currencyConverter.getCurrencySymbol(currencyCode);
        catalog.add(new Item("Apple",  currencySymbol + currencyConverter.getConversion("USD", currencyCode, 2.99),"apple"));
        catalog.add(new Item("Orange", currencySymbol + currencyConverter.getConversion("USD", currencyCode, 3.55),"orange"));
        catalog.add(new Item("Pear", currencySymbol + currencyConverter.getConversion("USD", currencyCode, 1.55),"pear"));
    }
    	
    	
    #else	
    @Init
    public void init() {
        String currencySymbol = currencyConverter.getCurrencySymbol(currencyCode);
        catalog.add(new Item("Apple",  currencySymbol + currencyConverter.getConversion("USD", currencyCode, 2.99)));
        catalog.add(new Item("Orange", currencySymbol + currencyConverter.getConversion("USD", currencyCode, 3.55)));
        catalog.add(new Item("Pear", currencySymbol + currencyConverter.getConversion("USD", currencyCode, 1.55)));
    }
    #end

    public Item[] get() {
        Item[] catalogArray = new Item[catalog.size()];
        catalog.toArray(catalogArray);
        return catalogArray;
    }
}
