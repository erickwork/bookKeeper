package com.erick.bookKeeper.service;


import com.erick.bookKeeper.domain.Book;
import com.erick.bookKeeper.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public boolean isBookAvailable(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return book != null && book.getAvailableCopies() > 0;
    }

    public void rentBook(Long bookId){
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book != null){
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }

    public void devolutionBook(Long bookId){
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book != null){
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            bookRepository.save(book);
        }
    }

}
