package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.request.RegisterRequest;
import com.myfinances.apigateway.models.request.UserActiveRequest;
import com.myfinances.apigateway.models.request.UserInputRequest;
import com.myfinances.apigateway.models.request.UserUpdateRequest;
import com.myfinances.apigateway.models.response.UserBoardItemResponse;
import com.myfinances.apigateway.models.response.UserEditViewResponse;
import com.myfinances.apigateway.models.response.UserViewResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends CRUDService<User, Integer, UserInputRequest, UserUpdateRequest, UserViewResponse> {

    UserService(@Value("${users.service.baseUrl}") String baseUrl) {
        super(baseUrl, "users");
    }

    public Optional<User> findUserByUserName(String userName) {
        User result = restClient.get()
                .uri("/findUserByUserName/" + userName)
                .retrieve()
                .body(User.class);

        return result != null ? Optional.of(result) : Optional.empty();
    }

    public void register(RegisterRequest registerRequest) {
        restClient.post()
                .uri("/register")
                .body(registerRequest)
                .retrieve()
                .toBodilessEntity();
    }

    public List<UserBoardItemResponse> getBoard() {
        List<UserBoardItemResponse> result = restClient.get()
                .uri("/board")
                .retrieve()
                .body(List.class);

        return result;
    }

    public void setActive(UserActiveRequest request) {
        restClient.post()
                .uri("/set-active")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public UserEditViewResponse getEditUser(int userId) {
        UserEditViewResponse result = restClient.get()
                .uri("/get-edit/" + userId)
                .retrieve()
                .body(UserEditViewResponse.class);

        return result;
    }
}
