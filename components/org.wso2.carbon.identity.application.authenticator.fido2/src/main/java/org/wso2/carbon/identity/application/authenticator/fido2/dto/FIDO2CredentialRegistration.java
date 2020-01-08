/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.application.authenticator.fido2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yubico.webauthn.RegisteredCredential;
import com.yubico.webauthn.attestation.Attestation;
import com.yubico.webauthn.data.UserIdentity;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.time.Instant;
import java.util.Optional;

/**
 * Wrapper for FIDO2 credentials.
 */
@Value
@Builder
@Wither
public class FIDO2CredentialRegistration {

    private long signatureCount;

    private UserIdentity userIdentity;
    private Optional<String> credentialNickname;

    @JsonIgnore
    private Instant registrationTime;
    private RegisteredCredential credential;

    private Optional<Attestation> attestationMetadata;

    private String displayName;
    private boolean isUsernamelessSupported;

    @JsonProperty("registrationTime")
    public String getRegistrationTimestamp() {
        return registrationTime.toString();
    }

    public String getDisplayName() {

        return displayName;
    }

    public boolean getIsUsernamelessSupported() {

        return isUsernamelessSupported;
    }
}
