package com.moda.ToNaModa.navRepositorios;

import com.moda.ToNaModa.navIdentidades.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface OfertasRepositorio extends JpaRepository<Ofertas,Long> {
    List<Ofertas> findByNomeContainingIgnoreCase(String nome);

}
