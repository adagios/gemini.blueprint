/******************************************************************************
 * Copyright (c) 2006, 2010 VMware Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution. 
 * The Eclipse Public License is available at 
 * http://www.eclipse.org/legal/epl-v10.html and the Apache License v2.0
 * is available at http://www.opensource.org/licenses/apache2.0.php.
 * You may elect to redistribute this code under either of these licenses. 
 * 
 * Contributors:
 *   VMware Inc.
 *****************************************************************************/

package org.eclipse.gemini.blueprint.iandt.exportimport;

import java.util.List;

import org.eclipse.gemini.blueprint.iandt.BaseIntegrationTest;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * @author Costin Leau
 */
@ContextConfiguration (locations = {"classpath:org/eclipse/gemini/blueprint/iandt/exportimport/export-import.xml"})
public class ExportImportTest extends BaseIntegrationTest {

	@Test
	public void testCollectionSize() throws Exception {
		final List list = (List) applicationContext.getBean("list");
		assertEquals(2, list.size());
		assertEquals(2, Listener.bind);
	}

	@Test
	public void testExportNA() throws Exception {
		applicationContext.getBean("export-na");
		System.out.println(Listener.unbind);
		assertEquals(1, Listener.unbind);		
	}
}
