package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.User;
import com.jaystar.eatgo.domain.UserNotFoundException;
import com.jaystar.eatgo.domain.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return user;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                        .email(email)
                        .name(name)
                        .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        User user = getUser(id);

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deactiveUser(Long id) {
        User user = getUser(id);

        user.deactivate();

        return user;
    }
}
