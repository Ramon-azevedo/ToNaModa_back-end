package com.moda.ToNaModa.navRepositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moda.ToNaModa.navIdentidades.Feminino;

import java.util.*;

public interface FemininoRepositorio extends JpaRepository<Feminino,Long> {
    List<Feminino> findByNomeContainingIgnoreCase(String nome);
}
