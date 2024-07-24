package com.erick.bookKeeper.controller;

import com.erick.bookKeeper.dto.CadastroUser;
import com.erick.bookKeeper.domain.User;
import com.erick.bookKeeper.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid CadastroUser cadastroUser) {
        userRepository.save(new User(cadastroUser));
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{user}")
    public Optional<User> getUsers(@PathVariable Long user) {
        return userRepository.findById(user);
    }
}
