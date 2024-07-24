package com.erick.bookKeeper.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroLoan(
        @NotNull
        long book,
        @NotNull
        long user,
        @NotNull
        LocalDate loanDate,

        @NotNull
        LocalDate dueDate,

        LocalDate returnDate) {
}
