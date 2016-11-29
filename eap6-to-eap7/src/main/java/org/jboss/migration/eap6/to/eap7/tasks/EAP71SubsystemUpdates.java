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

package org.jboss.migration.eap6.to.eap7.tasks;

import org.jboss.migration.wfly10.config.task.subsystem.ExtensionNames;
import org.jboss.migration.wfly10.config.task.subsystem.SubsystemNames;
import org.jboss.migration.wfly10.config.task.subsystem.UpdateSubsystemTaskFactory;
import org.jboss.migration.wfly10.config.task.subsystem.infinispan.AddEjbCache;
import org.jboss.migration.wfly10.config.task.subsystem.infinispan.AddServerCache;
import org.jboss.migration.wfly10.config.task.subsystem.infinispan.FixHibernateCacheModuleName;
import org.jboss.migration.wfly10.config.task.subsystem.infinispan.UpdateWebCache;
import org.jboss.migration.wfly10.config.task.subsystem.undertow.AddBufferCache;
import org.jboss.migration.wfly10.config.task.subsystem.undertow.AddHttpsListener;
import org.jboss.migration.wfly10.config.task.subsystem.undertow.AddWebsockets;
import org.jboss.migration.wfly10.config.task.subsystem.undertow.EnableHttp2;
import org.jboss.migration.wfly10.config.task.subsystem.undertow.MigrateHttpListener;

/**
 * @author emmartins
 */
public class EAP71SubsystemUpdates {

    public static final UpdateSubsystemTaskFactory INFINISPAN = new UpdateSubsystemTaskFactory.Builder(SubsystemNames.INFINISPAN, ExtensionNames.INFINISPAN)
                                .subtasks(AddServerCache.INSTANCE, AddEjbCache.INSTANCE, FixHibernateCacheModuleName.INSTANCE, UpdateWebCache.INSTANCE)
                                .build();

    public static final UpdateSubsystemTaskFactory EE = EAP7SubsystemUpdates.EE;

    public static final UpdateSubsystemTaskFactory EJB3 = EAP7SubsystemUpdates.EJB3;

    public static final UpdateSubsystemTaskFactory REMOTING = EAP7SubsystemUpdates.REMOTING;

    public static final UpdateSubsystemTaskFactory UNDERTOW = new UpdateSubsystemTaskFactory.Builder(SubsystemNames.UNDERTOW, ExtensionNames.UNDERTOW)
            .subtasks(AddBufferCache.INSTANCE, MigrateHttpListener.INSTANCE, AddWebsockets.INSTANCE, AddHttpsListener.INSTANCE, EnableHttp2.INSTANCE)
            .build();

    public static final UpdateSubsystemTaskFactory MESSAGING_ACTIVEMQ = EAP7SubsystemUpdates.MESSAGING_ACTIVEMQ;

}
