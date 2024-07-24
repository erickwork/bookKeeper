package com.erick.bookKeeper.controller;

import com.erick.bookKeeper.book.Book;
import com.erick.bookKeeper.book.BookRepository;
import com.erick.bookKeeper.book.CadastroBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
