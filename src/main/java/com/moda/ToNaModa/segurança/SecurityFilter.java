package com.moda.ToNaModa.segurança;

import com.moda.ToNaModa.loginIdentidade.*;
import com.moda.ToNaModa.loginRepositorio.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.filter.*;

import java.io.*;

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
            Login login = loginRepositorio.findByEmail()
        }
    }

    private String recuperarToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null ) return null;
        return authHeader.replace("Bearer ", "");
    }
}
