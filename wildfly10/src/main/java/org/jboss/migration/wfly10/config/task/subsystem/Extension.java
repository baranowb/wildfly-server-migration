/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.migration.wfly10.config.task.subsystem;

import org.jboss.migration.core.ServerMigrationTask;
import org.jboss.migration.core.ServerMigrationTaskContext;
import org.jboss.migration.wfly10.config.management.SubsystemsManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author emmartins
 */
public class Extension {

    private final String name;
    protected final List<WildFly10Subsystem> subsystems;

    public Extension(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        subsystems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<WildFly10Subsystem> getSubsystems() {
        return Collections.unmodifiableList(subsystems);
    }

    public void migrate(SubsystemsManagement subsystemsManagement, ServerMigrationTaskContext context) throws IOException {
        for (WildFly10Subsystem subsystem : subsystems) {
            ServerMigrationTask subsystemTask = subsystem.getServerMigrationTask(subsystemsManagement);
            if (subsystemTask != null) {
                context.execute(subsystemTask);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Extension that = (Extension) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
