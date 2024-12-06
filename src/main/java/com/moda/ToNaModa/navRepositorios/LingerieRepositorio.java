package com.moda.ToNaModa.navRepositorios;

import com.moda.ToNaModa.navIdentidades.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface LingerieRepositorio extends JpaRepository<Lingerie,Long> {
    List<Lingerie> findByNomeContainingIgnoreCase(String nome);

}
