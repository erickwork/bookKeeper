package com.erick.bookKeeper.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroBook(
        @NotBlank(message = "Titulo obrigatório")
        String title,
        @NotBlank(message = "Autor obrigatório")
        String author,
        @NotNull(message = "Gênero obrigatório")
        GeneroLivro genre,
        @NotNull(message = "Copias disponíveis obrigatório")
        int availableCopies) {
}
