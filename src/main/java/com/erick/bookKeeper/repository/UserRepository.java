package com.erick.bookKeeper.repository;

import com.erick.bookKeeper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
