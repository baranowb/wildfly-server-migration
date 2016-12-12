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

package org.jboss.migration.eap7.to.eap7;

import org.jboss.migration.eap.EAPServer7_1;
import org.jboss.migration.eap.EAPServerMigrationProvider7_1;
import org.jboss.migration.wfly10.WildFlyServerMigration10;
import org.jboss.migration.wfly10.config.task.update.MigrateCompatibleSecurityRealms;
import org.jboss.migration.wfly10.config.task.update.RemoveDeployments;
import org.jboss.migration.wfly10.config.task.update.ServerUpdate;

/**
 * Server migration, from EAP 7.1 to EAP 7.1.
 * @author emmartins
 */
public class EAP7_1ToEAP7_1ServerMigrationProvider implements EAPServerMigrationProvider7_1 {

    @Override
    public WildFlyServerMigration10 getServerMigration() {
        final ServerUpdate.Builders serverUpdateBuilders = new ServerUpdate.Builders();
        return serverUpdateBuilders.serverUpdateBuilder()
                .standaloneServer(serverUpdateBuilders.standaloneConfigurationBuilder()
                        .subtask(MigrateCompatibleSecurityRealms.INSTANCE)
                        .subtask(RemoveDeployments.INSTANCE)
                )
                .domain(serverUpdateBuilders.domainBuilder()
                        .domainConfigurations(serverUpdateBuilders.domainConfigurationBuilder()
                                .subtask(RemoveDeployments.INSTANCE)
                                .build()
                        )
                        .hostConfigurations(serverUpdateBuilders.hostConfigurationBuilder()
                                .subtask(serverUpdateBuilders.hostBuilder()
                                        .subtask(MigrateCompatibleSecurityRealms.INSTANCE)
                                        .build()
                                )
                        )
                )
                .build();
    }

    @Override
    public Class<EAPServer7_1> getSourceType() {
        return EAPServer7_1.class;
    }
}