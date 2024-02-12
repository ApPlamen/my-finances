package com.myfinances.apigateway.services;

import com.myfinances.apigateway.helpers.SecurityContextHelper;
import com.myfinances.apigateway.models.internal.users.ChangePasswordInternalRequest;
import com.myfinances.apigateway.models.internal.users.ProfileInternalRequest;
import com.myfinances.apigateway.models.request.users.ChangePasswordRequest;
import com.myfinances.apigateway.models.request.users.ProfileRequest;
import com.myfinances.apigateway.models.response.users.ProfileResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProfileService {
    private final RestClient restClient;

    public ProfileService(@Value("${users.service.baseUrl}") String baseUrl) {
        restClient = RestClient.builder().baseUrl(baseUrl + "profile").build();
    }

    public ProfileResponse getProfile() {
        int userId = SecurityContextHelper.getUserId();

        return restClient.get()
                .uri("/" + userId)
                .retrieve()
                .body(ProfileResponse.class);
    }

    public void saveProfile(ProfileRequest profile) {
        int userId = SecurityContextHelper.getUserId();

        ProfileInternalRequest body = ProfileInternalRequest.builder()
                .id(userId)
                .fullName(profile.getFullName())
                .build();

        restClient.put()
                .uri("")
                .body(body)
                .retrieve()
                .toBodilessEntity();
    }

    public void changePassword(ChangePasswordRequest passwordModel) {
        int userId = SecurityContextHelper.getUserId();

        ChangePasswordInternalRequest body = ChangePasswordInternalRequest.builder()
                .id(userId)
                .currentPassword(passwordModel.getCurrentPassword())
                .newPassword(passwordModel.getNewPassword())
                .build();

        restClient.put()
                .uri("/change-password")
                .body(body)
                .retrieve()
                .toBodilessEntity();
    }
}
