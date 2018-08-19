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

package org.eclipse.vorto.repository;

import org.eclipse.vorto.repository.api.ModelId;

public class TestUtils {

    public static String REST_MODEL_URL = "rest/models/";

    public static String REST_API_MODELS = "api/v1/models/";

    public static String BACK_SLASH = "/";

    public static ModelId loadTestModel(){
        ModelId modelId = new ModelId("TestModel4", "test.model", "0.0.1");
        return modelId;
    }
}
