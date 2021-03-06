/*
 * Copyright 2015 Red Hat, Inc.
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
package org.jboss.migration.core;

/**
 * The product info that identifies a {@link Server}.
 * @author emmartins
 */
public class ProductInfo {
    private final String name;
    private final String version;

    public ProductInfo(String name, String version) {
        this.name = name;
        this.version = version;
    }

    /**
     * Retrieves the product's version.
     * @return the product's version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Retrieves the product's name.
     * @return the product's name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringBuilder("name: ").append(String.valueOf(name)).append(", version: ").append(String.valueOf(version)).toString();
    }
}
