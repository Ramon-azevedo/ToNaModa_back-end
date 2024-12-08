package com.moda.ToNaModa.segurança;

import com.moda.ToNaModa.loginIdentidade.*;
import com.moda.ToNaModa.loginRepositorio.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.web.filter.*;

import java.io.*;
import java.util.*;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginRepositorio loginRepositorio;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recuperarToken(request);
        var login = tokenService.validateToken(token);

        if (login != null) {
            Login login1 = loginRepositorio.findByEmail(login).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(login1,null,authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null ) return null;
        return authHeader.replace("Bearer ", "");
    }
}
