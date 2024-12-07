package com.moda.ToNaModa.loginControll;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userLogin")
public class userLoginControll {
    @GetMapping()
    public ResponseEntity<String> getUserLogin() {
        return ResponseEntity.ok("Sucesso!");
    }
}
