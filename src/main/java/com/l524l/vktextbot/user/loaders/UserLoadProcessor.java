package com.l524l.vktextbot.user.loaders;

import com.l524l.vktextbot.exсeptions.UserLoadingException;
import com.l524l.vktextbot.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserLoadProcessor {

    private List<UserLoader> loaders;

    public UserLoadProcessor() {
        this.loaders = new ArrayList<>();
    }

    public User loadUser(int id) throws UserLoadingException {

        if (loaders == null || loaders.isEmpty())
            throw new UserLoadingException("Loaders list is empty");

        Optional<User> userOptional = Optional.empty();

        for (UserLoader loader: loaders) {

            userOptional = loader.loadUser(id);

            if (userOptional.isPresent()) break;
        }

        return userOptional.orElseThrow(UserLoadingException::new);
    }

    public void setLoaders(List<UserLoader> loaders) {
        this.loaders = loaders;
    }

    public void addLoader(UserLoader userLoader) {
        loaders.add(userLoader);
    }

}
