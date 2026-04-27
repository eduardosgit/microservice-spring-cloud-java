package br.com.estudo.springservice.resources.request;

import jakarta.validation.constraints.NotBlank;

public record PersonRequest(
        @NotBlank String name,
        @NotBlank String email
) {}
