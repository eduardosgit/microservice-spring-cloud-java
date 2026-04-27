package br.com.estudo.springservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "desc_name", nullable = false)
    private String name;

    @Column(name = "desc_email")
    private String email;

}
