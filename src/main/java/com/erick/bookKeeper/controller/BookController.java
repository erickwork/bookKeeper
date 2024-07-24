package com.erick.bookKeeper.controller;

import com.erick.bookKeeper.domain.Book;
import com.erick.bookKeeper.repository.BookRepository;
import com.erick.bookKeeper.dto.CadastroBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    @Transactional
    public void addBook(@RequestBody @Valid CadastroBook cadastroBook) {
        bookRepository.save(new Book(cadastroBook));
    }
}
