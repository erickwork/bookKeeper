package com.erick.bookKeeper.book;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
@Entity(name = "Book")
@EqualsAndHashCode(of = "id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private GeneroLivro genre;
    private int availableCopies;

    public Book(CadastroBook cadastroBook) {
        this.title = cadastroBook.title();
        this.author = cadastroBook.author();
        this.genre = cadastroBook.genre();
        this.availableCopies = cadastroBook.availableCopies();
    }
}
