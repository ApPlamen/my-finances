package com.myfinances.users.services;

import com.myfinances.users.dtos.views.RolesOptionViewDTO;
import com.myfinances.users.entities.Authority;
import com.myfinances.users.infrastructure.AuthorityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorityService {
    private final AuthorityRepo repo;

    public Optional<Authority> getAuthority(String name) {
        return this.repo.findByName(name);
    }

    public Authority getUserAuthority() {
        return this.getAuthority("ROLE_USER").get();
    }

    public List<RolesOptionViewDTO> getRolesOptions() {
        List<RolesOptionViewDTO> options = this.repo.findByNameStartingWith("ROLE_")
                .stream()
                .map(a -> RolesOptionViewDTO.builder()
                        .value(a.getId())
                        .displayValue(a.getName()
                                .replace("ROLE_", "")
                                .toLowerCase())
                        .build()
                ).collect(Collectors.toList());

        return options;
    }

    public List<Authority> findAllById(List<Integer> ids) {
        return this.repo.findAllById(ids);
    }
}
