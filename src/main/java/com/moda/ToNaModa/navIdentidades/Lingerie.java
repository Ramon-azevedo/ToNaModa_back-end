package com.moda.ToNaModa.navIdentidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Lingerie")
@Table(name = "LingerieItens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lingerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imagem;
    private String nome;
    private String preco;
    private String vezesCartao;


}


