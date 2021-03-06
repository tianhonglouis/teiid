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

package org.teiid.dqp.internal.datamgr;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.teiid.language.BatchedUpdates;
import org.teiid.language.Delete;
import org.teiid.language.Insert;
import org.teiid.language.Update;
import org.teiid.query.sql.lang.BatchedUpdateCommand;



/** 
 * @since 4.2
 */
@SuppressWarnings("nls")
public class TestBatchedUpdatesImpl {

    public static BatchedUpdateCommand helpExample() {
        List updates = new ArrayList();
        updates.add(TestInsertImpl.helpExample("a.b")); //$NON-NLS-1$
        updates.add(TestUpdateImpl.helpExample());
        updates.add(TestDeleteImpl.helpExample());
        return new BatchedUpdateCommand(updates);
    }
    
    public static BatchedUpdates example() throws Exception {
        return TstLanguageBridgeFactory.factory.translate(helpExample());
    }

    @Test
    public void testGetUpdateCommands() throws Exception {
        List updates = example().getUpdateCommands();
        assertEquals(3, updates.size());
        assertTrue(updates.get(0) instanceof Insert);
        assertTrue(updates.get(1) instanceof Update);
        assertTrue(updates.get(2) instanceof Delete);
    }
    
    @Test
    public void testToString() throws Exception {
        assertEquals("INSERT INTO b (e1, e2, e3, e4) VALUES (1, 2, 3, 4);\n"
                + "UPDATE g1 SET e1 = 1, e2 = 1, e3 = 1, e4 = 1 WHERE 1 = 1;\n"
                + "DELETE FROM g1 WHERE 100 >= 200 AND 500 < 600;", example().toString());
    }

}
