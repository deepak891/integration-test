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
import org.eclipse.vorto.repository.api.ModelInfo;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application.properties")
public class AbstractRepositoryIntegrationTest {

    @Value("${repo.integration.test.url:/infomodelrepository/}")
    private String basePath;

    @Value("${repo.integration.test.port:8080}")
    private Integer port;

    @Value("${repo.integration.test.basePath:http://localhost:}")
    private String baseHost;

    @Value("${repo.integration.test.username:}")
    private String userName;

    @Value("${repo.integration.test.password:}")
    private String password;

    protected RestTemplate restTemplate;

    @Before
    public void beforeEach() {
        restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor(userName, password));
    }

    protected ResponseEntity<ModelInfo> createModelInRepository(ModelId modelId, String type) {
        return restTemplate.exchange(
                createBaseUrl()
                        + TestUtils.REST_MODEL_URL
                        + modelId.getPrettyFormat()
                        + TestUtils.BACK_SLASH
                        + type,
                HttpMethod.POST, null, ModelInfo.class);
    }

    protected  ResponseEntity<ModelInfo> fromRepositoryGetModelById(ModelId modelId) {
        return restTemplate.getForEntity(
                createBaseUrl()
                        + TestUtils.REST_API_MODELS
                        + modelId.getPrettyFormat(), ModelInfo.class);
    }

    protected String createBaseUrl(){
        return baseHost + port+ basePath;
    }


}
