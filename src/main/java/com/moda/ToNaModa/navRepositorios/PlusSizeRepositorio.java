package com.moda.ToNaModa.navRepositorios;

import com.moda.ToNaModa.navIdentidades.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PlusSizeRepositorio extends JpaRepository<PlusSize,Long> {
    List<PlusSize> findByNomeContainingIgnoreCase(String nome);

}
