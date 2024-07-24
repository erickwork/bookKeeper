package com.erick.bookKeeper.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;

public record DevolutionBook(
        @NotNull
        LocalDate returnDate,
        @NotNull
        BigInteger loan) {
}
