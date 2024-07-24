package com.erick.bookKeeper.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroUser(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email) {
}
