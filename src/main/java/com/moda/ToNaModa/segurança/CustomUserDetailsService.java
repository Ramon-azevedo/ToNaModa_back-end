package com.moda.ToNaModa.segurança;

import com.moda.ToNaModa.loginIdentidade.*;
import com.moda.ToNaModa.loginRepositorio.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;

import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginRepositorio loginRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = this.loginRepositorio.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new org.springframework.security.core.userdetails.User(login.getEmail(), login.getSenha(), new ArrayList<>());
    }
}
