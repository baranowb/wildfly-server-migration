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

package org.jboss.migration.wfly10.config.task.update;

import org.jboss.migration.core.jboss.JBossServer;
import org.jboss.migration.core.ServerPath;
import org.jboss.migration.wfly10.config.management.HostConfiguration;
import org.jboss.migration.wfly10.config.task.HostMigration;
import org.jboss.migration.wfly10.config.task.factory.HostConfigurationTaskFactory;
import org.jboss.migration.wfly10.config.task.factory.ManageableServerConfigurationTaskFactory;

/**
 * @author emmartins
 */
public class HostUpdate<S extends JBossServer<S>> extends HostMigration<ServerPath<S>> {

    protected HostUpdate(HostMigration.Builder<ServerPath<S>> builder) {
        super(builder);
    }

    public static class Builder<S extends JBossServer<S>> extends HostMigration.Builder<ServerPath<S>> {

        @Override
        public Builder<S> subtask(HostConfigurationTaskFactory<ServerPath<S>> subtaskFactory) {
            super.subtask(subtaskFactory);
            return this;
        }

        @Override
        public Builder<S> subtask(ManageableServerConfigurationTaskFactory<ServerPath<S>, HostConfiguration> subtaskFactory) {
            super.subtask(subtaskFactory);
            return this;
        }

        @Override
        public HostUpdate<S> build() {
            return new HostUpdate<>(this);
        }
    }
}
