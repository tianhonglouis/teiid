/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */
package org.teiid.jboss;

import org.jboss.msc.service.ServiceName;

public class TeiidServiceNames {
	private static ServiceName ENGINE = ServiceName.JBOSS.append("teiid", "query-engine"); //$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName TRANSLATOR_REPO = ServiceName.JBOSS.append("teiid", "translator-repository");//$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName VDB_REPO = ServiceName.JBOSS.append("teiid", "vdb-repository");//$NON-NLS-1$ //$NON-NLS-2$
	private static ServiceName TRANSLATOR_BASE = ServiceName.JBOSS.append("teiid", "translator");//$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName BUFFER_DIR = ServiceName.JBOSS.append("teiid", "buffer.dir");//$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName DATA_DIR = ServiceName.JBOSS.append("teiid", "data.dir");//$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName BUFFER_MGR = ServiceName.JBOSS.append("teiid", "buffer-mgr");//$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName SYSTEM_VDB = ServiceName.JBOSS.append("teiid", "system.vdb");//$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName AUTHORIZATION_VALIDATOR = ServiceName.JBOSS.append("teiid", "authorization-validator");//$NON-NLS-1$ //$NON-NLS-2$
	private static ServiceName VDB_SVC_BASE = ServiceName.JBOSS.append("teiid", "vdb"); //$NON-NLS-1$ //$NON-NLS-2$
	public static ServiceName OBJECT_SERIALIZER = ServiceName.JBOSS.append("teiid", "object-serializer"); //$NON-NLS-1$ //$NON-NLS-2$
	
	public static ServiceName translatorServiceName(String name) {
		return TRANSLATOR_BASE.append(name);
	}
	
	public static ServiceName engineServiceName(String name) {
		return ENGINE.append(name);
	}
	
	public static ServiceName vdbServiceName(String vdbName, int version) {
		return VDB_SVC_BASE.append(vdbName, ".", String.valueOf(version)); //$NON-NLS-1$
	}
	
	public static ServiceName executorServiceName(String poolName) {
		return ServiceName.JBOSS.append("thread", "executor", poolName);
	}
}
