package com.l524l.vktextbot.user.loaders;

import com.l524l.vktextbot.database.UserRepository;
import com.l524l.vktextbot.user.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataBaseUserLoader implements UserLoader {

    private final UserRepository userRepository;

    public DataBaseUserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> loadUser(int id) {
        return userRepository.findById(id);
    }
}
