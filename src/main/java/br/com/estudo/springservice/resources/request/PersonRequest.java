package br.com.estudo.springservice.resources.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PersonRequest(
        @NotBlank String name,
        @Email(message = "Invalid email") @NotBlank String email
) {}
