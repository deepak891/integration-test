/**
 * Copyright (c) 2015-2016 Bosch Software Innovations GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Bosch Software Innovations GmbH - Please refer to git log
 */

package org.eclipse.vorto.repository.v1;

import org.assertj.core.api.Assertions;
import org.eclipse.vorto.repository.AbstractRepositoryIntegrationTest;
import org.eclipse.vorto.repository.TestUtils;
import org.eclipse.vorto.repository.api.ModelId;
import org.eclipse.vorto.repository.api.ModelInfo;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class ModelIntegrationTest extends AbstractRepositoryIntegrationTest {

    ModelId testModelId;

    @Override
    public void beforeEach(){
        super.beforeEach();
        testModelId = TestUtils.loadTestModel();
    }

    @Test
    public void testGetModelById() {
        //given
        createModelInRepository(testModelId, "InformationModel");

        //when
        ResponseEntity<ModelInfo> responseEntity = fromRepositoryGetModelById(testModelId);

        //then
        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
