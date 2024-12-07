package com.moda.ToNaModa.loginRepositorio;

import com.moda.ToNaModa.loginIdentidade.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface LoginRepositorio extends JpaRepository<Login,Long> {
    Optional<Login> findByEmail(String email);
}
