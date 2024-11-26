package com.moda.ToNaModa.identidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Feminino")
@Table(name = "FemininoItens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Feminino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imagem;
    private String nome;
    private double preco;
    private String vezesCartao;


}
