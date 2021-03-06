/*
 * Copyright 2016 Red Hat, Inc.
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
package org.jboss.migration.wfly10;

import org.jboss.migration.core.Server;
import org.jboss.migration.core.ServerMigrationTaskContext;
import org.jboss.migration.core.ServerMigrationTaskResult;

/**
 * @author emmartins
 */
public interface WildFlyServerMigration10<S extends Server> {

    /**
     * Runs the server migration.
     * @param source
     * @param target
     * @param context
     * @return
     */
    ServerMigrationTaskResult run(S source, WildFlyServer10 target, ServerMigrationTaskContext context);
}
