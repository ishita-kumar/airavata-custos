/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.custos.security.manager;

import org.apache.custos.commons.exceptions.CustosSecurityException;
import org.apache.custos.security.model.AuthzToken;

import java.util.Map;

public interface CustosSecurityManager {
    /**
     * Implement this method in your SecurityManager to perform necessary initializations at the server startup.
     * @throws CustosSecurityException
     */
    public void initializeSecurityInfra() throws CustosSecurityException;

    /**
     * Implement this method with the user authentication/authorization logic in your SecurityManager.
     * @param authzToken : this includes OAuth token and user's claims
     * @param metaData : this includes other meta data needed for security enforcements.
     * @return
     * @throws CustosSecurityException
     */
    public boolean isUserAuthorized(AuthzToken authzToken, Map<String, String> metaData) throws CustosSecurityException;


    /**
     * Return an AuthzToken that has the appropriate access to manage user's in the IAM service.
     * @param gatewayId
     * @return
     * @throws CustosSecurityException
     */
    public AuthzToken getUserManagementServiceAccountAuthzToken(String gatewayId, String clientId, String clientSecret) throws CustosSecurityException;

    /**
     * Get OpenID Connect user profile information from the given AuthzToken.
     * @param authzToken
     * @return
     * @throws CustosSecurityException
     */
    public UserInfo getUserInfoFromAuthzToken(AuthzToken authzToken, String identityServerRealm) throws CustosSecurityException;
}
