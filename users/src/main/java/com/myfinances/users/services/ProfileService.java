package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.ChangePasswordUpdateDTO;
import com.myfinances.users.dtos.inputs.ProfileUpdateDTO;
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
                .fullName(user.getFullName())
                .build();
    }

    public void saveProfile(ProfileUpdateDTO profile) {
        User user = this.repo.findById(profile.getId()).get();
        this.repo.save(profile.toEntity(user));
    }

    public void changePassword(ChangePasswordUpdateDTO passwordModel) {
        User user = this.repo.findById(passwordModel.getId()).get();

        if (!passwordModel.getCurrentPassword().equals(user.getPassword())) {
            throw new RuntimeException("Current password does not match the user password!");
        }

        this.repo.save(passwordModel.toEntity(user));
    }
}
