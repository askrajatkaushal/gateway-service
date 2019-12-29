package com.techolution.userauthservice.services;

import com.techolution.userauthservice.models.User;
import com.techolution.userauthservice.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public User getUserByUsername(String username) {
        return usersRepository.findByUsername(username).orElse(null);
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public User deleteUser(Integer id) {
        Optional<User> user = usersRepository.findById(id);

        user.ifPresent(u -> {
            u.setActive(false);
            usersRepository.save(u);
        });

        return user.orElse(null);
    }

}
