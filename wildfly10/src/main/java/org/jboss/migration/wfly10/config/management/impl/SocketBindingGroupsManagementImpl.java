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

package org.jboss.migration.wfly10.config.management.impl;

import org.jboss.as.controller.PathAddress;
import org.jboss.migration.wfly10.config.management.ManageableServerConfiguration;
import org.jboss.migration.wfly10.config.management.SocketBindingGroupManagement;
import org.jboss.migration.wfly10.config.management.SocketBindingGroupsManagement;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.SOCKET_BINDING_GROUP;

/**
 * @author emmartins
 */
public class SocketBindingGroupsManagementImpl extends ResourcesManagementImpl implements SocketBindingGroupsManagement {

    public SocketBindingGroupsManagementImpl(PathAddress parentPathAddress, ManageableServerConfiguration configurationManagement) {
        super(SOCKET_BINDING_GROUP, parentPathAddress, configurationManagement);
    }

    @Override
    public SocketBindingGroupManagement getSocketBindingGroupManagement(String socketBindingGroupName) {
        return new SocketBindingGroupManagementImpl(socketBindingGroupName, getParentPathAddress(), getServerConfiguration());
    }
}