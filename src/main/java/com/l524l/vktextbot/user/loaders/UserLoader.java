package com.l524l.vktextbot.user.loaders;

import com.l524l.vktextbot.user.User;

import java.util.Optional;

public interface UserLoader {
    Optional<User> loadUser(int id);
}
