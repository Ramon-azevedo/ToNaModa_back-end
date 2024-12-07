package com.moda.ToNaModa.loginControll;

import com.moda.ToNaModa.loginIdentidade.*;
import com.moda.ToNaModa.loginRepositorio.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginControll {

    @Autowired
    private LoginRepositorio loginRepositorio;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Login login) {
        return null;
    }

}
