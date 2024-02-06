package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.request.users.CreateEditUserRequest;
import com.myfinances.apigateway.models.request.users.RegisterRequest;
import com.myfinances.apigateway.models.request.users.UserActiveRequest;
import com.myfinances.apigateway.models.request.users.UserInputRequest;
import com.myfinances.apigateway.models.request.users.UserUpdateRequest;
import com.myfinances.apigateway.models.response.users.UserBoardItemResponse;
import com.myfinances.apigateway.models.response.users.UserEditViewResponse;
import com.myfinances.apigateway.models.response.users.UserViewResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends CRUDService<User, Integer, UserInputRequest, UserUpdateRequest, UserViewResponse> {

    public UserService(@Value("${users.service.baseUrl}") String baseUrl) {
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
        return restClient.get()
                .uri("/board")
                .retrieve()
                .body(List.class);
    }

    public void setActive(UserActiveRequest request) {
        restClient.post()
                .uri("/set-active")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public UserEditViewResponse getEditUser(int userId) {
        return restClient.get()
                .uri("/get-edit/" + userId)
                .retrieve()
                .body(UserEditViewResponse.class);
    }

    public void createEditUser(CreateEditUserRequest request) {
        restClient.post()
                .uri("/create-edit-user")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}
