package com.erick.bookKeeper.controller;

import com.erick.bookKeeper.domain.Book;
import com.erick.bookKeeper.repository.BookRepository;
import com.erick.bookKeeper.dto.CadastroBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{book}")
    public Optional<Book> findAll(@PathVariable Long book) {
        return bookRepository.findById(book);
    }
}
