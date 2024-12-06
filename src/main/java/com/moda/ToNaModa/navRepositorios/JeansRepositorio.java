package com.moda.ToNaModa.navRepositorios;

import com.moda.ToNaModa.navIdentidades.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface JeansRepositorio extends JpaRepository<Jeans,Long> {
    List<Jeans> findByNomeContainingIgnoreCase(String nome);

}
