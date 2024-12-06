package com.moda.ToNaModa.navRepositorios;

import com.moda.ToNaModa.navIdentidades.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface InfantilRepositorio extends JpaRepository<Infantil,Long> {
    List<Infantil> findByNomeContainingIgnoreCase(String nome);

}
