package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/masculino")
@CrossOrigin(origins = "*")
public class MasculinoControll {

    @Autowired MasculinoRepositorio masculinoRepositorio;


    @GetMapping("/getMasculino")
    public ResponseEntity<?> getMasculino() {
        return ResponseEntity.ok(masculinoRepositorio.findAll());
    }

    @PostMapping("/postMasculino")
    public ResponseEntity<?> postMasculino(@RequestBody Masculino masculino) {
        return ResponseEntity.ok(masculinoRepositorio.save(masculino));
    }

    @PutMapping("/putMasculino/{id}")
    public ResponseEntity<?> putMasculino(@PathVariable Long id , @RequestBody Masculino masculino) {
        if (masculinoRepositorio.existsById(id)) {
            masculino.setId(id);
            return ResponseEntity.ok(masculinoRepositorio.save(masculino));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteMasculino/{id}")
    public ResponseEntity<?> deleteMasculino(@PathVariable Long id) {
        if (masculinoRepositorio.existsById(id)) {
            masculinoRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}

