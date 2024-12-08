package com.moda.ToNaModa.loginControll;

import com.moda.ToNaModa.dto.*;
import com.moda.ToNaModa.loginIdentidade.*;
import com.moda.ToNaModa.loginRepositorio.*;
import com.moda.ToNaModa.segurança.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginControll {

    @Autowired
    private LoginRepositorio loginRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO login) {
        Login user = this.loginRepositorio.findByEmail(login.email()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (passwordEncoder.matches(login.senha(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(token));
        }

        return ResponseEntity.badRequest().build();
    }






    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequestDTO login) {
        Optional<Login> user = this.loginRepositorio.findByEmail(login.email());

        if (user.isEmpty()) {
            Login newUser = new Login();
            newUser.setSenha(passwordEncoder.encode(login.senha()));
            newUser.setEmail(login.email());
            this.loginRepositorio.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(token));
        }

        return ResponseEntity.badRequest().build();
    }

}
