package com.cognizant.junitspring.exercise6;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

}