package com.erick.bookKeeper.controller;

import com.erick.bookKeeper.dto.CadastroUser;
import com.erick.bookKeeper.domain.User;
import com.erick.bookKeeper.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
