package com.moda.ToNaModa.loginIdentidade;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Login")
@Table(name = "LoginList")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String email;

    private String senha;
}
