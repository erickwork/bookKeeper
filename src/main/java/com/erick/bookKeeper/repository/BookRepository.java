package com.erick.bookKeeper.repository;

import com.erick.bookKeeper.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
