package org.example.service;

import org.example.model.User;

/**
 * Service for {@link User} bean.
 */
public interface UserService {
    /**
     * Finds {@link User} by the provided username.
     *
     * @param username - username to execute search by
     * @return {@link User}
     */
    User findByUsername(String username);
}
