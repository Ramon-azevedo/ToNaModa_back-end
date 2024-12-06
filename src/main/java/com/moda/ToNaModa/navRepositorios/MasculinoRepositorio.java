package com.moda.ToNaModa.navRepositorios;

import com.moda.ToNaModa.navIdentidades.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface MasculinoRepositorio extends JpaRepository<Masculino,Long> {
    List<Masculino> findByNomeContainingIgnoreCase(String nome);

}
