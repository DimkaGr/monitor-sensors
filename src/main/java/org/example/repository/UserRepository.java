package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link User} bean.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds {@link User} by the provided username.
     *
     * @param username - username to execute search by
     * @return {@link User}
     */
    User findByUsername(String username);
}
