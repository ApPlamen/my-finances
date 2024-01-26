package com.myfinances.users.services;

import com.myfinances.users.dtos.views.ProfileViewDTO;
import com.myfinances.users.entities.User;
import com.myfinances.users.infrastructure.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileService {
    private final UserRepo repo;

    public ProfileViewDTO getProfile(int userId) {
        Optional<User> result = repo.findById(userId);

        User user = result.orElseThrow(() -> new RuntimeException("No profile found"));

        return ProfileViewDTO.builder()
                .userName(user.getUserName())
                .build();
    }
}
